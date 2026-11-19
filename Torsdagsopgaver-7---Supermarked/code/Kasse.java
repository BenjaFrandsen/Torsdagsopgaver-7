package supermarked.robot;

import supermarked.robot.supermarked.data.Vare;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Kasse {

    private final Map<String, Vare> alleVarer;
    private final Map<String, Vare> tilbudsVarer;

    public Kasse(Map<String, Vare> alleVarer, Map<String, Vare> tilbudsVarer) {
        this.alleVarer = alleVarer;
        this.tilbudsVarer = tilbudsVarer;
    }

    public void udskrivBon(Collection<Vare> kurv) {
        Map<String, Integer> antal = new LinkedHashMap<>();
        for (Vare vare : kurv) {
            antal.merge(vare.getId(), 1, Integer::sum);
        }

        BigDecimal total = BigDecimal.ZERO;

        for (String id : antal.keySet()) {
            Vare vare = alleVarer.get(id);
            BigDecimal n = BigDecimal.valueOf(antal.get(id));
            BigDecimal line = vare.getPrice().multiply(n);

            System.out.println(vare.getName().split(",")[0].trim());
            System.out.println("  " + antal.get(id) + " × " + kr(vare.getPrice()) + " = " + kr(line));

            Vare tilbud = tilbudsVarer.get(id);
            if (tilbud != null) {
                BigDecimal rabat = vare.getPrice().subtract(tilbud.getPrice()).multiply(n).negate();
                System.out.println("  Tilbud: " + kr(rabat));
                line = line.add(rabat);
            }
            total = total.add(line);
        }

        BigDecimal moms = total.divide(BigDecimal.valueOf(5), 2, RoundingMode.HALF_UP);
        System.out.println("TOTAL: " + kr(total));
        System.out.println("Heraf moms: " + kr(moms));
    }

    private String kr(BigDecimal amount) {
        return String.format(Locale.forLanguageTag("da-DK"), "%.2f kr.", amount);
    }
}