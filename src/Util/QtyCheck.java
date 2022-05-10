package Util;

import java.util.*;

import Interface.Handler;
import Model.items;

import java.io.*; 

public class QtyCheck implements Handler{
	private Handler nextStep;
	public void setHandler(Handler nextHandler) {
		this.nextStep = nextHandler;
	}
	
	public void check(String filePath) {
		// Reading the Dataset file
		DataScan  read = new DataScan();
		read.Filescan("/Users/admin/Desktop/CMPE202/individual-project-preethibilla/src/resources/Dataset.csv");
		HashMap<String, items> dbitems = read.items;
		
		// Reading the Input file
		ReaderInput r1 = new ReaderInput();
		r1.Filescan(filePath);
		List<List<String>> inputdata = r1.inputList;

		boolean flag=false;
		boolean essflag=false;
		boolean luxuryflag=false;
		boolean miscflag=false;
		String lowQuantflag="";
		
		//Fetching the cap details for all categories
		CheckCapValue cap = CheckCapValue.getInstance();
		HashMap<String, Integer> category = cap.CategoryCap;
		int essentials = category.get("Essentials");
		int luxury = category.get("Luxury");
		int misc = category.get("Misc");
		int essentialstotal = 0;
		int luxurytotal = 0;
		int misctotal = 0;
		
		for (List<String> item: inputdata) {
			int quantity = Integer.parseInt(item.get(1));
			String itemName = item.get(0).toUpperCase();
			
			//String cardNumber = item.get(2);
			
			//Validating the Quantities 
			if(dbitems.get(itemName.toUpperCase()).quantity<quantity) {
				flag= true;
				lowQuantflag+= "Invalid quantity for "+itemName+" "+ item.get(1)+"\n";
			}
			
			//validating the cap for categories
			switch(dbitems.get(itemName.toUpperCase()).category) {
			case "Essentials":

				essentialstotal = essentialstotal + quantity;
				
				if(essentialstotal>essentials) {
					flag=true;
					essflag=true;
				}
				break;
				
			case "Luxury":

				luxurytotal = luxurytotal + quantity;
				
				if(luxurytotal>luxury) {
					flag=true;
					luxuryflag=true;
				}
				break;
				
			case "Misc":
			
				misctotal = misctotal + quantity;
				
				if(misctotal>misc) {
					flag=true;
					miscflag=true;
				}
				break;
			default:
				break;
			
			}
		}
		
		if(flag) {
			try {
			      FileWriter myWriter = new FileWriter("errors.txt");
			      myWriter.write("Please Correct the quantities "+ "\n");
			      myWriter.write(lowQuantflag);
			      if(lowQuantflag.equals("")) {
			    	  if(essflag)
			    	  myWriter.write("Items are out of stock for Essentials"+ "\n");
			    	  if(luxuryflag)
				    	  myWriter.write("Items are out of stock for Luxury"+ "\n");
			    	  if(miscflag)
				    	  myWriter.write("Items are out of stock for Misc"+ "\n");
			      }
			      myWriter.close();
			      System.out.println("Incomplete payment due to invalid quantities entered, check the error.txt file");
			    } catch (IOException e) {
			      System.out.println("An exception error occurred.");
			      e.printStackTrace();
			    }
			return;
		}

		nextStep.check(filePath);
		
	}


}
