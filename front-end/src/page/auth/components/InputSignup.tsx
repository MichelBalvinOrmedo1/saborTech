import React from "react";
import { FieldValues, UseFormRegister } from "react-hook-form";

interface PropsInputSignup {
  label: string;
  type: string;
  register: UseFormRegister<FieldValues>;
  valueRegister: string;
}

export const InputSignup: React.FC<PropsInputSignup> = ({
  label,
  type,
  register,
  valueRegister,
}) => {
  return (
    <div className="flex max-w-[480px] flex-wrap items-end gap-4 px-4 py-3">
      <label className="flex flex-col min-w-40 flex-1">
        <p className="text-base font-medium leading-normal pb-2">{label}</p>
        <input
          placeholder="@username"
          type={type}
          className="form-input flex w-full min-w-0 flex-1 resize-none overflow-hidden rounded-xl text-white focus:outline-0 focus:ring-0 border border-[#3c4753] bg-[#1c2126] focus:border-[#3c4753] h-14 placeholder:text-[#9dabb8] p-[15px] text-base font-normal leading-normal"
          {...register(valueRegister)}
        />
      </label>
    </div>
  );
};
