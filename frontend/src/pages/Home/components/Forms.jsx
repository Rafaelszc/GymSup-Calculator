import { History } from "./History"

export const Forms = () => {
    const personMetrics = [
        {metric: "Height", type: "number", placeholder: "cm"},
        {metric: "Weight", type: "number", placeholder: "kg"},
        {metric: "Age", type: "number", placeholder: ""},
        {metric: "Diet", type: "radio", values: ["Bulking", "Cutting", "Default", "Low Carb"]},
        {metric: "Routine", type: "radio", values: ["Sedentary", "Light", "Moderate", "Intense"]}

    ]

    const renderMetricsForms = (o, i) => {
        if (o.type === "radio") {
            return (
                <div key={i} className="flex gap-4 w-1/2">
                    {o.metric}:
                    <div className="grid grid-flow-row grid-cols-2 gap-4">
                        {o.values.map((v, i) => (
                            <div key={i} className="flex gap-1 border-b-2 w-fit transform transition-colors duration-200 hover:border-blue-500">
                                <label htmlFor={v.toLowerCase()} className="select-none cursor-pointer">{v}</label>
                                <input className="cursor-pointer" type="radio" name={o.metric} id={v.toLowerCase()} />
                            </div>
                        ))}
                    </div>
                </div>
            )
        }

        return (
        <div key={i} className="border-b-2 border-gray-200 flex gap-1 transform transition-colors duration-200 hover:border-blue-500 has-[input:focus-within]:border-blue-500 has-[input:invalid]:border-pink-600 w-1/2">
            <label htmlFor={o.metric.toLowerCase()} className="select-none cursor-pointer">{o.metric}:</label>
            <input className="outline-none arrow w-full" placeholder={o.placeholder} type={o.type} name={o.metric.toLowerCase()} id={o.metric.toLowerCase()} />
        </div>)
    }

    return (
        <div className="flex-grow m-8">
            <div className="flex items-center justify-between h-full gap-8">
                <div className="w-full border rounded-lg shadow-xl h-full">
                    <form className="flex flex-col items-center justify-center h-full gap-8">
                        {personMetrics.map((o, i) => (renderMetricsForms(o, i)))}
                        <button type="button" className="bg-blue-600 rounded-md w-1/4 h-10 text-white font-bold text-xl transition-colors transform duration-300 hover:bg-blue-500">Calculate</button>
                    </form>
                </div>
                <History />
            </div>
        </div>
    )
}
