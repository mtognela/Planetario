package org.Arch.IsTheBest.Planetarium.Utils.Extras;

import com.kibo.pgar.lib.AnsiColors;
import com.kibo.pgar.lib.PrettyStrings;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Moon;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Planet;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Star;

public abstract class Route {
    public static double fromTo(Planet p1, Planet p2) {
        return p1.distanceAss() + p2.distanceAss();
    }

    public static double fromTo(Moon m1, Moon m2) {
        if (m1.getPianetaRif().getID() == m2.getPianetaRif().getID()) {
            return (
                m1.distanceFrom(m1.getPianetaRif().getCoordinate()) +
                m2.distanceFrom(m1.getPianetaRif().getCoordinate())
            );
        } else {
            return (
                m1.distanceFrom(m1.getPianetaRif().getCoordinate()) + m1.getPianetaRif().distanceAss() +
                m2.distanceFrom(m2.getPianetaRif().getCoordinate()) + m2.getPianetaRif().distanceAss()
            );
        }
    }

    public static double fromTo(Moon m, Planet p) {
        if (m.getPianetaRif().getID() == p.getID()) {
            return (
                m.distanceFrom(p.getCoordinate())
            );
        } else {
            return (
                m.distanceFrom(m.getPianetaRif().getCoordinate()) +
                m.getPianetaRif().distanceAss() + p.distanceAss()
            );
        }
    }

    public static String BuildPathFromTo(Planet p1, Planet p2) {
        return PrettyStrings.
                prettify(String.format("%s > %s > %s", p1.getName(), Star.getInstanceName(), p2.getName()),
                        AnsiColors.CYAN, null, null);
    }

    public static String BuildPathFromTo(Moon m, Planet p) {
        if (m.getPianetaRif().getID() == p.getID()) {
            return PrettyStrings.prettify(String.format("%s > %s", p.getName(), m.getName()),
                    AnsiColors.CYAN, null, null);
        } else {
            return PrettyStrings.prettify(String.format("%s > %s > %s > %s", p.getName(), Star.getInstanceName(), m.getPianetaRif().getName(), m.getName()),
                    AnsiColors.CYAN, null, null);
        }
    }

    public static String BuildPathFromTo(Moon m1, Moon m2) {
        if (m1.getPianetaRif().getIDString().equals(m2.getPianetaRif().getIDString())) {
            return PrettyStrings.
                    prettify(String.format("%s > %s > %s", m1.getName(), m1.getPianetaRif().getName(), m2.getName()),
                    AnsiColors.CYAN, null, null);
        } else {
            return PrettyStrings.prettify(
                    String.format("%s > %s > %s > %s > %s",
                    m1.getName(), m1.getPianetaRif().getName(), Star.getInstanceName(), m2.getPianetaRif().getName(), m2.getName()),
                    AnsiColors.CYAN, null, null);
        }
    }
}
