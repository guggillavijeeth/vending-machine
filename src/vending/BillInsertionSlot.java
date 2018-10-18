package vending;

public class BillInsertionSlot {

	public BillInsertionSlot(BillBox b, DepositBox d, double highPrice) {
		nativeBillBox = b;
		nativeDepositBox = d;
		mostExpensive = highPrice;
	}

	public void insertBills(Integer bills) {
		for (Integer i=0; i<bills; i++) {
			if (nativeDepositBox.amountMoney() < mostExpensive) {
				nativeBillBox.setBills(1);
				nativeDepositBox.setBillsEntered(1);
			}
			else {
				System.out.println("The bill insertion slot spit back " + (bills-i) + " bills because money "
						+"entered already exceeds maximum transaction cost.");
				break;
			}
		}
	}

	private BillBox nativeBillBox;
	private DepositBox nativeDepositBox;
	private Double mostExpensive;
}
