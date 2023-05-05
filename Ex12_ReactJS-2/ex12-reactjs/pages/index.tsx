import { Inter } from "next/font/google";
import { useState } from "react";
import { useRouter } from "next/router";
import Head from "next/head";

const inter = Inter({ subsets: ["latin"] });

export default function Home() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(false);
  const router = useRouter();

  const login = () => {
    if (username === "admin" && password === "admin") {
      localStorage.setItem("userName", username);
      router.push("/dashboard");
    } else {
      setError(true);
    }
  };

  return (
    <>
      <Head>
        <title>Category List</title>
      </Head>
      <div className="container w-screen bg-gray-400 h-screen flex justify-center items-center">
        <div className="w-20 flex justify-center items-center flex-col">
          <span className="font-semibold text-2xl mb-2">Login</span>
          <input
            type="text"
            className="rounded-sm p-1 my-1"
            onChange={(e) => {
              setUsername(e.target.value);
            }}
          />
          <input
            type="password"
            className="rounded-sm p-1 my-1"
            onChange={(e) => {
              setPassword(e.target.value);
            }}
          />
          {error ? (
            <span className="text-red-600 text-xs w-44">
              username/password không đúng
            </span>
          ) : (
            ""
          )}
          <button
            className="bg-red-500 mt-2 px-2 py-1 rounded-sm text-gray-50"
            onClick={login}
          >
            Submit
          </button>
        </div>
      </div>
    </>
  );
}
