package work.yohon.weight.template.passenger;

public class PassengerCabinBag {
    private long count;
    private final long basicWeight;
    private long totalWeight;

    public PassengerCabinBag(long count, long basicWeight){
        this.count = count;
        this.basicWeight = basicWeight;
        this.totalWeight = count * basicWeight;
    }


    public long getCount() {
        return this.count;
    }
    public long getTotalWeight() {
        return this.totalWeight;
    }
    public long getWeight() {
        return this.basicWeight;
    }
    public void setCount(long counts) {
        this.count = counts;
        update();
    }

    private void update() {
        this.totalWeight = this.count * this.basicWeight;
    }
}
