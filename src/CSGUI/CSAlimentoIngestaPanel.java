package CSGUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import CSBusinessLogic.CSCarnivoro;
import CSBusinessLogic.CSGenoAlimentoBL;
import CSBusinessLogic.CSIngestaNativaBL;
import CSBusinessLogic.CSXBL;
import CSBusinessLogic.CSXXBL;
import CSBusinessLogic.CSXYBL;

public class CSAlimentoIngestaPanel extends JPanel {
    private JComboBox<CSGenoAlimentoBL> csCBoxGenoAlimento;
    private JComboBox<CSIngestaNativaBL> csCBoxIngestaNativa;

    public CSAlimentoIngestaPanel() {
        csCustomizeComponent();

    }

    private void csCustomizeComponent() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        
        ArrayList<CSGenoAlimentoBL> csGenoAlimentoElementos = new ArrayList<>(); 
        csGenoAlimentoElementos.add(new CSXBL());
        csGenoAlimentoElementos.add(new CSXXBL());
        csGenoAlimentoElementos.add(new CSXYBL()); 
        
        csCBoxGenoAlimento = new JComboBox<>(csGenoAlimentoElementos.toArray(new CSGenoAlimentoBL[0]));
        csCBoxGenoAlimento.setPreferredSize(new Dimension(200, 30));
        
        ArrayList<CSIngestaNativaBL> csIngestaNativaElementos = new ArrayList<>(); 
        csIngestaNativaElementos.add(new CSCarnivoro());

        csCBoxIngestaNativa = new JComboBox<>(csIngestaNativaElementos.toArray(new CSIngestaNativaBL[0]));
        csCBoxIngestaNativa.setPreferredSize(new Dimension(200, 30));
        
        add(csCBoxGenoAlimento);
        add(csCBoxIngestaNativa);
    }
}
