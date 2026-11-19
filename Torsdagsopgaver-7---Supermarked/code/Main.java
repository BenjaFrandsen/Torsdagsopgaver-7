package supermarked.robot;

import supermarked.robot.supermarked.data.DataReader;
import supermarked.robot.supermarked.data.Vare;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class Main {


    void main() throws IOException {
        Map<String, Vare> alleVarer = DataReader.readGroceries("data/varer.csv");
        Map<String, Vare> tilbudsVarer = DataReader.readGroceries("data/tilbud.csv");

        Kasse kasse = new Kasse(alleVarer, tilbudsVarer);
        Collection<Vare> kurv = new Robot().fyldIKurv(alleVarer.values());
        kasse.udskrivBon(kurv);
    }

    // Valg af Datastrukturer
    // Har brugt Map til at gemme nøglen(EAN nr) og værdien varen.

    // Har brugt LinkedHashMap til bonen, så tingene står i scannet rækkefølge og samler flere ens scannede varer.


}
