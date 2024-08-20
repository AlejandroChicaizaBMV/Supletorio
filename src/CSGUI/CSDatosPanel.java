package CSGUI;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CSDatosPanel extends JPanel{
    private static final String csMateria = "Programacion II";
    private static final String csNCedula = "1727432260";
    private static final String csNombre  = "Sebastian Chicaiza";

    public CSDatosPanel() {
        csCustomizeComponent();
    }

    private void csCustomizeComponent() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
        setPreferredSize(new Dimension(690,10));
        JLabel csMateriaLbl = new JLabel(csMateria);
        JLabel csNCedulaLbl = new JLabel("Cedula: "+csNCedula);
        JLabel csNombreLbl  = new JLabel("Nombre: "+csNombre);

        add(csMateriaLbl);
        add(csNCedulaLbl);
        add(csNombreLbl);
    }
}
