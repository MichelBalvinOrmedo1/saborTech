import { RecipeListItem } from "../models/Recipes";

export const recipeFilterCategory = (
  data: RecipeListItem[],
  categoryName: string
) => {
  return data.filter((recipe) => recipe.category.includes(categoryName));
};
