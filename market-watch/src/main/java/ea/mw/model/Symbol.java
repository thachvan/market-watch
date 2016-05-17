package ea.mw.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Symbol {
	@Id
	private String name;

	private double bid;
	private double ask;

	public Symbol() {
	}

	public Symbol(String name) {
		this.name = name;
	}

	public Symbol(String name, double ask, double bid) {
		this.name = name;
		this.ask = ask;
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public double getAsk() {
		return ask;
	}

	public void setAsk(double ask) {
		this.ask = ask;
	}

}
