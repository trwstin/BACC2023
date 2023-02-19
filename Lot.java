class Lot {
    int id;
    int step;

    Lot(int id, int step) {
        this.id = id;
        this.step = step;
    }

    public Lot nextStep() {
        return new Lot(this.id, this.step + 1);
    }
}
