package work.yohon.weight.template.cagoAndBaggage;

public class Baggage {
    private long count;
    private long weight;
    private long totalWeight;

    public Baggage(long count, long weight) {
        this.count = count;
        this.weight = weight;
        this.totalWeight = this.weight;
    }

    public long getCount() {
        return this.count;
    }
    public long getWeight() {
        return this.weight;
    }
    public long getTotalWeight() {
        return this.totalWeight;
    }
    public void setCount(long counts) {
        this.count = counts;
    }
    public void setWeight(long weight) {
        this.weight = weight;
        update();
    }
    private void update() {
        this.totalWeight = this.weight;
    }
}

