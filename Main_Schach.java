package pack1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingUtilities;

public class Main_Schach {

	
	static String temp_schach_getted_pos = "e2";
	static List<Figur> alle_figuren = new ArrayList<>();
	public Main_Schach() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<Figur> bauernweis = new ArrayList<>();
		List<Figur> bauernschwarz = new ArrayList<>();
		

		Figur bauer_weis_temp = null;
		Figur bauer_schwarz_temp = null;
		Figur turm_weis = null;
		Figur turm_schwarz = null;
		Figur pferd_weis = null;
		Figur pferd_schwarz = null;
		Figur laufer_weis = null;
		Figur laufer_schwarz = null;

		// Bauern
		for (int i = 0; i < 8; i++) {
			Position start_pos = new Position(i, 1);
			bauer_weis_temp = new Figur("bauer", start_pos);
			bauer_weis_temp.setTeam("weiß");
			bauernweis.add(bauer_weis_temp);
			alle_figuren.add(bauer_weis_temp);

			


		}

		for (int i = 0; i < 8; i++) {
			Position start_pos = new Position(i, 6);
			bauer_schwarz_temp = new Figur("bauer", start_pos);
			bauer_schwarz_temp.setTeam("schwarz");
			bauernschwarz.add(bauer_schwarz_temp);
			alle_figuren.add(bauer_schwarz_temp);

		}

		
		// Türme
		Position[] turm_positions = { new Position(0, 0), new Position(7, 0), new Position(0, 7), new Position(7, 7) };
		for (int i = 0; i < 2; i++) {
			turm_weis = new Figur("turm", turm_positions[i]);
			turm_weis.setTeam("weiß");
			alle_figuren.add(turm_weis);

		}
		for (int i = 2; i < 4; i++) {
			turm_schwarz = new Figur("turm", turm_positions[i]);
			turm_schwarz.setTeam("schwarz");
			alle_figuren.add(turm_schwarz);

		}

		// Pferde
		Position[] pferd_positions = { new Position(1, 0), new Position(6, 0), new Position(1, 7), new Position(6, 7) };
		for (int i = 0; i < 2; i++) {
			pferd_weis = new Figur("pferd", pferd_positions[i]);
			pferd_weis.setTeam("weiß");
			alle_figuren.add(pferd_weis);

		}
		for (int i = 2; i < 4; i++) {
			pferd_schwarz = new Figur("pferd", pferd_positions[i]);
			pferd_schwarz.setTeam("schwarz");
			alle_figuren.add(pferd_schwarz);

		}

		// Läufer
		Position[] laufer_positions = { new Position(2, 0), new Position(5, 0), new Position(2, 7),
				new Position(5, 7) };
		for (int i = 0; i < 2; i++) {
			laufer_weis = new Figur("laufer", laufer_positions[i]);
			laufer_weis.setTeam("weiß");
			alle_figuren.add(laufer_weis);

		}
		for (int i = 2; i < 4; i++) {
			laufer_schwarz = new Figur("laufer", laufer_positions[i]);
			laufer_schwarz.setTeam("schwarz");
			alle_figuren.add(laufer_schwarz);

		}

		// Damen
		Figur dame_weis = new Figur("dame", new Position(3, 0));
		dame_weis.setTeam("weiß");
		alle_figuren.add(dame_weis);

		Figur dame_schwarz = new Figur("dame", new Position(3, 7));
		dame_schwarz.setTeam("schwarz");
		alle_figuren.add(dame_weis);

		// Könige
		Figur koenig_weis = new Figur("konig", new Position(4, 0));
		koenig_weis.setTeam("weiß");
		alle_figuren.add(koenig_weis);

		Figur koenig_schwarz = new Figur("konig", new Position(4, 7));
		koenig_schwarz.setTeam("schwarz");
		alle_figuren.add(koenig_schwarz);
		
		
		
		/////////////////////////////////////
		   SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	        		new SchachGUI();
	        		
	            }
	        });
		   
		  

				  
			
			
		   
		
		
			
		
		

		
		
		
		
	}

}
