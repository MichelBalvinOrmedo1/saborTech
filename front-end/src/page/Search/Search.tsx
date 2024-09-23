import { useDispatch } from "react-redux";
import { RecipeList } from "../../components/RecipeList";
import { recipes } from "../../data/recipe";
import { useEffect } from "react";
import { setRecipes } from "../../redux/recipesSlice";
import { AppDispatch } from "../../redux/store";

export const Search = () => {
  const dispatch = useDispatch<AppDispatch>();

  useEffect(() => {
    dispatch(setRecipes(recipes));
  }, [dispatch]);
  return (
    <>
      <RecipeList data={recipes} />;
    </>
  );
};
