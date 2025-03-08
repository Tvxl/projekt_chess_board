package pack1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Move {

	public Move() {

	}

	public Figur getFigur(Position position) {

		for (int i = 0; i < Main_Schach.alle_figuren.size(); i++) {
			if (Main_Schach.alle_figuren.get(i).getPosition().equals(position)) {
				return Main_Schach.alle_figuren.get(i);
			} else {

			}

		}
		return null;

	}

	public boolean istmoeglich(int[] move_vorschlage) { //nicht boolean sondern rpckgabe der liste
		List<int[]> unter_array_lst = new ArrayList<>();
		// Überprüfen, ob die Länge gerade ist
		if (move_vorschlage.length % 2 != 0) {
		    throw new IllegalArgumentException("nicht zwei");
		}

		int anzahl_unter_arrays = move_vorschlage.length / 2;
		

		for (int i = 0; i < anzahl_unter_arrays; i++) {
		    int[] feld_vorschlage = new int[2];
		    for (int j = 0; j < 2; j++) {
		    	feld_vorschlage[j] = move_vorschlage[i * 2 + j];
		    }
		    unter_array_lst.add(feld_vorschlage);
		}

		// überprüfen ob werte größer 8 dabei sind
		for (int i = 0; i < unter_array_lst.size(); i++) {
		  if(unter_array_lst.get(i)[0] > 7 || unter_array_lst.get(i)[1] < 0 ) {
			  unter_array_lst.remove(i);
			  return false;
		  }
		  if(unter_array_lst.get(i)[1] > 7 || unter_array_lst.get(i)[1] < 0 ) {
			  unter_array_lst.remove(i);
			  return false;
		  }
		  
		}

		return true;

	}
}



