package work.yohon.weight.repository.entity;

public class Point {
    private long seq;
    private long typeSeq;
    private String aircraft;
    private String name;
    private float x;
    private float y;

    public Point(long seq, long typeSeq, String aircraft, String name, float x, float y) {
        this.seq = seq;
        this.typeSeq = typeSeq;
        this.aircraft = aircraft;
        this.name = name;
        this.x = x;
        this.y = y;
    }
    public long getSeq() {
        return this.seq;
    }
    public long getTypeSeq() {
        return this.typeSeq;
    }
    public String getAircraft() {
        return this.aircraft;
    }
    public String getName() {
        return this.name;
    }
    public float getX() {
        return this.x;
    }
    public float getY() {
        return this.y;
    }
}
