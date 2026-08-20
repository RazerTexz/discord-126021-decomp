package lombok.installer.eclipse;

import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: discord-126021.apk:lombok/installer/eclipse/EclipseProductDescriptor.SCL.lombok */
public interface EclipseProductDescriptor {
    String getProductName();

    String getWindowsExecutableName();

    String getUnixAppName();

    String getMacAppName();

    String getDirectoryName();

    List<String> getExecutableNames();

    List<String> getSourceDirsOnWindows();

    List<String> getSourceDirsOnMac();

    List<String> getSourceDirsOnUnix();

    String getIniFileName();

    Pattern getLocationSelectors();

    URL getIdeIcon();
}
