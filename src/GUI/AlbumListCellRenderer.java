package GUI;

import Model.Album;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class AlbumListCellRenderer extends JPanel implements ListCellRenderer<Album> {
    private JLabel imageLabel = new JLabel();
    private JLabel textLabel = new JLabel();
    private static final int IMAGE_SIZE = 100;

    public AlbumListCellRenderer() {
        setLayout(new BorderLayout(5, 5));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        imageLabel.setPreferredSize(new Dimension(IMAGE_SIZE, IMAGE_SIZE));
        add(imageLabel, BorderLayout.WEST);
        add(textLabel, BorderLayout.CENTER);
    }

    private ImageIcon loadAlbumCover(String imageFileName) {
        try {
            String imagePath = "src/resources/images/" + imageFileName;
            Image img = ImageIO.read(new File(imagePath));
            if (img != null) {
                Image scaledImg = img.getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_SMOOTH);
                return new ImageIcon(scaledImg);
            }
        } catch (IOException e) {
            System.err.println("Error loading image: " + imageFileName);
        }
        // Return a default icon if image loading fails
        return new ImageIcon(new byte[0]); // Empty icon
    }

    @Override
    public Component getListCellRendererComponent(
            JList<? extends Album> list,
            Album album,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        
        imageLabel.setIcon(loadAlbumCover(album.getImageFileName()));
        textLabel.setText(String.format("<html>%s<br>by %s<br>Genre: %s</html>", 
            album.getTitle(), album.getArtist(), album.getGenre()));

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
            textLabel.setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
            textLabel.setForeground(list.getForeground());
        }

        setEnabled(list.isEnabled());
        setFont(list.getFont());
        
        return this;
    }
}
