package ua.bish.project.data.repository.common;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


public class OperationsImpl<T, PK extends Serializable> implements GenericRepository<T, PK>{
	
	private Class<T> type;

    @Autowired
    private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	public PK create(T newInstance) {
		return (PK) getCurrentSession().save(newInstance);
	}

	@SuppressWarnings("unchecked")
	public T read(PK id) {
		return (T) getCurrentSession().get(type, id);
	}

	public void update(T transientObject) {
        getCurrentSession().update(transientObject);
		
	}

	public void delete(T persistentObject) {
        getCurrentSession().delete(persistentObject);		
	}
	
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
	
	@SuppressWarnings("unchecked")
	protected void setType(Class type) {
        this.type = type;
    }

    protected Class<T> getType() {
        return type;
    }

}