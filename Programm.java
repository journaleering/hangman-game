import java.io.IOException;
import java.util.ArrayList;

public class Programm
{
    String werhatsgesagt;
	String zufaelligesZitat;
	String sichtbar = "";
    ArrayList<Character> gewaehlteBuchstaben = new ArrayList<Character>();

    public Programm() throws IOException, ArithmeticException, ArrayIndexOutOfBoundsException{
			Einlesen.starteEinlesen();
    		}//Beim Erstellen eines neuen Objekts der Klasse Programm wird ein neues Textdokument eingelesen
    
    
    public void neuesZitat() throws IOException {
		String [] h = Einlesen.zitatAuswaehlen();
    	zufaelligesZitat = h[0];
		werhatsgesagt = h[1];
		sichtbar = "";
		gewaehlteBuchstaben.clear();
		for ( int i = 0; i < zufaelligesZitat.length(); i++){
			char zeichen = zufaelligesZitat.charAt(i);
			if ( zeichen == ' ' || zeichen == ',' || zeichen == '.' || zeichen == '!' || zeichen == '?'|| zeichen == ':'|| Character.isDigit(zeichen) ) sichtbar += zeichen;
			else sichtbar += '_';
			}
    	}	/*Die String Variable sichtbar wird mit Zeichen befuellt
	  		 Satzzeichen werden direkt angezeigt, Buchstaben durch Unterstriche ersetzt*/


    
    public boolean aktualisieren(char eingegebenerBuchstabe){
    	
    		boolean enthaelt = false ;
    		String s = "";
    		char[] geheimesArray = new char [zufaelligesZitat.length()]; 
        	char[] sichtbaresArray = new char [zufaelligesZitat.length()];
        	for(int i = 0; i < zufaelligesZitat.length(); i++){ 
        			geheimesArray[i] = zufaelligesZitat.charAt(i);  
        			sichtbaresArray[i] = sichtbar.charAt(i);
        			} //Die Strings 'sichtbar' und 'zufaelligesZitat' werden in char Arrays umgewandelt
        	
        	for(int k = 0; k < zufaelligesZitat.length();k++){
        			if(geheimesArray[k] == eingegebenerBuchstabe){  
        				sichtbaresArray[k] = eingegebenerBuchstabe;
        				enthaelt = true;         
            			}/*Falls der eingegebene Buchstabe im Zitat enthalten ist, wird der Inhalt des Arrays 
		 				   an der entsprechenden Stelle durch die Eingabe ersetzt */
        			
        			else if(geheimesArray[k] == Character.toUpperCase(eingegebenerBuchstabe)){  
        				sichtbaresArray[k] = Character.toUpperCase(eingegebenerBuchstabe); 
        				enthaelt = true; 
            			}// Das Array wird bei Eingabe von Kleinbuchstaben auch auf Grossbuchstaben ueberprueft
        			
        			else if(geheimesArray[k] == Character.toLowerCase(eingegebenerBuchstabe)){  
        				sichtbaresArray[k] = Character.toLowerCase(eingegebenerBuchstabe); 
        				enthaelt = true; 
            		}// Bei Eingabe von Grossbuchstaben wird das Array auch auf Kleinbuchstaben ueberprueft
        		}
        	for(int m=0; m < zufaelligesZitat.length(); m++ ) s = s + sichtbaresArray[m];    sichtbar = s;  
        	//Der Inhalt des Arrays wird wieder in den String sichtbar gespeichert

        	return enthaelt;
    		}
    
    
    public boolean sofortLoesung(String ganzesZitat){
    	String a = zufaelligesZitat.replaceAll("[^a-zA-Z]+", "");
		String b = ganzesZitat.replaceAll("[^a-zA-Z]", "");
		return (a.equalsIgnoreCase(b));
    		}//Wenn der eingegebene String mit den Buchstaben von zufaelligesZitat uebereinstimmt wird 'true' zurück gegeben
    
    
    public boolean loesungErraten(){   
    		return zufaelligesZitat.equalsIgnoreCase(sichtbar);   
    		} // Wenn die Variable sichtbar dem gesuchten Zitat entspricht, ist das Spiel gewonnen.
    
    
    public boolean mehrfachAusgewaehlt(char buchstabe){
    		return gewaehlteBuchstaben.contains(Character.toLowerCase(buchstabe)) ||buchstabe == ' ';
    		}// Ueberpruefen, ob der Buchstabe bereits eingegeben wurde oder nur ein Leerzeichen eingegeben wurde
   
    
    public static boolean ungueltigerName( String name){
    		return name.isEmpty() ||name.contains(" ") || name.length() > 15;
    		}// Der eingegebene Name darf nicht leer oder laenger als 15 Zeichen sein
   
    
    public boolean ungueltigeEingabe( String eingabe){
    		return !eingabe.matches("^[ \u00C0-\u017FA-z]+$")||eingabe.isEmpty();
    		}// Nur die Eingabe von Buchstaben des deutschen Alphabets ist zulaessig
   
    
    public boolean jaodernein( String eingabe){
    		return !eingabe.matches("[jnJN]");
    		}//Nur die Eingabe der Buchstaben 'j' und 'n' ist zulaessig
    
    
    public void loesungAnzeigen (){
    		System.out.println(zufaelligesZitat);
    		}
    
    
    public void autorAnzeigen() {
    		System.out.println(werhatsgesagt);
    		}
}
