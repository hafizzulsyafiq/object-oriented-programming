package possystem.inventory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AdminRemoveItem {
	private JFrame f_remove_item;
	private JLabel l_remove_item;
	private JTextField tf_remove_item;
	private JButton b_ok;
	private JPanel p_top_part = new JPanel();
	private JPanel p_middle_part = new JPanel();
	private JPanel p_button = new JPanel();
	
	public void RemoveItemWindow() {
		f_remove_item = new JFrame("Remove Specific Item");
        f_remove_item.setVisible(true);
        
        l_remove_item = new JLabel("Enter the item barcode which to be removed");
        tf_remove_item = new JTextField();
        tf_remove_item.setColumns(30);
        b_ok = new JButton("OK");
        
        p_top_part.add(l_remove_item);
        p_middle_part.add(tf_remove_item);
        p_button.add(b_ok);
        
        f_remove_item.add(p_top_part, BorderLayout.NORTH);
        f_remove_item.add(p_middle_part, BorderLayout.CENTER);
        f_remove_item.add(p_button, BorderLayout.SOUTH);
        f_remove_item.pack();
	}
}