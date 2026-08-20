package lombok.installer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import lombok.core.Version;

/* JADX INFO: loaded from: discord-126021.apk:lombok/installer/OsUtils.SCL.lombok */
public final class OsUtils {
    private static final AtomicBoolean windowsDriveInfoLibLoaded = new AtomicBoolean(false);

    private OsUtils() {
    }

    private static void loadWindowsDriveInfoLib() throws IOException {
        if (windowsDriveInfoLibLoaded.compareAndSet(false, true)) {
            String prefix = "lombok-" + Version.getVersion() + "-";
            File temp = File.createTempFile("lombok", ".mark");
            File dll1 = new File(temp.getParentFile(), String.valueOf(prefix) + "WindowsDriveInfo-i386.dll");
            File dll2 = new File(temp.getParentFile(), String.valueOf(prefix) + "WindowsDriveInfo-x86_64.dll");
            temp.delete();
            dll1.deleteOnExit();
            dll2.deleteOnExit();
            try {
                if (unpackDLL("WindowsDriveInfo-i386.binary", dll1)) {
                    System.load(dll1.getAbsolutePath());
                    return;
                }
            } catch (Throwable unused) {
            }
            try {
                if (unpackDLL("WindowsDriveInfo-x86_64.binary", dll2)) {
                    System.load(dll2.getAbsolutePath());
                }
            } catch (Throwable unused2) {
            }
        }
    }

    private static boolean unpackDLL(String dllName, File target) throws IOException {
        InputStream in = OsUtils.class.getResourceAsStream(dllName);
        try {
            try {
                FileOutputStream out = new FileOutputStream(target);
                try {
                    byte[] b2 = new byte[32000];
                    while (true) {
                        int r = in.read(b2);
                        if (r != -1) {
                            out.write(b2, 0, r);
                        } else {
                            out.close();
                            in.close();
                            return true;
                        }
                    }
                } catch (Throwable th) {
                    out.close();
                    throw th;
                }
            } catch (Throwable th2) {
                in.close();
                throw th2;
            }
        } catch (IOException unused) {
            boolean z2 = target.exists() && target.canRead();
            in.close();
            return z2;
        }
    }

    public static List<String> getDrivesOnWindows() throws Throwable {
        loadWindowsDriveInfoLib();
        List<String> drives = new ArrayList<>();
        WindowsDriveInfo info = new WindowsDriveInfo();
        for (String drive : info.getLogicalDrives()) {
            if (info.isFixedDisk(drive)) {
                drives.add(drive);
            }
        }
        return drives;
    }

    /* JADX INFO: renamed from: lombok.installer.OsUtils$OS */
    /* JADX INFO: loaded from: discord-126021.apk:lombok/installer/OsUtils$OS.SCL.lombok */
    public enum EnumC12884OS {
        MAC_OS_X("\n"),
        WINDOWS("\r\n"),
        UNIX("\n");

        private final String lineEnding;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static EnumC12884OS[] valuesCustom() {
            EnumC12884OS[] enumC12884OSArrValuesCustom = values();
            int length = enumC12884OSArrValuesCustom.length;
            EnumC12884OS[] enumC12884OSArr = new EnumC12884OS[length];
            System.arraycopy(enumC12884OSArrValuesCustom, 0, enumC12884OSArr, 0, length);
            return enumC12884OSArr;
        }

        EnumC12884OS(String lineEnding) {
            this.lineEnding = lineEnding;
        }

        public String getLineEnding() {
            return this.lineEnding;
        }
    }

    public static EnumC12884OS getOS() {
        String prop = System.getProperty("os.name", "").toLowerCase();
        if (!prop.matches("^.*\\bmac\\b.*$") && !prop.matches("^.*\\bdarwin\\b.*$")) {
            return prop.matches("^.*\\bwin(dows|32|64)?\\b.*$") ? EnumC12884OS.WINDOWS : EnumC12884OS.UNIX;
        }
        return EnumC12884OS.MAC_OS_X;
    }
}
