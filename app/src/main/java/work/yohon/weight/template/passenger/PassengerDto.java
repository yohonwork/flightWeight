package work.yohon.weight.template.passenger;

import static work.yohon.weight.common.Utils.isNull;

public class PassengerDto {
    private final PassengerAdult passengerAdult;
    private final PassengerChild passengerChild;
    private final PassengerInf passengerInfants;
    private final PassengerCabinBag passengerCabinBagDto;

    public PassengerDto(work.yohon.weight.repository.entity.Passenger passenger) {
        if (isNull(passenger)) {
            throw new IllegalArgumentException("passenger is Null");
        }
        this.passengerAdult    = new PassengerAdult(0, passenger.getAdultWeight());
        this.passengerChild    = new PassengerChild(0, passenger.getChildWeight());
        this.passengerInfants  = new PassengerInf(0, passenger.getInfantsWeight());
        this.passengerCabinBagDto = new PassengerCabinBag(0, passenger.getCarbinBagWeight());
    }

    public String getTotalPaxString() {
        long adultHeads = this.passengerAdult.getHeadcount();
        long childHeads = this.passengerChild.getHeadcount();
        long heads = adultHeads + childHeads;

        long countForInf = this.passengerInfants.getHeadcount();

        return "${heads} + ${INF} INF"
                .replace("${heads}", String.valueOf(heads))
                .replace("${INF}", String.valueOf(countForInf))
                ;
    }

    public long getTotalPaxWeight() {
        return passengerAdult.getTotalWeight()
                + passengerChild.getTotalWeight()
                + passengerInfants.getTotalWeight()
                + passengerCabinBagDto.getTotalWeight();
    }

    public PassengerAdult getPassengerAdult() {
        return this.passengerAdult;
    }
    public PassengerChild getPassengerChild() {
        return this.passengerChild;
    }
    public PassengerInf getPassengerInfants() {
        return this.passengerInfants;
    }
    public PassengerCabinBag getPassengerCabinBag() {
        return this.passengerCabinBagDto;
    }

    public void setAdultHeads(long heads) {
        this.passengerAdult.setHeadcount(heads);
    }
    public long getAdultTotalWeight() {
        return this.passengerAdult.getTotalWeight();
    }

    public void setChildHeads(long heads) {
        this.passengerChild.setHeadcount(heads);
    }
    public long getChildTotalWeight() {
        return this.passengerChild.getTotalWeight();
    }
    public void setInfHeads(long heads) {
        this.passengerInfants.setHeadcount(heads);
    }
    public long getInfTotalWeight() {
        return this.passengerInfants.getTotalWeight();
    }
    public void setCabinGagCount(long counts) {
        this.passengerCabinBagDto.setCount(counts);
    }
    public long getCabinbagTotalWeight() {
        return this.passengerCabinBagDto.getTotalWeight();
    }
}
