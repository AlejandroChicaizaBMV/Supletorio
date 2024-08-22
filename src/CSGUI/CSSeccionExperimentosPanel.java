package CSGUI;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import CSBL.Entities.CSHormiga;
import CSInfra.CSAppException;

public class CSSeccionExperimentosPanel extends JPanel {
    private JTable csTabla;
    private DefaultTableModel csModeloTabla;
    public int csRowSelect;

    
    public CSSeccionExperimentosPanel() {
        csCustomizeComponent();
        
    }

    private void csCustomizeComponent() {
        csModeloTabla = new DefaultTableModel();
        csModeloTabla.addColumn("nHormiga");
        csModeloTabla.addColumn("Tipo");
        csModeloTabla.addColumn("Sexo");
        csModeloTabla.addColumn("IngestaNativa");
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
                        System.out.println("numero de la hormiga seleccionada: " + csSelect);
                        setCsRowSelect(csSelect);
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(csTabla);

        add(scrollPane);
    }

    public void csAddLarva() throws CSAppException {
        try {
            List<CSHormiga> csHormigas = csGetAllRows();
            int csNReg = csHormigas.size() + 1;
                
            CSHormiga csHormiga = new CSHormiga(csNReg, "larva", "Asexual","Nectivoro","VIVA");
        
            csModeloTabla.addRow(new Object[] {
                csHormiga.getId(),
                csHormiga.getTipo(),
                csHormiga.getSexo(),
                csHormiga.getAlimentacion(),
                csHormiga.getEstado()
            });
            
            System.out.println("Creando larva...");
        } catch (Exception e) {
        }
    }
        
    
    
    public List<CSHormiga> csGetAllRows() {
        List<CSHormiga> csHormigas = new ArrayList<>();
        
        for (int i = 0; i < csModeloTabla.getRowCount(); i++) {
            int csNHormiga = (int) csModeloTabla.getValueAt(i, 0);
            String csTipo = (String) csModeloTabla.getValueAt(i, 1);
            String csSexo = (String) csModeloTabla.getValueAt(i, 2);
            String csIngestaNativa = (String) csModeloTabla.getValueAt(i, 3);
            String csEstado = (String) csModeloTabla.getValueAt(i, 4);
    
            // Crea una nueva instancia de CSHormiga con los valores obtenidos
            CSHormiga csHormiga = new CSHormiga(csNHormiga, csTipo, csSexo, csIngestaNativa, csEstado);
            
            csHormigas.add(csHormiga); // Agrega la hormiga a la lista
        }
    
        return csHormigas;
    }
    

    public void csEliminarReg() {
        csModeloTabla.setRowCount(000);
        System.out.println("Eliminando Registros...");
    }
    
    public void csEvolucion() {
        int csRow = getCsRowSelect();

        csModeloTabla.setValueAt("HZangano", csRow, 1);
        csModeloTabla.setValueAt("Masculino", csRow, 2);
        csModeloTabla.setValueAt("Omnivoro", csRow, 3);
        
        
        System.out.println("Evolución completada: Todas las hormigas han sido actualizadas a Tipo 'Hzangano', GenoAlimento 'XY' e IngestaNativa 'Omnivoro'.");
    }
    
    public String csGetIngesta() {
        if (csModeloTabla.getRowCount() > 0) {
            return (String) csModeloTabla.getValueAt(0, 3);
        }
        return null;
    }
    
    public void csMatar() {
        int csRow = getCsRowSelect();
        csModeloTabla.setValueAt("MUERTA", csRow, 4);
        
    }


    public int getCsRowSelect() {
        return csRowSelect -1;
    }
    
    public void setCsRowSelect(int csRowSelect) {
        this.csRowSelect = csRowSelect;
    }
}
