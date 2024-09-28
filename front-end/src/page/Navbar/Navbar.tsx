import { Link } from "react-router-dom";
import { useAuth } from "../../hooks/useAuth";

export const Navbar = () => {
  const { isLoggedIn, user, logout } = useAuth();

  return (
    <>
      <header className="flex items-center justify-between whitespace-nowrap border-b border-solid border-b-[#f0f2f4] px-10 py-3">
        <div className="flex items-center gap-4 text-[#111418]">
          <div className="size-4">
            <svg
              viewBox="0 0 48 48"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="M42.4379 44C42.4379 44 36.0744 33.9038 41.1692 24C46.8624 12.9336 42.2078 4 42.2078 4L7.01134 4C7.01134 4 11.6577 12.932 5.96912 23.9969C0.876273 33.9029 7.27094 44 7.27094 44L42.4379 44Z"
                fill="currentColor"
              ></path>
            </svg>
          </div>
          <h2 className="text-[#111418] text-lg font-bold leading-tight tracking-[-0.015em]">
            Tasty
          </h2>
        </div>
        <div className="flex flex-1 justify-end gap-8">
          <div className="flex items-center gap-9">
            <Link
              className="text-[#111418] text-sm font-medium leading-normal"
              to="/"
            >
              recipes
            </Link>

            <a
              className="text-[#111418] text-sm font-medium leading-normal"
              href="#"
            >
              Guides
            </a>
            <a
              className="text-[#111418] text-sm font-medium leading-normal"
              href="#"
            >
              Makers
            </a>
            <a
              className="text-[#111418] text-sm font-medium leading-normal"
              href="#"
            >
              Videos
            </a>
          </div>
          <div className="flex gap-2">
            {isLoggedIn() ? (
              <>
                <p className="flex min-w-[84px] max-w-[480px] cursor-pointer items-center justify-center overflow-hidden rounded-xl h-10 px-4 bg-[#1980e6] text-white text-sm font-bold leading-normal tracking-[0.015em]">
                  Welcome , {user?.profile?.fullName}
                </p>
                <img
                  src={user?.profile.profileImage}
                  alt="profile"
                  className="flex min-w-[84px] max-w-[480px] cursor-pointer items-center justify-center overflow-hidden rounded-xl h-10 px-4 bg-[#f0f2f4] text-[#111418] text-sm font-bold leading-normal tracking-[0.015em]"
                />
                <button
                  onClick={logout}
                  className="flex min-w-[84px] max-w-[480px] cursor-pointer items-center justify-center overflow-hidden rounded-xl h-10 px-4 bg-[#1980e6] text-white text-sm font-bold leading-normal tracking-[0.015em]"
                >
                  logout
                </button>
              </>
            ) : (
              <>
                <button className="flex min-w-[84px] max-w-[480px] cursor-pointer items-center justify-center overflow-hidden rounded-xl h-10 px-4 bg-[#1980e6] text-white text-sm font-bold leading-normal tracking-[0.015em]">
                  <Link to="/login" className="hover:text-darkBlue">
                    Login
                  </Link>
                </button>
                <button className="flex min-w-[84px] max-w-[480px] cursor-pointer items-center justify-center overflow-hidden rounded-xl h-10 px-4 bg-[#f0f2f4] text-[#111418] text-sm font-bold leading-normal tracking-[0.015em]">
                  <span className="truncate">Sign up</span>
                </button>
              </>
            )}
          </div>
        </div>
      </header>
    </>
  );
};
