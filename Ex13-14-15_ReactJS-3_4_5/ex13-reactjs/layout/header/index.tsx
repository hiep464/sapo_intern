import LogOut from '@/components/Logout';
import Link from 'next/link';
import { useRouter } from 'next/router';

function Header() {
    const router = useRouter();
    // console.log(router.pathname.includes("categorylist"))
    const isCategory = router.pathname.includes('categorylist');
    const isDashboard = router.pathname.includes('dashboard');
    // console.log(isCategory);

    return (
        <header className="header">
            <div className="header-wrapper">
                <div className="header-left">
                    <Link href={'/dashboard'}>
                        {isDashboard ? (
                            <button className="item text-blue-400 font-semibold active">Dashboard</button>
                        ) : (
                            <button className="item text-blue-400 font-semibold">Dashboard</button>
                        )}
                    </Link>
                    <Link href={'/categorylist'}>
                        {isCategory ? (
                            <button className="item text-blue-400 font-semibold active">Category</button>
                        ) : (
                            <button className="item text-blue-400 font-semibold">Category</button>
                        )}
                    </Link>
                </div>
                <div className="flex items-center justify-center">
                    <LogOut />
                </div>
            </div>
        </header>
    );
}

export default Header;
