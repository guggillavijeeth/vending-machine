package vending;

public class BillBox {

	public BillBox(Integer bills) {
		numberBills = bills;
	}
	
	public Integer getBills() {
		return numberBills;
	}
	public void setBills(Integer transformation) {
		numberBills += transformation;
	}
	
	private Integer numberBills;
}
