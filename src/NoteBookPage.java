import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.plaf.synth.SynthGraphicsUtils;
import javax.xml.transform.Source;
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

public class NoteBookPage extends JFrame implements ActionListener {

	private JPanel contentPane;
	private ImageIcon fontChng = new ImageIcon(new ImageIcon("icons8-choose-font-24 (1).png").getImage().getScaledInstance(20,20,100));
	private ImageIcon fontColorChng = new ImageIcon(new ImageIcon("icons8-paint-palette-30.png").getImage().getScaledInstance(20,20,100));
	private ImageIcon fontSizeChng = new ImageIcon(new ImageIcon("icons8-font-size-48.png").getImage().getScaledInstance(20,20,100));
	private ImageIcon deleteBookBtn = new ImageIcon(new ImageIcon("icons8-delete-24.png").getImage().getScaledInstance(20,20,100));
	private ImageIcon deleteBookBtnn = new ImageIcon(new ImageIcon("icons8-delete-384 (1).png").getImage().getScaledInstance(20,20,100));
	private JButton[] book_list = new JButton[20];
	private JButton create_new_nb_btn;
	
	
	//
	private static String pathName = "C:\\DIGIBOOK\\NOTE_BOOKS";
	private JLabel current_notebook_shower;
	
	//left and right page numbers appearing at the bottom of the page
	private String left_page_no="0";
	private String right_page_no="0";
	
	/*
	The current selected notebook that will appear on the screen
	The default is set to empty string i.e. "";
	*/
	private static String currentNB="";
	
	//left and right pages/text area
	private JTextArea first_page_textarea;
	private JTextArea second_page_textarea;
	
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
	private JButton change_size_btn;
	private JButton change_colour_btn;
	
	//delete book button
	private JButton delete_book_btn;
	
	public NoteBookPage() {
		
		//for the main j frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(-7,0,1930,831);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		this.setContentPane(contentPane);
		//this.setResizable(false);
		this.setVisible(true);
		contentPane.setLayout(null);
		
		
		
		
		//the main pages panel
		JPanel pages_panel = new JPanel();
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
		first_page_textarea.setFont(new Font("Monospaced", Font.PLAIN, 17));
		first_page_textarea.setMargin(new Insets(30, 30, 30, 30));
		first_page_textarea.setLineWrap(true);
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
		second_page_textarea.setFont(new Font("Monospaced", Font.PLAIN, 17));
		second_page_textarea.setMargin(new Insets(30, 30, 30, 30));
		second_page_textarea.setLineWrap(true);
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
		left_btn_prev.setFont(new Font("Tahoma", Font.PLAIN, 12));
		left_btn_prev.setEnabled(false);
		left_btn_prev.setFocusable(false);
		left_btn_prev.setBackground(Color.LIGHT_GRAY);
		left_btn_prev.setBounds(10, 666, 41, 21);
		left_btn_prev.addActionListener(this);
		pages_panel.add(left_btn_prev);
		
		left_btn_next = new JButton(">");
		left_btn_next.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
		right_btn_prev.setFont(new Font("Tahoma", Font.PLAIN, 12));
		right_btn_prev.setEnabled(false);
		right_btn_prev.setBackground(Color.LIGHT_GRAY);
		right_btn_prev.setBounds(663, 666, 41, 21);
		right_btn_prev.addActionListener(this);
		pages_panel.add(right_btn_prev);
		
		right_btn_next = new JButton(">");
		right_btn_next.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
		
		
		
		
	
		
		
		
		
		//panel to show the created notebooks and the create new button
		JPanel book_list_panel = new JPanel();
		book_list_panel.setBounds(0, 100, 224, 694);
		book_list_panel.setBackground(Color.DARK_GRAY);
		book_list_panel.setBorder(new LineBorder(Color.WHITE, 2));
		book_list_panel.setPreferredSize(new Dimension(200, 10));
		contentPane.add(book_list_panel);
		book_list_panel.setLayout(null);
		
		//label showing your notebooks 
		JLabel Your_nbs_label = new JLabel("Your NoteBooks :");
		Your_nbs_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Your_nbs_label.setForeground(Color.LIGHT_GRAY);
		Your_nbs_label.setBounds(15, 15, 118, 21);
		book_list_panel.add(Your_nbs_label);
		
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
				book_list[i]=new JButton();
				book_list[i].setText(NB1);
				book_list[i].setBackground(Color.DARK_GRAY);
				book_list[i].setBorder(null);
				book_list[i].setFocusable(false);
				book_list[i].setForeground(Color.WHITE);
				book_list[i].setFont(new Font("Tahoma", Font.PLAIN, 14));
				book_list[i].setHorizontalAlignment(JButton.LEFT);
				book_list[i].setBounds(35,39+25*i,152,21);
				book_list[i].addActionListener(this);
				book_list_panel.add(book_list[i]);
				flg1=i;
			}
			
			//closing the scanner
			listReader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//create new notebook button
		create_new_nb_btn = new JButton("+ Create New Note-Book");
		create_new_nb_btn.setBorder(null);
		create_new_nb_btn.setBackground(Color.DARK_GRAY);
		create_new_nb_btn.setFocusable(false);
		create_new_nb_btn.setForeground(Color.WHITE);
		create_new_nb_btn.setHorizontalAlignment(JButton.LEFT);
		create_new_nb_btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		create_new_nb_btn.setBounds(35, 39+25*(flg1+1), 180, 21);
		create_new_nb_btn.addActionListener(this);
		book_list_panel.add(create_new_nb_btn);
		
		//this will show the date created and the date it was last modified before today
		JLabel date_created_lbl = new JLabel("Date created :");
		date_created_lbl.setForeground(Color.LIGHT_GRAY);
		date_created_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		date_created_lbl.setBounds(15, 637, 94, 13);
		book_list_panel.add(date_created_lbl);
		
		date_lbl = new JLabel("-");
		date_lbl.setForeground(Color.WHITE);
		date_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		date_lbl.setBounds(110, 637, 85, 13);
		book_list_panel.add(date_lbl);
		
		JLabel last_mod_lbl = new JLabel("Last modified :");
		last_mod_lbl.setForeground(Color.LIGHT_GRAY);
		last_mod_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		last_mod_lbl.setBounds(15, 660, 94, 13);
		book_list_panel.add(last_mod_lbl);
		
		date_mod_lbl = new JLabel("-");
		date_mod_lbl.setForeground(Color.WHITE);
		date_mod_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		date_mod_lbl.setBounds(113, 660, 85, 13);
		book_list_panel.add(date_mod_lbl);
		
		
		
		
		
		
		//The top panel showing the fonts color and etc change buttons and the current notebook label
		JPanel Functions_panel = new JPanel();
		Functions_panel.setBounds(0, 0, 1540, 100);
		Functions_panel.setBackground(Color.LIGHT_GRAY);
		Functions_panel.setPreferredSize(new Dimension(10, 100));
		contentPane.add(Functions_panel);
		Functions_panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(null);
		menuBar.setBackground(Color.DARK_GRAY);
		menuBar.setBounds(0, 0, 1540, 34);
		Functions_panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnNewMenu.setForeground(Color.LIGHT_GRAY);
		menuBar.add(mnNewMenu);
		
		JLabel current_nb_label = new JLabel("Current NoteBook : ");
		current_nb_label.setHorizontalAlignment(SwingConstants.CENTER);
		current_nb_label.setFont(new Font("Tahoma", Font.BOLD, 30));
		current_nb_label.setBounds(582, 40, 302, 50);
		Functions_panel.add(current_nb_label);
		
		current_notebook_shower = new JLabel("-");
		current_notebook_shower.setFont(new Font("Tahoma", Font.BOLD, 30));
		current_notebook_shower.setBounds(886, 40, 508, 50);
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
		change_font_btn.setBounds(3, 36, 37, 27);
		change_font_btn.setIcon(fontChng);
		change_font_btn.addActionListener(this);
		Functions_panel.add(change_font_btn);
		
		change_size_btn = new JButton("");
		change_size_btn.setBackground(Color.GRAY);
		change_size_btn.setBorder(null);
		change_size_btn.setFocusable(false);
		change_size_btn.setBounds(43, 36, 37, 27);
		change_size_btn.addActionListener(this);
		change_size_btn.setIcon(fontSizeChng);
		Functions_panel.add(change_size_btn);
		
		change_colour_btn = new JButton("");
		change_colour_btn.setFocusable(false);
		change_colour_btn.setBorder(null);
		change_colour_btn.setBackground(Color.GRAY);
		change_colour_btn.setBounds(83, 36, 37, 27);
		change_colour_btn.addActionListener(this);
		change_colour_btn.setIcon(fontColorChng);
		Functions_panel.add(change_colour_btn);
		
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
			int choice = JOptionPane.showConfirmDialog(null,"Do you really want to delete the current book ?", currentNB,JOptionPane.YES_NO_OPTION);
			if(choice==0) {
				
				//calling delete method
				deleteBook(new File(pathGiver(currentNB)));
			}
		}		
		
		// private static String pathName = "C:\\DIGIBOOK\\NOTE_BOOKS"; for reference path name for book so that 
		// I don't have to scroll all the way up
		
		for(int i=0;i<20;i++) {
			if(e.getSource()==book_list[i]) {
				
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
					pagereader = new Scanner(noteBookPage);
					first_page_textarea.setText("");
					while(pagereader.hasNextLine()) {
						
						//left side page showing page1 
						first_page_textarea.append(pagereader.nextLine()+"\n");
					    
					}
					leftpage_lbl.setText(String.valueOf(1));
					pagereader.close();
					
					//for copying the page 1 contents on the right page
					pagereader = new Scanner(noteBookPage);
					second_page_textarea.setText("");
					while(pagereader.hasNextLine()) {
						
						//right side page showing page1
						second_page_textarea.append(pagereader.nextLine()+"\n");
						
					}
					rightpage_lbl.setText(String.valueOf(1));
					//closing the scanner
					pagereader.close();	
		            
				} catch (FileNotFoundException e1) {
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
			insertFile(currentNB,Integer.parseInt(insert_new_page_tf.getText()));
			return;
		}
		
		//change font button clicked
		if(e.getSource()==change_font_btn) {
			
			first_page_textarea.setFont(new Font("Monospaced", Font.PLAIN, 40));
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
	public void insertFile(String bookname,int insert_page_no) {
		
		if(bookname=="") {
			
			//showing the user that you have not selected a book
			showAddBook();
		}
		else {
			File new_page = new File(pathGiver(currentNB,insert_page_no));
			File new_pages_prev_page = new File(pathGiver(currentNB,insert_page_no-1));
			File new_pages_next_page = new File(pathGiver(currentNB,insert_page_no+1));
			
			//booleans to define the three page existences
			boolean a,b,c;
			a=new_page.exists();
			b=new_pages_next_page.exists();
			c=new_pages_prev_page.exists();
			
			if(!c) {
				///if previous page doesn't exist then don't create the required page
				JOptionPane.showMessageDialog(null,"The number exceeds the total number of pages. Please enter a valid page number");
					
			}
			else if(b) {
				
				changeFileName(new_page,new_pages_next_page,insert_page_no);
				File new_insert_page = new File(pathGiver(currentNB, insert_page_no));
				
				try {
					new_insert_page.createNewFile();
					FileWriter fontFileWriter = new FileWriter(new_insert_page);
					PrintWriter fontWriter = new PrintWriter(fontFileWriter);
					fontWriter.println("Monospaced.PLAIN 18 Black");
					fontFileWriter.close();
					fontWriter.close();
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
				
			}
		}
	}
	
	//method to change file name
	public void changeFileName(File src_name,File dest_name,int insert_page_no) {
		
		if(dest_name.exists()) {
			changeFileName(dest_name,new File(pathGiver(currentNB,insert_page_no+2)),insert_page_no+1);
			boolean b=src_name.renameTo(dest_name);
			System.out.println(b);
		}
		else {
		    boolean a=src_name.renameTo(dest_name);
		    System.out.println(a);
		}
	}
	
	//copy page contents to required text area
	public void copy(int req_ta,String book_name,int pg_no) {
		File page=new File(pathGiver(currentNB,pg_no));
		if(req_ta==1) {
			if(page.exists()) {
				first_page_textarea.setText("");
				try {
					Scanner pagereader=new Scanner(page);
	                while(pagereader.hasNextLine()) {
						
						//left side page showing page current+1
						first_page_textarea.append(pagereader.nextLine()+"\n");
						//leftpage_lbl.setText(String.valueOf(1));
					}
	                leftpage_lbl.setText(String.valueOf(pg_no));
	                pagereader.close();
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		else {
			if(page.exists()) {
				second_page_textarea.setText("");
				try {
					Scanner pagereader=new Scanner(page);
	                while(pagereader.hasNextLine()) {
						
						//left side page showing page current+1
						second_page_textarea.append(pagereader.nextLine()+"\n");
						//leftpage_lbl.setText(String.valueOf(1));
					}
	                rightpage_lbl.setText(String.valueOf(pg_no));
	                pagereader.close();
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	
	public void savingThroughLeftTextArea(int curr_pg_no) {
		
		System.out.println("testing left");
		System.out.println();
		//Scanner text_area_reader=new Scanner((Readable) first_page_textarea);
		File mod_page = new File(pathGiver(currentNB, curr_pg_no));
		try {
			FileWriter mod_writer=new FileWriter(mod_page);
			PrintWriter prt_wrter=new PrintWriter(mod_writer);
			
			first_page_textarea.write(prt_wrter);
			prt_wrter.println();
				
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(Integer.parseInt(leftpage_lbl.getText())==Integer.parseInt(rightpage_lbl.getText())) {
			//System.out.println("than than gopal");
			File txtFile = new File(pathGiver(currentNB, Integer.parseInt(leftpage_lbl.getText())));
			second_page_textarea.setText("");
			try {
				Scanner textreader = new Scanner(txtFile);
				
				while(textreader.hasNextLine()) {
					second_page_textarea.append(textreader.nextLine()+"\n");
				}
				
				//closing the scanner
				textreader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void savingThroughRightTextArea(int curr_pg_no) {
		System.out.println("testing right");
		System.out.println();
		//Scanner text_area_reader=new Scanner((Readable) first_page_textarea);
		File mod_page = new File(pathGiver(currentNB, curr_pg_no));
		try {
			FileWriter mod_writer=new FileWriter(mod_page);
			PrintWriter prt_wrter=new PrintWriter(mod_writer);
					
			second_page_textarea.write(prt_wrter);
			prt_wrter.println();
					
			mod_writer.close();
			prt_wrter.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(Integer.parseInt(leftpage_lbl.getText())==Integer.parseInt(rightpage_lbl.getText())) {
			File txtFile = new File(pathGiver(currentNB, Integer.parseInt(rightpage_lbl.getText())));
			first_page_textarea.setText("");
			try {
				Scanner textreader = new Scanner(txtFile);
				
				while(textreader.hasNextLine()) {
					first_page_textarea.append(textreader.nextLine()+"\n");
				}
				
				//CLosing scanner
				textreader.close();
			} catch (FileNotFoundException e) {
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
		
	}
}