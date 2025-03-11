package pack1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;

public class Figur {

	private Position position;
	private String team;
	private String typ;
	private List<Position> move_vorschlage = new ArrayList<>();
	private boolean first_move;
	private ImageIcon image;
	
	 public Figur(String typ_input,Position pos, ImageIcon img) {
	        this.typ = typ_input;
	    	this.position = pos;
	    	this.image = img;
	    	
	    }
	 

	    public void move() {
	        switch (typ) {
	            case "bauer":
	            	move_vorschlage.add(new Position(this.getPosition().getReihe(), this.getPosition().getSpalte()+1));
	            	move_vorschlage.add(new Position(this.getPosition().getReihe(), this.getPosition().getSpalte()-1));
	            	if(first_move == false){
	            		move_vorschlage.add(new Position(this.getPosition().getReihe(), this.getPosition().getSpalte()+2));
	            		move_vorschlage.add(new Position(this.getPosition().getReihe(), this.getPosition().getSpalte()-2));
	            	}
	            	move_vorschlage.add(new Position(this.getPosition().getReihe()+1, this.getPosition().getSpalte()-1));
	            	move_vorschlage.add(new Position(this.getPosition().getReihe()+1, this.getPosition().getSpalte()+1));
	            	move_vorschlage.add(new Position(this.getPosition().getReihe()-1, this.getPosition().getSpalte()-1));
	            	move_vorschlage.add(new Position(this.getPosition().getReihe()-1, this.getPosition().getSpalte()+1));
	            	
	                break;
	            case "turm":
	              for (int i = 1; i < 8; i++) {
	            	  move_vorschlage.add(new Position(this.getPosition().getReihe()+i, this.getPosition().getSpalte()));
	            	  move_vorschlage.add(new Position(this.getPosition().getReihe(), this.getPosition().getSpalte()+i));
	            	  move_vorschlage.add(new Position(this.getPosition().getReihe()-i, this.getPosition().getSpalte()));
	            	  move_vorschlage.add(new Position(this.getPosition().getReihe(), this.getPosition().getSpalte()-i));
				}
	                break;
	            case "pferd":
	            	 move_vorschlage.add(new Position(this.getPosition().getReihe()+2, this.getPosition().getSpalte()+1));
	            	  move_vorschlage.add(new Position(this.getPosition().getReihe()+2, this.getPosition().getSpalte()-1));
	            	  move_vorschlage.add(new Position(this.getPosition().getReihe()-2, this.getPosition().getSpalte()+1));
	            	  move_vorschlage.add(new Position(this.getPosition().getReihe()-2, this.getPosition().getSpalte()-1));
	            	  
	            	  move_vorschlage.add(new Position(this.getPosition().getReihe()+1, this.getPosition().getSpalte()+2));
	            	  move_vorschlage.add(new Position(this.getPosition().getReihe()-1, this.getPosition().getSpalte()+2));
	            	  move_vorschlage.add(new Position(this.getPosition().getReihe()+1, this.getPosition().getSpalte()-2));
	            	  move_vorschlage.add(new Position(this.getPosition().getReihe()-1, this.getPosition().getSpalte()-2));
	            	  
	                break;
	            case "laufer":
	            	for (int i = 0; i < 8; i++) {
	            		 move_vorschlage.add(new Position(this.getPosition().getReihe()+i, this.getPosition().getSpalte()+i));
	            		 move_vorschlage.add(new Position(this.getPosition().getReihe()-i, this.getPosition().getSpalte()-i));
	            		 move_vorschlage.add(new Position(this.getPosition().getReihe()-i, this.getPosition().getSpalte()+i));
	            		 move_vorschlage.add(new Position(this.getPosition().getReihe()+i, this.getPosition().getSpalte()-i));
					}
	                break;
	            case "dame":
	            	for (int i = 0; i < 8; i++) {
	            		 move_vorschlage.add(new Position(this.getPosition().getReihe()+i, this.getPosition().getSpalte()+i));
	            		 move_vorschlage.add(new Position(this.getPosition().getReihe()-i, this.getPosition().getSpalte()-i));
	            		 move_vorschlage.add(new Position(this.getPosition().getReihe()-i, this.getPosition().getSpalte()+i));
	            		 move_vorschlage.add(new Position(this.getPosition().getReihe()+i, this.getPosition().getSpalte()-i));
	            		 
					}
	            	for (int i = 0; i < 8; i++) {
		            	  move_vorschlage.add(new Position(this.getPosition().getReihe()+i, this.getPosition().getSpalte()));
		            	  move_vorschlage.add(new Position(this.getPosition().getReihe(), this.getPosition().getSpalte()+i));
		            	  move_vorschlage.add(new Position(this.getPosition().getReihe()-i, this.getPosition().getSpalte()));
		            	  move_vorschlage.add(new Position(this.getPosition().getReihe(), this.getPosition().getSpalte()-i));
					}
	                break;
	            case "konig":
	            	
		            	  move_vorschlage.add(new Position(this.getPosition().getReihe()+1, this.getPosition().getSpalte())); //oben
		            	  move_vorschlage.add(new Position(this.getPosition().getReihe(), this.getPosition().getSpalte()+1)); //rechts
		            	  move_vorschlage.add(new Position(this.getPosition().getReihe()+1, this.getPosition().getSpalte()+1)); //oben rechts
		            	  move_vorschlage.add(new Position(this.getPosition().getReihe()-1, this.getPosition().getSpalte()+1)); //unten rechts
		            	  move_vorschlage.add(new Position(this.getPosition().getReihe()-1, this.getPosition().getSpalte()-1)); // unten links
		            	  move_vorschlage.add(new Position(this.getPosition().getReihe()-1, this.getPosition().getSpalte())); //unten
		            	  move_vorschlage.add(new Position(this.getPosition().getReihe(), this.getPosition().getSpalte()-1)); //links
		            	  move_vorschlage.add(new Position(this.getPosition().getReihe()+1, this.getPosition().getSpalte()-1)); // oben links
		            	  move_vorschlage.add(new Position(this.getPosition().getReihe()-1, this.getPosition().getSpalte())); // unten
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
	public void set_move_vorschlage(List<Position> mv) {
		this.move_vorschlage = mv;
	    
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


	public ImageIcon getImage() {
		return image;
	}


	



}
