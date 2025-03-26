package it.unibs.fp.Planetario.CorpoCeleste;

import it.unibs.fp.Planetario.Data.Coordinate;
import it.unibs.fp.Planetario.Data.Mass;

public final class Star extends CorpoCeleste {
    public final boolean ISSTAR;

    public Star(double mass, Coordinate coordinate, String nome, boolean ISSTAR) {
        super(mass, coordinate, nome);
        this.ISSTAR = ISSTAR;
    }

    @Override
    public String toString() {
        return super.toString() + "Star{ ISSTAR=" + ISSTAR + '}';
    }
}
