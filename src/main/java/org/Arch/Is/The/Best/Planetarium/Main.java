package org.Arch.Is.The.Best.Planetarium;

import org.Arch.Is.The.Best.Planetarium.Utils.Io.IoMain.IoMain;

import static org.Arch.Is.The.Best.Planetarium.Utils.Io.ArtTacTac.*;

public abstract class Main {
    public static void main(String[] args) {
        System.out.print(STARTING_PLANETARIUM);

        IoMain.setUpSystem();

        System.out.println("\n");
    }
}