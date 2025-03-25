package it.unibs.fp.Planetario.Data;

public class Mass {
    private double mass;

    Mass(double mass) {
        this.mass = mass;
    }

    public double getMass() {
        return mass;
    }

    public void updateMass(double update) {
        this.mass += update;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
