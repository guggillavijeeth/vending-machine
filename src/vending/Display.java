package vending;

public class Display {

	Display(DepositBox d){
		nativeDepositBox = d;
	}
	
	public void displayMoneyIn() {
		Double moneyIn = nativeDepositBox.amountMoney();
		String message = String.format("%.2f", moneyIn);
		System.out.println("DISPLAY: " + message);
	}
	
	public void displayCost(Double cost) {
		String message = String.format("%.2f", cost);
		System.out.println("DISPLAY: " + message);
	}
	
	public void displayCustom(String message) {
		System.out.println("DISPLAY: " + message);
	}
	
	private DepositBox nativeDepositBox;
}
