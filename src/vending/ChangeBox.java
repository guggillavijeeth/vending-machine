package vending;

public class ChangeBox extends CoinBox {

	public ChangeBox(Integer quarters, Integer dimes, Integer nickels, ChangeReceiver c) {
		super(quarters, dimes, nickels);
		nativeChangeReceiver = c;
	}
	
	public void getDepositBoxContents(DepositBox deposit) {
		this.setQuarters(deposit.getQuarters());
		this.setDimes(deposit.getDimes());
		this.setNickels(deposit.getNickels());
	}
	
	public void giveChange(Double amountToReturn) {
		Integer cents = (int) (Math.round(100*amountToReturn));		
		Integer potentialQ, potentialD, potentialN, rest;
		Integer actualQ, actualD, actualN;
		
		potentialQ = cents/25;
		
		if(potentialQ <= this.getQuarters())
			actualQ = potentialQ;
		else
			actualQ = this.getQuarters();
		
		this.setQuarters(-actualQ);
		
		rest = cents-(25*actualQ);

		potentialD = rest/10;
		
		if(potentialD <= this.getDimes())
			actualD = potentialD;
		else
			actualD = this.getDimes();
		
		this.setDimes(-actualD);
		rest  -= (10*actualD);
		
		potentialN = rest/5;
		
		if(potentialN <= this.getNickels())
			actualN = potentialN;
		else
			actualN = this.getNickels();
		
		this.setNickels(-actualN);
		rest -= (5*actualN);
		
		nativeChangeReceiver.receiveQuarters(actualQ);
		nativeChangeReceiver.receiveDimes(actualD);
		nativeChangeReceiver.receiveNickels(actualN);
	}
	
	public boolean ableToGiveChange(Double amountToReturn) {
		Integer cents = (int) (Math.round(100*amountToReturn));
		Integer potentialQ, potentialD, potentialN, rest;
		Integer actualQ, actualD, actualN;
		
		potentialQ = cents/25;
		if(potentialQ <= this.getQuarters())
			actualQ = potentialQ;
		else
			actualQ = this.getQuarters();
		
		rest = cents-(25*actualQ);
		
		potentialD = rest/10;
		if(potentialD <= this.getDimes())
			actualD = potentialD;
		else
			actualD = this.getDimes();
		
		rest  -= (10*actualD);
		
		potentialN = rest/5;
		if(potentialN <= this.getNickels())
			actualN = potentialN;
		else
			actualN = this.getNickels();
		
		rest -= (5*actualN);

		if (rest==0) 
			return true;
		return false;
	}
	
	private ChangeReceiver nativeChangeReceiver;
}
