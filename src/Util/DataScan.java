package Util;

import java.io.BufferedReader;
import java.io.*;
import java.util.HashMap;

import Interface.FilesScan;
import Model.*;

public class DataScan implements FilesScan {
    static HashMap<String, items> items = new HashMap<String, items>();

    public void Filescan(String filePath) {
        String line = "";
        try {

            BufferedReader br = new BufferedReader(new FileReader(filePath));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] dataset = line.split(",");
                int quant = Integer.parseInt(dataset[2]);//
                double price = Double.parseDouble(dataset[3]);
                items newDataitem = new items(dataset[1], dataset[0].toUpperCase(), quant, price);
                items.put(dataset[0].toUpperCase(), newDataitem);
                // System.out.println(dataset[1]);

            }
            br.close();

        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
