package work.yohon.weight.repository.entity;

public class Type {
    private final long seq;
    private final String name;
    private final String aircraft;
    public Type(final long seq, final String name, final String aircraft) {
        this.seq      = seq;
        this.name     = name;
        this.aircraft = aircraft;
    }
    public long getSeq() {
        return this.seq;
    }
    public String getName() {
        return this.name;
    }
    public String getAircraft() {
        return this.aircraft;
    }
}
