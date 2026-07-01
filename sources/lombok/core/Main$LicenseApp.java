package lombok.core;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: app.apk:lombok/core/Main$LicenseApp.SCL.lombok */
public class Main$LicenseApp extends LombokApp {
    @Override // lombok.core.LombokApp
    public String getAppName() {
        return "license";
    }

    @Override // lombok.core.LombokApp
    public String getAppDescription() {
        return "prints license information.";
    }

    @Override // lombok.core.LombokApp
    public List<String> getAppAliases() {
        return Arrays.asList("licence", "copyright", "copyleft", "gpl");
    }

    @Override // lombok.core.LombokApp
    public int runApp(List<String> args) {
        try {
            InputStream in = Main.class.getResourceAsStream("/LICENSE");
            try {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte[] b2 = new byte[65536];
                while (true) {
                    int r = in.read(b2);
                    if (r != -1) {
                        out.write(b2, 0, r);
                    } else {
                        System.out.println(new String(out.toByteArray()));
                        return 0;
                    }
                }
            } finally {
                in.close();
            }
        } catch (Exception unused) {
            System.err.println("License file not found. Check https://projectlombok.org/LICENSE");
            return 1;
        }
    }
}
