package it.unibs.fp.Planetario.Data;

public class Data {
    private Mass mass;
    private Coordinate coordinate;
    private final int ID;

    public Data(Mass mass, Coordinate coordinate) {
        this.mass = mass;
        this.coordinate = coordinate;
        this.ID = hashCode();
    }

    public Mass getMass() {
        return mass;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getID() {
        return ID;
    }
}
