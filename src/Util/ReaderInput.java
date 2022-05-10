package Util;

import java.util.*;

import Interface.FilesScan;

import java.io.*; 


public class ReaderInput implements FilesScan{
static List<List<String>> inputList =  new ArrayList<>();
	
	public void Filescan(String filePath) {
		String line = "";
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			br.readLine();
			while ((line = br.readLine()) != null)
			{
				String[] data = line.split(",");

				ArrayList<String> list = new ArrayList<String>();
				if(data.length == 3){
					list.add(data[0].toUpperCase());
					list.add(data[1]);
					list.add(data[2]);
					if(!CardData.cards.contains(data[2])) {
						//System.out.println("inserting t");
						CardData.cards.add(data[2]);
					
					}
					inputList.add(list);
			}else{
				System.out.println("New card details are inserted");
				list.add(data[0].toUpperCase());
					list.add(data[1]);
					list.add("");
					inputList.add(list);

			}

			}
            br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}