public class WeeklyPlan {
    private String day;
    private String breakfast;
    private String lunch;
    private String dinner;

    public WeeklyPlan(String day, String breakfast, String lunch, String dinner) {
        this.day = day;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    public String getDay() { return day; }

    @Override
    public String toString() {
        return day + " | Breakfast: " + breakfast + " | Lunch: " + lunch + " | Dinner: " + dinner;
    }
}
