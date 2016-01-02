package ua.bish.project.data.repository.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.bish.project.data.dao.User;
import ua.bish.project.data.repository.UsersRepository;
import ua.bish.project.data.repository.common.OperationsImpl;

import java.util.List;


@Repository("usersRepository")
public class UsersRepositoryImpl extends OperationsImpl<User, Integer> implements UsersRepository {

    public UsersRepositoryImpl() {
        setType(User.class);
    }

    @Override
    @Transactional
    public User getUserByEmail(String email) {
        Query query = getCurrentSession().createQuery("from User u where u.email = :email");
        query.setParameter("email", email);

        List<User> users = query.list();

        if(users != null && users.size() > 0){
            users.get(0);
        }
        return null;
    }
}