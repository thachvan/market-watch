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

	public Symbol getSymbol(String name) {
		Symbol result = symbolDao.getSymbol(name);

		if (result == null) { // symbol does not exist
			return new Symbol(name, 0, 0);
		}

		return result;
	}

	public List<Symbol> listSymbols() {
		return symbolDao.listSymbols();
	}

}
