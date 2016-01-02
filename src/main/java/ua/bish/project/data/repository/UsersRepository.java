package ua.bish.project.data.repository;


import ua.bish.project.data.dao.User;
import ua.bish.project.data.repository.common.Operations;

public interface UsersRepository extends Operations<User, Integer> {
	public User getUserByEmail(String email);
}
