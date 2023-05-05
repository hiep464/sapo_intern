import Link from "next/link";
import Head from "next/head";

function Dashboard() {
  const userName = localStorage.getItem("userName");
  return (
    <>
      <Head>
        <title>Dashboard</title>
      </Head>
      <div className="flex items-center justify-center flex-col">
        <span className="my-8 text-2xl font-semibold">hello {userName}</span>
        <br />
        <Link href={"/categorylist"}>
          <span className="border-b">Category List</span>
        </Link>
      </div>
    </>
  );
}

export default Dashboard;
