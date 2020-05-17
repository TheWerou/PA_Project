package zad1_1;
import java.awt.EventQueue;

import Gui.MainWindow;
import Gui_Listners.handleUser;
import Logic.ProgramFacade;

/**
 * Głowna klasa programu łaczy ze soba Model Kontroler i widok
 * @author wojte
 *
 */
public class main {
	/**
	 * głowny main programu
	 * @param args Pozostałe argumenty
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramFacade logic = new ProgramFacade();
					MainWindow frame = new MainWindow(logic);
					handleUser actionListner = new handleUser(frame,logic);
					frame.setVisiblity();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

}
