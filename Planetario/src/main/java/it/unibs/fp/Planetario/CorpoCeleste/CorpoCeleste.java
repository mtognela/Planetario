package it.unibs.fp.Planetario.CorpoCeleste;

import it.unibs.fp.Planetario.Data.*;

public class CorpoCeleste extends Data {
    private String nome;

    public CorpoCeleste(Mass mass, Coordinate coordinate, String nome) {
        super(mass, coordinate);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return super.toString() + "Nome: " + nome;
    }
}
