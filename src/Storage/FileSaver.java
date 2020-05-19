package Storage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Klasa służaca do zapisu tablicy do pliku
 * @author Wojciech Buńka
 *
 */
public class FileSaver {
    String pathToFile;
   private Object[][] tableRead = {
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},};
   
   /**
    * Konstruktor 
    * @param pathToFile - miejsce zapisu pliku
    */
    public FileSaver(String pathToFile)
    {
        this.pathToFile = pathToFile;
    }
    /**
     * Zapis tablicy do pliku
     * @param tableSave Object[][]  - tablica do zapisania 
     */
    public void saveToFile(Object[][] tableSave) {

        try
        {
            FileWriter csvWriter = new FileWriter(this.pathToFile);
            for(int j=0;j<5;j++) {
                for (int i = 0; i < 5; i++) {

                    csvWriter.append(tableSave[j][i].toString());
                    csvWriter.append(",");
                }
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();

        }
        catch (IOException e)
        {
            System.out.println("nie zadzialao");
        }

    }
    /**
     * Odczyt tablicy z pliku 
     * @return Object[][] - zwraca odczytana tablice
     */
    public Object[][] readFromFile()
    {
        try
        {
            BufferedReader csvReader = new BufferedReader(new FileReader(this.pathToFile));
            String line;
            for(int i = 0; i < 5; i++)
            {
                line = csvReader.readLine();
                this.lineToArray(i,line);
            }
            return this.tableRead;
        }
        catch (IOException e)
        {
            System.out.println("File do not exist");
        }
        catch(IndexOutOfBoundsException k)
        {
            System.out.println("idex out of bounds");
        }
        return this.tableRead;
    }
    /**
     * Zapisuje do zemieniej odczytana linie 
     * @param lineNr int numer lini 
     * @param lineToSplit String otrzymana linia 
     */
    private void lineToArray(int lineNr, String lineToSplit)
    {

        String[] helper = lineToSplit.split(",");
        System.arraycopy(helper, 0, this.tableRead[lineNr], 0, 5);

    }

}
