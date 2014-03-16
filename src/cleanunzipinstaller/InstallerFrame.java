/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleanunzipinstaller;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kyle
 */
public class InstallerFrame extends JFrame
{

    public static int WIDTH = 500;
    public static int HEIGHT = 500;
    
    public static String WELCOME_TEXT = String.format("<html><div WIDTH=%d>%s</div><html>", 500/*Width*/, "Welcome to the CleanUnZip Install Wizard");//"Welcome to the CleanUnZip Install Wizard";
    
    JPanel mainPanel;
    JPanel mainPanelTop;
    JPanel mainPanelBottom;
    JLabel welcomeLabel;
    JButton button1;
    JButton button2;    

    public InstallerFrame() throws HeadlessException
    {
        this.button2 = new JButton("I");
        this.button1 = new JButton("H");
        this.mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        this.welcomeLabel = new JLabel(WELCOME_TEXT);
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Clean UnZip Installer");
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - (WIDTH / 2), Toolkit.getDefaultToolkit().getScreenSize().height / 2 - (HEIGHT / 2));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);        
        this.add(mainPanel);
                      
        mainPanelTop = new JPanel(new BoxLayout(mainPanelTop, BoxLayout.Y_AXIS));//new BoxLayout(mainPanelTop, BoxLayout.Y_AXIS)
        mainPanelBottom = new JPanel();//new BoxLayout(mainPanelBottom, BoxLayout.Y_AXIS)
        
        mainPanel.add(mainPanelTop);
        mainPanel.add(mainPanelBottom);
        
        mainPanelTop.add(welcomeLabel);
        mainPanelBottom.add(button1);
        mainPanelBottom.add(button2);
                
    }
}
