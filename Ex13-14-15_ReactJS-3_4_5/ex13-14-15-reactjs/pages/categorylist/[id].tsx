import Head from 'next/head';
import { useRouter } from 'next/router';
import Link from 'next/link';
import { useGetCategory, useUpdateCategory } from '@/apiHandle/useCategory';
import Layout from '@/layout';
import type { NextPageWithLayout } from '../_app';
import { ReactElement, useEffect, useState } from 'react';
import Alert from '@/components/Alert';

// type dataUpdate = {
//     id: number;
//     categoryCode: string;
//     categoryName: string;
//     description: string;
// };


const Details: NextPageWithLayout = () => {
    // const [code, setCode] = useState('');
    // const [name, setName] = useState('');
    // const [description, setDescription] = useState('');
    const [sucess, setSucess] = useState(false);
    const [cate, setCate] = useState({id: '', categoryCode: '', categoryName: '', description: ''})
    const [auth, setAuth] = useState(false);

    const handleMutationEvent = {
        onSuccess: (data: any) => {
            setSucess(true);
            // alert('sucess')
            console.log(data.data)
            
            setTimeout(() => {
                setSucess(false);
            }, 2000);
        },
        onError: (err: any) => {
            const httpStatus = err.response.status;
            if (httpStatus === 403) {
                // alert("phiên đăng nhập hết hạn")
                setAuth(true);
                // router.push('/');
            } else if (httpStatus === 400) {
                alert('Categorycode is not change');
            } else alert('error');
        },
    };

    const router = useRouter();
    const { id: idParam } = router.query;

    const category = useGetCategory(idParam);

    useEffect(() => {
        setCate(category)
    }, [category])

    const { mutate: update } = useUpdateCategory(idParam, handleMutationEvent);
    const handleUpdate = () => {
        const ipCode: any = document.getElementById('inputCode')
        const ipName: any = document.getElementById('inputName')
        const ipDescription: any = document.getElementById('inputDescription')
        const data: any = {
            id: parseInt(category?.id),
            categoryCode: ipCode?.value,
            categoryName: ipName?.value,
            description: ipDescription?.value,
        };
        update(data);
    };

    return (
        <>
            {/* {console.log(category?.categoryCode,category?.categoryName,category?.description)} */}
            {/* {console.log(code,name,description)} */}
            <Head>
                <title>Details</title>
            </Head>
            {sucess ? <Alert text={'Update sucess'} /> : ''}
            {auth ? (
                <div className="fixed inset-0 flex items-center justify-center">
                    <div className="w-60 h-28 bg-yellow-200 flex items-center justify-center flex-col rounded">
                        <span className="text-xl font-semibold text-yellow-500">Phiên đăng nhập hết hạn</span>
                        <button
                            className="bg-blue-500 mt-4 px-2 py-1 px-3 rounded-sm text-white btn-submit"
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
            <div className="flex justify-center items-center flex-col">
                <span className="text-3xl font-bold my-6">Details</span>
                <div className="w-2/5 text-left ml-60 mb-4">
                    <div className="flex my-2">
                        <span className="w-2/5">Code :</span>
                        <div className="w-3/5">
                            <input
                                id='inputCode'
                                className="text-center"
                                defaultValue={cate?.categoryCode}
                                // onChange={(e) => {
                                //     setCode(e.target.value);
                                // }}
                            ></input>
                        </div>
                    </div>
                    <div className="flex my-2">
                        <span className="w-2/5">Name :</span>
                        <div className="w-3/5">
                            <input
                                id='inputName'
                                className="text-center"
                                defaultValue={cate?.categoryName}
                                // onChange={(e) => {
                                //     setName(e.target.value);
                                // }}
                            ></input>
                        </div>
                    </div>
                    <div className="flex my-2">
                        <span className="w-2/5">Description :</span>
                        <div className="w-3/5">
                            <input
                                id='inputDescription'
                                className="text-center"
                                defaultValue={cate?.description}
                                // onChange={(e) => {
                                //     setDescription(e.target.value);
                                // }}
                            ></input>
                        </div>
                    </div>
                </div>
                <div className="flex">
                    <button
                        onClick={handleUpdate}
                        className="btn-update mt-2 mr-4 px-3 py-1 rounded-sm text-blue-50 bg-blue-600"
                    >
                        Update
                    </button>
                    <Link href={'/categorylist'}>
                        <button className="bg-gray-400 mt-2 px-3 py-1 rounded-sm text-gray-50 ">Back</button>
                    </Link>
                </div>
            </div>
        </>
    );
};

export default Details;

Details.getLayout = function getLayout(page: ReactElement) {
    return <Layout>{page}</Layout>;
};
