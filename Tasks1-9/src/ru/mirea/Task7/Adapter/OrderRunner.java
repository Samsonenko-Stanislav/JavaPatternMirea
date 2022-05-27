package ru.mirea.Task7.Adapter;

public class OrderRunner {
    public static void main(String[] args) {
    Adapter a = new Adapter();
    a.addOrd();
    a.cookOrd();
    a.deliverOrd();
    a.removeOrd();
    }
}
