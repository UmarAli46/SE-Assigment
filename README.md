
# Title
### Shopping Basket Program

# Libraries And packages

### javax.swing:
This package provides the GUI components such as JFrame, JList, JScrollPane, JTextField, JButton, and JLabel.
### ava.awt:
This package provides the layout managers such as BorderLayout and GridLayout.
### java.awt.event:
 This package provides the event handling classes such as ActionListener.
## Program Explaination

The program defines a ShoppingBasket class, which represents the shopping basket. 
The class has the following attributes:

items: an array of strings to store the item names.

prices: an array of doubles to store the item prices.

itemCount: an integer to keep track of the number of items in the basket.

### The class has several methods:
append(String item, double price): adds an item to the basket
delete(int index): removes an item at the specified index
checkout(): calculates and displays the total price of the items in the basket
getItemCount(): returns the number of items in the basket
getItems(): returns an array of item names
getPrices(): returns an array of item prices
The main method creates a ShoppingBasket object and enters a loop to handle user input.
### The user is presented with a menu to:
1.Add an item

2.Delete an item

3.Checkout

4.Exit the program


## Explaination for GUI
The program extends the JFrame class to create a GUI window. It has several components:
A JList to display the items in the basket
A JScrollPane to scroll the list
Two JTextField components to input the item name and price
Four JButton components to add, delete, checkout, and exit
A ShoppingBasket object to manage the basket
The program uses event handling to respond to button clicks:
The "Add" button adds an item to the basket and updates the list
The "Delete" button deletes the selected item from the basket and updates the list
The "Checkout" button calculates and displays the total price of the items in the basket
The "Exit" button exits the program
The updateItemList() method updates the list of items in the GUI by clearing the list and adding each item from the ShoppingBasket object.
The main method creates an instance of the ShoppingBasketGUI class and sets it visible.
# Deployment

To deploy this project run

```bash
$git remote add origin https://github.com/UmarAli46/SE-Assigment.git
```


# Authors & CONTRIBUTORS
- [@UmarAli46](https://www.github.com/UmarAli46)(2k23/CSE/149)

- [@AliHassan](https://github.com/AliHassan6842)(2K23/CSE/28)

- [@MajidLeghari](https://www.github.com/MajidLehari)(2K23/CSE/74)



## Screenshots

### Front Page
![Front Page](https://i.ibb.co/hVTQjFs/Screenshot-1.png)

### Item Add Function
![Add](https://i.ibb.co/9y3ZL9m/Screenshot-2.png)

### Item Delete
![Front Page](https://i.ibb.co/BtTMMGb/Screenshot-3.png)

### 
![Front Page](https://i.ibb.co/DVzLZZw/Screenshot-4.png)


