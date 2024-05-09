import java.util.Scanner;

public class ShoppingBasket {
    int p=100;
    String[] items=new String[p];
    double[] prices=new double[p];
    int itemCount=0;



    public void append(String item, double price) {

        items[itemCount] = item;
        prices[itemCount] = price;
        itemCount++;
        System.out.println(item + " added to the basket.");

    }

    public void delete(int index) {
        if (index < 0 || index >= itemCount) {
            System.out.println("Invalid index.");
            return;
        }

        for (int i = index; i < itemCount - 1; i++) {
            items[i] = items[i + 1];
            prices[i] = prices[i + 1];
        }

        items[itemCount - 1] = null;
        prices[itemCount - 1] = 0;
        itemCount--;
        System.out.println("Item at index " + index + " deleted from the basket.");
    }

    public void insert(int index, String item, double price) {

        if (index < 0 || index > itemCount) {
            System.out.println("Invalid index.");
            return;
        }

        if (itemCount == items.length) {
            System.out.println("Basket is full. Cannot insert more items.");
            return;
        }
        for (int i = itemCount - 1; i >= index; i--) {
            items[i + 1] = items[i];
            prices[i + 1] = prices[i];
        }

        items[index] = item;
        prices[index] = price;
        itemCount++;
        System.out.println(item + " inserted at index " + index + ".");
    }

    public void remove(String item) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i]==item) {
                delete(i);
                return;
            }
        }
        System.out.println("Item not found in the basket.");
    }

    public double checkout() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];

        }
        System.out.println("Total amount to pay: $" + total);
        return total;
    }
    public int getItemCount() {
        return itemCount;
    }
    public String[] getItems() {
        return items;
    }

    public double[] getPrices() {
        return prices;
    }


    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        ShoppingBasket basket = new ShoppingBasket();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Append");
            System.out.println("2. Delete");
            System.out.println("3. Insert");
            System.out.println("4. Remove");
            System.out.println("5. View Cart");
            System.out.println("6. Search");
            System.out.println("7. Checkout");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String item = scan.nextLine();
                    System.out.print("Enter item price: ");
                    double price = scan.nextDouble();
                    basket.append(item, price);
                    break;
                case 2:
                    System.out.print("Enter index to delete: ");
                    int index = scan.nextInt();
                    basket.delete(index);
                    break;
                case 3:
                    System.out.print("Enter index to insert: ");
                    int insIndex = scan.nextInt();
                    scan.nextLine(); // Consume newline
                    System.out.print("Enter item name: ");
                    String insItem = scan.nextLine();
                    System.out.print("Enter item price: ");
                    double insPrice = scan.nextDouble();
                    basket.insert(insIndex, insItem, insPrice);
                    break;
                case 4:
                    System.out.print("Enter item to remove: ");
                    String remItem = scan.nextLine();
                    basket.remove(remItem);
                    break;
                case 7:
                    basket.checkout();
                    break;
                case 8:
                    System.out.println("Thank you for using the shopping basket!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        }
    }
}
