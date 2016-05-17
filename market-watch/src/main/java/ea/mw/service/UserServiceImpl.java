package ea.mw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import ea.mw.dao.UserDao;
import ea.mw.model.PortfolioItem;
import ea.mw.model.User;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
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
