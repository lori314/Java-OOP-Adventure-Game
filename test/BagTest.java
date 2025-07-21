import org.junit.Test;
import static org.junit.Assert.*;

public class BagTest {

    @Test
    public void addBottle() {
        Bag bag = new Bag();
        for(int i=0;i<1;i++){
            AtkBottle b =new AtkBottle(12+i,"water",100,"AtkBottle",120);
            bag.addBottle(b,19);
            assertEquals(i+1,bag.getBottles().size());
        }
    }

    @Test
    public void addEquipment() {
        Bag bag = new Bag();
        for(int i=0;i<101;i++){
            Equipment e=new Equipment(12,"sword"+i,125,"Sword",100);
            bag.addEquipment(e);
            assertEquals(i+1,bag.getEquipments().size());
        }
    }

    @Test
    public void removeBottle() {
        Bag bag = new Bag();
        bag.addBottle(new AtkBottle(12,"water",100,"AtkBottle",120),19);
        bag.removeBottle(12);
        assertEquals(0,bag.getBottles().size());
    }

    @Test
    public void removeEquipment() {
        Bag bag = new Bag();
        bag.addEquipment(new Equipment(12,"sword"+1,125,"Sword",100));
        bag.removeEquipment(12);
        assertEquals(0,bag.getEquipments().size());
    }

    @Test
    public void getBottle() {
        Bag bag = new Bag();
        for(int i=0;i<1;i++){
            AtkBottle b =new AtkBottle(12+i,"water",100,"AtkBottle",120);
            bag.addBottle(b,19);
            assertEquals(b,bag.getBottle(12+i));
        }
    }

    @Test
    public void getEquipment() {
        Bag bag = new Bag();
        for(int i=0;i<101;i++){
            Equipment e=new Equipment(12+i,"sword",125,"Sword",100);
            bag.addEquipment(e);
            assertEquals(e,bag.getEquipment(12+i));
        }
    }
}