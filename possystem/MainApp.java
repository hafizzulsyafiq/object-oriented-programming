package possystem;
import java.io.File;

import javax.swing.JFileChooser;

import possystem.inventory.ItemList;
import possystem.inventory.LoginScreen;
import possystem.inventory.UserList;

public class MainApp{
	//private JFileChooser choose_item_file = new JFileChooser();
	
	
    public static void main(String[] args){
    	MainApp main_app = new MainApp();
    	UserList u_list = new UserList();
    	ItemList i_list = new ItemList();
    	
    	/*
    	main_app.choose_user_file.showOpenDialog(null);
    	File f_user = main_app.choose_user_file.getSelectedFile();
    	u_list.ReadFromFile(f_user.getAbsolutePath());
    	*/
    	
    	/*
    	choose_item_file.showOpenDialog(null);
    	File f_item = choose_item_file.getSelectedFile();
    	i_list.ReadFromFile(f_item.getAbsolutePath());
    	*/
    	
        LoginScreen lo = new LoginScreen();
        lo.LoginScreenDialog();
    }
}