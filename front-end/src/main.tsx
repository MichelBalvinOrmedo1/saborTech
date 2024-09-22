import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./style.css";

import { router } from "./routes/Routes";
import { RouterProvider } from "react-router-dom";

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>
);
