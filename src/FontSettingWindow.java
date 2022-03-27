import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;


public class FontSettingWindow extends JFrame implements ActionListener,ItemListener {

	private JPanel contentPane;
	
	JComboBox<String> comboBox;
	JComboBox<String> comboBox_1;
	JLabel lblNewLabel;
	JLabel lblNewLabel4;
	
	JComboBox<String> comboBox_6;
	JComboBox<String> comboBox_7;

	String [] fonts_list = {"Arial","Arial Black","Arial Narraow","Calibri","Calibri Light","Cambria","Bebas Kai","Consolas","Technic","GothicE","GothicG","MS Gothic"
			+ "Monotxt","Segoe UI","Segoe UI Black","Tahoma","Monospaced"};
	
	String [] font_type_list = {"PLAIN","BOLD","ITALIC"};
	HashMap<String,Integer> font_stl = new HashMap<String,Integer>();
	
	String [] font_sizes = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28",
			"29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","48","49","50"};
	
	String [] colorStrings = {"black","blue","cyan","darkgray","gray","green","yellow","lightgray","magenta","orange","white"};
	
	int [] type_ref = {0,1,2};
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_7;
	private JComboBox<String> comboBox_2;
	private JComboBox<String> comboBox_3;
	private JComboBox<String> comboBox_9;
	private JComboBox<String> comboBox_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_13;
	private JComboBox<String> comboBox_4;
	private JComboBox<String> comboBox_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_16;
	
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	
	public FontSettingWindow() {
		
		font_stl.put("PLAIN",0);
		font_stl.put("BOLD",1);
		font_stl.put("ITALIC",2);
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(300, 200, 850, 500);
		contentPane = new JPanel();
		this.setVisible(true);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Left Font :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(20, 20, 60, 22);
		contentPane.add(lblNewLabel);
		
		lblNewLabel4 = new JLabel("Right Font :");
		lblNewLabel4.setForeground(Color.WHITE);
		lblNewLabel4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel4.setBounds(252, 20, 67, 22);
		contentPane.add(lblNewLabel4);
		
		comboBox = new JComboBox(fonts_list);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setBounds(20, 48, 180, 22);
		comboBox.setSelectedItem(NewNoteBookPage.left_side.font);
		comboBox.addItemListener(this);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox(fonts_list);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_1.setBounds(252, 48, 180, 22);
		comboBox_1.setSelectedItem(NewNoteBookPage.right_side.font);
		comboBox_1.addItemListener(this);
		contentPane.add(comboBox_1);
		
		lblNewLabel_1 = new JLabel("Left Font color : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(20, 94, 103, 22);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_5 = new JLabel("Right Font color :");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(252, 94, 109, 22);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_7 = new JLabel("Left Font Type :");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(20, 165, 92, 22);
		contentPane.add(lblNewLabel_7);
		
		comboBox_2 = new JComboBox(font_type_list);
		comboBox_2.setBounds(20, 192, 180, 22);
		comboBox_2.setSelectedItem(font_type_list[NewNoteBookPage.left_side.fontType]);
		comboBox_2.addItemListener(this);
		contentPane.add(comboBox_2);
		
		comboBox_3 = new JComboBox(font_type_list);
		comboBox_3.setBounds(252, 192, 180, 22);
		comboBox_3.setSelectedItem(font_type_list[NewNoteBookPage.right_side.fontType]);
		comboBox_3.addItemListener(this);
		contentPane.add(comboBox_3);
		
		lblNewLabel_9 = new JLabel("Right Font Type :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(252, 165, 103, 22);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_11 = new JLabel("Left Font size :");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_11.setBounds(20, 232, 92, 22);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_13 = new JLabel("Right Font Size :");
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_13.setBounds(252, 232, 103, 22);
		contentPane.add(lblNewLabel_13);
		
		comboBox_4 = new JComboBox(font_sizes);
		comboBox_4.setBounds(20, 258, 180, 22);
		comboBox_4.setSelectedItem(String.valueOf(NewNoteBookPage.left_side.size));
		comboBox_4.addItemListener(this);
		contentPane.add(comboBox_4);
		
		comboBox_5 = new JComboBox(font_sizes);
		comboBox_5.setBounds(252, 258, 180, 22);
		comboBox_5.setSelectedItem(String.valueOf(NewNoteBookPage.right_side.size));
		comboBox_5.addItemListener(this);
		contentPane.add(comboBox_5);
		
		JPanel panel = new JPanel();
		panel.setBounds(466, 48, 349, 123);
		panel.setBorder(new LineBorder(ColorUIResource.WHITE,1));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_6 = new JLabel("Left Font Preview");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setOpaque(true);
		panel.add(lblNewLabel_6, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(466, 218, 349, 123);
		panel_1.setBorder(new LineBorder(ColorUIResource.WHITE,1));
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_16 = new JLabel("Right Font Preview");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setOpaque(true);
		panel_1.add(lblNewLabel_16, BorderLayout.CENTER);
		
		comboBox_6 = new JComboBox(colorStrings);
		comboBox_6.setBounds(20, 122, 180, 22);
		comboBox_6.setSelectedItem((String)NewNoteBookPage.left_side.color_name);
		comboBox_6.addItemListener(this);
		contentPane.add(comboBox_6);
		
		comboBox_7 = new JComboBox(colorStrings);
		comboBox_7.setBounds(252, 122, 180, 22);
		comboBox_7.setSelectedItem((String)NewNoteBookPage.right_side.color_name);
		comboBox_7.addItemListener(this);
		contentPane.add(comboBox_7);
		
		btnNewButton = new JButton("Apply changes");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(365, 393, 125, 39);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("Left Page color :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(20, 295, 103, 24);
		contentPane.add(lblNewLabel_2);
		
		comboBox_8 = new JComboBox(colorStrings);
		comboBox_8.setBounds(20, 320, 180, 21);
		comboBox_8.setSelectedItem((String)NewNoteBookPage.left_side.page_color);
		comboBox_8.addItemListener(this);
		contentPane.add(comboBox_8);
		
		JLabel lblNewLabel_3 = new JLabel("Right Page color :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(252, 295, 125, 24);
		contentPane.add(lblNewLabel_3);
		
		comboBox_9 = new JComboBox(colorStrings);
		comboBox_9.setBounds(252, 320, 180, 21);
		comboBox_9.setSelectedItem((String)NewNoteBookPage.right_side.page_color);
		comboBox_9.addItemListener(this);
		contentPane.add(comboBox_9);
		
		left_f_set();
		right_f_set();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton) {
			doChanges();
		}
 
	}
	
	public void left_f_set() {
		lblNewLabel_6.setFont(new FontUIResource(String.valueOf(comboBox.getSelectedItem()), font_stl.get(String.valueOf(comboBox_2.getSelectedItem())), Integer.parseInt(String.valueOf(comboBox_4.getSelectedItem()))));
		lblNewLabel_6.setForeground(new ColorUIResource(MyColor.getColor((String) comboBox_6.getSelectedItem())));
		lblNewLabel_6.setBackground(new ColorUIResource(MyColor.getColor((String)comboBox_8.getSelectedItem())));
	}
	
	public void right_f_set() {
		lblNewLabel_16.setFont(new FontUIResource(String.valueOf(comboBox_1.getSelectedItem()),font_stl.get(String.valueOf(comboBox_3.getSelectedItem())),Integer.parseInt(String.valueOf(comboBox_5.getSelectedItem()))));
		lblNewLabel_16.setForeground(new ColorUIResource(MyColor.getColor((String) comboBox_7.getSelectedItem())));
		lblNewLabel_16.setBackground(new ColorUIResource(MyColor.getColor((String)comboBox_9.getSelectedItem())));
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==comboBox) {
			left_f_set();
			NewNoteBookPage.left_side.font = (String) comboBox.getSelectedItem();
		}
		else if(e.getSource()==comboBox_1) {
			right_f_set();
			NewNoteBookPage.right_side.font = (String) comboBox_1.getSelectedItem();
		}
		else if(e.getSource()==comboBox_2) {
			left_f_set();
			NewNoteBookPage.left_side.fontType = font_stl.get(String.valueOf(comboBox_2.getSelectedItem()));
			
		}
        else if(e.getSource()==comboBox_3) {
			right_f_set();
			NewNoteBookPage.right_side.fontType = font_stl.get(String.valueOf(comboBox_3.getSelectedItem()));
			
		}
        else if(e.getSource()==comboBox_4) {
        	left_f_set();
        	NewNoteBookPage.left_side.size = Integer.parseInt(String.valueOf(comboBox_4.getSelectedItem()));
        }
        else if(e.getSource()==comboBox_5) {
        	right_f_set();
        	NewNoteBookPage.right_side.size = Integer.parseInt(String.valueOf(comboBox_5.getSelectedItem()));
        }	
        else if (e.getSource()==comboBox_6) {
        	left_f_set();
        	NewNoteBookPage.left_side.color_name = String.valueOf(comboBox_6.getSelectedItem());
		}
        else if (e.getSource()==comboBox_7) {
        	right_f_set();
        	NewNoteBookPage.right_side.color_name = String.valueOf(comboBox_7.getSelectedItem());
		}
        else if (e.getSource()==comboBox_8) {
        	left_f_set();
        	NewNoteBookPage.left_side.page_color = String.valueOf(comboBox_8.getSelectedItem());
		}
        else if (e.getSource()==comboBox_9) {
        	right_f_set();
        	NewNoteBookPage.right_side.page_color = String.valueOf(comboBox_9.getSelectedItem());
		}
        
	}
	
	public void doChanges() {
		NewNoteBookPage.left_side.size = Integer.parseInt(String.valueOf(comboBox_4.getSelectedItem()));
		NewNoteBookPage.right_side.size = Integer.parseInt(String.valueOf(comboBox_5.getSelectedItem()));
		NewNoteBookPage.left_side.color_name = String.valueOf(comboBox_6.getSelectedItem());
		NewNoteBookPage.right_side.color_name = String.valueOf(comboBox_7.getSelectedItem());
		NewNoteBookPage.left_side.fontType = font_stl.get(String.valueOf(comboBox_2.getSelectedItem()));
		NewNoteBookPage.right_side.fontType = font_stl.get(String.valueOf(comboBox_3.getSelectedItem()));
		NewNoteBookPage.left_side.font = String.valueOf(comboBox.getSelectedItem());
		NewNoteBookPage.right_side.font = String.valueOf(comboBox_1.getSelectedItem());
		NewNoteBookPage.left_side.page_color = String.valueOf(comboBox_8.getSelectedItem());
		NewNoteBookPage.right_side.page_color = String.valueOf(comboBox_9.getSelectedItem());
		
		NewNoteBookPage.setChangesToTextAreas();
		this.dispose();
	}
}