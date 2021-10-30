package concurrency.lesson4.inventory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventoryManager {
    List<Product> soldProductsList = new CopyOnWriteArrayList<>();

    public void populateSoldProducts() {
        for (int i = 0; i < 300; i++) {
            Product product = new Product(i, "test_product_" + i);
            soldProductsList.add(product);
            System.out.println("ADDED: " + product);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void displaySoldProducts() {
        for (Product product : soldProductsList) {
            System.out.println("PRINTING THE SOLD: " + product);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
