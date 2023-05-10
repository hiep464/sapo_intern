import { useCreateCategory } from '@/apiHandle/useCategory';
import Link from 'next/link';
import Head from 'next/head';
import { useState } from 'react';
import Layout from '@/layout';
import type { NextPageWithLayout } from '../_app';
import type { ReactElement } from 'react';
import Alert from '@/components/Alert';
import { useRouter } from 'next/router';

const CreateCategory: NextPageWithLayout = () => {
    const [id, setId] = useState('');
    const [code, setCode] = useState('');
    const [name, setName] = useState('');
    const [description, setDescription] = useState('');
    const [auth, setAuth] = useState(false);
    const [sucess, setSucess] = useState(false);

    const router = useRouter();

    const handleMutationEvent = {
        onSuccess: () => {
            setSucess(true);
            // alert('sucess')

            setTimeout(() => {
                setSucess(false);
            }, 2000);
        },
        onError: (err: any) => {
            const httpStatus = err.response.status;
            if(httpStatus === 403){
                setAuth(true);
            }else if(httpStatus === 400)
                alert("Category đã tồn tại")
            else
                alert('error')
        }
    };

    const { mutate: create } = useCreateCategory(handleMutationEvent);

    const handleCreate = () => {
        const data: any = {
            id: id,
            categoryCode: code,
            categoryName: name,
            description: description,
        };
        create(data);
    };

    return (
        <>
            <Head>
                <title>Create Category</title>
            </Head>
            {sucess ? <Alert text={'Create Sucess'} /> : ''}
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
            <div className="flex justify-center items-center flex-col">
                <span className="text-3xl font-bold my-6">Create Category</span>
                <div className="w-2/5 text-left ml-80">
                    <div className="flex my-2">
                        <span className="w-1/5">id :</span>
                        <input
                            type="text"
                            className="border text-center"
                            onChange={(e) => {
                                setId(e.target.value);
                            }}
                        />
                    </div>
                    <div className="flex my-2">
                        <span className="w-1/5">code :</span>
                        <input
                            type="text"
                            className="border text-center"
                            onChange={(e) => {
                                setCode(e.target.value);
                            }}
                        />
                    </div>
                    <div className="flex my-2">
                        <span className="w-1/5">name :</span>
                        <input
                            type="text"
                            className="border text-center"
                            onChange={(e) => {
                                setName(e.target.value);
                            }}
                        />
                    </div>
                    <div className="flex my-2">
                        <span className="w-1/5">description :</span>
                        <input
                            type="text"
                            className="border text-center"
                            onChange={(e) => {
                                setDescription(e.target.value);
                            }}
                        />
                    </div>
                </div>
                <div className="flex my-6">
                    <button
                        className="btn-create mt-2 px-3 py-1 rounded-sm text-blue-50 bg-blue-600 mx-2"
                        onClick={handleCreate}
                    >
                        Create
                    </button>
                    <Link href={'/categorylist'}>
                        <button className="bg-gray-400 mt-2 px-3 py-1 rounded-sm text-gray-50">Back</button>
                    </Link>
                </div>
            </div>
        </>
    );
};

export default CreateCategory;

CreateCategory.getLayout = function getLayout(page: ReactElement) {
    return <Layout>{page}</Layout>;
};
