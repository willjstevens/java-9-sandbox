/*
 * Property of Will Stevens
 * All rights reserved.
 */
package chapter_5;

/**
 * @author wstevens
 */
public class Dish {

    String title;
    boolean isVegan;
    int calories;
    Type type;

    enum Type {
        FISH, MEAT, OTHER
    }

    public Dish(String title, boolean isVegan, int calories, Type type) {
        this.title = title;
        this.isVegan = isVegan;
        this.calories = calories;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }
}
