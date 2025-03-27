package it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.Extend;

import it.unibs.fp.Planetario.Data.Coordinate;
import it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.CorpoCeleste;

import java.util.ArrayList;

public class Star extends CorpoCeleste {
    private static Star instance = null;
    private ArrayList<Planet> listaPianeti = new ArrayList<>();
    private String systemName;



    private Star(double mass, String nome, ArrayList<Planet> listaPianeti, String systemName) {
        super(mass, new Coordinate(0, 0), nome);
        this.listaPianeti = listaPianeti;
        this.systemName = systemName;
    }

    public static Star createInstance(double mass, String nome, ArrayList<Planet> listaPianeti, String systemName) {
        if (instance == null) instance = new Star(mass, nome, listaPianeti, systemName);

        return instance;
    }

    public static Star getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "FIX ME";
    }
}
