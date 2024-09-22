import { useQuery } from "@tanstack/react-query";

const getRandomNumber = async () => {
  const res = await fetch(
    "https://www.random.org/integers/?num=1&min=1&max=100&col=1&base=10&format=plain&rnd=new"
  );
  const numberString = await res.text();

  return +numberString;
};
export const Home = () => {
  const query = useQuery({
    queryKey: ["randomNumber"],
    queryFn: getRandomNumber,
  });
  return (
    <>
      <h1 className=" text-red-500">Home</h1>
      {query.isLoading && <p>Loading...</p>}
      {query.isError && <p>Error: {`${query.error}`}</p>}
      {query.isSuccess && <p>Random number: {query.data}</p>}

      <button onClick={() => query.refetch()} disabled={query.isLoading}>
        {query.isLoading ? "Refreshing..." : "Refresh"}
      </button>
    </>
  );
};
