class FlmTreasure implements Treasure {
    @Override
    public void showInfo() {
        System.out.println("Flamebrand Sword");
    }

    @Override
    public void usedBy(Adventurer adventurer) {
        adventurer.addAtk(40);
        for (Adventurer adv : adventurer.getMyAdventurers().keySet()) {
            adv.addAtk(40);
        }
    }
}
