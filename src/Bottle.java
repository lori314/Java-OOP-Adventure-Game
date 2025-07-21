public class Bottle {
    private int id;
    private int capacity;
    private String name;
    private boolean isEmpty = false;
    private int ce;
    private String type;

    public Bottle(int id, String name, int capacity,String type, int ce) {
        this.name = name;
        this.id = id;
        this.capacity = capacity;
        this.isEmpty = false;
        this.type = type;
        this.ce = ce;
    }

    public int getId() {
        return this.id;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getCe() {
        return this.ce;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }
}