package work.yohon.weight.template.cgoBaggageLoadingPosition;

import work.yohon.weight.template.cagoAndBaggage.CargoBaggageDto;

public class CgoBaggageLoadingPositionDto {
    private final CargoCpt cpt1;
    private final CargoCpt cpt2;
    private final CargoCpt cpt3;
    private final CargoCpt cpt4;
    private final CargoCpt cpt5;
    private final CargoBaggageDto cargoBaggageDtoFoDeadload;

    public CgoBaggageLoadingPositionDto(CargoCpt cpt1, CargoCpt cpt2, CargoCpt cpt3, CargoCpt cpt4, CargoCpt cpt5, CargoBaggageDto cargoBaggageDtoFoDeadload) {
        this.cpt1 = cpt1;
        this.cpt2 = cpt2;
        this.cpt3 = cpt3;
        this.cpt4 = cpt4;
        this.cpt5 = cpt5;
        this.cargoBaggageDtoFoDeadload = cargoBaggageDtoFoDeadload;
    }

    public long getCpt1Weight () {
        return this.cpt1.getWeight();
    }
    public double getCpt1WeightPoint() {
        return this.cpt1.getWeightPoint();
    }
    public double getCpt1DeadloadPoint() { return this.cpt1.getDeadloadPoint(); }
    public long getCpt2Weight () {
        return this.cpt2.getWeight();
    }
    public double getCpt2WeightPoint() {
        return this.cpt2.getWeightPoint();
    }
    public double getCpt2DeadloadPoint() { return this.cpt2.getDeadloadPoint(); }
    public long getCpt3Weight () {
        return this.cpt3.getWeight();
    }
    public double getCpt3WeightPoint() {
        return this.cpt3.getWeightPoint();
    }
    public double getCpt3DeadloadPoint() { return this.cpt3.getDeadloadPoint(); }
    public long getCpt4Weight () {
        return this.cpt4.getWeight();
    }
    public double getCpt4WeightPoint() {
        return this.cpt4.getWeightPoint();
    }
    public double getCpt4DeadloadPoint() { return this.cpt4.getDeadloadPoint(); }
    public long getCpt5Weight () {
        return this.cpt5.getWeight();
    }
    public double getCpt5WeightPoint() {
        return this.cpt5.getWeightPoint();
    }
    public double getCpt5DeadloadPoint() { return this.cpt5.getDeadloadPoint(); }
    public long getDeadload() {
        return this.getCpt1Weight() + this.getCpt2Weight() + this.getCpt3Weight() + this.getCpt4Weight() + this.getCpt5Weight();
    }
    public long getAvailableSpace() {
        return this.cargoBaggageDtoFoDeadload.getTtlDeadLoad() - getDeadload();
    }
    private long totalCptWeight() {
        return cpt1.getWeight() + cpt2.getWeight() + cpt3.getWeight() + cpt4.getWeight() + cpt5.getWeight();
    }
    public void setCpt1Weight(long weight) {
        this.cpt1.setWeight(weight);
    }
    public void setCpt2Weight(long weight) {
        this.cpt2.setWeight(weight);
    }
    public void setCpt3Weight(long weight) {
        this.cpt3.setWeight(weight);
    }
    public void setCpt4Weight(long weight) {
        this.cpt4.setWeight(weight);
    }
    public void setCpt5Weight(long weight) {
        this.cpt5.setWeight(weight);
    }
}
