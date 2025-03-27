package it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.Extend;

import it.unibs.fp.Planetario.Data.Coordinate;
import it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.CorpoCeleste;

public class Moon extends CorpoCeleste {
   private final Planet pianetaRif;
   private final String path;

    public Moon(double mass, Coordinate coordinate, String nome, Planet pianetaRif) {
        super(mass, coordinate, nome);
        this.pianetaRif = pianetaRif;
        this.path = buildpath();
    }

    private String buildpath() {
        return Star.getInstanceName() + " > " + pianetaRif.getName() + " > " + super.nome;
    }

    public String toString() {
        return super.toString() + "Moon{" + "pianetaRif=" + pianetaRif + '}';
    }

    public Planet getPianetaRif() {
        return pianetaRif;
    }

    public String getPath() {
        return path;
    }
}
