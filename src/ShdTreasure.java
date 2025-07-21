class ShdTreasure implements Treasure {
    @Override
    public void showInfo() {
        System.out.println("Cloak of Shadows");
    }

    @Override
    public void usedBy(Adventurer adventurer) {
        adventurer.addDef(40);
        for (Adventurer adv : adventurer.getMyAdventurers().keySet()) {
            adv.addDef(40);
        }
    }
}
