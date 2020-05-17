package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
/**
 * Klasa odpowiedzialna za wyświetlenie wykresu
 * @author Wojciech Buńka
 *
 */
public class wykres {
	private JDialog dialogObj;
	private final JPanel contentPanel = new JPanel();
	Object[][] data;
	JFrame frame;

	/**
	 * Przygotwuje potrzebne obiekty do utowrzeenia okna
	 * @param Table - Tablica z elementami do wyświetlenia
	 * @param frame - Obiekt JFrame okna według którego ma być wyświetlone
	 */
	public wykres(Object[][] Table,JFrame frame) {
		this.frame = frame;
		this.data = Table;
		this.dialogObj = new JDialog();
		setWindow();
		this.dialogObj.setVisible(true);
	}
	/**
	 * metoda Inicializuje okno
	 */
	public void setWindow()
	{
		
		dialogObj.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialogObj.setBounds(100, 100, 650, 500);
		dialogObj.setLocationRelativeTo(frame);
		dialogObj.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		dialogObj.getContentPane().add(contentPanel, BorderLayout.CENTER);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 329, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 38, Short.MAX_VALUE)
		);
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		
		double kolumnaLiczby = 0;
		String kolumnaText = null;

		for(int j = 0; j < 5; j++)
		{
			for(int i = 0; i < 5; i++)
			{
			
				kolumnaLiczby = kolumnaLiczby + Double.parseDouble(data[j][i].toString());
			}

			kolumnaText = "["+String.valueOf(j)+"]";
			dataset.setValue(kolumnaLiczby , kolumnaText, kolumnaText);
			kolumnaLiczby = 0;
		}

		
		JFreeChart chart = ChartFactory.createBarChart("Suma wierszy zawartych w komórkach tabeli",
				 "Oznaczenie", "Wartośc", dataset, PlotOrientation.VERTICAL, false, true, false);
		
		JPanel pane = new ChartPanel(chart);
		pane.setBounds(0, 0, 350, 350);
		dialogObj.getContentPane().add(pane);
		contentPanel.setLayout(gl_contentPanel);
	}

}
