class FrzTreasure implements Treasure {
    @Override
    public void showInfo() {
        System.out.println("Frostbite Staff");
    }

    @Override
    public void usedBy(Adventurer adventurer) {
        adventurer.addAtk(50);
        for (Adventurer adv : adventurer.getMyAdventurers().keySet()) {
            adv.addAtk(50);
        }
    }
}
