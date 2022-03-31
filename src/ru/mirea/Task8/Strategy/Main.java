package ru.mirea.Task8.Strategy;

abstract class Car {
    private Drivable drivable;

    public void setDrivable(Drivable drivable){
        this.drivable = drivable;
    }

    public void performDrive(){
        drivable.drive();
    }

}

interface Drivable{
    public void drive();
}

class FullWheelDrive implements Drivable{
    public void drive(){
        System.out.println("Full wheel drive");
    }
}

class RearWheelDrive implements Drivable{
    public void drive(){
        System.out.println("Rear wheel drive");
    }
}

class RearCar extends Car {
    public RearCar(){
        setDrivable(new RearWheelDrive());
    }
}

class FullCar extends Car {
    public FullCar(){
        setDrivable(new FullWheelDrive());
    }
}

public class Main{
    public static void main(String[] args) {
        Car f = new FullCar();
        f.performDrive();
        f.setDrivable(new RearWheelDrive());
        f.performDrive();
    }
}