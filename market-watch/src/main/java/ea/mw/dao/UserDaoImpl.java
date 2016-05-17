package ea.mw.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ea.mw.model.PortfolioItem;
import ea.mw.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/*
	 * public void init() throws IOException { Symbol symbol = new
	 * Symbol("XAU"); symbol.setAsk(1023); symbol.setBid(1025);
	 * 
	 * User user = new User(); user.setName("a"); user.setUsername("a");
	 * user.setPassword("a"); user.setEnabled(true);
	 * user.setAuthority(Role.ROLE_USER); user.addPortfolioItem( new
	 * PortfolioItem(symbol, 1.5, 1002, TradingType.BUY));
	 * 
	 * saveUser(user); }
	 */

	@Transactional
	public void saveUser(User user) {
		entityManager.persist(user);
		entityManager.flush();
	}

	@Transactional
	public User getUser(String username) {
		Query query = entityManager.createQuery(
				"SELECT u FROM User u WHERE u.username = '" + username + "'");
		User user = (User) query.getSingleResult();
		query = entityManager
				.createQuery("FROM PortfolioItem p WHERE p.user.username = '"
						+ username + "'");
		@SuppressWarnings("unchecked")
		List<PortfolioItem> portfolio = query.getResultList();
		for (PortfolioItem item : portfolio) {
			user.addPortfolioItem(item);
		}

		return user;
	}
}
