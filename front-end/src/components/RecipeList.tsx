import { RecipeCardItem } from "./RecipeCardItem";
interface RecipeListProps {
  data: {
    id: string;
    image: string;
    name: string;
    description: string;
    rating: number;
  }[];
}

export const RecipeList: React.FC<RecipeListProps> = ({ data }) => {
  return (
    <>
      {data.map((recipe) => (
        <RecipeCardItem key={recipe.id} recipeId={recipe.id} />
      ))}
    </>
  );
};
