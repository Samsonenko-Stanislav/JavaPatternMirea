package ru.mirea.Task7.Decorator;
public class Humburger implements Burger {

    @Override
    public int getCost() {
        return 50;
    }

    @Override
    public String getIngredients() {
        return "Humburger";
    }
}
