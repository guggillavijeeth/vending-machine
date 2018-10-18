package vending;

public class ChangeReceiver {

	public ChangeReceiver() {};

	public void receiveQuarters(Integer quarters) {
		if(quarters > 0)
			System.out.println(quarters + " quarter(s) returned as change");
	}

	public void receiveDimes(Integer dimes) {
		if(dimes > 0)
			System.out.println(dimes + " dime(s) returned as change");
	}

	public void receiveNickels(Integer nickels) {
		if(nickels > 0)
			System.out.println(nickels + " nickel(s) returned as change");
	}
}
