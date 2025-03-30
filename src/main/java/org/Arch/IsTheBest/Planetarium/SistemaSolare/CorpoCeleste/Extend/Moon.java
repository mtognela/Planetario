package org.Arch.IsTheBest.Planetarium.SistemaSolare.CorpoCeleste.Extend;

import com.kibo.pgar.lib.AnsiColors;
import com.kibo.pgar.lib.PrettyStrings;
import org.Arch.IsTheBest.Planetarium.Data.Coordinate;
import org.Arch.IsTheBest.Planetarium.SistemaSolare.CorpoCeleste.CorpoCeleste;

public class Moon extends CorpoCeleste {
   private final Planet pianetaRif;
   private final String path;

    public Moon(double mass, Coordinate coordinate, String nome, Planet pianetaRif) {
        super(mass, Coordinate.convertToAbsolute(coordinate, pianetaRif), nome);
        this.pianetaRif = pianetaRif;
        this.path = buildpath();
    }

    private String buildpath() {
        return Star.getInstanceName() + " > " + pianetaRif.getName() + " > " + super.getName();
    }

    public String toString() {
        return PrettyStrings.prettify(String.format("%s %s", super.toString(), pianetaRif.toString()), AnsiColors.CYAN, null,  null);
    }

    public Planet getPianetaRif() {
        return pianetaRif;
    }

    public Coordinate getCoordinate() {
        return super.getCoordinate();
    }

    public String getPath() {
        return path;
    }
}
