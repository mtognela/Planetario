package org.Arch.IsTheBest.Planetarium.Utils.Io.PierPaolo;

import com.kibo.pgar.lib.InputData;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Moon;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Planet;
import org.Arch.IsTheBest.Planetarium.System.OrbitingSystem;
import org.Arch.IsTheBest.Planetarium.Utils.Path.Search;
import static org.Arch.IsTheBest.Planetarium.Utils.Io.ArtTacTac.*;
import static org.Arch.IsTheBest.Planetarium.Utils.Path.Route.*;
import java.util.ArrayList;

public abstract class BornOut {

    public static void fromToInterface() {
        if (!OrbitingSystem.getPlanets().isEmpty()) {
            double distance = rebusFromTo();

            System.out.println("Distance: " + distance);
        } else {
            System.out.println(ERROR_INIT_PANET_FIRST);
        }
    }

    public static void BuildPathFromTo() {
        if (!OrbitingSystem.getPlanets().isEmpty()) {
            String path =  rebusBuildPathFromTo();

            System.out.println("Path: " + path);
        } else {
            System.out.println(ERROR_INIT_PANET_FIRST);
        }
    }

    private static double rebusFromTo() {
        ArrayList<Planet> planets = OrbitingSystem.getPlanets();
        ArrayList<Moon> moons = OrbitingSystem.getMoons();

        if (InputData.readYesOrNo("Do you want to do a mix research?")) {
            Planet planet;
            Moon moon;
            do {
                int id = Integer.parseInt(InputData.readString("Please enter an ID: ", true));
                String nome = InputData.readString("Please enter a name ", true);

                planet = Search.searchPlanet(id, nome);
                moon = Search.searchMoon(id, nome);

                if (planet == null && moon == null) System.out.println(NO_PLANET_FOUND);
                else if (planet == null) System.out.println(moon);
                else if (moon == null) System.out.println(planet);
                else {
                    System.out.println(moon);
                    System.out.println(planet);
                }
            } while((planet != null || moon != null) && !InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));

            if (planet == null) {
                do {
                    int id = Integer.parseInt(InputData.readString("Please enter an ID: ", true));
                    String nome = InputData.readString("Please enter a name ", true);
                    planet = Search.searchPlanet(id, nome);
                } while((planet != null) && !InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));
            } else if (moon == null) {
                do {
                    int id = Integer.parseInt(InputData.readString("Please enter an ID: ", true));
                    String nome = InputData.readString("Please enter a name ", true);
                    moon = Search.searchMoon(id, nome);
                } while((moon != null) && !InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));
            }

            assert moon != null;
            assert planet != null;

            return fromTo(moon, planet);
        } else if (InputData.readYesOrNo("Do you want to search planets or moons (Y for Planet and n for moon)?")) {
            Planet planet1, planet2;

            do {
                int id1 = Integer.parseInt(InputData.readString("Please enter an ID: ", true));
                String nome1 = InputData.readString("Please enter a name ", true);
                planet1 = Search.searchPlanet(id1, nome1);
            } while((planet1 != null) && !InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));

            do {
                int id2 = Integer.parseInt(InputData.readString("Please enter an ID: ", true));
                String nome2 = InputData.readString("Please enter a name ", true);
                planet2 = Search.searchPlanet(id2, nome2);
            } while((planet2 != null) && !InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));

            assert planet1 != null;
            assert planet2 != null;

            return fromTo(planet1, planet2);
        } else {
            Moon moon1, moon2;

            do {
                int id1 = Integer.parseInt(InputData.readString("Please enter an ID: ", true));
                String nome1 = InputData.readString("Please enter a name ", true);
                moon1 = Search.searchMoon(id1, nome1);
            } while((moon1 != null) && !InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));

            do {
                int id2 = Integer.parseInt(InputData.readString("Please enter an ID: ", true));
                String nome2 = InputData.readString("Please enter a name ", true);
                moon2 = Search.searchMoon(id2, nome2);
            } while((moon2 != null) && !InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));

            assert moon1 != null;
            assert moon2 != null;

            return fromTo(moon1, moon2);
        }
    }

    private static String rebusBuildPathFromTo() {
        ArrayList<Planet> planets = OrbitingSystem.getPlanets();
        ArrayList<Moon> moons = OrbitingSystem.getMoons();
        Planet planetToSearch;
        Moon moonToSearch;

        if (InputData.readYesOrNo("Do you want to do a mix research?")) {
            do {
                int id = Integer.parseInt(InputData.readString("Please enter an ID: ", true));
                String nome = InputData.readString("Please enter a name ", true);

                planetToSearch = Search.searchPlanet(id, nome);
                moonToSearch = Search.searchMoon(id, nome);

                if (planetToSearch == null && moonToSearch == null) System.out.println(NO_PLANET_FOUND);
                else if (planetToSearch == null) System.out.println(moonToSearch);
                else if (moonToSearch == null) System.out.println(planetToSearch);
                else {
                    System.out.println(moonToSearch);
                    System.out.println(planetToSearch);
                }
            } while((planetToSearch != null || moonToSearch != null) && !InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));

            if (planetToSearch == null) {
                do {
                    int id = Integer.parseInt(InputData.readString("Please enter an ID: ", true));
                    String nome = InputData.readString("Please enter a name ", true);
                    planetToSearch = Search.searchPlanet(id, nome);
                } while((planetToSearch != null) && !InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));
            } else if (moonToSearch == null) {
                do {
                    int id = Integer.parseInt(InputData.readString("Please enter an ID: ", true));
                    String nome = InputData.readString("Please enter a name ", true);
                    moonToSearch = Search.searchMoon(id, nome);
                } while((moonToSearch != null) && !InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));
            }

            assert moonToSearch != null;
            assert planetToSearch != null;

            return buildPathFromTo(moonToSearch, planetToSearch);
        } else if (InputData.readYesOrNo("Do you want to search planets or moons (Y for Planet and n for moon)?")) {
            Planet planet1, planet2;

            do {
                int id1 = Integer.parseInt(InputData.readString("Please enter an ID: ", true));
                String nome1 = InputData.readString("Please enter a name ", true);
                planet1 = Search.searchPlanet(id1, nome1);
            } while((planet1 != null) && !InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));

            do {
                int id2 = Integer.parseInt(InputData.readString("Please enter an ID: ", true));
                String nome2 = InputData.readString("Please enter a name ", true);
                planet2 = Search.searchPlanet(id2, nome2);
            } while((planet2 != null) && !InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));

            assert planet1 != null;
            assert planet2 != null;

            return buildPathFromTo(planet1, planet2);
        } else {
            Moon moon1, moon2;

            do {
                int id1 = Integer.parseInt(InputData.readString("Please enter an ID: ", true));
                String nome1 = InputData.readString("Please enter a name ", true);
                moon1 = Search.searchMoon(id1, nome1);
            } while((moon1 != null) && !InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));

            do {
                int id2 = Integer.parseInt(InputData.readString("Please enter an ID: ", true));
                String nome2 = InputData.readString("Please enter a name ", true);
                moon2 = Search.searchMoon(id2, nome2);
            } while((moon2 != null) && !InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));

            assert moon1 != null;
            assert moon2 != null;

            return buildPathFromTo(moon1, moon2);
        }
    }
}
