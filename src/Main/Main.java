
package Main;

import Enums.Genre;
import Model.Album;
import Model.CD;

import java.util.ArrayList;
import java.util.List;

/**
 * Main entry point for the application.
 * Initializes the system and demonstrates its functionality.
 * 
 * @param args Command line arguments (not used)
 */
public final class Main {
    /**
     * Main entry point for the application.
     * Initializes the system and demonstrates its functionality.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("\n=== Music Store Management System ===\n");

        // Initialize available albums
        List<Album> availableAlbums = new ArrayList<>();
        availableAlbums.add(new Album("Greatest Hits", "Queen", Genre.ROCK, 29.99, "queen.jpg"));
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
        availableAlbums.add(new Album("Mellie Collie and The Infinite Sadness", "The Smashing Pumpkins", Genre.ROCK, 19.99, "smashingpumpkins.jpg"));
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
        availableAlbums.add(new Album("Come Away With Me", "Norah Jones", Genre.JAZZ, 15.00, "norahjones.jpg"));

        // Initialize available CDs
        List<CD> availableCDs = new ArrayList<>();
        availableCDs.add(new CD("OK Computer", "Radiohead", Genre.ROCK, 19.99, "ok_computer.jpg", 12, "53:21"));
        availableCDs.add(new CD("Blue", "Joni Mitchell", Genre.FOLK, 15.99, "blue.jpg", 10, "35:41"));
        availableCDs.add(new CD("Kind of Blue", "Miles Davis", Genre.JAZZ, 17.99, "kind_of_blue.jpg", 5, "45:44"));

        // Print available albums
        System.out.println("Available Albums:");
        System.out.println("-----------------");
        for (int i = 0; i < availableAlbums.size(); i++) {
            System.out.println((i + 1) + ". " + availableAlbums.get(i));
        }
        System.out.println();

        // Print available CDs
        System.out.println("Available CDs:");
        System.out.println("----------------");
        for (int i = 0; i < availableCDs.size(); i++) {
            System.out.println((i + 1) + ". " + availableCDs.get(i));
        }
        System.out.println();

        System.out.println("\n=== End of Program ===\n");
    }
}
