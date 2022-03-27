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
    private ImageIcon bIcon = new ImageIcon("person-writing-in-a-book.jpg");
    private JButton get_str_btn;
    
	public IntroPage() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("DIGIBOOK");
		this.setBounds(-7,0,1930,831);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.setVisible(true);
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
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==get_str_btn) {
			this.dispose();
			new NewNoteBookPage();
		}
	}
}