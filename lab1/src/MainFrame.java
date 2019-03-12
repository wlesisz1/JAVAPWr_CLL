import java.awt.EventQueue;
import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;


@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
	
	public MainFrame() {
		setUndecorated(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(d.width,d.height);
		setBackground(new Color(0,0,0,0));
		getContentPane().setLayout(null);		
		JButton btnNewButton = new JButton("Wcisnij");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(40,40,100,100);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random rand = new Random();
					btnNewButton.setLocation(rand.nextInt((getWidth() -  btnNewButton.getWidth() -10)), rand.nextInt(getHeight() - btnNewButton.getHeight() - 45));		
			}
		});
	}

	
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}		
	});
	
	
}

}