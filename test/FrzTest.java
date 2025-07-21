import org.junit.Test;

import static org.junit.Assert.*;

public class FrzTest {

    @Test
    public void fight() {
        Flm flm = new Flm();
        Adventurer adventurer=new Adventurer(12,"koi");
        flm.fight(adventurer);
        String str=flm.getType();
        assertEquals(adventurer.getName(),"koi");
    }
}