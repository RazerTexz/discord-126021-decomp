package lombok.core;

import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import lombok.Lombok;
import lombok.patcher.ClassRootFinder;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/PublicApiCreatorApp.SCL.lombok */
public class PublicApiCreatorApp extends LombokApp {
    @Override // lombok.core.LombokApp
    public String getAppName() {
        return "publicApi";
    }

    @Override // lombok.core.LombokApp
    public String getAppDescription() {
        return "Creates a small lombok-api.jar with the annotations and other public API\nclasses of all lombok features. This is primarily useful to include in your\nandroid projects.";
    }

    @Override // lombok.core.LombokApp
    public int runApp(List<String> rawArgs) throws Exception {
        String loc = ".";
        switch (rawArgs.size()) {
            case 0:
                break;
            case 1:
                loc = rawArgs.get(0);
                break;
            default:
                System.err.println("Supply 1 path to specify the directory where lombok-api.jar will be created. No path means the current directory is used.");
                return 1;
        }
        File out = new File(loc, "lombok-api.jar");
        try {
            int errCode = writeApiJar(out);
            return errCode;
        } catch (Exception e) {
            System.err.println("ERROR: Creating " + canonical(out) + " failed: ");
            e.printStackTrace();
            return 1;
        }
    }

    private static File findOurJar() {
        return new File(ClassRootFinder.findClassRootOfClass(PublicApiCreatorApp.class));
    }

    private int writeApiJar(File outFile) throws Exception {
        File selfRaw = findOurJar();
        if (selfRaw == null) {
            System.err.println("The publicApi option only works if lombok is a jar.");
            return 2;
        }
        List<String> toCopy = new ArrayList<>();
        JarFile self = new JarFile(selfRaw);
        try {
            Enumeration<JarEntry> entries = self.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                String name = entry.getName();
                if (name.startsWith("lombok/") && !name.endsWith("/package-info.class") && name.endsWith(".class")) {
                    String subName = name.substring(7, name.length() - 6);
                    int firstSlash = subName.indexOf(47);
                    if (firstSlash == -1) {
                        if (!subName.startsWith("ConfigurationKeys")) {
                            toCopy.add(name);
                        }
                    } else {
                        String topPkg = subName.substring(0, firstSlash);
                        if ("extern".equals(topPkg) || "experimental".equals(topPkg)) {
                            toCopy.add(name);
                        }
                    }
                }
            }
            self.close();
            if (toCopy.isEmpty()) {
                System.out.println("Not generating lombok-api.jar: No lombok api classes required!");
                return 1;
            }
            OutputStream out = new FileOutputStream(outFile);
            try {
                JarOutputStream jar = new JarOutputStream(out);
                for (String resourceName : toCopy) {
                    InputStream in = Lombok.class.getResourceAsStream(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN + resourceName);
                    if (in == null) {
                        throw new Fail(String.format("api class %s cannot be found", resourceName));
                    }
                    try {
                        writeIntoJar(jar, resourceName, in);
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
        } catch (Throwable th2) {
            self.close();
            throw th2;
        }
    }

    private void writeIntoJar(JarOutputStream jar, String resourceName, InputStream in) throws IOException {
        jar.putNextEntry(new ZipEntry(resourceName));
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

    /* JADX INFO: loaded from: discord-126021.apk:lombok/core/PublicApiCreatorApp$Fail.SCL.lombok */
    private static class Fail extends Exception {
        Fail(String message) {
            super(message);
        }
    }

    private static String canonical(File out) {
        try {
            return out.getCanonicalPath();
        } catch (Exception unused) {
            return out.getAbsolutePath();
        }
    }
}
