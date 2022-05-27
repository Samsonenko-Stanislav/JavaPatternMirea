package ru.mirea.Task7.Decorator;

public class Decorator implements Burger {
    private Burger burger;

    public Decorator(Burger humburger) {
        this.burger = humburger;
    }

    @Override
    public int getCost() {
        return burger.getCost();
    }

    @Override
    public String getIngredients() {
        return burger.getIngredients();
    }
}
