import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.Year;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.PanelUI;
import javax.swing.text.html.ImageView;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class SettingScreen extends JFrame implements ItemListener {

	private JPanel contentPane;
	
    String [] colorStrings = {"black","blue","cyan","darkgray","gray","green","lightgray","magneta","orange","pink","red","white","yellow"};
    
    String [] light_colStrings = {"cyan","green","yellow","lightgray","orange","white","pink","gray"};
    String [] dark_colStrings = {"black","blue","darkgray","magneta","red"};	    
    
    
    JComboBox comboBox;
    JComboBox comboBox_1;
    JComboBox comboBox_4;
    JComboBox comboBox_5;
    
    JPanel panel_3;
    JPanel panel_4;
    
    HashMap<String,Integer> color_comb = new HashMap<>();
	public SettingScreen() {
		
		for(int i=0;i<light_colStrings.length;i++) {
			color_comb.put(light_colStrings[i],0);
		}
		for(int i=0;i<dark_colStrings.length;i++) {
			color_comb.put(dark_colStrings[i],1);
		}
		
		this.setTitle("Settings");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(250,150,800,520);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		this.setContentPane(contentPane);
		this.setVisible(true);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.WHITE));
		panel_1.setBackground(Color.GRAY);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setPreferredSize(new Dimension(10, 60));
		panel_2.setOpaque(true);
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 784, 26);
		panel_5.setPreferredSize(new Dimension(10, 22));
		panel_5.setForeground(Color.WHITE);
		panel_2.add(panel_5);
		panel_5.setOpaque(true);
		panel_5.setLayout(null);
		
		comboBox_5 = new JComboBox(colorStrings);
		comboBox_5.setFocusable(false);
		comboBox_5.setBorder(new LineBorder(Color.DARK_GRAY));
		comboBox_5.addItemListener(this);
		comboBox_5.setBounds(343, 2, 94, 22);
		panel_5.add(comboBox_5);
		
		comboBox_1 = new JComboBox(colorStrings);
		comboBox_1.setFocusable(false);
		comboBox_1.setBorder(new LineBorder(Color.DARK_GRAY));
		comboBox_1.setBounds(10, 32, 94, 22);
		panel_2.add(comboBox_1);
		comboBox_1.addItemListener(this);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.WHITE));
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setPreferredSize(new Dimension(120, 10));
		panel_3.setOpaque(true);
		panel_1.add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(null);
		
		comboBox = new JComboBox(colorStrings);
		comboBox.setFocusable(false);
		comboBox.setBounds(10, 10, 100, 22);
		panel_3.add(comboBox);
		comboBox.addItemListener(this);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setOpaque(true);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("___________________");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 425, 100, 13);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("___________________");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(551, 425, 100, 13);
		panel_4.add(lblNewLabel_2);
		
		comboBox_4 = new JComboBox(colorStrings);
		comboBox_4.setFocusable(false);
		comboBox_4.setBounds(290, 398, 94, 20);
		panel_4.add(comboBox_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 10, 317, 384);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(337, 10, 317, 384);
		panel_4.add(panel_7);
		panel_7.setLayout(null);
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		String a;
		
		if(e.getSource()==comboBox) {
			a = String.valueOf(comboBox.getSelectedItem());
			NewNoteBookPage.book_list_panel.setBackground(MyColor.getColor(a));
			if(color_comb.get(a)==0) {
				
				NewNoteBookPage.lblNewLabel_5.setForeground(ColorUIResource.BLACK);
				NewNoteBookPage.lblNewLabel_4.setForeground(ColorUIResource.BLACK);
				NewNoteBookPage.date_created_lbl.setForeground(ColorUIResource.BLACK);
				NewNoteBookPage.date_lbl.setForeground(ColorUIResource.BLACK);
				NewNoteBookPage.date_mod_lbl.setForeground(ColorUIResource.BLACK);
				NewNoteBookPage.last_mod_lbl.setForeground(ColorUIResource.BLACK);
				NewNoteBookPage.lblNewLabel_3.setForeground(ColorUIResource.BLACK);
				for(int i=0;i<20;i++) {
					NewNoteBookPage.book_list[i].setForeground(ColorUIResource.BLACK);
				}
				NewNoteBookPage.Your_nbs_label.setForeground(ColorUIResource.BLACK);
				NewNoteBookPage.create_new_nb_btn.setForeground(ColorUIResource.BLACK);
			}
			else {
				
				NewNoteBookPage.lblNewLabel_5.setForeground(ColorUIResource.WHITE);
				NewNoteBookPage.lblNewLabel_4.setForeground(ColorUIResource.LIGHT_GRAY);
				NewNoteBookPage.date_created_lbl.setForeground(ColorUIResource.LIGHT_GRAY);
				NewNoteBookPage.date_lbl.setForeground(ColorUIResource.WHITE);
				NewNoteBookPage.date_mod_lbl.setForeground(ColorUIResource.WHITE);
				NewNoteBookPage.last_mod_lbl.setForeground(ColorUIResource.LIGHT_GRAY);
				NewNoteBookPage.lblNewLabel_3.setForeground(ColorUIResource.BLACK);
				for(int i=0;i<20;i++) {
					NewNoteBookPage.book_list[i].setForeground(ColorUIResource.WHITE);
				}
				NewNoteBookPage.Your_nbs_label.setForeground(ColorUIResource.LIGHT_GRAY);
				NewNoteBookPage.create_new_nb_btn.setForeground(ColorUIResource.WHITE);
			}
		}
		else if(e.getSource()==comboBox_1) {
			a = String.valueOf(comboBox_1.getSelectedItem());
			NewNoteBookPage.Functions_panel.setBackground(MyColor.getColor(a));
			if(color_comb.get(a)==0) {
				System.out.println("yes");
				NewNoteBookPage.textField.setBorder(new LineBorder(ColorUIResource.BLACK,1));
				NewNoteBookPage.textField_1.setBorder(new LineBorder(ColorUIResource.BLACK,1));
				NewNoteBookPage.insert_new_page_tf.setBorder(new LineBorder(ColorUIResource.BLACK,1));
				
				NewNoteBookPage.insert_new_page_lbl.setForeground(ColorUIResource.BLACK);
				NewNoteBookPage.current_nb_label.setForeground(ColorUIResource.BLACK);
				NewNoteBookPage.current_notebook_shower.setForeground(ColorUIResource.BLACK);
				NewNoteBookPage.lblNewLabel.setForeground(ColorUIResource.BLACK);
				NewNoteBookPage.lblNewLabel_1.setForeground(ColorUIResource.BLACK);
				NewNoteBookPage.lblNewLabel_2.setForeground(ColorUIResource.BLACK);
				NewNoteBookPage.lblNewLabel_3.setForeground(ColorUIResource.BLACK);
				
				NewNoteBookPage.delete_book_btn.setBorder(null);
				NewNoteBookPage.btnNewButton.setBorder(null);
				NewNoteBookPage.btnNewButton_1.setBorder(null);
				NewNoteBookPage.change_font_btn.setBorder(null);
					
				
				
			}
			else {
				System.out.println("no");
				NewNoteBookPage.textField.setBorder(null);
				NewNoteBookPage.textField_1.setBorder(null);
				NewNoteBookPage.insert_new_page_tf.setBorder(null);
				
				NewNoteBookPage.insert_new_page_lbl.setForeground(ColorUIResource.WHITE);
				NewNoteBookPage.current_nb_label.setForeground(ColorUIResource.WHITE);
				NewNoteBookPage.current_notebook_shower.setForeground(ColorUIResource.WHITE);
				NewNoteBookPage.lblNewLabel.setForeground(ColorUIResource.WHITE);
				NewNoteBookPage.lblNewLabel_1.setForeground(ColorUIResource.WHITE);
				NewNoteBookPage.lblNewLabel_2.setForeground(ColorUIResource.WHITE);
				NewNoteBookPage.lblNewLabel_3.setForeground(ColorUIResource.WHITE);
				
				if(a=="gray") {
					System.out.println("this is there");
					NewNoteBookPage.delete_book_btn.setBorder(new LineBorder(ColorUIResource.WHITE,1));
					NewNoteBookPage.btnNewButton.setBorder(new LineBorder(ColorUIResource.WHITE,1));
					NewNoteBookPage.btnNewButton_1.setBorder(new LineBorder(ColorUIResource.WHITE,1));
					NewNoteBookPage.change_font_btn.setBorder(new LineBorder(ColorUIResource.WHITE,1));
				}
				else {
					NewNoteBookPage.delete_book_btn.setBorder(null);
					NewNoteBookPage.btnNewButton.setBorder(null);
					NewNoteBookPage.btnNewButton_1.setBorder(null);
					NewNoteBookPage.change_font_btn.setBorder(null);
				}
			}
		}
		else if(e.getSource()==comboBox_4) {
			a = String.valueOf(comboBox_4.getSelectedItem());
			NewNoteBookPage.pages_panel.setBackground(MyColor.getColor(a));
			if(color_comb.get(a)==0) {
				NewNoteBookPage.Enter_page_no_lbl_left.setForeground(ColorUIResource.BLACK);
				NewNoteBookPage.Enter_page_no_lbl_right.setForeground(ColorUIResource.BLACK);
				NewNoteBookPage.leftpage_lbl.setForeground(ColorUIResource.BLACK);
				NewNoteBookPage.rightpage_lbl.setForeground(ColorUIResource.BLACK);
				if(a=="white") {
					NewNoteBookPage.page_no_tf_left.setBorder(new LineBorder(ColorUIResource.BLACK,1));
					NewNoteBookPage.page_no_tf_right.setBorder(new LineBorder(ColorUIResource.BLACK,1));
				}
				else {
					NewNoteBookPage.page_no_tf_left.setBorder(null);
					NewNoteBookPage.page_no_tf_right.setBorder(null);
				}
				if(a=="lightgray") {
					NewNoteBookPage.left_btn_next.setBorder(new LineBorder(ColorUIResource.BLACK,1));
					NewNoteBookPage.left_btn_prev.setBorder(new LineBorder(ColorUIResource.BLACK,1));
					NewNoteBookPage.right_btn_next.setBorder(new LineBorder(ColorUIResource.BLACK,1));
					NewNoteBookPage.left_btn_prev.setBorder(new LineBorder(ColorUIResource.BLACK,1));
					NewNoteBookPage.delete_pg_btn_left.setBorder(new LineBorder(ColorUIResource.BLACK,1));
					NewNoteBookPage.delete_pg_btn_right.setBorder(new LineBorder(ColorUIResource.BLACK,1));
					
				}
				else {
					
					NewNoteBookPage.left_btn_next.setBorder(null);
					NewNoteBookPage.left_btn_prev.setBorder(null);
					NewNoteBookPage.right_btn_next.setBorder(null);
					NewNoteBookPage.left_btn_prev.setBorder(null);
					NewNoteBookPage.delete_pg_btn_left.setBorder(null);
					NewNoteBookPage.delete_pg_btn_right.setBorder(null);
				}
			}
			else {
				
				NewNoteBookPage.Enter_page_no_lbl_left.setForeground(ColorUIResource.WHITE);
				NewNoteBookPage.Enter_page_no_lbl_right.setForeground(ColorUIResource.WHITE);
				NewNoteBookPage.leftpage_lbl.setForeground(ColorUIResource.WHITE);
				NewNoteBookPage.rightpage_lbl.setForeground(ColorUIResource.WHITE);
				
				NewNoteBookPage.left_btn_next.setBorder(null);
				NewNoteBookPage.left_btn_prev.setBorder(null);
				NewNoteBookPage.right_btn_next.setBorder(null);
				NewNoteBookPage.right_btn_prev.setBorder(null);
				NewNoteBookPage.delete_pg_btn_left.setBorder(null);
				NewNoteBookPage.delete_pg_btn_right.setBorder(null);
				NewNoteBookPage.page_no_tf_left.setBorder(null);
				NewNoteBookPage.page_no_tf_right.setBorder(null);
				
			}
		}
		else if(e.getSource()==comboBox_5) {
			a = String.valueOf(comboBox_5.getSelectedItem());
			NewNoteBookPage.menuBar.setBackground(MyColor.getColor(a));
			if(color_comb.get(a)==0) {
				NewNoteBookPage.fileMenu.setForeground(MyColor.getColor("darkgray"));
				NewNoteBookPage.helpMenu.setForeground(MyColor.getColor("darkgray"));
			}
			else {
				NewNoteBookPage.fileMenu.setForeground(MyColor.getColor("lightgray"));
				NewNoteBookPage.helpMenu.setForeground(MyColor.getColor("lightgray"));
			}
		}
		else if(e.getSource()==comboBox_5) {
			a = String.valueOf(comboBox_5.getSelectedItem());
			NewNoteBookPage.menuBar.setBackground(MyColor.getColor(a));
		}
	}
}
