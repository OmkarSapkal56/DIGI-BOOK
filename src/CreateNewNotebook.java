import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.a.authentication.CachingSha2PasswordPlugin.AuthStage;
import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CreateNewNotebook extends JFrame implements ActionListener {

	private JPanel contentPane;
	static private JTextField textField;
	private JButton create_book_btn;
	private static String pathName = "C:\\DIGIBOOK\\NOTE_BOOKS";
	private static String booksListpath = pathName+"\\lIST_OR_NAMES_OF_NOTE-BOOKS.txt";
	//protected static String book_name="";

	public CreateNewNotebook() {
		
		//main j frame for accepting book name
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(590,350,366,195);
		this.setVisible(true);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel name_label = new JLabel("Enter book name :");
		name_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		name_label.setBounds(40, 50, 106, 16);
		contentPane.add(name_label);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(156, 44, 157, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		create_book_btn = new JButton("Create Note-Book");
		create_book_btn.setBackground(Color.LIGHT_GRAY);
		create_book_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		create_book_btn.setBorder(null);
		create_book_btn.setFocusable(false);
		create_book_btn.setBounds(114, 95, 115, 29);
		create_book_btn.addActionListener(this);
		contentPane.add(create_book_btn);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==create_book_btn) {
			
			File list_of_nb = new File(booksListpath);
			
			try {
				
				/*
				writing to the notebook list text file i.e. adding the newly 
				created notebook
				*/
				FileWriter addBook = new FileWriter(list_of_nb,true);
				PrintWriter add_Book = new PrintWriter(addBook);
				add_Book.println("> "+textField.getText());
				add_Book.close();
				addBook.close();
				
				//creating the actual notebook
				File noteBook = new File(pathName+"\\NB_"+textField.getText());
				noteBook.mkdir();
				
				//creating the first page   name -> "Page_1",etc
				String pagePath=NoteBookPage.pathGiver(textField.getText())+"\\"+textField.getText()+"_Page_1.txt";
				File noteBookPage=new File(pagePath);
				noteBookPage.createNewFile();
				
				
				FileWriter fontFileWriter = new FileWriter(noteBookPage);
				PrintWriter fontWriter = new PrintWriter(fontFileWriter);
				fontWriter.printf("black\n018\nMonospaced\n0");
				fontWriter.close();
				fontFileWriter.close();
				
				
				//creating the last accessed file storing the dates of the last time this book was accessed
				String last_acc_date_file_path=NoteBookPage.pathGiver(textField.getText())+"\\"+textField.getText()+"_LastModified.txt";
				File last_accessed_date_file=new File(last_acc_date_file_path);
				last_accessed_date_file.createNewFile();
				NewNoteBookPage.refresh();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.dispose();
			//new NoteBookPage();
		}
	}
}
