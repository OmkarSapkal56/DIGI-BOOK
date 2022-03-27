import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTML;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class InstructionPanel extends JFrame {

	private JPanel contentPane;
	private ImageIcon delet_page_icon = new ImageIcon(new ImageIcon("icons8-trash-can-24.png").getImage());
	
	public InstructionPanel() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(300, 20, 900, 710);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setTitle("Instructions");
		this.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 986, 104);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblNewLabel_13 = new JLabel("<html><b>BASICS</b>");
		lblNewLabel_13.setBounds(30, 30, 58, 19);
		panel_1.add(lblNewLabel_13);
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_13.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setBounds(30, 52, 946, 38);
		panel_1.add(lblNewLabel_14);
		lblNewLabel_14.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_14.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14.setText("<html>This is just like a digital copy of the note-books you usually use for writing purposes"
				+ "<br>and in some scenarios even better than those<html>");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 104, 986, 200);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FEATURES");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(30, 10, 88, 19);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setText("<html>You can create multiple books as you want and delete them as needed<br>"
				+ "You can add and delete as many pages as you want at any position<br>"
				+ "You can set the font and its type, text size and color and page color for every page<br>"
				+ "You can scroll through the pages or jump directly to a particular page<br>"
				+ "You will have two sides to work on and both of them will be independant of each other<br>"
				+ "You can design your panel according to the color of your choice<br>"
				+ "You do not need to save your book data. It gets auto saved<br>"
				+ "You can keep track of the number of pages, creation date and the date you last modified for a particular book");
		lblNewLabel_1.setBounds(30, 31, 946, 154);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(0, 304, 986, 158);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ADDING/DELETING A BOOK");
		lblNewLabel_2.setBounds(30, 10, 216, 19);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(30, 32, 946, 116);
		panel_3.add(lblNewLabel_3);
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setText("<html>The list of all notebooks will show up on the left side of the screen<br>"
				+ "Select your desired notebook<br>"
				+ "If you haven't created one you can do so by clicking on the 'CREATE NEW NOTE-BOOK' button<br>"
				+ "Enter the name of the notebook and click on create<br>"
				+ "After selecting a book the first page of it will appear on both the sides<br>"
				+ "Click on top right button to delete book (can't be undone)<br>");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(0, 460, 986, 193);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("SCROLLING THROUGH AND DELETING PAGES");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(30, 11, 359, 19);
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_5.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setText("<html>You can scroll through the pages using the previous page and next page button present at the bottom<br>"
				+ "You can directly move to a page by entering the deisred page number<br>"
				+ "Note that both these actions can be done from both the sides and act independantly<br>"
				+ "Deletion of pages can be done in 3 ways<br>"
				+ "a)    Using the deletion page button on the bottom which will delete the page currently opened<br>"
				+ "b)    Using the delete all (DLA) button (top right) - delete all pages except for the first one<br>"
				+ "c)    Using the delete selected (DLS) button (top right) - All the pages in the input range will be deleted (inclusive) of the range<br>"
				+ "Note that all three of these can't be undone but you will get a confirmation before deleting one");
		lblNewLabel_5.setBounds(28, 32, 948, 151);
		panel_4.add(lblNewLabel_5);
		this.setVisible(true);
		
	    
		
	}
}
