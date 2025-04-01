package org.Arch.IsTheBest.Planetarium.System.CorpoCeleste;

import com.kibo.pgar.lib.AnsiColors;
import com.kibo.pgar.lib.PrettyStrings;
import org.Arch.IsTheBest.Planetarium.Data.Coordinate;

public  abstract  class CorpoCeleste {
    private String nome;
    private double mass;
    private Coordinate coordinate;
    private final int ID;

    public CorpoCeleste(double mass, Coordinate coordinate, String nome) {
        this.mass = mass;
        this.nome = nome;
        this.coordinate = coordinate;
        this.ID = hashCode();
    }

    public CorpoCeleste(double mass, double radius, double theta, String nome ) {
        this.mass = mass;
        this.coordinate = new Coordinate(radius,theta);
        this.nome = nome;
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

    public double distanceAss(){
        return coordinate.distanceAss();
    }

    public double distanceFrom(Coordinate c) {
        return coordinate.distanceFrom(c);
    }

    public double getX(){
        return coordinate.getX();
    }

    public double getY(){
        return coordinate.getY();
    }

    public double getRADIUS(){
        return coordinate.getRADIUS();
    }

    public double getTheta(){
        return coordinate.getTHETA();
    }

    public int getID() {
        return ID;
    }

    public String getIDString() {
        return Integer.toString(ID);
    }

    @Override
    public String toString() {
        return PrettyStrings.
                prettify(String.format("Mass = %f, %s, Nome %s, ID = %d", mass, coordinate.toString(), nome, this.ID), AnsiColors.CYAN, null,  null);
    }
}
