class Stn implements Gud {
    @Override
    public boolean fight(Adventurer adventurer) {
        return adventurer.getComprehensiveCe() > 3000;
    }

    @Override
    public String getType() {
        return "Stn";
    }
}
