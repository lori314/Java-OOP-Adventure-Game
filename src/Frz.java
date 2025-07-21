class Frz implements Gud {
    @Override
    public boolean fight(Adventurer adventurer) {
        return adventurer.getComprehensiveCe() > 5000;
    }

    @Override
    public String getType() {
        return "Frz";
    }
}
