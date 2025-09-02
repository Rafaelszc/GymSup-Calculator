import { Link } from "react-router-dom"

export const Header = () => {
    return (
        <header className="h-20 shadow-sm flex items-center justify-between pr-14 pl-14 z-0">
            <div>
                <span className="text-2xl font-bold"><Link to="/">GymSup 🍎</Link></span>
            </div>
        </header>
    )
}