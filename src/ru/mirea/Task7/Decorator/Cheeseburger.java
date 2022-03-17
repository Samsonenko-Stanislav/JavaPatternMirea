package ru.mirea.Task7.Decorator;
public class Cheeseburger extends Decorator{
    public Cheeseburger(Humburger chocolateBar) {
        super(chocolateBar);
    }

    @Override
    public int getCost() {
        return super.getCost() + 20;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", cheese";
    }
}
