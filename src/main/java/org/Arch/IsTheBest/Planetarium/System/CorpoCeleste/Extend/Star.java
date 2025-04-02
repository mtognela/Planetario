package org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend;

import com.kibo.pgar.lib.AnsiColors;
import com.kibo.pgar.lib.PrettyStrings;
import org.Arch.IsTheBest.Planetarium.Data.Coordinate;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.CorpoCeleste;

public class Star extends CorpoCeleste {
    private static Star instance = null;

    private Star(double mass, String nome) {
        super(mass, new Coordinate(0, 0), nome);
    }

    public static void createInstance(double mass, String nome) {
        if (instance == null) instance = new Star(mass, nome);
    }

    public static Star getInstance() {
        return instance;
   }

    public static String getInstanceToString() {
        return instance.toString();
    }

    public static String getInstanceName() {
        return instance.getName();
    }

    public static double getInstanceMass() {
        return instance.getMass();
    }

    @Override
    public String toString() {
        return PrettyStrings.prettify("Star: " + super.toString(), AnsiColors.RED, null, null);
    }
}
