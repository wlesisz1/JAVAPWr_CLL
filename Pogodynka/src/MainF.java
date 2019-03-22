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
import org.json.*;

public class MainF extends JFrame{
	private JTextField wpiszdane;
	private JTextField wpisz2;
	public MainF() {
		DefaultListModel listModel = new DefaultListModel();
		JList list = new JList(listModel);
		setBounds(20, 20, 800, 250);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		listModel.addElement("Wpisz liczbe lub tytu³ filmu w pierwszym polu! (np. The Shining)");
		listModel.addElement("W drugim polu wpisz co chcesz siê dowiedzieæ! (np. Genre)");
		
		JButton load = new JButton("Pobierz dane");
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deci=(wpiszdane.getText());
				if (deci.matches("[0-9]+") && deci.length() > 0) {
					 String s = "http://numbersapi.com/"+deci+"/?xml";
		
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
					
						String s = "http://www.omdbapi.com/?t=";
								 try {
									s += URLEncoder.encode(deci, "UTF-8");
								} catch (UnsupportedEncodingException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								 s += "&apikey=8877feec";
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
					    JSONObject obj = new JSONObject(str);
					
						listModel.addElement(obj.getString(wpisz2.getText()));
					
					
				}
			
			
			}
		});
		
		JButton clear = new JButton("Wyczyœæ");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.clear();
			}
		});
		
		wpiszdane = new JTextField();
		wpiszdane.setColumns(10);
		
		wpisz2 = new JTextField();
		wpisz2.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(list, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(wpiszdane, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(wpisz2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
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
						.addComponent(load)
						.addComponent(wpisz2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(31, Short.MAX_VALUE))
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