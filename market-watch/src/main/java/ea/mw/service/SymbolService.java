package ea.mw.service;

import java.util.List;

import ea.mw.model.Symbol;

public interface SymbolService {
	
	public void saveSymbol(Symbol symbol);
	public List<Symbol> listSymbols();
}
