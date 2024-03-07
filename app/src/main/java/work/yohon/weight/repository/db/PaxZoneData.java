package work.yohon.weight.repository.db;

import java.util.Arrays;
import java.util.LinkedList;

import work.yohon.weight.repository.entity.PaxForPaxZone;

public class PaxZoneData {
    public static LinkedList<PaxForPaxZone> repository = new LinkedList<>(Arrays.asList(
              new PaxForPaxZone(1, 1, "PAX OA", -0.01091)
            , new PaxForPaxZone(2, 1, "PAX OB", -0.00133)
            , new PaxForPaxZone(3, 1, "PAX OC", 0.00962)

            , new PaxForPaxZone(4, 2, "PAX OA", -0.01081)
            , new PaxForPaxZone(5, 2, "PAX OB", -0.00128)
            , new PaxForPaxZone(6, 2, "PAX OC", 0.00962)
    ));
}
