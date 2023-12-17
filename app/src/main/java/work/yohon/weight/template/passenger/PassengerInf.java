package work.yohon.weight.template.passenger;

public class PassengerInf {
    private long headcount;
    private final long basicWeight;
    private long totalWeight;

    public PassengerInf(long headcount, long basicWeight){
        this.headcount = headcount;
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

    private void update() {
        this.totalWeight = this.headcount * this.basicWeight;
    }
}
