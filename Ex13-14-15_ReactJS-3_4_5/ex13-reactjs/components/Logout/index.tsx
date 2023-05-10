import { useRouter } from 'next/router';
import { useLogout } from '../../apiHandle/useAuth';

function LogOut() {
    const router = useRouter();

    const { mutate: logout } = useLogout();

    const handleLogout = () => {
        logout();
        router.push('/');
    };

    return (
        <button className="text-red-600" onClick={handleLogout}>
            Logout
        </button>
    );
}

export default LogOut;
