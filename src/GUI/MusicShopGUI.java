package GUI;

import Enums.Genre;
import Model.Album;
import Model.Customer;
import Model.Sale;
import Exceptions.PurchaseLimitException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.File;

public class MusicShopGUI extends JFrame {
    private Customer customer;
    private List<Album> availableAlbums;
    private DefaultListModel<Album> cartListModel;
    private JList<Album> vinylAlbumList;
    private JList<Album> cdAlbumList;
    private JList<Album> cartList;
    private JLabel totalLabel;
    private JLabel messageLabel;
    private static final String IMAGE_PATH = "src/resources/images/"; // Base path for album images
    private JTabbedPane tabbedPane;
    private JPanel cartPanel;

    public MusicShopGUI() {
        initializeShop();
        setupGUI();
    }

    private void initializeShop() {
        // Initialize customer
        customer = new Customer("Guest");

        // Initialize available albums
        availableAlbums = new ArrayList<>();
        availableAlbums.add(new Album("Greatest Hits", "Queen", Genre.ROCK, 29.99, "queen.jpeg"));
        availableAlbums.add(new Album("Thriller", "Michael Jackson", Genre.POP, 24.99, "thriller.jpg"));
        availableAlbums.add(new Album("Dark Side of the Moon", "Pink Floyd", Genre.ROCK, 19.99, "dark_side.jpg"));
        availableAlbums.add(new Album("Back in Black", "AC/DC", Genre.ROCK, 21.99, "back_in_black.jpg")); 
        availableAlbums.add(new Album("21", "Adele", Genre.POP, 18.99, "adele_21.jpg"));
        availableAlbums.add(new Album("The Rise and Fall Of A Midwest Princess", "Chappell Roan", Genre.POP, 35.50, "chappellRoan.jpeg"));
        availableAlbums.add(new Album("Hypnotize", "System of A Down", Genre.ROCK, 25.00, "SOAD.jpeg"));
        availableAlbums.add(new Album("In Utero", "Nirvana", Genre.ROCK, 22.00, "nirvana.jpg"));
        availableAlbums.add(new Album("Born This Way (Signed Edition)", "Lady Gaga", Genre.POP, 25.00, "ladygaga.jpg"));
        availableAlbums.add(new Album("The Marshall Mathers LP", "Eminem", Genre.RAP, 20.00, "eminem.png"));
        availableAlbums.add(new Album("OK Computer", "Radiohead", Genre.ROCK, 15.00, "radiohead.jpeg"));
        availableAlbums.add(new Album("Mellie Collie and The Infinite Sadness", "The Smashing Pumpkins", Genre.ROCK, 19.99, "thesmashingpumkins.jpg"));
        availableAlbums.add(new Album("Doolittle", "Pixies", Genre.ROCK, 15.00, "pixies.jpg"));
        availableAlbums.add(new Album("Speak for Yourself", "Imogen Heap", Genre.ELECTRONIC, 18.00, "imogenheap.jpg"));
        availableAlbums.add(new Album("Grace", "Jeff Buckley", Genre.ROCK, 15.00, "jeffbuckley.jpeg"));
        availableAlbums.add(new Album("Weezer (Blue Album)", "Weezer", Genre.ROCK, 15.00, "weezer.jpg"));
        availableAlbums.add(new Album("The White Album", "The Beatles", Genre.ROCK, 15.00, "thebeatles.png"));
        availableAlbums.add(new Album("Graduation", "Kanye West", Genre.RAP, 15.00, "kanyewest.jpg"));
        availableAlbums.add(new Album("The Colour and the Shape", "Foo Fighters", Genre.ROCK, 23.99, "foofighters.jpeg"));
        availableAlbums.add(new Album("Rumours", "Fleetwood Mac", Genre.ROCK, 22.99, "fleetwoodmac.jpeg"));
        availableAlbums.add(new Album("Blue", "Joni Mitchell", Genre.FOLK, 15.00, "jonimitchell.jpg"));
        availableAlbums.add(new Album("Goo", "Sonic Youth", Genre.ROCK, 15.00, "sonicyouth.png"));
        availableAlbums.add(new Album("Tidal", "Fiona Apple", Genre.POP, 15.00, "fionaapple.jpg"));
        availableAlbums.add(new Album("Dreaming", "Andre Rieu", Genre.CLASSICAL, 15.00, "andrerieu.jpg"));
        availableAlbums.add(new Album("Come Away With Me", "Norah Jones", Genre.JAZZ, 15.00, "norahjones.jpeg"));
        
        cartListModel = new DefaultListModel<>();
    }

    private void setupGUI() {
        setTitle("Music Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(1000, 600));

        // Create main panels
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        JPanel catalogPanel = new JPanel(new BorderLayout(10, 10));
        cartPanel = createCartPanel();

        // Create tabbed pane for catalogs
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Vinyl", createFormatPanel(true));
        tabbedPane.addTab("CD", createFormatPanel(false));
        catalogPanel.add(tabbedPane, BorderLayout.CENTER);

        // Top panel for customer info
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel customerLabel = new JLabel("Customer: " + customer.getName());
        topPanel.add(customerLabel);

        // Add panels to frame
        mainPanel.add(catalogPanel, BorderLayout.CENTER);
        mainPanel.add(cartPanel, BorderLayout.EAST);
        
        add(topPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createCartPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Shopping Cart"));
        panel.setPreferredSize(new Dimension(300, getHeight()));

        // Create cart list
        cartList = new JList<>(cartListModel);
        cartList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        cartList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Album album = (Album) value;
                String displayText = String.format("%s - %s ($%.2f)", album.getTitle(), 
                    tabbedPane.getSelectedIndex() == 0 ? "Vinyl" : "CD", album.getPrice());
                return super.getListCellRendererComponent(list, displayText, index, isSelected, cellHasFocus);
            }
        });
        JScrollPane cartScrollPane = new JScrollPane(cartList);
        panel.add(cartScrollPane, BorderLayout.CENTER);

        // Cart controls
        JPanel controlsPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        JButton removeButton = new JButton("Remove from Cart");
        removeButton.addActionListener(e -> removeFromCart());

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(e -> checkout());

        totalLabel = new JLabel("Total: $0.00 (0 items)");
        messageLabel = new JLabel(" ");
        messageLabel.setForeground(Color.BLUE);

        controlsPanel.add(removeButton);
        controlsPanel.add(checkoutButton);
        controlsPanel.add(totalLabel);
        controlsPanel.add(messageLabel);
        panel.add(controlsPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createFormatPanel(boolean isVinyl) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        String formatName = isVinyl ? "Vinyl" : "CD";
        panel.setBorder(BorderFactory.createTitledBorder("Available " + formatName + "s"));

        // Create album list
        DefaultListModel<Album> albumListModel = new DefaultListModel<>();
        availableAlbums.forEach(album -> {
            // Calculate CD price: 40% of vinyl price, rounded to nearest 50 cents
            double cdPrice = Math.round(album.getPrice() * 0.4 * 2) / 2.0;
            Album formatAlbum = new Album(
                album.getTitle(), 
                album.getArtist(), 
                album.getGenre(), 
                isVinyl ? album.getPrice() : cdPrice,
                album.getImageFileName()
            );
            albumListModel.addElement(formatAlbum);
        });

        JList<Album> albumList;
        if (isVinyl) {
            vinylAlbumList = new JList<>(albumListModel);
            albumList = vinylAlbumList;
        } else {
            cdAlbumList = new JList<>(albumListModel);
            albumList = cdAlbumList;
        }
        albumList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(albumList);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add to Cart button
        JButton addButton = new JButton("Add to Cart");
        addButton.addActionListener(e -> addToCart(isVinyl));
        panel.add(addButton, BorderLayout.SOUTH);

        return panel;
    }

    private void addToCart(boolean isVinyl) {
        JList<Album> albumList = isVinyl ? vinylAlbumList : cdAlbumList;
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
                        "Added to Cart: " + selectedAlbum.getTitle() + " (" + (isVinyl ? "Vinyl" : "CD") + ")",
                        JOptionPane.PLAIN_MESSAGE);
                } else {
                    messageLabel.setText("Failed to load image: " + selectedAlbum.getImageFileName());
                }
            } catch (Exception e) {
                messageLabel.setText("Error loading image: " + e.getMessage());
                e.printStackTrace();
            }

            updateTotalLabel();
            messageLabel.setText("Added: " + selectedAlbum.getTitle() + " (" + (isVinyl ? "Vinyl" : "CD") + ")");
        }
    }

    private void removeFromCart() {
        int[] selectedIndices = cartList.getSelectedIndices();
        if (selectedIndices.length > 0) {
            List<Album> albumsToRemove = new ArrayList<>();
            for (int index : selectedIndices) {
                albumsToRemove.add(cartListModel.getElementAt(index));
            }
            for (Album album : albumsToRemove) {
                cartListModel.removeElement(album);
            }
            updateTotalLabel();
            messageLabel.setText("Removed selected items from cart");
        } else {
            messageLabel.setText("Please select items to remove from cart");
        }
    }

    private void checkout() {
        if (cartListModel.isEmpty()) {
            messageLabel.setText("Cart is empty!");
            return;
        }

        double total = 0;
        List<Album> purchasedAlbums = new ArrayList<>();
        for (int i = 0; i < cartListModel.size(); i++) {
            Album album = cartListModel.getElementAt(i);
            total += album.getPrice();
            purchasedAlbums.add(album);
        }

        // Create individual sales for each album
        for (Album album : purchasedAlbums) {
            new Sale(customer, album, new Date());
        }
        
        String message = String.format("Thank you for your purchase!%nTotal: $%.2f", total);
        JOptionPane.showMessageDialog(this, message, "Purchase Complete", JOptionPane.INFORMATION_MESSAGE);
        cartListModel.clear();
        updateTotalLabel();
        messageLabel.setText("Purchase completed successfully!");
    }

    private void updateTotalLabel() {
        double total = 0;
        for (int i = 0; i < cartListModel.size(); i++) {
            total += cartListModel.getElementAt(i).getPrice();
        }
        totalLabel.setText(String.format("Total: $%.2f (%d items)", total, cartListModel.size()));
    }

    private String getImagePath(String imageFileName) {
        return IMAGE_PATH + imageFileName;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MusicShopGUI().setVisible(true);
        });
    }
}
