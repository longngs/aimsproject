package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    // Class (classifier) member: shared by all DVDs, used to generate ids
    private static int nbDigitalVideoDiscs = 0;

    // Instance members
    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // ---------- Constructors (overloading) ----------
    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
        assignId();
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
        assignId();
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        assignId();
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        assignId();
    }

    private void assignId() {
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // ---------- Accessors (only getters: no use case changes a DVD after creation) ----------
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    // Temporary setter, required only by the TestPassingParameter exercise (Lab03 - section 3)
    public void setTitle(String title) {
        this.title = title;
    }

    // ---------- Behaviours ----------
    /**
     * A DVD matches if its title contains ANY word of the given keywords
     * (case-insensitive), following the AIMS problem statement.
     */
    public boolean isMatch(String keywords) {
        if (keywords == null || title == null) {
            return false;
        }
        String lowerTitle = title.toLowerCase();
        for (String word : keywords.trim().toLowerCase().split("\\s+")) {
            if (!word.isEmpty() && lowerTitle.contains(word)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + " $";
    }
}
