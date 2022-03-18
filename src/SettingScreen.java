import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
    private ImageIcon txtareapic = new ImageIcon(new ImageIcon("both_text_areas.png").getImage().getScaledInstance(641,409,100));
	
    String [] colorStrings = {"black","blue","cyan","darkgray","gray","green","lightgray","magneta","orange","pink","red","white","yellow"};
    
    String [] light_colStrings = {"cyan","gray","green","yellow","lightgray","orange","white","pink"};
    String [] dark_colStrings = {"black","blue","darkgray","magneta","red"};	    
    
    
    JComboBox comboBox;
    JComboBox comboBox_1;
    JComboBox comboBox_2 ;
    JComboBox comboBox_3;
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
		
		//for the main j frame
		this.setTitle("Settings");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(250,150,1000,520);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		this.setContentPane(contentPane);
		//this.setResizable(false);
		this.setVisible(true);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 10));
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(null);
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Book list area :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 10, 94, 22);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Book area :");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 73, 94, 22);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Left page :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 137, 94, 22);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Right page :");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 201, 94, 22);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Page dividers and borders :");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 265, 180, 22);
		panel.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.WHITE));
		panel_1.setBackground(Color.GRAY);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setForeground(Color.LIGHT_GRAY);
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
		
		comboBox_2 = new JComboBox(colorStrings);
		comboBox_2.setFocusable(false);
		comboBox_2.setBorder(new LineBorder(Color.DARK_GRAY));
		comboBox_2.setBounds(10, 10, 94, 22);
		panel_6.add(comboBox_2);
		comboBox_2.addItemListener(this);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(337, 10, 317, 384);
		panel_4.add(panel_7);
		panel_7.setLayout(null);
		
		comboBox_3 = new JComboBox(colorStrings);
		comboBox_3.setFocusable(false);
		comboBox_3.setBorder(new LineBorder(Color.DARK_GRAY));
		comboBox_3.setBounds(10, 10, 94, 22);
		panel_7.add(comboBox_3);
		comboBox_3.addItemListener(this);
		comboBox_4.addItemListener(this);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		String a;
		
		if(e.getSource()==comboBox) {
			a = String.valueOf(comboBox.getSelectedItem());
			NewNoteBookPage.book_list_panel.setBackground(MyColor.getColor(a));
			if(color_comb.get(a)==0) {
				
			}
			else {
				
			}
			//panel_3.setBackground(MyColor.getColor((String.valueOf(comboBox.getSelectedItem()))));
		}
		else if(e.getSource()==comboBox_1) {
			a = String.valueOf(comboBox_1  .getSelectedItem());
			NewNoteBookPage.Functions_panel.setBackground(MyColor.getColor(a));
		}
		else if(e.getSource()==comboBox_2) {
			a = String.valueOf(comboBox_2.getSelectedItem());
			NewNoteBookPage.first_page_textarea.setBackground(MyColor.getColor(a));
		}
		else if(e.getSource()==comboBox_3) {
			a = String.valueOf(comboBox_3.getSelectedItem());
			NewNoteBookPage.second_page_textarea.setBackground(MyColor.getColor(a));
		}
		else if(e.getSource()==comboBox_4) {
			a = String.valueOf(comboBox_4.getSelectedItem());
			NewNoteBookPage.pages_panel.setBackground(MyColor.getColor(a));
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
