package it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.Extend;

import it.unibs.fp.Planetario.Data.Coordinate;
import it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.CorpoCeleste;

public class Star extends CorpoCeleste {
    private static Star instance = null;

    public Star(double mass, String nome) {
        super(mass, new Coordinate(0, 0), nome);
    }

   public static Star createInstance(double mass, String nome) {
        if (instance == null) instance = new Star(mass, nome);
        return instance;
   }

   public static Star getInstance() {
        return instance;
   }

    public static String getInstanceName() {
        return instance.getName();
    }

    public static double getInstanceMass() {
        return instance.getMass();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
