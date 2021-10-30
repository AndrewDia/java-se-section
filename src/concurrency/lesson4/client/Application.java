package concurrency.lesson4.client;

import concurrency.lesson4.inventory.InventoryManager;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        InventoryManager manager = new InventoryManager();
        Thread inventoryTask = new Thread() {
            @Override
            public void run() {
                manager.populateSoldProducts();
            }
        };
        Thread displayTask = new Thread() {
            @Override
            public void run() {
                manager.displaySoldProducts();
            }
        };
        inventoryTask.start();
        Thread.sleep(2000);
        displayTask.start();
    }
}
