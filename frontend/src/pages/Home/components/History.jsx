import { useState } from "react"

export const History = () => {
    return (
        <div className="flex justify-center items-center flex-col rounded-lg border shadow-xl h-full transition-all duration-500 ease-in-out transform w-full">
            <div className="relative flex justify-center items-center h-44">
                <span className={`absolute h-44 w-44 rounded-full transform transition-colors duration-500 bg-gray-400`}></span>
                <span className={`z-10 text-5xl font-bold transform transition-colors duration-500 text-gray-400`}>--</span>
                <span className="absolute h-40 w-40 rounded-full bg-white"></span>
            </div>
        </div>
    )
}