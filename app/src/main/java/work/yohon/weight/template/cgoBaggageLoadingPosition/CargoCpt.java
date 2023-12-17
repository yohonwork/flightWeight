package work.yohon.weight.template.cgoBaggageLoadingPosition;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CargoCpt {
    private long weight;
    private final double weightPoint;
    private BigDecimal deadloadPoint;

    public CargoCpt(long weight, double weightPoint) {
        this.weight        = weight;
        this.weightPoint   = weightPoint;
        this.deadloadPoint = BigDecimal.valueOf(weight * weightPoint);
    }

    public long getWeight() {
        return this.weight;
    }
    public double getWeightPoint() {
        return this.weightPoint;
    }
    public double getDeadloadPoint() {
        return this.deadloadPoint.setScale(5, RoundingMode.CEILING).doubleValue();
    }
    public void setWeight(long weight) {
        this.weight = weight;
        update();
    }
    private void update() {
        this.deadloadPoint = BigDecimal.valueOf(this.weight * this.weightPoint);
    }
}
