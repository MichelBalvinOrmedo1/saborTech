import { recipeFilterCategory } from "../helpers/recipeFilterCategory";
import { RecipeListProps } from "../models/Recipes";
import { RecipeCardItem } from "./RecipeCardItem";

const category = ["Main Course", "Dessert", "Appetizer", "Drink"];

export const RecipeList: React.FC<RecipeListProps> = ({ data }) => {
  if (data.length === 0) {
    return <div>Cargando recetas...</div>;
  }

  return (
    <>
      {category.map((category) => {
        const categoryRecipes = recipeFilterCategory(data, category);

        if (categoryRecipes.length === 0) return;

        return (
          <div key={category}>
            <h2 className="text-3xl font-semibold">{category}</h2>
            <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
              {categoryRecipes.map((recipe) => (
                <RecipeCardItem key={recipe.id} recipeId={recipe.id} />
              ))}
            </div>
          </div>
        );
      })}
    </>
  );
};
