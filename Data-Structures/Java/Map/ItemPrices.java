/* Design a data structure for item prices */

import java.util.*;

public class ItemPrices {
    private TreeMap<String, Double> itemPrices;
    
    public ItemPrices() {
        itemPrices = new TreeMap<>();
    }
    
    public void addItem(String itemName, double price) {
        itemPrices.put(itemName, price);
    }

    public void updatePrice(String itemName, double newPrice) {
        if (itemPrices.containsKey(itemName)) {
            itemPrices.put(itemName, newPrice);
        } else {
            System.out.println("Item does not exist.");
        }
    }

    public void removeItem(String itemName) {
        if (itemPrices.containsKey(itemName)) {
            itemPrices.remove(itemName);
        } else {
            System.out.println("Item does not exist.");
        }
    }

    public Double getPrice(String itemName) {
        return itemPrices.get(itemName);
    }

    public void displayAllItems() {
        for (Map.Entry<String, Double> entry : itemPrices.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    public void displayItemsInPriceRange(double minPrice, double maxPrice) {
        for (Map.Entry<String, Double> entry : itemPrices.entrySet()) {
            if (entry.getValue() >= minPrice && entry.getValue() <= maxPrice) {
                System.out.println(entry.getKey() + ": $" + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        ItemPrices manager = new ItemPrices();

        manager.addItem("Apple", 1.99);
        manager.addItem("Banana", 0.99);
        manager.addItem("Orange", 2.49);
        manager.addItem("Milk", 3.19);
        manager.addItem("Bread", 2.89);

        System.out.println("All items:");
        manager.displayAllItems();

        manager.updatePrice("Banana", 1.29);
        System.out.println("\nUpdated price for Banana:");
        System.out.println("Banana: $" + manager.getPrice("Banana"));

        System.out.println("\nItems in price range $1.00 to $3.00:");
        manager.displayItemsInPriceRange(1.00, 3.00);

        manager.removeItem("Orange");
        System.out.println("\nAll items after removing Orange:");
        manager.displayAllItems();
    }
}
