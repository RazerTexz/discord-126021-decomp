package lombok.installer.eclipse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.installer.CorruptedIdeLocationException;
import lombok.installer.IdeLocation;
import lombok.installer.InstallException;
import lombok.installer.Installer;
import lombok.installer.OsUtils;
import lombok.installer.OsUtils$OS;
import lombok.installer.UninstallException;

/* JADX INFO: loaded from: app.apk:lombok/installer/eclipse/EclipseProductLocation.SCL.lombok */
public final class EclipseProductLocation extends IdeLocation {
    private final EclipseProductDescriptor descriptor;
    private final String name;
    private final File eclipseIniPath;
    private final String pathToLombokJarPrefix;
    private final boolean hasLombok;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$installer$OsUtils$OS;
    private static final String OS_NEWLINE = OsUtils.getOS().getLineEnding();
    private static final Pattern JAVA_AGENT_LINE_MATCHER = Pattern.compile("^\\-javaagent\\:.*lombok.*\\.jar$", 2);
    private static final Pattern BOOTCLASSPATH_LINE_MATCHER = Pattern.compile("^\\-Xbootclasspath\\/a\\:(.*lombok.*\\.jar.*)$", 2);

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$installer$OsUtils$OS() {
        int[] iArr = $SWITCH_TABLE$lombok$installer$OsUtils$OS;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[OsUtils$OS.valuesCustom().length];
        try {
            iArr2[OsUtils$OS.MAC_OS_X.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[OsUtils$OS.UNIX.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[OsUtils$OS.WINDOWS.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$lombok$installer$OsUtils$OS = iArr2;
        return iArr2;
    }

    EclipseProductLocation(EclipseProductDescriptor descriptor, String nameOfLocation, File pathToEclipseIni) throws CorruptedIdeLocationException {
        this.descriptor = descriptor;
        this.name = nameOfLocation;
        this.eclipseIniPath = pathToEclipseIni;
        File p1 = pathToEclipseIni.getParentFile();
        File p2 = p1 == null ? null : p1.getParentFile();
        File p3 = p2 == null ? null : p2.getParentFile();
        if (p1 != null && p1.getName().equals("Eclipse") && p2 != null && p2.getName().equals("Contents") && p3 != null && p3.getName().endsWith(".app")) {
            this.pathToLombokJarPrefix = "../Eclipse/";
        } else {
            this.pathToLombokJarPrefix = "";
        }
        try {
            this.hasLombok = checkForLombok(this.eclipseIniPath);
        } catch (IOException e) {
            throw new CorruptedIdeLocationException("I can't read the configuration file of the " + descriptor.getProductName() + " installed at " + this.name + "\nYou may need to run this installer with root privileges if you want to modify that " + descriptor.getProductName() + ".", descriptor.getProductName(), e);
        }
    }

    public int hashCode() {
        return this.eclipseIniPath.hashCode();
    }

    public boolean equals(Object o) {
        if (o instanceof EclipseProductLocation) {
            return ((EclipseProductLocation) o).eclipseIniPath.equals(this.eclipseIniPath);
        }
        return false;
    }

    @Override // lombok.installer.IdeLocation
    public String getName() {
        return this.name;
    }

    @Override // lombok.installer.IdeLocation
    public boolean hasLombok() {
        return this.hasLombok;
    }

    private static boolean checkForLombok(File iniFile) throws IOException {
        String line;
        if (!iniFile.exists()) {
            return false;
        }
        FileInputStream fis = new FileInputStream(iniFile);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            do {
                line = br.readLine();
                if (line == null) {
                    br.close();
                    fis.close();
                    return false;
                }
            } while (!JAVA_AGENT_LINE_MATCHER.matcher(line.trim()).matches());
            br.close();
            fis.close();
            return true;
        } catch (Throwable th) {
            fis.close();
            throw th;
        }
    }

    private List<File> getUninstallDirs() {
        List<File> result = new ArrayList<>();
        File x2 = new File(this.name);
        if (!x2.isDirectory()) {
            x2 = x2.getParentFile();
        }
        if (x2.isDirectory()) {
            result.add(x2);
        }
        result.add(this.eclipseIniPath.getParentFile());
        return result;
    }

    @Override // lombok.installer.IdeLocation
    public void uninstall() throws UninstallException {
        List<File> lombokJarsForWhichCantDeleteSelf = new ArrayList<>();
        StringBuilder newContents = new StringBuilder();
        if (this.eclipseIniPath.exists()) {
            try {
                FileInputStream fis = new FileInputStream(this.eclipseIniPath);
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                    while (true) {
                        String line = br.readLine();
                        if (line == null) {
                            break;
                        }
                        if (!JAVA_AGENT_LINE_MATCHER.matcher(line).matches()) {
                            Matcher m = BOOTCLASSPATH_LINE_MATCHER.matcher(line);
                            if (m.matches()) {
                                StringBuilder elemBuilder = new StringBuilder();
                                elemBuilder.append("-Xbootclasspath/a:");
                                boolean first = true;
                                for (String elem : m.group(1).split(Pattern.quote(File.pathSeparator))) {
                                    if (!elem.toLowerCase().endsWith("lombok.jar") && !elem.toLowerCase().endsWith("lombok.eclipse.agent.jar")) {
                                        if (first) {
                                            first = false;
                                        } else {
                                            elemBuilder.append(File.pathSeparator);
                                        }
                                        elemBuilder.append(elem);
                                    }
                                }
                                if (!first) {
                                    newContents.append(elemBuilder.toString()).append(OS_NEWLINE);
                                }
                            } else {
                                newContents.append(line).append(OS_NEWLINE);
                            }
                        }
                    }
                    br.close();
                    fis.close();
                    FileOutputStream fos = new FileOutputStream(this.eclipseIniPath);
                    try {
                        fos.write(newContents.toString().getBytes());
                        fos.close();
                    } catch (Throwable th) {
                        fos.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    fis.close();
                    throw th2;
                }
            } catch (IOException e) {
                throw new UninstallException("Cannot uninstall lombok from " + this.name + generateWriteErrorMessage(), e);
            }
        }
        for (File dir : getUninstallDirs()) {
            File lombokJar = new File(dir, "lombok.jar");
            if (lombokJar.exists() && !lombokJar.delete()) {
                if (OsUtils.getOS() == OsUtils$OS.WINDOWS && Installer.isSelf(lombokJar.getAbsolutePath())) {
                    lombokJarsForWhichCantDeleteSelf.add(lombokJar);
                } else {
                    throw new UninstallException("Can't delete " + lombokJar.getAbsolutePath() + generateWriteErrorMessage(), null);
                }
            }
            File agentJar = new File(dir, "lombok.eclipse.agent.jar");
            if (agentJar.exists()) {
                agentJar.delete();
            }
        }
        if (!lombokJarsForWhichCantDeleteSelf.isEmpty()) {
            throw new UninstallException(true, String.format("lombok.jar cannot delete itself on windows.\nHowever, lombok has been uncoupled from your %s.\nYou can safely delete this jar file. You can find it at:\n%s", this.descriptor.getProductName(), lombokJarsForWhichCantDeleteSelf.get(0).getAbsolutePath()), null);
        }
    }

    private static String generateWriteErrorMessage() {
        String osSpecificError;
        switch ($SWITCH_TABLE$lombok$installer$OsUtils$OS()[OsUtils.getOS().ordinal()]) {
            case 1:
            case 3:
            default:
                osSpecificError = ":\nStart terminal, go to the directory with lombok.jar, and run: sudo java -jar lombok.jar";
                break;
            case 2:
                osSpecificError = ":\nStart a new cmd (dos box) with admin privileges, go to the directory with lombok.jar, and run: java -jar lombok.jar";
                break;
        }
        return ", probably because this installer does not have the access rights.\nTry re-running the installer with administrative privileges" + osSpecificError;
    }

    @Override // lombok.installer.IdeLocation
    public String install() throws InstallException {
        String pathPrefix;
        boolean fullPathRequired = !"false".equals(System.getProperty("lombok.installer.fullpath", "true"));
        StringBuilder newContents = new StringBuilder();
        File lombokJar = new File(this.eclipseIniPath.getParentFile(), "lombok.jar");
        if (!Installer.isSelf(lombokJar.getAbsolutePath())) {
            File ourJar = findOurJar();
            byte[] b2 = new byte[524288];
            try {
                FileOutputStream out = new FileOutputStream(lombokJar);
                try {
                    InputStream in = new FileInputStream(ourJar);
                    while (true) {
                        try {
                            int r = in.read(b2);
                            if (r == -1) {
                                break;
                            }
                            if (r > 0) {
                            }
                            out.write(b2, 0, r);
                        } catch (Throwable th) {
                            in.close();
                            throw th;
                        }
                    }
                    in.close();
                    out.close();
                } catch (Throwable th2) {
                    out.close();
                    throw th2;
                }
            } catch (IOException e) {
                try {
                    lombokJar.delete();
                } catch (Throwable unused) {
                }
                if (1 == 0) {
                    throw new InstallException("I can't read my own jar file (trying: " + ourJar.toString() + "). I think you've found a bug in this installer!\nI suggest you restart it and use the 'what do I do' link, to manually install lombok. Also, tell us about this at:\nhttp://groups.google.com/group/project-lombok - Thanks!\n\n[DEBUG INFO] " + e.getClass() + ": " + e.getMessage() + "\nBase: " + OsUtils.class.getResource("OsUtils.class"), e);
                }
                throw new InstallException("I can't write to your " + this.descriptor.getProductName() + " directory at " + this.name + generateWriteErrorMessage(), e);
            }
        }
        new File(lombokJar.getParentFile(), "lombok.eclipse.agent.jar").delete();
        try {
            try {
                FileInputStream fis = new FileInputStream(this.eclipseIniPath);
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                    while (true) {
                        String line = br.readLine();
                        if (line == null) {
                            break;
                        }
                        if (!JAVA_AGENT_LINE_MATCHER.matcher(line).matches()) {
                            Matcher m = BOOTCLASSPATH_LINE_MATCHER.matcher(line);
                            if (m.matches()) {
                                StringBuilder elemBuilder = new StringBuilder();
                                elemBuilder.append("-Xbootclasspath/a:");
                                boolean first = true;
                                for (String elem : m.group(1).split(Pattern.quote(File.pathSeparator))) {
                                    if (!elem.toLowerCase().endsWith("lombok.jar") && !elem.toLowerCase().endsWith("lombok.eclipse.agent.jar")) {
                                        if (first) {
                                            first = false;
                                        } else {
                                            elemBuilder.append(File.pathSeparator);
                                        }
                                        elemBuilder.append(elem);
                                    }
                                }
                                if (!first) {
                                    newContents.append(elemBuilder.toString()).append(OS_NEWLINE);
                                }
                            } else {
                                newContents.append(line).append(OS_NEWLINE);
                            }
                        }
                    }
                    br.close();
                    fis.close();
                    if (fullPathRequired) {
                        pathPrefix = String.valueOf(lombokJar.getParentFile().getCanonicalPath()) + File.separator;
                    } else {
                        pathPrefix = this.pathToLombokJarPrefix;
                    }
                    newContents.append(String.format("-javaagent:%s", escapePath(String.valueOf(pathPrefix) + "lombok.jar"))).append(OS_NEWLINE);
                    FileOutputStream fos = new FileOutputStream(this.eclipseIniPath);
                    try {
                        fos.write(newContents.toString().getBytes());
                        fos.close();
                        if (1 == 0) {
                            try {
                                lombokJar.delete();
                            } catch (Throwable unused2) {
                            }
                        }
                        if (1 == 0) {
                            throw new InstallException("I can't find the " + this.descriptor.getIniFileName() + " file. Is this a real " + this.descriptor.getProductName() + " installation?", null);
                        }
                        return "If you start " + this.descriptor.getProductName() + " with a custom -vm parameter, you'll need to add:<br><code>-vmargs -javaagent:lombok.jar</code><br>as parameter as well.";
                    } catch (Throwable th3) {
                        fos.close();
                        throw th3;
                    }
                } catch (Throwable th4) {
                    fis.close();
                    throw th4;
                }
            } catch (IOException e2) {
                throw new InstallException("Cannot install lombok at " + this.name + generateWriteErrorMessage(), e2);
            }
        } catch (Throwable th5) {
            if (0 == 0) {
                try {
                    lombokJar.delete();
                } catch (Throwable unused3) {
                }
            }
            throw th5;
        }
    }

    @Override // lombok.installer.IdeLocation
    public URL getIdeIcon() {
        return this.descriptor.getIdeIcon();
    }
}
