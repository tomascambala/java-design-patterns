package structural.composite;

import java.util.ArrayList;
import java.util.List;

interface Component {
    void showPrice();
}

// Leaf class - represent smallest, indivisible elements in the hierarchy
class Leaf implements Component {
    private String name;
    private int price;

    public Leaf(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void showPrice() {
        System.out.println(name + ": $" + price);
    }
}

// Composite class
class Composite implements Component {
    private List<Component> components = new ArrayList<>();
    private String name;

    public Composite(String name) {
        this.name = name;
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    public void showPrice() {
        System.out.println(name);
        for (Component component : components) {
            component.showPrice();
        }
    }
}

public class PriceComposite {
    public static void main(String[] args) {
        Component leaf1 = new Leaf("toy", 97);
        Component leaf2 = new Leaf("robot", 123);
        Component leaf3 = new Leaf("phone", 234);
        Component leaf4 = new Leaf("keyboard", 323);

        Composite composite1 = new Composite("Package 1");
        Composite composite2 = new Composite("Package 2");
        Composite composite3 = new Composite("Package 3");

        composite1.add(leaf1);
        composite1.add(composite2);

        composite2.add(leaf2);
        composite2.add(leaf3);

        composite3.add(leaf4);

        Composite allPackages = new Composite("All Packages");
        allPackages.add(composite1);
        allPackages.add(composite3);

        allPackages.showPrice();
    }
}
