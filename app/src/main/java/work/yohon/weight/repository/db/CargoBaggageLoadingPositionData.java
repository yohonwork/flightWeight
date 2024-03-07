package work.yohon.weight.repository.db;

import java.util.Arrays;
import java.util.LinkedList;

import work.yohon.weight.repository.entity.CargoCpt;

public class CargoBaggageLoadingPositionData {
    public static LinkedList<CargoCpt> repository = new LinkedList<>(Arrays.asList(
              new CargoCpt("CPT1", 1, -0.01153)
            , new CargoCpt("CPT2", 1, -0.0075)
            , new CargoCpt("CPT3", 1, 0.00588)
            , new CargoCpt("CPT4", 1, 0.01007)
            , new CargoCpt("CPT5", 1, 0.01263)

            , new CargoCpt("CPT1", 2, -0.01153)
            , new CargoCpt("CPT2", 2, -0.0075)
            , new CargoCpt("CPT3", 2, 0.00588)
            , new CargoCpt("CPT4", 2, 0.01007)
            , new CargoCpt("CPT5", 2, 0.01263)
    ));
}
