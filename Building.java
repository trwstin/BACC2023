class Building {
    ImList<Lot> s0;
    ImList<Lot> s1;
    ImList<Lot> s2;
    ImList<Lot> s3;
    ImList<Lot> s4;
    ImList<Lot> s5;
    ImList<Lot> s6;


    Building(ImList<Lot> s0, ImList<Lot> s1, ImList<Lot> s2, ImList<Lot> s3, 
            ImList<Lot> s4, ImList<Lot> s5, ImList<Lot> s6) {
        this.s0 = s0;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.s5 = s5;
        this.s6 = s6;
    }

    public void add(Lot x) {
        int a = x.step;
        if (a == 0) {
            this.s0 = this.s0.add(x);
        } else if (a == 1) {
            this.s1 = this.s1.add(x);
        } else if (a == 2) {
            this.s2 = this.s2.add(x);
        } else if (a == 3) {
            this.s3 = this.s3.add(x);
        } else if (a == 4) {
            this.s4 = this.s4.add(x);
        } else if (a == 5) {
            this.s5 = this.s5.add(x);
        } else {
            this.s6 = this.s6.add(x);
        }
    }

    public Lot take(int a) {
        Lot x;
        if (a == 0) {
            x = this.s0.get(0);
            this.s0 = this.s0.remove(0);
        } else if (a == 1) {
            x = this.s1.get(0);
            this.s1 = this.s1.remove(0);
        } else if (a == 2) {
            x = this.s2.get(0);
            this.s2 = this.s2.remove(0);
        } else if (a == 3) {
            x = this.s3.get(0);
            this.s3 = this.s3.remove(0);
        } else if (a == 4) {
            x = this.s4.get(0);
            this.s4 = this.s4.remove(0);
        } else if (a == 5) {
            x = this.s5.get(0);
            this.s5 = this.s5.remove(0);
        } else {
            x = this.s6.get(0);
            this.s6 = this.s6.remove(0);
        }
        return x;
    }
}

