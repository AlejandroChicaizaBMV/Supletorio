package CSGUI;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class CSAlimentoIngestaPanel extends JPanel {
    private JComboBox<String> csCBoxGenoAlimento;
    private JComboBox<String> csCBoxIngestaNativa;

    public CSAlimentoIngestaPanel() {
        csCustomizeComponent();

    }

    private void csCustomizeComponent() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        csCBoxGenoAlimento = new JComboBox<>();
        csCBoxGenoAlimento.setPreferredSize(new Dimension(200, 30));
        add(csCBoxGenoAlimento);


        csCBoxIngestaNativa = new JComboBox<>();
        csCBoxIngestaNativa.setPreferredSize(new Dimension(200, 30));
        add(csCBoxIngestaNativa);

    }
}
