package org.Arch.IsTheBest.Planetarium.SistemaSolare.CorpoCeleste;

import com.kibo.pgar.lib.AnsiColors;
import com.kibo.pgar.lib.PrettyStrings;
import org.Arch.IsTheBest.Planetarium.Data.Coordinate;

public  abstract  class CorpoCeleste {
    private String nome;
    private double mass;
    private Coordinate coordinate;
    private final int ID;

    public CorpoCeleste(double mass, Coordinate coordinate, String nome) {
        this.nome = nome;
        this.coordinate = coordinate;
        this.ID = hashCode();
    }

    public String getName() {
        return nome;
    }

    public double getMass() {
        return mass;
    }

    public void updateMass(double update) {
        this.mass += update;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getID() {
        return ID;
    }

    public String getIDString() {
        return Integer.toString(ID);
    }

    @Override
    public String toString() {
        return PrettyStrings.prettify(String.format("%f %s %d", mass, coordinate.toString(), this.ID), AnsiColors.CYAN, null,  null);
    }
}
