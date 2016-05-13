package ea.mw.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PortfolioItem {
	private enum TradingType {
		Sell, Buy
	};

	@Id
	@GeneratedValue
	private int id;

	@OneToOne
	@JoinColumn(name = "symbol_id")
	private Symbol symbol;

	private double orginalPrice;
	private double volume;

	@Enumerated(EnumType.STRING)
	private TradingType type;

	public TradingType getType() {
		return type;
	}

	public void setType(TradingType type) {
		this.type = type;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getOrginalPrice() {
		return orginalPrice;
	}

	public void setOrginalPrice(double orginalPrice) {
		this.orginalPrice = orginalPrice;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}
}
