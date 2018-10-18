package vending;

public class CoinReturnLever {

	CoinReturnLever(ChangeBox c, DepositBox d){
		nativeChangeBox = c;
		nativeDepositBox = d;
	}

	public void onPull() {
		System.out.println("Returning entered money and clearing transaction.\n");
		Double amountToReturn = nativeDepositBox.amountMoney();
		if (amountToReturn == 0.0) {
			System.out.println("No change was entered, 0 coins returned");
			return;
		}
		nativeChangeBox.getDepositBoxContents(nativeDepositBox);
		nativeDepositBox.clearDepositBox();
		nativeChangeBox.giveChange(amountToReturn);
	}

	private ChangeBox nativeChangeBox;
	private DepositBox nativeDepositBox;
}
