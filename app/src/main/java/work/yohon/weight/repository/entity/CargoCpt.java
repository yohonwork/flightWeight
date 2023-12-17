package work.yohon.weight.repository.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CargoCpt {

    private final String name;
    private final long typeSeq;
    private final BigDecimal weightPoint;

    public CargoCpt(String name, long typeSeq, double weightPoint) {
        this.name        = name;
        this.typeSeq     = typeSeq;
        this.weightPoint = BigDecimal.valueOf(weightPoint).setScale(5, RoundingMode.CEILING);
    }

    public String getName() {
        return this.name;
    }
    public long getTypeSeq() {
        return this.typeSeq;
    }
    public double getWeightPoint() {
        return this.weightPoint.setScale(5, RoundingMode.CEILING).doubleValue();
    }

    public work.yohon.weight.template.cgoBaggageLoadingPosition.CargoCpt value() {
        return new work.yohon.weight.template.cgoBaggageLoadingPosition.CargoCpt(0, this.weightPoint.doubleValue());
    }
}
