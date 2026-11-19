package supermarked.robot.supermarked.data;


import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataReader {

    public static Map<String, Vare> readGroceries(String path) throws IOException {
        Map<String, Vare> varer = new HashMap<>();
        List<String> lines = Files.readAllLines(Path.of(path));

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty()) continue;

            String[] d = line.split(";");
            Vare vare = new Vare(
                    d[0].trim(),
                    d[1].trim(),
                    LocalDate.parse(d[2].trim()),
                    new BigDecimal(d[3].trim()),
                    Boolean.parseBoolean(d[4].trim()),
                    Double.parseDouble(d[5].trim()),
                    d[6].trim(),
                    Boolean.parseBoolean(d[7].trim()),
                    Boolean.parseBoolean(d[8].trim()),
                    Boolean.parseBoolean(d[9].trim())
            );
            varer.put(vare.getId(), vare);
        }
        return varer;
    }




}
