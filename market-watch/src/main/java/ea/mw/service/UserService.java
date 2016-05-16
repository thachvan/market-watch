package ea.mw.service;

import java.util.List;

import ea.mw.model.PortfolioItem;
import ea.mw.model.User;

public interface UserService {
	public void saveUser(User user);
	public void addPortfolioItem(User user, PortfolioItem item);
	public List<PortfolioItem> getPortfolio(User user);
	public User getUser(String username);
}
