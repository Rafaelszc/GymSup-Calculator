import { Header } from './components/Header';
import { Forms } from './components/Forms';

export const Home = () => {
    return (
        <div className='flex flex-col h-screen'>
            <Header />
            <Forms />
        </div>
    )
}