package possystem.inventory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class POSMain {
	private JFrame f_main_window;

	private JLabel l_barcode = new JLabel("Barcode");
	private JTextField tf_barcode_insert = new JTextField();
	private JButton b_add = new JButton("Add");
	private JButton b_del = new JButton("Clear");
	private JPanel p_top_part = new JPanel();
	private JTextArea ta_item_list = new JTextArea();
	private JTextArea ta_price_list = new JTextArea();
	private JScrollPane sp_item_list = new JScrollPane(ta_item_list);
	private JScrollPane sp_price_list = new JScrollPane(ta_price_list);
	private JPanel p_item = new JPanel(new GridLayout(1,2));
	private JLabel l_total = new JLabel("Total");
	private JTextField tf_total = new JTextField();
	private JLabel l_paid_amount = new JLabel("Paid");
	private JTextField tf_paid = new JTextField();
	private JButton b_paid_calc = new JButton("Amount paid");
	private JLabel l_balance = new JLabel("Balance");
	private JTextField tf_balance = new JTextField();
	private JPanel paid_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel total_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel bal_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel p_right_part = new JPanel(new GridLayout(3,1));
	
	String total_string;
	String paid_string = null;
	String bal_string;
	float amount;
	float total = 0;
	float paid_amount;
	float bal;
	
	public float ParseToFloat(String s) { //change string to float
		return Float.parseFloat(s);
	}
	
	public String ParseToString(float n) {
		return Float.toString(n);
	}
	
	public float CalculateTotal() {
		total = total + amount;
		return total;
	}

	public float CalculateBal(){
		bal = paid_amount - total;
		return bal;
	}
	
	public void MainWindow() {
		
		ItemList i_list = new ItemList();
		i_list.GetFile();
		i_list.ReadFromFile();
		
		f_main_window = new JFrame("Point Of Sale System");
		f_main_window.setVisible(true);
		f_main_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//float total1 = 0;
				int i = 0;
				for (i = 0; i < i_list.barcode.size(); i++) {
					if ((tf_barcode_insert.getText()).equals(i_list.barcode.elementAt(i))) {
						ta_item_list.insert("\n", 0);
						ta_price_list.insert("\n", 0);
						ta_item_list.insert(i_list.item_name.elementAt(i), 0);
						ta_price_list.insert(i_list.item_price.elementAt(i),0);  //create two text files
						amount = ParseToFloat(i_list.item_price.elementAt(i));
						total = total + amount;
						total_string = ParseToString(total);
						tf_total.setText(total_string);
						break;
					}	
				}
			}
		}
		);
		
		b_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ta_item_list.setText(null);
				ta_price_list.setText(null);
				tf_paid.setText(null);
				tf_total.setText(null);
				tf_balance.setText(null);
				amount = 0;
				total = 0;
			}
		});
		
		tf_barcode_insert.setColumns(35);
		
		tf_paid.setColumns(15);
		tf_total.setColumns(15);
		tf_total.setEditable(false);
		tf_balance.setColumns(15);
		tf_balance.setEditable(false);
		ta_item_list.setRows(10);
		ta_item_list.setEditable(false);
		ta_price_list.setEditable(false);
		
		p_top_part.add(l_barcode);
		p_top_part.add(tf_barcode_insert);
		p_top_part.add(b_add);
		p_top_part.add(b_del);
		p_item.add(sp_item_list);
		p_item.add(sp_price_list);
		paid_panel.add(l_paid_amount);
		paid_panel.add(tf_paid);
		b_paid_calc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					paid_amount = ParseToFloat(tf_paid.getText().toString());
					bal = paid_amount - total;
					bal_string = ParseToString(bal);
					tf_balance.setText(bal_string);
				}
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Paid amount cannot be empty");
				}}
		});
		paid_panel.add(b_paid_calc);
		total_panel.add(l_total);
		total_panel.add(tf_total);
		bal_panel.add(l_balance);
		bal_panel.add(tf_balance);
		p_right_part.add(paid_panel);
		p_right_part.add(total_panel);
		p_right_part.add(bal_panel);

		f_main_window.getContentPane().add(p_top_part, BorderLayout.NORTH);
		f_main_window.getContentPane().add(p_item, BorderLayout.CENTER);
		f_main_window.getContentPane().add(p_right_part, BorderLayout.EAST);
		f_main_window.pack();
	}
}