# MealPlanner 🍽️

A simple Java console application for saving meals and creating weekly meal plans.

## Features

- Add meals
- View saved meals
- Search meals by name or type
- Delete meals
- Create a meal plan for each day of the week
- View the complete weekly plan
- Includes sample meals to demonstrate the application

## Java Concepts Used

- Classes and objects
- Constructors
- Private fields and getters
- ArrayList
- Loops
- If/else conditions
- Switch statements
- Methods
- Scanner input
- Basic CRUD operations
- String searching
- Exception handling with `try/catch`

## Project Structure

```text
MealPlanner/
├── src/
│   ├── Meal.java
│   ├── WeeklyPlan.java
│   └── MealPlannerApp.java
├── .gitignore
└── README.md
```

## How to Run

### Option 1: IntelliJ IDEA / Eclipse

1. Open the `MealPlanner` folder as a Java project.
2. Open `src/MealPlannerApp.java`.
3. Run the `main()` method.

### Option 2: Terminal

From the project folder:

```bash
javac -d out src/*.java
java -cp out MealPlannerApp
```

## Example

```text
================================
          MEAL PLANNER
================================
1. Add Meal
2. View Meals
3. Search Meals
4. Delete Meal
5. Create Weekly Plan
6. View Weekly Plan
7. Exit
================================
```

## Future Improvements

- Save meals to a text or JSON file
- Add calories and preparation time
- Add shopping-list generation
- Add meal categories
- Add a graphical user interface

## Author

Kshama Thakur
