package services;

import java.util.List;

/**
 * Created by Raymond Phua on 31-10-2016.
 */
public interface DefaultService<T> {

    T find(long id);
    List<T> findAll();
    T create(T t);
    void update(T t);
    void delete(T t);
}
