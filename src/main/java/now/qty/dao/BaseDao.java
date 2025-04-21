package now.qty.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDao<K, E> {
    Optional<E> findById(K id);
    List<E> findAll();
    E add(E entity);
    E update(E entity);
    void delete(K id);
}