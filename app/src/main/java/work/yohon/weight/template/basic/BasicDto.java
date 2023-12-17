package work.yohon.weight.template.basic;

import java.math.BigDecimal;

public class BasicDto {
    private BigDecimal dow;
    private BigDecimal index;
    private BigDecimal takeOffFuel;
    private BigDecimal tripFuel;
    private BigDecimal fuelIndex;
    private BigDecimal landingIndex;
    private BigDecimal estPayload;

    public BasicDto(BigDecimal dow, BigDecimal index, BigDecimal takeOffFuel, BigDecimal tripFuel, BigDecimal fuelIndex, BigDecimal landingIndex, BigDecimal estPayload) {
        this.dow          = dow;
        this.index        = index;
        this.takeOffFuel  = takeOffFuel;
        this.tripFuel     = tripFuel;
        this.fuelIndex    = fuelIndex;
        this.landingIndex = landingIndex;
        this.estPayload   = estPayload;
    }

    public BigDecimal getDow() {
        return this.dow;
    }

    public BigDecimal getIndex() {
        return this.index;
    }

    public BigDecimal getTakeOffFuel() {
        return this.takeOffFuel;
    }

    public BigDecimal getTripFuel() {
        return this.tripFuel;
    }

    public BigDecimal getFuelIndex() {
        return this.fuelIndex;
    }

    public BigDecimal getLandingIndex() {
        return this.landingIndex;
    }

    public BigDecimal getEstPayload() {
        return this.estPayload;
    }
    public void setDow(double dow) {
        this.dow = BigDecimal.valueOf(dow);
    }
    public void setIndex(double index) {
        this.index = BigDecimal.valueOf(index);
    }
    public void setTakeOffFuel(double takeOffFuel) {
        this.takeOffFuel = BigDecimal.valueOf(takeOffFuel);
    }
    public void setTripFuel(double tripFuel) {
        this.tripFuel = BigDecimal.valueOf(tripFuel);
    }
    public void setFuelIndex(double fuelIndex) {
        this.fuelIndex = BigDecimal.valueOf(fuelIndex);
    }
    public void setLandingIndex(double landingIndex) {
        this.landingIndex = BigDecimal.valueOf(landingIndex);
    }
    public void setEstPayload(double estPayload) {
        this.estPayload = BigDecimal.valueOf(estPayload);
    }


}
