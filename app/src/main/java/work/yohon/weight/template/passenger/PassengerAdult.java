package work.yohon.weight.template.passenger;

public class PassengerAdult {
    private long headcount;
    private final long basicWeight;
    private long totalWeight;

    public PassengerAdult(long headcount, long basicWeight){
      this.headcount   = headcount;
      this.basicWeight = basicWeight;
      this.totalWeight = headcount * basicWeight;
    }

    public long getHeadcount () {
        return this.headcount;
    }
    public long getTotalWeight() {
        return this.totalWeight;
    }
    public long getWeight() {
        return this.basicWeight;
    }
    public void setHeadcount(long heads) {
        this.headcount = heads;
        update();
    }

    public void update() {
        this.totalWeight = headcount * basicWeight;
    }
}
