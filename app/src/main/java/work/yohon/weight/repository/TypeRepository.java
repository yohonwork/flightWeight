package work.yohon.weight.repository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import work.yohon.weight.repository.db.TypeData;
import work.yohon.weight.repository.entity.Type;

public class TypeRepository implements Repository<Type> {
    private LinkedList<Type> repository;
    public TypeRepository() {
        this.repository = TypeData.repository;
    }

    @Override
    public Type findByName(String name) {
        for(Type row : repository) {
            if (row.getName().equals(name)) {
                return row;
            }
        }
        return null;
    }

    @Override
    public List<Type> findAll() {
        Type[] type = new Type[repository.size()];
        return Arrays.asList(repository.toArray(type));
    }
}
