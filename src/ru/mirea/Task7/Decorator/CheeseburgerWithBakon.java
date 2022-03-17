package ru.mirea.Task7.Decorator;

public class CheeseburgerWithBakon extends Decorator{
    public CheeseburgerWithBakon(Burger burger) {
        super(burger);
    }

    @Override
    public int getCost() {
        return super.getCost() + 10;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients()+", bakon";
    }
}
