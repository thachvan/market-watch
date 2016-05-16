package ea.mw.dao;

import ea.mw.model.User;

public interface UserDao {

	public void saveUser(User user);
	public User getUser(String username);

}
