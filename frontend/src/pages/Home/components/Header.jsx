import { Link } from "react-router-dom"

export const Header = () => {
    const naviagation = [
        {name: "Home", link: "#home"},
        {name: "History", link: "#history"}
    ]

    return (
        <header className="h-20 shadow-sm flex items-center justify-between pr-14 pl-14">
            <div>
                <span className="text-2xl font-bold"><Link to={'/'}>GymSup 🍎</Link></span>
            </div>
            <nav>
                <ul className="flex gap-8 list-none">
                    {naviagation.map((nav, i) => (
                        <li key={i} className="border-b-2 border-white transition transform duration-175 ease-linear hover:border-blue-500 ">
                            <a href={nav.link}>{nav.name}</a>
                        </li>
                    ))}
                </ul>

            </nav>
        </header>
    )
}