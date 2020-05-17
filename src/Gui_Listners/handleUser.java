package Gui_Listners;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;


import Gui.MainWindow;
import Gui.info;
import Gui.wykres;
import Logic.ProgramFacade;

/**
 *  * @author Wojciech Buńka
 *	Klasa odpowiedzialna za obsluge zdarzeń klasy MainWindow
 */
public class handleUser {
	/**
	 *  MainWindow view - objekt głownego okna do którego klasa obsługuje wydarzenia
	 *  ProgramFacade logic - Objekt facady służacy do obróbki danych jak i przechowywania
	 */
	private MainWindow view;
	private ProgramFacade logic;
	/*
	 * Konstruktor klasy hadnleUser przyjmuje argumenty w postaci obiektów ProgramFacade,MainWindow.
	 * Głównym zadaniem jest przyporzadkowaniem obsługi wydarzeń przez wystawione w Obiekcie klasy MainWindow metody
	 */
	public handleUser(MainWindow MainWindowObject, ProgramFacade FacadeObject)
	{
		this.view = MainWindowObject;
		this.logic = FacadeObject;
		
		this.view.SumaActionListner(new SumaListener(this.view, this.logic));
		this.view.dodajActionListner(new DodajListener(this.view, this.logic));
		this.view.SredniaActionListner(new SredniaListener(this.view, this.logic));
		this.view.MinActionListner(new MinListener(this.view, this.logic));
		this.view.MaxActionListner(new MaxListener(this.view, this.logic));
		this.view.ZerujActionListner(new ZerujListener(this.view, this.logic));
		this.view.SaveActionListner(new SaveListener(this.view, this.logic));
		this.view.ObliczActionListner(new ObliczListener(this.view, this.logic));
		this.view.AutorActionListner(new AutorListener(this.view, this.logic));
		this.view.KalendarzActionListner(new KalendarzListener(this.view, this.logic));
		this.view.WykresActionListner(new WykresListener(this.view, this.logic));
		this.view.ZakonczActionListner(new ZakonczListener(this.view, this.logic));
		this.view.ZakonczWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent we)
			{ 
				String ObjButtons[] = {"Tak","Nie"};
				int PromptResult = JOptionPane.showOptionDialog(null, 
					"Czy aby napewno chcesz opuść program?", "Zaliczenie PA", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons,ObjButtons[1]);
				
				if(PromptResult==0)
				{
			    	
					System.exit(0);          
				}
			}});

	}

	/**
	 * Klasa abstrakcyjna z które dziedzicza pozostale klasy w klasie handleUser
	 * Klasa dziedzicza od tej klasy obiekty MainWindow,ProgramFacade 
	 * @author Wojciech Buńka
	 *
	 */
	abstract class TaskListener
	{
		MainWindow inView;
		ProgramFacade inLogic;
		
		public TaskListener(MainWindow MainWindowObject, ProgramFacade FacadeObject)
		{
			this.inLogic = FacadeObject;
			this.inView = MainWindowObject;
		}

	}
	/**
	 * Klasa służaca do wyświetlania ekranu upewniajcego sie czy użytwkonik ma zamiar wyjsc
	 * @author Wojciech Buńka
	 *
	 */
	class ZakonczListener extends TaskListener implements ActionListener {
		
		public ZakonczListener(MainWindow MainWindowObject, ProgramFacade FacadeObject) {
			super(MainWindowObject, FacadeObject);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String ObjButtons[] = {"Tak","Nie"};
			int PromptResult = JOptionPane.showOptionDialog(null, 
				"Czy aby napewno chcesz opuść program?", "Zaliczenie PA", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons,ObjButtons[1]);
			
			if(PromptResult==0)
			{
		    	
				System.exit(0);          
			}
			
		}

	}
	/**
	 * Klasa obsługuje wydarzenia Kalendarza
	 * @author Wojciech Buńka
	 *
	 */
	class KalendarzListener extends TaskListener implements ActionListener {
		
		public KalendarzListener(MainWindow MainWindowObject, ProgramFacade FacadeObject) {
			super(MainWindowObject, FacadeObject);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String tekst = "Wybrana data - " + inView.kalendarzGetDate();
			this.inView.writeTextAera(tekst);
			this.inLogic.addInfoLog("Pokazano wykres");
			
		}

	}
	/**
	 * Klasa obsługuje wydarzenia Wykresu
	 * @author Wojciech Buńka
	 *
	 */
	class WykresListener extends TaskListener implements ActionListener {
		

		public WykresListener(MainWindow MainWindowObject, ProgramFacade FacadeObject) {
			super(MainWindowObject, FacadeObject);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			this.inLogic.addInfoLog("Pokazano porade dnia");
			wykres wykres = new wykres(this.inLogic.storage.table_class.getTable_data(),inView.getmainFrame());
			
		}

	}
	/**
	 * Klasa obsługuje wydarzenia przycisków suma
	 * @author Wojciech Buńka
	 *
	 */
	class SumaListener extends TaskListener implements ActionListener {
		
		public SumaListener(MainWindow MainWindowObject, ProgramFacade FacadeObject) {
			super(MainWindowObject, FacadeObject);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int ans = this.inLogic.AddTableElements();
			
			String helper = " Suma elementów wynosi" + Double.toString(ans);
			this.inView.writeTextAera(helper);
			
		}

	}
	/**
	 * Klasa obsługuje wydarzenia przycisków Autor
	 * @author Wojciech Buńka
	 *
	 */
	class AutorListener extends TaskListener implements ActionListener 
	{
		public AutorListener(MainWindow MainWindowObject, ProgramFacade FacadeObject)
		{
			super(MainWindowObject, FacadeObject);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			info info;
			this.inLogic.addInfoLog("Pokazano okno info");
			info = new info(inView.getmainFrame());
			
		}

	}
	/**
	 * Klasa obsługuje wydarzenia przycisków Dodaj
	 * @author Wojciech Buńka
	 *
	 */
	class DodajListener extends TaskListener implements ActionListener {
			
		public DodajListener(MainWindow MainWindowObject, ProgramFacade FacadeObject) {
			super(MainWindowObject, FacadeObject);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			try
			{
				int kolumna = this.inView.getSlider_1();
				int poem = this.inView.getSlider();
				String userOutput = this.inView.getUserInput();
				
				int value = Integer.parseInt(userOutput);
				
				this.inView.addToTable(value, poem, kolumna);
				this.inLogic.storage.table_class.setValueAt(poem, kolumna, value);
				String helper = " Wartość została dodana do tablicy";
				this.inView.writeTextAera(helper);
			
			}
			catch(Exception ee)
			{
				this.inView.showError("bład wprowadzonej wartosci");
			}
		
		}

	}
	/**
	 * Klasa obsługuje wydarzenia przycisków Średnia
	 * @author Wojciech Buńka
	 *
	 */
	class SredniaListener extends TaskListener implements ActionListener {
		
		
		public SredniaListener(MainWindow MainWindowObject, ProgramFacade FacadeObject) {
			super(MainWindowObject, FacadeObject);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Double ans = this.inLogic.AvrageTableElements();
			
			String helper = " Średnia elementów wynosi " + Double.toString(ans);
			this.inView.writeTextAera(helper);
		}

	}
	/**
	 * Klasa obsługuje wydarzenia przycisków Min
	 * @author Wojciech Buńka
	 *
	 */
	class MinListener extends TaskListener implements ActionListener {
		
		
		public MinListener(MainWindow MainWindowObject, ProgramFacade FacadeObject) {
			super(MainWindowObject, FacadeObject);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int ans = this.inLogic.MinTableElements();
			
			String helper = " Najmniejszy z elementów wynosi " + Double.toString(ans);
			this.inView.writeTextAera(helper);
		}

	}
	/**
	 * Klasa obsługuje wydarzenia przycisków Max
	 * @author Wojciech Buńka
	 *
	 */
	class MaxListener extends TaskListener implements ActionListener {
		

		public MaxListener(MainWindow MainWindowObject, ProgramFacade FacadeObject) {
			super(MainWindowObject, FacadeObject);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int ans = this.inLogic.MaxTableElements();
			
			String helper = " Najwiekszy z elementów wynosi " + Double.toString(ans);
			this.inView.writeTextAera(helper);
		}

	}
	/**
	 * Klasa obsługuje wydarzenia przycisków Zeruj
	 * @author Wojciech Buńka
	 *
	 */
	class ZerujListener extends TaskListener implements ActionListener {
		
		public ZerujListener(MainWindow MainWindowObject, ProgramFacade FacadeObject) {
			super(MainWindowObject, FacadeObject);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			this.inLogic.resetTableValues();
			
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					view.addToTable(0, i, j);
				}
			}
			
			String helper = " Tablica została wyzerowana";
			this.inView.writeTextAera(helper);
		}

	}
	/**
	 * Klasa obsługuje wydarzenia przycisków Save
	 * @author Wojciech Buńka
	 *
	 */
	class SaveListener extends TaskListener implements ActionListener {

		public SaveListener(MainWindow MainWindowObject, ProgramFacade FacadeObject) {
			super(MainWindowObject, FacadeObject);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			this.inLogic.storage.saveTableToFile();
			String helper = " Tablica została zapisana";
			this.inView.writeTextAera(helper);
		
		}

	}
	/**
	 * Klasa obsługuje wydarzenia przycisków Oblicz
	 * @author Wojciech Buńka
	 *
	 */
	class ObliczListener extends TaskListener implements ActionListener {

		public ObliczListener(MainWindow MainWindowObject, ProgramFacade FacadeObject) {
			super(MainWindowObject, FacadeObject);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			int index = this.inView.getSelectionedList();
			
			switch(index) 
			{
			case 0:
				SumaListener suma = new SumaListener(view, logic);
				suma.actionPerformed(e);
				break;
			case 1:
				SredniaListener srednia = new SredniaListener(view, logic);
				srednia.actionPerformed(e);
				break;
			case 2:
				MinListener min = new MinListener(view, logic);
				min.actionPerformed(e);
				break;
			case 3:

				MaxListener max = new MaxListener(view, logic);
				max.actionPerformed(e);
				break;
		
		}

	}
	}
}	
