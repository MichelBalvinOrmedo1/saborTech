import { useEffect, useState, ReactNode } from "react";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import axios from "axios";
import { UserProfile } from "../models/User";
import { loginApi, registerApi } from "../Service/AuthService";
import UserContext from "../context/UserContext";

type Props = { children: ReactNode };

export const UserProvider = ({ children }: Props) => {
  const navigate = useNavigate();
  const [token, setToken] = useState<string | null>(null);
  const [user, setUser] = useState<UserProfile | null>(null);
  const [isReady, setIsReady] = useState<boolean>(false);

  useEffect(() => {
    const storedUser = localStorage.getItem("user");
    const storedToken = localStorage.getItem("token");

    if (storedUser && storedToken) {
      setUser(JSON.parse(storedUser));
      setToken(storedToken);
      axios.defaults.headers.common["Authorization"] = `Bearer ${storedToken}`;
    }
    setIsReady(true);
  }, []);

  const registerUser = async (
    email: string,
    username: string,
    password: string
  ) => {
    await registerApi(email, username, password)
      .then((res) => {
        if (res) {
          localStorage.setItem("token", res?.data.token);
          const userObj = {
            userName: res?.data.userName,
            email: res?.data.email,
          };

          localStorage.setItem("user", JSON.stringify(userObj));
          setToken(res?.data.token);
          setUser(userObj!);
          toast.success("User registered successfully");
          navigate("/");
        }
      })
      .catch(() => {
        toast.warning("Server error occurred");
      });
  };

  const loginUser = async (username: string, password: string) => {
    await loginApi(username, password)
      .then((res) => {
        if (res) {
          localStorage.setItem("token", res?.token);
          const userObj = {
            userName: res?.userName,
            email: res?.email,
          };

          localStorage.setItem("user", JSON.stringify(userObj));
          setToken(res?.token);
          setUser(userObj!);
          toast.success("Login successfully");
          navigate("/");
        }
      })
      .catch(() => {
        toast.warning("Server error occurred");
      });
  };

  const isLogged = () => {
    return !!user;
  };

  const logout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    setUser(null);
    setToken(null);
    navigate("/login");
  };

  return (
    <UserContext.Provider
      value={{
        loginUser,
        registerUser,
        user,
        token,
        logout,
        isLoggedIn: isLogged,
      }}
    >
      {isReady ? children : null}
    </UserContext.Provider>
  );
};