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
    <div
      key={recipe.id}
      className="bg-white shadow-md rounded-lg overflow-hidden transition-transform transform hover:scale-105 w-64"
    >
      <img
        src={recipe.image}
        alt={recipe.name}
        className="w-full h-32 object-cover"
      />
      <div className="p-4">
        <h2 className="font-bold text-lg mb-2">{recipe.name}</h2>
        <p className="text-gray-700 text-sm mb-2">{recipe.description}</p>
        <div className="border-b border-gray-200 mb-2"></div>
        <p className="text-gray-600 text-xs mb-1">
          Categoría: {recipe.category}
        </p>
        <p className="text-gray-600 text-xs mb-1">Tiempo: {recipe.time}</p>
        <p className="text-gray-600 text-xs mb-1">
          Formato de tiempo: {recipe.time_format}
        </p>
        <p className="text-gray-600 text-xs mb-1">
          Porciones: {recipe.servings}
        </p>
        <p className="text-gray-600 text-xs mb-2">Rating: {recipe.rating}</p>
        <button className="bg-blue-500 text-white text-sm px-3 py-1 rounded hover:bg-blue-600">
          Ver receta
        </button>
      </div>
    </div>
  );
};
