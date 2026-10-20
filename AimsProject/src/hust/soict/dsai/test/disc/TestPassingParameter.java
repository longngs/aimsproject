package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {

    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());

        // ----- A swap that really works -----
        System.out.println("\n--- Correct swap using wrappers ---");
        DVDWrapper w1 = new DVDWrapper(new DigitalVideoDisc("Jungle"));
        DVDWrapper w2 = new DVDWrapper(new DigitalVideoDisc("Cinderella"));
        swap(w1, w2);
        System.out.println("w1 title: " + w1.dvd.getTitle());
        System.out.println("w2 title: " + w2.dvd.getTitle());

        System.out.println("\n--- Correct swap inside an array ---");
        DigitalVideoDisc[] discs = { new DigitalVideoDisc("Jungle"), new DigitalVideoDisc("Cinderella") };
        swap(discs, 0, 1);
        System.out.println("discs[0]: " + discs[0].getTitle() + ", discs[1]: " + discs[1].getTitle());
    }

    // Does NOT work: only the local copies o1, o2 of the references are swapped
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);                  // modifies the object the caller also points to
        dvd = new DigitalVideoDisc(oldTitle); // only re-points the local copy
    }

    // ---------- Correct swaps ----------
    // A holder: we swap the references stored inside the holders (the holders are shared objects)
    public static class DVDWrapper {
        DigitalVideoDisc dvd;

        public DVDWrapper(DigitalVideoDisc dvd) {
            this.dvd = dvd;
        }
    }

    public static void swap(DVDWrapper a, DVDWrapper b) {
        DigitalVideoDisc tmp = a.dvd;
        a.dvd = b.dvd;
        b.dvd = tmp;
    }

    public static void swap(DigitalVideoDisc[] arr, int i, int j) {
        DigitalVideoDisc tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
