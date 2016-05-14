package ea.mw.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ea.mw.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(User user) {
		Session session = sessionFactory.openSession();
		session.persist(user);
		session.flush();
		session.close();
	}
}
