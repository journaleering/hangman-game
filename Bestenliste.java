import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Bestenliste {

	public static void schreibeBestenliste(String name, int punkte, int gespielteRunden, int fehler) {
		    try{
			 BufferedWriter bw = null;
		     bw = new BufferedWriter(new FileWriter("Bestenliste.txt", true));
			 bw.write("Punkte: "+punkte+ " | Gespielte Runden: "+gespielteRunden+" | Fehler: "+fehler+" | Name: "+name);
			 bw.newLine();
			 bw.close();
		    } //Die naechste leere Zeile des Textdokuments "Bestenliste.txt" wird mit den Spieldaten beschrieben
		      //Ist das Dokument nicht vorhanden, wird ein neues Dokument erzeugt
		    
		    catch(IOException e){
		    	System.out.println("Fehler beim Erstellen der Bestenliste");
		    	}
			}
	
	
    public static void ordneBestenliste(){
    	   try{ 
    		    ArrayList<String> eintraege = new ArrayList<>();
    	   		FileReader fr = new FileReader("Bestenliste.txt");
    	   		BufferedReader br = new BufferedReader(fr);
    	   		String aktuelleZeile = br.readLine();
    	   		
    	   		while (aktuelleZeile != null) {
    	   			eintraege.add(aktuelleZeile);
    	   			aktuelleZeile = br.readLine();
    	   			}
    	   		br.close();
    	   		fr.close();
    	   		Collections.sort(eintraege, Collections.reverseOrder());
	    	   	System.out.println();
	            System.out.println();
	            System.out.println();
	            System.out.println("DIE BESTENLISTE WURDE ERSTELLT:");
	            System.out.println("-------------------------------------------------------------------");
	            
	            for(String counter: eintraege){
	            	System.out.println(counter);
	            	System.out.println("-------------------------------------------------------------------");
	            	}
	            } //Die Eintraege des Dokuments werden eingelesen
    	   		  //und mit der 'sort' Methode in absteigender Reihenfolge sortiert
    	   
    	  catch(IOException e){
    		   System.out.println("Fehler beim Erstellen der Bestenliste!");
    	   }
    	}
}