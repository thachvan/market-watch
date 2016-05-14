package ea.mw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ea.mw.dao.UserDao;
import ea.mw.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public void addUser(User user) {
		userDao.addUser(user);
	}

}
