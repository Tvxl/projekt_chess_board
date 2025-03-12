package pack1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class SchachGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Ein 8x8-Array, das alle Schachbrettfelder (Buttons) enthält.
	private JButton[][] boardButtons = new JButton[8][8];
	private boolean figur_wurde_ausgewahlt = false;
	private List<Position> alle_zuge;
	static boolean matt = false;
	private int spielt = 0; // 0 fur weis und 1 fur schwarz
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
						///////// Beginn Spiellogik/////////////////
						if (figur_wurde_ausgewahlt == false) { // es müssen zwei felder ausgewählt werden, hier wird
																// zuerst überprüft ob ein fig feld ausgewählt wurde
							int[] temp = Uebersetzter.schach_zu_koords(feld); // wandle z.B. e2 zu 5,1 um
							ausgewahlte_figur = new Move().getFigur(new Position(temp[0], temp[1])); // figur des felds
																										// rausfinden
							if (ausgewahlte_figur != null) { // prüfen ob fig auf feld ist
								// teams spielen tauschen und blockieren
								if (spielt == 0) {
									if (ausgewahlte_figur.getTeam() == "schwarz") {
										System.out.println("es wurde schwarz angeklickt");

										ausgewahlte_figur = null;
									}
								} else if (spielt == 1) {
									if (ausgewahlte_figur.getTeam() == "weis") {
										System.out.println("es wurde weis angeklickt");
										ausgewahlte_figur = null;
									}
								}
							}

							if (ausgewahlte_figur != null) { // prüfen ob fig auf feld ist

								figur_wurde_ausgewahlt = true; // ändern des bools um nach if zweiten feld zugriff
																// möglich zu machen

								ausgewahlte_figur.move();
								// hier alle zug moelichkeiten später grafisch anzeigen (koords hier)
								alle_zuge = ausgewahlte_figur.get_move_vorschlage();
								System.out.println(alle_zuge);

								alle_zuge = new Move().eingrenzen_move(alle_zuge, ausgewahlte_figur.getTeam(),
										ausgewahlte_figur.getTyp());
								if (alle_zuge.size() == 0) {
									figur_wurde_ausgewahlt = false;
								}
								System.out.println(alle_zuge);

							}

						} else if (figur_wurde_ausgewahlt == true) { // ziel feld überprüfung

							Position neue_pos = new Position(Uebersetzter.schach_zu_koords(feld)[0], // neue pos
																										// erstellen
									Uebersetzter.schach_zu_koords(feld)[1]);

							for (int i = 0; i < alle_zuge.size(); i++) {
								if (neue_pos.equals(alle_zuge.get(i))) { // gucken ob neue pos in möglichkeit der figur
										//bauern zwei zuge entfernen									// liegt
									if(ausgewahlte_figur.getTyp().equals("bauer")) {
										ausgewahlte_figur.setfirstmove(true);
									}
									for (int j = 0; j < Main_Schach.alle_figuren.size(); j++) { // updaten der
																								// alle_figuren liste
										if (ausgewahlte_figur.equals(Main_Schach.alle_figuren.get(j))) {
											Main_Schach.alle_figuren.remove(j);
											Main_Schach.alle_figuren.add(ausgewahlte_figur);
										}
									}
									// schalg uberprufung
									for (int j = 0; j < Main_Schach.alle_figuren.size(); j++) {
										if (neue_pos.equals(Main_Schach.alle_figuren.get(j).getPosition())) {
											if (Main_Schach.alle_figuren.get(j).getTyp().equals("konig")) {
												// matt uberprufung und reset des feldes

												for (int k = 0; k < Main_Schach.alle_figuren.size(); k++) {
													Main_Schach.alle_figuren.set(k, null);
												}
												Main_Schach.alle_figuren.clear();
												for (int k = 0; k < 8; k++) {
													for (int l = 0; l < 8; l++) {
														boardButtons[k][l].setIcon(null);
													}

												}
												matt = true;
												spielt = 1;
												setChessPieces();
												new Main_Schach();
												break;

											}
											Main_Schach.alle_figuren.set(j, null); // aus feld rauswerfen
											Main_Schach.alle_figuren.remove(j);

										}
									}

									if (matt == false) {
										boardButtons[ausgewahlte_figur.getPosition().getSpalte()][ausgewahlte_figur
												.getPosition().getReihe()].setIcon(null);// entfernen des icon auf alter
																							// pos
										ausgewahlte_figur.setPosition(currentCol, currentRow);
										boardButtons[currentRow][currentCol].setIcon(ausgewahlte_figur.getImage()); // icon
																													// //
																													// setzten
										repaint();
									} else {
										matt = false;
									}
									// vars nach möglichkeit zurück setzten
									figur_wurde_ausgewahlt = false;
									// ausgewahlte_figur = null;
									// team tausch
									if (spielt == 1) {
										spielt = 0;
										System.out.println("0");

									} else if (spielt == 0) {
										spielt = 1;
										System.out.println("1");

									}
								} else {
									for (int j = 0; j < Main_Schach.alle_figuren.size(); j++) {
										// überprüfen ob figuren wechsel gewollt ist
										if (neue_pos.equals(Main_Schach.alle_figuren.get(j).getPosition())) {
											if (spielt == 0
													&& Main_Schach.alle_figuren.get(j).getTeam().equals("weis")) {
												ausgewahlte_figur = Main_Schach.alle_figuren.get(j);
												figur_wurde_ausgewahlt = false;
											} else if (spielt == 1
													&& Main_Schach.alle_figuren.get(j).getTeam().equals("schwarz")) {
												ausgewahlte_figur = Main_Schach.alle_figuren.get(j);
												figur_wurde_ausgewahlt = false;

											}
										}
									}
									// fehlerhafte feld eingabe ignorieren, warte auf richtige
									if (i == alle_zuge.size()) {
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
		boardButtons[0][0].setIcon(new ImageIcon(getClass().getResource("/images/br.png")));
		boardButtons[0][1].setIcon(new ImageIcon(getClass().getResource("/images/bn.png")));
		boardButtons[0][2].setIcon(new ImageIcon(getClass().getResource("/images/bb.png")));
		boardButtons[0][3].setIcon(new ImageIcon(getClass().getResource("/images/bq.png")));
		boardButtons[0][4].setIcon(new ImageIcon(getClass().getResource("/images/bk.png")));
		boardButtons[0][5].setIcon(new ImageIcon(getClass().getResource("/images/bb.png")));
		boardButtons[0][6].setIcon(new ImageIcon(getClass().getResource("/images/bn.png")));
		boardButtons[0][7].setIcon(new ImageIcon(getClass().getResource("/images/br.png")));
		for (int col = 0; col < 8; col++) {
			boardButtons[1][col].setIcon(new ImageIcon(getClass().getResource("/images/bp.png")));
		}

		// -----------------------------
		// Weiße Figuren (unten)
		// -----------------------------
		boardButtons[7][0].setIcon(new ImageIcon(getClass().getResource("/images/wr.png")));
		boardButtons[7][1].setIcon(new ImageIcon(getClass().getResource("/images/wn.png")));
		boardButtons[7][2].setIcon(new ImageIcon(getClass().getResource("/images/wb.png")));
		boardButtons[7][3].setIcon(new ImageIcon(getClass().getResource("/images/wq.png")));
		boardButtons[7][4].setIcon(new ImageIcon(getClass().getResource("/images/wk.png")));
		boardButtons[7][5].setIcon(new ImageIcon(getClass().getResource("/images/wb.png")));
		boardButtons[7][6].setIcon(new ImageIcon(getClass().getResource("/images/wn.png")));
		boardButtons[7][7].setIcon(new ImageIcon(getClass().getResource("/images/wr.png")));
		for (int col = 0; col < 8; col++) {
			boardButtons[6][col].setIcon(new ImageIcon(getClass().getResource("/images/wp.png")));
		}
	}

}
