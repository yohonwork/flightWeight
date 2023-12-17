package work.yohon.weight.template;

import java.util.Observable;

import work.yohon.weight.template.basic.BasicDto;
import work.yohon.weight.template.cagoAndBaggage.CargoBaggageDto;
import work.yohon.weight.template.cagoAndBaggage.LoadDto;
import work.yohon.weight.template.cgoBaggageLoadingPosition.CgoBaggageLoadingPostion;
import work.yohon.weight.template.finalplan.Finalplan;
import work.yohon.weight.template.passenger.PassengerDto;
import work.yohon.weight.template.paxZone.PaxZoneDto;

public class Template extends Observable {
    private BasicDto basic;
    private PassengerDto passengerDto;
    private CargoBaggageDto cargoBaggageDto;
    private LoadDto loadDto;
    private CgoBaggageLoadingPostion cgoBaggageLoadingPostion;
    private PaxZoneDto paxZoneDto;
    private Finalplan finalplan;

    public Template(BasicDto basic, PassengerDto passengerDto, CargoBaggageDto cargoBaggageDto, LoadDto loadDto, CgoBaggageLoadingPostion cgoBaggageLoadingPostion, PaxZoneDto paxZoneDto, Finalplan finalplan) {
        this.basic                    = basic;
        this.passengerDto             = passengerDto;
        this.cargoBaggageDto          = cargoBaggageDto;
        this.loadDto                  = loadDto;
        this.cgoBaggageLoadingPostion = cgoBaggageLoadingPostion;
        this.paxZoneDto               = paxZoneDto;
        this.finalplan                = finalplan;
    }

    public BasicDto getBasic() {
        return this.basic;
    }
    public PassengerDto getPassenger() {
        return this.passengerDto;
    }
    public CargoBaggageDto getCargoBaggage() {
        return this.cargoBaggageDto;
    }

}
