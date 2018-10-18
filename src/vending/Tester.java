package vending;

import java.util.Scanner;

//import coins.Quarter;

public class Tester {

	public static void main(String [] args) {
		/*Quarter q = new Quarter();
		System.out.println(q.getValue());
		Stockpile s = new Stockpile(20);
		System.out.println(s.getCocaColaCount());
		System.out.println(s.getCocaColaZeroCount());
		s.decrementCocaColaCherryCount();
		System.out.println(s.getCocaColaCherryCount());*/
		//System.out.println(v.changeBox.getQuarters());
		//ExactChangeOnlyLight e = new ExactChangeOnlyLight();
		/*System.out.println("This is the vending machine simulator.\nPlease enter the starting "
				+ "stock of all items and the starting number of all coin types in the "
				+ "change box, in that order.\n"
				+ "(Two integers separated by a space)");
		Scanner input = new Scanner(System.in);
		Integer startStock = input.nextInt();
		System.out.println("Next");
		Integer startChange = input.nextInt();
		System.out.println("Constructing a vending machine with the following parameters: startStock = "
				+ startStock
				+", startChange = "
				+ startChange);
		System.out.print(".\n.\n.\n");*/
		VendingMachine v = new VendingMachine(20, 5);
		//System.out.println("Calling the function 'useVendingMachine':");
		v.useVendingMachine();
		//System.out.println("\n\nCalling 'useVendingMachine' again on the same vending machine:");
		//v.useVendingMachine();
		//System.out.println("\n\nSimulation complete.");
		//input.close();
	}
}
