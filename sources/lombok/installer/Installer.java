package lombok.installer;

import com.zwitserloot.cmdreader.CmdReader;
import com.zwitserloot.cmdreader.Description;
import com.zwitserloot.cmdreader.InvalidCommandLineException;
import com.zwitserloot.cmdreader.Sequential;
import com.zwitserloot.cmdreader.Shorthand;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import lombok.Lombok;
import lombok.core.LombokApp;
import lombok.core.SpiLoadUtil;
import lombok.core.Version;
import lombok.installer.OsUtils;
import lombok.patcher.ClassRootFinder;

/* JADX INFO: loaded from: app.apk:lombok/installer/Installer.SCL.lombok */
public class Installer {
    static final URI ABOUT_LOMBOK_URL = URI.create("https://projectlombok.org");
    static final List<IdeLocationProvider> locationProviders;

    static {
        List<IdeLocationProvider> list = new ArrayList<>();
        try {
            for (IdeLocationProvider provider : SpiLoadUtil.findServices(IdeLocationProvider.class)) {
                list.add(provider);
            }
            locationProviders = Collections.unmodifiableList(list);
        } catch (IOException e) {
            throw Lombok.sneakyThrow(e);
        }
    }

    static List<Pattern> getIdeExecutableNames() {
        List<Pattern> list = new ArrayList<>();
        for (IdeLocationProvider provider : locationProviders) {
            Pattern p = provider.getLocationSelectors();
            if (p != null) {
                list.add(p);
            }
        }
        return list;
    }

    static IdeLocation tryAllProviders(String location) throws CorruptedIdeLocationException {
        for (IdeLocationProvider provider : locationProviders) {
            IdeLocation loc = provider.create(location);
            if (loc != null) {
                return loc;
            }
        }
        return null;
    }

    static void autoDiscover(List<IdeLocation> locations, List<CorruptedIdeLocationException> problems) {
        for (IdeLocationProvider provider : locationProviders) {
            provider.findIdes(locations, problems);
        }
    }

    public static boolean isSelf(String jar) {
        String self = ClassRootFinder.findClassRootOfClass(Installer.class);
        if (self == null) {
            return false;
        }
        File a = new File(jar).getAbsoluteFile();
        File b2 = new File(self).getAbsoluteFile();
        try {
            a = a.getCanonicalFile();
        } catch (IOException unused) {
        }
        try {
            b2 = b2.getCanonicalFile();
        } catch (IOException unused2) {
        }
        return a.equals(b2);
    }

    /* JADX INFO: loaded from: app.apk:lombok/installer/Installer$GraphicalInstallerApp.SCL.lombok */
    public static class GraphicalInstallerApp extends LombokApp {
        @Override // lombok.core.LombokApp
        public String getAppName() {
            return "installer";
        }

        @Override // lombok.core.LombokApp
        public String getAppDescription() {
            return "Runs the graphical installer tool (default).";
        }

        @Override // lombok.core.LombokApp
        public List<String> getAppAliases() {
            return Arrays.asList("");
        }

        @Override // lombok.core.LombokApp
        public int runApp(List<String> args) throws Exception {
            return Installer.guiInstaller();
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/installer/Installer$CommandLineInstallerApp.SCL.lombok */
    public static class CommandLineInstallerApp extends LombokApp {
        @Override // lombok.core.LombokApp
        public String getAppName() {
            return "install";
        }

        @Override // lombok.core.LombokApp
        public String getAppDescription() {
            return "Runs the 'handsfree' command line scriptable installer.";
        }

        @Override // lombok.core.LombokApp
        public int runApp(List<String> args) throws Exception {
            return Installer.cliInstaller(false, args);
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/installer/Installer$CommandLineUninstallerApp.SCL.lombok */
    public static class CommandLineUninstallerApp extends LombokApp {
        @Override // lombok.core.LombokApp
        public String getAppName() {
            return "uninstall";
        }

        @Override // lombok.core.LombokApp
        public String getAppDescription() {
            return "Runs the 'handsfree' command line scriptable uninstaller.";
        }

        @Override // lombok.core.LombokApp
        public int runApp(List<String> args) throws Exception {
            return Installer.cliInstaller(true, args);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.lang.Object, java.util.concurrent.atomic.AtomicReference<java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.concurrent.atomic.AtomicReference<java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Throwable] */
    private static int guiInstaller() {
        int iIntValue;
        if (OsUtils.getOS() == OsUtils.OS.MAC_OS_X) {
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Lombok Installer");
            System.setProperty("com.apple.macos.use-file-dialog-packages", "true");
        }
        try {
            SwingUtilities.invokeLater(new Runnable() { // from class: lombok.installer.Installer.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                        } catch (Exception unused) {
                        }
                        new InstallerGUI().show();
                    } catch (HeadlessException unused2) {
                        Installer.printHeadlessInfo();
                    }
                }
            });
            ?? r0 = InstallerGUI.exitMarker;
            synchronized (r0) {
                while (!Thread.interrupted() && InstallerGUI.exitMarker.get() == null) {
                    try {
                        try {
                            r0 = InstallerGUI.exitMarker;
                            r0.wait();
                        } catch (InterruptedException unused) {
                            return 1;
                        }
                    } catch (Throwable th) {
                        throw r0;
                    }
                }
                Integer errCode = InstallerGUI.exitMarker.get();
                iIntValue = errCode == null ? 1 : errCode.intValue();
            }
            return iIntValue;
        } catch (HeadlessException unused2) {
            printHeadlessInfo();
            return 1;
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/installer/Installer$CmdArgs.SCL.lombok */
    private static class CmdArgs {

        @Description("Specify paths to a location to install/uninstall. Use 'auto' to apply to all automatically discoverable installations.")
        @Sequential
        List<String> path = new ArrayList();

        @Description("Shows this help text")
        @Shorthand({"h", "?"})
        boolean help;

        private CmdArgs() {
        }
    }

    public static int cliInstaller(boolean uninstall, List<String> rawArgs) {
        CmdReader<CmdArgs> reader = CmdReader.of(CmdArgs.class);
        try {
            CmdArgs args = reader.make((String[]) rawArgs.toArray(new String[0]));
            if (args.help) {
                System.out.println(generateCliHelp(uninstall, reader));
                return 0;
            }
            if (args.path.isEmpty()) {
                System.err.println("ERROR: Nothing to do!");
                System.err.println("--------------------------");
                System.err.println(generateCliHelp(uninstall, reader));
                return 1;
            }
            List<IdeLocation> locations = new ArrayList<>();
            List<CorruptedIdeLocationException> problems = new ArrayList<>();
            if (args.path.contains("auto")) {
                autoDiscover(locations, problems);
            }
            for (String rawPath : args.path) {
                if (!rawPath.equals("auto")) {
                    try {
                        IdeLocation loc = tryAllProviders(rawPath);
                        if (loc != null) {
                            locations.add(loc);
                        } else {
                            problems.add(new CorruptedIdeLocationException("Can't find any IDE at: " + rawPath, null, null));
                        }
                    } catch (CorruptedIdeLocationException e) {
                        problems.add(e);
                    }
                }
            }
            int validLocations = locations.size();
            for (IdeLocation loc2 : locations) {
                if (uninstall) {
                    try {
                        loc2.uninstall();
                    } catch (InstallException e2) {
                        if (e2.isWarning()) {
                            System.err.printf("Warning while installing at %s:\n", loc2.getName());
                        } else {
                            System.err.printf("Installation at %s failed:\n", loc2.getName());
                            validLocations--;
                        }
                        System.err.println(e2.getMessage());
                    } catch (UninstallException e3) {
                        if (e3.isWarning()) {
                            System.err.printf("Warning while uninstalling at %s:\n", loc2.getName());
                        } else {
                            System.err.printf("Uninstall at %s failed:\n", loc2.getName());
                            validLocations--;
                        }
                        System.err.println(e3.getMessage());
                    }
                } else {
                    loc2.install();
                }
                PrintStream printStream = System.out;
                Object[] objArr = new Object[3];
                objArr[0] = uninstall ? "uninstalled" : "installed";
                objArr[1] = uninstall ? "from" : "to";
                objArr[2] = loc2.getName();
                printStream.printf("Lombok %s %s: %s\n", objArr);
            }
            for (CorruptedIdeLocationException problem : problems) {
                System.err.println("WARNING: " + problem.getMessage());
            }
            if (validLocations == 0) {
                System.err.println("WARNING: Zero valid locations found; so nothing was done!");
                return 0;
            }
            return 0;
        } catch (InvalidCommandLineException e4) {
            System.err.println(e4.getMessage());
            System.err.println("--------------------------");
            System.err.println(generateCliHelp(uninstall, reader));
            return 1;
        }
    }

    private static String generateCliHelp(boolean uninstall, CmdReader<CmdArgs> reader) {
        return reader.generateCommandLineHelp("java -jar lombok.jar " + (uninstall ? "uninstall" : "install"));
    }

    private static void printHeadlessInfo() {
        System.out.printf("About lombok v%s\nLombok makes java better by providing very spicy additions to the Java programming language,such as using @Getter to automatically generate a getter method for any field.\n\nBrowse to %s for more information. To install lombok on Eclipse, re-run this jar file on a graphical computer system - this message is being shown because your terminal is not graphics capable.\nAlternatively, use the command line installer (java -jar lombok.jar install --help).\nIf you are just using 'javac' or a tool that calls on javac, no installation is neccessary; just make sure lombok.jar is in the classpath when you compile. Example:\n\n   java -cp lombok.jar MyCode.java\n", Version.getVersion(), ABOUT_LOMBOK_URL);
    }
}
