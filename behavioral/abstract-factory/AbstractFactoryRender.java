// Abstract Factory interface
interface GUIFactory {
    Button createButton();
    TextField createTextField();
}

// Abstract Product 1
interface Button {
    void render();
}

// Abstract Product 2
interface TextField {
    void render();
}

// Concrete Factory 1
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public TextField createTextField() {
        return new WindowsTextField();
    }
}

// Concrete Factory 2
class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextField createTextField() {
        return new MacTextField();
    }
}

// Concrete Product 1A
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("WindowsButton...");
    }
}

// Concrete Product 1B
class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("MacButton...");
    }
}

// Concrete Product 2A
class WindowsTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Windows text field...");
    }
}

// Concrete Product 2B
class MacTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Mac text field...");
    }
}

// Client
public class AbstractFactoryRender {
    public static void main(String[] args) {
    
        GUIFactory windowsFactory = new WindowsFactory();
        Button windowsButton = windowsFactory.createButton();
        TextField windowsTextField = windowsFactory.createTextField();
        
        windowsButton.render();
        windowsTextField.render();

        GUIFactory macFactory = new MacFactory();
        Button macButton = macFactory.createButton();
        TextField macTextField = macFactory.createTextField();

        macButton.render();
        macTextField.render();
    }
}
