package Logic;

import Storage.FacadeStorage;
/**
 * Klasa wykonuje obliczenia matematyczne potrzebne w programie
 * @author Wojciech Buńka
 *
 */
public class math {
	
	FacadeStorage storage;
	/**
	 * Klasa zapisuje obiekt klasy FacadeStorage który jest potrzebny do zapisu inforamcji
	 * @param storageClass FacadeStorage - Obiekt klasy FacadeStorage
	 */
	public math(FacadeStorage storageClass)
	{
		this.storage = storageClass;
	}
	/**
	 * Sumuje elementy tablicy 
	 * @return double - Wynik operacji 
	 */
	public int AddTableElements()
	{
		int wynik = 0;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5;j++) {
				try 
				{
					
					wynik = wynik + this.storage.table_class.getValueAt(i, j);
					
				}
				catch(Exception e)
				{
					break;
				}
				
			}
		}
		
		return wynik;
		
	}
	/**
	 * Oblicza średnia z elementów tablicy
	 * @return double - Wynik operacji 
	 */
	public double AvrageTableElements()
	{
		double suma = this.AddTableElements();
		
		return suma/25.0;
		
	}
	/**
	 * Oblicza wartość maksymalna z elementów tablicy
	 * @return double - Wynik operacji 
	 */
	public int MaxTableElements()
	{
		int wynik = 0;
		
		try 
		{
			wynik = this.storage.table_class.getValueAt(0, 0);
			
			for(int i=0; i<5; i++) {
				for(int j=0; j<5;j++) {
					if( this.storage.table_class.getValueAt(i, j) >= wynik ) {
						wynik = this.storage.table_class.getValueAt(i, j);
					}
				}
			}
			
		}
		catch(Exception e)
		{
			return wynik;
		}
		
		return wynik;
	
	}
	/**
	 * Oblicza wartość minimalną z elementów tablicy
	 * @return double - Wynik operacji 
	 */
	public int MinTableElements()
	{
		int wynik = 0;
		try
		{
			for(int i=0; i<5; i++) {
				for(int j=0; j<5;j++) {
					if(this.storage.table_class.getValueAt(i, j) <= wynik ) {
						wynik = this.storage.table_class.getValueAt(i, j);
					}
				}
			}
		}
		catch(Exception e)
		{
			return wynik;
		}
		
		return wynik;
	}
	

}
