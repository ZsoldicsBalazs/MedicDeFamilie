package Repository;

import java.util.List;

public interface PacientRepoInterface<T> {

    List<T> findAll();

    boolean save(T entity);

    boolean update(T entity);

    T findById(int id);

    boolean delete(int entityId);
}
