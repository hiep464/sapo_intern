import Link from "next/link";

// type typeProps = {
//   id: number;
//   code: string;
//   name: string;
// };

function Categoryitem(data: any) {
  const { id, code, name } = data.data;
  return (
    <div className="w-3/5 flex text-center border-b my-2">
      <div className="w-1/4">
        <span>{id}</span>
      </div>
      <div className="w-1/4">
        <span>{code}</span>
      </div>
      <div className="w-1/4">
        <span>{name}</span>
      </div>
      <div className="w-1/4">
        <Link href={`/categorylist/${id}`}>
        <button>details</button>  
        </Link>
      </div>
    </div>
  );
}

export default Categoryitem;
