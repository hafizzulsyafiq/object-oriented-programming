package possystem.inventory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFileChooser;

public class ItemList{
	public Vector<String> barcode = new Vector<String>();
	public Vector<String> item_name = new Vector<String>();
	public Vector<String> item_price = new Vector<String>();
	
	private JFileChooser choose_item_file = new JFileChooser();
	private static File f_item;
	

	public void insert_element(String b_code, String i_name, String i_price){
		barcode.addElement(b_code);
		item_name.addElement(i_name);
		item_price.addElement(i_price);
	}
	
	public void GetFile() {
		choose_item_file.showDialog(null, "Choose Item File");
		f_item = choose_item_file.getSelectedFile();
	}
      

	public void ReadFromFile(){
		String bar_code = null;
        String i_name = null;
        String i_price = null;
        System.out.println("F item in read forom file func: " +f_item.getAbsolutePath());

        try{
            BufferedReader infile = new BufferedReader(new FileReader(f_item.getAbsolutePath()));
            
            while (
                (   (bar_code = infile.readLine()) != null  ) && 
                (   (i_name = infile.readLine()) != null    ) && 
                (   (i_price = infile.readLine()) != null   )
                 ) {
                
                //float price_new = Float.parseFloat(i_price);
                insert_element(bar_code, i_name, i_price);  
            }
            infile.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void WriteToFile() {
        try{
            BufferedWriter outfile = new BufferedWriter(new FileWriter("\\ItemList.txt"));
            
            int i;
            for(i = 0; i < barcode.size(); i++) {
            	outfile.write(barcode.elementAt(i));
            	outfile.newLine();
            	outfile.write(item_name.elementAt(i));
            	outfile.newLine();
            	outfile.write(item_price.elementAt(i));
            	outfile.newLine();
            	
            }
            outfile.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}