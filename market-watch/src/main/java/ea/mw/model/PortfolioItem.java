package ea.mw.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PortfolioItem {
	public enum TradingType {
		Sell, Buy
	};

	@Id
	@GeneratedValue
	private int id;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "symbol_id")
	private Symbol symbol;

	@Column(name = "original_price")
	private double orginalPrice;
	private double volume;

	@Enumerated(EnumType.STRING)
	private TradingType type;

	public PortfolioItem(Symbol symbol, double volume, double originalPrice,
			TradingType type) {
		this.symbol = symbol;
		this.volume = volume;
		this.orginalPrice = originalPrice;
		this.type = type;
	}

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
