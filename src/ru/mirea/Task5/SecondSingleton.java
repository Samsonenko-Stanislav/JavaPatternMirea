package ru.mirea.Task5;

public class SecondSingleton {
    private static final SecondSingleton INSTANCE = new SecondSingleton();

    private SecondSingleton() {

    }

    public static SecondSingleton getInstance() {
        return INSTANCE;
    }
}