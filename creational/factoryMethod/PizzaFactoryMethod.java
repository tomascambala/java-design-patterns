package creational.factoryMethod;

interface Pizza {
    void prepare();
    void bake();
    void pack();
}

interface PizzaFactory {
    Pizza createPizza();
}

public class PizzaFactoryMethod {
    public static void main(String[] args) {
        PizzaFactory factory1 = new PizzaFactory() {
            @Override
            public Pizza createPizza() {
                return new MargheritaPizza();
            }
        };
        
        Pizza margherita = factory1.createPizza();
        margherita.prepare();
        margherita.bake();
        margherita.pack();
        
        PizzaFactory factory2 = new PizzaFactory() {
            @Override
            public Pizza createPizza() {
                return new GazdovskaPizza();
            }
        };
        
        Pizza gazdovska = factory2.createPizza();
        gazdovska.prepare();
        gazdovska.bake();
        gazdovska.pack();
    }
}

class MargheritaPizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing Margherita Pizza.");
    }
    public void bake() {
        System.out.println("Baking Margherita Pizza.");
    }
    public void pack() {
        System.out.println("Packing Margherita Pizza.");
    }
}

class GazdovskaPizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing Gazdovska Pizza.");
    }
    public void bake() {
        System.out.println("Baking Gazdovska Pizza.");
    }
    public void pack() {
        System.out.println("Packing Gazdovska Pizza.");
    }
}


