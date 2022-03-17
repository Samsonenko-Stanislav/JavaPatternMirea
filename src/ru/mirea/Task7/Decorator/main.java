package ru.mirea.Task7.Decorator;

public class main {
    public static void main(String[] args) {
        Burger humburger = new Humburger();
        System.out.println("Cost: "+humburger.getCost() + " Ingredients: "+humburger.getIngredients());

        Burger cheeseburger = new Cheeseburger(new Humburger());
        System.out.println("Cost: "+cheeseburger.getCost() + " Ingredients: "+cheeseburger.getIngredients());

        Burger cheeseburgerWithBakon = new CheeseburgerWithBakon(new Cheeseburger(new Humburger()));
        System.out.println("Cost: "+cheeseburgerWithBakon.getCost() + " Ingredients: "+cheeseburgerWithBakon.getIngredients());


    }
}
