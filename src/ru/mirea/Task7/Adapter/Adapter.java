package ru.mirea.Task7.Adapter;


public class Adapter extends JavaApp implements Order {
    @Override
    public void add() {
        addOrd();
    }

    @Override
    public void cook() {
        cookOrd();
    }

    @Override
    public void deliver() {
        deliverOrd();
    }

    @Override
    public void remove() {
        removeOrd();
    }
}
