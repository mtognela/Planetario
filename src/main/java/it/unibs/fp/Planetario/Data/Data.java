package it.unibs.fp.Planetario.Data;

public class Data {
    private double mass;
    private Coordinate coordinate;
    private final int ID;

    public Data(double mass, Coordinate coordinate) {
        this.mass = mass;
        this.coordinate = coordinate;
        this.ID = hashCode();
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
}
