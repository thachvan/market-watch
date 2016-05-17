package ea.mw.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ea.mw.model.Symbol;

@Repository
public class SymbolDaoImpl implements SymbolDao {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public void saveSymbol(Symbol symbol) {
		entityManager.persist(symbol);
		entityManager.flush();
	}

	@Transactional
	public Symbol getSymbol(String name) {
		Symbol result;
		Query query = entityManager
				.createQuery("FROM Symbol WHERE name='" + name + "'");

		try {
			result = (Symbol) query.getSingleResult();
		} catch (NoResultException e) {
			result = null;
		}
		
		return result;
	}

	@Transactional
	public List<Symbol> listSymbols() {
		Query query = entityManager.createQuery("FROM Symbol");

		@SuppressWarnings("unchecked")
		List<Symbol> symbolList = query.getResultList();

		return symbolList;
	}
}
