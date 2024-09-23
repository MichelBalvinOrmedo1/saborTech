import { Outlet } from "react-router-dom";
import { UserProvider } from "./context/useAuth";
import { Navbar } from "./page/Navbar/Navbar";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css"; // Asegúrate de importar los estilos

import { QueryProvider } from "./app/query.provider";
import { Provider } from "react-redux";
import { store } from "./redux/store";

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
