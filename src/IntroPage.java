import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;
import javax.xml.validation.Validator;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.net.Inet4Address;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Dimension;

public class IntroPage extends JFrame implements ActionListener {

	private JPanel contentPane;
    private ImageIcon a = new ImageIcon("plus.png"); 
    private ImageIcon bIcon = new ImageIcon("person-writing-in-a-book.jpg");
    private ImageIcon pencilIcon = new ImageIcon(new ImageIcon("Editing-Pencil-Icon.png").getImage().getScaledInstance(10,10,2000)); 
    private JTextField textField;
    private JTextField id_tf;
    private JTextField pass_tf;
    private JTextField username_tf;
    private JTextField password_tf;
    private JButton get_str_btn;
    private JButton signup_btn;
    
	public IntroPage() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(-7,0,1930,831);
		contentPane = new JPanel();
		//contentPane.setPreferredSize(new Dimension(1950, 10));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.setIconImage(a.getImage());
		this.setVisible(true);
		//this.setResizable(false);;
		contentPane.setBackground(Color.YELLOW);
		contentPane.setLayout(null);
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1540, 794);
		getContentPane().add(layeredPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(0, 0, 1540, 794);
		lblNewLabel.setIcon(bIcon);
		layeredPane.add(lblNewLabel,Integer.valueOf(0));
		
		JLabel getDig_lbl = new JLabel("<html>Get<br>Digitalized</html>");
		getDig_lbl.setForeground(Color.DARK_GRAY);
		getDig_lbl.setFont(new Font("Segoe UI Historic", Font.PLAIN, 76));
		getDig_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		getDig_lbl.setBounds(84, 26, 464, 312);
		layeredPane.add(getDig_lbl,Integer.valueOf(1));
		/*
		String[] theme = {"Change Theme"};
		JComboBox comboBox = new JComboBox(theme);
		comboBox.setBounds(1170, 10, 106, 28);
		layeredPane.add(comboBox,Integer.valueOf(1));
		
		id_tf = new JTextField();
		id_tf.setHorizontalAlignment(SwingConstants.CENTER);
		id_tf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		id_tf.setBorder(null);
		id_tf.setBounds(0, 389, 162, 34);
		layeredPane.add(id_tf,Integer.valueOf(1));
		id_tf.setColumns(10);
		
		pass_tf = new JTextField();
		pass_tf.setHorizontalAlignment(SwingConstants.CENTER);
		pass_tf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pass_tf.setBorder(null);
		pass_tf.setBounds(10, 451, 162, 34);
		layeredPane.add(pass_tf,Integer.valueOf(1));
		pass_tf.setColumns(10);
		
		JLabel pass_lbl = new JLabel("Password");
		pass_lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pass_lbl.setBounds(0, 419, 79, 22);
		layeredPane.add(pass_lbl,Integer.valueOf(1));
		
		JLabel Id_lbl = new JLabel("Id");
		Id_lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Id_lbl.setBounds(0, 375, 79, 22);
		layeredPane.add(Id_lbl,Integer.valueOf(1));
		
		JLabel div_lbl = new JLabel("..............................Sign up..............................");
		div_lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		div_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		div_lbl.setBounds(0, 495, 306, 16);
		layeredPane.add(div_lbl,Integer.valueOf(1));
		
		JLabel username_lbl = new JLabel("Select a username");
		username_lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		username_lbl.setBounds(0, 523, 135, 16);
		layeredPane.add(username_lbl,Integer.valueOf(1));
		
		username_tf = new JTextField();
		username_tf.setHorizontalAlignment(SwingConstants.CENTER);
		username_tf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		username_tf.setBorder(new EmptyBorder(0, 0, 0, 0));
		username_tf.setBounds(0, 549, 162, 34);
		layeredPane.add(username_tf,Integer.valueOf(1));
		username_tf.setColumns(10);
		
		JLabel password_lbl = new JLabel("Select a strong password");
		password_lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		password_lbl.setBounds(0, 593, 162, 16);
		layeredPane.add(password_lbl,Integer.valueOf(1));
		
		password_tf = new JTextField();
		password_tf.setHorizontalAlignment(SwingConstants.CENTER);
		password_tf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		password_tf.setBorder(new EmptyBorder(0, 0, 0, 0));
		password_tf.setBounds(10, 619, 162, 34);
		layeredPane.add(password_tf,Integer.valueOf(1));
		password_tf.setColumns(10);
		
		signup_btn = new JButton("Sign up");
		signup_btn.setFocusable(false);
		signup_btn.setFocusTraversalKeysEnabled(false);
		signup_btn.setFocusPainted(false);
		signup_btn.setBackground(Color.WHITE);
		signup_btn.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		signup_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		signup_btn.setBounds(10, 663, 66, 28);
		signup_btn.addActionListener(this);
		layeredPane.add(signup_btn,Integer.valueOf(1));
		*/
		
		get_str_btn = new JButton();
		get_str_btn.setText("Click here to begin");
		get_str_btn.setForeground(Color.BLACK);
		get_str_btn.setFocusable(false);
		get_str_btn.setOpaque(true);
		get_str_btn.setBackground(new Color(233,216,206));
		get_str_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		get_str_btn.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		get_str_btn.setBounds(163, 530, 253, 69);
		get_str_btn.addActionListener(this);
		layeredPane.add(get_str_btn,Integer.valueOf(1));
		
		/*
		JLabel lblNewLabel_1 = new JLabel(".................................................................................");
		lblNewLabel_1.setBounds(127, 629, 246, 13);
		layeredPane.add(lblNewLabel_1,Integer.valueOf(1));
		*/
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==get_str_btn) {
			this.dispose();
			new NewNoteBookPage();
		}
	}
}