package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (dvd == null) {
            System.out.println("Invalid DVD.");
            return;
        }
        if (qtyInStore >= MAX_ITEMS_IN_STORE) {
            System.out.println("The store is full.");
            return;
        }
        itemsInStore[qtyInStore++] = dvd;
        System.out.println("Added to store: " + dvd.getTitle());
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[--qtyInStore] = null;
                System.out.println("Removed from store: " + dvd.getTitle());
                return;
            }
        }
        System.out.println("DVD not found in store.");
    }

    public int getQtyInStore() {
        return qtyInStore;
    }

    public void print() {
        System.out.println("*********************STORE*********************");
        for (int i = 0; i < qtyInStore; i++) {
            System.out.println((i + 1) + ". " + itemsInStore[i]);
        }
        System.out.println("************************************************");
    }
}
