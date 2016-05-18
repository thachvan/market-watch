package ea.mw.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	public void saveUser(User user) {
		entityManager.merge(user);
		entityManager.flush();
	}

	@Transactional
	public User getUser(String username) {
		Query query = entityManager.createQuery(
				"SELECT u FROM User u LEFT JOIN FETCH u.portfolio WHERE u.username = '"
						+ username + "'");
		User user = (User) query.getSingleResult();

		return user;
	}
}
