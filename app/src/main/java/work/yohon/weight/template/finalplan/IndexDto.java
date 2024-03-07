package work.yohon.weight.template.finalplan;

import java.math.BigDecimal;

public class IndexDto {
    private final BigDecimal zfw;
    private final BigDecimal zfwIndex;
    private final BigDecimal tow;
    private final BigDecimal towIndex;
    private final BigDecimal ldw;
    private final BigDecimal ldwIndex;

    public IndexDto(BigDecimal zfw, BigDecimal zfwIndex,BigDecimal tow, BigDecimal towIndex, BigDecimal ldw, BigDecimal ldwIndex) {
        this.zfw      = zfw;
        this.zfwIndex = zfwIndex;
        this.tow      = tow;
        this.towIndex = towIndex;
        this.ldw      = ldw;
        this.ldwIndex = ldwIndex;

    }
    public BigDecimal getZfw() {
        return this.zfw;
    }
    public BigDecimal getZfwIndex() {
        return this.zfwIndex;
    }
    public BigDecimal getTow() {
        return this.tow;
    }
    public BigDecimal getTowIndex() {
        return this.towIndex;
    }
    public BigDecimal getLdw() {
        return this.ldw;
    }
    public BigDecimal getLdwIndex() {
        return this.ldwIndex;
    }
}
