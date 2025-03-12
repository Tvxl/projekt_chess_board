package pack1;


//Pos Klasse wird verwendendt um das Progamm einfacher zu programmieren, so können positionen dirket bestimmt werden und man verzichtet auf int[]
public class Position {
    private int reihe;
    private int spalte;

    public Position(int reihe, int spalte) {
        this.reihe = reihe;
        this.spalte = spalte;
    }

    public int getSpalte() {
        return spalte;
    }

    public void setSpalte(int spalte) {
        this.spalte = spalte;
    }

    public int getReihe() {
        return reihe;
    }

    public Position setReihe(int reihe) {
        this.reihe = reihe;
		return null;
    }
    @Override
    public String toString() {
        return  reihe + ", " + spalte;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return reihe == position.reihe && spalte == position.spalte;
    }

    @Override
    public int hashCode() {
        return 31 * reihe + spalte;
    }

}
