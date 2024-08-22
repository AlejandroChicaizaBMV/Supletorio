package CSDAC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import CSBL.Entities.CSHormiga;
import CSDAC.CSDTO.CSHormigaDTO;

public class CSHormigaDAO {
    private String csFilePath;

    public CSHormigaDAO(String csFilePath) {
        this.csFilePath = csFilePath;
    }

    public List<CSHormiga> csReadAll() throws IOException {
        List<CSHormiga> csHormigas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] valores = line.split(",");
                if (valores.length == 7) {  
                    CSHormiga hormiga = new CSHormiga(
                        Integer.parseInt(valores[0]), 
                        valores[1],
                        valores[2],
                        valores[3],
                        valores[4]
                    );
                    csHormigas.add(hormiga); 
                } else {

                }
            }
        }
        return csHormigas;
    }
    

    public void csCreate(List<CSHormiga> csList) throws IOException {
        List<CSHormiga> hormigasExistentes = csReadAll(); 
        int nuevoId = hormigasExistentes.size() + 1;
    
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csFilePath, true))) {
            for (CSHormiga csHormiga : csList) {
                // Asigna el nuevo ID a cada hormiga y luego incrementa el ID para la siguiente hormiga
                csHormiga.setId(nuevoId);
                nuevoId++; // Incrementa el ID para la siguiente hormiga
    
                // Escribe la hormiga en el archivo CSV
                bw.write(csHormiga.getId() + "," +
                         csHormiga.getTipo() + "," +
                         csHormiga.getSexo() + "," +
                         csHormiga.getAlimentacion() + "," +
                         csHormiga.getEstado());
                bw.newLine();
            }
        }
    }
    
    
    
    

    public void csDelete(int csNHormiga) throws IOException {
        List<CSHormiga> hormigas = csReadAll();
        hormigas.removeIf(h -> h.getId() == csNHormiga);
    
        // Reenumerar los registros restantes
        int contador = 1;
        for (CSHormiga h : hormigas) {
            h.setId(contador); // Reasigna el número de registro
            contador++;
        }
    
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csFilePath))) {
            for (CSHormiga h : hormigas) {
                bw.write(h.getId() + "," + 
                         h.getTipo() + "," + 
                         h.getSexo() + "," + 
                         h.getAlimentacion() + "," + 
                         h.getEstado());
                bw.newLine();
            }
        }
    }
    
}
