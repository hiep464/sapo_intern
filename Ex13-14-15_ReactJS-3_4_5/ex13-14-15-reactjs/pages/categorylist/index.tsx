import Head from 'next/head';
import CategoryItem from '../../components/CategoryItem';
import Link from 'next/link';
import { useGetAllCategory, useGetCategoryInPage, useGetPageSize } from '../../apiHandle/useCategory';
import Layout from '@/layout';
import type { NextPageWithLayout } from '../_app';
import { ReactElement, useState } from 'react';

const CategoryList: NextPageWithLayout = () => {
    const [page, setPage] = useState(0);

    // const categories = useGetAllCategory();

    const pageSize = useGetPageSize(0, 5);

    const inPage = useGetCategoryInPage(page, 5);
    // console.log(pageSize);
    // console.log(inPage);

    return (
        <>
            <Head>
                <title>Category List</title>
            </Head>
            <div className="flex justify-center items-center flex-col">
                <span className="text-3xl font-bold my-6">Category List</span>
                <div className="relative w-4/5">
                    <Link href={'/categorylist/create'}>
                        <button className="border absolute right-0.5 px-2 rounded text-blue-50 bg-blue-600">Add</button>
                    </Link>
                    <br />
                </div>
                <div className="w-full flex justify-start items-center flex-col h-72">
                    {inPage?.map((item: any, key: number) => {
                        return <CategoryItem data={item} key={key} />;
                    })}
                </div>
                <div className="my-5">
                    {pageSize?.map((item: any, key: any) => {
                        if (page === item - 1)
                            return (
                                <button
                                    key={key}
                                    className="bg-blue-400 m-2 px-3 py-1 rounded-sm text-gray-50 my-6 page-active"
                                    onClick={() => {
                                        setPage(item - 1);
                                    }}
                                >
                                    {item}
                                </button>
                            );
                        else
                            return (
                                <button
                                    key={key}
                                    className="bg-blue-400 m-2 px-3 py-1 rounded-sm text-gray-50 my-6"
                                    onClick={() => {
                                        setPage(item - 1);
                                    }}
                                >
                                    {item}
                                </button>
                            );
                    })}
                </div>
            </div>
        </>
    );
};

export default CategoryList;

CategoryList.getLayout = function getLayout(page: ReactElement) {
    return <Layout>{page}</Layout>;
};
