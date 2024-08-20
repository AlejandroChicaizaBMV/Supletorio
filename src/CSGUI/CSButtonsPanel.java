package CSGUI;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CSButtonsPanel extends JPanel {

    JButton csBtnCrearLarva;
    JButton csBtnALimentar;
    JButton csBtnEliminar;
    JButton csBtnGuardar; 
    public CSButtonsPanel(){
        csCustomizeComponent();
    }

    private void csCustomizeComponent(){
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 10 , 35));
        setBackground(Color.decode("0xd1d1d1"));
        csBtnCrearLarva= new JButton("Crear Larva");
        csBtnALimentar = new JButton("Alimentar");
        csBtnEliminar  = new JButton("Eliminar");
        csBtnGuardar   = new JButton("Guardar");

        add(csBtnCrearLarva);
        add(csBtnALimentar);
        add(csBtnEliminar);
        add(csBtnGuardar);
    }
}
