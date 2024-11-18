package GUI;

import Enums.Genre;
import Model.Album;
import Model.Customer;
import Model.Sale;
import Exceptions.PurchaseLimitException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MusicShopGUI extends JFrame {
    private Customer customer;
    private List<Album> availableAlbums;
    private DefaultListModel<Album> cartListModel;
    private JList<Album> albumList;
    private JList<Album> cartList;
    private JLabel totalLabel;
    private JLabel messageLabel;

    public MusicShopGUI() {
        initializeShop();
        setupGUI();
    }

    private void initializeShop() {
        // Initialize customer
        customer = new Customer("Guest");
        
        // Initialize available albums
        availableAlbums = new ArrayList<>();
        availableAlbums.add(new Album("Greatest Hits", "Queen", Genre.ROCK));
        availableAlbums.add(new Album("Thriller", "Michael Jackson", Genre.POP));
        availableAlbums.add(new Album("Dark Side of the Moon", "Pink Floyd", Genre.ROCK));
        availableAlbums.add(new Album("Back in Black", "AC/DC", Genre.ROCK));
        availableAlbums.add(new Album("21", "Adele", Genre.POP));
        
        cartListModel = new DefaultListModel<>();
    }

    private void setupGUI() {
        setTitle("Music Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(800, 600));

        // Create main panels
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JPanel leftPanel = new JPanel(new BorderLayout(5, 5));
        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));

        // Available Albums Section
        leftPanel.setBorder(BorderFactory.createTitledBorder("Available Albums"));
        DefaultListModel<Album> albumListModel = new DefaultListModel<>();
        availableAlbums.forEach(albumListModel::addElement);
        albumList = new JList<>(albumListModel);
        albumList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane albumScrollPane = new JScrollPane(albumList);
        leftPanel.add(albumScrollPane, BorderLayout.CENTER);

        // Add to Cart Button
        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.addActionListener(e -> addToCart());
        leftPanel.add(addToCartButton, BorderLayout.SOUTH);

        // Shopping Cart Section
        rightPanel.setBorder(BorderFactory.createTitledBorder("Shopping Cart"));
        cartList = new JList<>(cartListModel);
        JScrollPane cartScrollPane = new JScrollPane(cartList);
        rightPanel.add(cartScrollPane, BorderLayout.CENTER);

        // Cart Controls Panel
        JPanel cartControlsPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        JButton removeFromCartButton = new JButton("Remove from Cart");
        removeFromCartButton.addActionListener(e -> removeFromCart());
        
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(e -> checkout());
        
        totalLabel = new JLabel("Total Items: 0");
        messageLabel = new JLabel(" ");
        messageLabel.setForeground(Color.BLUE);

        cartControlsPanel.add(removeFromCartButton);
        cartControlsPanel.add(checkoutButton);
        cartControlsPanel.add(totalLabel);
        cartControlsPanel.add(messageLabel);
        rightPanel.add(cartControlsPanel, BorderLayout.SOUTH);

        // Add panels to main panel
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        // Add main panel to frame
        add(mainPanel, BorderLayout.CENTER);

        // Top panel for customer info
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel customerLabel = new JLabel("Customer: " + customer.getName());
        topPanel.add(customerLabel);
        add(topPanel, BorderLayout.NORTH);

        pack();
        setLocationRelativeTo(null);
    }

    private void addToCart() {
        Album selectedAlbum = albumList.getSelectedValue();
        if (selectedAlbum != null) {
            cartListModel.addElement(selectedAlbum);
            updateTotalLabel();
            messageLabel.setText("Added: " + selectedAlbum.getTitle());
        }
    }

    private void removeFromCart() {
        int selectedIndex = cartList.getSelectedIndex();
        if (selectedIndex != -1) {
            Album removedAlbum = cartListModel.remove(selectedIndex);
            updateTotalLabel();
            messageLabel.setText("Removed: " + removedAlbum.getTitle());
        }
    }

    private void checkout() {
        if (cartListModel.isEmpty()) {
            messageLabel.setText("Cart is empty!");
            return;
        }

        try {
            for (int i = 0; i < cartListModel.size(); i++) {
                Album album = cartListModel.getElementAt(i);
                customer.purchaseAlbum(album);
                new Sale(customer, album, new Date());
            }
            messageLabel.setText("Checkout successful! Thank you for your purchase.");
            cartListModel.clear();
            updateTotalLabel();
        } catch (PurchaseLimitException e) {
            messageLabel.setText("Error: " + e.getMessage());
        }
    }

    private void updateTotalLabel() {
        totalLabel.setText("Total Items: " + cartListModel.size());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MusicShopGUI().setVisible(true);
        });
    }
}
