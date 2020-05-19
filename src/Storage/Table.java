package Storage;

/**
 * Klasa przechowujaca dane tabeli
 * @author Wojciech Buńka
 *
 */
public class Table
{
    	private Object[][] table_data = {
    							{0,0,0,0,0},
    							{0,0,0,0,0},
    							{0,0,0,0,0},
    							{0,0,0,0,0},
    							{0,0,0,0,0},};
    	/**
    	 * Zwraca tablice 
    	 * @return table_data Object[][] - Zwraca tablicze obiektow
    	 */
    	public Object[][] getTable_data() {
    		return table_data;
    	}
    	/**
    	 * Zwraca obiekt z konkretengo miejsca w tabeli 
    	 * @param pointX - wiersz 
    	 * @param pointY - kolumna 
    	 * @return int 
    	 * @throws Exception własny (obiekt w wyznaczonym miejscu nie istnieje)
    	 */
        public int getValueAt(int pointX, int pointY) throws Exception {
            if(this.isValuesCorect(pointX, pointY))
            {
            	int helper = (int) table_data[pointX][pointY];
                return helper;
            }
            else
            {
                throw new Exception("object at specifed atributs do not exist");
            }

        }
        /**
         * ustawia obiekt w konkretnym miejscu w tabeli
         * @param pointX - wiersz 
    	 * @param pointY - kolumna 
    	 * @param value_to_set - wartosc do dodania
    	 * @return int 
    	 * @throws Exception własny (obiekt w wyznaczonym miejscu nie istnieje)
         */
        public boolean setValueAt(int pointX, int pointY, int value_to_set) throws Exception {
            if(this.isValuesCorect(pointX, pointY))
            {
                table_data[pointX][pointY] = value_to_set;
            }
            else
            {
                throw new Exception("object at specifed atributs do not exist");
            }
            return true;
        }
        /**
         * Zeruje tablice
         */
        public void resetValues()
        {

            for(int i=0; i<5; i++) {
                for(int j=0; j<5;j++) {
                    try{
                        this.setValueAt(i, j, 0);
                    }
                    catch (Exception e)
                    {
                        break;
                    }

                }
            }

        }

        /**
         * Sprawdza czy istnieje obiekt we wskazanym miejscu 
         * @param pointX - wiersz 
         * @param pointY - kolumna 
         * @return boolean true jezeli istnieje
         */
        private boolean isValuesCorect(int pointX, int pointY)
        {
            try {
                return pointX >= 0 && pointY >= 0;

            }
            catch (IndexOutOfBoundsException e)
            {
                return false;
            }


        }


}
