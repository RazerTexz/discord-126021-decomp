package lombok.core;

import com.adjust.sdk.Constants;
import java.io.InputStream;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/Version.SCL.lombok */
public class Version {
    private static final String VERSION = "1.18.16";
    private static final String RELEASE_NAME = "Envious Ferret";

    private Version() {
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.printf("%s\n", getFullVersion());
        } else {
            System.out.println(VERSION);
        }
    }

    public static String getVersion() {
        return VERSION;
    }

    public static String getReleaseName() {
        return RELEASE_NAME;
    }

    public static String getFullVersion() {
        InputStream in;
        int r;
        String version = String.format("v%s \"%s\"", VERSION, RELEASE_NAME);
        if (isEdgeRelease() && (in = Version.class.getResourceAsStream("/release-timestamp.txt")) != null) {
            try {
                byte[] data = new byte[65536];
                int p = 0;
                while (p < data.length && (r = in.read(data, p, data.length - p)) != -1) {
                    p += r;
                }
                String timestamp = new String(data, Constants.ENCODING).trim();
                return String.valueOf(version) + " - " + timestamp;
            } catch (Exception unused) {
                try {
                    in.close();
                } catch (Exception unused2) {
                }
                return version;
            }
        }
        return version;
    }

    public static boolean isEdgeRelease() {
        int lastIdx = VERSION.lastIndexOf(46);
        if (lastIdx == -1) {
            return false;
        }
        try {
            return Integer.parseInt(VERSION.substring(lastIdx + 1)) % 2 == 1;
        } catch (Exception unused) {
            return false;
        }
    }
}
