package org.Arch.IsTheBest.Planetarium.Utils.Io.IoRoute;

import com.kibo.pgar.lib.*;

import static org.Arch.IsTheBest.Planetarium.Utils.Io.ArtTacTac.*;

public abstract class IoRoute {
        public static void showMenu() {
        Menu menu = new Menu(MENU_ROUTE_TITLE, MENU_ROUTE_OPTIONS, true, false, false);

        int choice;

        do {
            choice = menu.choose();

            switch (choice) {
                case 1:
                    BurnOut.fromToInterface();
                    break;
                case 2:
                    BurnOut.BuildPathFromTo();
                    break;
            }
        } while (choice != 0);
    }
}
