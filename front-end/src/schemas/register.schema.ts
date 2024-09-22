import { z } from "zod";

const registerSchema = z
  .object({
    email: z
      .string()
      .min(1, "The email field cannot be empty")
      .email("Please enter a valid email"),
    password: z.string().min(8, "Password must be at least 8 characters long"),
    confirmPassword: z
      .string()
      .min(8, "Confirm password must be at least 8 characters long"),
    lastName: z.string().min(1, "The last name field cannot be empty"),
    name: z.string().min(1, "The name field cannot be empty"),
  })
  .refine((data) => data.password === data.confirmPassword, {
    message: "Passwords do not match",
    path: ["password"],
  });

export { registerSchema };
