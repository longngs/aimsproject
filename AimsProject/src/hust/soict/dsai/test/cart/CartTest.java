package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // Overloaded add methods
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Frozen", "Animation", "Chris Buck", 102, 21.5f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 26.0f);
        cart.addDigitalVideoDisc(dvd4, dvd5);
        cart.addDigitalVideoDisc(new DigitalVideoDisc[] {
                new DigitalVideoDisc("The Lion Guard"), new DigitalVideoDisc("Toy Story", "Animation", 15.0f) });

        // Test the print method
        cart.print();

        // Test the search methods
        System.out.println("\n-- Search by id 2 --");
        cart.searchById(2);
        System.out.println("-- Search by id 99 --");
        cart.searchById(99);
        System.out.println("-- Search by title \"lion\" --");
        cart.searchByTitle("lion");
        System.out.println("-- Search by title \"WARS story\" --");
        cart.searchByTitle("WARS story");
        System.out.println("-- Search by title \"Titanic\" --");
        cart.searchByTitle("Titanic");

        // Test full cart
        System.out.println("\n-- Fill the cart --");
        for (int i = 0; i < 15; i++) {
            cart.addDigitalVideoDisc(new DigitalVideoDisc("Extra " + i, "Misc", 1f));
        }
    }
}
