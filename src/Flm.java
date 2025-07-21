class Flm implements Gud {
    @Override
    public boolean fight(Adventurer adventurer) {
        return adventurer.getComprehensiveCe() > 2000;
    }

    @Override
    public String getType() {
        return "Flm";
    }
}
