import { createContext } from "react";
import { RegisterUser, UserProfile } from "../models/User";

export type UserContextType = {
  user: UserProfile | null;
  token: string | null;
  registerUser: (
    username: string,
    password: string,
    profile: RegisterUser
  ) => void;
  loginUser: (username: string, password: string) => void;
  logout: () => void;
  isLoggedIn: () => boolean;
};

const UserContext = createContext<UserContextType>({} as UserContextType);
export default UserContext;
