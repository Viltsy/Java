import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JFormattedTextField;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JToolBar;
import java.awt.Button;
import java.awt.Color;

import javax.swing.JTabbedPane;

public class testi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testi frame = new testi();
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
	public testi() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 465);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(33, 73, 638, 315);
		contentPane.add(editorPane);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Valikko");
		menuBar.add(mnNewMenu);
		

		
		JMenuItem mntmNewMenuItem = new JMenuItem("Avaa tiedosto");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				String rivi = "";
				
				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.showOpenDialog(null);
				String uusitiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();
				
				
				//File tiedosto = new File("src//gradu.txt");
				
				try {	
				Scanner lukija = null;
				File tiedosto = new File(uusitiedosto);
				lukija = new Scanner(tiedosto);

				while (lukija.hasNextLine()) {

				rivi += lukija.nextLine() + "\n";
	
				System.out.println(rivi);
				

				}

				}

				catch (FileNotFoundException f) {

				System.out.println("Tiedostoa ei löydy..");

				}
			     editorPane.setText(rivi);
			}
		});

		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmTallenna = new JMenuItem("Tallenna");
		mntmTallenna.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			
				
			JFileChooser valintaikkuna = new JFileChooser();
			valintaikkuna.showSaveDialog(null);
			String uusitiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();
					
			try {
			
			PrintWriter writer = new PrintWriter(uusitiedosto);
				
			String kirjoita	= editorPane.getText() + "\n";
			writer.println(kirjoita);
			
			writer.flush();
			writer.close();
				
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("Tiedoston tallennuksessa tapahtui virhe!");
				e1.printStackTrace();
			}	
				
			}
		});
		mnNewMenu.add(mntmTallenna);
		
		JMenuItem mntmEtsi = new JMenuItem("Etsi");
		mntmEtsi.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			
				
		   String haettava = JOptionPane.showInputDialog(null, null, "Anna haettava", 2);
				
			String sisältö = editorPane.getText();	
			sisältö = sisältö.toLowerCase();
			int luku = sisältö.indexOf(haettava);
			
			editorPane.setSelectionColor(Color.green);
			editorPane.setSelectedTextColor(Color.white);
			editorPane.setSelectionStart(luku);
			editorPane.setSelectionEnd(luku + haettava.length());
				
			}
		});
		mnNewMenu.add(mntmEtsi);
		
		JMenuItem mntmMuokkaa = new JMenuItem("Muokkaa");
		mntmMuokkaa.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

			}
		});
		mnNewMenu.add(mntmMuokkaa);
		
	}
}
