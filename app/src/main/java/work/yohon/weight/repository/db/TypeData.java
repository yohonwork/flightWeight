package work.yohon.weight.repository.db;

import java.util.Arrays;
import java.util.LinkedList;

import work.yohon.weight.repository.entity.Type;

public class TypeData {
    public static LinkedList<Type> repository = new LinkedList<>(Arrays.asList(
            new Type(1, "G TYPE")
            , new Type(2, "K TYPE")
            , new Type(3, "O TYPE")
    ));
}