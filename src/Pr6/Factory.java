package Pr6;

interface Vehicle {
    void move();
}

class Car implements Vehicle {

    @Override
    public void move() {
        System.out.println("Car is moving ...");
    }
}

class Bike implements Vehicle {

    @Override
    public void move() {
        System.out.println("Bike is moving ...");
    }
}

abstract class TransportCompany {
    abstract Vehicle createVehicle();
}

class CarCompany extends TransportCompany {

    @Override
    Vehicle createVehicle() {
        return new Car();
    }
}
class BikeCompany extends TransportCompany {

    @Override
    Vehicle createVehicle() {
        return new Bike();
    }
}

class Test1 {
    public static void main(String[] args) {
        TransportCompany carCompany = new CarCompany();
        TransportCompany bikeCompany = new BikeCompany();
        Vehicle car = carCompany.createVehicle();
        car.move();
        Vehicle bike = bikeCompany.createVehicle();
        bike.move();
    }
}