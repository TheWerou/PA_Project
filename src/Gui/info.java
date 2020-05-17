package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
/**
 * Klasa odpowiedzialna za przygotowanie i wyświetlenie okna dialogu z informacjami
 * @author Wojciech Buńka
 *
 */
public class info {

	private final JPanel contentPanel = new JPanel();
	JDialog dialog; 
	private JFrame frame;
	/**
	 * Konstruktor dba o poprawne złożenie okna 
	 * @param frame JFrame - Obiekt okna do którego ma być okno z tej klasy przyczepione
	 */
	public info(JFrame frame) 
	{
		this.frame = frame;
		dialog = new JDialog();
		startWindow();
		dialog.setVisible(true);
	}
	/**
	 * Metoda która odpowiednio przygotowuje okno do wyświetlenia
	 */
	private void startWindow()
	{
		
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setTitle("Info");
		dialog.setBounds(100, 100, 500, 320);
		dialog.setLocationRelativeTo(frame);
		dialog.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		dialog.getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Wykonane przez:");
		
		JLabel lblNewLabel_1 = new JLabel("Wojciech Buńka");
		
		JLabel lblNewLabel_2 = new JLabel("Politechnika Koszalińska");
		
		JLabel lblNewLabel_3 = new JLabel("2019/2020");
		
		JButton btnNewButton = new JButton("Powrót");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dialog.dispose();
		
			}
		});
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(56)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_1))
					.addContainerGap(113, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(205, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(194))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(74)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		
	}
}
