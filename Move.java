package pack1;

import java.util.List;

public class Move {

	public Move() {

	}

	public Figur getFigur(Position position) {

		for (int i = 0; i < Main_Schach.alle_figuren.size(); i++) {
			if (Main_Schach.alle_figuren.get(i).getPosition().equals(position)) {
				return Main_Schach.alle_figuren.get(i);
			} 

		}
		return null;

	}

	public List<Position> eingrenzen_move(List<Position> unter_array_lst, String team, String typ) { 
		
		// überprüfen ob werte größer 8 dabei sind
		for (int i = unter_array_lst.size() - 1; i >= 0; i--) {
		  if(unter_array_lst.get(i).getReihe() > 7 || unter_array_lst.get(i).getSpalte() > 7) {
			  unter_array_lst.remove(i);
		
			 
		  }
		  else if(unter_array_lst.get(i).getReihe() < 0 || unter_array_lst.get(i).getSpalte() < 0) {
			  unter_array_lst.remove(i);
			
		  }
		  //hier wird überprüft ob eine andere figur bereits auf diesem feld steht, sollte das der Fall sein fällt diese zug option ebenfalls raus
		  else {
			  for (int j = 0; j < Main_Schach.alle_figuren.size(); j++) {
				 if(unter_array_lst.get(i).equals( Main_Schach.alle_figuren.get(j).getPosition())) {
					 if(SchachGUI.ausgewahlte_figur.getTeam().equals(Main_Schach.alle_figuren.get(j).getTeam())) {
						 unter_array_lst.remove(i);
					 }
					
					 break;
				 }
		  
		}

		

	}
	
}
		return unter_array_lst;

}
}


