import NumberFlow from "@number-flow/react"
import axios from "axios"
import { useEffect, useState } from "react"
import { useForm } from "react-hook-form"
import { z } from "zod"
import { zodResolver } from "@hookform/resolvers/zod"
import { Swiper,SwiperSlide } from "swiper/react"
import { Navigation, Pagination } from "swiper/modules"

const personSchema = z.object({
    height: z.number().min(100).max(250),
    weight: z.number().min(10).max(250),
    age: z.number().min(1).max(120),
    sex: z.enum(["MALE", "FEMALE"]),
    diet: z.enum(["BULKING", "CUTTING", "DEFAULT", "LOW_CARB"]),
    routine: z.enum(["SEDENTARY", "LIGHT", "MODERATE", "INTENSE"])
})

export const Forms = () => {
    const personMetrics = [
        {metric: "Height", type: "number", placeholder: "cm"},
        {metric: "Weight", type: "number", placeholder: "kg"},
        {metric: "Age", type: "number", placeholder: ""},
        {metric: "Sex", type: "radio", values: ["Male", "Female"]},
        {metric: "Diet", type: "radio", values: ["Bulking", "Cutting", "Default", "Low Carb"]},
        {metric: "Routine", type: "radio", values: ["Sedentary", "Light", "Moderate", "Intense"]}
    ]
    const { register, handleSubmit, reset } = useForm({resolver: zodResolver(personSchema)})
    
    const [data, setData] = useState([{
        calories: 0,
        carbo: 0,
        proteins: 0,
        fat: 0,
        total: 0
    }])

    const [refresh, setRefresh] = useState(0)

    const onSubmit = async (fromData) => {
        try {
            const res = await axios.post(
            "http://localhost:8080/api/save",
            fromData)
            setRefresh(refresh => refresh + 1)
            reset()
            console.log(fromData)
        } catch (err) {
            console.error(err)
        }

        reset()
    }

    const renderMetricsForms = (o, i) => {
        if (o.type === "radio") {
            return (
                <div key={i} className="flex gap-4 w-1/2">
                    {o.metric}:
                    <div className="grid grid-flow-row grid-cols-2 gap-4">
                        {o.values.map((v, i) => (
                            <div key={i} className="flex gap-1 border-b-2 w-fit transform transition-colors duration-200 hover:border-blue-500">
                                <label htmlFor={v.toLowerCase()} className="select-none cursor-pointer">{v}</label>
                                <input className="cursor-pointer" type="radio" id={v.toLowerCase()}  {...register(o.metric.toLowerCase())} value={v.toUpperCase().replace(" ", "_")}/>
                            </div>
                        ))}
                    </div>
                </div>
            )
        }
        
        return (
        <div key={i} className="border-b-2 border-gray-200 flex gap-1 transform transition-colors duration-200 hover:border-blue-500 has-[input:focus-within]:border-blue-500 has-[input:invalid]:border-pink-600 w-1/2">
            <label htmlFor={o.metric.toLowerCase()} className="select-none cursor-pointer">{o.metric}:</label>
            <input className="outline-none arrow w-full" placeholder={o.placeholder} type={o.type} id={o.metric.toLowerCase()} {...register(o.metric.toLowerCase(), {valueAsNumber: o.type === "number" ? true : false})} />
        </div>)
    }

    const history = (o, i) => {
        return (
            <SwiperSlide key={i}>
                <div className="h-full flex flex-col justify-center items-center gap-8 relative">
                    <div className="relative flex justify-center items-center h-44">
                        <span className={`absolute h-44 w-44 rounded-full transform transition-colors duration-500 ${(o.calories == 0 ? 'bg-gray-400' : 'bg-blue-500')}`}></span>
                        <span className={`z-10 text-2xl transform transition-colors duration-500 text-gray-black font-semibold ${(o.calories === 0 ? 'text-gray-400' : 'text-black')}`}><NumberFlow value={o?.calories} /> Cal</span>
                        <span className="absolute h-40 w-40 rounded-full bg-white"></span>
                    </div>
                    <div className="w-1/2 font-semibold text-xl flex flex-col gap-2">
                        <span>🍫 Carbohydrate: <NumberFlow value={o?.carbo} /> g</span>
                        <div className="w-full h-3 rounded-md bg-gray-400 relative overflow-hidden">
                            <span className="h-full absolute" style={{width: `${o.total > 0  ? (o?.carbo/o.total)*100 : 0}%`, transition: "width 0.5s ease", backgroundColor: "#745045"}} />
                        </div>
                        <span>🥩 Proteins: <NumberFlow value={o?.proteins} /> g</span>
                        <div className="w-full h-3 rounded-md bg-gray-400 relative overflow-hidden">
                            <span className="h-full absolute" style={{width: `${o.total > 0? (o?.proteins/o.total)*100 : 0}%`, transition: "width 0.5s ease", backgroundColor: "#dc0d28"}} />
                        </div>
                        <span>🧀 Fat: <NumberFlow value={o?.fat} /> g</span>
                        <div className="w-full h-3 rounded-md bg-gray-400 relative overflow-hidden">
                            <span className="h-full bg-blue-500 absolute" style={{width: `${o.total > 0 ? (o.fat/o.total)*100 : 0}%`, transition: "width 0.5s ease", backgroundColor: "#f9a10e"}} />
                        </div>
                    </div>
                </div>
            </SwiperSlide>
        )
    }


    useEffect(() => {
        const fetchData = async () => {
            const res = await axios.get("http://localhost:8080/api/get")
            if (res.data.length === 0) return
            
            setData(res.data)
        }

        fetchData()
    }, [refresh])

    return (
        <div className="flex-grow m-8">
            <div className="flex items-center justify-between h-full w-full gap-8">
                <div className=" border rounded-lg shadow-xl h-full w-full">
                    <form className="flex flex-col items-center justify-center h-full gap-8" action={handleSubmit(onSubmit)}>
                        {personMetrics.map((o, i) => (renderMetricsForms(o, i)))}
                        <button type="submit" className="bg-blue-600 rounded-md w-1/4 h-10 text-white font-bold text-xl transition-colors transform duration-300 hover:bg-blue-500">Calculate</button>
                    </form>
                </div>
                    <Swiper
                    className="rounded-lg border shadow-xl w-full h-full flex"
                    modules={[Navigation, Pagination]}
                    slidesPerView={1}
                    pagination={{ clickable: true }}
                    navigation={true}
                    allowTouchMove={true}>
                        {data.map((o, i) => (history(o, i)))}
                    </Swiper>

            </div>
        </div>
    )
}
