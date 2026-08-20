package lombok.core.runtimeDependencies;

import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.zwitserloot.cmdreader.CmdReader;
import com.zwitserloot.cmdreader.Description;
import com.zwitserloot.cmdreader.InvalidCommandLineException;
import com.zwitserloot.cmdreader.Mandatory;
import com.zwitserloot.cmdreader.Requires;
import com.zwitserloot.cmdreader.Shorthand;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import lombok.core.LombokApp;
import lombok.core.SpiLoadUtil;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/runtimeDependencies/CreateLombokRuntimeApp.SCL.lombok */
public class CreateLombokRuntimeApp extends LombokApp {
    private List<RuntimeDependencyInfo> infoObjects;

    @Override // lombok.core.LombokApp
    public String getAppName() {
        return "createRuntime";
    }

    @Override // lombok.core.LombokApp
    public String getAppDescription() {
        return "Creates a small lombok-runtime.jar with the runtime\ndependencies of all lombok transformations that have them,\nand prints the names of each lombok transformation that\nrequires the lombok-runtime.jar at runtime.";
    }

    @Override // lombok.core.LombokApp
    public List<String> getAppAliases() {
        return Arrays.asList("runtime");
    }

    /* JADX INFO: loaded from: discord-126021.apk:lombok/core/runtimeDependencies/CreateLombokRuntimeApp$CmdArgs.SCL.lombok */
    private static class CmdArgs {

        @Description("Prints those lombok transformations that require lombok-runtime.jar.")
        @Mandatory(onlyIfNot = {"create"})
        @Shorthand({"p"})
        boolean print;

        @Description("Creates the lombok-runtime.jar.")
        @Mandatory(onlyIfNot = {"print"})
        @Shorthand({"c"})
        boolean create;

        @Requires({"create"})
        @Description("Where to write the lombok-runtime.jar. Defaults to the current working directory.")
        @Shorthand({"o"})
        String output;

        @Description("Shows this help text")
        boolean help;

        private CmdArgs() {
        }
    }

    @Override // lombok.core.LombokApp
    public int runApp(List<String> rawArgs) throws Exception {
        CmdReader<CmdArgs> reader = CmdReader.m9327of(CmdArgs.class);
        try {
            CmdArgs args = reader.make((String[]) rawArgs.toArray(new String[0]));
            if (args.help) {
                printHelp(reader, null, System.out);
                return 0;
            }
            initializeInfoObjects();
            if (args.print) {
                printRuntimeDependents();
            }
            int errCode = 0;
            if (args.create) {
                File out = new File("./lombok-runtime.jar");
                if (args.output != null) {
                    out = new File(args.output);
                    if (out.isDirectory()) {
                        out = new File(out, "lombok-runtime.jar");
                    }
                }
                try {
                    errCode = writeRuntimeJar(out);
                } catch (Exception e) {
                    System.err.println("ERROR: Creating " + canonical(out) + " failed: ");
                    e.printStackTrace();
                    return 1;
                }
            }
            return errCode;
        } catch (InvalidCommandLineException e2) {
            printHelp(reader, e2.getMessage(), System.err);
            return 1;
        }
    }

    private void printRuntimeDependents() {
        List<String> descriptions = new ArrayList<>();
        for (RuntimeDependencyInfo info : this.infoObjects) {
            descriptions.addAll(info.getRuntimeDependentsDescriptions());
        }
        if (descriptions.isEmpty()) {
            System.out.println("Not printing dependents: No lombok transformations currently have any runtime dependencies!");
            return;
        }
        System.out.println("Using any of these lombok features means your app will need lombok-runtime.jar:");
        for (String desc : descriptions) {
            System.out.println(desc);
        }
    }

    private int writeRuntimeJar(File outFile) throws Exception {
        Map<String, Class<?>> deps = new LinkedHashMap<>();
        for (RuntimeDependencyInfo info : this.infoObjects) {
            List<String> depNames = info.getRuntimeDependencies();
            if (depNames != null) {
                for (String depName : depNames) {
                    if (!deps.containsKey(depName)) {
                        deps.put(depName, info.getClass());
                    }
                }
            }
        }
        if (deps.isEmpty()) {
            System.out.println("Not generating lombok-runtime.jar: No lombok transformations currently have any runtime dependencies!");
            return 1;
        }
        OutputStream out = new FileOutputStream(outFile);
        try {
            JarOutputStream jar = new JarOutputStream(out);
            deps.put("LICENSE", CreateLombokRuntimeApp.class);
            deps.put("AUTHORS", CreateLombokRuntimeApp.class);
            for (Map.Entry<String, Class<?>> dep : deps.entrySet()) {
                InputStream in = dep.getValue().getResourceAsStream(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN + dep.getKey());
                if (in == null) {
                    throw new Fail(String.format("Dependency %s contributed by %s cannot be found", dep.getKey(), dep.getValue()));
                }
                try {
                    writeIntoJar(jar, dep.getKey(), in);
                    if (in != null) {
                        in.close();
                    }
                } catch (Throwable th) {
                    if (in != null) {
                        in.close();
                    }
                    throw th;
                }
            }
            jar.close();
            out.close();
            System.out.println("Successfully created: " + canonical(outFile));
            return 0;
        } catch (Throwable t) {
            try {
                out.close();
            } catch (Throwable unused) {
            }
            if (0 == 0) {
                outFile.delete();
            }
            if (t instanceof Fail) {
                System.err.println(t.getMessage());
                return 1;
            }
            if (t instanceof Exception) {
                throw ((Exception) t);
            }
            if (t instanceof Error) {
                throw ((Error) t);
            }
            throw new Exception(t);
        }
    }

    private void writeIntoJar(JarOutputStream jar, String depName, InputStream in) throws IOException {
        jar.putNextEntry(new ZipEntry(depName));
        byte[] b2 = new byte[65536];
        while (true) {
            int r = in.read(b2);
            if (r != -1) {
                jar.write(b2, 0, r);
            } else {
                jar.closeEntry();
                in.close();
                return;
            }
        }
    }

    /* JADX INFO: loaded from: discord-126021.apk:lombok/core/runtimeDependencies/CreateLombokRuntimeApp$Fail.SCL.lombok */
    private static class Fail extends Exception {
        Fail(String message) {
            super(message);
        }
    }

    private void initializeInfoObjects() throws IOException {
        this.infoObjects = SpiLoadUtil.readAllFromIterator(SpiLoadUtil.findServices(RuntimeDependencyInfo.class));
    }

    private static String canonical(File out) {
        try {
            return out.getCanonicalPath();
        } catch (Exception unused) {
            return out.getAbsolutePath();
        }
    }

    private void printHelp(CmdReader<CmdArgs> reader, String message, PrintStream out) {
        if (message != null) {
            out.println(message);
            out.println("----------------------------");
        }
        out.println(reader.generateCommandLineHelp("java -jar lombok.jar createRuntime"));
    }
}
