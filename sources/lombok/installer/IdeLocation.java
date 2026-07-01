package lombok.installer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import lombok.installer.OsUtils;
import lombok.patcher.ClassRootFinder;

/* JADX INFO: loaded from: app.apk:lombok/installer/IdeLocation.SCL.lombok */
public abstract class IdeLocation {
    boolean selected = true;
    private static final String LEGAL_PATH_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.-_/";
    private static final String LEGAL_PATH_CHARS_WINDOWS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,/;'[]{}!@#$^&()-_+= :\\";

    public abstract String install() throws InstallException;

    public abstract void uninstall() throws UninstallException;

    public abstract String getName();

    public abstract boolean hasLombok();

    public abstract URL getIdeIcon();

    public static File findOurJar() {
        return new File(ClassRootFinder.findClassRootOfClass(OsUtils.class));
    }

    public String toString() {
        return getName();
    }

    public static String canonical(File p) {
        try {
            return p.getCanonicalPath();
        } catch (IOException unused) {
            String x2 = p.getAbsolutePath();
            return x2 == null ? p.getPath() : x2;
        }
    }

    public static String escapePath(String path) {
        StringBuilder out = new StringBuilder();
        String legalChars = OsUtils.getOS() == OsUtils.OS.UNIX ? LEGAL_PATH_CHARS : LEGAL_PATH_CHARS_WINDOWS;
        for (char c : path.toCharArray()) {
            if (legalChars.indexOf(c) == -1) {
                out.append('\\');
            }
            out.append(c);
        }
        return out.toString();
    }
}
