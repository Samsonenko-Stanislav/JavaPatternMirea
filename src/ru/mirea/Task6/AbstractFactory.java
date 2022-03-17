package ru.mirea.Task6;

public class AbstractFactory {
    public static void main(String[] args){

        Factory1 factory = new Factory1();
        Chair ordinaryChair = factory.createOrdinaryChair();
        Chair armchair = factory.createArmchair();
        Chair sofa = factory.createSofa();

        ordinaryChair.seat();
        armchair.seat();
        sofa.seat();



    }
}
interface Chair {
    void seat();
}


class OrdinaryChair implements Chair {

    @Override
    public void seat() {
        System.out.println("seat ordinary chair");
    }
}

class ArmChair implements Chair {

    @Override
    public void seat() {
        System.out.println("seat armchair");
    }
}

class Sofa implements Chair {

    @Override
    public void seat() {
        System.out.println("seat sofa");
    }
}
interface AbstraсtFactory{
    Chair createOrdinaryChair();
    Chair createArmchair();
    Chair createSofa();
}

class Factory1 implements AbstraсtFactory {


    @Override
    public Chair createOrdinaryChair() {
        return new OrdinaryChair();
    }

    @Override
    public Chair createArmchair() {
        return new ArmChair();
    }

    @Override
    public Chair createSofa() {
        return new Sofa();
    }

}