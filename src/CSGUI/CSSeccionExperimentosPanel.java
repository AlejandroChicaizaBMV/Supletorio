package CSGUI;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CSSeccionExperimentosPanel extends JPanel {
    private JTable csTabla;
    private Object[] csLarvaNueva = {1, "larva", "-", "Loja", "Nectivoro", "VIVA"}; 
    private DefaultTableModel csModeloTabla;

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
        csModeloTabla.addRow(csLarvaNueva);
        System.out.println("creando larva...");
    }
}
