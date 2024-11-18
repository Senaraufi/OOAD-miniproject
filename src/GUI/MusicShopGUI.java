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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

public class MusicShopGUI extends JFrame {
    private Customer customer;
    private List<Album> availableAlbums;
    private DefaultListModel<Album> cartListModel;
    private JList<Album> albumList;
    private JList<Album> cartList;
    private JLabel totalLabel;
    private JLabel messageLabel;
    private static final String IMAGE_PATH = "resources/images/"; // Base path for album images

    public MusicShopGUI() {
        initializeShop();
        setupGUI();
    }

    private void initializeShop() {
        // Initialize customer
        customer = new Customer("Guest");

        // Initialize available albums
        availableAlbums = new ArrayList<>();
        availableAlbums.add(new Album("Greatest Hits", "Queen", Genre.ROCK, 29.99, "queen.jpg"));
        availableAlbums.add(new Album("Thriller", "Michael Jackson", Genre.POP, 24.99, "thriller.jpg"));
        availableAlbums.add(new Album("Dark Side of the Moon", "Pink Floyd", Genre.ROCK, 19.99, "dark_side.jpg"));
        availableAlbums.add(new Album("Back in Black", "AC/DC", Genre.ROCK, 21.99, "back_in_black.jpg")); 
        availableAlbums.add(new Album("21", "Adele", Genre.POP, 18.99, "adele_21.jpg"));

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
            
            try {
                String imagePath = getImagePath(selectedAlbum.getImageFileName());
                File imageFile = new File(imagePath);
                
                if (!imageFile.exists()) {
                    messageLabel.setText("Image not found at: " + imagePath);
                    return;
                }

                ImageIcon albumImageIcon = new ImageIcon(imagePath);
                
                // Scale the image while maintaining aspect ratio
                if (albumImageIcon.getIconWidth() > 0) {
                    int maxSize = 200;
                    int width = albumImageIcon.getIconWidth();
                    int height = albumImageIcon.getIconHeight();
                    double scale = Math.min((double) maxSize / width, (double) maxSize / height);
                    
                    int scaledWidth = (int) (width * scale);
                    int scaledHeight = (int) (height * scale);
                    
                    Image scaledImage = albumImageIcon.getImage()
                        .getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
                    
                    JLabel albumImageLabel = new JLabel(new ImageIcon(scaledImage));
                    albumImageLabel.setHorizontalAlignment(JLabel.CENTER);
                    
                    JPanel imagePanel = new JPanel(new BorderLayout());
                    imagePanel.add(albumImageLabel, BorderLayout.CENTER);
                    imagePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    
                    JOptionPane.showMessageDialog(this, imagePanel,
                        "Added to Cart: " + selectedAlbum.getTitle(),
                        JOptionPane.PLAIN_MESSAGE);
                } else {
                    messageLabel.setText("Failed to load image: " + selectedAlbum.getImageFileName());
                }
            } catch (Exception e) {
                messageLabel.setText("Error loading image: " + e.getMessage());
                e.printStackTrace();
            }

            updateTotalLabel();
            messageLabel.setText("Added: " + selectedAlbum.getTitle());
        }
    }

    private void removeFromCart() {
        int selectedIndex = cartList.getSelectedIndex();
        if (selectedIndex != -1) {
            Album removedAlbum = cartListModel.getElementAt(selectedIndex);
            cartListModel.remove(selectedIndex);
            updateTotalLabel();
            messageLabel.setText("Removed: " + removedAlbum.getTitle());
        } else {
            messageLabel.setText("Please select an item to remove from the cart");
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
        double total = 0.0;
        for (int i = 0; i < cartListModel.getSize(); i++) {
            Album album = cartListModel.getElementAt(i);
            total += album.getPrice();
        }
        totalLabel.setText(String.format("Total: $%.2f", total));
    }

    private String getImagePath(String fileName) {
        // Get the absolute path to the project root
        String projectPath = System.getProperty("user.dir");
        // Construct the full path to the image
        return projectPath + File.separator + "src" + File.separator + IMAGE_PATH + fileName;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MusicShopGUI().setVisible(true);
        });
    }
}
