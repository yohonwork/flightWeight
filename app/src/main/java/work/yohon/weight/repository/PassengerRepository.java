package work.yohon.weight.repository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import work.yohon.weight.repository.db.PassengerData;
import work.yohon.weight.repository.entity.Passenger;

public class PassengerRepository implements Repository<Passenger> {
    private LinkedList<Passenger> repository;
    public PassengerRepository() {
        this.repository = PassengerData.repository;
    }

    @Override
    public Passenger findByName(String name) {
        return null;
    }

    @Override
    public List<Passenger> findAll() {
        Passenger[] list = new Passenger[repository.size()];
        return Arrays.asList(repository.toArray(list));
    }

    public Passenger findByTypeSeq(long typeSeq) {
       Passenger returnValue = null;
        for(Passenger passenger : repository) {
            if(passenger.getTypeSeq() == typeSeq) {
                returnValue = passenger;
            }
        }
        return returnValue;
    }
}
