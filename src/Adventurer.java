import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Adventurer {
    private String name;
    private int id;
    private int atk;
    private int def;
    private int hitPoint;
    private ArrayList<Bottle> bottles = new ArrayList<>();
    private ArrayList<Equipment> equipments = new ArrayList<>();
    private Map<String,Integer> framgments = new HashMap<>();
    private HashMap<Adventurer,Integer> myAdventurers = new HashMap<>();
    private Bag bag = new Bag();

    public Adventurer(int id, String name) {
        this.name = name;
        this.id = id;
        this.atk = 1;
        this.def = 0;
        this.hitPoint = 500;
    }

    public void addBottle(int id, String name, int capacity,String type,int ce) {
        switch (type) {
            case "HpBottle":
                HpBottle hpBottle = new HpBottle(id, name, capacity,type,ce);
                bottles.add(hpBottle);
                break;
            case "AtkBottle":
                AtkBottle atkBottle = new AtkBottle(id, name, capacity,type,ce);
                bottles.add(atkBottle);
                break;
            case "DefBottle":
                DefBottle defBottle = new DefBottle(id, name, capacity,type,ce);
                bottles.add(defBottle);
                break;
            default:
                break;
        }
    }

    public ArrayList<Bottle> getBottles() {
        return bottles;
    }

    public void addEquipment(int id, String name, int durability,String type,int ce) {
        equipments.add(new Equipment(id, name, durability,type,ce));
    }

    public ArrayList<Equipment> getEquipments() {
        return equipments;
    }

    public void addFramgment(int id, String name) {
        Framgment framgment = new Framgment(name,id);
        if (framgments.containsKey(framgment.getName())) {
            framgments.put(name,framgments.get(name) + 1);
        }
        else {
            framgments.put(name,1);
        }
    }

    public void redeem(String name,int welfareId) {
        if (framgments.containsKey(name) && framgments.get(name) >= 5) {
            framgments.put(name,framgments.get(name) - 5);
            if (getBottle(welfareId) != null) {
                Bottle bottle = getBottle(welfareId);
                if (bottle.isEmpty()) {
                    bottle.setIsEmpty(false);
                }
                System.out.printf("%s %d\n",bottle.getName(),bottle.getCapacity());
            }
            else if (getEquipment(welfareId) != null) {
                Equipment equipment = getEquipment(welfareId);
                equipment.addDurability();
                System.out.printf("%s %d\n",equipment.getName(),equipment.getDurability());
            }
            else {
                addBottle(welfareId,name,100,"HpBottle",0);
                System.out.printf("Congratulations! HpBottle %s acquired\n",name);
            }
        }
        else {
            System.out.printf("%d: Not enough fragments collected yet\n",framgments.get(name));
        }
    }

    public void fix(int id) {
        for (Equipment e : equipments) {
            if (e.getId() == id) {
                e.addDurability();
                System.out.printf("%s %d\n", e.getName(), e.getDurability());
                break;
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Bottle getBottle(int id) {
        for (int i = 0; i < bottles.size(); i++) {
            Bottle bottle = bottles.get(i);
            if (bottle.getId() == id) {
                return bottle;
            }
        }
        return null;
    }

    public Equipment getEquipment(int id) {
        for (int i = 0; i < equipments.size(); i++) {
            Equipment equipment = equipments.get(i);
            if (equipment.getId() == id) {
                return equipment;
            }
        }
        return null;
    }

    public void removeBottle(int id) {
        for (int i = 0; i < bottles.size(); i++) {
            Bottle bottle = bottles.get(i);
            if (bottle.getId() == id) {
                System.out.printf(
                        "%s %s %d\n",bottle.getType(),bottle.getName(),bottle.getCapacity()
                );
                bottles.remove(bottle);
                break;
            }
        }
        bag.removeBottle(id);
    }

    public void removeEquipment(int id) {
        for (int i = 0; i < equipments.size(); i++) {
            Equipment equipment = equipments.get(i);
            if (equipment.getId() == id) {
                String t = equipment.getType();
                System.out.printf(
                        "%s %s %d\n",t,equipment.getName(),equipment.getDurability()
                );
                equipments.remove(equipment);
                break; // 调整索引以反映列表的变化
            }
        }
        bag.removeEquipment(id);
    }

    public void join(int id) {
        if (getBottle(id) != null && bag.getBottle(id) == null) {
            bag.addBottle(getBottle(id),atk + def);
        }
        else if (getEquipment(id) != null && bag.getEquipment(id) == null) {
            bag.addEquipment(getEquipment(id));
        }
    }

    public void drink(int id) {
        Bottle bottle = bag.getBottle(id);
        if (bottle == null) {
            System.out.printf("%s fail to use %s\n",this.getName(),this.getBottle(id).getName());
        }
        else {
            if (bottle.isEmpty()) {
                bottles.remove(bottle);
                bag.removeBottle(id);
            }
            else {
                if (bottle instanceof HpBottle) {
                    this.hitPoint += bottle.getCapacity();
                } else if (bottle instanceof AtkBottle) {
                    this.atk += bottle.getCapacity() / 100 + bottle.getCe();
                } else if (bottle instanceof DefBottle) {
                    this.def += bottle.getCapacity() / 100 + bottle.getCe();
                }
                bottle.setIsEmpty(true);
            }
            System.out.printf("%s %d %d %d\n", name, hitPoint, atk, def);
        }
    }

    public void attack(String equipmentName, ArrayList<Adventurer> adventurers, String type) {
        int enemyDef = 0;
        int damage = 0;
        if (type.equals("chain")) {
            HashSet<Adventurer> temp = new HashSet<>();
            for (Adventurer ad : adventurers) {
                ad.findMyAdventurers(5,temp);
            }
            temp.addAll(adventurers);
            adventurers.clear();
            adventurers.addAll(temp);
        }
        for (Adventurer adventurer : adventurers) {
            if (adventurer.getDef() > enemyDef) {
                enemyDef = adventurer.getDef();
            }
        }
        Equipment equipment = bag.getEquipment(equipmentName);
        if (equipment == null) {
            System.out.printf("Adventurer %d defeated\n",this.getId());
        }
        else {
            if (this.atk + equipment.getCE() > enemyDef) {
                equipment.subDurability();
                if (equipment.getDurability() == 0) {
                    equipments.remove(equipment);
                    bag.getEquipments().remove(equipment);
                }
                for (Adventurer adventurer: adventurers) {
                    damage += adventurer.beAttacked(this.atk,equipment,type);
                }
                if (type.equals("chain")) {
                    System.out.printf("%d\n",damage);
                }
            }
            else {
                System.out.printf("Adventurer %d defeated\n",this.getId());
            }
        }
    }

    public int beAttacked(int enemyAtk,Equipment equipment,String type) {
        int beforeHitPoint = hitPoint;
        switch (equipment.getType()) {
            case "Axe":
                hitPoint = hitPoint / 10;
                break;
            case "Sword":
                hitPoint = hitPoint + this.def - enemyAtk - equipment.getCE();
                break;
            case "Blade":
                hitPoint = hitPoint - enemyAtk - equipment.getCE();
                break;
            default:
                break;
        }
        if (type.equals("normal")) {
            if (beforeHitPoint / 2 >= hitPoint) {
                askHelp();
            }
            System.out.printf("%s %d\n", this.getName(), hitPoint);
        }
        return beforeHitPoint - hitPoint;
    }

    public Bag getBag() {
        return this.bag;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public void addAtk(int atk) {
        this.atk += atk;
    }

    public void addDef(int def) {
        this.def += def;
    }

    public void employ(Adventurer adventurer) {
        myAdventurers.put(adventurer,0);
    }

    public void help(Adventurer adventurer) {
        ArrayList<Equipment> giveEquipments = new ArrayList<>();
        for (Equipment equipment: bag.getEquipments()) {
            adventurer.getEquipments().add(equipment);
            giveEquipments.add(equipment);
        }
        for (Equipment equipment: giveEquipments) {
            equipments.remove(equipment);
            bag.getEquipments().remove(equipment);
        }
    }

    public void askHelp() {
        ArrayList<Adventurer> delAdventurer = new ArrayList<>();
        for (Adventurer adventurer: myAdventurers.keySet()) {
            adventurer.help(this);
            myAdventurers.put(adventurer,myAdventurers.get(adventurer) + 1);
            if (myAdventurers.get(adventurer) > 3) {
                delAdventurer.add(adventurer);
            }
        }
        for (Adventurer adventurer: delAdventurer) {
            myAdventurers.remove(adventurer);
        }
    }

    public HashMap<Adventurer,Integer> getMyAdventurers() {
        return myAdventurers;
    }

    public void findMyAdventurers(int deepth,HashSet<Adventurer> adventurers) {
        if (deepth != 1) {
            adventurers.addAll(myAdventurers.keySet());
            if (myAdventurers != null) {
                for (Adventurer adventurer: myAdventurers.keySet()) {
                    adventurer.findMyAdventurers(deepth - 1,adventurers);
                }
            }
        }
    }

    public int getComprehensiveCe() {
        int comprehensiveCe = atk + def;
        for (Adventurer adventurer: myAdventurers.keySet()) {
            comprehensiveCe = comprehensiveCe + adventurer.getDef() + adventurer.getAtk();
        }
        for (Bottle bottle: bag.getBottles()) {
            comprehensiveCe = comprehensiveCe + bottle.getCe();
        }
        for (Equipment equipment: bag.getEquipments()) {
            comprehensiveCe = comprehensiveCe + equipment.getCE();
        }
        return comprehensiveCe;
    }
}