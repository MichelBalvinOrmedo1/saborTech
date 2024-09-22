import { createContext, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import React from "react";
import axios from "axios";
import { loginApi, registerApi } from "../Service/AuthService";
import { UserProfile } from "../models/User";

type UserContextType = {
  user: UserProfile | null;
  token: string | null;
  registerUser: (email: string, username: string, password: string) => void;
  loginUser: (username: string, password: string) => void;
  logout: () => void;
  isLoggedIn: () => boolean;
};

type Props = { children: React.ReactNode };

const UserContext = createContext<UserContextType>({} as UserContextType);

export const UserProvider = ({ children }: Props) => {
  const navigate = useNavigate();

  const [token, setToken] = useState<string | null>(null);
  const [user, setUser] = useState<UserProfile | null>(null);
  const [isReady, setIsReady] = useState<boolean>(false);

  useEffect(() => {
    const user = localStorage.getItem("user");
    const token = localStorage.getItem("token");

    if (user && token) {
      setUser(JSON.parse(user));
      setToken(token);
      axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
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
        toast.warning("server error occured");
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
        toast.warning("server error occured");
      });
  };

  const isLogged = () => {
    return !!user;
  };
  const logout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    setUser(null);
    setToken("");
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

export const useAuth = () => React.useContext(UserContext);
