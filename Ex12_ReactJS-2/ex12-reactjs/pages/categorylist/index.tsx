import Head from "next/head";
import CategoryItem from "../../components/CategoryItem";
import Link from "next/link";

const data = [
  { id: 1, code: "C001", name: "category1" },
  { id: 2, code: "C002", name: "category2" },
];

function CategoryList() {
  return(
    <>
        <Head>
        <title>Category List</title>
        </Head>
        <div className="flex justify-center items-center flex-col">
        <span className="text-3xl font-bold my-6">Category List</span>
        {data.map((item, key) => {
            return <CategoryItem data={item} key={key} />;
        })}
        <Link href={'/dashboard'}><button className='bg-gray-400 mt-2 px-3 py-1 rounded-sm text-gray-50 my-6'>Back</button></Link>
        </div>
        ;
    </>
  )
}

export default CategoryList;
