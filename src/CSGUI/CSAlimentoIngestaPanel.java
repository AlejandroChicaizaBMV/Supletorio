package CSGUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import CSBL.Entities.*;


public class CSAlimentoIngestaPanel extends JPanel {
    private JComboBox<CSGenoAlimento> csCBoxGenoAlimento;
    private JComboBox<CSIngestaNativa> csCBoxIngestaNativa;

    public CSAlimentoIngestaPanel() {
        csCustomizeComponent();
    }

    private void csCustomizeComponent() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        
        ArrayList<CSGenoAlimento> csGenoAlimentoElementos = new ArrayList<>(); 
        csGenoAlimentoElementos.add(new CSX());
        csGenoAlimentoElementos.add(new CSXX());
        csGenoAlimentoElementos.add(new CSXY()); 
        
        csCBoxGenoAlimento = new JComboBox<>(csGenoAlimentoElementos.toArray(new CSGenoAlimento[0]));
        csCBoxGenoAlimento.setPreferredSize(new Dimension(200, 30));
        
        ArrayList<CSIngestaNativa> csIngestaNativaElementos = new ArrayList<>(); 
        csIngestaNativaElementos.add(new CSCarnivoro());
        csIngestaNativaElementos.add(new CSHerbivoro());
        csIngestaNativaElementos.add(new CSInsectivoro());
        csIngestaNativaElementos.add(new CSNectarivoro());
        csIngestaNativaElementos.add(new CSOmnivoro());



        csCBoxIngestaNativa = new JComboBox<>(csIngestaNativaElementos.toArray(new CSIngestaNativa[0]));
        csCBoxIngestaNativa.setPreferredSize(new Dimension(200, 30));
        
        add(csCBoxGenoAlimento);
        add(csCBoxIngestaNativa);
    }

    // Métodos getter para los JComboBox
    public JComboBox<CSGenoAlimento> getCsCBoxGenoAlimento() {
        return csCBoxGenoAlimento;
    }

    public JComboBox<CSIngestaNativa> getCsCBoxIngestaNativa() {
        return csCBoxIngestaNativa;
    }
}
