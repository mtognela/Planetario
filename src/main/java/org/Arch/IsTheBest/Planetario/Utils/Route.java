package org.Arch.IsTheBest.Planetario.Utils;

import com.kibo.pgar.lib.AnsiColors;
import com.kibo.pgar.lib.PrettyStrings;
import org.Arch.IsTheBest.Planetario.SistemaSolare.CorpoCeleste.Extend.Moon;
import org.Arch.IsTheBest.Planetario.SistemaSolare.CorpoCeleste.Extend.Planet;
import org.Arch.IsTheBest.Planetario.SistemaSolare.CorpoCeleste.Extend.Star;

public abstract class Route {
        public static double FromTo(Planet p1, Planet p2) {
            return p1.getCoordinate().distanceAss() + p2.getCoordinate().distanceAss();
        }

        public static double FromTo(Moon m1, Moon m2) {
            if (m1.getPianetaRif().getIDString().equals(m2.getPianetaRif().getIDString())) {
                return (
                    m1.getCoordinate().distanceFrom(m1.getPianetaRif().getCoordinate()) +
                    m2.getCoordinate().distanceFrom(m1.getPianetaRif().getCoordinate())
                );
            } else {
                return (
                    m1.getCoordinate().distanceFrom(m1.getPianetaRif().getCoordinate()) + m1.getPianetaRif().getCoordinate().distanceAss() +
                    m2.getCoordinate().distanceFrom(m2.getPianetaRif().getCoordinate()) + m2.getPianetaRif().getCoordinate().distanceAss()
                );
            }
        }

        public static double FromTo(Moon m, Planet p) {
            if (m.getPianetaRif().getIDString().equals(p.getIDString())) {
                return (
                    m.getCoordinate().distanceFrom(p.getCoordinate())
                );
            } else {
                return (
                        m.getCoordinate().distanceFrom(m.getPianetaRif().getCoordinate()) +
                        m.getPianetaRif().getCoordinate().distanceAss() +
                        p.getCoordinate().distanceAss()
                );
            }
        }

        public static String BuildPathFromTo(Planet p1, Planet p2) {
            return PrettyStrings.
                    prettify(String.format("%s > %s > %s", p1.getName(), Star.getInstanceName(), p2.getName()), AnsiColors.CYAN, null, null);
        }

        public static String BuildPathFromTo(Moon m1, Moon m2) {
            if (m1.getPianetaRif().getIDString().equals(m2.getPianetaRif().getIDString())) {
                return PrettyStrings.
                        prettify(String.format("%s > %s > %s", m1.getName(), m1.getPianetaRif().getName(), m2.getName()), AnsiColors.CYAN, null, null);
            } else {
                return PrettyStrings.prettify(
                        String.format("%s > %s > %s > %s > %s",
                        m1.getName(), m1.getPianetaRif().getName(), Star.getInstanceName(), m2.getPianetaRif().getName(), m2.getName()),
                        AnsiColors.CYAN, null, null);
            }
        }
}
