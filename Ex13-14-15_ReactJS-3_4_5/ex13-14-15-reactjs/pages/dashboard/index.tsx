import Head from 'next/head';
import { useEffect, useState } from 'react';
import { storageKey } from '../../context/AuthContext';
import Layout from '@/layout';
import type { NextPageWithLayout } from '../_app';
import type { ReactElement } from 'react';

export async function getServerSideProps(context: any) {
    const { Authorization } = context.req.cookies;
    
    if (!Authorization) {
      return {
        redirect: {
          destination: '/',
          permanent: false,
        },
      };
    }
  
    return {
      props: {}, // Không có props nào được truyền vào component
    };
  }

const Dashboard: NextPageWithLayout = () => {
    const [userName, setUserName] = useState('')
    
    useEffect(() => {
        const login: any = localStorage?.getItem(storageKey) || '';
        const loginObject = JSON.parse(login);
        setUserName(loginObject?.username);
    }, [])

    return (
        <>
            <Head>
                <title>Dashboard</title>
            </Head>
            <div className="flex items-center justify-center flex-col">
                <span className="my-8 text-2xl font-semibold">hello {userName}</span>
                <br />
            </div>
        </>
    );
}

export default Dashboard;

Dashboard.getLayout = function getLayout(page: ReactElement) {
  return (
    <Layout>
      {page}
    </Layout>
  )
}