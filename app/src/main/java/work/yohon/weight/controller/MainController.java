package work.yohon.weight.controller;

import java.math.BigDecimal;

import work.yohon.weight.MainActivity;
import work.yohon.weight.service.MainService;
import work.yohon.weight.service.Service;
import work.yohon.weight.template.TypeSpinner;
import work.yohon.weight.template.basic.Basic;
import work.yohon.weight.template.basic.BasicDto;
import work.yohon.weight.template.cagoAndBaggage.CargoBaggage;
import work.yohon.weight.template.cgoBaggageLoadingPosition.CgoBaggageLoadingPostion;
import work.yohon.weight.template.finalplan.Finalplan;
import work.yohon.weight.template.passenger.Passenger;
import work.yohon.weight.template.paxZone.PaxZone;

public class MainController implements Controller {
    private final Service service;
    private final MainActivity context;

    public MainController (MainActivity context) {
        this.context = context;
        this.service = new MainService();
    }

    public void createLayer() {
        TypeSpinner typeSpinner = new TypeSpinner(this.context);
        BasicDto basicDto = new BasicDto(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,BigDecimal.ZERO, BigDecimal.ZERO,BigDecimal.ZERO);
        Basic basic = new Basic(this.context, basicDto);
        Passenger passenger = new Passenger(this.context, typeSpinner.getType());
        CargoBaggage cargoBaggage = new CargoBaggage(this.context, basicDto, passenger.getPassengerDto());
        CgoBaggageLoadingPostion cgoBaggageLoadingPostion = new CgoBaggageLoadingPostion(this.context, typeSpinner.getType(), cargoBaggage.getCargoBaggageDto());
        PaxZone paxZone = new PaxZone(this.context, typeSpinner.getType(), passenger.getPassengerDto());
        Finalplan finalplan = new Finalplan(this.context);
    }

}
