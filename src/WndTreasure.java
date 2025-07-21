class WndTreasure implements Treasure {
    @Override
    public void showInfo() {
        System.out.println("Windrunner Boots");
    }

    @Override
    public void usedBy(Adventurer adventurer) {
        adventurer.addDef(30);
        for (Adventurer adv : adventurer.getMyAdventurers().keySet()) {
            adv.addDef(30);
        }
    }
}
