package CSGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class CSLogoPanel extends JPanel{

    public CSLogoPanel() {
        customizeComponent();
    }

    private void customizeComponent() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel csLogoPnl = new JPanel();
        csLogoPnl.setLayout(new BorderLayout());

        ImageIcon logoIcon = new ImageIcon(new ImageIcon("src\\CSGUI\\Resourses\\csLogo.png")
                                           .getImage()
                                           .getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        
        JLabel csLogoLbl = new JLabel(logoIcon);
        csLogoPnl.add(csLogoLbl, BorderLayout.CENTER);
        JLabel csNamelbl = new JLabel("Hormiguero Virtual", SwingConstants.CENTER);
        csLogoPnl.add(csNamelbl, BorderLayout.SOUTH);
        
        add(csLogoPnl);
    }
}
