import org.junit.Test;

import static org.junit.Assert.*;

public class FramgmentTest {

    @Test
    public void getName() {
        Framgment framgment = new Framgment("us",12);
        assertEquals("us",framgment.getName());
    }

    @Test
    public void getId() {
        Framgment framgment = new Framgment("us",12);
        assertEquals(12,framgment.getId());
    }
}