package ea.mw.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ea.mw.model.Symbol;

@Repository
@Transactional
public class SymbolDaoImpl implements SymbolDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveSymbol(Symbol symbol) {
		Session session = sessionFactory.openSession();
		session.persist(symbol);
		session.flush();
	}

	public List<Symbol> listSymbols() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Symbol");
		
		@SuppressWarnings("unchecked")
		List<Symbol> symbolList = query.list();
		
		return symbolList;
	}
}
