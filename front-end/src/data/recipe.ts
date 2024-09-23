type Ingredient = {
  id: string;
  amount: string;
  unit: number;
  ingredient_name: string;
};
type Step = {
  id: string;
  description: string;
  step_number: number;
};

enum TimeFormat {
  Minutes = "minutes",
  Hours = "hours",
  Days = "days",
}

type Recipe = {
  id: string;
  image: string;
  name: string;
  time: number;
  time_format: TimeFormat;
  servings: number;

  description: string;
  tags: string[];
  rating: number;
  ingredients: Ingredient[];
  steps: Step[];
};

//Dame un json de Recipe unos 20
export const recipes: Recipe[] = [
  {
    id: "1",
    image:
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSekD43Qe0k8mPovGSZXewaADgacMVBpA2j0A&s",
    name: "Pasta",
    description: "Delicious pasta recipe",
    time: 30,
    time_format: TimeFormat.Minutes,
    servings: 4,
    tags: ["pasta", "italian"],
    rating: 4.5,
    ingredients: [
      { id: "1", amount: "200", unit: 1, ingredient_name: "Spaghetti" },
      { id: "2", amount: "100", unit: 2, ingredient_name: "Tomato Sauce" },
    ],
    steps: [
      { id: "1", description: "Boil water", step_number: 1 },
      { id: "2", description: "Cook pasta", step_number: 2 },
    ],
  },
  {
    id: "2",
    image:
      "https://agraria.pe/imgs/a/lx/pollo-a-la-brasa-es-elegido-como-el-mejor-platillo-del-mundo-29648.jpg",
    name: "Chicken",
    description: "Tasty chicken recipe",
    time: 45,
    time_format: TimeFormat.Minutes,
    servings: 4,
    tags: ["chicken", "grill"],
    rating: 4.7,
    ingredients: [
      { id: "3", amount: "500", unit: 3, ingredient_name: "Chicken Breast" },
      { id: "4", amount: "50", unit: 4, ingredient_name: "BBQ Sauce" },
    ],
    steps: [
      { id: "3", description: "Preheat grill", step_number: 1 },
      { id: "4", description: "Grill chicken", step_number: 2 },
    ],
  },
  {
    id: "3",
    image:
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSekD43Qe0k8mPovGSZXewaADgacMVBpA2j0A&s",
    name: "Pasta",
    description: "Delicious pasta recipe",
    time: 30,
    time_format: TimeFormat.Minutes,
    servings: 4,
    tags: ["pasta", "italian"],
    rating: 4.5,
    ingredients: [
      { id: "5", amount: "200", unit: 1, ingredient_name: "Spaghetti" },
      { id: "6", amount: "100", unit: 2, ingredient_name: "Tomato Sauce" },
    ],
    steps: [
      { id: "5", description: "Boil water", step_number: 1 },
      { id: "6", description: "Cook pasta", step_number: 2 },
    ],
  },
  {
    id: "4",
    image:
      "https://agraria.pe/imgs/a/lx/pollo-a-la-brasa-es-elegido-como-el-mejor-platillo-del-mundo-29648.jpg",
    name: "Chicken",
    description: "Tasty chicken recipe",
    time: 45,
    time_format: TimeFormat.Minutes,
    servings: 4,
    tags: ["chicken", "grill"],
    rating: 4.7,
    ingredients: [
      { id: "7", amount: "500", unit: 3, ingredient_name: "Chicken Breast" },
      { id: "8", amount: "50", unit: 4, ingredient_name: "BBQ Sauce" },
    ],
    steps: [
      { id: "7", description: "Preheat grill", step_number: 1 },
      { id: "8", description: "Grill chicken", step_number: 2 },
    ],
  },
];
