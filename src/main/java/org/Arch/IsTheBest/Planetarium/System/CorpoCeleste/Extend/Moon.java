package org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend;

import com.kibo.pgar.lib.AnsiColors;
import com.kibo.pgar.lib.PrettyStrings;
import org.Arch.IsTheBest.Planetarium.Data.Coordinate;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.CorpoCeleste;

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

    public String getPath(){
        return path;
    }

    public String toString() {
        return super.toString();
    }

    public Planet getPianetaRif() {
        return pianetaRif;
    }
}
