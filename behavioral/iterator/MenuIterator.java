package behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MenuIterator {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Gnocchi", 387));
        menuItems.add(new MenuItem("Pizza", 754));
        menuItems.add(new MenuItem("Pancakes", 289));
        menuItems.add(new MenuItem("Salad", 89));
    
        // Iterator
        Iterator<MenuItem> iterator = menuItems.iterator();
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            System.out.println(item.getName() + " has " + item.getCalories() + " kcal");
        }
    }
}

class MenuItem {
    private String name;
    private int calories;

    public MenuItem(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }
}
