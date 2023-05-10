import '@/styles/globals.css';
import '@/styles/header.css';
import type { AppProps } from 'next/app';
import { QueryClient, QueryClientProvider } from 'react-query';
import { ReactQueryDevtools } from 'react-query/devtools';
import React from 'react';
import { AuthContextProvider } from '../context/AuthContext';
import type { ReactElement, ReactNode } from 'react';
import type { NextPage } from 'next';

const queryClient = new QueryClient();

export type NextPageWithLayout<P = {}, IP = P> = NextPage<P, IP> & {
    getLayout?: (page: ReactElement) => ReactNode;
  };
   
  type AppPropsWithLayout = AppProps & {
    Component: NextPageWithLayout;
  };

export default function App({ Component, pageProps }: AppPropsWithLayout) {
    const getLayout = Component.getLayout ?? ((page) => page);

    return (
        <QueryClientProvider client={queryClient}>
            <AuthContextProvider>
                {getLayout(<Component {...pageProps} />)}
            </AuthContextProvider>
            <ReactQueryDevtools initialIsOpen={false} />
        </QueryClientProvider>
    );
}
