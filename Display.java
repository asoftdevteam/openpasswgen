import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Display extends JFrame {
	
	JTextField pwdtf = new JTextField(15);
	JTextField pwdlbl = new JTextField(15);
	JTextField pwdalph = new JTextField(15);
	JButton genbtn = new JButton("Generate");
	JLabel lbl = new JLabel("Enter number of symbols:");
	JLabel lblal = new JLabel("Enter alphabet:");
	
	public Display(String s) {
		super(s);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		GridLayout layout = new GridLayout(3, 2, 1, 1);
		setLayout(layout);
		add(lbl);
		add(pwdtf);
		add(lblal);
		add(pwdalph);
		add(pwdlbl);
		add(genbtn);
        
		pwdlbl.setText("Password");
		pwdalph.setText("1234567890qwertyuiopasdfghjklzxcvbnm!?&%QWERTYUIOPASDFGHJKLZXCVBNM");
		ActionListener actionListener = new List();
        
		genbtn.addActionListener(actionListener);
		
	}
	public class List implements ActionListener {
		public void actionPerformed(ActionEvent e) {
            String pwd = "";
            Random r = new Random();
            String alphabet = pwdalph.getText();
			try {
            	int i = Integer.parseInt(pwdtf.getText());
            	for(int j = 0; j != i; j++) {
            		pwd = pwd + alphabet.charAt(r.nextInt(alphabet.length()));
            	}
            	pwdlbl.setText(pwd);
            }catch (NumberFormatException nfe)
            {
            	JOptionPane.showMessageDialog(null, "NumberFormatException\n" + nfe + "\n\nEnter integer number!");
              }
        }
	}
}
