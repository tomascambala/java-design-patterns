package structural.adapter;

interface Movable {
    double getSpeed();
}

class Car implements Movable {
    private double speed;

    public Car(double speed) {
        this.speed = speed;
    }

    @Override
    public double getSpeed() {
        return speed;
    }
}

interface MovableAdapter {
    double getSpeed();
}

class MovableAdapterImpl implements MovableAdapter {
    private Movable car;

    public MovableAdapterImpl(Movable car) {
        this.car = car;
    }

    @Override
    public double getSpeed() {
        return convertMPHtoKMPH(car.getSpeed());
    }

    private double convertMPHtoKMPH(double mph) {
        return mph * 1.60934;
    }
}

class Client {
    public static void main(String[] args) {
        Movable car = new Car(65);
        MovableAdapter adapter = new MovableAdapterImpl(car);
        System.out.println("Moving speed is " + adapter.getSpeed()  + " km/h:");
    }
}
