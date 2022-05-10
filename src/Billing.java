import Util.CardData;
import Util.CalPrice;
import Util.QtyCheck;

import java.util.*;
public class Billing {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter input file for testing:");
		String filepath = sc.nextLine();
		sc.close();
		// System.out.println("filepath: "+filepath);
		CardData carddata = new CardData();
		carddata.readCarddata("/Users/admin/Desktop/CMPE202/individual-project-preethibilla/src/resources/Cards.csv");
		QtyCheck qtycheck = new QtyCheck();
		CalPrice pricecalculation = new CalPrice();
		// CheckCap checkcap = new CheckCap();
		qtycheck.setHandler(pricecalculation);
		qtycheck.check(filepath);
		// System.out.println("Hello world");
		System.out.println("Cards present and inserted are:");
		CardData.cards.forEach((element) -> {
			System.out.println(element);
		});

	}

}
