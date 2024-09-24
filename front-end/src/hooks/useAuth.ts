import { useContext } from "react";
import UserContext from "../context/UserContext";

export const useAuth = () => {
  return useContext(UserContext);
};
