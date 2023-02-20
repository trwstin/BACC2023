class Truck {
   ImList<Lot> inv;
   int time;
   int loc;

   Truck(ImList<Lot> inv, int time, int loc) {
       this.inv = inv;
       this.time = time;
       this.loc = loc;
   }

   public void move(ImList<Lot> x) {
       this.inv = x;
       this.time += 25;
       if (this.loc == 1) {
           this.loc = 2;
       } else {
           this.loc = 1;
       }
   }
}
