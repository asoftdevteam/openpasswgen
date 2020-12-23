import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import java.util.Random;

public class Display extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -118707512687693000L;
	JTextField pwdtf = new JTextField(15);
	JTextField pwdlbl = new JTextField(15);
	JLabel pwdlbl2 = new JLabel("Generated password:");
	JTextField pwdalph = new JTextField(15);
	JButton genbtn = new JButton("Generate");
	JButton cpbtn = new JButton("Copy");
	JLabel lbl = new JLabel("Enter number of symbols:");
	JLabel lblal = new JLabel("Enter custom alphabet:");
	JRadioButton numrb = new JRadioButton("Numbers alphabet");
	JRadioButton defrb = new JRadioButton("Letters&numbers alphabet");
	JRadioButton extrb = new JRadioButton("Extended alphabet");
	ButtonGroup group = new ButtonGroup();
	JPanel emptpane = new JPanel();
	
	public Display(String s) {
		super(s);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		GridLayout layout = new GridLayout(4, 3, 1, 1);
		setLayout(layout);
		group.add(numrb);
		group.add(defrb);
		group.add(extrb);
		add(lbl);
		add(pwdtf);
		add(numrb);
		add(lblal);
		add(pwdalph);
		add(defrb);
		add(pwdlbl2);
		add(pwdlbl);
		add(extrb);
		add(emptpane);
		add(cpbtn);
		add(genbtn);
		pwdlbl.setText("Password");
		
		ActionListener actionListener = new List();
		genbtn.addActionListener(actionListener);
		cpbtn.addActionListener(actionListener);
	}
	public class List implements ActionListener {
		public void actionPerformed(ActionEvent e) {
            if(e.getSource() == genbtn) {
            	if(numrb.isSelected()) {
            		pwdalph.setText("1234567890");
            	}else if(defrb.isSelected()) {
            		pwdalph.setText("1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM");
            	}else if(extrb.isSelected()) {
            		pwdalph.setText("1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM?!@#$%^&*<>.,");
            	}
            	String pwd = "";
            	Random r = new Random();
            	String alphabet = pwdalph.getText();
				try {
            		int i = Integer.parseInt(pwdtf.getText());
            		for(int j = 0; j != i; j++) {
            			pwd = pwd + alphabet.charAt(r.nextInt(alphabet.length()));
            		}
            		pwdlbl.setText(pwd);
            	}catch (NumberFormatException nfe){
            		JOptionPane.showMessageDialog(null, "NumberFormatException\n" + nfe + "\n\nEnter integer number!");
            	}catch (IllegalArgumentException iae){
            		JOptionPane.showMessageDialog(null, "IllegalArgumentException\n" + iae + "\n\nEnter password alphabet or select pattern!");
            	}
            }
            if(e.getSource() == cpbtn) {
            	String get = pwdlbl.getText();
            	StringSelection selec= new StringSelection(get);
            	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            	clipboard.setContents(selec, null);
            }
        }
	}
}
