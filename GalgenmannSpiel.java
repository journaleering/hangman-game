import java.io.IOException;
import java.util.Scanner;


public class GalgemannSpiel
{
    public static void main( String[] args){
    	try{
        Scanner scan1 = new Scanner(System.in);  
        Galgenmaennchen mann = new Galgenmaennchen();
        Programm prog = new Programm();
        //Objekte der Klassen Programm, Galgenmaennchen und Scanner werden erzeugt
        
        int rundenzahl = 1;
        int punkte = 0;
        int fehler = 0;
        //Drei int-Variablen für das spaetere Erstellen der Bestenliste werden erzeugt
        
        System.out.println();
        System.out.println(mann.maleFussball());
        System.out.println( "HERZLICH WILLKOMMEN ZU GALGENMANN - DEM EINZIGARTIGEN HANGMANSPIEL !");
        System.out.println();
        System.out.println( "Fussballer sind moderne Philosophen, die schon so manche Lebensweisheit von sich gegeben haben ;-)");
        System.out.println( "Atmen Sie tief durch, schnallen Sie sich an und versuchen Sie die unendliche Weisheit der Ballakrobaten zu entraetseln.!");
        System.out.println( "Wenn Sie ein Zitat mit weniger als 5 Fehlversuchen erraten, haben Sie gewonnen.");
        System.out.println( "Falls Sie glauben, die Loesung erraten zu haben, koennen Sie jederzeit versuchen eine Komplettloesung einzugeben.");
        System.out.println( "Also los gehts ;-) ");
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println(" BITTE GEBEN SIE IHREN NAMEN EIN:");
		System.out.println("-----------------------------------");
		System.out.println();
        
        String name = scan1.nextLine(); 
		
        while(Programm.ungueltigerName(name)){
        	System.out.println("------------------------------------------------------------------------------------");
        	System.out.println(" FEHLER: DER NAME DARF KEINE LEERZEICHEN ENTHALTEN UND MAXIMAL 15 ZEICHEN LANG SEIN.");
        	System.out.println("------------------------------------------------------------------------------------");
        	name = scan1.nextLine();
        	}
        		
        System.out.println();
        System.out.println("Willkommen "+name+"! " + "Viel Spass und Glueck bei unserem kleinen Hangman-Spiel!");
        
		boolean nocheineRunde = true;
        //der Anfangswert der Variable 'nocheineRunde' wird als 'true' definiert, um die while-Schleife zu betreten
		
        while(nocheineRunde){
        	
        	System.out.println();
        	System.out.println(mann.keinFehlversuch());
        	int fehlversuche = 0;
        	boolean geloest = false;
        	prog.neuesZitat();  //Ein neues zufaelliges Zitat wird ausgewaehlt
        	
        			while (fehlversuche < 5 && !prog.loesungErraten() && !geloest){
        				//Das Abfragen einer neuen Eingabe wird fortgesetzt, solange das Zitat nicht erraten oder das Spiel verloren ist
        			
        					System.out.println(prog.sichtbar);
        					System.out.print("Ein Zitat von Fussball-Philosoph "); 
        					prog.autorAnzeigen(); 
        					System.out.println();
        					System.out.println("-----------------------------------------------------------------");
        					System.out.println("            BITTE GEBEN SIE EINEN BUCHSTABEN EIN");
        					System.out.println("-----------------------------------------------------------------");
        					System.out.println();
        					String komplett;
        					char eingabe;
        					
        					do{
        						komplett = scan1.nextLine();
        						while(prog.ungueltigeEingabe(komplett)){
        							System.out.println("----------------------------------------------------------------------------------------");
            						System.out.println(" UNGUELTIGE EINGABE: BITTE VERWENDEN SIE NUR BUCHSTABEN. KEINE ZIFFERN UND SONDERZEICHEN.");
            						System.out.println("----------------------------------------------------------------------------------------");
            						komplett = scan1.nextLine();
        							}
        						if(prog.sofortLoesung(komplett)) {
        							geloest = true; 
        							break;
        							} //Falls eine richtige Komplettloesung eingegeben wurde, verlaesst man die Schleife
        						
            					eingabe = komplett.charAt(0);
            					//die Methode 'mehrfachAusgewaehlt' benoetigt eine char Variable als Eingangsparameter
        						if(prog.mehrfachAusgewaehlt(eingabe)){
        							System.out.println("------------------------------------------------------------------------------------------");
        							System.out.println(" SIE HABEN DIESEN BUCHSTABEN BEREITS GEWAEHLT. BITTE GEBEN SIE EINEN NEUEN BUCHSTABEN EIN");
        							System.out.println("------------------------------------------------------------------------------------------");
        							}
        						} while(prog.mehrfachAusgewaehlt(eingabe));
        						
        					for (int i = 0; i < 40; i++){
								System.out.println();
							}// Zur besseren Uebersicht werden Leerzeilen eingefuegt
    						
        					if(!geloest){
            						eingabe = komplett.charAt(0);
            						prog.gewaehlteBuchstaben.add(Character.toLowerCase(eingabe));
            						//Der gewaehlte Buchstabe wird in die entsprechende ArrayList der Klasse Programm geschrieben
            					
        							if (prog.aktualisieren(eingabe)) System.out.println("Super! Das ist richtig :-)");
        							//Die aktualisieren Methode wird aufgerufen und das Ergebnis ausgewertet
        							else{
    									fehlversuche = fehlversuche + 1 ;
    									System.out.println("Das war leider falsch :-(");
    									}
        							System.out.println(mann.maleBild(fehlversuche));
        							// Das Bild des Galgenmaennchens wird gemalt
        								} 
        			}
        			      			
        if (prog.loesungErraten()||geloest == true) {
            System.out.println("Gratulation, Sie haben gewonnen!");
            System.out.println();
            System.out.println("Hier ist noch einmal die richtige Loesung:");
            punkte = punkte +1;
        	}
        else{
            System.out.println("Sie haben leider verloren.");
            System.out.println();
            System.out.println("Das waere die richtige Loesung gewesen:");
        	}
        
        fehler = fehler + fehlversuche;
        System.out.println("");
        prog.loesungAnzeigen();
        System.out.print("Ein Zitat von Fussball-Philosoph "); 
        prog.autorAnzeigen();
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println(" DRUECKEN SIE 'J' WENN SIE NOCH EINE RUNDE SPIELEN WOLLEN ODER 'N' WENN SIE DAS SPIEL VERLASSEN WOLLEN.");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        String antwort = scan1.nextLine().toUpperCase();
        //Abfragen, ob der Spieler eine weitere Runde spielen moechte
        
        while(prog.jaodernein(antwort)){
        	System.out.println("---------------------------------------------------------------");
			System.out.println("UNGUELTIGE EINGABE: BIITE GEBEN SIE ENTWEDER 'J' ODER 'N' EIN");
			System.out.println("---------------------------------------------------------------");
			antwort = scan1.nextLine().toUpperCase();
			} //Nur die Buchstaben 'n' und 'j' sind als Eingabe zulaessig
        
        char antwort1 = antwort.charAt(0);
        
        if(nocheineRunde = (antwort1 == 'J')){
        	rundenzahl = rundenzahl +1;
        	System.out.println("Super! Auf zur naechsten Runde!"); 
        	}// eine neue Runde wird gestartet
        else{
        	nocheineRunde = false;
        	System.out.println("Auf Wiedersehen! Bis zum naechsten Mal!"); 
        	Bestenliste.schreibeBestenliste(name, punkte, rundenzahl, fehler);
        	Bestenliste.ordneBestenliste();
        	}//Das Spiel wird beendet und die Bestenliste erstellt
        }
        scan1.close();
    	}
    	catch(IOException e){
    		System.out.println();
    		System.out.println("FEHLER: Das Spiel musste leider beendet werden."); 
    		System.out.println("Es konnte kein Dokument zum Einlesen der Zitate gefunden werden.");
    		System.out.println("Hinweis: Es muss eine Datei mit Namen 'bestenliste.txt' im Programmordner 'Galgenmann' vorhanden sein.");
    	}
    	catch(ArithmeticException e) {
    		System.out.println();
    		System.out.println("FEHLER: Das Spiel musste leider beendet werden."); 
    		System.out.println("Das Dokument zum Einlesen der Zitate ist leer.");
    	}
    	catch(ArrayIndexOutOfBoundsException e){
    		System.out.println();
    		System.out.println("FEHLER: Das Spiel musste leider beendet werden."); 
    		System.out.println("Die Zitate wurden nicht korrekt in das Dokument eingetragen.");
    		System.out.println("Hinweis: Zitat und Autor muessen mit einem Minuszeichen getrennt eingeben werden.");
		}
	}   // Exception - Handling
}
