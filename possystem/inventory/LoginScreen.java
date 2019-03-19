package possystem.inventory;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class LoginScreen {
	private JLabel l_username;
	private JLabel l_password;
	private JTextField tf_username;
	private JPasswordField tf_password;
	private JButton b_ok_button;
	private JPanel p_username;
	private JPanel p_password;
	private JPanel p_button;
	private JFrame f_login;
	private JFileChooser choose_user_file = new JFileChooser();
	
	public void LoginScreenDialog(){
		UserList u_list = new UserList();
		AdminUser adm = new AdminUser();
		POSMain p = new POSMain();
		ItemList i_list = new ItemList();
		
		choose_user_file.showDialog(null, "Choose User File");
    	File f_user = choose_user_file.getSelectedFile();
    	u_list.ReadFromFile(f_user.getAbsolutePath());
    	
		//Frame Dialog
		f_login = new JFrame("Login");
		f_login.setVisible(true);
		f_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Label
		l_username = new JLabel("Username");
		l_password = new JLabel("Password");
		
		//Text Field
		tf_username = new JTextField();
		tf_username.setColumns(20);
		tf_password = new JPasswordField();
		tf_password.setColumns(20);
		
		//btn
		b_ok_button = new JButton("OK");
		b_ok_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = 0;
				while (i <= u_list.username.size()) {
					
					if(i < u_list.username.size()) {
						if ( 
								( tf_username.getText() ).equals( u_list.username.elementAt(0) ) &&
								( tf_password.getText() ).equals( u_list.passwd.elementAt(0) )
							) {
							adm.AdminWindow();
							f_login.setVisible(false);
							break;
						}
						if ( 
								( tf_username.getText() ).equals( u_list.username.elementAt(i) ) &&
								( tf_password.getText() ).equals( u_list.passwd.elementAt(i) )
							) {
							p.MainWindow();
							f_login.setVisible(false);
							break;
						}
						if ( 
								!( tf_username.getText() ).equals( u_list.username.elementAt(i) ) ||
								!( tf_password.getText() ).equals( u_list.passwd.elementAt(i) )
							) {
							i++;
						}	
					}
					if (i == u_list.passwd.size()) {
						JOptionPane.showMessageDialog(null, "Your User ID and/or password is incorrect");
						break;
					}
				}
			}
		});
		
		//Username Panel
		p_username = new JPanel();
		p_username.add(l_username);
		p_username.add(tf_username);
		
		//password panel
		p_password = new JPanel();
		p_password.add(l_password);
		p_password.add(tf_password); 
		
		//btl panel
		p_button = new JPanel();
		p_button.add(b_ok_button);
		
		//add all to frame
		f_login.getContentPane().setLayout(new GridLayout(3, 2));
		f_login.getContentPane().add(p_username);
		f_login.getContentPane().add(p_password);
		f_login.getContentPane().add(p_button);
		f_login.pack();
	}
}