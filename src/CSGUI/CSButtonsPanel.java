package CSGUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import CSBusinessLogic.CSGenoAlimentoBL;
import CSBusinessLogic.CSHormigaBL;
import CSBusinessLogic.CSIngestaNativaBL;
import CSDAC.CSDTO.CSHormigaDTO;

public class CSButtonsPanel extends JPanel {

    JButton csBtnCrearLarva;
    JButton csBtnALimentar;
    JButton csBtnEliminar;
    JButton csBtnGuardar;
    CSSeccionExperimentosPanel csSeccionExperimentosPanel;
    CSAlimentoIngestaPanel csAlimentoIngestaPanel;

    public CSButtonsPanel(CSSeccionExperimentosPanel csSeccionExperimentosPanel, CSAlimentoIngestaPanel csAlimentoIngestaPanel){
        this.csSeccionExperimentosPanel = csSeccionExperimentosPanel;
        this.csAlimentoIngestaPanel = csAlimentoIngestaPanel;
        csCustomizeComponent();
    }

    private void csCustomizeComponent(){
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 10 , 35));
        setBackground(Color.decode("0xd1d1d1"));
        csBtnCrearLarva= new JButton("Crear Larva");
        csBtnALimentar = new JButton("Alimentar");
        csBtnEliminar  = new JButton("Eliminar");
        csBtnGuardar   = new JButton("Guardar");

        csBtnCrearLarva.addActionListener(e -> {csSeccionExperimentosPanel.csAddLarva();});
        csBtnEliminar.addActionListener(e -> {csSeccionExperimentosPanel.csEliminarReg();});
        csBtnGuardar.addActionListener(e -> {
            List<CSHormigaDTO> csHormigasList =  csSeccionExperimentosPanel.csGetAllRows();
            CSHormigaBL csHormigaBL = new CSHormigaBL();
            try {
                csHormigaBL.csAgregarHormiga(csHormigasList);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        csBtnALimentar.addActionListener(e -> {
            // Obtener los datos de los JComboBox en CSAlimentoIngestaPanel
            CSGenoAlimentoBL genoAlimentoSeleccionado = (CSGenoAlimentoBL) csAlimentoIngestaPanel.getCsCBoxGenoAlimento().getSelectedItem();
            CSIngestaNativaBL ingestaNativaSeleccionada = (CSIngestaNativaBL) csAlimentoIngestaPanel.getCsCBoxIngestaNativa().getSelectedItem();
            
            // Lógica adicional aquí según los valores seleccionados
            System.out.println("Geno Alimento Seleccionado: " + genoAlimentoSeleccionado);
            System.out.println("Ingesta Nativa Seleccionada: " + ingestaNativaSeleccionada);

            if(genoAlimentoSeleccionado.toString().equals("XY")){
                csSeccionExperimentosPanel.csEvolucion();
            }

            if(csSeccionExperimentosPanel.csGetIngesta().equals("Carnivoro") && !ingestaNativaSeleccionada.toString().equals("CARNIVORO")){
                csSeccionExperimentosPanel.csMatar();
            }
        });

        add(csBtnCrearLarva);
        add(csBtnALimentar);
        add(csBtnEliminar);
        add(csBtnGuardar);
    }
}
