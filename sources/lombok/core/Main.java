package lombok.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: app.apk:lombok/core/Main.SCL.lombok */
public class Main {
    private static final Collection<?> HELP_SWITCHES = Collections.unmodifiableList(Arrays.asList("/?", "/h", "/help", "-h", "-help", "--help", "help", "h"));
    private final List<LombokApp> apps;
    private final List<String> args;

    public static void main(String[] args) throws IOException {
        Thread.currentThread().setContextClassLoader(Main.class.getClassLoader());
        int err = new Main(SpiLoadUtil.readAllFromIterator(SpiLoadUtil.findServices(LombokApp.class)), Arrays.asList(args)).go();
        if (err != 0) {
            System.exit(err);
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/core/Main$VersionApp.SCL.lombok */
    public static class VersionApp extends LombokApp {
        @Override // lombok.core.LombokApp
        public String getAppName() {
            return "version";
        }

        @Override // lombok.core.LombokApp
        public String getAppDescription() {
            return "prints lombok's version.";
        }

        @Override // lombok.core.LombokApp
        public List<String> getAppAliases() {
            return Arrays.asList("-version", "--version");
        }

        @Override // lombok.core.LombokApp
        public int runApp(List<String> args) {
            System.out.println(Version.getFullVersion());
            return 0;
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/core/Main$LicenseApp.SCL.lombok */
    public static class LicenseApp extends LombokApp {
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

    public Main(List<LombokApp> apps, List<String> args) {
        this.apps = apps;
        this.args = args;
    }

    public int go() {
        if (!this.args.isEmpty() && HELP_SWITCHES.contains(this.args.get(0))) {
            printHelp(null, System.out);
            return 0;
        }
        String command = this.args.isEmpty() ? "" : this.args.get(0).trim();
        if (command.startsWith("--")) {
            command = command.substring(2);
        } else if (command.startsWith("-")) {
            command = command.substring(1);
        }
        List<String> subArgs = this.args.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(this.args.subList(1, this.args.size()));
        for (LombokApp app : this.apps) {
            if (app.getAppName().equals(command) || app.getAppAliases().contains(command)) {
                try {
                    return app.runApp(subArgs);
                } catch (Exception e) {
                    e.printStackTrace();
                    return 5;
                }
            }
        }
        printHelp("Unknown command: " + command, System.err);
        return 1;
    }

    public void printHelp(String message, PrintStream out) {
        if (message != null) {
            out.println(message);
            out.println("------------------------------");
        }
        out.println("projectlombok.org " + Version.getFullVersion());
        out.println("Copyright (C) 2009-2018 The Project Lombok Authors.");
        out.println("Run 'lombok license' to see the lombok license agreement.");
        out.println();
        out.println("Run lombok without any parameters to start the graphical installer.");
        out.println("Other available commands:");
        for (LombokApp app : this.apps) {
            if (!app.isDebugTool()) {
                String[] desc = app.getAppDescription().split("\n");
                int i = 0;
                while (i < desc.length) {
                    Object[] objArr = new Object[2];
                    objArr[0] = i == 0 ? app.getAppName() : "";
                    objArr[1] = desc[i];
                    out.printf("  %15s    %s\n", objArr);
                    i++;
                }
            }
        }
        out.println();
        out.println("Run lombok commandName --help for more info on each command.");
    }
}
