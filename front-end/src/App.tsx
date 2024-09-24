import { Outlet } from "react-router-dom";

import { Navbar } from "./page/Navbar/Navbar";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css"; // Asegúrate de importar los estilos

import { Provider } from "react-redux";
import { store } from "./redux/store";
import { UserProvider } from "./providers/UserProvider";
import { QueryProvider } from "./providers/QueryProvider";

export const App = () => {
  return (
    <>
      <Provider store={store}>
        <QueryProvider>
          <UserProvider>
            <Navbar />
            <Outlet />
            <ToastContainer />
          </UserProvider>
        </QueryProvider>
      </Provider>
    </>
  );
};
