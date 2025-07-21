public class Mysterious {
    public void game(Adventurer adv) {
        Gud shd = new Shd();
        if (shd.fight(adv)) {
            Treasure treasure = TreasureFactory.createTreasure(shd);
            treasure.showInfo(); // 显示获得的宝物信息
            treasure.usedBy(adv);
        }
        Gud flm = new Flm();
        if (flm.fight(adv)) {
            Treasure treasure = TreasureFactory.createTreasure(flm);
            treasure.showInfo();
            treasure.usedBy(adv);
        }
        Gud stn = new Stn();
        if (stn.fight(adv)) {
            Treasure treasure = TreasureFactory.createTreasure(stn);
            treasure.showInfo();
            treasure.usedBy(adv);
        }
        Gud wnd = new Wnd();
        if (wnd.fight(adv)) {
            Treasure treasure = TreasureFactory.createTreasure(wnd);
            treasure.showInfo();
            treasure.usedBy(adv);
        }
        Gud frz = new Frz();
        if (frz.fight(adv)) {
            Treasure treasure = TreasureFactory.createTreasure(frz);
            treasure.showInfo();
            treasure.usedBy(adv);
        }
    }
}