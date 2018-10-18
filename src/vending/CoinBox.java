package vending;

public abstract class CoinBox {

	public CoinBox(Integer quarters, Integer nickels, Integer dimes) {
		numberQuarters = quarters;
		numberDimes = dimes;
		numberNickels = nickels;
	}
	
	public Integer getQuarters() {
		return numberQuarters;
	}
	public void setQuarters(Integer transformation) {
		numberQuarters += transformation;
	}

	public Integer getDimes() {
		return numberDimes;
	}
	public void setDimes(Integer transformation) {
		numberDimes += transformation;
	}
	
	public Integer getNickels() {
		return numberNickels;
	}
	public void setNickels(Integer transformation) {
		numberNickels += transformation;
	}
	
	protected Integer numberQuarters;
	protected Integer numberNickels;
	protected Integer numberDimes;
	
	public Double amountMoney() {
		return 0.25*numberQuarters + 0.10*numberDimes + 0.05*numberNickels;
	}
	
}
