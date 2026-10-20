package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // ---------- Add (overloading) ----------
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (disc == null) {
            System.out.println("Invalid disc.");
            return;
        }
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full. Cannot add \"" + disc.getTitle() + "\".");
            return;
        }
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full.");
        }
    }

    // Overloading by differing the type of parameter: add a list of DVDs
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (dvdList == null) {
            return;
        }
        for (DigitalVideoDisc disc : dvdList) {
            addDigitalVideoDisc(disc);
        }
    }

    /*
     * Varargs version (arbitrary number of arguments).
     * It cannot coexist with addDigitalVideoDisc(DigitalVideoDisc[]) because
     * DigitalVideoDisc... is compiled to DigitalVideoDisc[] -> same signature.
     * If chosen instead of the array version, it would be:
     *
     * public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
     *     for (DigitalVideoDisc disc : dvds) addDigitalVideoDisc(disc);
     * }
     */

    // Overloading by differing the number of parameters
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    // ---------- Remove ----------
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                // shift remaining items to the left
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
                return;
            }
        }
        System.out.println("The disc is not in the cart.");
    }

    // ---------- Cost ----------
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    // ---------- Print ----------
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        }
        System.out.printf("Total cost: %.2f $%n", totalCost());
        System.out.println("***************************************************");
    }

    // ---------- Search ----------
    public void searchById(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found: " + itemsOrdered[i]);
                return;
            }
        }
        System.out.println("No DVD with id " + id + " in the cart.");
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Found: " + itemsOrdered[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD matching \"" + title + "\" in the cart.");
        }
    }
}
