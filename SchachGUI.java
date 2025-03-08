package pack1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SchachGUI extends JFrame {

    // Ein 8x8-Array, das alle Schachbrettfelder (Buttons) enthält.
    private JButton[][] boardButtons = new JButton[8][8];
    static boolean angeklickt = false;
    static String feld;

    // Konstruktor, um das Fenster, das Schachbrett und die zusätzlichen Panels aufzubauen.
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

                // Füge einen ActionListener hinzu, der die Position des geklickten Feldes ausgibt.
                final int currentRow = row;
                final int currentCol = col;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Berechne die Schachnotation: Spalte a-h und Reihe 1-8.
                        char colChar = (char) ('a' + currentCol);
                        int rowNumber = 8 - currentRow;
                        feld = colChar + "" + rowNumber;
                        angeklickt = true;
                       
                       int[] temp = Uebersetzter.schach_zu_koords(feld); //wandle z.B. e2 zu 5,1 um
              		  Figur ausgewahlte_figur = new Move().getFigur(new Position(temp[0], temp[1])); //figur der feld koordinate rausfinden
              		   ausgewahlte_figur.move();
              		   System.out.println(ausgewahlte_figur.get_move_vorschlage());

                      
        

                    }
                });
            }
        }

        // Setze die Schachfiguren (Bilder) auf die entsprechenden Felder.
       // setChessPieces();

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
        // setExtendedState() maximiert das Fenster, und setUndecorated(true) entfernt den Titelbalken.
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Entferne den Fensterrahmen (optional, falls du wirklich "Vollbild" ohne Rahmen möchtest)
        // setUndecorated(true);

        // Zentriere das Fenster (dieser Schritt ist im Vollbildmodus meist redundant).
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Methode, um die Schachfiguren als Icons (Bilder) auf dem Brett zu platzieren.
    /*
    private void setChessPieces() {
        // -----------------------------
        // Schwarze Figuren (oben)
        // -----------------------------
        boardButtons[0][0].setIcon(new ImageIcon("images/b_rook.png"));
        boardButtons[0][1].setIcon(new ImageIcon("images/b_knight.png"));
        boardButtons[0][2].setIcon(new ImageIcon("images/b_bishop.png"));
        boardButtons[0][3].setIcon(new ImageIcon("images/b_queen.png"));
        boardButtons[0][4].setIcon(new ImageIcon("images/b_king.png"));
        boardButtons[0][5].setIcon(new ImageIcon("images/b_bishop.png"));
        boardButtons[0][6].setIcon(new ImageIcon("images/b_knight.png"));
        boardButtons[0][7].setIcon(new ImageIcon("images/b_rook.png"));
        for (int col = 0; col < 8; col++) {
            boardButtons[1][col].setIcon(new ImageIcon("images/b_pawn.png"));
        }

        // -----------------------------
        // Weiße Figuren (unten)
        // -----------------------------
        boardButtons[7][0].setIcon(new ImageIcon("images/w_rook.png"));
        boardButtons[7][1].setIcon(new ImageIcon("images/w_knight.png"));
        boardButtons[7][2].setIcon(new ImageIcon("images/w_bishop.png"));
        boardButtons[7][3].setIcon(new ImageIcon("images/w_queen.png"));
        boardButtons[7][4].setIcon(new ImageIcon("images/w_king.png"));
        boardButtons[7][5].setIcon(new ImageIcon("images/w_bishop.png"));
        boardButtons[7][6].setIcon(new ImageIcon("images/w_knight.png"));
        boardButtons[7][7].setIcon(new ImageIcon("images/w_rook.png"));
        for (int col = 0; col < 8; col++) {
            boardButtons[6][col].setIcon(new ImageIcon("images/w_pawn.png"));
        }
    }
*/
    // Hauptmethode zum Starten der Anwendung.
}
