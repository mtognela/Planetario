package it.unibs.fp.Planetario.CorpoCeleste;

import it.unibs.fp.Planetario.Data.Coordinate;

public class Moon extends CorpoCeleste {
   private final Planet pianetaRif;

    public Moon(double mass, Coordinate coordinate, String nome, Planet pianetaRif) {
        super(mass, coordinate, nome);
        this.pianetaRif = pianetaRif;
    }

    public String toString() {
        return super.toString() + "Moon{" + "pianetaRif=" + pianetaRif + '}';
    }

    public Planet getPianetaRif() {
        return pianetaRif;
    }


}
