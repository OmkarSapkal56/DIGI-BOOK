import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.imageio.plugins.tiff.TIFFDirectory;
import javax.lang.model.element.NestingKind;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.synth.SynthGraphicsUtils;
import javax.xml.transform.Source;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.PrimitiveIterator.OfDouble;
//import java.util.stream.Sink.ChainedDouble;
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

public class NewNoteBookPage extends JFrame implements ActionListener,ItemListener {

	private JPanel contentPane;
	private ImageIcon fontChng = new ImageIcon(new ImageIcon("icons8-choose-font-24 (1).png").getImage().getScaledInstance(20,20,100));
	private ImageIcon fontColorChng = new ImageIcon(new ImageIcon("icons8-paint-palette-30.png").getImage().getScaledInstance(20,20,100));
	private ImageIcon fontSizeChng = new ImageIcon(new ImageIcon("icons8-font-size-48.png").getImage().getScaledInstance(20,20,100));
	private ImageIcon deleteBookBtnn = new ImageIcon(new ImageIcon("icons8-delete-384 (1).png").getImage().getScaledInstance(20,20,100));
	private ImageIcon refreshBtnn = new ImageIcon(new ImageIcon("icons8-refresh-64.png").getImage().getScaledInstance(15,15,100));
	private ImageIcon delet_page_icon = new ImageIcon(new ImageIcon("icons8-delete-24.png").getImage().getScaledInstance(15,15,100));
	private static JButton[] book_list;
	private static JButton create_new_nb_btn;
	static JPanel book_list_panel;
	
	String [] themes = {"Dark","Light","Custom"};
	
	//
	private static String pathName = "C:\\DIGIBOOK\\NOTE_BOOKS";
	
	//the label for showing current notebook
	private JLabel current_nb_label;
	private JLabel current_notebook_shower;
	
	/*
	The current selected notebook that will appear on the screen
	The default is set to empty string i.e. "";
	*/
	private static String currentNB="";
	
	//left and right pages/text area
	static JTextArea first_page_textarea;
	static JTextArea second_page_textarea;
	
	//left and right page numbers
	private JLabel leftpage_lbl;
	private JLabel rightpage_lbl;
	
	//date created label
	private JLabel date_lbl;
	private JLabel date_mod_lbl;
	
	//The next and previous page button
	private JButton left_btn_next;
	private JButton left_btn_prev;
	private JButton right_btn_next;
	private JButton right_btn_prev;
	private JTextField page_no_tf_left;
	private JTextField page_no_tf_right;
	private JTextField insert_new_page_tf;
	
	//the three change font color and size buttons
	private JButton change_font_btn;
	
	//delete book button
	private JButton delete_book_btn;
	
	//setting menu
	JMenuItem setting_btn_in_menu;
	
	//delete current page button
	private JButton delete_pg_btn_left;
	private JButton delete_pg_btn_right;
	
	static Fontas left_side = new Fontas();
	static Fontas right_side = new Fontas();
	
	static JPanel pages_panel;
	
	private JComboBox comboBox;
	
	private JLabel Your_nbs_label;
	
	private JLabel last_mod_lbl;
	
	private JLabel date_created_lbl;
	
	static JPanel Functions_panel;
	
	static JMenuBar menuBar;
	
	static JMenu fileMenu;
	static JMenu helpMenu;
	
	public NewNoteBookPage() {
		
		//for the main j frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(-7,0,1930,831);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		this.setContentPane(contentPane);
		//this.setResizable(false);
		this.setVisible(true);
		this.setTitle("DiGIBOOK-NOTEBOOKS");
		contentPane.setLayout(null);
		
		
		
		
		//the main pages panel
		pages_panel = new JPanel();
		pages_panel.setBounds(224, 100, 1316, 694);
		pages_panel.setBackground(Color.GRAY);
		contentPane.add(pages_panel);
		//pages_panel.setBorder(new LineBorder(Color.BLACK,1));
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
		//second_page_textarea.setBorder(new LineBorder(ColorUIResource.BLACK,2));
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
		
		JLabel Enter_page_no_lbl_left = new JLabel("Page no :");
		Enter_page_no_lbl_left.setForeground(Color.WHITE);
		Enter_page_no_lbl_left.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Enter_page_no_lbl_left.setBounds(56, 670, 60, 13);
		pages_panel.add(Enter_page_no_lbl_left);
		
		JLabel Enter_page_no_lbl_right = new JLabel("Page no :");
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
		//delete_pg_btn_right.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
		//file to access the list of notebooks text file
		File noteBookList = new File(pathName+"\\LIST_OR_NAMES_OF_NOTE-BOOKS.txt");
		int flg1=-1;
		try {
			Scanner listReader = new Scanner(noteBookList);
			
			//to skip the 'note book' list String on the first line
			listReader.nextLine();
			
			//for loop to loop through the available notebooks
			for(int i=0;listReader.hasNextLine();i++) {
	
				String NB1 = listReader.nextLine();
				//book_list[i]=new JButton();
				book_list[i].setText(NB1);
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
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//create new notebook button
		create_new_nb_btn = new JButton("+ CREATE NEW NOTE-BOOK");
		create_new_nb_btn.setBorder(null);
		create_new_nb_btn.setBackground(Color.DARK_GRAY);
		create_new_nb_btn.setFocusable(false);
		create_new_nb_btn.setForeground(Color.WHITE);
		create_new_nb_btn.setOpaque(false);
		create_new_nb_btn.setHorizontalAlignment(JButton.LEFT);
		create_new_nb_btn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		create_new_nb_btn.setBounds(35, 39+25*(flg1+1), 180, 21);
		create_new_nb_btn.addActionListener(this);
		book_list_panel.add(create_new_nb_btn);
		
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
		
		String []themString = {"-Select-","DARK","LIGHT"};
		
		
		
		
		
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
		
//		JMenu mnNewMenu = new JMenu("File");
//		mnNewMenu.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		mnNewMenu.setForeground(Color.LIGHT_GRAY);
//		menuBar.add(mnNewMenu);
		
		
		current_nb_label = new JLabel("Current NoteBook : ");
		current_nb_label.setHorizontalAlignment(SwingConstants.CENTER);
		current_nb_label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		current_nb_label.setBounds(663, 44, 270, 50);
		Functions_panel.add(current_nb_label);
		
		current_notebook_shower = new JLabel("-");
		current_notebook_shower.setFont(new Font("Tahoma", Font.BOLD, 30));
		current_notebook_shower.setBounds(936, 44, 508, 50);
		Functions_panel.add(current_notebook_shower);
		
		delete_book_btn = new JButton("");
		delete_book_btn.setBackground(Color.GRAY);
		delete_book_btn.setIcon(deleteBookBtnn);
		delete_book_btn.setFocusable(false);
		delete_book_btn.setBorder(null);
		delete_book_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		delete_book_btn.setBounds(1497, 69, 37, 27);
		delete_book_btn.addActionListener(this);
		Functions_panel.add(delete_book_btn);
		
		//The 3 change font, size and color buttons
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
		
		JLabel insert_new_page_lbl = new JLabel("Insert new page at :");
		insert_new_page_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		insert_new_page_lbl.setBounds(234, 73, 117, 21);
		Functions_panel.add(insert_new_page_lbl);
		
		comboBox = new JComboBox(themes);
		comboBox.setFocusable(false);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setBounds(46, 36, 64, 30);
		comboBox.addItemListener(this);
		Functions_panel.add(comboBox);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//action after clicking on create new note book
		if(e.getSource()==create_new_nb_btn) {
			
			//new JFrame to create new NB
			new CreateNewNotebook();
			return;
		}
		
		//delete current book function
		if(e.getSource()==delete_book_btn) {
			
			if(currentNB=="") {
				
				//if there is no notebook selected
				JOptionPane.showMessageDialog(null,"You have no book selected");
				return;
			}
			
			int choice = JOptionPane.showConfirmDialog(null,"Do you really want to delete the current book ?", currentNB,JOptionPane.YES_NO_OPTION);
			
			if(choice==0) {
				
				//calling delete method
				deleteBook(new File(pathGiver(currentNB)));
				//removing the book name form the list of books text file
				File list_of_nb = new File(pathName+"\\LIST_OR_NAMES_OF_NOTE-BOOKS.txt");
				
				try {
					
					Scanner file_rdr = new Scanner(list_of_nb);
					String wholeString="";
					int i=0;
					while(file_rdr.hasNextLine()) {
						if(i==0) {
							wholeString = wholeString + file_rdr.nextLine();
							i=1;
						}
						else {
							wholeString = wholeString +"\n"+ file_rdr.nextLine();
						}
					}
					wholeString=wholeString+"\n";
					wholeString=wholeString.replace("> "+currentNB+"\n","");
					
					FileWriter addBook = new FileWriter(list_of_nb);
					PrintWriter add_Book = new PrintWriter(addBook);
					
					add_Book.print(wholeString);
					
					add_Book.close();
					addBook.close();
					file_rdr.close();
					refresh();
					currentNB="";
					current_notebook_shower.setText("-");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			return;
		}		
		
		// private static String pathName = "C:\\DIGIBOOK\\NOTE_BOOKS"; for reference path name for book so that 
		// I don't have to scroll all the way up
		
		for(int i=0;i<20;i++) {
			if(e.getSource().equals(book_list[i])) {
				
				//current book name in bold name
				currentNB=book_list[i].getText().replace("> ","");
				current_notebook_shower.setText("'"+currentNB+"'");
				
				//file for the notebooks 1st and 2nd page
				File noteBookPage;
				//path String of NB 1st and 2nd page
				String pname;
				//scanner to read from the books and append to text area
				Scanner pagereader;
				try {
					
					//reading the first page data
					pname=pathGiver(currentNB,1);
					noteBookPage = new File(pname);
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
				
				//all this for getting the date and of creation of a particular notebook
				File ActualNB=new File(pathGiver(currentNB));
				BasicFileAttributes ftpAttr = null;
				try {
					ftpAttr = Files.readAttributes(ActualNB.toPath(),BasicFileAttributes.class);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String crea_date = String.valueOf(ftpAttr.creationTime()).substring(0,10);
				String crea_date_arranged = crea_date.substring(8,10)+crea_date.substring(4,8)+crea_date.substring(0,4);
				//System.out.println(crea_date_arranged);
				//date_mod_lbl.setText(DateAndTimeGiver.dateGiver());
				date_lbl.setText(crea_date_arranged);
				
				//for modified date 
				File mod_dt = new File(pathGiver(currentNB)+"\\"+currentNB+"_LastModified.txt");
				Scanner dt_rdr=null;
				try {
					 dt_rdr = new Scanner(mod_dt);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				date_mod_lbl.setText(dt_rdr.nextLine());
				dt_rdr.close();
				
				
				try {
					FileWriter tomFileWriter = new FileWriter(mod_dt);
					PrintWriter tomPrintWriter = new PrintWriter(tomFileWriter);
					
					tomPrintWriter.println(DateAndTimeGiver.dateGiver());
					tomPrintWriter.close();
					tomFileWriter.close();
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//enabling the next and prev page buttons
				left_btn_next.setEnabled(true);
				left_btn_prev.setEnabled(true);
				right_btn_next.setEnabled(true);
				right_btn_prev.setEnabled(true);
				return;
			}
		}
		
		
		
		
		//for left side page next button
		if(e.getSource()==left_btn_next) {
			int curr_pg_no = Integer.parseInt(leftpage_lbl.getText());
			savingThroughLeftTextArea(curr_pg_no);
			int next_pg_no = curr_pg_no+1;
			copy(1, currentNB, next_pg_no);
			return;
		}
		
		//for left side page previous button
		if(e.getSource()==left_btn_prev) {
			int curr_pg_no = Integer.parseInt(leftpage_lbl.getText());
			savingThroughLeftTextArea(curr_pg_no);
			int prev_pg_no = curr_pg_no-1;
			copy(1, currentNB, prev_pg_no);
			return;
		}
		
		//for right side page next button
		if(e.getSource()==right_btn_next) {
			int curr_pg_no = Integer.parseInt(rightpage_lbl.getText());
			savingThroughRightTextArea(curr_pg_no);
			int next_pg_no = curr_pg_no+1;
			copy(2, currentNB, next_pg_no);
			return;
		}
		
		//for right side page previous button
		if(e.getSource()==right_btn_prev) {
			int curr_pg_no = Integer.parseInt(rightpage_lbl.getText());
			savingThroughRightTextArea(curr_pg_no);
			int prev_pg_no = curr_pg_no-1;
			copy(2, currentNB, prev_pg_no);
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
		
		//left side page delete
		if(e.getSource()==delete_pg_btn_left) {
			
			if(currentNB=="") {
				showAddBook();
			}
			
			else {
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
			}
			return;
			
		}
		
		//right side page delete
        if(e.getSource()==delete_pg_btn_right) {
			
        	if(currentNB=="") {
        		showAddBook();
        	}
        	
        	else {
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
			}
			return;
			
		}
		
	}
	
	/**
	 *this function accepts only name of the notebook without including
	 *the 'NB_th...' and returns the path_string of the entered book
	 */
	public static String pathGiver(String book_name) {
		String path_of_book=pathName+"\\NB_"+book_name;
		return path_of_book;
	}
	
	/**
	 *this function accepts name and page no of the notebook without including
	 *the 'NB_th...' and returns the path_string of the entered books page number
	 */	
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
			
			
			//booleans to define the three page existences
			boolean a,b,c;
			a=new_page.exists();
			//b=new_pages_next_page.exists();
			c=new_pages_prev_page.exists();
			
			if(a || c) {
				
				
				if(a) {
					changeFileName(new_page,new_pages_next_page,insert_page_no);
					System.out.println("oih");
					
				}
				File new_insert_page = new File(pathGiver(currentNB, insert_page_no));
				try {
					new_insert_page.createNewFile();
					FileWriter fontFileWriter = new FileWriter(new_insert_page);
					PrintWriter fontWriter = new PrintWriter(fontFileWriter);
					fontWriter.println("black\n018\nMonospaced\n0");
					//System.out.println("one");
					fontWriter.close();
					fontFileWriter.close();
					//System.out.println("two");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				//this whole thing is for if the page is inserted at a place where the current page is open then reload it then and there so that user doesn't need to
				//go front then come behind in order to see the results
				File abgF = new File(pathGiver(currentNB,Integer.parseInt(leftpage_lbl.getText())));
				File abgf = new File(pathGiver(currentNB,Integer.parseInt(rightpage_lbl.getText())));
				first_page_textarea.setText("");
				second_page_textarea.setText("");
				try {
					Scanner scanner = new Scanner(abgF);
					Scanner scnnr = new Scanner(abgf);
					
					//skipping the the first lines of both pages
					for(int i=0;i<4;i++) {
						scanner.nextLine();
						scnnr.nextLine();
					}
					while(scanner.hasNextLine()) {
						
						//left side page showing page current+1
						first_page_textarea.append(scanner.nextLine()+"\n");
						//leftpage_lbl.setText(String.valueOf(1));
					}
                    while(scnnr.hasNextLine()) {
						
						//left side page showing page current+1
						second_page_textarea.append(scnnr.nextLine()+"\n");
						//leftpage_lbl.setText(String.valueOf(1));
					}
					
                    //rightpage_lbl.setText(String.valueOf(required_pg_no));
                    
					scanner.close();
					scnnr.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else {
				
				///if previous page doesn't exist then don't create the required page
				JOptionPane.showMessageDialog(null,"The number exceeds the total number of pages. Please enter a valid page number");	
			}
		//	people meet, they like something superficial, and then they fill in the blanks,with whatever they want to believe full stop
			
			
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
	
	//copy page contents to required text area
	public void copy(int req_ta,String book_name,int pg_no) {
		File page=new File(pathGiver(currentNB,pg_no));
		if(req_ta==1) {
			if(page.exists()) {
				first_page_textarea.setText("");
				try {
					
					readingTxtFile(page, 0);
	                leftpage_lbl.setText(String.valueOf(pg_no));
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		else {
			if(page.exists()) {
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
	}
	
	public void savingThroughLeftTextArea(int curr_pg_no) {
		
		//Scanner text_area_reader=new Scanner((Readable) first_page_textarea);
		File mod_page = new File(pathGiver(currentNB, curr_pg_no));
		try {
			FileWriter mod_writer=new FileWriter(mod_page);
			PrintWriter prt_wrter=new PrintWriter(mod_writer);
			
			prt_wrter.println(left_side.color_name);
			prt_wrter.println(left_side.size);
			prt_wrter.println(left_side.font);
			prt_wrter.println(left_side.fontType);
			first_page_textarea.write(prt_wrter);
			prt_wrter.println();
		    
			//closing both writers
			prt_wrter.close();
			mod_writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(Integer.parseInt(leftpage_lbl.getText())==Integer.parseInt(rightpage_lbl.getText())) {
			//System.out.println("than than gopal");
			File txtFile = new File(pathGiver(currentNB, Integer.parseInt(leftpage_lbl.getText())));
			second_page_textarea.setText("");
			try {
//				Scanner textreader = new Scanner(txtFile);
//				for(int i=0;i<4;i++) {
//					textreader.nextLine();
//				}
//				while(textreader.hasNextLine()) {
//					second_page_textarea.append(textreader.nextLine()+"\n");
//				}
//				
//				//closing the scanner
//				textreader.close();
				
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
			FileWriter mod_writer=new FileWriter(mod_page);
			PrintWriter prt_wrter=new PrintWriter(mod_writer);
					
			prt_wrter.println(right_side.color_name);
			prt_wrter.println(right_side.size);
			prt_wrter.println(right_side.font);
			prt_wrter.println(right_side.fontType);
			second_page_textarea.write(prt_wrter);
			prt_wrter.println();
			
			//closing both writers
			prt_wrter.close();
			mod_writer.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(Integer.parseInt(leftpage_lbl.getText())==Integer.parseInt(rightpage_lbl.getText())) {
			File txtFile = new File(pathGiver(currentNB, Integer.parseInt(rightpage_lbl.getText())));
			first_page_textarea.setText("");
			try {
//				Scanner textreader = new Scanner(txtFile);
//				for(int i=0;i<4;i++) {
//					textreader.nextLine();
//				}
//				while(textreader.hasNextLine()) {
//					first_page_textarea.append(textreader.nextLine()+"\n");
//				}
//				
//				//CLosing scanner
//				textreader.close();
				readingTxtFile(txtFile,0);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void showAddBook() {
		
		first_page_textarea.setText("Please select a note book first");
		second_page_textarea.setText("Please select a note book first");
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
	
				String NB1 = listReader.nextLine();
				System.out.println(NB1);
				//book_list[i]=new JButton();
				book_list[i].setText(NB1);
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
		second_page_textarea.setFont(new FontUIResource(right_side.font, right_side.fontType, right_side.size));
		second_page_textarea.setForeground(new ColorUIResource(MyColor.getColor(right_side.color_name)));
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
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
				book_list_panel.setBorder(new LineBorder(ColorUIResource.WHITE, 2));
				
				Functions_panel.setBackground(ColorUIResource.LIGHT_GRAY);
				menuBar.setBackground(ColorUIResource.DARK_GRAY);
				insert_new_page_tf.setBorder(null);
				
				fileMenu.setForeground(ColorUIResource.LIGHT_GRAY);
				helpMenu.setForeground(ColorUIResource.LIGHT_GRAY);
				
			}
            if(String.valueOf(comboBox.getSelectedItem())=="Light") {
            	book_list_panel.setBackground(ColorUIResource.LIGHT_GRAY);
				create_new_nb_btn.setForeground(ColorUIResource.BLACK);
				Your_nbs_label.setForeground(ColorUIResource.DARK_GRAY);
				for(int i=0;i<20;i++) {
					book_list[i].setForeground(ColorUIResource.BLACK);
				}
				last_mod_lbl.setForeground(ColorUIResource.BLACK);
				date_mod_lbl.setForeground(ColorUIResource.BLACK);
				date_lbl.setForeground(ColorUIResource.BLACK);
				date_created_lbl.setForeground(ColorUIResource.BLACK);
				book_list_panel.setBorder(new LineBorder(ColorUIResource.BLACK, 2));
				
				Functions_panel.setBackground(ColorUIResource.WHITE);
				menuBar.setBackground(ColorUIResource.WHITE);
				menuBar.setBorder(new LineBorder(ColorUIResource.BLACK,1));
				menuBar.setBackground(ColorUIResource.LIGHT_GRAY);
				fileMenu.setForeground(ColorUIResource.BLACK);
				helpMenu.setForeground(ColorUIResource.BLACK);
				pages_panel.setBorder(null);
				insert_new_page_tf.setBorder(new LineBorder(ColorUIResource.BLACK,1));
			}
            else if(String.valueOf(comboBox.getSelectedItem())=="Custom") {
            	new SettingScreen();
            }
		}
	}
	
	public void readingTxtFile(File page,int lr) {
		Scanner pagereader = null;
		if(lr==0) {
			try {
				pagereader = new Scanner(page);
				first_page_textarea.setText("");
				//System.out.println(pagereader.nextLine());
				left_side.color_name = pagereader.nextLine();
				left_side.size = Integer.parseInt(pagereader.nextLine().trim());
				left_side.font = pagereader.nextLine();
				left_side.fontType = Integer.parseInt(pagereader.nextLine().trim());
				first_page_textarea.setFont(new FontUIResource(left_side.font,left_side.fontType,left_side.size));
				first_page_textarea.setForeground(MyColor.getColor(left_side.color_name));
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
				right_side.size = Integer.parseInt(pagereader.nextLine().trim());
				right_side.font = pagereader.nextLine();
				right_side.fontType = Integer.parseInt(pagereader.nextLine().trim());
				second_page_textarea.setFont(new FontUIResource(right_side.font,right_side.fontType,right_side.size));
				second_page_textarea.setForeground(MyColor.getColor(right_side.color_name));
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
}
	
class Fontas{
	String color_name;
	String font;
	int fontType;
	int size;
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	