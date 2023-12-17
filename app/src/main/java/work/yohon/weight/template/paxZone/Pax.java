package work.yohon.weight.template.paxZone;

import java.math.BigDecimal;

public class Pax {
    private BigDecimal count;
    private final BigDecimal weight;
    private BigDecimal weightForParts;
    private BigDecimal correctionValue;
    private BigDecimal value;

    public Pax (long count, long weight, double correctionValue) {
        this.count           = BigDecimal.valueOf(count);
        this.weight          = BigDecimal.valueOf(weight);
        this.weightForParts  = this.count.multiply(this.weight);
        this.correctionValue = BigDecimal.valueOf(correctionValue);
        this.value           = weightForParts.multiply(this.correctionValue);
    }

    public BigDecimal getCount() {
        return this.count;
    }

    public BigDecimal getWeightForParts() {
        return this.weightForParts;
    }

    public BigDecimal getCorrectionValue() {
        return this.correctionValue;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setCount(long count) {
        this.count          = BigDecimal.valueOf(count);
        updateWeightForParts();
        updateValue();
    }

    private void updateWeightForParts() {
        this.weightForParts = this.count.multiply(this.weight);
    }

    private void updateValue() {
        this.value = weightForParts.multiply(this.correctionValue);
    }

}
