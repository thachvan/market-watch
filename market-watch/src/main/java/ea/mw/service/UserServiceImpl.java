package ea.mw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ea.mw.dao.UserDao;
import ea.mw.model.PortfolioItem;
import ea.mw.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	public void addPortfolioItem(User user, PortfolioItem item) {
		user.addPortfolioItem(item);
		saveUser(user);
	}

	public List<PortfolioItem> getPortfolio(User user) {
		return user.getPortfolio();
	}

	public User getUser(String username) {
		return userDao.getUser(username);
	}

}
