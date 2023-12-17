package work.yohon.weight.repository.entity;

public class PaxForPaxZone {
    private final long seq;
    private final long typeSeq;
    private final String name;
    private final double weightPoint;

    public PaxForPaxZone(long seq, long typeSeq, String name, double weightPoint) {
        this.seq         = seq;
        this.typeSeq     = typeSeq;
        this.name        = name;
        this.weightPoint = weightPoint;
    }

    public long getSeq() {
        return this.seq;
    }

    public long getTypeSeq() {
        return this.typeSeq;
    }
    public String getName() {
            return this.name;
    }
    public double getWeightPoint() {
        return this.weightPoint;
    }
}
