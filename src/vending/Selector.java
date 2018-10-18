package vending;

public class Selector {

	public Selector(String drink, BillBox b, ChangeBox c, DepositBox d, Stockpile s) {
		drinkName = drink;
		nativeBillBox = b;
		nativeChangeBox = c;
		nativeDepositBox = d;
	}
	
	public String getDrinkName() {
		return drinkName;
	}
	
	private String drinkName;
	private BillBox nativeBillBox;
	private ChangeBox nativeChangeBox;
	private DepositBox nativeDepositBox;
	
	public boolean onClick(Double price){
		Double paidSoFar = nativeDepositBox.amountMoney();
		if (paidSoFar < price) {
			System.out.println("Not enough money entered to buy this selection.");
			return false;
		}
		Double changeToGive = paidSoFar-price;
		nativeChangeBox.getDepositBoxContents(nativeDepositBox);
		nativeDepositBox.clearDepositBox();
		nativeChangeBox.giveChange(changeToGive);
		return true;
	}
}
