import CategoryDetails from "@/components/CategoryDetails";
import Head from "next/head";
import { useRouter } from "next/router";
import Link from "next/link";

const data = [
  { id: "1", code: "C001", name: "category1", description: "quần" },
  { id: "2", code: "C002", name: "category2", description: "áo" },
];

function Details() {
  const router = useRouter();
  const { id } = router.query;
  return (
    <>
      <Head>
        <title>Details</title>
      </Head>
      <div className="flex justify-center items-center flex-col">
        <span className="text-3xl font-bold my-6">Details</span>
        {data.map((item, key) => {
          if (item.id === id) return <CategoryDetails props={item} key={key} />;
        })}
        <Link href={'/categorylist'}><button className='bg-gray-400 mt-2 px-3 py-1 rounded-sm text-gray-50 my-6'>Back</button></Link>
      </div>
    </>
  );
}

export default Details;
