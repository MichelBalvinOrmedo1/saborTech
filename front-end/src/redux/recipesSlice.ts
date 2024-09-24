import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { RecipeListItem } from "../models/Recipes";

interface RecipesState {
  data: RecipeListItem[];
}

const initialState: RecipesState = {
  data: [],
};

const recipesSlice = createSlice({
  name: "recipes",
  initialState,
  reducers: {
    setRecipes: (state, action: PayloadAction<RecipeListItem[]>) => {
      state.data = action.payload;
    },
  },
});

export const { setRecipes } = recipesSlice.actions;
export default recipesSlice.reducer;
