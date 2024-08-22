package CSGUI;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import CSDAC.CSDTO.CSHormigaDTO;

public class CSSeccionExperimentosPanel extends JPanel {
    private JTable csTabla;
    private DefaultTableModel csModeloTabla;
    private Random random = new Random();
    public int csRowSelect;

    
    public CSSeccionExperimentosPanel() {
        csCustomizeComponent();
    }

    private void csCustomizeComponent() {
        csModeloTabla = new DefaultTableModel();
        csModeloTabla.addColumn("nHormiga");
        csModeloTabla.addColumn("Tipo");
        csModeloTabla.addColumn("Sexo");
        csModeloTabla.addColumn("Provincia");
        csModeloTabla.addColumn("IngestaNativa");
        csModeloTabla.addColumn("GenoAlimento");
        csModeloTabla.addColumn("Estado");

        csTabla = new JTable(csModeloTabla);
        csTabla.setPreferredScrollableViewportSize(new Dimension(660, 200));
        
        csTabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = csTabla.getSelectedRow();
                    if (selectedRow != -1) {
                        int csSelect = (int) csModeloTabla.getValueAt(selectedRow, 0);
                        System.out.println("Tipo de hormiga seleccionada: " + csSelect);
                        setCsRowSelect(csSelect);
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(csTabla);

        add(scrollPane);
    }

    public void csAddLarva() {
        List<CSHormigaDTO> csHormigas = csGetAllRows(); // Obtiene todas las hormigas existentes
        int csNReg = csHormigas.size() + 1; // Determina el nuevo ID basado en el tamaño de la lista
    
        String csProvincia = csProvinciaRandom(); // Genera una provincia aleatoria
    
        // Crea una nueva instancia de CSHormigaDTO para representar la larva
        CSHormigaDTO csLarvaNueva = new CSHormigaDTO(csNReg, "larva", "-", csProvincia, "Nectivoro","X", "VIVA");
    
        // Agrega la nueva larva al modelo de la tabla
        csModeloTabla.addRow(new Object[] {
            csLarvaNueva.getCsNHormiga(),
            csLarvaNueva.getCsTipo(),
            csLarvaNueva.getCsSexo(),
            csLarvaNueva.getCsProvincia(),
            csLarvaNueva.getCsIngestaNativa(),
            csLarvaNueva.getCsGenoAlimento(),
            csLarvaNueva.getCsEstado()
        });
        
        System.out.println("Creando larva...");
    }
    
    
    
    public List<CSHormigaDTO> csGetAllRows() {
        List<CSHormigaDTO> csHormigas = new ArrayList<>();
        
        for (int i = 0; i < csModeloTabla.getRowCount(); i++) {
            int csNHormiga = (int) csModeloTabla.getValueAt(i, 0);
            String csTipo = (String) csModeloTabla.getValueAt(i, 1);
            String csSexo = (String) csModeloTabla.getValueAt(i, 2);
            String csProvincia = (String) csModeloTabla.getValueAt(i, 3);
            String csIngestaNativa = (String) csModeloTabla.getValueAt(i, 4);
            String csGenoAlimento = (String) csModeloTabla.getValueAt(i, 5);
            String csEstado = (String) csModeloTabla.getValueAt(i, 6);
    
            // Crea una nueva instancia de CSHormigaDTO con los valores obtenidos
            CSHormigaDTO csHormigaDTO = new CSHormigaDTO(csNHormiga, csTipo, csSexo, csProvincia, csIngestaNativa, csGenoAlimento, csEstado);
            
            csHormigas.add(csHormigaDTO); // Agrega la hormiga a la lista
        }
    
        return csHormigas;
    }
    

    public void csEliminarReg() {
        csModeloTabla.setRowCount(0);
        System.out.println("Eliminando Registros...");
    }
    
    public void csEvolucion() {
        // Recorre todas las filas de la tabla
        for (int i = 0; i < csModeloTabla.getRowCount(); i++) {
            // Actualiza la columna "Tipo" a "Soldado"
            csModeloTabla.setValueAt("Soldado", i, 1);
            csModeloTabla.setValueAt("Masculino", i, 2);
            // Actualiza la columna "GenoAlimento" a "XY"
            csModeloTabla.setValueAt("XY", i, 5);
            // Actualiza la columna "IngestaNativa" a "Carnivoro"
            csModeloTabla.setValueAt("Carnivoro", i, 4);
        }
        
        System.out.println("Evolución completada: Todas las hormigas han sido actualizadas a Tipo 'Soldado', GenoAlimento 'XY' e IngestaNativa 'Carnivoro'.");
    }
    
    public String csGetIngesta() {
        if (csModeloTabla.getRowCount() > 0) {
            return (String) csModeloTabla.getValueAt(0, 4);
        }
        return null;
    }
    
    public void csMatar() {
        for (int i = 0; i < csModeloTabla.getRowCount(); i++) {
            csModeloTabla.setValueAt("MUERTA", i, 6);
        }
    }

    private String csProvinciaRandom() {
        int csNRandom = random.nextInt(24 - 1 + 1) + 1;
        switch (csNRandom) {
            case 1:
            return "Azuay";
                
            case 2:
            return "Bolívar";
                
            case 3:
            return "Cañar";
                
            case 4:
            return "Carchi";
                
            case 5:
            return "Chimborazo";
                
            case 6:
            return "Cotopaxi";
                
            case 7:
            return "El Oro";
                
            case 8:
            return "Esmeraldas";
                
            case 9:
            return "Galápagos";
                
            case 10:
            return "Guayas";
                
            case 11:
            return "Imbabura";
            
            case 12:
            return "Loja";
            
            case 13:
            return "Los Ríos";
            
            case 14:
            return "Manabí";
            
            case 15:
            return "Morona Santiago";
            
            case 16:
            return "Napo";
            
            case 17:
            return "Orellana";
            
            case 18:
            return "Pastaza";
            
            case 19:
            return "Pichincha";
            
            case 20:
            return "Santa Elena";
            
            case 21:
            return "Santo Domingo de los Tsáchilas";
            
            case 22:
            return "Sucumbíos";
            
            case 23:
            return "Tungurahua";
            
            case 24:
            return "Zamora-Chinchipe";
            
            default:
            return "Número de provincia no válido";
            
        }
    }


    public int getCsRowSelect() {
        return csRowSelect;
    }
    
    public void setCsRowSelect(int csRowSelect) {
        this.csRowSelect = csRowSelect;
    }
}
