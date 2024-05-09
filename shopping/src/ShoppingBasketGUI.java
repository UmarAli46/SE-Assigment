import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShoppingBasketGUI extends JFrame {
    private DefaultListModel<String> itemListModel;
    private JList<String> itemList;
    private JScrollPane scrollPane;
    private JTextField itemField;
    private JTextField priceField;
    private JButton addButton;
    private JButton deleteButton;
    private JButton checkoutButton;
    private JButton exitButton;
    private ShoppingBasket basket;

    public ShoppingBasketGUI() {
        setTitle("Shopping Basket");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        itemListModel = new DefaultListModel<>();
        itemList = new JList<>(itemListModel);
        scrollPane = new JScrollPane(itemList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        JLabel itemLabel = new JLabel("Item:");
        inputPanel.add(itemLabel);
        itemField = new JTextField();
        inputPanel.add(itemField);

        JLabel priceLabel = new JLabel("Price:");
        inputPanel.add(priceLabel);
        priceField = new JTextField();
        inputPanel.add(priceField);

        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });
        inputPanel.add(addButton);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteItem();
            }
        });
        inputPanel.add(deleteButton);

        checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkout();
            }
        });
        inputPanel.add(checkoutButton);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        inputPanel.add(exitButton);

        add(inputPanel, BorderLayout.SOUTH);

        basket = new ShoppingBasket();

        setVisible(true);
    }

    private void addItem() {
        String item = itemField.getText();
        double price = Double.parseDouble(priceField.getText());
        basket.append(item, price);
        updateItemList();
    }

    private void deleteItem() {
        int selectedIndex = itemList.getSelectedIndex();
        if (selectedIndex != -1) {
            basket.delete(selectedIndex);
            updateItemList();
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void checkout() {
        double total = basket.checkout();
        JOptionPane.showMessageDialog(this, "Total amount to pay: $" + total, "Checkout", JOptionPane.INFORMATION_MESSAGE);
    }

    private void updateItemList() {
        itemListModel.clear();
        for (int i = 0; i < basket.getItemCount(); i++) {
            itemListModel.addElement(basket.getItems()[i] + " - $" + basket.getPrices()[i]);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShoppingBasketGUI();
            }
        });
    }
}