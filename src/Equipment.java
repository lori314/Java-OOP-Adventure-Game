public class Equipment {
    private String name;
    private int id;
    private int durability;
    private int ce;
    private String type;

    public Equipment(int id,String name, int durability,String type,int ce) {
        this.name = name;
        this.id = id;
        this.durability = durability;
        this.type = type;
        this.ce = ce;
    }

    public void addDurability() {
        this.durability += 1;
    }

    public void subDurability() {
        this.durability -= 1;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getDurability() {
        return this.durability;
    }

    public String getType() {
        return this.type;
    }

    public int getCE() {
        return this.ce;
    }
}
