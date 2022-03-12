import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Einlesen{
	    
	   static ArrayList<String> zitatsammlung = new ArrayList<>();
	   static ArrayList<String> autorensammlung = new ArrayList<>();
	   static ArrayList<Integer> gespielteZitate = new ArrayList<>();
	   
	    public static void starteEinlesen() throws IOException, ArrayIndexOutOfBoundsException {

	    		FileReader fr = new FileReader("zitatsammlung.txt");
	    		BufferedReader br = new BufferedReader(fr);
	            String aktuelleZeile = br.readLine();
	            //ein File Reader und ein Bufferd Reader werden erzeugt
	           
	            while (aktuelleZeile != null) {
	            	String[] teil = aktuelleZeile.split("-");
	            	// "-" wird als Trennzeichen zwischen Zitat und Autor in der Textdatei festgelegt.
	            	
	            	zitatsammlung.add(teil[0]);
	            	autorensammlung.add(teil[1]);
	               aktuelleZeile = br.readLine();
	            } //Die Textdatei wird Zeile für Zeile eingelesen und in zwei ArrayListen gespeichert
	            
	            br.close();
	            fr.close();
	    	}
	    
	    
	    public static  String[] zitatAuswaehlen() throws ArithmeticException{
	    		Random rand = new Random();
	    		int zitatNummer = Math.abs(rand.nextInt()) % zitatsammlung.size(); 
	    		//Eine zufaellige Ordnungsnummer in der Zitatsammlung wird erzeugt
	    		
	    		int schleifendurchlauf = 0;
	    		while(gespielteZitate.contains(zitatNummer)){
	    			zitatNummer = Math.abs(rand.nextInt()) % zitatsammlung.size();
	    			schleifendurchlauf = schleifendurchlauf + 1;
	    			if(schleifendurchlauf == zitatsammlung.size()) gespielteZitate.clear();
	        		} //Falls das Zitat bereits ausgewaehlt wurde, wird ein neues Zufallszitat ausgesucht
	    		
	    		String[] ergebnis = new String [2];
	    		ergebnis[0] = zitatsammlung.get(zitatNummer);
	    		ergebnis[1] = autorensammlung.get(zitatNummer);
	    		gespielteZitate.add(zitatNummer);
	    		return ergebnis;
	    	}
	    }