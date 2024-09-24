import { TimeFormatRecipe } from "../enums/timeFormatRecipe.enum";

// Definición de un ingrediente
export interface Ingredient {
  readonly id: string;
  readonly amount: string;
  readonly unit: number;
  readonly ingredient_name: string;
}

// Definición de un paso
export interface Step {
  readonly id: string;
  readonly description: string;
  readonly step_number: number;
}

// Definición de una receta
export interface Recipe {
  readonly id: string;
  readonly image: string;
  readonly name: string;
  readonly time: number;
  readonly time_format: TimeFormatRecipe;
  readonly servings: number;
  readonly category: string[];
  readonly description: string;
  readonly tags: string[];
  readonly rating: number;
  readonly ingredients: Ingredient[];
  readonly steps: Step[];
}

// Propiedades de la lista de recetas
// src/models/Recipes.ts
export interface RecipeListItem {
  readonly id: string;
  readonly image: string;
  readonly time: number;
  readonly servings: number;
  readonly time_format: TimeFormatRecipe;
  readonly name: string;
  readonly description: string;
  readonly rating: number;
  readonly tags: string[];
  readonly category: string[];
}

export interface RecipeListProps {
  readonly data: RecipeListItem[];
}
