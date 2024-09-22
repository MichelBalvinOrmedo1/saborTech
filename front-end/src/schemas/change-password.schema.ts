import { z } from "zod";

const changePasswordSchema = z
  .object({
    newPassword: z.string().min(6),
    repeatPassword: z.string().min(6),
  })
  .refine((data) => data.newPassword === data.repeatPassword, {
    message: "Passwords do not match",
    path: ["newPassword"],
  });

export { changePasswordSchema };
