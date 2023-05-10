import Link from 'next/link';
import { useDeleteCategory } from '../../apiHandle/useCategory';
import { useRouter } from 'next/router';
import { useState } from 'react';

function Categoryitem(data: any) {
    // const [sucess, setSucess] = useState(false);
    const [auth, setAuth] = useState(false);

    const { id, categoryCode, categoryName } = data.data;

    const router = useRouter();

    const handleMutationEvent = {
        onSuccess: () => {
            // setSucess(true);
            alert('sucess');

            // setTimeout(() => {
            //     setSucess(false);
            // }, 2000);
        },
        onError: (err: any) => {
            const httpStatus = err.response.status;
            if (httpStatus === 403) {
                // alert("phiên đăng nhập hết hạn")
                setAuth(true);
                // router.push('/');
            } else alert('error');
        },
    };

    const { mutate: remove } = useDeleteCategory(handleMutationEvent);

    const handleDelete = () => {
        remove(id);
    };

    return (
        <>
            {auth ? (
                <div className="fixed inset-0 flex items-center justify-center">
                <div className="w-60 h-28 bg-yellow-200 flex items-center justify-center flex-col rounded">
                    <span className='text-xl font-semibold text-yellow-500'>Phiên đăng nhập hết hạn</span>
                    <button
                        className='bg-blue-500 mt-4 px-2 py-1 px-3 rounded-sm text-white btn-submit'
                        onClick={() => {
                            router.push('/');
                        }}
                    >
                        Login
                    </button>
                </div>
            </div>
            ) : (
                ''
            )}
            <div className="w-4/5 flex text-center border-b my-2 py-2">
                <div className="w-1/5">
                    <span>{id}</span>
                </div>
                <div className="w-1/5">
                    <span>{categoryCode}</span>
                </div>
                <div className="w-1/5">
                    <span>{categoryName}</span>
                </div>
                <div className="w-1/5">
                    <Link href={`/categorylist/${id}`}>
                        <button className='btn-details'>details</button>
                    </Link>
                </div>
                <div className="w-1/5">
                    <button className='btn-delete' onClick={handleDelete}>delete</button>
                </div>
            </div>
        </>
    );
}

export default Categoryitem;
