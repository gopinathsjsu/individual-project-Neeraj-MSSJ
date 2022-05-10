package Util;

import java.util.*;
import java.io.*; 

public class CardData {
	public static Set<String> cards = new HashSet<String>();
	
	public void readCarddata(String filePath) {
		String line = "";
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			br.readLine();
			while ((line = br.readLine()) != null) 
			{
				String[] card = line.split(",");
				cards.add(card[0]);
				//System.out.println("card data:"+card[0]);
	
			}
            br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
	}	
	
}
