package structural.facade;

class HardDrive {
    public byte[] read(long block, int size) {
        System.out.println("Size " + size + " from HardDrive read " + block);
        return new byte[size];
    }
}

class Memory {
    public void load(long position, byte[] data) { 
        System.out.println("Memory loading data at ... " + position);
    }
}

class CPU {
    public void freeze() { System.out.println("Freezed CPU"); }
    public void execute() { System.out.println("CPU is executed"); }
}

// Facade class
class Computer {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;
    
    public Computer() {
        cpu = new CPU();
        memory = new Memory();
        hardDrive = new HardDrive();
    }
    
    public void startComputer() {
        cpu.freeze();
        memory.load(0, hardDrive.read(20, 100));
        cpu.execute();
    }
}

public class Device {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startComputer();
    }
}
