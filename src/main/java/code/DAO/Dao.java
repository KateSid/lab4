package code.DAO;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Object get(int id);
    Object getByName(String name);
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(T t);
    void saveOrUpdate(T t);
}
