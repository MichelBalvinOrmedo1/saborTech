import { createBrowserRouter } from "react-router-dom";

import ProtectedRoute from "./ProtectedRoute";
import { Home } from "../app/home/Home";
import { Login } from "../page/auth/Login";
import { Signup } from "../page/auth/Signup";
import { App } from "../App";
import { Search } from "../page/Search/Search";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    children: [
      { path: "/", element: <Search /> },
      { path: "login", element: <Login /> },
      { path: "register", element: <Signup /> },
      {
        path: "/search",
        element: (
          <ProtectedRoute>
            <Home />
          </ProtectedRoute>
        ),
      },
    ],
  },
]);
