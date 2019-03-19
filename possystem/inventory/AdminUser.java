package possystem.inventory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminUser {
	private JFrame f_admin;
	private JLabel l_welcome_admin;
	private JButton b_add_items;
	private JButton b_remove_items;
	private JPanel p_button;
	private JPanel p_label;
	
	public void AdminWindow(){
		AdminAddItem aaitem = new AdminAddItem();
		AdminRemoveItem rmitem = new AdminRemoveItem();
	        
		//Window Frame
		f_admin = new JFrame("Administrator Login");
	    f_admin.setVisible(true);
	    f_admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    //Top label
	    l_welcome_admin = new JLabel("Welcome, Inventory Manager!");
	    l_welcome_admin.setFont(new Font("Calibri", Font.BOLD, 20));
	    
	    //Button Options
	    b_add_items = new JButton("Add new Items");
	    b_add_items.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		aaitem.AddItemWindow();
	    	}
	    });
	    b_remove_items = new JButton("Remove existing items");
	    b_remove_items.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		rmitem.RemoveItemWindow();
	    	}
	    });

	    //Panel for buttons, center
	    p_button = new JPanel();
	    p_button.add(b_add_items);
	    p_button.add(b_remove_items);

	    //Panel for label, north
	    p_label = new JPanel();
	    p_label.add(l_welcome_admin);

	    //Add all panels to frame
	    f_admin.getContentPane().add(p_button, BorderLayout.SOUTH);
	    f_admin.getContentPane().add(p_label, BorderLayout.NORTH);
	    f_admin.pack();
	}
}