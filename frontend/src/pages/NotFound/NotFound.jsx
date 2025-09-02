import { Header } from "../Home/components/Header"

export const NotFound = () => {
    return (
        <div className="h-screen flex flex-col">
            <Header />
            <div className="flex flex-grow items-center ml-20">
                <span className="text-2xl">Error 404 Page not found :((</span>
            </div>
        </div>

    )
}