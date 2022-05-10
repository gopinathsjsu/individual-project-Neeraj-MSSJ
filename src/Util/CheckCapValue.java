package Util;


import java.util.*;
import Model.*;

public class CheckCapValue {
	private static CheckCapValue checkcapvalue = null;
	static HashMap<String, items> items = new HashMap<String, items>();
	static HashMap<String,Integer> CategoryCap = new HashMap<String,Integer>();
	private CheckCapValue() {
		CategoryCap.put("Essentials",10);
		CategoryCap.put("Luxury",10);
		CategoryCap.put("Misc",10);
		
	}

	public static CheckCapValue getInstance() {
		if (checkcapvalue != null)
			return checkcapvalue;
		else {
			checkcapvalue = new CheckCapValue();
			return checkcapvalue;
		}
	}

}

