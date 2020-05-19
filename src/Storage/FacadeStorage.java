package Storage;

import Storage.FileSaver;
/**
 * Klasa odpowiedzialna za zapis oraz przechowywanie danych
 * @author Wojciech Buńka
 *
 */
public class FacadeStorage 
{

    public Table table_class;
    public FileSaver saver;
    /**
     * Konstruktor przygotwuje obiekty potrzebne dla dzialania prgoramu
     */
    public FacadeStorage()
    {
    	this.table_class = new Table();
    	this.saver = new FileSaver("tabela.csv");
    }
    /**
     * Zapisuje tablice do pliku
     */
    public void saveTableToFile()
    {
    	this.saver.saveToFile(this.table_class.getTable_data()); 
    }
    
 
}
