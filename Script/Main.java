class Main {

    Main() {}

    public void test() {
        Building X = new Building(new ImList<Lot>(), new ImList<Lot>(), new ImList<Lot>(),
                new ImList<Lot>(), new ImList<Lot>(), new ImList<Lot>(), new ImList<Lot>());
        Building Y = new Building(new ImList<Lot>(), new ImList<Lot>(), new ImList<Lot>(),
                new ImList<Lot>(), new ImList<Lot>(), new ImList<Lot>(), new ImList<Lot>());
        Truck truck = new Truck(new ImList<Lot>(), 0, 1);
        Machine A = new Machine(1);
        Machine B = new Machine(2);
        Machine C = new Machine(3);
        Machine D = new Machine(4);
        Machine E = new Machine(5);
        Machine F = new Machine(6);
        int time = 0;
        int lotNo = 0;
        ImList<String> output = new ImList<String>();

        while (time <= 10080) {
            if (truck.time <= time) {
                // empty truck
                if (!truck.inv.isEmpty()) {
                    for (int i = 0; i < truck.inv.size(); i++) {
                        if (truck.loc == 1) {
                            X.add(truck.inv.get(i));
                        } else {
                            Y.add(truck.inv.get(i));
                        }
                    }
                }
                // load truck
                ImList<Lot> newLoad = new ImList<Lot>();
                if (truck.loc == 1) {
                    for (int i = 0; i < 5; i++) {
                        if (!X.s3.isEmpty()) {
                            newLoad = newLoad.add(X.take(3));
                        } else if (!X.s2.isEmpty()) {
                            newLoad = newLoad.add(X.take(2));
                        } else {
                            lotNo++;
                            newLoad = newLoad.add(new Lot(lotNo, 0));
                        }
                    }
                } else {
                    for (int i = 0; i < 5; i++) {
                        if (!Y.s1.isEmpty()) {
                            newLoad = newLoad.add(Y.take(1));
                        } else if (!Y.s4.isEmpty()) {
                            newLoad = newLoad.add(Y.take(4));
                        } else if (!Y.s5.isEmpty()) {
                            newLoad = newLoad.add(Y.take(5));
                        } else {
                            break;
                        }
                    }
                }
                truck.move(newLoad);
            }
            // machine A
            if (A.time <= time) {
                if (A.lot.id != 0) {
                    X.add(A.lot.nextStep());
                }
                if (!X.s2.isEmpty()) {
                    A.lot = X.take(2);
                    A.changeTime(time + 10);
                } else {
                    lotNo++;
                    A.lot = new Lot(lotNo, 0);
                    A.changeTime(time + 5);
                }
            }
            // machine B
            if (B.time <= time) {
                if (B.lot.id != 0) {
                    X.add(B.lot.nextStep());
                }
                if (!X.s5.isEmpty()) {
                    B.lot = X.take(5);
                    B.changeTime(time + 10);
                } else if (!X.s1.isEmpty()) {
                    B.lot = X.take(1);
                    B.changeTime(time + 15);
                } else {
                    B.lot = new Lot(0, 0);
                }
            }
            // machine C
            if (C.time <= time) {
                if (C.lot.id != 0) {
                    X.add(C.lot.nextStep());
                }
                if (!X.s4.isEmpty()) {
                    C.lot = X.take(4);
                    C.changeTime(time + 10);
                } else if (!X.s1.isEmpty()) {
                    C.lot = X.take(1);
                    C.changeTime(time + 15);
                } else {
                    C.lot = new Lot(0, 0);
                }
            }
            // machine d
            if (D.time <= time) {
                if (D.lot.id != 0) {
                    Y.add(D.lot.nextStep());
                }
                if (!Y.s3.isEmpty()) {
                    D.lot = Y.take(3);
                    D.changeTime(time + 15);
                } else if (!Y.s0.isEmpty()) {
                    D.lot = Y.take(0);
                    D.changeTime(time + 5);
                } else {
                    D.lot = new Lot(0, 0);
                }
            }
            // machine E
            if (E.time <= time) {
                if (E.lot.id != 0) {
                    Y.add(E.lot.nextStep());
                }
                if (!Y.s4.isEmpty()) {
                    E.lot = Y.take(4);
                    E.changeTime(time + 15);
                } else if (!Y.s2.isEmpty()) {
                    E.lot = Y.take(2);
                    E.changeTime(time + 5);
                } else if (!Y.s0.isEmpty()) {
                    E.lot = Y.take(0);
                    E.changeTime(time + 5);
                } else {
                    E.lot = new Lot(0, 0);
                }
            }
            // machine F
            if (F.time <= time) {
                if (F.lot.id != 0) {
                    Y.add(F.lot.nextStep());
                }
                if (!Y.s5.isEmpty()) {
                    F.lot = Y.take(5);
                    F.changeTime(time + 10);
                } else if (!Y.s3.isEmpty()) {
                    F.lot = Y.take(3);
                    F.changeTime(time + 10);
                } else {
                    F.lot = new Lot(0, 0);
                }
            }
            output = output.add(String.valueOf(time));

            if (A.lot.id == 0) {
                output = output.add("-");
            } else {output = output.add(String.valueOf(A.lot.id));}
            if (B.lot.id == 0) {
                output = output.add("-");
            } else {output = output.add(String.valueOf(B.lot.id));}
            if (C.lot.id == 0) {
                output = output.add("-");
            } else {output = output.add(String.valueOf(C.lot.id));}
            if (D.lot.id == 0) {
                output = output.add("-");
            } else {output = output.add(String.valueOf(D.lot.id));}
            if (E.lot.id == 0) {
                output = output.add("-");
            } else {output = output.add(String.valueOf(E.lot.id));}
            if (F.lot.id == 0) {
                output = output.add("-");
            } else {output = output.add(String.valueOf(F.lot.id));}

            int count = 0;
            for (int i = 0; i < truck.inv.size(); i++) {
                output = output.add(String.valueOf(truck.inv.get(i).id));
                count++;
            }
            for (int i = count; i < 5; i++) {
                output = output.add("-");
            }
            if (truck.loc == 1) {
                output = output.add("X");
            } else {
                output = output.add("Y");
            }

            time += 5;
        }
        for (String i : output) {
            System.out.println(i);
        }
        System.out.println(X.s6.size() + Y.s6.size());
    }
}
