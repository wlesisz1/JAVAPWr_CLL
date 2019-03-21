import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;


public class MainF extends JFrame{
	private JTextField wpiszdane;
	public MainF() {
		DefaultListModel listModel = new DefaultListModel();
		JList list = new JList(listModel);
		setBounds(20, 20, 800, 250);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);

		JButton load = new JButton("Pobierz dane");
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deci=(wpiszdane.getText());
				if (deci.matches("[0-9]+") && deci.length() > 0) {
					 String s = "http://numbersapi.com/"+deci+"/?xml";
					 try {
						s += URLEncoder.encode(deci, "UTF-8");
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 URL url = null;
					try {
						url = new URL(s);
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 Scanner scan = null;
					try {
						scan = new Scanner(url.openStream());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					    String str = new String();
					    while (scan.hasNext())
					        str += scan.nextLine();
					    scan.close();
					    
					 
					 
					
					listModel.addElement(str);
				}
				else {
					

						listModel.addElement("To nie jest liczba!");
					
				}
			
			
			}
		});
		
		JButton clear = new JButton("Wyczysc");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.clear();
			}
		});
		
		wpiszdane = new JTextField();
		wpiszdane.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(list, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(wpiszdane, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(load)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(clear)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(clear)
						.addComponent(wpiszdane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(load))
					.addContainerGap(81, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}

public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				MainF frame = new MainF();
				frame.setVisible(true);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}		
	});
	
	
}}