package it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.Extend;

import it.unibs.fp.Planetario.Data.Coordinate;
import it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.CorpoCeleste;

public class Star extends CorpoCeleste {
    private static Star instance = null;

    private Star(double mass, String nome) {
        super(mass, new Coordinate(0, 0), nome);
    }

    public static Star createInstance(double mass, String nome) {
        if (instance == null) instance = new Star(mass, nome);
        else throw new IllegalStateException("Star instance already created!");

        return instance;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
