package CSGUI;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CSSeccionExperimentosPanel extends JPanel {
    private JTable csTabla;
    private DefaultTableModel csModeloTabla;
    private Random random = new Random();

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
        csModeloTabla.addColumn("Estado");

        csTabla = new JTable(csModeloTabla);
        csTabla.setPreferredScrollableViewportSize(new Dimension(500, 200));
        JScrollPane scrollPane = new JScrollPane(csTabla);

        add(scrollPane);
    }

    public void csAddLarva() {
        List<Object[]> csRows = new ArrayList<>();
        csRows = csGetAllRows();
        int csNReg = csRows.size() + 1;

        String csProvincia= csProvinciaRandom() ;
        Object[] csLarvaNueva = {csNReg, "larva", "-", csProvincia, "Nectivoro", "VIVA"};
        csModeloTabla.addRow(csLarvaNueva);
        System.out.println("creando larva...");
    }

    
    public List<Object[]> csGetAllRows() {
        List<Object[]> csRows = new ArrayList<>();
        for (int i = 0; i < csModeloTabla.getRowCount(); i++) {
            int columnCount = csModeloTabla.getColumnCount();
            Object[] row = new Object[columnCount];
            for (int j = 0; j < columnCount; j++) {
                row[j] = csModeloTabla.getValueAt(i, j);
            }
            csRows.add(row);
        }
        return csRows;
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
}
