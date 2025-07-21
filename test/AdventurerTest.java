import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AdventurerTest {

    @Test
    public void addBottle() {
        Adventurer a=new Adventurer(1,"me");
        a.addBottle(12,"new",125,"HpBottle",100);
        assertEquals(a.getBottles().size(),1);
    }

    @Test
    public void addEquipment() {
        Adventurer a=new Adventurer(1,"me");
        a.addEquipment(12,"new",125,"Sword",100);
        assertEquals(a.getEquipments().size(),1);
    }

    @Test
    public void fix() {
        Adventurer a=new Adventurer(1,"me");
        a.addEquipment(12,"new",125,"Sword",100);
        a.fix(12);
        assertEquals(a.getEquipments().get(0).getDurability(),126);
    }

    @Test
    public void removeBottle() {
        Adventurer a=new Adventurer(1,"me");
        a.addBottle(12,"new",125,"AtkBottle",100);
        a.removeBottle(12);
        assertEquals(a.getBottles().size(),0);
    }

    @Test
    public void removeEquipment() {
        Adventurer a=new Adventurer(1,"me");
        a.addEquipment(12,"new",125,"Sword",100);
        a.removeEquipment(12);
        assertEquals(a.getEquipments().size(),0);
    }

    @Test
    public void getBottles() {
        Adventurer a=new Adventurer(1,"me");
        a.addBottle(12,"new",125,"DefBottle",100);
        assertEquals(a.getBottles().size(),1);
    }

    @Test
    public void getEquipments() {
        Adventurer a=new Adventurer(1,"me");
        a.addEquipment(12,"new",125,"Sword",100);
        assertEquals(a.getEquipments().size(),1);
    }

    @Test
    public void getId() {
        for(int i=0;i<101;i++){
            Adventurer a=new Adventurer(1+i,"me");
            assertEquals(a.getId(),i+1);
        }
    }

    @Test
    public void getName() {
        for(int i=0;i<101;i++){
            Adventurer a=new Adventurer(1+i,"me");
            assertEquals(a.getName(),"me");
        }
    }

    @Test
    public void getBottle() {
        Adventurer a=new Adventurer(1,"me");
        for(int i=0;i<101;i++){
            a.addBottle(12+i,"new",125,"AtkBottle",100);
            assertEquals(a.getBottles().get(i).getId(),12+i);
        }
    }

    @Test
    public void getEquipment() {
        Adventurer a=new Adventurer(1,"me");
        for(int i=0;i<101;i++){
            a.addEquipment(12+i,"sword",120,"Blade",100);
            assertEquals(a.getEquipments().get(i).getId(),12+i);
        }
    }

    @Test
    public void join() {
        Adventurer a=new Adventurer(1,"me");
        for(int i=0;i<1;i++) {
            a.addBottle(12 + i, "new", 125, "AtkBottle", 1000);
            a.join(12+i);
            assertEquals(a.getBag().getBottles(),a.getBottles());
        }
    }

    @Test
    public void drink() {
        Adventurer a=new Adventurer(1,"me");
        a.addBottle(12,"new",125,"DefBottle",100);
        a.addBottle(15,"ee",10,"AtkBottle",100);
        a.addBottle(16,"ff",10,"HpBottle",100);
        a.join(12);
        a.join(15);
        a.join(16);
        a.addEquipment(13,"sword",120,"Axe",100);
        a.join(13);
        a.drink(12);
        a.drink(15);
        a.drink(16);
        assertEquals(a.getDef(),101);
    }

    @Test
    public void getHitPoint() {
        Adventurer a=new Adventurer(1,"me");
        assertEquals(a.getHitPoint(),500);
    }

    @Test
    public void getAtk() {
        Adventurer a=new Adventurer(1,"me");
        assertEquals(a.getAtk(),1);
    }

    @Test
    public void attack(){
        Adventurer a=new Adventurer(1,"me");
        a.addEquipment(12,"new",125,"Sword",100);
        a.addEquipment(13,"now",125,"Axe",100);
        a.addEquipment(14,"nio",1,"Blade",100);
        a.join(12);
        a.join(13);
        a.join(14);
        ArrayList<Adventurer> adventurers=new ArrayList<>();
        Adventurer b=new Adventurer(2,"you");
        Adventurer c=new Adventurer(3,"me");
        c.addEquipment(15,"weapon",10,"Axe",100);
        c.join(15);
        Adventurer d=new Adventurer(4,"d");
        Adventurer e=new Adventurer(5,"e");
        Adventurer f=new Adventurer(6,"f");
        Adventurer g=new Adventurer(7,"g");
        Adventurer h=new Adventurer(8,"h");
        Adventurer i=new Adventurer(9,"i");
        Adventurer j=new Adventurer(10,"j");
        Adventurer k=new Adventurer(11,"k");
        Adventurer l=new Adventurer(12,"l");
        Adventurer m=new Adventurer(13,"m");
        Adventurer n=new Adventurer(14,"n");
        Adventurer o=new Adventurer(15,"o");
        Adventurer p=new Adventurer(16,"p");
        b.employ(c);
        b.employ(d);
        c.employ(e);
        c.employ(f);
        d.employ(g);
        f.employ(h);
        g.employ(i);
        g.employ(j);
        h.employ(k);
        i.employ(l);
        k.employ(m);
        k.employ(n);
        l.employ(n);
        l.employ(o);
        l.employ(p);
        adventurers.add(b);
        adventurers.add(i);
        a.attack("new",adventurers,"chain");
        assertEquals(m.getHitPoint(),500);
        a.attack("nww",adventurers,"chain");
        a.attack("now",adventurers,"normal");
        assertEquals(b.getEquipments().size(),1);
        a.attack("now",adventurers,"normal");
        a.attack("now",adventurers,"normal");
        a.attack("now",adventurers,"normal");
        assertEquals(b.getEquipments().size(),1);
        a.attack("nio",adventurers,"normal");
    }

    @Test
    public void redeem(){
        Adventurer a=new Adventurer(1,"me");
        a.addEquipment(12315,"new",125,"Sword",100);
        a.addFramgment(12,"nu");
        a.addFramgment(13,"nu");
        a.addFramgment(14,"nu");
        a.addFramgment(15,"nu");
        a.redeem("nu",12315);
        a.addFramgment(16,"nu");
        a.redeem("nu",12315);
        assertEquals(126,a.getEquipment(12315).getDurability());
    }

}