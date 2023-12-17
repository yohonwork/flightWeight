package work.yohon.weight.repository.db;

import java.util.Arrays;
import java.util.LinkedList;

import work.yohon.weight.repository.entity.Passenger;

public class PassengerData {
    public static LinkedList<Passenger> repository = new LinkedList<>(Arrays.asList(
        new Passenger(1, 1, 75, 35, 8, 0)
    ));
}
