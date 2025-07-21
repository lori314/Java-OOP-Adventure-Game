class StnTreasure implements Treasure {
    @Override
    public void showInfo() {
        System.out.println("Stoneheart Amulet");
    }

    @Override
    public void usedBy(Adventurer adventurer) {
        adventurer.addDef(40);
        for (Adventurer adv : adventurer.getMyAdventurers().keySet()) {
            adv.addDef(40);
        }
    }
}
