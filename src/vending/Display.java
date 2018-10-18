package vending;

public class Display {

	Display(DepositBox d){
		nativeDepositBox = d;
	}
	
	public void displayMoneyIn() {
		Double moneyIn = nativeDepositBox.amountMoney();
		String message = String.format("%.2f", moneyIn);
		System.out.println("\nDISPLAY: $" + message+"\n");
	}
	
	public void displayCost(Double cost) {
		String message = String.format("%.2f", cost);
		System.out.println("\nDISPLAY: Cost: $" + message+"\n");
	}
	
	public void displayCustom(String message) {
		System.out.println("\nDISPLAY: " + message+"\n");
	}
	
	private DepositBox nativeDepositBox;
}
