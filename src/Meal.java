public class Meal {
    private int id;
    private String name;
    private String type;
    private String ingredients;

    public Meal(int id, String name, String type, String ingredients) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.ingredients = ingredients;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public String getIngredients() { return ingredients; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + type + " | Ingredients: " + ingredients;
    }
}
