package CSGUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import CSBusinessLogic.CSHormigaBL;
import CSDAC.CSDTO.CSHormigaDTO;

public class CSButtonsPanel extends JPanel {

    JButton csBtnCrearLarva;
    JButton csBtnALimentar;
    JButton csBtnEliminar;
    JButton csBtnGuardar;
    CSSeccionExperimentosPanel csSeccionExperimentosPanel;

    public CSButtonsPanel(CSSeccionExperimentosPanel csSeccionExperimentosPanel){
        this.csSeccionExperimentosPanel = csSeccionExperimentosPanel;
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


        add(csBtnCrearLarva);
        add(csBtnALimentar);
        add(csBtnEliminar);
        add(csBtnGuardar);
    }

}
