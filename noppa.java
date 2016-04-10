
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Window.Type;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import java.awt.Color;
import javax.swing.JTextArea;

@SuppressWarnings("unused")
public class noppa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					noppa frame = new noppa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public noppa() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Noppien Summan Arvaaminen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 271);
		setLocationRelativeTo(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Valikko");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmOhjeet = new JMenuItem("Ohjeet");
		mntmOhjeet.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			JOptionPane.showMessageDialog (null, "Nopat ovat 1-6 olevia perus noppia. \n"
					+ "Kirjoita arvauksesi eli noppien summa siihen varattuun teksti kentt‰‰n. \n"
					+ "Aloittaaksesi paina arvaa n‰pp‰int‰.\n"
					+ "Voit halutessasi muuttaa arvaamaasi summaa ja painaa arvaa n‰pp‰int‰ uudelleen aloittaaksesi pelin alusta.", "Ohjeet", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu.add(mntmOhjeet);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		textField = new JTextField();
		textField.setBounds(145, 192, 28, 23);
		contentPane.add(textField);
		textField.setColumns(10);
			
	
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(70, 27, 169, 154);
		contentPane.add(textArea);	JButton btnNewButton = new JButton("Arvaa");
		btnNewButton.addMouseListener(new MouseAdapter() {
		public void mousePressed(MouseEvent arg0) {
	
		String arvaus = textField.getText();

		if (arvaus.length() == 0) {
		JOptionPane.showMessageDialog(null, "Et antanut arvaustasi... \nvoit antaa sen kirjoittamalla sen kirjoituskentt‰‰n.", "Virhe", JOptionPane.ERROR_MESSAGE);
			} else {
				
		textArea.setText("Arvaamasi summa: "+ arvaus + "\n");
			
		int noppaluku1, noppaluku2;

		noppaluku1 = (int) Math.floor(Math.random() * 6 + 1);
		noppaluku2 = (int) Math.floor(Math.random() * 6 + 1);

		int summa = (noppaluku1 + noppaluku2);

		textArea.append("\nNoppa 1: " + noppaluku1  + "\n" + "Noppa 2: " + noppaluku2 + "\n");
		textArea.append("Noppien summa: " + summa + "\n");

		if (Integer.valueOf(arvaus) == summa) {
			textArea.append("\nArvasit oikein!" + "\n");
		} else {
			textArea.append("\nArvauksesi ei ollut oikein." + "\n");
		}
			}

			}
		});
		btnNewButton.setBounds(190, 192, 89, 23);
		contentPane.add(btnNewButton);
		JLabel lblNewLabel = new JLabel("Arvaa noppien summa:");
		lblNewLabel.setBounds(8, 196, 181, 14);
		contentPane.add(lblNewLabel);
	}
}
