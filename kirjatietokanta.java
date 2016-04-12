import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SpringLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Panel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.List;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import java.awt.Canvas;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.Font;
import java.awt.Color;
import java.awt.Choice;
import java.awt.Label;
import javax.swing.SwingConstants;

public class kirjaikkuna extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kirjaikkuna frame = new kirjaikkuna();
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
	public kirjaikkuna() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1176, 488);
		contentPane = new JPanel();
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(23, 224, 198, 23);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(23, 148, 198, 23);
		contentPane.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(23, 300, 198, 23);
		contentPane.add(textPane_2);
		
		JButton btnOk = new JButton("Lis\u00E4\u00E4");
		btnOk.setIcon(new ImageIcon(kirjaikkuna.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		btnOk.setToolTipText("Voit lis\u00E4t\u00E4 uuden kirjan tietokantaan painamalla nappia.");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnOk.setBackground(Color.BLACK);
		btnOk.setForeground(Color.WHITE);
		btnOk.setBounds(65, 350, 113, 23);
		contentPane.add(btnOk);
		
		TextArea textArea = new TextArea();
		textArea.setForeground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setBounds(272, 92, 252, 281);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Kirjan nimi:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Source Sans Pro", Font.PLAIN, 16));
		lblNewLabel.setBounds(23, 121, 111, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblJulkaisuvuosi = new JLabel("Julkaisuvuosi:");
		lblJulkaisuvuosi.setForeground(Color.WHITE);
		lblJulkaisuvuosi.setFont(new Font("Source Sans Pro", Font.PLAIN, 16));
		lblJulkaisuvuosi.setBounds(23, 199, 155, 14);
		contentPane.add(lblJulkaisuvuosi);
		
		JLabel lblTekijnNimi = new JLabel("Tekij\u00E4n nimi:");
		lblTekijnNimi.setForeground(Color.WHITE);
		lblTekijnNimi.setBackground(Color.WHITE);
		lblTekijnNimi.setFont(new Font("Source Sans Pro", Font.PLAIN, 16));
		lblTekijnNimi.setBounds(23, 275, 131, 14);
		contentPane.add(lblTekijnNimi);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(0, 0, 1614, 21);
		contentPane.add(menuBar);
		
		JMenu mnKirjasto = new JMenu("Kirjastotietokanta");
		mnKirjasto.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnKirjasto.setHorizontalAlignment(SwingConstants.TRAILING);
		mnKirjasto.setForeground(Color.WHITE);
		mnKirjasto.setBackground(Color.BLACK);
		menuBar.add(mnKirjasto);
		
		JMenuItem mntmOhjeet = new JMenuItem("Ohjeet");
		mntmOhjeet.setBackground(Color.WHITE);
		mnKirjasto.add(mntmOhjeet);
		
		JMenuItem mntmTiedot = new JMenuItem("Tiedot");
		mntmTiedot.setBackground(Color.WHITE);
		mnKirjasto.add(mntmTiedot);
		
		Choice choice = new Choice();
		choice.setBounds(23, 78, 56, 20);
		contentPane.add(choice);
		
		JLabel lblMontaKirjaListn = new JLabel("Monta kirjaa lis\u00E4t\u00E4\u00E4n?");
		lblMontaKirjaListn.setForeground(Color.WHITE);
		lblMontaKirjaListn.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblMontaKirjaListn.setBounds(23, 43, 213, 23);
		contentPane.add(lblMontaKirjaListn);
		
		JButton btnEtsi = new JButton("Etsi");
		btnEtsi.setIcon(new ImageIcon(kirjaikkuna.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		btnEtsi.setToolTipText("Etsi haluattuasi kirjaa t\u00E4ytt\u00E4m\u00E4ll\u00E4, joko kirjan nimi, julkaisuvuosi tai tekij\u00E4n nimi hakukentt\u00E4\u00E4n");
		btnEtsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEtsi.setForeground(Color.WHITE);
		btnEtsi.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnEtsi.setBackground(Color.BLACK);
		btnEtsi.setBounds(668, 350, 106, 23);
		contentPane.add(btnEtsi);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setForeground(Color.WHITE);
		textArea_1.setEditable(false);
		textArea_1.setBounds(868, 92, 252, 281);
		contentPane.add(textArea_1);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(619, 300, 198, 23);
		contentPane.add(textPane_3);
		
		JLabel label = new JLabel("Tekij\u00E4n nimi:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Source Sans Pro", Font.PLAIN, 16));
		label.setBackground(Color.WHITE);
		label.setBounds(619, 275, 131, 14);
		contentPane.add(label);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(619, 224, 198, 23);
		contentPane.add(textPane_4);
		
		JLabel label_1 = new JLabel("Julkaisuvuosi:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Source Sans Pro", Font.PLAIN, 16));
		label_1.setBounds(619, 199, 155, 14);
		contentPane.add(label_1);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(619, 148, 198, 23);
		contentPane.add(textPane_5);
		
		JLabel label_2 = new JLabel("Kirjan nimi:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Source Sans Pro", Font.PLAIN, 16));
		label_2.setBounds(619, 121, 111, 14);
		contentPane.add(label_2);
		
		JLabel lblMitKirjaaHaetaan = new JLabel("Mit\u00E4 kirjaa haetaan?");
		lblMitKirjaaHaetaan.setForeground(Color.WHITE);
		lblMitKirjaaHaetaan.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblMitKirjaaHaetaan.setBounds(619, 63, 213, 23);
		contentPane.add(lblMitKirjaaHaetaan);
		
		JLabel lblLydetytKirjat = new JLabel("L\u00F6ydetyt kirjat");
		lblLydetytKirjat.setForeground(Color.WHITE);
		lblLydetytKirjat.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblLydetytKirjat.setBounds(868, 63, 213, 23);
		contentPane.add(lblLydetytKirjat);
		
		JButton btnMuokkaa = new JButton("Muokkaa");
		btnMuokkaa.setIcon(new ImageIcon(kirjaikkuna.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		btnMuokkaa.setToolTipText("Voit muokata kirjan tietoja painamalla t\u00E4st\u00E4.");
		btnMuokkaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMuokkaa.setForeground(Color.WHITE);
		btnMuokkaa.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnMuokkaa.setBackground(Color.BLACK);
		btnMuokkaa.setBounds(868, 387, 129, 23);
		contentPane.add(btnMuokkaa);
		
		JButton btnPoista = new JButton("Poista");
		btnPoista.setIcon(new ImageIcon(kirjaikkuna.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/backspace-icon.png")));
		btnPoista.setToolTipText("Voit poistaa halutun kirjan painamalla t\u00E4t\u00E4");
		btnPoista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPoista.setForeground(Color.WHITE);
		btnPoista.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnPoista.setBackground(Color.BLACK);
		btnPoista.setBounds(1007, 387, 113, 23);
		contentPane.add(btnPoista);
		
		JLabel lblListytKirjat = new JLabel("Lis\u00E4tyt kirjat");
		lblListytKirjat.setForeground(Color.WHITE);
		lblListytKirjat.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblListytKirjat.setBounds(272, 63, 213, 23);
		contentPane.add(lblListytKirjat);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
