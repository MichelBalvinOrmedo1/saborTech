import { useState } from "react";
import { Outlet, Navigate } from "react-router-dom";
export const Protected = () => {
  const [isAuth, setIsAuth] = useState(false);
  return isAuth ? <Outlet /> : <Navigate to="/" />;
};
