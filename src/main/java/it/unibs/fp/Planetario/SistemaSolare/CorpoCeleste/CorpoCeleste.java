package it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste;

import it.unibs.fp.Planetario.Data.*;

public  abstract  class CorpoCeleste {
    private final String nome;
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
        return mass + " " + coordinate.toString() + " " + ID;
    }
}
