package work.yohon.weight.repository.entity;

public class Passenger {
    private final long seq;
    private final long typeSeq;
    private final long adultWeight;
    private final long childWeight;
    private final long infantsWeight;
    private final long carbinBagWeight;
    public Passenger(long seq, long typeSeq, long adultWeight, long childWeight, long infantsWeight, long carbinBagWeight) {
        this.seq             = seq;
        this.typeSeq         = typeSeq;
        this.adultWeight     = adultWeight;
        this.childWeight     = childWeight;
        this.infantsWeight   = infantsWeight;
        this.carbinBagWeight = carbinBagWeight;
    }
    public long getSeq() {
        return this.seq;
    }
    public long getTypeSeq() {
        return this.typeSeq;
    }
    public long getAdultWeight() {
        return this.adultWeight;
    }
    public long getChildWeight() {
        return this.childWeight;
    }
    public long getInfantsWeight() {
        return this.infantsWeight;
    }
    public long getCarbinBagWeight() {
        return this.carbinBagWeight;
    }
}
