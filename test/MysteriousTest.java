import org.junit.Test;

import static org.junit.Assert.*;

public class MysteriousTest {

    @Test
    public void game() {
        Adventurer adventurer=new Adventurer(12,"lori");
        Mysterious mysterious=new Mysterious();
        mysterious.game(adventurer);
        adventurer.addAtk(6000);
        adventurer.addDef(6000);
        mysterious.game(adventurer);
    }
}