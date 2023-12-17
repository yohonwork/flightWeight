package work.yohon.weight.service;

import java.math.BigDecimal;

import work.yohon.weight.repository.PassengerRepository;
import work.yohon.weight.repository.Repository;
import work.yohon.weight.repository.Type2;
import work.yohon.weight.repository.entity.Passenger;
import work.yohon.weight.template.Template;
import work.yohon.weight.template.basic.BasicDto;

public class MainService implements Service {

    private Repository<Type2> repository;
    private PassengerRepository passengerRepository;

    public MainService() {
        this.repository = repository;
        this.passengerRepository = new PassengerRepository();
    }

    public Template getTemplate(String typename) {
        Type2 type = repository.findByName(typename);
        BasicDto basic = new BasicDto(BigDecimal.valueOf(48519), BigDecimal.valueOf(41.81), BigDecimal.valueOf(18000), BigDecimal.valueOf(11863), BigDecimal.valueOf(-10), BigDecimal.valueOf(-6), BigDecimal.valueOf(18500));
        Template template = new Template(basic, null, null, null, null, null, null);
        return template;
    }

    @Override
    public Type2 getTemplates() {
        return null;
    }

    public Passenger getPassengerByTypeSeq(int typeSeq) {
        return passengerRepository.findByTypeSeq(typeSeq);
    }
}
