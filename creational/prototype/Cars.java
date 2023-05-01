package creational.prototype;

interface Car {
    Car clone();
    void own();
}

class SportsCar implements Car {
    @Override
    public Car clone() {
        return new SportsCar();
    }

    @Override
    public void own() {
        System.out.println("Owning a sports car");
    }
}

class LuxuryCar implements Car {
    @Override
    public Car clone() {
        return new LuxuryCar();
    }

    @Override
    public void own() {
        System.out.println("Owning a luxury car");
    }
}

public class Cars {
    public static void main(String[] args) {
        Car car1 = new SportsCar();
        Car car2 = car1.clone();
        car1.own();
        car2.own();

        Car car3 = new LuxuryCar();
        Car car4 = car3.clone();
        car3.own();
        car4.own();
    }
}
