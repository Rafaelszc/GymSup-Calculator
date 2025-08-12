import { useEffect, useState } from "react"

export const Forms = () => {
    const [isVisible, setIsVisible] = useState(false)
    const [lastDiet, setLastDiet] = useState(0)

    useEffect(() => {
        setIsVisible(lastDiet != 0)
    })

    return (
        <div className="flex items-center justify-between m-8 gap-8 h-md-section">
            <div className="w-full border rounded-lg shadow-xl h-full">
                <form>
                    <button type="button" onClick={() => (setLastDiet("test"))}>test</button>
                </form>
            </div>
            <div className={`rounded-lg border shadow-xl h-md-section transition-all duration-500 ease-in-out transform ${isVisible ? "w-full" : "w-0 overflow-hidden absolute opacity-0"}`}>
                {lastDiet}
            </div>
        </div>
    )
}
