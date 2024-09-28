import { useForm } from "react-hook-form";
import { InputSignup } from "./components/InputSignup";
import { useAuth } from "../../hooks/useAuth";

// Función para verificar el estado de la imagen

export const Signup = () => {
  const { register, handleSubmit, watch } = useForm();

  const { registerUser } = useAuth();

  const onSubmit = async () => {
    registerUser(watch("userName"), watch("password"), {
      firstName: watch("firstName"),
      lastName: watch("lastName"),
      email: watch("email"),
      biografy: watch("biografy"),
      profileImage:
        "https://www.shutterstock.com/image-vector/user-profile-icon-vector-avatar-600nw-2247726673.jpg",
      followersCount: 0,
      recipesCount: 0,
    });
  };
  return (
    <>
      <div className="px-40 flex flex-1 justify-center py-5">
        <form
          onSubmit={handleSubmit(onSubmit)}
          className="layout-content-container flex flex-col w-[512px] max-w-[512px] py-5 max-w-[960px] flex-1"
        >
          <h1 className="text-white text-[22px] font-bold leading-tight tracking-[-0.015em] px-4 text-center pb-3 pt-5">
            Create an account
          </h1>
          <InputSignup
            label="Username"
            type="text"
            register={register}
            valueRegister="userName"
          />
          <InputSignup
            label="Password"
            type="password"
            register={register}
            valueRegister="password"
          />
          <InputSignup
            label="Confirm password"
            type="password"
            register={register}
            valueRegister="confirmPassword"
          />
          <InputSignup
            label="First name"
            type="text"
            register={register}
            valueRegister="firstName"
          />
          <InputSignup
            label="Last name"
            type="text"
            register={register}
            valueRegister="lastName"
          />
          <InputSignup
            label="Email"
            type="email"
            register={register}
            valueRegister="email"
          />
          <div className="flex px-4 py-3">
            <button className="flex min-w-[84px] max-w-[480px] cursor-pointer items-center justify-center overflow-hidden rounded-xl h-10 px-4 flex-1 bg-[#1980e6] text-white text-sm font-bold leading-normal tracking-[0.015em]">
              <span className="truncate">Create account</span>
            </button>
          </div>
        </form>
      </div>
    </>
  );
};
