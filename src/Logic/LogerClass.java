package Logic;

import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.XMLLayout;
/**
 * klasa odpowiedzialna za konfiguracje oraz wyświetlanie Logów
 * @author Wojciech Buńka
 *
 */
public class LogerClass {
	ConsoleAppender capp;
	FileAppender fapp;
	Logger consoleLogger,fileLogger;
	/**
	 * Konstruktor tworzy obiekty potrzebne do logów
	 */
	public LogerClass()
	{

		try {
			this.capp = new ConsoleAppender(new SimpleLayout());
			this.fapp = new FileAppender(new XMLLayout(), "loger.xml");
			this.consoleLogger = Logger.getLogger("consoleloger");
			this.fileLogger = Logger.getLogger("fileloger");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		configLogerObject();
		
	}
	/**
	 * Konfiguracja obiektów potrzebnych do logów
	 */
	private void configLogerObject()
	{
		this.consoleLogger.setLevel(Level.INFO);
		this.consoleLogger.addAppender(capp);
		
		
		this.fileLogger.setLevel(Level.INFO);
		this.fileLogger.addAppender(fapp);
	}
	/**
	 * Dodaje log typu INFO do pliku oraz wyświetla w konsoli
	 * @param msg - Wiadomość jaka jest zapisywana w logu 
	 */
	public void addInfoLog(String msg)
	{
		consoleLogger.info(msg);
		fileLogger.info(msg);
	}
	/**
	 * Dodaje log typu INFO do pliku oraz wyświetla w konsoli
	 * @param msg - Wiadomość jaka jest zapisywana w logu 
	 */
	public void addErrorLog(String msg)
	{
		consoleLogger.error(msg);
		fileLogger.error(msg);
	}
	
}
