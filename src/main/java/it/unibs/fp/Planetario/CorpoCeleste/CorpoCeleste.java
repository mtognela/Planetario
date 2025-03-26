package it.unibs.fp.Planetario.CorpoCeleste;

import it.unibs.fp.Planetario.Data.*;

public class CorpoCeleste extends Data {
    String nome;

    public CorpoCeleste(double mass, Coordinate coordinate, String nome) {
        super(mass, coordinate);
        this.nome = nome;
    }

    public String getName() {
        return nome;
    }

    @Override
    public String toString() {
        return super.toString() + "Nome: " + nome;
    }
}
