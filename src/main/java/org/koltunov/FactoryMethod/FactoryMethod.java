package org.koltunov.FactoryMethod;

interface IProduction {
    void release();
}

class Car implements IProduction {

    @Override
    public void release() {
        System.out.println("Выпущен легковой автомобиль");
    }
}

class Truck implements IProduction {

    @Override
    public void release() {
        System.out.println("Выпущен грузовой автомобиль");
    }
}

interface IWorkShop {
    IProduction create();
}

class CarWorkShop implements IWorkShop {

    @Override
    public IProduction create() {
        return new Car();
    }
}

class TruckWorkShop implements IWorkShop {

    @Override
    public IProduction create() {
        return new Truck();
    }
}


public class FactoryMethod {
    public static void main(String[] args) {
        IWorkShop creator = new CarWorkShop();
        IProduction car = creator.create();

        creator = new TruckWorkShop();
        IProduction truck = creator.create();

        car.release();
        truck.release();
    }
}
