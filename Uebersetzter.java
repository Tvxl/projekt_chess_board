package pack1;

public class Uebersetzter {

	private static final String SPALTEN = "abcdefgh";

	public Uebersetzter() {

	}

	public static String koords_zu_schach(int x, int y) {
		char spalte = SPALTEN.charAt(x); // charAt gibt zahlen wert zurück wo sich der buchstabe(x) in der SPALTEN var befindet
		int reihe = y + 1;

		return "" + reihe + spalte;

	}

	public static int[] schach_zu_koords(String schach) {
		 	char spalte = schach.charAt(0); //herrausfiltern des ersten chars, spalte ist nun umgewandelt in einen char 
	        int reihe = Character.getNumericValue(schach.charAt(1)); //herrausfiltern des zweiten chars(muss zahl sein)

	        int x = SPALTEN.indexOf(spalte); //es wird der index von dem char im SPLATEN var genannt 
	        int y =  7 - reihe +1;
		return new int[]{x,y};

	}

}
