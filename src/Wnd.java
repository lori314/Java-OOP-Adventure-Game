class Wnd implements Gud {
    @Override
    public boolean fight(Adventurer adventurer) {
        return adventurer.getComprehensiveCe() > 4000;
    }

    @Override
    public String getType() {
        return "Wnd";
    }
}
