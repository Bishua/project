package ua.bish.project.data.repository.common;

import java.io.Serializable;

public interface Operations<T, PK extends Serializable> {

    PK create(T newInstance);

    T read(PK id);

    void update(T transientObject);

    void delete(T persistentObject);
}