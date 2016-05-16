package ea.mw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ea.mw.dao.SymbolDao;
import ea.mw.model.Symbol;

@Service
public class SymbolServiceImpl implements SymbolService {

	@Autowired
	private SymbolDao symbolDao;

	public void saveSymbol(Symbol symbol) {
		symbolDao.saveSymbol(symbol);
	}

	public List<Symbol> listSymbols() {
		return symbolDao.listSymbols();
	}

}
