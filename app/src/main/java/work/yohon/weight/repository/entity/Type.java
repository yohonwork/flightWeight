package work.yohon.weight.repository.entity;

public class Type {
    private final long seq;
    private final String name;
    public Type(final long seq, final String name) {
        this.seq  = seq;
        this.name = name;
    }
    public long getSeq() {
        return this.seq;
    }
    public String getName() {
        return this.name;
    }
}
