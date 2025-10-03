class Inventory {
    private int stock;

    public Inventory(int stock) {
        this.stock = stock;
    }

    public void purchase(String customer) {
        synchronized (this) {  // synchronized block for thread safety
            if (stock > 0) {
                System.out.println(customer + " purchased 1 item. Remaining stock: " + (stock - 1));
                stock--;
            } else {
                System.out.println(customer + " tried to purchase, but stock is empty!");
            }
        }
    }
}

class CustomerThread extends Thread {
    private Inventory inventory;
    private String customerName;

    public CustomerThread(Inventory inventory, String customerName) {
        this.inventory = inventory;
        this.customerName = customerName;
    }

    @Override
    public void run() {
        inventory.purchase(customerName);
    }
}

public class InventoryManagementDemo {
    public static void main(String[] args) {
        Inventory inventory = new Inventory(5); // initial stock = 5

        // Multiple customers (threads) trying to purchase
        Thread c1 = new CustomerThread(inventory, "Customer-1");
        Thread c2 = new CustomerThread(inventory, "Customer-2");
        Thread c3 = new CustomerThread(inventory, "Customer-3");
        Thread c4 = new CustomerThread(inventory, "Customer-4");
        Thread c5 = new CustomerThread(inventory, "Customer-5");
        Thread c6 = new CustomerThread(inventory, "Customer-6");

        // Start threads
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
    }
}
