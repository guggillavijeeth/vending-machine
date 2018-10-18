package vending;

import java.util.Scanner;

public class VendingMachine {

	//Internals
	private Stockpile stock;
	private BillBox billBox;
	//External
	private ChangeReceiver changeSlot;
	//Internals
	private ChangeBox changeBox;
	private DepositBox depositBox;

	//Externals
	private Selector cocaCola;
	private Selector cocaColaZero;
	private Selector cocaColaCherry;
	private Selector sprite;
	private Selector fantaOrange;
	private Selector fantaGrape;
	private Selector barqs;
	private Selector melloYello;

	private BeverageReceiver beverageTray;
	private CoinInsertionSlot coinSlot;
	private BillInsertionSlot billSlot;
	private CoinReturnLever coinReturn;
	private ExactChangeOnlyLight changeLight;
	private Display machineLED;


	public VendingMachine(Integer startStock, Integer startChange) {
		//Internals
		stock = new Stockpile(startStock);
		billBox = new BillBox(0);
		//External
		changeSlot = new ChangeReceiver();
		//Internals
		changeBox = new ChangeBox(startChange, startChange, startChange, changeSlot);
		depositBox = new DepositBox(0, 0, 0);

		//Externals
		cocaCola = new Selector("Coke", billBox, changeBox, depositBox, stock);
		cocaColaZero = new Selector("Coke Zero", billBox, changeBox, depositBox, stock);
		cocaColaCherry = new Selector("Cherry Coke", billBox, changeBox, depositBox, stock);
		sprite = new Selector("Sprite", billBox, changeBox, depositBox, stock);
		fantaOrange = new Selector("Fanta Orange", billBox, changeBox, depositBox, stock);
		fantaGrape = new Selector("Fanta Grape", billBox, changeBox, depositBox, stock);
		barqs = new Selector("Barqs RB", billBox, changeBox, depositBox, stock);
		melloYello = new Selector("Mello Yello", billBox, changeBox, depositBox, stock);

		beverageTray = new BeverageReceiver();
		coinSlot = new CoinInsertionSlot(depositBox, stock.getMostExpensive(), changeSlot);
		billSlot = new BillInsertionSlot(billBox, depositBox, stock.getMostExpensive());
		coinReturn = new CoinReturnLever(changeBox, depositBox);
		changeLight = new ExactChangeOnlyLight(changeBox, stock);
		machineLED = new Display(depositBox);
	};

	public void useVendingMachine() {
		System.out.println("Welcome to your local Coca Cola vending machine!\n" 
				+ "'DISPLAY:' indicates the vending machine's LED readout at at the time\n"
				+ "A list of possible actions follows.\n"
				+ "This list will reappear after every 5 actions.\n");
		System.out.println("Enter 1 to Insert Quarters into Coin Slot\n"
				+ "Enter 2 to Insert Dimes into Coin Slot\n"
				+ "Enter 3 to Insert Nickels into Coin Slot\n"
				+ "Enter 4 to Insert Bills into Bill Slot\n"
				+ "Enter 5 to Pull Coin Return Lever\n"
				+ "Enter 6 to Click Coca Cola Button\n"
				+ "Enter 7 to Click Coca Cola Zero Button\n"
				+ "Enter 8 to Click Coca Cola Cherry Button\n"
				+ "Enter 9 to Click Sprite Button\n"
				+ "Enter 10 to Click Fanta Orange Button\n"
				+ "Enter 11 to Click Fanta Grape Button\n"
				+ "Enter 12 to Click Barqs Button\n"
				+ "Enter 13 to Click Mello Yello Button\n"
				+ "Enter 0 to Quit\n");

		if (!changeLight.isExactChangeAvailable())
			changeLight.switchLightOn();
		if (changeLight.isLit())
			changeLight.showLight();
		
		machineLED.displayCustom("Welcome!");
		
		Scanner in = new Scanner(System.in);
		Integer choice = in.nextInt();
		Integer count = 0;

		while(choice != 0) {
			
			count++;
			if ((count%10)==0) {
				System.out.println("1) Add quarters\n"
						+ "2) Add dimes\n"
						+ "3) Add nickels\n"
						+ "4) Add bills\n"
						+ "5) Coin return\n"
						+ "6) Coca Cola\n"
						+ "7) Coca Cola Zero\n"
						+ "8) Coca Cola Cherry\n"
						+ "9) Sprite\n"
						+ "10) Fanta Orange\n"
						+ "11) Fanta Grape\n"
						+ "12) Barqs\n"
						+ "13) Mello Yello");
			}
			switch (choice) {
			case 1:{
				System.out.println("Enter the number of quarters you would like to "
						+ "insert as a single integer:\n");
				Integer quarters = in.nextInt();
				coinSlot.insertQuarters(quarters);
				machineLED.displayMoneyIn();
				break;
			}
			case 2:{
				System.out.println("Enter the number of dimes you would like to "
						+ "insert as a single integer:\n");
				coinSlot.insertDimes(in.nextInt());
				machineLED.displayMoneyIn();
				break;
			}
			case 3:{
				System.out.println("Enter the number of nickels you would like to"
						+ "insert as a single integer");
				coinSlot.insertNickels(in.nextInt());
				machineLED.displayMoneyIn();
				break;
			}
			case 4:{
				System.out.println("Enter the number of dollar bills you would like to "
						+ "insert as a single integer:\n");
				billSlot.insertBills(in.nextInt());
				machineLED.displayMoneyIn();
				break;
			}
			case 5:{
				coinReturn.onPull();
				machineLED.displayCustom("Money Returned");
				break;
			}
			case 6:{
				Integer relevantStock = stock.getCocaColaCount();
				if (relevantStock == 0) {
					machineLED.displayCustom("OUT OF STOCK");
					break;
				}
				Double relevantPrice = stock.getCocaColaCost();
				if (cocaCola.onClick(relevantPrice)) {
					beverageTray.receiveBeverage("Coca Cola");
					machineLED.displayCustom("Have a nice day!");
					stock.decrementCocaColaCount();
				}
				else
					machineLED.displayCost(relevantPrice);
				break;
			}
			case 7:{
				Integer relevantStock = stock.getCocaColaZeroCount();
				if (relevantStock == 0) {
					machineLED.displayCustom("OUT OF STOCK");
					break;
				}
				Double relevantPrice = stock.getCocaColaZeroCost();
				if (cocaColaZero.onClick(relevantPrice)) {
					beverageTray.receiveBeverage("Coca Cola Zero");
					machineLED.displayCustom("Have a nice day!");
					stock.decrementCocaColaZeroCount();
				}
				else
					machineLED.displayCost(relevantPrice);
				break;
			}
			case 8:{
				Integer relevantStock = stock.getCocaColaCherryCount();
				if (relevantStock == 0) {
					machineLED.displayCustom("OUT OF STOCK");
					break;
				}
				Double relevantPrice = stock.getCocaColaCherryCost();
				if (cocaColaCherry.onClick(relevantPrice)) {
					beverageTray.receiveBeverage("Coca Cola Cherry");
					machineLED.displayCustom("Have a nice day!");
					stock.decrementCocaColaCherryCount();
				}
				else
					machineLED.displayCost(relevantPrice);
				break;
			}
			case 9:{
				Integer relevantStock = stock.getSpriteCount();
				if (relevantStock == 0) {
					machineLED.displayCustom("OUT OF STOCK");
					break;
				}
				Double relevantPrice = stock.getSpriteCost();
				if (sprite.onClick(relevantPrice)) {
					beverageTray.receiveBeverage("Sprite");
					machineLED.displayCustom("Have a nice day!");
					stock.decrementSpriteCount();
				}
				else
					machineLED.displayCost(relevantPrice);
				break;
			}
			case 10:{
				Integer relevantStock = stock.getFantaOrangeCount();
				if (relevantStock == 0) {
					machineLED.displayCustom("OUT OF STOCK");
					break;
				}
				Double relevantPrice = stock.getFantaOrangeCost();
				if (fantaOrange.onClick(relevantPrice)) {
					beverageTray.receiveBeverage("Fanta Orange");
					machineLED.displayCustom("Have a nice day!");
					stock.decrementFantaOrangeCount();
				}
				else
					machineLED.displayCost(relevantPrice);
				break;
			}
			case 11:{
				Integer relevantStock = stock.getFantaGrapeCount();
				if (relevantStock == 0) {
					machineLED.displayCustom("OUT OF STOCK");
					break;
				}
				Double relevantPrice = stock.getFantaGrapeCost();
				if (fantaGrape.onClick(relevantPrice)) {
					beverageTray.receiveBeverage("Fanta Grape");
					machineLED.displayCustom("Have a nice day!");
					stock.decrementFantaGrapeCount();
				}
				else
					machineLED.displayCost(relevantPrice);
				break;
			}
			case 12:{
				Integer relevantStock = stock.getBarqsCount();
				if (relevantStock == 0) {
					machineLED.displayCustom("OUT OF STOCK");
					break;
				}
				Double relevantPrice = stock.getBarqsCost();
				if (barqs.onClick(relevantPrice)) {
					beverageTray.receiveBeverage("Barqs RB");
					machineLED.displayCustom("Have a nice day!");
					stock.decrementBarqsCount();
				}
				else
					machineLED.displayCost(relevantPrice);
				break;
			}
			case 13:{
				Integer relevantStock = stock.getMelloYelloCount();
				if (relevantStock == 0) {
					machineLED.displayCustom("OUT OF STOCK");
					break;
				}
				Double relevantPrice = stock.getMelloYelloCost();
				if (melloYello.onClick(relevantPrice)) {
					beverageTray.receiveBeverage("Mello Yello");
					machineLED.displayCustom("Have a nice day!");
					stock.decrementMelloYelloCount();
				}
				else
					machineLED.displayCost(relevantPrice);
				break;
			}
			default:{
				System.out.println("Command not recognized, try again.\n");
				machineLED.displayCustom("Welcome!");
				break;
			}
			}
			
			System.out.println("Enter next command.\n");
			
			if (!changeLight.isExactChangeAvailable())
				changeLight.switchLightOn();
			else
				changeLight.switchLightOff();
			if (changeLight.isLit())
				changeLight.showLight();
			
			choice = in.nextInt();
		}
		in.close();
		machineLED.displayCustom("Welcome!");
		System.out.println("Thank you for your business, have a nice day!");
	}
}
