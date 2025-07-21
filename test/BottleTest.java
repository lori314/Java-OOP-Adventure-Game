import org.junit.Test;
import static org.junit.Assert.*;

public class BottleTest {

    @Test
    public void getCapacity() {
        for(int i=0;i<101;i++){
            Bottle b=new Bottle(5111,"niji",i,"DefBottle",100);
            assertEquals(i,b.getCapacity());
        }
    }

    @Test
    public void getName() {
        for(int i=0;i<101;i++){
            Bottle b=new Bottle(5111,"niji"+i,12,"DefBottle",100);
            assertEquals("niji"+i,b.getName());
        }
    }

    @Test
    public void getId() {
        for(int i=0;i<101;i++){
            Bottle b=new Bottle(i,"niji",12,"DefBottle",100);
            assertEquals(i,b.getId());
        }
    }

    @Test
    public void getType() {
        for(int i=0;i<101;i++){
            Bottle b=new Bottle(5111,"niji",12,"DefBottle"+i,100);
            assertEquals("DefBottle"+i,b.getType());
        }
    }
}