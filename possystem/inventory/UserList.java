package possystem.inventory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class UserList {
	public Vector<String> username = new Vector<String>();
	public Vector<String> passwd = new Vector<String>();
	
	public void ReadFromFile(String u_name, String p_wd) {
		username.addElement(u_name);
        passwd.addElement(p_wd);
	}
	
	public void ReadFromFile(String file_path){
        String user_name = null;
        String password = null;
        System.out.println("File path in readfromfile: " +file_path);
    	
        try{
            BufferedReader infile = new BufferedReader(new FileReader(file_path));
            
            while (
                (   (user_name = infile.readLine()) != null  ) && 
                (   (password = infile.readLine()) != null   )
                 ) {
                
                //float price_new = Float.parseFloat(i_price);
                ReadFromFile(user_name, password);    
            }
            infile.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}