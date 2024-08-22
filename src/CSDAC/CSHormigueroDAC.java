package CSDAC;

import CSInfra.Config;
import java.io.FileWriter;
import java.io.IOException;

public class CSHormigueroDAC {
    public CSHormigueroDAC(){}

    public void saveHormigueroToCSV(String fullData) {
        try (FileWriter writer = new FileWriter(Config.DATAFILE, true)) { 
            writer.write(fullData);
            writer.write(System.lineSeparator()); 
            Config.showMsg("Datos guardados exitosamente en " + Config.DATAFILE);
        } catch (IOException e) {
            Config.showMsgError("Error al guardar datos: " + e.getMessage());
        }
    }
}

