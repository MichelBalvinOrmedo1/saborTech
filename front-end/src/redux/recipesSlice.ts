import { createSlice, PayloadAction } from "@reduxjs/toolkit";
enum TimeFormat {
  Minutes = "minutes",
  Hours = "hours",
  Days = "days",
}
interface Recipe {
  id: string;
  image: string;
  time: number;
  time_format: TimeFormat;
  servings: number;
  name: string;
  description: string;
  rating: number;
}

interface RecipesState {
  data: Recipe[];
}

const initialState: RecipesState = {
  data: [],
};

const recipesSlice = createSlice({
  name: "recipes",
  initialState,
  reducers: {
    setRecipes: (state, action: PayloadAction<Recipe[]>) => {
      state.data = action.payload;
    },
  },
});

export const { setRecipes } = recipesSlice.actions;
export default recipesSlice.reducer;
