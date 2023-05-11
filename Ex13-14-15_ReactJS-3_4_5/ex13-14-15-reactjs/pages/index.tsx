import { useState } from 'react';
import { useRouter } from 'next/router';
import Head from 'next/head';
import { useLogin } from '../apiHandle/useAuth';
import ReactLoading from 'react-loading';

export default function Login() {
    const [email, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState(false);
    const [loading, setLoading] = useState(false);

    const router = useRouter();

    const handleMutationEvent = {
        onSuccess: () => {
            router.push('/dashboard');
            setLoading(false);
        },
        onError: () => {
            setError(true);
            setLoading(false);
        },
    };

    const { mutate: login }: any = useLogin(handleMutationEvent);

    const handleSubmit = () => {
        setLoading(true);
        setTimeout(() => {
            login({ email, password });
        }, 1000)
    };

    return (
        <>
            <Head>
                <title>Login</title>
            </Head>
            {loading ? (
                <div className="fixed inset-0 flex items-center justify-center">
                    <ReactLoading type={'spinningBubbles'} color={'#0288d1'} />
                </div>
            ) : (
                ''
            )}
            <div className="container w-screen bg-gray-400 h-screen flex justify-center items-center">
                <div className="w-20 flex justify-center items-center flex-col">
                    <span className="font-semibold text-3xl mb-2 text-red-600">Login</span>
                    <div className='mt-3'>
                        <span>UserName: </span>
                        <input
                            type="text"
                            className="rounded-sm p-1 my-1"
                            onChange={(e) => {
                                setUsername(e.target.value);
                            }}
                        />
                    </div>
                    <div className='mt-3'>
                        <span>Password: </span>
                        <input
                            type="password"
                            className="rounded-sm p-1 my-1"
                            onChange={(e) => {
                                setPassword(e.target.value);
                            }}
                        />
                    </div>
                    {error ? <span className="text-red-600 text-xs w-44">username/password không đúng</span> : ''}
                    <button className="bg-blue-500 mt-4 px-2 py-1 px-3 rounded-sm text-white btn-submit" onClick={handleSubmit}>
                        Submit
                    </button>
                </div>
            </div>
        </>
    );
}
