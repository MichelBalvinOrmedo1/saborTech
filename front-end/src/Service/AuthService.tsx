import axios from "axios";
import publicConfig from "../config/public.config";
import { handleError } from "../helpers/ErrorHandle";
import { UserProfileToken } from "../models/User";

const api = publicConfig.api.v1;
const axiosInstance = axios.create({
  baseURL: api,
  headers: {
    "Content-Type": "application/json",
  },
  withCredentials: true, // Si necesitas enviar cookies con la solicitud
});

export const loginApi = async (username: string, password: string) => {
  try {
    const response = await axiosInstance.post<UserProfileToken>("/auth/login", {
      username: username,
      password: password,
    });

    return response.data;
  } catch (error) {
    handleError(error);
  }
};

export const registerApi = async (
  username: string,
  email: string,
  password: string
) => {
  try {
    const data = await axios.post<UserProfileToken>(`${api}/auth/register`, {
      username: username,
      email: email,
      password: password,
    });

    return data;
  } catch (error) {
    handleError(error);
  }
};
