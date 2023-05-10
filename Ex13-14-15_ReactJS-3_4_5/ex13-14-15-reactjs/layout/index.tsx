import Header from './header';

function Layout({ children }: any) {
    return (
        <div>
            <div><Header /></div>
            <hr />
            <main className='bg-gray-100 main-body'>{children}</main>
        </div>
    );
}

export default Layout;
