package CSGUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import CSBL.CSHormigaBL;
import CSBL.CSHormigueroBL;
import CSBL.Entities.CSGenoAlimento;
import CSBL.Entities.CSHormiga;
import CSBL.Entities.CSIngestaNativa;
import CSDAC.CSHormigaDAO;
import CSDAC.CSDTO.CSHormigaDTO;
import CSInfra.CSAppException;
import CSInfra.Config;

public class CSButtonsPanel extends JPanel {

    JButton csBtnCrearLarva;
    JButton csBtnALimentar;
    JButton csBtnEliminar;
    JButton csBtnGuardar;
    CSSeccionExperimentosPanel csSeccionExperimentosPanel;
    CSAlimentoIngestaPanel csAlimentoIngestaPanel;
    private CSHormigueroBL csHormigueroBL = new CSHormigueroBL() ;

    public CSButtonsPanel(CSSeccionExperimentosPanel csSeccionExperimentosPanel, CSAlimentoIngestaPanel csAlimentoIngestaPanel){
        this.csSeccionExperimentosPanel = csSeccionExperimentosPanel;
        this.csAlimentoIngestaPanel = csAlimentoIngestaPanel;
        csCustomizeComponent();
    }

   private void csCustomizeComponent() {
    setLayout(new FlowLayout(FlowLayout.CENTER, 10 , 35));
    setBackground(Color.decode("0xd1d1d1"));
    
    csBtnCrearLarva = new JButton("Crear Larva");
    csBtnALimentar = new JButton("Alimentar");
    csBtnEliminar = new JButton("Eliminar");
    csBtnGuardar = new JButton("Guardar");

    csBtnCrearLarva.addActionListener(e -> {
        // Mostrar el cuadro de diálogo de confirmación
        int option = JOptionPane.showConfirmDialog(
            this,
            "¿Está seguro de crear una nueva larva?",
            "Confirmar Creación de Larva",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        // Verificar la respuesta del usuario
        if (option == JOptionPane.YES_OPTION) {
            try {
                csSeccionExperimentosPanel.csAddLarva();
                JOptionPane.showMessageDialog(this, "Larva creada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (CSAppException e1) {
                JOptionPane.showMessageDialog(this, "Error al crear la larva: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e1.printStackTrace();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, "Error inesperado: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e1.printStackTrace();
            }
        }
    });

    csBtnEliminar.addActionListener(e -> {
        int option = JOptionPane.showConfirmDialog(
            this,
            "¿Seguro que la quiere matar?",
            "Confirmar Eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
    
        if (option == JOptionPane.YES_OPTION) {
            try {
                csSeccionExperimentosPanel.csMatar();
                System.out.println(csHormigueroBL.eliminarHormiga(csSeccionExperimentosPanel.getCsRowSelect()));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    });
    

    csBtnGuardar.addActionListener(e -> {
        List<CSHormiga> csHormigasList = csSeccionExperimentosPanel.csGetAllRows();
        CSHormigueroBL csHormigueroBL = new CSHormigueroBL();

        CSHormigaDAO csHormigaDAO = new CSHormigaDAO(Config.DATAFILE);
        try {
            csHormigaDAO.csCreate(csHormigasList);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            System.out.println(csHormigueroBL.guardarHormiguero());
        } catch (CSAppException e1) {
            e1.printStackTrace();
        }
    });

    csBtnALimentar.addActionListener(e -> {
        CSGenoAlimento genoAlimentoSeleccionado = (CSGenoAlimento) csAlimentoIngestaPanel.getCsCBoxGenoAlimento().getSelectedItem();
        CSIngestaNativa ingestaNativaSeleccionada = (CSIngestaNativa) csAlimentoIngestaPanel.getCsCBoxIngestaNativa().getSelectedItem();
        
        System.out.println("Geno Alimento Seleccionado: " + genoAlimentoSeleccionado);
        System.out.println("Ingesta Nativa Seleccionada: " + ingestaNativaSeleccionada);

        if (genoAlimentoSeleccionado.toString().equals("XY")) {
            csSeccionExperimentosPanel.csEvolucion();
        }
        String ingestaNativaStr = ingestaNativaSeleccionada.toString();

        if (csSeccionExperimentosPanel.csGetIngesta().equals("Omnivoro") &&
        (ingestaNativaStr.equals("Nectarivoro") || ingestaNativaStr.equals("Insectivoro"))) {
        csSeccionExperimentosPanel.csMatar();
    }
    });

    add(csBtnCrearLarva);
    add(csBtnALimentar);
    add(csBtnEliminar);
    add(csBtnGuardar);
}
}
