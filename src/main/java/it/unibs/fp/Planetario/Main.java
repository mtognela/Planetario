package it.unibs.fp.Planetario;

import it.kibo.fp.lib.InputData;
import it.unibs.fp.Planetario.Data.Coordinate;
import it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.Extend.Moon;
import it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.Extend.Planet;
import it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.Extend.Star;

public class Main {
   public static boolean n = false;
    public static void main(String[] args) {
        System.out.println("Benvenuto nel tuo Planetario");
        boolean x = InputData.readYesOrNo("Sei pronto a cominciare?");
            if (x){
                //inserimento sistema solare
            String nomeSistema = InputData.readNonEmptyString("qual è il nome del tuo sistema solare?", n);
            System.out.println("ottimo, per prima cosa procederemo ad inserire la stella del tuo sistema solare");
                //inserimento stella
            String starName = InputData.readNonEmptyString("inserisci il nome della tua stella: ", n);
            double starMass = InputData.readDoubleWithMinimum("inserisci la massa della tua stella: ", 0);
            Star star = new Star(starMass, starName, nomeSistema);
            System.out.println("ottimo, ora che abbiamo la stella del tuo sistema solare, procediamo ad inserire i pianeti");
            boolean y = InputData.readYesOrNo("vuoi inserire un pianeta?");
                //creazione primo pianeta
                if (y){
                String planetName = InputData.readNonEmptyString("inserisci il nome del pianeta: ", n );
                double planetMass = InputData.readDoubleWithMinimum("inserisci la massa del pianeta: ", 0);
                double planetRadius = InputData.readDoubleWithMinimum("inserisci la distanza del pianeta dalla stella: ", 0);
                double planetAngle = InputData.readDoubleWithMinimum("inserisci l'angolo del pianeta rispetto alla stella: ", 0);
                Planet planet = new Planet(planetMass, new Coordinate(planetRadius * Math.cos(planetAngle), planetRadius * Math.sin(planetAngle)), planetName);
                //metodo da creare
                star.addPlanet(planet);
                    
                System.out.println("ottimo, ora che abbiamo il primo pianeta del tuo sistema solare, procediamo ad inserire le lune del pianeta");
                boolean z = InputData.readYesOrNo("vuoi inserire una luna?");
                
                while(z){
                //creazione prima luna
                String moonName = InputData.readStringNotEmpty("inserisci il nome della luna: ", n );
                double moonMass = InputData.readDoubleWithMinimum("inserisci la massa della luna: ", 0);
                double moonRadius = InputData.readDoubleWithMinimum("inserisci la distanza della luna dal pianeta: ", 0);
                double moonAngle = InputData.readDoubleWithMinimum("inserisci l'angolo della luna rispetto al pianeta: ", 0);
                //creazione luna
                Moon moon = new Moon(moonMass, new Coordinate(moonRadius * Math.cos(moonAngle), moonRadius * Math.sin(moonAngle)), moonName, planet);
                //metodo da creare
                planet.addMoon(moon);
                z = InputData.readYesOrNo("ottimo, ora che abbiamo la luna del tuo pianeta, vuoi inserire altre lune per questo pianeta?");
                        }
                    }
                }
            
                
                
            while (x){
                //menu principale
                    System.out.println("\nMenu: ");
                    System.out.println("1. Aggiungi un pianeta");
                    System.out.println("2. Aggiungi una luna");
                    System.out.println("3. Rimuovi un pianeta");
                    System.out.println("4. Rimuovi una luna");
                    System.out.println("5. Mostra il sistema solare");
                    System.out.println("6. Esci");
                    
                    int scelta = InputData.readIntegerBetween ("Scegli un'opzione: ", 1, 6);
                    
                    switch (scelta) {
                        case 1:
                            addPlanet();
                            break;
                        case 2:
                            addMoon();
                            break;
                        case 3:
                            removePlanet();
                            break;
                        case 4:
                            removeMoon();
                            break;
                        case 5:
                            showSolarSystem();
                            break;
                        case 6:
                            System.out.println("Uscita in corso...");
                            x = false;
                            break;
                    }
                }
            }
}






        
//aggiungi pianeta
private static void addPlanet() {
    String planetName = InputData.readStringNotEmpty("Inserisci il nome del pianeta: ", n);
    double planetMass = InputData.readDoubleWithMinimum("Inserisci la massa del pianeta: ", 0);
    double planetRadius = InputData.readDoubleWithMinimum("Inserisci la distanza del pianeta dalla stella: ", 0);
    double planetAngle = InputData.readDoubleWithMinimum("Inserisci l'angolo del pianeta rispetto alla stella: ", 0);
    Planet planet = new Planet(planetMass, new Coordinate(planetRadius * Math.cos(planetAngle), planetRadius * Math.sin(planetAngle)), planetName);
    star.addPlanet(planet);
    System.out.println("Pianeta aggiunto con successo!");}

//aggiungi luna



            
        

    


