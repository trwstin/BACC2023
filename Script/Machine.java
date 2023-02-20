class Machine {
    int id;
    int time = 0;
    Lot lot = new Lot(0, 0);

    Machine(int id) {
        this.id = id;
    }

    public void changeTime(int x) {
        this.time = x;
    }
}
