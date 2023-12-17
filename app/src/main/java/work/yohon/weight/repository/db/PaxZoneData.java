package work.yohon.weight.repository.db;

import java.util.Arrays;
import java.util.LinkedList;

import work.yohon.weight.repository.entity.PaxForPaxZone;

public class PaxZoneData {
    public static LinkedList<PaxForPaxZone> repository = new LinkedList<>(Arrays.asList(
              new PaxForPaxZone(1, 1, "PAX OA", -0.00975)
            , new PaxForPaxZone(2, 1, "PAX OB", 0.00049)
            , new PaxForPaxZone(3, 1, "PAX OC", 0.01103)
    ));
}
