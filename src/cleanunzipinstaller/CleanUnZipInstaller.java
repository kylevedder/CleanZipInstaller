/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleanunzipinstaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kyle
 */
public class CleanUnZipInstaller
{

    
    public static InstallerFrameStart f;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        f = new InstallerFrameStart();
        f.setVisible(true);
    }

    

}
