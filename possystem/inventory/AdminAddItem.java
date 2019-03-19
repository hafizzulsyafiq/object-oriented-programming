package possystem.inventory;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminAddItem {
	private JFrame f_add_item;
    private JLabel l_barcode;
    private JLabel l_item_name;
    private JLabel l_item_price;
    private JTextField tf_barcode;
    private JTextField tf_item_name;
    private JTextField tf_item_price;
    
    private JButton b_ok_button;
    private JButton b_cancel_button;

    //Panels for each componenet
    private JPanel p_barcode;
    private JPanel p_item_name;
    private JPanel p_item_price;
    
    //panel for button
    private JPanel p_button_okcancel;
    
    public void AddItemWindow(){
    	ItemList i_list = new ItemList();

        //Window frame
        f_add_item = new JFrame("Add Items");
        f_add_item.setVisible(true);
        //f_add_item.setDefaultCloseOperation();

        //Labels
        l_barcode = new JLabel("Bar Code");
        l_item_name = new JLabel("Item Name");
        l_item_price = new JLabel("Price");

        //Text fields
        tf_barcode = new JTextField();
        tf_barcode.setColumns(20);
        tf_item_name = new JTextField();
        tf_item_name.setColumns(20);
        tf_item_price = new JTextField();
        tf_item_price.setColumns(20);
        
        //Buttons
        b_ok_button = new JButton("OK");
        b_ok_button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		i_list.barcode.addElement(tf_barcode.getText().toString());
        		i_list.item_name.addElement(tf_item_name.getText().toString());
        		i_list.item_price.addElement(tf_item_price.getText().toString());
        		i_list.WriteToFile();
        		JOptionPane.showMessageDialog(null, "Item is successfully added");
        		
        		f_add_item.setVisible(false);
        	}
        });
        b_cancel_button = new JButton("Cancel");
        b_cancel_button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		f_add_item.setVisible(false);
        	}
        });

        //Barcode Panel
        p_barcode = new JPanel();
        p_barcode.add(l_barcode);
        p_barcode.add(tf_barcode);

        //Item Name Panel
        p_item_name = new JPanel();
        p_item_name.add(l_item_name);
        p_item_name.add(tf_item_name);

        //Price Panel
        p_item_price = new JPanel();
        p_item_price.add(l_item_price);
        p_item_price.add(tf_item_price);
        
        /*
        //Discount rate Panel
        p_discount_rate = new JPanel();
        p_discount_rate.add(l_discount_rate, BorderLayout.EAST);
        p_discount_rate.add(tf_discount_rate);
        */
        
        //buttons panel
        p_button_okcancel = new JPanel();
        p_button_okcancel.add(b_ok_button);
        p_button_okcancel.add(b_cancel_button);
        
        //Grid Layout
        f_add_item.getContentPane().setLayout(new GridLayout(5, 2));
        f_add_item.getContentPane().add(p_barcode);
        f_add_item.getContentPane().add(p_item_name);
        f_add_item.getContentPane().add(p_item_price);
        f_add_item.getContentPane().add(p_button_okcancel);
        f_add_item.pack();
    }
}