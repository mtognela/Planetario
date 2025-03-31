package org.Arch.IsTheBest.Planetarium.Utils.Io;

import com.kibo.pgar.lib.*;

import static org.Arch.IsTheBest.Planetarium.Utils.Io.ArtTacTac.*;

public abstract class IoRoute {
        public static void showMenu() {
        Menu menu = new Menu(MENU_ROUTE_TITLE, MENU_ROUTE_OPTIONS, true, true, true);

        int choice;

        do {
            choice = menu.choose();

            switch (choice) {
                case 1:

                    break;
                case 2:
                    BornOut.
                    break;
                case 3:
                    JustKidding.removePlanet();
                    break;
                case 4:
                    JustKidding.removeMoon();
                    break;
                case 5:
                    JustKidding.showSystem();
                    break;
                case 6:
                    JustKidding.cmd();
                    break;
                case 7:
                    JustKidding.route();
                    break;
            }
        } while (choice != 0);
    }
}
