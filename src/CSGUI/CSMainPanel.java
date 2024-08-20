package CSGUI;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CSMainPanel extends JPanel {
    CSLogoPanel csLogoPanel                                 = new CSLogoPanel();
    CSSeccionExperimentosPanel csSeccionExperimentosPanel   = new CSSeccionExperimentosPanel();
    CSAlimentoIngestaPanel csAlimentoIngestaPanel           = new CSAlimentoIngestaPanel();
    CSButtonsPanel csButtonsPanel                           = new CSButtonsPanel();
    CSDatosPanel csDatosPanel                               = new CSDatosPanel();

    public CSMainPanel() {
        csCustomizeComponent();
    }

    private void csCustomizeComponent() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 30, 0, 30));

        add(csLogoPanel);
        add(csSeccionExperimentosPanel);
        add(csAlimentoIngestaPanel);
        add(csButtonsPanel);
        csButtonsPanel.setPreferredSize(new Dimension(690,50));
        add(csDatosPanel);
    }
}