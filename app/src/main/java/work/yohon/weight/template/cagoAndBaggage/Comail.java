package work.yohon.weight.template.cagoAndBaggage;

public class Comail {
    private long count;
    private long weight;
    private long totalWeight;

    public Comail(long count, long deadLoad) {
        this.count         = count;
        this.weight = deadLoad;
        this.totalWeight = deadLoad;
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

