import { defineConfig } from "vite";
import react from "@vitejs/plugin-react-swc";
import dotenv from "dotenv";
import tailwindcss from "tailwindcss";
import autoprefixer from "autoprefixer";

dotenv.config();

export default defineConfig({
  plugins: [react()],
  define: {
    "process.env": process.env,
  },
  css: {
    postcss: {
      plugins: [tailwindcss, autoprefixer],
    },
  },
});
