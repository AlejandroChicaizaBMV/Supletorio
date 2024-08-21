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
            }
        }
        return csHormigas;
    }

        public void csCreate(CSHormigaDTO csHormigaDTO) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csFilePath, true))) {
            bw.write(csHormigaDTO.getCsNHormiga() + "," + 
                     csHormigaDTO.getCsTipo() + "," +
                     csHormigaDTO.getCsSexo() + "," + 
                     csHormigaDTO.getCsProvincia() + "," + 
                     csHormigaDTO.getCsIngestaNativa() + "," +
                     csHormigaDTO.getCsGenoAlimento() + ","+ 
                     csHormigaDTO.getCsEstado());
            bw.newLine();
        }
    }

    public void csDelete(int csNHormiga) throws IOException {
        List<CSHormigaDTO> hormigas = csReadAll();
        hormigas.removeIf(h -> h.getCsNHormiga() == csNHormiga);
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csFilePath))) {
            for (CSHormigaDTO h : hormigas) {
                bw.write(h.getCsNHormiga() + "," + 
                         h.getCsTipo() + "," + 
                         h.getCsSexo() + "," + 
                         h.getCsProvincia() + "," + 
                         h.getCsIngestaNativa() + "," +
                         h.getCsIngestaNativa() + ","+
                         h.getCsEstado() 
                        );
                bw.newLine();
            }
        }
    }
}
