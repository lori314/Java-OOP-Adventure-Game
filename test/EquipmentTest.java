import org.junit.Test;
import static org.junit.Assert.*;

public class EquipmentTest {

    @Test
    public void addDurability() {
        Equipment e=new Equipment(12,"sword",1,"Sword",100);
        e.addDurability();
        assertEquals(2,e.getDurability());
    }

    @Test
    public void getCE() {
        for(int i=0;i<101;i++){
            Equipment e=new Equipment(12,"sword",1,"Sword",i);
            assertEquals(i,e.getCE());
        }
    }

    @Test
    public void getId() {
        for(int i=0;i<101;i++){
            Equipment e=new Equipment(i,"sword",1,"Sword",100);
            assertEquals(i,e.getId());
        }
    }

    @Test
    public void getName() {
        for(int i=0;i<101;i++){
            Equipment e=new Equipment(12,"sword"+i,1,"Sword",100);
            assertEquals("sword"+i,e.getName());
        }
    }

    @Test
    public void getDurability() {
        for(int i=0;i<101;i++){
            Equipment e=new Equipment(12,"sword",i,"Sword",100);
            assertEquals(i,e.getDurability());
        }
    }

}