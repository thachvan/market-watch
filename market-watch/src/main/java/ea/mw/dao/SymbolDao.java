package ea.mw.dao;

import java.util.List;

import ea.mw.model.Symbol;

public interface SymbolDao {

	public void saveSymbol(Symbol symbol);
	public Symbol getSymbol(String name);
	public List<Symbol> listSymbols();

}
