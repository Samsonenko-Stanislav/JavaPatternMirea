package ru.mirea.Task6;

class Factory {
    public Device getCurrentDev(String inputdev) {
        Device device = null;
        if (inputdev.equals("laptop")) {
            device = new laptopDev();
        } else if (inputdev.equals("phone")) {
            device = new phoneDev();
        } else if (inputdev.equals("tablet")) {
            device = new tabletDev();
        }
        return device;
    }
}
interface Device {
    void getDevice();
}
class laptopDev implements Device {
    public void getDevice() {
        System.out.println("применить для ноутбука");
    }
}
class phoneDev implements Device {
    public void getDevice() {
        System.out.println("применить для телефона");
    }
}
class tabletDev implements Device {
    public void getDevice() {
        System.out.println("применить для планшета");
    }
}

class FactoryTest {
    public static void main(String[] args){
        String mydev = "laptop";
        Factory factory = new Factory();
        Device dev = factory.getCurrentDev(mydev);
        dev.getDevice();
    }
}
