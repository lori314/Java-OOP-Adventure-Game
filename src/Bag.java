import java.util.ArrayList;

public class Bag {
    private ArrayList<Bottle> bottles = new ArrayList<>();
    private ArrayList<Equipment> equipments = new ArrayList<>();

    public void addBottle(Bottle bottle,int ce) {
        int maxBottles = ce / 5 + 1;
        if (countBottle(bottle.getName()) < maxBottles) {
            bottles.add(bottle);
        }
    }

    public void addEquipment(Equipment equipment) {
        for (int i = 0; i < equipments.size(); i++) {
            if (equipments.get(i).getName().equals(equipment.getName())) {
                Equipment temp = equipments.get(i);
                equipments.remove(temp);
                break;
            }
        }
        equipments.add(equipment);
    }

    public void removeBottle(int id) {
        for (int i = 0; i < bottles.size(); i++) {
            Bottle bottle = bottles.get(i);
            if (bottle.getId() == id) {
                bottles.remove(bottle);
                break;
            }
        }
    }

    public void removeEquipment(int id) {
        for (int i = 0; i < equipments.size(); i++) {
            Equipment equipment = equipments.get(i);
            if (equipment.getId() == id) {
                equipments.remove(equipment);
                break; // 调整索引以反映列表的变化
            }
        }
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

    public Equipment getEquipment(String name) {
        for (int i = 0; i < equipments.size(); i++) {
            Equipment equipment = equipments.get(i);
            if (equipment.getName().equals(name)) {
                return equipment;
            }
        }
        return null;
    }

    public int countBottle(String name) {
        int count = 0;
        for (int i = 0; i < bottles.size(); i++) {
            Bottle bottle = bottles.get(i);
            if (bottle.getName().equals(name)) {
                count++;
            }
        }
        return count;
    }

    public ArrayList<Bottle> getBottles() {
        return bottles;
    }

    public ArrayList<Equipment> getEquipments() {
        return equipments;
    }
}
