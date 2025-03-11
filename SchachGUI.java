package pack1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class SchachGUI extends JFrame {

	// Ein 8x8-Array, das alle Schachbrettfelder (Buttons) enthält.
	private JButton[][] boardButtons = new JButton[8][8];
	private boolean figur_wurde_ausgewahlt = false;
	private List<Position> alle_zuge;
	private int spielt = 0; //0 fur weis und 1 fur schwarz
	static String feld;
	static Figur ausgewahlte_figur;

	// Konstruktor, um das Fenster, das Schachbrett und die zusätzlichen Panels
	// aufzubauen.
	public SchachGUI() {
		setTitle("Schachspiel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Setze das Layout des Hauptfensters auf BorderLayout.
		setLayout(new BorderLayout());

		// -----------------------------
		// Zentrales Panel: Schachbrett
		// -----------------------------
		// Erstelle ein Panel mit einem 8x8 GridLayout für das Schachbrett.
		JPanel boardPanel = new JPanel(new GridLayout(8, 8));
		add(boardPanel, BorderLayout.CENTER);

		// Erstelle alle 64 Felder (Buttons) und füge sie zum Schachbrett-Panel hinzu.
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				JButton button = new JButton();
				button.setPreferredSize(new Dimension(70, 70));

				// Abwechselnde Farben: helle und dunkle Felder
				if ((row + col) % 2 == 0) {
					button.setBackground(Color.LIGHT_GRAY);
				} else {
					button.setBackground(Color.DARK_GRAY);
				}

				// Speichere den Button im Array, damit wir später darauf zugreifen können.
				boardButtons[row][col] = button;
				boardPanel.add(button);

				// Füge einen ActionListener hinzu, der die Position des geklickten Feldes
				// ausgibt.
				final int currentRow = row;
				final int currentCol = col;
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						

						// Berechne die Schachnotation: Spalte a-h und Reihe 1-8.
						char colChar = (char) ('a' + currentCol);
						int rowNumber = 8 - currentRow;
						feld = colChar + "" + rowNumber;

						if (figur_wurde_ausgewahlt == false) {
							int[] temp = Uebersetzter.schach_zu_koords(feld); // wandle z.B. e2 zu 5,1 um
							ausgewahlte_figur = new Move().getFigur(new Position(temp[0], temp[1])); // figur des felds rausfinden
							if (ausgewahlte_figur != null) {
							if (spielt == 0) {
								if(ausgewahlte_figur.getTeam() == "schwarz") {
									System.out.println("es wurde schwarz angeklickt");

									ausgewahlte_figur = null;
								}
								}else if (spielt == 1){
									if(ausgewahlte_figur.getTeam() == "weis") {
										System.out.println("es wurde weis angeklickt");
										ausgewahlte_figur = null;
									}																		
								}
							}
																										
							if (ausgewahlte_figur != null) {
								
								figur_wurde_ausgewahlt = true;

								ausgewahlte_figur.move();
								// hier alle zug moelichkeiten später grafisch anzeigen (koords hier)
								alle_zuge = ausgewahlte_figur.get_move_vorschlage();

								alle_zuge = new Move().eingrenzen_move(alle_zuge, ausgewahlte_figur.getTeam(),
										ausgewahlte_figur.getTyp());

								for (int i = 0; i < alle_zuge.size(); i++) {
									boardButtons[alle_zuge.get(i).getSpalte()][alle_zuge.get(i).getReihe()]
											.setIcon(new ImageIcon("images/vorschlag.png"));
									;
								}

							}
							
						} else if (figur_wurde_ausgewahlt == true) {
							
							Position neue_pos = new Position(Uebersetzter.schach_zu_koords(feld)[0],
									Uebersetzter.schach_zu_koords(feld)[1]);

							for (int i = 0; i < alle_zuge.size(); i++) {
								if (neue_pos.equals(alle_zuge.get(i))) {
									for (int j = 0; j < alle_zuge.size(); j++) {
										boardButtons[alle_zuge.get(j).getSpalte()][alle_zuge.get(j).getReihe()]
												.setIcon(null);
									}
									boardButtons[ausgewahlte_figur.getPosition().getSpalte()][ausgewahlte_figur
											.getPosition().getReihe()].setIcon(null);// entfernen des icon auf alter pos
									ausgewahlte_figur.setPosition(currentRow, currentCol);
									boardButtons[currentRow][currentCol].setIcon(ausgewahlte_figur.getImage());
									repaint();
									figur_wurde_ausgewahlt = false;
									ausgewahlte_figur.set_move_vorschlage(null);
									ausgewahlte_figur = null;
									if(spielt == 1) {
										spielt = 0;
									}else if(spielt == 0){
										spielt = 1;
									}
								} else {
									if(i == alle_zuge.size()) {	
									figur_wurde_ausgewahlt = true;
									}
								}
							}
							
							
						}

					}
				});
			}
		}

		// Setze die Schachfiguren (Bilder) auf die entsprechenden Felder.
		setChessPieces();

		// -----------------------------
		// Linkes Panel: Platz für zukünftige Elemente
		// -----------------------------
		JPanel leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(100, 600));
		leftPanel.setBackground(Color.WHITE);
		add(leftPanel, BorderLayout.WEST);

		// -----------------------------
		// Rechtes Panel: Platz für zukünftige Elemente
		// -----------------------------
		JPanel rightPanel = new JPanel();
		rightPanel.setPreferredSize(new Dimension(100, 600));
		rightPanel.setBackground(Color.WHITE);
		add(rightPanel, BorderLayout.EAST);

		// Versetzt das Fenster in den Vollbildmodus.

		// setUndecorated(true); //entfernt den Titelbalken.
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		// Entferne den Fensterrahmen (optional, falls du wirklich "Vollbild" ohne
		// Rahmen möchtest)
		// setUndecorated(true);

		// Zentriere das Fenster (dieser Schritt ist im Vollbildmodus meist redundant).
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// Methode, um die Schachfiguren als Icons (Bilder) auf dem Brett zu platzieren.

	private void setChessPieces() {
		// -----------------------------
		// Schwarze Figuren (oben)
		// -----------------------------
		boardButtons[0][0].setIcon(new ImageIcon("images/br.png"));
		boardButtons[0][1].setIcon(new ImageIcon("images/bn.png"));
		boardButtons[0][2].setIcon(new ImageIcon("images/bb.png"));
		boardButtons[0][3].setIcon(new ImageIcon("images/bq.png"));
		boardButtons[0][4].setIcon(new ImageIcon("images/bk.png"));
		boardButtons[0][5].setIcon(new ImageIcon("images/bb.png"));
		boardButtons[0][6].setIcon(new ImageIcon("images/bn.png"));
		boardButtons[0][7].setIcon(new ImageIcon("images/br.png"));
		for (int col = 0; col < 8; col++) {
			boardButtons[1][col].setIcon(new ImageIcon("images/bp.png"));
		}

		// -----------------------------
		// Weiße Figuren (unten)
		// -----------------------------
		boardButtons[7][0].setIcon(new ImageIcon("images/wr.png"));
		boardButtons[7][1].setIcon(new ImageIcon("images/wn.png"));
		boardButtons[7][2].setIcon(new ImageIcon("images/wb.png"));
		boardButtons[7][3].setIcon(new ImageIcon("images/wq.png"));
		boardButtons[7][4].setIcon(new ImageIcon("images/wk.png"));
		boardButtons[7][5].setIcon(new ImageIcon("images/wb.png"));
		boardButtons[7][6].setIcon(new ImageIcon("images/wn.png"));
		boardButtons[7][7].setIcon(new ImageIcon("images/wr.png"));
		for (int col = 0; col < 8; col++) {
			boardButtons[6][col].setIcon(new ImageIcon("images/wp.png"));
		}
	}

}
