package ea.mw.dao;

import java.util.List;

import ea.mw.model.Symbol;

public interface SymbolDao {

	public void saveSymbol(Symbol symbol);
	public List<Symbol> listSymbols();

}
