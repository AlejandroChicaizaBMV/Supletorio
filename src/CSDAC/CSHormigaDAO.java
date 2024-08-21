package CSDAC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import CSDAC.CSDTO.CSHormigaDTO;

public class CSHormigaDAO {
    private String csFilePath;

    public CSHormigaDAO(String csFilePath) {
        this.csFilePath = csFilePath;
    }

    public List<CSHormigaDTO> csReadAll() throws IOException {
        List<CSHormigaDTO> csHormigas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] valores = line.split(",");
                if (valores.length == 7) {  
                    CSHormigaDTO hormiga = new CSHormigaDTO(
                        Integer.parseInt(valores[0]), 
                        valores[1],
                        valores[2],
                        valores[3],
                        valores[4],
                        valores[5],
                        valores[6]
                    );
                    csHormigas.add(hormiga); 
                } else {

                }
            }
        }
        return csHormigas;
    }
    

    public void csCreate(List<CSHormigaDTO> csList) throws IOException {
        List<CSHormigaDTO> hormigasExistentes = csReadAll(); 
        int nuevoId = hormigasExistentes.size() + 1;
    
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csFilePath, true))) {
            for (CSHormigaDTO csHormiga : csList) {
                // Asigna el nuevo ID a cada hormiga y luego incrementa el ID para la siguiente hormiga
                csHormiga.setCsNHormiga(nuevoId);
                nuevoId++; // Incrementa el ID para la siguiente hormiga
    
                // Escribe la hormiga en el archivo CSV
                bw.write(csHormiga.getCsNHormiga() + "," +
                         csHormiga.getCsTipo() + "," +
                         csHormiga.getCsSexo() + "," +
                         csHormiga.getCsProvincia() + "," +
                         csHormiga.getCsIngestaNativa() + "," +
                         csHormiga.getCsGenoAlimento() + "," +
                         csHormiga.getCsEstado());
                bw.newLine();
            }
        }
    }
    
    
    
    

    public void csDelete(int csNHormiga) throws IOException {
        List<CSHormigaDTO> hormigas = csReadAll();
        hormigas.removeIf(h -> h.getCsNHormiga() == csNHormiga);
    
        // Reenumerar los registros restantes
        int contador = 1;
        for (CSHormigaDTO h : hormigas) {
            h.setCsNHormiga(contador); // Reasigna el número de registro
            contador++;
        }
    
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csFilePath))) {
            for (CSHormigaDTO h : hormigas) {
                bw.write(h.getCsNHormiga() + "," + 
                         h.getCsTipo() + "," + 
                         h.getCsSexo() + "," + 
                         h.getCsProvincia() + "," + 
                         h.getCsIngestaNativa() + "," + 
                         h.getCsEstado());
                bw.newLine();
            }
        }
    }
    
}
