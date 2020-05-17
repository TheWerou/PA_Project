package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.freixas.jcalendar.JCalendarCombo;
import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXHyperlink;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;

import com.l2fprod.common.swing.JTipOfTheDay;
import com.l2fprod.common.swing.tips.DefaultTip;
import com.l2fprod.common.swing.tips.DefaultTipModel;

import Logic.ProgramFacade;

/**
 * Główna klasa GUI odpowiada za wyświetlenie głównego menu
 * @author Wojciech Buńka
 *
 */
public class MainWindow  {
	
	/**
	 * Obiekt Facady służacej do przetrzymywania oraz modyfikowania danych
	 */
	public ProgramFacade logic;
	/**
	 * Obiekt głowny wyświelanego okna
	 */
	private JFrame mainFrame;
	/**
	 * Obiekty kontenerów które ustawiaja w odpowiednim miejscu pozstale obiekty
	 */
	private JPanel contentPane, panel,panel_1,panel_2,panel_3,panel_4, panel_5;
	/**
	 * Obiekt tablicy w ktorej znajduja sie dane uzytkownika
	 */
	private JTable table;
	
	/**
	 * Obiekty przycisków list, służacych do komunikacji z użytkownikiem
	 */
	private JList<String> list;
	private JMenuItem mntmNewMenuItem, mntmNewMenuItem_1, mntmNewMenuItem_2 , mntmNewMenuItem_3, mntmNewMenuItem_4, mntmNewMenuItem_5, mntmNewMenuItem_6, mntmNewMenuItem_7, mntmNewMenuItem_8,mntmNewMenuItem_9; 
	private JButton btnNewButton, btnNewButton_1, btnNewButton_12, btnNewButton_3, btnNewButton_9, btnNewButton_2, btnNewButton_10, btnNewButton_8,btnNewButton_5,btnNewButton_4,btnNewButton_6,btnNewButton_7,btnNewButton_11,btnNewButton_13,btnNewButton_14; 
	private JTextArea txtrCos;
	private JSlider slider,slider_1;
	private JTextField txtDada;
	/**
	 * Objekty służace do wyświetlania bocznego menu zadań
	 */
	private JXHyperlink taskAut, taskKalk, taskSuma, taskSred, taskMin, taskMax, taskDodaj, taskZeruj, taskZapisz, taskWykres,taskZakoncz;
	private JXTaskPaneContainer paneMain;
	private JXTaskPane pane1,pane2,pane3,pane4;
	private JToolBar toolBar;
	private Icon icon_autor,icon_zakoncz,icon_wykres,icon_suma,icon_srednia,icon_min,icon_max,icon_dodaj,icon_zeruj,icon_zapisz;
	private Icon icon_16_autor,icon_16_zakoncz,icon_16_wykres,icon_16_suma,icon_16_srednia,icon_16_min,icon_16_max,icon_16_dodaj,icon_16_zeruj,icon_16_zapisz;
	
	/**
	 * Obiekt kalendarza
	 */
	private JCalendarCombo kalendarz;
	
	
	String[] tableNames = {"1", "2", "3", "4", "5"};
	Object[][] data = {
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
	};

	

	/**
	 * Konstruktor klasy wywoluje metode tworzace okno z poradami a nastempnie tworzy i wypelnia główne okno
	 * @param logic Obiekt klasy ProgramFacade umożliwiajacy zapisanie odczytanie danych potrzebnych dla działania klasy 
	 * oraz umożliwia tworzenie logów z programu
	 * 
	 */
	public MainWindow(ProgramFacade logic) 
	{
		this.mainFrame = new JFrame(); 
		mainFrame.setTitle("Projekt PA");
		this.logic = logic;
		showTip();
		createWindow();
		
	}
	/**
	 *  Metoda tworzy Pasek menu oraz kalendarz który się na nim znajduje
	 */
	private void createMenuBar()
	{
		
		JMenuBar menuBar = new JMenuBar();
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			this.mntmNewMenuItem = new JMenuItem("Autor",this.icon_16_autor);
			mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			JSeparator separator_1 = new JSeparator();
			this.mntmNewMenuItem_9 = new JMenuItem("Zakończ",this.icon_16_zakoncz);
		JMenu mnNewMenu_1 = new JMenu("Edytuj");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			this.mntmNewMenuItem_1 = new JMenuItem("Dodaj",this.icon_16_dodaj);
			this.mntmNewMenuItem_2 = new JMenuItem("Zapisz",this.icon_16_zapisz);
			this.mntmNewMenuItem_3 = new JMenuItem("Zeruj",this.icon_16_zeruj);
			this.mntmNewMenuItem_8 = new JMenuItem("Wykres",this.icon_16_wykres);
		JMenu mnNewMenu_2 = new JMenu("Oblicz");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			this.mntmNewMenuItem_4 = new JMenuItem("Suma",this.icon_16_suma);
			this.mntmNewMenuItem_5 = new JMenuItem("Średnia",this.icon_16_srednia);
			this.mntmNewMenuItem_6 = new JMenuItem("Min",this.icon_16_min);
			this.mntmNewMenuItem_7 = new JMenuItem("Max",this.icon_16_max);
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
			this.kalendarz = new JCalendarCombo();
		
		this.mainFrame.setJMenuBar(menuBar);
		menuBar.add(mnNewMenu);
			mnNewMenu.add(mntmNewMenuItem);
			mnNewMenu.add(separator_1);
			mnNewMenu.add(mntmNewMenuItem_9);
		menuBar.add(mnNewMenu_1);
			mnNewMenu_1.add(mntmNewMenuItem_1);
			mnNewMenu_1.add(mntmNewMenuItem_2);
			mnNewMenu_1.add(mntmNewMenuItem_3);
			mnNewMenu_1.add(mntmNewMenuItem_8);
		menuBar.add(mnNewMenu_2);
			mnNewMenu_2.add(mntmNewMenuItem_4);
			mnNewMenu_2.add(mntmNewMenuItem_5);
			mnNewMenu_2.add(mntmNewMenuItem_6);
			mnNewMenu_2.add(mntmNewMenuItem_7);
		menuBar.add(separator);	
		menuBar.add(kalendarz);	
		
			this.kalendarz.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
			this.kalendarz.setBounds(525, 278, 122, 23);
			
	}
	/**
	 *  Metoda tworzy pasek z narzedziami
	 */
	private void createToolBar()
	{
		
		this.toolBar = new JToolBar();
			this.btnNewButton = this.createButton("Dodaj liczba do tabeli", this.icon_dodaj);
			this.btnNewButton_1 = this.createButton("Zapisz liste do pliku", this.icon_zapisz); //new JButton("Zapisz");
			this.btnNewButton_12 = this.createButton("Zeruj tablice", this.icon_zeruj);
			this.btnNewButton_13 = this.createButton("Pokaż wykres", this.icon_wykres);
		JSeparator separator = new JSeparator();
			this.btnNewButton_3 = this.createButton("Oblicz sume z elementów tabeli", this.icon_suma);
			this.btnNewButton_9 = this.createButton("Oblicz średnią elementów tabeli", this.icon_srednia); 
			this.btnNewButton_2 = this.createButton("Oblicz minimum elementów tabeli", this.icon_min);
			this.btnNewButton_10 =this.createButton("Oblicz maksimum elementów tabeli", this.icon_max);  
		JSeparator separator_1 = new JSeparator();
			this.btnNewButton_7 = this.createButton("Pokaż informacje o autorze", this.icon_autor);  
			this.btnNewButton_14 = this.createButton("Zakoncz program", this.icon_zakoncz);  
				
		toolBar.setFloatable(false);
		toolBar.setEnabled(false);
		toolBar.setRollover(true);
		separator.setBackground(UIManager.getColor("Button.background"));
		separator.setForeground(SystemColor.menu);
		separator_1.setForeground(UIManager.getColor("Button.background"));
		separator_1.setBackground(UIManager.getColor("Button.background"));

		toolBar.add(btnNewButton);
		toolBar.add(btnNewButton_1);
		toolBar.add(btnNewButton_12);
		toolBar.add(btnNewButton_13);
		toolBar.add(separator);
		toolBar.add(btnNewButton_3);
		toolBar.add(btnNewButton_9);
		toolBar.add(btnNewButton_2);
		toolBar.add(btnNewButton_10);
		toolBar.add(separator_1);
		toolBar.add(btnNewButton_7);
		toolBar.add(btnNewButton_14);
	}
	/**
	 * Metoda wypelnia głowny obszar okna
	 */
	private void menuThings()
	{
		
		this.table = new JTable(this.logic.storage.table_class.getTable_data(),tableNames);
		//this.table = new JTable(data,tableNames);
		this.txtrCos = new JTextArea();
		txtrCos.setWrapStyleWord(true);
		txtrCos.setEditable(false);
		txtrCos.setLineWrap(true);
		txtrCos.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtrCos.setAlignmentX(0.0f);
		txtrCos.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtrCos.setText(" Jak ci mija dzień ?");
		
		JLabel lblNewLabel_1 = new JLabel("Kolumna");
		this.slider_1 = new JSlider(1, 5, 3);
		JLabel lblNewLabel = new JLabel("Wiersz");
		this.slider = new JSlider(1, 5, 3);
		String[] listContent = {"Suma elementów", "Srednia elementów", "Min elementów", "Max elementów"};
		this.list = new JList(listContent);
		JLabel lblNewLabel_2 = new JLabel("Wpisz wartość");
		
		this.btnNewButton_8 = new JButton("Oblicz");
		this.btnNewButton_5 = new JButton("Dodaj");
		this.btnNewButton_4 = new JButton("Zapisz");
		this.btnNewButton_6 = new JButton("Zeruj");
		this.btnNewButton_11 = new JButton("Wykres");
		
		
		panel.add(btnNewButton_6);
		panel_3.add(lblNewLabel_1);
		panel_3.add(slider_1);
		panel_2.add(lblNewLabel);
		panel_2.add(slider);
		panel_1.add(btnNewButton_8);
		panel_1.add(list);
		panel.add(btnNewButton_5);
		panel.add(btnNewButton_4);
		panel.add(btnNewButton_11);
		
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		slider_1.setMajorTickSpacing(1);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		
		panel_5.add(lblNewLabel_2);
		txtDada = new JTextField();
		txtDada.setText("0");
		panel_5.add(txtDada);
		txtDada.setColumns(10);
		
	}
	/**
	 *  Metoda odpowiedzialna za utworzenie głownego okna w odpowiedniej kolejnosci tworzy pasek menu,pasek narzedzi
	 *  wypełnia głowna częśc.
	 */
	private void createWindow()
	{
		this.mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.mainFrame.setBounds(100, 100, 600, 680);
		this.mainFrame.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.mainFrame.setContentPane(contentPane);

		//====================================================================
	
		this.panel = new JPanel();
		this.panel_1 = new JPanel();
		this.panel_2 = new JPanel();
		this.panel_3 = new JPanel();
		this.panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		this.panel_4 = new JPanel();
		panel_4.setBackground(UIManager.getColor("Button.background"));
		
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		//====================================================================
		createIcons();
		createMenuBar();
		createToolBar();
		menuThings();
		CreateTaskMenu();
		
	
     // -------------------------------------------------------------------
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(table, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
								.addComponent(txtrCos, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtrCos)))
					.addGap(7))
		);
		this.logic.addInfoLog("Utworzono i pokazano głowne okno");
		contentPane.setLayout(gl_contentPane);
	}
	/**
	 *  Metoda tworzy boczny pasek zadan
	 */
	private void CreateTaskMenu()
	{
		this.paneMain = new JXTaskPaneContainer();
		paneMain.setBackground(UIManager.getColor("Button.background"));
		
        this.pane1 = new JXTaskPane();
        this.pane2 = new JXTaskPane();
        this.pane3 = new JXTaskPane();
        this.pane4 = new JXTaskPane();
        
        pane1.setTitle("Główny pasek");
        pane1.setCollapsed(false);
       
        pane2.setTitle("Oblicz narzędzia");
        pane2.setCollapsed(false);
        
        pane3.setTitle("Narzedzia do zarządzania");
        pane3.setCollapsed(false);
            
        paneMain.add(pane1);
	    	this.taskAut = createLinkClass("Autor");
	    	this.taskZakoncz = createLinkClass("Zakoncz program");
        paneMain.add(pane2);
	    	this.taskSuma = createLinkClass("Oblicz Sume");
	    	this.taskSred = createLinkClass("Oblicz Srednia");
	    	this.taskMin = createLinkClass("Wyznacz min");
	    	this.taskMax = createLinkClass("Wyznacz max");
        paneMain.add(pane3);
	    	this.taskDodaj = createLinkClass("Dodaj");
	    	this.taskZapisz = createLinkClass("Zapisz");
	    	this.taskZeruj = createLinkClass("Zeruj");
	    	this.taskWykres = createLinkClass("Wykres");
       
        pane1.add(taskAut, BorderLayout.NORTH);
	    pane1.add(taskZakoncz, BorderLayout.NORTH);
        
        pane2.add(taskSuma, BorderLayout.NORTH);
        pane2.add(taskSred, BorderLayout.NORTH);
	    pane2.add(taskMin, BorderLayout.NORTH);
        pane2.add(taskMax, BorderLayout.NORTH);
        
        pane3.add(taskDodaj, BorderLayout.NORTH);
        pane3.add(taskZapisz, BorderLayout.NORTH);
        pane3.add(taskZeruj, BorderLayout.NORTH);
        pane3.add(taskWykres, BorderLayout.NORTH);
	    
        this.panel_4.add(paneMain);
		
	}
	public void createIcons()
	{
		
  		this.icon_autor = createMyIcon("24/autor.png");
  		this.icon_zakoncz = createMyIcon("24/zakoncz.png");
  		this.icon_wykres = createMyIcon("24/wykres.png");
  		this.icon_suma = createMyIcon("24/suma.png");
  		this.icon_srednia = createMyIcon("24/srednia.png");
  		this.icon_min = createMyIcon("24/min.png");
  		this.icon_max = createMyIcon("24/max.png");
  		this.icon_dodaj = createMyIcon("24/dodaj.png");
  		this.icon_zeruj = createMyIcon("24/reset.png");
  		this.icon_zapisz = createMyIcon("24/zapisz.png");
  		
  		this.icon_16_autor = createMyIcon("16/autor.png");
  		this.icon_16_zakoncz = createMyIcon("16/zakoncz.png");
  		this.icon_16_wykres = createMyIcon("16/wykres.png");
  		this.icon_16_suma = createMyIcon("16/suma.png");
  		this.icon_16_srednia = createMyIcon("16/srednia.png");
  		this.icon_16_min = createMyIcon("16/min.png");
  		this.icon_16_max = createMyIcon("16/max.png");
  		this.icon_16_dodaj = createMyIcon("16/dodaj.png");
  		this.icon_16_zeruj = createMyIcon("16/reset.png");
  		this.icon_16_zapisz = createMyIcon("16/zapisz.png");
  		
	}
	/**
	 * Metoda tworzy i zwraca obiekt Icon
	 * @param file String - Sciezka do pliku z ikona
	 * @return Icon obiekt
	 */
	public Icon createMyIcon(String file) {
		if(file == null)
		{
			file = "";
		}
		else
		{
			file = "lib/icony/" + file;
		}
		Icon icon = new ImageIcon(file);
		return icon;
	}
	/**
	 * Metoda tworzy obiekty JXHyperlink służace za przyciski w bocznym pasku zadań
	 * @param String nazwa - Nazwa jaka będzie wyświetlana na przycisku
	 * @return JXHyperlink
	 */
	private JXHyperlink createLinkClass(String nazwa)
	{
		JXHyperlink link = new JXHyperlink();
		link.setText(nazwa);
        link.setClicked(false);
        link.setClickedColor(link.getUnclickedColor());
        return link;
		
	}
	public JButton createButton(String tooltip,Icon icon) {
		JButton jb = new JButton("",icon);
		jb.setToolTipText(tooltip);
		return jb;
	}


	/**
	 *  Metoda tworzy a nastempnie wyświetla okno z poradami
	 */
	public void showTip()
	{
		DefaultTipModel tipModel = new DefaultTipModel();
		tipModel.add(new DefaultTip("Tip1", "Quick and dirty zeby pisac, trzeba pisac."));
		tipModel.add(new DefaultTip("Tip2", "DRY - Don't repeat yourself"));
		tipModel.add(new DefaultTip("Tip3", "KISS Keep it simple stupid"));
		tipModel.add(new DefaultTip("Tip4", "Zawsze pisz kod tak, jakby gość, który ma się nim zajmować był agresywnym psychopatą, który wie, gdzie mieszkasz."));
		tipModel.add(new DefaultTip("Tip5", "Czasami bardziej opłaca się zostać w łóżku w poniedziałek niż spędzić resztę tygodnia, debugując poniedziałkowy kod ."));
		JTipOfTheDay porady = new JTipOfTheDay(tipModel);
		porady.showDialog(this.mainFrame);
		
	}
	/**
	 * Metoda umożliwa dodanie akcji Kalendarzowi
	 * @param al ActionListener - Obiekt obsługujacy wydarzenia
	 */
	public void KalendarzActionListner(ActionListener al)
	{
		this.kalendarz.addActionListener(al);
	}
	/**
	 * Metoda wyświetla okno podczas zakonczenia działania programu
	 * @param wi WindowAdapter - Obiekt obslugujacy wydarzenie okna 
	 */
	public void ZakonczWindowListener(WindowAdapter wi)
	{
		this.mainFrame.addWindowListener(wi);
	}
	public void ZakonczActionListner(ActionListener al)
	{
		this.mntmNewMenuItem_9.addActionListener(al);
		this.btnNewButton_14.addActionListener(al);
		this.taskZakoncz.addActionListener(al);
	}
	
	/**
	 * Metoda umożliwa dodanie akcji Wykresu
	 * @param al ActionListener - Obiekt obsługujacy wydarzenia
	 */
	public void WykresActionListner(ActionListener al)
	{
		this.taskWykres.addActionListener(al);
		this.btnNewButton_11.addActionListener(al);
	}
	/**
	 * Metoda umożliwa dodanie akcji przycisku Autor
	 * @param al ActionListener - Obiekt obsługujacy wydarzenia
	 */
	public void AutorActionListner(ActionListener al)
	{
		this.btnNewButton_7.addActionListener(al);
		this.taskAut.addActionListener(al);
		this.mntmNewMenuItem.addActionListener(al);
		
	}
	/**
	 * Metoda umożliwa dodanie akcji przycisku dodaj
	 * @param al ActionListener - Obiekt obsługujacy wydarzenia
	 */
	public void dodajActionListner(ActionListener al) 
	{
		this.mntmNewMenuItem_1.addActionListener(al);
		this.btnNewButton.addActionListener(al);
		this.btnNewButton_5.addActionListener(al);
		this.taskDodaj.addActionListener(al);
	}
	/**
	 * Metoda umożliwa dodanie akcji przycisku Suma
	 * @param al ActionListener - Obiekt obsługujacy wydarzenia
	 */
	public void SumaActionListner(ActionListener al) 
	{
		this.mntmNewMenuItem_4.addActionListener(al);
		this.btnNewButton_3.addActionListener(al);
		this.taskSuma.addActionListener(al);
		
	}
	/**
	 * Metoda umożliwa dodanie akcji przycisku Srednia
	 * @param al ActionListener - Obiekt obsługujacy wydarzenia
	 */
	public void SredniaActionListner(ActionListener al) 
	{
		this.mntmNewMenuItem_5.addActionListener(al);
		this.btnNewButton_9.addActionListener(al);
		this.taskSred.addActionListener(al);
	}
	/**
	 * Metoda umożliwa dodanie akcji przycisku min
	 * @param al ActionListener- Obiekt obsługujacy wydarzenia
	 */
	public void MinActionListner(ActionListener al) 
	{
		this.mntmNewMenuItem_6.addActionListener(al);
		this.btnNewButton_2.addActionListener(al);
		this.taskMin.addActionListener(al);
	}
	/**
	 * Metoda umożliwa dodanie akcji przycisku max
	 * @param al ActionListener - Obiekt obsługujacy wydarzenia
	 */
	public void MaxActionListner(ActionListener al) 
	{
		this.mntmNewMenuItem_7.addActionListener(al);
		this.btnNewButton_10.addActionListener(al);
		this.taskMax.addActionListener(al);
	}
	/**
	 * Metoda umożliwa dodanie akcji przycisku Zeruj
	 * @param al ActionListener - Obiekt obsługujacy wydarzenia
	 */
	public void ZerujActionListner(ActionListener al) 
	{
		this.mntmNewMenuItem_3.addActionListener(al);
		this.btnNewButton_12.addActionListener(al);
		this.btnNewButton_6.addActionListener(al);
		this.taskZeruj.addActionListener(al);
	}
	/**
	 * Metoda umożliwa dodanie akcji przycisku Save
	 * @param al ActionListener - Obiekt obsługujacy wydarzenia
	 */
	public void SaveActionListner(ActionListener al) 
	{
		this.mntmNewMenuItem_2.addActionListener(al);
		this.btnNewButton_1.addActionListener(al);
		this.btnNewButton_4.addActionListener(al);
		this.taskZapisz.addActionListener(al);
	}
	/**
	 * Metoda umożliwa dodanie akcji przycisku Oblicz
	 * @param al ActionListener- Obiekt obsługujacy wydarzenia
	 */
	public void ObliczActionListner(ActionListener al) 
	{
		this.btnNewButton_8.addActionListener(al);
	}
	/**
	 * Metoda przekazuje obiekt głownego okna
	 * @return JFrame
	 */
	public JFrame getmainFrame()
	{
		return this.mainFrame;
	}
	/**
	 * Metoda przekazuje wartość slider
	 * @return int
	 */
	public int getSlider()
	{
		return this.slider.getValue() - 1;
	}
	/**
	 * Metoda przekazuje wartość slider_1
	 * @return int
	 */
	public int getSlider_1()
	{
		return this.slider_1.getValue() - 1;
	}
	/**
	 * Metoda zwraca wartość wpisana w okno przez użytkownika
	 * @return String 
	 */
	public String getUserInput() {
		return txtDada.getText();
	}
	/**
	 * Metoda umożliwia wypisanie tekstu w przygotowanym oknie 
	 * @param tekst String - tekst który ma zostać wyswietlony
	 */
	public void writeTextAera(String tekst)
	{
		this.txtrCos.setText(tekst);
	}
	/**
	 * Metoda zwraca wartość zaznaczoną na liscie wyboru
	 * @return int 
	 */
	public int getSelectionedList()
	{
		return this.list.getSelectedIndex();
	}
	/**
	 * Metoda umożliwa dodanie wartosci do tabeli 
	 * @param thigToAdd int  - Liczba do dodania
	 * @param row int - rzad do której chcemy dodać 
	 * @param column int  - kolumna do której chcemy dodać 
	 */
	public void addToTable(int thigToAdd,int row ,int column)
	{
		this.table.setValueAt(thigToAdd, row, column);
	}
	/**
	 * Sprawia że głowne menu jest widoczne
	 */
	public void setVisiblity()
	{
		this.mainFrame.setVisible(true);
	}
	/**
	 * Pokazuje wiadomosc na oknie błedu
	 * @param msg String - Widomosc ktora ma zostac wyswietlona
	 */
	public void showError(String msg)
	{
		JOptionPane.showMessageDialog(mainFrame, msg);
		this.logic.addErrorLog("Wyświetlono okno błedu - " + msg);
	}
	/**
	 * Metoda zwraca zacznaczona date w kalendarzu
	 * @return String 
	 */
	public String kalendarzGetDate()
	{
		this.kalendarz.updateUI();
		return kalendarz.getDate().toString();
	}
}
