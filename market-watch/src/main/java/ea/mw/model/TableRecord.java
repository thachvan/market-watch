package ea.mw.model;

import ea.mw.model.PortfolioItem.TradingType;

public class TableRecord {
	private int id;
	private String symbolName;
	private double volume;
	private double originalPrice;
	private TradingType type;
	private double ask;
	private double bid;
	private double profit;
	
	public String getSymbolName() {
		return symbolName;
	}
	
	public void setSymbolName(String symbolName) {
		this.symbolName = symbolName;
	}
	
	public double getVolume() {
		return volume;
	}
	
	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	public double getOriginalPrice() {
		return originalPrice;
	}
	
	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public TradingType getType() {
		return type;
	}

	public void setType(TradingType type) {
		this.type = type;
	}
	
	public double getAsk() {
		return ask;
	}
	
	public void setAsk(double ask) {
		this.ask = ask;
	}
	
	public double getBid() {
		return bid;
	}
	
	public void setBid(double bid) {
		this.bid = bid;
	}
	
	public double getProfit() {
		return profit;
	}
	
	public void setProfit(double profit) {
		this.profit = profit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
