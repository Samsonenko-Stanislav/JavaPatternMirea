package ru.mirea.Task5;

public class FirstSingleton {
    private static FirstSingleton instance = null;

    private FirstSingleton() {
    }

    public static synchronized FirstSingleton getInstance() {
        if(instance == null) {
            instance = new FirstSingleton();
        }
        return instance;
    }
}
