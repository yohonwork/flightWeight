package work.yohon.weight.repository;

import java.util.List;

public interface Repository<T> {
    public T findByName(String name);
    public List<T> findAll();
}
