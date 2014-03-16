CleanZipInstaller
=================

Installer program for CleanZip.

For quick install on Windows, download CleanZipInstaller.exe. It was created by wrapping the jar using Launch4j.

This program sets up all needed directories and assets for CleanZip to operate. Currently, the right-click functionality only works on Windows and only if the executable is run with admin privileges. If the executable is not run with admin privileges or the jar is run instead, run the "addRightClickWindows.bat" as an admin for the right-click functionality to be added.

The files created by this installer not programmatically generated can be viewed in /src/cleanunzipinstaller/payload and programmatically generated files can be viewed inside /src/cleanunzipinstaller/InstallerUtils.java.
