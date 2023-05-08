package behavioral.command;

interface Command {
    void execute();
    void fly();
}

class Dron {
    private boolean isOn = false;

    public void switchOn() {
        isOn = true;
        System.out.println("Dron is turned on");
    }

    public void switchOff() {
        isOn = false;
        System.out.println("Dron is turned off");
    }

    public void fly() {
        isOn = true;
        System.out.println("Dron is in the air and dron is automatically on");
    }

    public boolean isOn() {
        return isOn;
    }
}

//  concrete classes
class SwitchOnCommand implements Command {
    private Dron dron;

    public SwitchOnCommand(Dron dron) {
        this.dron = dron;
    }

    public void execute() {
        dron.switchOn();
    }

    public void fly() {
        dron.fly();
    }
}

class SwitchOffCommand implements Command {
    private Dron dron;

    public SwitchOffCommand(Dron dron) {
        this.dron = dron;
    }

    public void execute() {
        dron.switchOff();
    }

    public void fly() {
        dron.fly();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public void flyButton() {
        command.fly();
    }
}

public class DronExample {
    public static void main(String[] args) {
        Dron dron = new Dron();
        Command switchOnCommand = new SwitchOnCommand(dron);
        Command switchOffCommand = new SwitchOffCommand(dron);
        RemoteControl remote = new RemoteControl();

        remote.setCommand(switchOnCommand);
        remote.pressButton();

        remote.setCommand(switchOffCommand);
        remote.pressButton();
        
        remote.flyButton();
    }
}