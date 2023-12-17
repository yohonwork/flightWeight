package work.yohon.weight.repository;

import java.math.BigDecimal;

public class Type2 {
    private final String name;
    private final long adultWeight;
    private final long childWeight;
    private final long infWeight;
    private final long cabinBagWeight;
    private final BigDecimal cargoCpt1WeightPoint;
    private final BigDecimal cargoCpt2WeightPoint;
    private final BigDecimal cargoCpt3WeightPoint;
    private final BigDecimal cargoCpt4WeightPoint;
    private final BigDecimal cargoCpt5WeightPoint;
    private final BigDecimal paxOAWeightPoint;
    private final BigDecimal paxOBWeightPoint;
    private final BigDecimal paxOCWeightPoint;
    public Type2(String name, long adultWeight, long childWeight, long infWeight, long cabinBagWeight, BigDecimal cargoCpt1WeightPoint, BigDecimal cargoCpt2WeightPoint, BigDecimal cargoCpt3WeightPoint, BigDecimal cargoCpt4WeightPoint, BigDecimal cargoCpt5WeightPoint, BigDecimal paxOAWeightPoint, BigDecimal paxOBWeightPoint, BigDecimal paxOCWeightPoint) {
        this.name                 = name;
        this.adultWeight          = adultWeight;
        this.childWeight          = childWeight;
        this.infWeight            = infWeight;
        this.cabinBagWeight       = cabinBagWeight;
        this.cargoCpt1WeightPoint = cargoCpt1WeightPoint;
        this.cargoCpt2WeightPoint = cargoCpt2WeightPoint;
        this.cargoCpt3WeightPoint = cargoCpt3WeightPoint;
        this.cargoCpt4WeightPoint = cargoCpt4WeightPoint;
        this.cargoCpt5WeightPoint = cargoCpt5WeightPoint;
        this.paxOAWeightPoint     = paxOAWeightPoint;
        this.paxOBWeightPoint     = paxOBWeightPoint;
        this.paxOCWeightPoint     = paxOCWeightPoint;
    }

    public String getName() {
        return this.name;
    }
    public long getAdultWeight() {
        return this.adultWeight;
    }
    public long getChildWeight() {
        return this.childWeight;
    }
    public long getInfWeight() {
        return this.infWeight;
    }
    public long getCabinBagWeight() {
        return this.cabinBagWeight;
    }
    public BigDecimal getCargoCpt1WeightPoint() {
        return this.cargoCpt1WeightPoint;
    }
    public BigDecimal getCargoCpt2WeightPoint() {
        return this.cargoCpt2WeightPoint;
    }
    public BigDecimal getCargoCpt3WeightPoint() {
        return this.cargoCpt3WeightPoint;
    }
    public BigDecimal getCargoCpt4WeightPoint() {
        return this.cargoCpt4WeightPoint;
    }
    public BigDecimal getCargoCpt5WeightPoint() {
        return this.cargoCpt5WeightPoint;
    }
    public BigDecimal getPaxOAWeightPoint() {
        return this.paxOAWeightPoint;
    }
    public BigDecimal getPaxOBWeightPoint() {
        return this.paxOAWeightPoint;
    }
    public BigDecimal getPaxOCWeightPoint() {
        return this.paxOAWeightPoint;
    }

}
