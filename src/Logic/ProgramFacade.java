package Logic;
import Storage.FacadeStorage;
import Logic.LogerClass;
/**
 * Klasa odpowiedzialna za dostarczenie aplikacji możliwości przechowywania oraz obróbki danych
 * @author Wojciech Buńka
 *
 */
public class ProgramFacade {
	public FacadeStorage storage;
	private math math;
	private LogerClass log;
	
	/**
	 * Konstruktor inicializuje wewnetrzen obiekty potrzebne do działania programu
	 */
	public ProgramFacade()
	{
		this.storage = new FacadeStorage();
		this.math = new math(this.storage);
		this.log = new LogerClass();
	}
	/**
	 * Sumuje elementy tablicy 
	 * @return Double 
	 */
	public int AddTableElements()
	{
		return this.math.AddTableElements();
	}
	/**
	 * Średnią elementów tablicy 
	 * @return Double 
	 */
	public double AvrageTableElements()
	{
		return  this.math.AvrageTableElements();
	}
	/**
	 * najwieksza wartość z elementów tablicy 
	 * @return Double 
	 */
	public int MaxTableElements()
	{
		return this.math.MaxTableElements();
	}
	/**
	 * najmiejszą wartość z elementów tablicy 
	 * @return Double 
	 */
	public int MinTableElements()
	{
		return this.math.MinTableElements();
	}
	/**
	 * zeruje wartości z elementów tablicy 
	 */
	public void resetTableValues()
	{
		this.storage.table_class.resetValues();
	}
	/**
	 * Dodaje log typu INFO
	 * @param msg String - wiadomosc do wyświetlenia 
	 */
	public void addInfoLog(String msg)
	{
		this.log.addInfoLog(msg); 
	}
	/**
	 * Dodaje log typu ERROR
	 * @param msg String - wiadomosc do wyświetlenia 
	 */
	public void addErrorLog(String msg)
	{
		this.log.addErrorLog(msg);
	}

	
}
