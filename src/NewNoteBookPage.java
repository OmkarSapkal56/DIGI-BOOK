import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import com.mysql.cj.xdevapi.AbstractDataResult;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Insets;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;

public class NewNoteBookPage extends JFrame implements ActionListener,WindowListener {

	private JPanel contentPane;
	private ImageIcon fontChng = new ImageIcon(new ImageIcon("icons8-choose-font-24 (1).png").getImage().getScaledInstance(20,20,100));
	private ImageIcon deleteBookBtnn = new ImageIcon(new ImageIcon("icons8-delete-384 (1).png").getImage().getScaledInstance(20,20,100));
	private ImageIcon delet_page_icon = new ImageIcon(new ImageIcon("icons8-trash-19.png").getImage());
	static JButton[] book_list;
	static JButton create_new_nb_btn;
	static JPanel book_list_panel;
	
	String [] themes = {"Dark","Light","Custom"};
	
	
	private static String pathName = "C:\\DIGIBOOK\\NOTE_BOOKS";
	
	//the label for showing current notebook
	static JLabel current_nb_label;
	static JLabel current_notebook_shower;
	
	/*
	The current selected notebook that will appear on the screen
	The default is set to empty string i.e. "";
	*/
	private static String currentNB="";
	
	//left and right pages/text area
	static JTextArea first_page_textarea;
	static JTextArea second_page_textarea;
	
	//left and right page numbers
	static JLabel leftpage_lbl;
	static JLabel rightpage_lbl;
	
	//date created label
	static JLabel date_lbl;
	static JLabel date_mod_lbl;
	
	//The next and previous page button
	static JButton left_btn_next;
    static JButton left_btn_prev;
	static JButton right_btn_next;
	static JButton right_btn_prev;
	static JTextField page_no_tf_left;
	static JTextField page_no_tf_right;
	static JTextField insert_new_page_tf;
	
	//the font change button
    static JButton change_font_btn;
	
	//delete book button
	static JButton delete_book_btn;
	
	//setting menu
	JMenuItem setting_btn_in_menu;
	
	//delete current page button
	static JButton delete_pg_btn_left;
	static JButton delete_pg_btn_right;
	
	static Fontas left_side = new Fontas();
	static Fontas right_side = new Fontas();
	
	static JPanel pages_panel;
	
	private JComboBox comboBox;
	
	static JLabel Your_nbs_label;
	
	static JLabel last_mod_lbl;
	
	static JLabel date_created_lbl;
	
	static JPanel Functions_panel;
	
	static JMenuBar menuBar;
	
	static JMenu fileMenu;
	static JMenu helpMenu;
	
	JMenuItem mntmNewMenuItem;
	static JTextField textField;
	static JTextField textField_1;
	
	static JButton btnNewButton_1;
	static JButton btnNewButton;
	
	static JLabel lblNewLabel_5;
	
	//JLabel lblNewLabel_6;
	private int tot_pg_in_cn=0;
	
	static JLabel lblNewLabel_4;
	
	static JLabel insert_new_page_lbl;
	
	static JLabel lblNewLabel_1;
	static JLabel lblNewLabel;
	static JLabel lblNewLabel_2;
	static JLabel lblNewLabel_3;
	
	static JLabel Enter_page_no_lbl_left;
	static JLabel Enter_page_no_lbl_right;
	public NewNoteBookPage() {
		
		//for the main j frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(-7,0,1930,831);
		this.addWindowListener(this);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		this.setContentPane(contentPane);
		//this.setResizable(false);
		this.setVisible(true);
		this.setTitle("DiGIBOOK");
		contentPane.setLayout(null);
		
		
		
		left_side.size=18;
		left_side.color_name="black";
		left_side.page_color="white";
		left_side.font="Monospaced";
		left_side.fontType=0;
		right_side.size=18;
		right_side.color_name="black";
		right_side.page_color="white";
		right_side.font="Monospaced";
		right_side.fontType=0;
		
		//the main pages panel
		pages_panel = new JPanel();
		pages_panel.setBounds(224, 100, 1316, 694);
		pages_panel.setBackground(Color.GRAY);
		contentPane.add(pages_panel);
		pages_panel.setLayout(null);
		
		JPanel left_panel = new JPanel();
		left_panel.setBounds(10, 10, 643, 650);
		pages_panel.add(left_panel);
		left_panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane left_scrollPane = new JScrollPane();
		left_scrollPane.setBorder(null);
		left_panel.add(left_scrollPane);
		
		first_page_textarea = new JTextArea();
		first_page_textarea.setText("Add a page here");
		first_page_textarea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		first_page_textarea.setMargin(new Insets(30, 30, 30, 30));
		first_page_textarea.setLineWrap(true);
		first_page_textarea.setOpaque(true);
		left_scrollPane.setViewportView(first_page_textarea);
		
		JPanel right_panel = new JPanel();
		right_panel.setBounds(663, 10, 643, 650);
		pages_panel.add(right_panel);
		right_panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane right_scrollPane = new JScrollPane();
		right_scrollPane.setBorder(null);
		right_panel.add(right_scrollPane, BorderLayout.CENTER);
		
		second_page_textarea = new JTextArea();
		second_page_textarea.setText("Add a page here");
		second_page_textarea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		second_page_textarea.setMargin(new Insets(30, 30, 30, 30));
		second_page_textarea.setLineWrap(true);
		second_page_textarea.setOpaque(true);
		right_scrollPane.setViewportView(second_page_textarea);
		
		leftpage_lbl = new JLabel("-");
		leftpage_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		leftpage_lbl.setForeground(Color.WHITE);
		leftpage_lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		leftpage_lbl.setBounds(338, 664, 39, 23);
		pages_panel.add(leftpage_lbl);
		
		rightpage_lbl = new JLabel("-");
		rightpage_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		rightpage_lbl.setForeground(Color.WHITE);
		rightpage_lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		rightpage_lbl.setBounds(984, 664, 39, 23);
		pages_panel.add(rightpage_lbl);
		
		//left side next page and previous page buttons (scrolling)
		left_btn_prev = new JButton("<");
		left_btn_prev.setBorder(null);
		left_btn_prev.setFont(new Font("Tahoma", Font.BOLD, 12));
		left_btn_prev.setEnabled(false);
		left_btn_prev.setFocusable(false);
		left_btn_prev.setBackground(Color.LIGHT_GRAY);
		left_btn_prev.setBounds(10, 666, 41, 21);
		left_btn_prev.addActionListener(this);
		pages_panel.add(left_btn_prev);
		
		left_btn_next = new JButton(">");
		left_btn_next.setBorder(null);
		left_btn_next.setFont(new Font("Tahoma", Font.BOLD, 12));
		left_btn_next.setEnabled(false);
		left_btn_next.setFocusable(false);
		left_btn_next.setBackground(Color.LIGHT_GRAY);
		left_btn_next.setBounds(612, 666, 41, 21);
		left_btn_next.addActionListener(this);
		pages_panel.add(left_btn_next);
		
		page_no_tf_left = new JTextField();
		page_no_tf_left.setHorizontalAlignment(SwingConstants.CENTER);
		page_no_tf_left.setBorder(null);
		page_no_tf_left.setBounds(113, 666, 39, 21);
		page_no_tf_left.addActionListener(this);
		pages_panel.add(page_no_tf_left);
		page_no_tf_left.setColumns(10);
		
		//right side next page and previous page buttons (scrolling)
		right_btn_prev = new JButton("<");
		right_btn_prev.setBorder(null);
		right_btn_prev.setFont(new Font("Tahoma", Font.BOLD, 12));
		right_btn_prev.setEnabled(false);
		right_btn_prev.setBackground(Color.LIGHT_GRAY);
		right_btn_prev.setBounds(663, 666, 41, 21);
		right_btn_prev.addActionListener(this);
		pages_panel.add(right_btn_prev);
		
		right_btn_next = new JButton(">");
		right_btn_next.setBorder(null);
		right_btn_next.setFont(new Font("Tahoma", Font.BOLD, 12));
		right_btn_next.setEnabled(false);
		right_btn_next.setBackground(Color.LIGHT_GRAY);
		right_btn_next.setBounds(1265, 666, 41, 21);
		right_btn_next.addActionListener(this);
		pages_panel.add(right_btn_next);
		
		page_no_tf_right = new JTextField();
		page_no_tf_right.setBorder(null);
		page_no_tf_right.setHorizontalAlignment(SwingConstants.CENTER);
		page_no_tf_right.setBounds(766, 666, 39, 21);
		page_no_tf_right.addActionListener(this);
		pages_panel.add(page_no_tf_right);
		page_no_tf_right.setColumns(10);
		
		Enter_page_no_lbl_left = new JLabel("Page no :");
		Enter_page_no_lbl_left.setForeground(Color.WHITE);
		Enter_page_no_lbl_left.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Enter_page_no_lbl_left.setBounds(56, 670, 60, 13);
		pages_panel.add(Enter_page_no_lbl_left);
		
		Enter_page_no_lbl_right = new JLabel("Page no :");
		Enter_page_no_lbl_right.setForeground(Color.WHITE);
		Enter_page_no_lbl_right.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Enter_page_no_lbl_right.setBounds(709, 670, 60, 13);
		pages_panel.add(Enter_page_no_lbl_right);
		
		delete_pg_btn_left = new JButton("");
		delete_pg_btn_left.setBackground(Color.LIGHT_GRAY);
		delete_pg_btn_left.setBorder(null);
		delete_pg_btn_left.setBounds(570, 666, 39, 21);
		delete_pg_btn_left.setIcon(delet_page_icon);
		delete_pg_btn_left.addActionListener(this);
		pages_panel.add(delete_pg_btn_left);
		
		delete_pg_btn_right = new JButton("");
		delete_pg_btn_right.setBackground(Color.LIGHT_GRAY);
		delete_pg_btn_right.setBorder(null);
		delete_pg_btn_right.setBounds(1223, 666, 39, 21);
		delete_pg_btn_right.setIcon(delet_page_icon);
		delete_pg_btn_right.addActionListener(this);
		pages_panel.add(delete_pg_btn_right);
		
		
		
		
	
		
		
		
		
		//panel to show the created notebooks and the create new button
		book_list_panel = new JPanel();
		book_list_panel.setBounds(0, 100, 224, 694);
		book_list_panel.setBackground(Color.DARK_GRAY);
		book_list_panel.setBorder(new LineBorder(Color.WHITE, 2));
		book_list_panel.setPreferredSize(new Dimension(200, 10));
		book_list_panel.setOpaque(true);
		contentPane.add(book_list_panel);
		book_list_panel.setLayout(null);
		
		//label showing your notebooks 
		Your_nbs_label = new JLabel("Your NoteBooks :");
		Your_nbs_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Your_nbs_label.setForeground(Color.LIGHT_GRAY);
		Your_nbs_label.setBounds(15, 15, 118, 21);
		book_list_panel.add(Your_nbs_label);
		
		
		create_new_nb_btn = new JButton("+ CREATE NEW NOTE-BOOK");
		create_new_nb_btn.setBorder(null);
		create_new_nb_btn.setBackground(Color.DARK_GRAY);
		create_new_nb_btn.setFocusable(false);
		create_new_nb_btn.setForeground(Color.WHITE);
		create_new_nb_btn.setOpaque(false);
		create_new_nb_btn.setHorizontalAlignment(JButton.LEFT);
		create_new_nb_btn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		create_new_nb_btn.addActionListener(this);
		book_list_panel.add(create_new_nb_btn);
				
		//initializing the array of buttons
		book_list = new JButton[20];
		//initially setting all the books to null
		for(int i=0;i<20;i++) {
			book_list[i]=new JButton();
			book_list[i].setVisible(false);
			book_list[i].setText("");
			book_list[i].setOpaque(false);
			book_list[i].addActionListener(this);
			book_list_panel.add(book_list[i]);
		}
		
		refresh();	
		
		//this will show the date created and the date it was last modified before today
		date_created_lbl = new JLabel("Date created :");
		date_created_lbl.setForeground(Color.LIGHT_GRAY);
		date_created_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		date_created_lbl.setBounds(15, 637, 94, 13);
		book_list_panel.add(date_created_lbl);
		
		date_lbl = new JLabel("-");
		date_lbl.setForeground(Color.WHITE);
		date_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		date_lbl.setBounds(110, 637, 85, 13);
		book_list_panel.add(date_lbl);
		
		last_mod_lbl = new JLabel("Last modified :");
		last_mod_lbl.setForeground(Color.LIGHT_GRAY);
		last_mod_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		last_mod_lbl.setBounds(15, 660, 94, 13);
		book_list_panel.add(last_mod_lbl);
		
		date_mod_lbl = new JLabel("-");
		date_mod_lbl.setForeground(Color.WHITE);
		date_mod_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		date_mod_lbl.setBounds(113, 660, 85, 13);
		book_list_panel.add(date_mod_lbl);
		
		lblNewLabel_4 = new JLabel("Total pages :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setForeground(new Color(192, 192, 192));
		lblNewLabel_4.setBounds(15, 608, 83, 21);
		book_list_panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("-");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(103, 613, 85, 13);
		book_list_panel.add(lblNewLabel_5);
		
		
		
		
		
		
		//The top panel showing the fonts color and etc change buttons and the current notebook label
		Functions_panel = new JPanel();
		Functions_panel.setBounds(0, 0, 1540, 100);
		Functions_panel.setBackground(Color.LIGHT_GRAY);
		Functions_panel.setPreferredSize(new Dimension(10, 100));
		contentPane.add(Functions_panel);
		Functions_panel.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBorder(null);
		menuBar.setBackground(Color.DARK_GRAY);
		menuBar.setBounds(0, 0, 1540, 34);
		Functions_panel.add(menuBar);
		
		fileMenu = new JMenu("File");
		fileMenu.setBorder(null);
		fileMenu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fileMenu.setForeground(Color.LIGHT_GRAY);
		menuBar.add(fileMenu);
		
		setting_btn_in_menu = new JMenuItem("Setting");
		setting_btn_in_menu.setHorizontalAlignment(SwingConstants.LEFT);
		setting_btn_in_menu.setPreferredSize(new Dimension(100, 24));
		setting_btn_in_menu.setBorder(null);
		setting_btn_in_menu.addActionListener(this);
		fileMenu.add(setting_btn_in_menu);
		
		helpMenu = new JMenu("Help");
		helpMenu.setBorder(null);
		helpMenu.setForeground(Color.LIGHT_GRAY);
		helpMenu.setBackground(Color.WHITE);
		helpMenu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(helpMenu);
		
		mntmNewMenuItem = new JMenuItem("Instructions");
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem.addActionListener(this);
		mntmNewMenuItem.setPreferredSize(new Dimension(100, 24));
		helpMenu.add(mntmNewMenuItem);
		
		current_nb_label = new JLabel("Current NoteBook : ");
		current_nb_label.setHorizontalAlignment(SwingConstants.CENTER);
		current_nb_label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		current_nb_label.setBounds(628, 44, 270, 50);
		Functions_panel.add(current_nb_label);
		
		current_notebook_shower = new JLabel("-");
		current_notebook_shower.setFont(new Font("Tahoma", Font.BOLD, 30));
		current_notebook_shower.setBounds(894, 44, 348, 50);
		Functions_panel.add(current_notebook_shower);
		
		delete_book_btn = new JButton("");
		delete_book_btn.setBackground(Color.GRAY);
		delete_book_btn.setIcon(deleteBookBtnn);
		delete_book_btn.setFocusable(false);
		delete_book_btn.setBorder(null);
		delete_book_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		delete_book_btn.setBounds(1495, 69, 37, 27);
		delete_book_btn.addActionListener(this);
		Functions_panel.add(delete_book_btn);
		
		//The font change button
		change_font_btn = new JButton("");
		change_font_btn.setBackground(Color.GRAY);
		change_font_btn.setBorder(null);
		change_font_btn.setFocusable(false);
		change_font_btn.setBounds(3, 36, 40, 30);
		change_font_btn.setIcon(fontChng);
		change_font_btn.addActionListener(this);
		Functions_panel.add(change_font_btn);
		
		insert_new_page_tf = new JTextField();
		insert_new_page_tf.setHorizontalAlignment(SwingConstants.CENTER);
		insert_new_page_tf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		insert_new_page_tf.setBorder(null);
		insert_new_page_tf.setBounds(346, 73, 50, 21);
		insert_new_page_tf.addActionListener(this);
		Functions_panel.add(insert_new_page_tf);
		insert_new_page_tf.setColumns(10);
		
		insert_new_page_lbl = new JLabel("Insert new page at :");
		insert_new_page_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		insert_new_page_lbl.setBounds(234, 73, 117, 21);
		Functions_panel.add(insert_new_page_lbl);
		
		comboBox = new JComboBox(themes);
		comboBox.setFocusable(false);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setBounds(46, 36, 64, 30);
		comboBox.addActionListener(this);
		Functions_panel.add(comboBox);
		
		btnNewButton = new JButton("DLA");
		btnNewButton.setFocusable(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(1415, 69, 63, 27);
		Functions_panel.add(btnNewButton);
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(this);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setIcon(deleteBookBtnn);
		
		btnNewButton_1 = new JButton("DLS");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(1246, 69, 63, 27);
		Functions_panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setIcon(deleteBookBtnn);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBorder(null);
		textField.setBounds(1312, 69, 41, 27);
		Functions_panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBorder(null);
		textField_1.setBounds(1356, 69, 41, 27);
		Functions_panel.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel = new JLabel("From");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(1312, 53, 41, 13);
		Functions_panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("To");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(1356, 53, 41, 13);
		Functions_panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("<html>|<br>|</html>");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(1479, 71, 17, 23);
		Functions_panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("<html>|<br>|</html>");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(1398, 71, 17, 23);
		Functions_panel.add(lblNewLabel_3);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		//for left side page next button
		if(e.getSource()==left_btn_next) {
			int curr_pg = Integer.parseInt(leftpage_lbl.getText());
			savingThroughLeftTextArea(curr_pg);
			copy(1, currentNB, curr_pg+1);
			return;
		}
		
		//for left side page previous button
		if(e.getSource()==left_btn_prev) {
			int curr_pg = Integer.parseInt(leftpage_lbl.getText());
			savingThroughLeftTextArea(curr_pg);
			copy(1, currentNB, curr_pg-1);
			return;
		}
		
		//for right side page next button
		if(e.getSource()==right_btn_next) {
			int curr_pg = Integer.parseInt(rightpage_lbl.getText());
			savingThroughRightTextArea(curr_pg);
			copy(2, currentNB, curr_pg+1);
			return;
		}
		
		//for right side page previous button
		if(e.getSource()==right_btn_prev) {
			int curr_pg = Integer.parseInt(rightpage_lbl.getText());
			savingThroughRightTextArea(curr_pg);
			copy(2, currentNB, curr_pg-1);
			return;
		}
		
		//to show the page according to page no text field
		if(e.getSource()==page_no_tf_left) {
			if(currentNB=="") {
				
				//showing the user that you have not selected a book
				showAddBook();
			}
			else {
				
				//saving the contents of text area into text file
				savingThroughLeftTextArea(Integer.parseInt(leftpage_lbl.getText()));
				
				//showing the required page to the left side if exists
				int required_pg_no = Integer.parseInt(page_no_tf_left.getText());
				copy(1, currentNB, required_pg_no);
			}
			return;
		}
		
		//to show the page according to page no text field
		if(e.getSource()==page_no_tf_right) {
			if(currentNB=="") {
				
				//showing the user that you have not selected a book
				showAddBook();
			}
			else {
				
				//saving the contents of text area into text file
				savingThroughRightTextArea(Integer.parseInt(rightpage_lbl.getText()));
				
				//showing the required page to the right side if exists
				int required_pg_no = Integer.parseInt(page_no_tf_right.getText());
				copy(2, currentNB, required_pg_no);
			}
			return;
		}
		
		
		//action after clicking on create new note book
		if(e.getSource()==create_new_nb_btn) {
			
			//new JFrame to create new NB
			new CreateNewNotebook();
			return;
		}
		
		//delete current book function
		if(e.getSource()==delete_book_btn) {
			
			if(currentNB=="") {
				
				showAddBook();
			}
			else {
				int choice = JOptionPane.showConfirmDialog(null,"Do you really want to delete the current book ?", currentNB,JOptionPane.YES_NO_OPTION);
				if(choice==0) {
					
					//calling delete method
					deleteBook(new File(pathGiver(currentNB)));
					//removing the book name form the list of books text file
					File list_of_nb = new File(pathName+"\\LIST_OR_NAMES_OF_NOTE-BOOKS.txt");
					
					try {
						
						Scanner file_rdr = new Scanner(list_of_nb);
						String wholeString = file_rdr.nextLine();
						while(file_rdr.hasNextLine()) {
							
							wholeString = wholeString +"\n"+ file_rdr.nextLine();
							
						}
						wholeString=wholeString+"\n";
						wholeString=wholeString.replace("> "+currentNB+"\n","");
						file_rdr.close();
						
						PrintWriter add_Book = new PrintWriter(new FileWriter(list_of_nb));
						
						add_Book.print(wholeString);
						
						add_Book.close();
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					refresh();
					currentNB="";
					current_notebook_shower.setText("-");
					date_lbl.setText("-");
					date_mod_lbl.setText("-");
					lblNewLabel_5.setText("-");
					left_btn_next.setEnabled(false);
					left_btn_prev.setEnabled(false);
					right_btn_next.setEnabled(false);
					right_btn_prev.setEnabled(false);
				}
			}
			return;
		}		
		
		// private static String pathName = "C:\\DIGIBOOK\\NOTE_BOOKS"; for reference path name for book so that
		
		for(int i=0;i<20;i++) {
			if(e.getSource().equals(book_list[i])) {
				
				//removing the current notebook
				remove_curr();
				
				//current book name in bold name
				currentNB=book_list[i].getText().replace("> ","");
				current_notebook_shower.setText("'"+currentNB+"'");
				
				//file for the notebooks 1st page
				File noteBookPage;
				try {
					
					//reading the first page data
					noteBookPage = new File(pathGiver(currentNB, 1));
					
					//for copying the page 1 contents on the left page
					readingTxtFile(noteBookPage,0);
					leftpage_lbl.setText(String.valueOf(1));
					
					//for copying the page 1 contents on the right page
					readingTxtFile(noteBookPage, 1);
					rightpage_lbl.setText(String.valueOf(1));
		            
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//for modified date 
				File info_file = new File(pathGiver(currentNB)+"\\"+currentNB+"_Book_Info.txt");
				Scanner dt_rdr=null;
				try {
					 dt_rdr = new Scanner(info_file);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				date_lbl.setText(dt_rdr.nextLine().substring(13,23));
				String disp = dt_rdr.nextLine();
				if(DateAndTimeGiver.dateGiver().equals(disp.substring(22,32))) {
					date_mod_lbl.setText(disp.substring(11,21));
				}
				else {
					date_mod_lbl.setText(disp.substring(22,32));
				}
				//if(DateAndTimeGiver.dateGiver()==)
				lblNewLabel_5.setText(dt_rdr.nextLine().substring(14));
				tot_pg_in_cn = Integer.parseInt(lblNewLabel_5.getText().trim());
				dt_rdr.close();
			
				//enabling the next and prev page buttons
				left_btn_next.setEnabled(true);
				left_btn_prev.setEnabled(true);
				right_btn_next.setEnabled(true);
				right_btn_prev.setEnabled(true);
				return;
			}
		}
		
		//inserting a new page in the current notebook
		if(e.getSource()==insert_new_page_tf) {
			insertPage(currentNB,Integer.parseInt(insert_new_page_tf.getText()));
			insert_new_page_tf.setText("");
			return;
		}
		
		//change font button clicked
		if(e.getSource()==change_font_btn) {
			
			new FontSettingWindow();
			return;
		}
		
		//setting button
		if(e.getSource()==setting_btn_in_menu) {
			
			new SettingScreen();
			return;
		}
		
		//instructions panel
		if(e.getSource()==mntmNewMenuItem) {
			new InstructionPanel();
			return;
		}
		
		//left side page delete
		if(e.getSource()==delete_pg_btn_left) {
			
			if(currentNB=="") {
				showAddBook();
			}
			
			else {
				if(tot_pg_in_cn==1) {
					JOptionPane.showMessageDialog(null, "You cannot delete the only page left");
				}
				else {
					int choice = JOptionPane.showConfirmDialog(null, "Do you want to delete page "+leftpage_lbl.getText()+" from "+currentNB,currentNB,JOptionPane.YES_NO_OPTION);
					if(choice==0) {
						File currPage = new File(pathGiver(currentNB,Integer.parseInt(leftpage_lbl.getText())));
						currPage.delete();
						File nextPage =  new File(pathGiver(currentNB, Integer.parseInt(leftpage_lbl.getText())+1));
						
						for(int i=1;nextPage.exists();i++){
							
							nextPage = new File(pathGiver(currentNB, Integer.parseInt(leftpage_lbl.getText())+i));
							nextPage.renameTo(new File(pathGiver(currentNB,Integer.parseInt(leftpage_lbl.getText())+i-1)));
							nextPage = new File(pathGiver(currentNB, Integer.parseInt(leftpage_lbl.getText())+i+1));
						}
						copy(1, currentNB, Integer.parseInt(leftpage_lbl.getText()));
						copy(2, currentNB, Integer.parseInt(rightpage_lbl.getText()));
						tot_pg_in_cn--;
						lblNewLabel_5.setText(String.valueOf(tot_pg_in_cn));
						//adjusting the proper page after inserting or deleting a page
						adjustPage();
					}
				}
			}
			return;
			
		}
		
		//right side page delete
        if(e.getSource()==delete_pg_btn_right) {
			
        	if(currentNB=="") {
        		showAddBook();
        	}
        	
        	else {
        		if(tot_pg_in_cn==1) {
					JOptionPane.showMessageDialog(null, "You cannot delete the only page left");
				}
        		else {
        			int choice = JOptionPane.showConfirmDialog(null, "DO you want to delete page "+rightpage_lbl.getText()+" from "+currentNB,currentNB,JOptionPane.YES_NO_OPTION);
    				if(choice==0) {
    					File currPage = new File(pathGiver(currentNB,Integer.parseInt(rightpage_lbl.getText())));
    					currPage.delete();
    					File nextPage =  new File(pathGiver(currentNB, Integer.parseInt(rightpage_lbl.getText())+1));
    					
    					for(int i=1;nextPage.exists();i++){
    						
    						nextPage = new File(pathGiver(currentNB, Integer.parseInt(rightpage_lbl.getText())+i));
    						nextPage.renameTo(new File(pathGiver(currentNB,Integer.parseInt(rightpage_lbl.getText())+i-1)));
    						nextPage = new File(pathGiver(currentNB, Integer.parseInt(rightpage_lbl.getText())+i+1));
    					}
    					copy(2, currentNB, Integer.parseInt(rightpage_lbl.getText()));
    					copy(1, currentNB, Integer.parseInt(leftpage_lbl.getText()));
    					tot_pg_in_cn--;
    					lblNewLabel_5.setText(String.valueOf(tot_pg_in_cn));
    					//adjusting the proper page after inserting or deleting a page
    					adjustPage();
    				}
        		}
			}
			return;
			
		}
        
        //delete all page except page 1
        if(e.getSource()==btnNewButton) {
        	if(currentNB=="") {
        		showAddBook();
        	}
        	else {
        		int ch = JOptionPane.showConfirmDialog(null,"Do you wan to delete all the pages except the first page ?",currentNB,JOptionPane.YES_NO_OPTION);
            	if(ch==0) {
            		File delFile = new File(pathGiver(currentNB, 2));
                	for(int i=3;delFile.exists();i++) {
                		delFile.delete();
                		delFile = new File(pathGiver(currentNB, i));
                	}
                	leftpage_lbl.setText("1");
                	rightpage_lbl.setText("1");
                	copy(1, currentNB, Integer.parseInt(leftpage_lbl.getText()));
        			copy(2, currentNB, Integer.parseInt(rightpage_lbl.getText()));
        			tot_pg_in_cn=1;
        			lblNewLabel_5.setText(String.valueOf(tot_pg_in_cn));
            	}
        	}
        	
        	return;
        }
        
        //delete selected pages
        if(e.getSource()==btnNewButton_1) {
        	if(currentNB=="") {
        		showAddBook();
        	}
        	else {
        		int u=Integer.parseInt(textField_1.getText().toString());
        		int l=Integer.parseInt(textField.getText().toString());
        		if(u<l) {
            		JOptionPane.showMessageDialog(null,"The lower limit is higher than the upper limit");
            	}

            	else {
            		if(l<=1) {
            			JOptionPane.showMessageDialog(null,"You cannot delete page 1 or lower");
            		}
            		else {
            			File uper = new File(pathGiver(currentNB, u));
        				if(uper.exists()) {
        					
            				File trav;
            				for(int i=0;i+l<=u;i++){
            					trav = new File(pathGiver(currentNB,l+i));
            					trav.delete();
            				}
            				int decr=u-l+1; 
            				File nextPages = new File(pathGiver(currentNB, u+1));
            				File rt;
            				for(int i=1;nextPages.exists();i++) {
            					nextPages = new File(pathGiver(currentNB, u+i));
                				rt = new File(pathGiver(currentNB, u+i-decr));
                				nextPages.renameTo(rt);
            					nextPages =  new File(pathGiver(currentNB, u+i+1));
            				}
            				
            				
            				copy(2, currentNB, Integer.parseInt(rightpage_lbl.getText()));
            				copy(1, currentNB, Integer.parseInt(leftpage_lbl.getText()));
            				tot_pg_in_cn-=(u-l+1);
            				lblNewLabel_5.setText(String.valueOf(tot_pg_in_cn));
            				//adjusting the proper page after inserting or deleting a page
            				adjustPage();
        					
        				}
        				else {
        					JOptionPane.showMessageDialog(null, "No such pages exist");
        					
        				}
            		}
            	}
        	}
        	return;
        }
        
        if(e.getSource()==comboBox) {
			
			if(String.valueOf(comboBox.getSelectedItem())=="Dark") {
				book_list_panel.setBackground(ColorUIResource.DARK_GRAY);
				create_new_nb_btn.setForeground(ColorUIResource.WHITE);
				Your_nbs_label.setForeground(ColorUIResource.LIGHT_GRAY);
				for(int i=0;i<20;i++) {
					book_list[i].setForeground(ColorUIResource.WHITE);
				}
				last_mod_lbl.setForeground(ColorUIResource.LIGHT_GRAY);  
				date_mod_lbl.setForeground(ColorUIResource.WHITE);
				date_lbl.setForeground(ColorUIResource.WHITE);           
				date_created_lbl.setForeground(ColorUIResource.LIGHT_GRAY);
				lblNewLabel_5.setForeground(ColorUIResource.WHITE);      
				lblNewLabel_4.setForeground(ColorUIResource.LIGHT_GRAY);
				book_list_panel.setBorder(new LineBorder(ColorUIResource.WHITE, 2));
				
				Functions_panel.setBackground(ColorUIResource.LIGHT_GRAY);
				menuBar.setBackground(ColorUIResource.DARK_GRAY);
				menuBar.setBorder(null);
				insert_new_page_tf.setBorder(null);
				textField.setBorder(null);
				textField_1.setBorder(null);
				
				fileMenu.setForeground(ColorUIResource.LIGHT_GRAY);
				helpMenu.setForeground(ColorUIResource.LIGHT_GRAY);
				
			}
			else if(String.valueOf(comboBox.getSelectedItem())=="Light") {
            	book_list_panel.setBackground(ColorUIResource.WHITE);
				create_new_nb_btn.setForeground(ColorUIResource.BLACK);
				Your_nbs_label.setForeground(ColorUIResource.DARK_GRAY);
				for(int i=0;i<20;i++) {
					book_list[i].setForeground(ColorUIResource.BLACK);
				}
				last_mod_lbl.setForeground(ColorUIResource.BLACK);
				date_mod_lbl.setForeground(ColorUIResource.BLACK);
				date_lbl.setForeground(ColorUIResource.BLACK);
				date_created_lbl.setForeground(ColorUIResource.BLACK);
				lblNewLabel_5.setForeground(ColorUIResource.BLACK);
				lblNewLabel_4.setForeground(ColorUIResource.BLACK);
				book_list_panel.setBorder(new LineBorder(ColorUIResource.BLACK, 2));
				
				Functions_panel.setBackground(ColorUIResource.WHITE);
				menuBar.setBackground(ColorUIResource.WHITE);
				menuBar.setBorder(new LineBorder(ColorUIResource.BLACK,2));
				menuBar.setBackground(ColorUIResource.WHITE);
				fileMenu.setForeground(ColorUIResource.BLACK);
				helpMenu.setForeground(ColorUIResource.BLACK);
				pages_panel.setBorder(null);
				insert_new_page_tf.setBorder(new LineBorder(ColorUIResource.BLACK,1));
				textField.setBorder(new LineBorder(ColorUIResource.BLACK,1));
				textField_1.setBorder(new LineBorder(ColorUIResource.BLACK,1));
				
				
			}
            else if(String.valueOf(comboBox.getSelectedItem())=="Custom") {
            	
            	new SettingScreen();
            }
			return;
		}
	}
	
	/**
	 *book path/book page path Giver
	 */
	public static String pathGiver(String book_name) {
		String path_of_book=pathName+"\\NB_"+book_name;
		return path_of_book;
	}
	
	public static String pathGiver(String book_name,int page_no) {
		String path_of_book_page=pathGiver(book_name)+"\\"+currentNB+"_Page_"+String.valueOf(page_no)+".txt";
		return path_of_book_page;
	}
	
	//method to insert at a particular page no in a book
	public void insertPage(String bookname,int insert_page_no) {
		
		if(bookname=="") {
			
			//showing the user that you have not selected a book
			showAddBook();
		}
		else {
			File new_page = new File(pathGiver(currentNB,insert_page_no));
			File new_pages_next_page = new File(pathGiver(currentNB,insert_page_no+1));
			File new_pages_prev_page = new File(pathGiver(currentNB,insert_page_no-1));
			
			
			//booleans to define the two page existences
			boolean a,c;
			a=new_page.exists();
			c=new_pages_prev_page.exists();
			
			if(a || c) {
				
				
				if(a) {
					
					changeFileName(new_page,new_pages_next_page,insert_page_no);
					
				}
				savingThroughLeftTextArea(Integer.parseInt(leftpage_lbl.getText()));
				savingThroughRightTextArea(Integer.parseInt(rightpage_lbl.getText()));
				File new_insert_page = new File(pathGiver(currentNB, insert_page_no));
				try {
					new_insert_page.createNewFile();
					PrintWriter fontWriter = new PrintWriter(new FileWriter(new_insert_page));
					fontWriter.println("black\nwhite\n018\nMonospaced\n0");
					fontWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				copy(1, currentNB, Integer.parseInt(leftpage_lbl.getText()));
				copy(2, currentNB, Integer.parseInt(rightpage_lbl.getText()));
				
				tot_pg_in_cn++;
				lblNewLabel_5.setText(String.valueOf(tot_pg_in_cn));
			}
			
			else {
				
				//if user entered page number greater than possible(> last_page + 1)
				JOptionPane.showMessageDialog(null,"The number exceeds the total number of pages. Please enter a valid page number");	
			}
			
		}
	}
	
	//method to change file name
	public void changeFileName(File src_name,File dest_name,int insert_page_no) {
		
		if(dest_name.exists()) {
			
			changeFileName(dest_name,new File(pathGiver(currentNB,insert_page_no+2)),insert_page_no+1);
			boolean b=src_name.renameTo(dest_name);
			System.out.print(b);
			System.out.println("tall");
			
		}
		else {
			
		    boolean a=src_name.renameTo(dest_name);
		    System.out.print(a);
		    System.out.println("short");
		}
	}
	
	
	
	public void savingThroughLeftTextArea(int curr_pg_no) {
		
		//Scanner text_area_reader=new Scanner((Readable) first_page_textarea);
		File mod_page = new File(pathGiver(currentNB, curr_pg_no));
		try {
			PrintWriter prt_wrter=new PrintWriter(new FileWriter(mod_page));
			
			prt_wrter.println(left_side.color_name);
			prt_wrter.println(left_side.page_color);
			prt_wrter.println(left_side.size);
			prt_wrter.println(left_side.font);
			prt_wrter.println(left_side.fontType);
			first_page_textarea.write(prt_wrter);
			prt_wrter.println();
		    
			//closing pw
			prt_wrter.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(Integer.parseInt(leftpage_lbl.getText())==Integer.parseInt(rightpage_lbl.getText())) {
			
			File txtFile = new File(pathGiver(currentNB, Integer.parseInt(leftpage_lbl.getText())));
			second_page_textarea.setText("");
			try {
				
				readingTxtFile(txtFile,1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void savingThroughRightTextArea(int curr_pg_no) {
		
		//Scanner text_area_reader=new Scanner((Readable) first_page_textarea);
		File mod_page = new File(pathGiver(currentNB, curr_pg_no));
		try {
			PrintWriter prt_wrter=new PrintWriter(new FileWriter(mod_page));
					
			prt_wrter.println(right_side.color_name);
			prt_wrter.println(right_side.page_color);
			prt_wrter.println(right_side.size);
			prt_wrter.println(right_side.font);
			prt_wrter.println(right_side.fontType);
			second_page_textarea.write(prt_wrter);
			prt_wrter.println();
			
			//closing pw
			prt_wrter.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(Integer.parseInt(leftpage_lbl.getText())==Integer.parseInt(rightpage_lbl.getText())) {
			File txtFile = new File(pathGiver(currentNB, Integer.parseInt(rightpage_lbl.getText())));
			first_page_textarea.setText("");
			try {
				
				readingTxtFile(txtFile,0);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void showAddBook() {
		
		first_page_textarea.append("\n"+"Please select a note book first");
		second_page_textarea.append("\n"+"Please select a note book first");
	}
	
	public void deleteBook(File book) {
		
		File[] files = book.listFiles();
		for(int i=0;i<files.length;i++) {
			
			try {
				Files.deleteIfExists(Paths.get(files[i].getPath()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		book.delete();
	}
	
	public static void refresh() {
		
		//file to access the list of notebooks text file
		for(int i=0;i<20;i++) {
			book_list[i].setVisible(false);
			book_list[i].setText("");
		}
		
		//file to access the list of notebooks text file
		File noteBookList = new File(pathName+"\\LIST_OR_NAMES_OF_NOTE-BOOKS.txt");
		int flg1=-1;
		try {
			Scanner listReader = new Scanner(noteBookList);
			
			//to skip the 'note book' list String on the first line
			listReader.nextLine();
			
			//for loop to loop through the available notebooks
			for(int i=0;listReader.hasNextLine();i++) {
	
				book_list[i].setText(listReader.nextLine());
				book_list[i].setBackground(Color.DARK_GRAY);
				book_list[i].setVisible(true);
				book_list[i].setBorder(null);
				book_list[i].setFocusable(false);
				book_list[i].setForeground(Color.WHITE);
				book_list[i].setFont(new Font("Tahoma", Font.PLAIN, 14));
				book_list[i].setHorizontalAlignment(JButton.LEFT);
				book_list[i].setBounds(35,39+25*i,152,21);
				flg1=i;
			}
			
			//closing the scanner
			listReader.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		//rearranging the create new book button
		create_new_nb_btn.setBounds(35, 39+25*(flg1+1), 180, 21);
		return;
	}
	
	public static void setChangesToTextAreas() {
		first_page_textarea.setFont(new FontUIResource(left_side.font, left_side.fontType, left_side.size));
		first_page_textarea.setForeground(new ColorUIResource(MyColor.getColor(left_side.color_name)));
		first_page_textarea.setBackground(new ColorUIResource(MyColor.getColor(left_side.page_color)));
		second_page_textarea.setFont(new FontUIResource(right_side.font, right_side.fontType, right_side.size));
		second_page_textarea.setForeground(new ColorUIResource(MyColor.getColor(right_side.color_name)));
		second_page_textarea.setBackground(new ColorUIResource(MyColor.getColor(right_side.page_color)));
	}
	
	
	//copy page contents to required text area
	public void copy(int req_ta,String book_name,int pg_no) {
		File page=new File(pathGiver(currentNB,pg_no));
		if(page.exists()) {
			
			if(req_ta==1) {
				
				first_page_textarea.setText("");
				try {
					
					readingTxtFile(page, 0);
	                leftpage_lbl.setText(String.valueOf(pg_no));
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				second_page_textarea.setText("");
				try {
					
					readingTxtFile(page, 1);
	                rightpage_lbl.setText(String.valueOf(pg_no));
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "You are already at the first / last page. You can't go beyond that");
		}
	}
		
	public void readingTxtFile(File page,int lr) {
		Scanner pagereader = null;
		if(lr==0) {
			try {
				pagereader = new Scanner(page);
				first_page_textarea.setText("");
				left_side.color_name = pagereader.nextLine();
				left_side.page_color = pagereader.nextLine();
				left_side.size = Integer.parseInt(pagereader.nextLine().trim());
				left_side.font = pagereader.nextLine();
				left_side.fontType = Integer.parseInt(pagereader.nextLine().trim());
				first_page_textarea.setFont(new FontUIResource(left_side.font,left_side.fontType,left_side.size));
				first_page_textarea.setForeground(MyColor.getColor(left_side.color_name));
				first_page_textarea.setBackground(MyColor.getColor(left_side.page_color));
				while(pagereader.hasNextLine()) {
					
					//left side page showing page1 
					first_page_textarea.append(pagereader.nextLine()+"\n");
				    
				}
				pagereader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				pagereader = new Scanner(page);
				second_page_textarea.setText("");
				right_side.color_name = pagereader.nextLine();
				right_side.page_color = pagereader.nextLine();
				right_side.size = Integer.parseInt(pagereader.nextLine().trim());
				right_side.font = pagereader.nextLine();
				right_side.fontType = Integer.parseInt(pagereader.nextLine().trim());
				second_page_textarea.setFont(new FontUIResource(right_side.font,right_side.fontType,right_side.size));
				second_page_textarea.setForeground(MyColor.getColor(right_side.color_name));
				second_page_textarea.setBackground(MyColor.getColor(right_side.page_color));
				while(pagereader.hasNextLine()) {
					
					//right side page showing page1
					second_page_textarea.append(pagereader.nextLine()+"\n");
					
				}
				
				pagereader.close();	
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		pagereader.close();
	}
	
	public void remove_curr(){
		if(!currentNB.equals("")) {
			System.out.println("okjb");
			File info_file = new File(pathGiver(currentNB)+"\\"+currentNB+"_Book_Info.txt");
			try {
				PrintWriter pt = new PrintWriter(new FileWriter(info_file));
				pt.println("Created On : "+date_lbl.getText());
				pt.print("Last Mod : ");
				String today=DateAndTimeGiver.dateGiver();
				
				pt.print(date_mod_lbl.getText()+" ");
				pt.println(today);
				
				pt.println("Total Pages : "+lblNewLabel_5.getText());
				pt.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			currentNB="";
			current_notebook_shower.setText(currentNB);
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		if(currentNB!="") {
			savingThroughLeftTextArea(Integer.parseInt(leftpage_lbl.getText()));
			savingThroughRightTextArea(Integer.parseInt(rightpage_lbl.getText()));
			remove_curr();
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void adjustPage() {
		
		if(Integer.parseInt(leftpage_lbl.getText())>tot_pg_in_cn) {
			System.out.println("left l");
			copy(1, currentNB, tot_pg_in_cn);
		}
		if(Integer.parseInt(rightpage_lbl.getText())>tot_pg_in_cn) {
			System.out.println("rright l");
			copy(2, currentNB, tot_pg_in_cn);
		}
	}
}
	
class Fontas{
	String color_name;
	String page_color;
	String font;
	int fontType;
	int size;
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	