import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;
import javax.xml.validation.Validator;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.net.Inet4Address;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class TypeSelectionPage extends JFrame implements ActionListener {
    //main content pane 
	private JPanel contentPane;
	
	//all icons
    private ImageIcon noteBookIcon = new ImageIcon(new ImageIcon("icons8-book-50.png").getImage().getScaledInstance(100,100,100));
    private ImageIcon passWordIcon = new ImageIcon(new ImageIcon("icons8-password-50.png").getImage().getScaledInstance(100,100,100));
    private ImageIcon DiaryIcon = new ImageIcon(new ImageIcon("icons8-calendar-12-50.png").getImage().getScaledInstance(100,100,100));
    private JButton book_btn;
    
    //the main file location string
    static String file_Location;
    private JButton select_file_btn;
    
	public TypeSelectionPage() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(-7,0,1930,831);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setContentPane(contentPane);
		this.setVisible(true);
		this.setResizable(false);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setLayout(null);
		
		JPanel options_pane = new JPanel();
		options_pane.setBackground(Color.WHITE);
		options_pane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		options_pane.setBounds(0, 79, 1540, 715);
		contentPane.add(options_pane);
		options_pane.setLayout(null);
		
		book_btn = new JButton("Notebooks");
		book_btn.setIconTextGap(15);
		book_btn.setFocusable(false);
		book_btn.setBackground(Color.WHITE);
		book_btn.setIcon(noteBookIcon);
		book_btn.setHorizontalTextPosition(JButton.CENTER);
		book_btn.setVerticalTextPosition(JButton.BOTTOM);
		book_btn.setFont(new Font("Tahoma", Font.BOLD, 20));
		book_btn.setBounds(0, 0, 893, 455);
		book_btn.addActionListener(this);
		options_pane.add(book_btn);
		
		JButton pass_btn = new JButton("Password saver");
		pass_btn.setFont(new Font("Tahoma", Font.BOLD, 20));
		pass_btn.setIcon(passWordIcon);
		pass_btn.setFocusable(false);
		pass_btn.setVerticalTextPosition(JButton.BOTTOM);
		pass_btn.setHorizontalTextPosition(JButton.CENTER);
		pass_btn.setIconTextGap(15);
		pass_btn.setBackground(Color.WHITE);
		pass_btn.setBounds(893, 0, 647, 284);
		options_pane.add(pass_btn);
		
		JButton diary_btn = new JButton("Diary");
		diary_btn.setIconTextGap(15);
		diary_btn.setIcon(DiaryIcon);
		diary_btn.setFocusable(false);
		diary_btn.setVerticalTextPosition(JButton.BOTTOM);
		diary_btn.setHorizontalTextPosition(JButton.CENTER);
		diary_btn.setBackground(Color.WHITE);
		diary_btn.setFont(new Font("Tahoma", Font.BOLD, 20));
		diary_btn.setBounds(0, 455, 893, 260);
		options_pane.add(diary_btn);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(893, 284, 647, 431);
        options_pane.add(btnNewButton_3);
        
        JPanel save_panel = new JPanel();
        save_panel.setBackground(Color.DARK_GRAY);
        save_panel.setBorder(null);
        save_panel.setBounds(0, 0, 1540, 79);
        contentPane.add(save_panel);
        save_panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Where do you want to save all your data : ");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel.setBounds(10, 10, 237, 23);
        save_panel.add(lblNewLabel);
        
        select_file_btn = new JButton("Select file");
        select_file_btn.setFont(new Font("Tahoma", Font.PLAIN, 11));
        select_file_btn.setBackground(new Color(192, 192, 192));
        select_file_btn.setFocusable(false);
        select_file_btn.setBounds(257, 11, 85, 22);
        select_file_btn.addActionListener(this);
        save_panel.add(select_file_btn);
        
        JLabel note_lbl = new JLabel("Note : Do not delete any data from the selected file");
        note_lbl.setForeground(Color.WHITE);
        note_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
        note_lbl.setBounds(10, 43, 347, 23);
        save_panel.add(note_lbl);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==select_file_btn) {
			File mainFile = new File("C:\\DIGIBOOK");
			mainFile.mkdir();
			File userInfo = new File("C:\\DIGIBOOK\\User_Info.txt");
			try {
				userInfo.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(e.getSource()==book_btn) {
			this.dispose();
			new NewNoteBookPage();
		}
		
	}
}
