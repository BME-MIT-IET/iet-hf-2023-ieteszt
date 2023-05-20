import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A nyer�s k�perny� kirat�sa
 */
public class WinFrame extends JFrame{
	/**
	 * A rajta l�v� gomb, amivel be lehet z�rni az eg�szet
	 */
	JButton ok = new JButton("OK");
	/**
	 * Egy label ami a JFramen van
	 */
	JLabel l= new JLabel("");
	/**
	 * A konstruktora l�trehozza az ablakot
	 */
	public WinFrame()
	{
		this.setSize(200,200);
        this.setLocationRelativeTo(null); 
		ImageIcon winp= new ImageIcon("./Pictures/WinFrame.png");
		this.setTitle("You won!");
		l.setIcon(winp);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ok.setBounds(80, 90, 40, 40);
		ok.addActionListener(e -> System.exit(0));
		JPanel panel = new JPanel();
		panel.add(ok, BorderLayout.CENTER);
		this.add(panel, BorderLayout.SOUTH);
		JPanel panelCenter = new JPanel();
		panelCenter.add(l, BorderLayout.SOUTH);
		this.add(panelCenter, BorderLayout.CENTER);
		this.setVisible(true);
	}
}


