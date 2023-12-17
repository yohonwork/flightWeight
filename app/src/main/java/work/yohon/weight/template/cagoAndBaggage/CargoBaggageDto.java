package work.yohon.weight.template.cagoAndBaggage;

import work.yohon.weight.template.basic.BasicDto;
import work.yohon.weight.template.passenger.PassengerDto;

public class CargoBaggageDto {
    private Baggage baggage;
    private Cargo cargo;
    private Comail comail;
    private long ttlDeadLoad;
    private BasicDto basicDtoForEstPayload;
    private PassengerDto passengetDtoForTotalPaxWeight;
    public CargoBaggageDto(
            Baggage baggage
            , Cargo cargo
            , Comail comail
            , BasicDto basicDtoForEstPayload
            , PassengerDto passengetDtoForTotalPaxWeight
    ) {
        this.baggage   = baggage;
        this.cargo = cargo;
        this.comail   = comail;
        this.ttlDeadLoad = this.baggage.getTotalWeight() + this.cargo.getTotalWeight() + this.comail.getTotalWeight();
        this.basicDtoForEstPayload = basicDtoForEstPayload;
        this.passengetDtoForTotalPaxWeight = passengetDtoForTotalPaxWeight;
    }

    public Baggage getBaggage() {
        return this.baggage;
    }

    public Cargo getCargo() {
        return this.cargo;
    }
    public Comail getComail() {
        return this.comail;
    }
    public void setBaggageCounts(long counts) {
        this.baggage.setCount(counts);
        update();
    }
    public void setBaggageWeight(long weight) {
        this.baggage.setWeight(weight);
        update();
    }
    public long getBaggageTotalWeight() {
        return this.baggage.getTotalWeight();
    }
    public void setCargoCounts(long counts) {
        this.cargo.setCount(counts);
        update();
    }
    public void setCargoWeight(long weight) {
        this.cargo.setWeight(weight);
        update();
    }
    public long getCargoTotalWeight() {
        return this.cargo.getTotalWeight();
    }
    public void setComailCounts(long counts) {
        this.comail.setCount(counts);
        update();
    }
    public void setComailWeight(long weight) {
        this.comail.setWeight(weight);
        update();
    }
    public long getComailTotalWeight() {
        return this.comail.getTotalWeight();
    }

    private void update() {
        this.ttlDeadLoad = this.baggage.getTotalWeight() + this.cargo.getTotalWeight() + this.comail.getTotalWeight();
    }
    public long getTtlDeadLoad() {
        return this.ttlDeadLoad;
    }
    public long getTtlPayload() {
        return passengetDtoForTotalPaxWeight.getTotalPaxWeight() + this.ttlDeadLoad;
    }
    public long getUnderLoad() {
        return this.basicDtoForEstPayload.getEstPayload().longValue() - getTtlPayload();
    }
}
