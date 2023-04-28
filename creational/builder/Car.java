package creational.builder;

public class Car {
    private String make;
    private String model;
    private int year;
    private int mileage;
    private int numDoors;
    private boolean hasSunroof;
    
    private Car(CarBuilder builder) {
        this.make = builder.make;
        this.model = builder.model;
        this.year = builder.year;
        this.mileage = builder.mileage;
        this.numDoors = builder.numDoors;
        this.hasSunroof = builder.hasSunroof;
    }
    
    public static class CarBuilder {
        private String make;
        private String model;
        private int year;
        private int mileage;
        private int numDoors;
        private boolean hasSunroof;
        
        public CarBuilder(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }
        
        public CarBuilder setMileage(int mileage) {
            this.mileage = mileage;
            return this;
        }
        
        public CarBuilder setNumDoors(int numDoors) {
            this.numDoors = numDoors;
            return this;
        }
        
        public CarBuilder setHasSunroof(boolean hasSunroof) {
            this.hasSunroof = hasSunroof;
            return this;
        }
        
        public Car build() {
            return new Car(this);
        }
    }
    
    public String getMake() {
        return make;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getYear() {
        return year;
    }
    
    public int getMileage() {
        return mileage;
    }
    
    public int getNumDoors() {
        return numDoors;
    }
    
    public boolean getHasSunroof() {
        return hasSunroof;
    }
}

class Main {
    public static void main(String[] args) {
        Car car = new Car.CarBuilder("Skoda", "Felicia", 1994)
                        .setMileage(80000)
                        .setNumDoors(4)
                        .setHasSunroof(false)
                        .build();
        
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Mileage: " + car.getMileage());
        System.out.println("Number of Doors: " + car.getNumDoors());
        System.out.println("Has Sunroof: " + car.getHasSunroof());
    }
}
