import React from "react";
import { useSelector } from "react-redux";
import { RootState } from "../redux/store";
interface RecipeItemProps {
  recipeId: string;
}
export const RecipeCardItem: React.FC<RecipeItemProps> = ({ recipeId }) => {
  const recipe = useSelector((state: RootState) =>
    state.recipes.data.find((recipe) => recipe.id === recipeId)
  );

  if (!recipe) {
    return <div>Recipe not found</div>;
  }
  return (
    <div key={recipe.id}>
      <img src={recipe.image} alt={recipe.name} />
      <h2 className="font-semibold">{recipe.name}</h2>
      <p>{recipe.description}</p>
      <p>{recipe.time}</p>
      <p>{recipe.time_format}</p>
      <p>{recipe.servings} porciones</p>
      <p>Rating: {recipe.rating}</p>
    </div>
  );
};
