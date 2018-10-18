package vending;

public class CoinInsertionSlot {

	public CoinInsertionSlot(DepositBox d, Double highPrice, ChangeReceiver c) {
		nativeDepositBox = d;
		mostExpensive = highPrice;
		nativeChangeReceiver = c;
	}
	
	public void insertQuarters(Integer quarters) {
		for (Integer i=0; i<quarters; i++) {
			if (nativeDepositBox.amountMoney() < mostExpensive)
				nativeDepositBox.setQuarters(1);
			else {
				System.out.println(quarters-i + " quarter(s) not accepted because money "
						+"entered already exceeds maximum transaction cost.");
				nativeChangeReceiver.receiveQuarters(quarters-i);
				break;
			}
		}
	}
	
	public void insertDimes(Integer dimes) {
		for (Integer i=0; i<dimes; i++) {
			if (nativeDepositBox.amountMoney() < mostExpensive)
				nativeDepositBox.setDimes(1);
			else {
				System.out.println(dimes-i + " dime(s) not accepted because money "
						+"entered already exceeds maximum transaction cost.");
				nativeChangeReceiver.receiveDimes(dimes-i);
				break;
			}
		}
	}
	
	public void insertNickels(Integer nickels) {
		for (Integer i=0; i<nickels; i++) {
			if (nativeDepositBox.amountMoney() < mostExpensive)
				nativeDepositBox.setNickels(1);
			else {
				System.out.println(nickels-i + " nickel(s) not accepted because money "
						+"entered already exceeds maximum transaction cost.");
				nativeChangeReceiver.receiveNickels(nickels-i);
				break;
			}
		}
	}
	
	private DepositBox nativeDepositBox;
	private Double mostExpensive;
	private ChangeReceiver nativeChangeReceiver;
}
