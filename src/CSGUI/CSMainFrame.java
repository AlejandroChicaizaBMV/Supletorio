package CSGUI;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

public class CSMainFrame extends JFrame{
    CSMainPanel csMainPanel = new CSMainPanel();
    
    public CSMainFrame (String csTitleApp){
        csMainPanel = new CSMainPanel();
        csCustomizeComponent (csTitleApp);
    }

    private void csCustomizeComponent(String csTitleApp){
        setTitle(csTitleApp);
        setSize(750, 750);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        container.add(csMainPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
