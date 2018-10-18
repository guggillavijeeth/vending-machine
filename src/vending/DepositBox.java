package vending;

public class DepositBox extends CoinBox {

	public DepositBox(Integer quarters, Integer dimes, Integer nickels) {
		super(quarters, dimes, nickels);
		billsEntered = 0;
	}

	public Integer getBillsEntered() {
		return billsEntered;
	}

	public void setBillsEntered(Integer transformation) {
		billsEntered += transformation;
	}

	//TODO FIX THIS METHOD, IT CRASHES EVERYTHING!!
	public void clearDepositBox() {
		Integer currentQ = getQuarters();
		Integer currentD = getDimes();
		Integer currentN = getNickels();
		Integer currentB = getBillsEntered();
		this.setQuarters(-currentQ);
		this.setDimes(-currentD); 
		this.setNickels(-currentN);
		this.setBillsEntered(-currentB);
	}
	
	//TODO THIS ONE DOESN'T WORK EITHER, WHY??
	@Override
	public Double amountMoney() {
		return 0.25*(double)(getQuarters()) + 0.10*(double)(getDimes()) 
		+ 0.05*(double)(getNickels()) + (double)getBillsEntered();	
	}

	private Integer billsEntered;
}
