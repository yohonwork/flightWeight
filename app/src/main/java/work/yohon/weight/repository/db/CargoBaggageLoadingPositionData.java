package work.yohon.weight.repository.db;

import java.util.Arrays;
import java.util.LinkedList;

import work.yohon.weight.repository.entity.CargoCpt;

public class CargoBaggageLoadingPositionData {
    public static LinkedList<CargoCpt> repository = new LinkedList<>(Arrays.asList(
              new CargoCpt("CPT1", 1, -0.01146)
            , new CargoCpt("CPT2", 1, -0.00755)
            , new CargoCpt("CPT3", 1, 0.00588)
            , new CargoCpt("CPT4", 1, 0.01007)
            , new CargoCpt("CPT5", 1, 0.01291)
    ));
}
