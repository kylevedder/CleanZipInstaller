/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleanunzipinstaller;

import java.awt.Desktop;
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
public class InstallUils
{

    static String WIN_DOCS_PATH = "/Documents/CleanZip";

    public static void installPayload()
    {

//        System.out.println(System.getProperty("os.name"));
        if (System.getProperty("os.name").toLowerCase().equals("windows 7")
                || System.getProperty("os.name").toLowerCase().equals("windows 8")
                || System.getProperty("os.name").toLowerCase().equals("windows 8.1")
                || System.getProperty("os.name").toLowerCase().equals("windows vista"))
        {
//            System.out.println(System.getProperty("user.home") + WIN_DOCS_PATH);
            new File(System.getProperty("user.home") + WIN_DOCS_PATH).mkdirs();
            File jarPayload = new File(System.getProperty("user.home") + WIN_DOCS_PATH + "/CleanZip.jar");
            File batPayload = new File(System.getProperty("user.home") + WIN_DOCS_PATH + "/addRightClickWindows.bat");
            File readmePayload = new File(System.getProperty("user.home") + WIN_DOCS_PATH + "/README.txt");
            writeFile("payload/CleanZip.jar", jarPayload);
            generateBatFile(batPayload);
            writeFile("payload/README.txt", readmePayload);
        }
    }

    public static void generateBatFile(File outputFile)
    {
        OutputStream outStream = null;
        byte[] messageInBytes = null;
        try
        {

            outStream = new FileOutputStream(outputFile);
            String message = 
                    "@echo off\n\r"
                    + "SET st2Path=java -jar \"" + System.getProperty("user.home") + WIN_DOCS_PATH + "/CleanZip.jar" + "\"\n\r"
                    + " \n\r"
                    + "rem add it for all file types\n\r"
                    + "@reg add \"HKEY_CLASSES_ROOT\\*\\shell\\Open with CleanUnZip\"         /t REG_SZ /v \"\" /d \"Unzip with CleanZip\"   /f\n\r"
                    + "@reg add \"HKEY_CLASSES_ROOT\\*\\shell\\Open with CleanUnZip\\command\" /t REG_SZ /v \"\" /d \"%st2Path% \\\"%%1\\\"\" /f\n\r"
                    + "\n\r"
                    + "rem add it for folders\n\r"
                    + "@reg add \"HKEY_CLASSES_ROOT\\Folder\\shell\\Open with CleanZip\"         /t REG_SZ /v \"\" /d \"Zip with CleanZip\"   /f\n\r"
                    + "@reg add \"HKEY_CLASSES_ROOT\\Folder\\shell\\Open with CleanZip\\command\" /t REG_SZ /v \"\" /d \"%st2Path% \\\"%%1\\\"\" /f\n\r"
                    + "\n\r"
                    + "exit";
            messageInBytes = message.getBytes();
            outStream.write(messageInBytes);
            outStream.close();
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(InstallUils.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(InstallUils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void writeFile(String resourcePath, File outputFile)
    {
        try
        {
            InputStream inStream = null;
            OutputStream outStream = null;
            inStream = cleanunzipinstaller.CleanUnZipInstaller.class.getResourceAsStream(resourcePath);
            outStream = new FileOutputStream(outputFile);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0)
            {

                outStream.write(buffer, 0, length);

            }

            inStream.close();
            outStream.close();

//            System.out.println("File is copied successful!");
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(CleanUnZipInstaller.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(CleanUnZipInstaller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void runAddRightClickFile()
    {
        if (System.getProperty("os.name").toLowerCase().equals("windows 7")
                || System.getProperty("os.name").toLowerCase().equals("windows 8")
                || System.getProperty("os.name").toLowerCase().equals("windows 8.1")
                || System.getProperty("os.name").toLowerCase().equals("windows vista"))
        {
            try
            {
                Runtime.getRuntime().exec("cmd /c start " + System.getProperty("user.home") + WIN_DOCS_PATH + "/addRightClickWindows.bat");
            }
            catch (IOException ex)
            {
                Logger.getLogger(InstallUils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void openInstallLocation()
    {
        if (Desktop.isDesktopSupported())
        {
            try
            {
                Desktop.getDesktop().open(new File(System.getProperty("user.home") + WIN_DOCS_PATH));
            }
            catch (IOException ex)
            {
                Logger.getLogger(InstallUils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
