package ea.mw.dao;

import java.io.IOException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ea.mw.model.PortfolioItem;
import ea.mw.model.PortfolioItem.TradingType;
import ea.mw.model.Symbol;
import ea.mw.model.User;
import ea.mw.model.User.Role;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void init() throws IOException {
		Symbol symbol = new Symbol("XAU");
		symbol.setAsk(1023);
		symbol.setBid(1025);

		User user = new User();
		user.setName("a");
		user.setUsername("a");
		user.setPassword("a");
		user.setEnabled(true);
		user.setAuthority(Role.ROLE_USER);
		user.addPortfolioItem(
				new PortfolioItem(symbol, 1.5, 1002, TradingType.Buy));

		saveUser(user);
	}

	public void saveUser(User user) {
		Session session = sessionFactory.openSession();
		session.persist(user);
		session.flush();
	}

	public User getUser(String username) {
		Session session = sessionFactory.openSession();
		Query query = session
				.createQuery("FROM User WHERE Username = '" + username + "'");
		return (User) query.uniqueResult();
	}
}
