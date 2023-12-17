package work.yohon.weight.template.cagoAndBaggage;

public class LoadDto {
    private final long ttlPayload;
    private final long underLoad;
    public LoadDto(long ttlPayload, long underLoad) {
        this.ttlPayload = ttlPayload;
        this.underLoad  = underLoad;
    }

    public long getTtlPayload () {
        return this.ttlPayload;
    }

    public long getUnderLoad () {
        return this.underLoad;
    }
}
