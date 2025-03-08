package pack1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Figur {

	private Position position;
	private String team;
	private String typ;
	private List<Position> move_vorschlage = new ArrayList<>();
	private boolean first_move;
	
	 public Figur(String typ_input,Position pos) {
	        this.typ = typ_input;
	    	this.position = pos;
	    	
	    }
	 

	    public void move() {
	        switch (typ) {
	            case "bauer":
	            	this.getPosition();
	            	move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()+1, this.getPosition().getReihe()));
	            	move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()-1, this.getPosition().getReihe()));
	            	if(first_move == false){
	            		move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()+2, this.getPosition().getReihe()));
	            		move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()-2, this.getPosition().getReihe()));
	            	}
	            	move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()+1, this.getPosition().getReihe()-1));
	            	move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()+1, this.getPosition().getReihe()+1));
	            	move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()-1, this.getPosition().getReihe()-1));
	            	move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()-1, this.getPosition().getReihe()+1));
	            	
	                break;
	            case "turm":
	              for (int i = 0; i < 8; i++) {
	            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()+i, this.getPosition().getReihe()));
	            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte(), this.getPosition().getReihe()+i));
	            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()-i, this.getPosition().getReihe()));
	            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte(), this.getPosition().getReihe()-i));
				}
	                break;
	            case "pferd":
	            	 move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()+2, this.getPosition().getReihe()+1));
	            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()+2, this.getPosition().getReihe()-1));
	            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()-2, this.getPosition().getReihe()+1));
	            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()-2, this.getPosition().getReihe()-1));
	            	  
	            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()+1, this.getPosition().getReihe()+2));
	            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()-1, this.getPosition().getReihe()+2));
	            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()+1, this.getPosition().getReihe()-2));
	            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()-1, this.getPosition().getReihe()-2));
	            	  
	                break;
	            case "laufer":
	            	for (int i = 0; i < 8; i++) {
	            		 move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()+1, this.getPosition().getReihe()+1));
	            		 move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()-1, this.getPosition().getReihe()-1));
	            		 move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()-1, this.getPosition().getReihe()+1));
	            		 move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()+1, this.getPosition().getReihe()-1));
					}
	                break;
	            case "dame":
	            	for (int i = 0; i < 8; i++) {
	            		 move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()+1, this.getPosition().getReihe()+1));
	            		 move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()-1, this.getPosition().getReihe()-1));
	            		 move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()-1, this.getPosition().getReihe()+1));
	            		 move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()+1, this.getPosition().getReihe()-1));
	            		 
					}
	            	for (int i = 0; i < 8; i++) {
		            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()+i, this.getPosition().getReihe()));
		            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte(), this.getPosition().getReihe()+i));
		            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()-i, this.getPosition().getReihe()));
		            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte(), this.getPosition().getReihe()-i));
					}
	                break;
	            case "konig":
	            	
		            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()+1, this.getPosition().getReihe())); //oben
		            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte(), this.getPosition().getReihe()+1)); //rechts
		            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()+1, this.getPosition().getReihe()+1)); //oben rechts
		            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()-1, this.getPosition().getReihe()+1)); //unten rechts
		            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()-1, this.getPosition().getReihe()-1)); // unten links
		            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()-1, this.getPosition().getReihe())); //unten
		            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte(), this.getPosition().getReihe()-1)); //links
		            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()+1, this.getPosition().getReihe()-1)); // oben links
		            	  move_vorschlage.add(this.setPosition(this.getPosition().getSpalte()-1, this.getPosition().getReihe())); // unten
	                break;
	            default:
	                throw new IllegalStateException("Unbekannter Typ: " + typ);
	                
	        }
	    }



	public Position getPosition() {
		return position;
	}
	
	public String getTyp() {
		return this.typ;
		
	}
	
	public List<Position> get_move_vorschlage() {
		return move_vorschlage;
		
	}
	public void set_move_vorschlage_null(List<Position> move_vorschlage_null) {
	    move_vorschlage_null.clear(); 
	}

	


	public Position setPosition(int x, int y) {
		return this.position = new Position(x, y);
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	



}
