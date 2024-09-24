import { useDispatch } from "react-redux";
import { RecipeList } from "../../components/RecipeList";
import { useEffect, useState } from "react";
import { setRecipes } from "../../redux/recipesSlice";
import { AppDispatch } from "../../redux/store";
import { recipes } from "../../data/recipe";
import { RecipeListItem, RecipeListProps } from "../../models/Recipes";

export const Search = () => {
  const dispatch = useDispatch<AppDispatch>();
  const [recipeProp, setRecipeProp] = useState<RecipeListProps>({ data: [] });

  useEffect(() => {
    const recipeListData: RecipeListItem[] = recipes.map((recipe) => ({
      id: recipe.id,
      image: recipe.image,
      time: recipe.time,
      servings: recipe.servings,
      time_format: recipe.time_format,
      name: recipe.name,
      description: recipe.description,
      rating: recipe.rating,
      tags: recipe.tags,
      category: recipe.category,
    }));
    setRecipeProp({ data: recipeListData });
    dispatch(setRecipes(recipeListData));
  }, [dispatch]);
  return (
    <>
      <RecipeList data={recipeProp?.data} />
    </>
  );
};
