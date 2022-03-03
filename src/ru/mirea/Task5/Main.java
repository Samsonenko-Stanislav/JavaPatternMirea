package ru.mirea.Task5;


public class Main {
    public static void main(String[] args) {
        System.out.println(FirstSingleton.getInstance().toString());
        System.out.println(FirstSingleton.getInstance().toString());
        System.out.println(FirstSingleton.getInstance().toString());

        System.out.println(SecondSingleton.getInstance().toString());
        System.out.println(SecondSingleton.getInstance().toString());
        System.out.println(SecondSingleton.getInstance().toString());

        System.out.println(ThirdSingleton.INSTANCE);
        System.out.println(ThirdSingleton.INSTANCE);
        System.out.println(ThirdSingleton.INSTANCE);
        System.out.println(ThirdSingleton.INSTANCE);
    }
}
