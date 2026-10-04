import java.util.ArrayList;
import java.util.Scanner;

public class MealPlannerApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Meal> meals = new ArrayList<>();
    private static final ArrayList<WeeklyPlan> weeklyPlans = new ArrayList<>();
    private static int nextMealId = 1;

    public static void main(String[] args) {
        addSampleMeals();

        while (true) {
            printMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> addMeal();
                case 2 -> viewMeals();
                case 3 -> searchMeals();
                case 4 -> deleteMeal();
                case 5 -> createWeeklyPlan();
                case 6 -> viewWeeklyPlan();
                case 7 -> {
                    System.out.println("\nThank you for using MealPlanner. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n================================");
        System.out.println("          MEAL PLANNER");
        System.out.println("================================");
        System.out.println("1. Add Meal");
        System.out.println("2. View Meals");
        System.out.println("3. Search Meals");
        System.out.println("4. Delete Meal");
        System.out.println("5. Create Weekly Plan");
        System.out.println("6. View Weekly Plan");
        System.out.println("7. Exit");
        System.out.println("================================");
    }

    private static void addMeal() {
        System.out.println("\n--- Add Meal ---");
        String name = readText("Meal name: ");
        String type = readText("Meal type (Breakfast/Lunch/Dinner/Snack): ");
        String ingredients = readText("Ingredients: ");

        meals.add(new Meal(nextMealId++, name, type, ingredients));
        System.out.println("Meal added successfully!");
    }

    private static void viewMeals() {
        System.out.println("\n--- Saved Meals ---");

        if (meals.isEmpty()) {
            System.out.println("No meals saved yet.");
            return;
        }

        for (Meal meal : meals) {
            System.out.println(meal);
        }
    }

    private static void searchMeals() {
        System.out.println("\n--- Search Meals ---");
        String keyword = readText("Enter meal name or type: ").toLowerCase();
        boolean found = false;

        for (Meal meal : meals) {
            if (meal.getName().toLowerCase().contains(keyword)
                    || meal.getType().toLowerCase().contains(keyword)) {
                System.out.println(meal);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching meals found.");
        }
    }

    private static void deleteMeal() {
        System.out.println("\n--- Delete Meal ---");
        viewMeals();

        if (meals.isEmpty()) {
            return;
        }

        int id = readInt("Enter meal ID to delete: ");
        Meal mealToDelete = null;

        for (Meal meal : meals) {
            if (meal.getId() == id) {
                mealToDelete = meal;
                break;
            }
        }

        if (mealToDelete != null) {
            meals.remove(mealToDelete);
            System.out.println("Meal deleted successfully!");
        } else {
            System.out.println("Meal ID not found.");
        }
    }

    private static void createWeeklyPlan() {
        System.out.println("\n--- Create Weekly Plan ---");
        String day = readText("Day (Monday-Sunday): ");
        String breakfast = readText("Breakfast: ");
        String lunch = readText("Lunch: ");
        String dinner = readText("Dinner: ");

        // Replace an existing plan for the same day.
        weeklyPlans.removeIf(plan -> plan.getDay().equalsIgnoreCase(day));
        weeklyPlans.add(new WeeklyPlan(day, breakfast, lunch, dinner));

        System.out.println("Weekly plan saved for " + day + "!");
    }

    private static void viewWeeklyPlan() {
        System.out.println("\n--- Weekly Meal Plan ---");

        if (weeklyPlans.isEmpty()) {
            System.out.println("No weekly plans saved yet.");
            return;
        }

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        for (String day : days) {
            boolean found = false;
            for (WeeklyPlan plan : weeklyPlans) {
                if (plan.getDay().equalsIgnoreCase(day)) {
                    System.out.println(plan);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println(day + " | No plan yet");
            }
        }
    }

    private static void addSampleMeals() {
        meals.add(new Meal(nextMealId++, "Oatmeal", "Breakfast", "Oats, milk, banana"));
        meals.add(new Meal(nextMealId++, "Chicken Rice", "Lunch", "Chicken, rice, vegetables"));
        meals.add(new Meal(nextMealId++, "Pasta", "Dinner", "Pasta, tomato sauce, cheese"));
    }

    private static String readText(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    private static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
