package work.yohon.weight.repository.db;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;

import work.yohon.weight.repository.Type2;

public class TemplateData {
    private static LinkedList<Type2> repository = new LinkedList<>(Arrays.asList(
            new Type2("gtype", 75, 35, 8, 0, BigDecimal.valueOf(-0.01153), BigDecimal.valueOf(-0.0075), BigDecimal.valueOf(0.00588), BigDecimal.valueOf(0.01007), BigDecimal.valueOf(0.01263),BigDecimal.valueOf(-0.01091), BigDecimal.valueOf(-0.00133), BigDecimal.valueOf(0.00962))
    ));

    public static Type2 findByName(String name) {
        Type2 retValue = null;
        for (Type2 row : repository) {
            if (row.getName().equals(name)) {
                retValue = row;
                return retValue;
            }
        }
        return retValue;
    }
}
