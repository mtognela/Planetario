package it.unibs.fp.Planetario.CorpoCeleste;

import it.unibs.fp.Planetario.Data.Coordinate;

public class Moon extends CorpoCeleste {
   private final Planet pianetaRif;
   private final Star starRif;
   private final String path;

    public Moon(double mass, Coordinate coordinate, String nome, Planet pianetaRif, Star starRif) {
        super(mass, coordinate, nome);
        this.pianetaRif = pianetaRif;
        this.starRif = starRif;
        this.path = buildpath();
    }

    private String buildpath() {
        return starRif.getName() + " > " + pianetaRif.getName() + " > " + super.nome;
    }

    public String toString() {
        return super.toString() + "Moon{" + "pianetaRif=" + pianetaRif + '}';
    }

    public Planet getPianetaRif() {
        return pianetaRif;
    }

    public Star getStarRif() {
        return starRif;
    }

    public String getPath() {
        return path;
    }

}
