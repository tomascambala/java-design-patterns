package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(int temperature);
}

interface WeatherApp {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers();
    void setTemperature(int temperature);
}

class WeatherStation implements WeatherApp {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public int getTemperature() {
        return temperature;
    }
}

class TemperatureDisplay implements Observer {
    private String name;

    public TemperatureDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println("According " + name + " air temperature will change tomorrow for : " + temperature +  " °C");
    }
}

public class WeatherObserver {
    public static void main(String[] args) {
        WeatherApp weatherApp = new WeatherStation();

        Observer broadcast1 = new TemperatureDisplay("Broadcast 1");
        Observer broadcast2 = new TemperatureDisplay("Broadcast 2");

        weatherApp.subscribe(broadcast1);
        weatherApp.subscribe(broadcast2);

        weatherApp.setTemperature(12);

        weatherApp.unsubscribe(broadcast2);

        weatherApp.setTemperature(41);
    }
}
