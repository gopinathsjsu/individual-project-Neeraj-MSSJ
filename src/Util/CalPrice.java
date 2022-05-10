package Util;


import java.util.*;

import Interface.Handler;

import java.io.*; 

public class CalPrice implements Handler{
	private Handler nextStep;

	public void setHandler(Handler nextHandler) {
		this.nextStep = nextHandler;

	}

	public void check(String filePath) {
		double total=0;
		String outputstr = "";
		List<List<String>> inputList = ReaderInput.inputList;
		try (FileWriter fw = new FileWriter("output.csv")) {

			String output = "";
			
			 //fw.write("Total amount to be paid"+ "\n");

			for (List<String> item : inputList) {
				String itemName = item.get(0).toUpperCase();
				int itemQty = Integer.parseInt(item.get(1));
				double price = itemQty * DataScan.items.get(itemName.toUpperCase()).price;
				outputstr = outputstr + itemName+", " + itemQty +", " + price + "\n";

				//System.out.println("Price"+price);
				total+=price;


				
			}
			output = outputstr + "\n" + "Total Amount " + String.valueOf(total);
			fw.write(output);
			//fw.write(output);
		      System.out.println("Amount is successfully calculated");
		      fw.close();
		} catch (IOException e) {
			System.out.println("file not found output");
		}
	}

}
