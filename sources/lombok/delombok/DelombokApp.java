package lombok.delombok;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Map$Entry;
import java.util.jar.JarFile;
import lombok.core.LombokApp;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/delombok/DelombokApp.SCL.lombok */
public class DelombokApp extends LombokApp {
    @Override // lombok.core.LombokApp
    public int runApp(List<String> args) throws Exception {
        try {
            Class.forName("com.sun.tools.javac.main.JavaCompiler");
            runDirectly(args);
            return 0;
        } catch (ClassNotFoundException unused) {
            Class<?> delombokClass = loadDelombok(args);
            if (delombokClass == null) {
                return 1;
            }
            try {
                Permit.getMethod(loadDelombok(args), "main", String[].class).invoke(null, args.toArray(new String[0]));
                return 0;
            } catch (InvocationTargetException e1) {
                Throwable t = e1.getCause();
                if (t instanceof Error) {
                    throw ((Error) t);
                }
                if (t instanceof Exception) {
                    throw ((Exception) t);
                }
                throw e1;
            }
        }
    }

    public static Class<?> loadDelombok(List<String> args) throws Exception {
        File toolsJar = findToolsJar();
        if (toolsJar == null) {
            String examplePath = File.separator.equals("\\") ? "C:\\path\\to\\tools.jar" : "/path/to/tools.jar";
            StringBuilder sb = new StringBuilder();
            for (String arg : args) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                if (arg.contains(" ")) {
                    sb.append('\"').append(arg).append('\"');
                } else {
                    sb.append(arg);
                }
            }
            System.err.printf("Can't find tools.jar. Rerun delombok as: java -cp lombok.jar%1$s%2$s lombok.launch.Main delombok %3$s\n", File.pathSeparator, examplePath, sb.toString());
            return null;
        }
        JarFile toolsJarFile = new JarFile(toolsJar);
        ClassLoader loader = new DelombokApp$1(DelombokApp.class.getClassLoader(), toolsJarFile, toolsJar);
        return loader.loadClass("lombok.delombok.Delombok");
    }

    private void runDirectly(List<String> args) {
        Delombok.main((String[]) args.toArray(new String[0]));
    }

    private static File findToolsJar() {
        try {
            File toolsJar = findToolsJarViaRT();
            if (toolsJar != null) {
                return toolsJar;
            }
        } catch (Throwable unused) {
        }
        try {
            File toolsJar2 = findToolsJarViaProperties();
            if (toolsJar2 != null) {
                return toolsJar2;
            }
        } catch (Throwable unused2) {
        }
        try {
            return findToolsJarViaEnvironment();
        } catch (Throwable unused3) {
            return null;
        }
    }

    private static File findToolsJarViaEnvironment() {
        for (Map$Entry<String, String> s2 : System.getenv().entrySet()) {
            if ("JAVA_HOME".equalsIgnoreCase(s2.getKey())) {
                return extensiveCheckToolsJar(new File(s2.getValue()));
            }
        }
        return null;
    }

    private static File findToolsJarViaProperties() {
        File home = new File(System.getProperty("java.home", "."));
        return extensiveCheckToolsJar(home);
    }

    private static File extensiveCheckToolsJar(File base) {
        File toolsJar = checkToolsJar(base);
        if (toolsJar != null) {
            return toolsJar;
        }
        File toolsJar2 = checkToolsJar(new File(base, "lib"));
        if (toolsJar2 != null) {
            return toolsJar2;
        }
        File toolsJar3 = checkToolsJar(new File(base.getParentFile(), "lib"));
        if (toolsJar3 != null) {
            return toolsJar3;
        }
        File toolsJar4 = checkToolsJar(new File(new File(base, "jdk"), "lib"));
        if (toolsJar4 != null) {
            return toolsJar4;
        }
        return null;
    }

    private static File findToolsJarViaRT() {
        String url;
        int idx;
        String url2 = ClassLoader.getSystemClassLoader().getResource("java/lang/String.class").toString();
        if (!url2.startsWith("jar:file:") || (idx = (url = url2.substring("jar:file:".length())).indexOf(33)) == -1) {
            return null;
        }
        String url3 = url.substring(0, idx);
        File toolsJar = checkToolsJar(new File(url3).getParentFile());
        if (toolsJar != null) {
            return toolsJar;
        }
        File toolsJar2 = checkToolsJar(new File(new File(url3).getParentFile().getParentFile().getParentFile(), "lib"));
        if (toolsJar2 != null) {
            return toolsJar2;
        }
        return null;
    }

    private static File checkToolsJar(File d) {
        if (d.getName().equals("tools.jar") && d.isFile() && d.canRead()) {
            return d;
        }
        File d2 = new File(d, "tools.jar");
        if (d2.getName().equals("tools.jar") && d2.isFile() && d2.canRead()) {
            return d2;
        }
        return null;
    }

    @Override // lombok.core.LombokApp
    public String getAppName() {
        return "delombok";
    }

    @Override // lombok.core.LombokApp
    public List<String> getAppAliases() {
        return Arrays.asList("unlombok");
    }

    @Override // lombok.core.LombokApp
    public String getAppDescription() {
        return "Applies lombok transformations without compiling your\njava code (so, 'unpacks' lombok annotations and such).";
    }
}
