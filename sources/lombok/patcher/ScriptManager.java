package lombok.patcher;

import java.io.File;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: app.apk:lombok/patcher/ScriptManager.SCL.lombok */
public class ScriptManager {
    private static final String DEBUG_PATCHING = System.getProperty("lombok.patcher.patchDebugDir", null);
    private static final boolean LOG_TO_STANDARD_ERR = false;
    private final List<PatchScript> scripts = new ArrayList();
    private final Map<String, List<ScriptManager$WitnessAction>> witnessActions = new HashMap();
    private TransplantMapper transplantMapper = TransplantMapper.IDENTITY_MAPPER;
    private Filter filter = Filter.ALWAYS;
    private final ScriptManager$OurClassFileTransformer transformer = new ScriptManager$OurClassFileTransformer(this, null);

    static /* synthetic */ List access$1(ScriptManager scriptManager) {
        return scriptManager.scripts;
    }

    static /* synthetic */ Map access$0(ScriptManager scriptManager) {
        return scriptManager.witnessActions;
    }

    static /* synthetic */ TransplantMapper access$3(ScriptManager scriptManager) {
        return scriptManager.transplantMapper;
    }

    static /* synthetic */ Filter access$2(ScriptManager scriptManager) {
        return scriptManager.filter;
    }

    public void addScript(PatchScript script) {
        this.scripts.add(script);
    }

    public void addScriptIfWitness(String[] witness, PatchScript script) {
        ScriptManager$WitnessAction wa = new ScriptManager$WitnessAction(null);
        wa.ifWitnessRemove = false;
        wa.script = script;
        for (String w : witness) {
            List<ScriptManager$WitnessAction> list = this.witnessActions.get(w);
            if (list == null) {
                list = new ArrayList();
                this.witnessActions.put(w, list);
            }
            list.add(wa);
        }
    }

    public void addScriptIfNotWitness(String[] witness, PatchScript script) {
        ScriptManager$WitnessAction wa = new ScriptManager$WitnessAction(null);
        wa.ifWitnessRemove = true;
        wa.script = script;
        this.scripts.add(script);
        for (String w : witness) {
            List<ScriptManager$WitnessAction> list = this.witnessActions.get(w);
            if (list == null) {
                list = new ArrayList();
                this.witnessActions.put(w, list);
            }
            list.add(wa);
        }
    }

    public void setFilter(Filter filter) {
        this.filter = filter == null ? Filter.ALWAYS : filter;
    }

    public void registerTransformer(Instrumentation instrumentation) {
        try {
            Method m = Instrumentation.class.getMethod("addTransformer", ClassFileTransformer.class, Boolean.TYPE);
            m.invoke(instrumentation, this.transformer, true);
        } catch (Throwable unused) {
            instrumentation.addTransformer(this.transformer);
        }
    }

    public void reloadClasses(Instrumentation instrumentation) {
        Set<String> toReload = new HashSet<>();
        for (PatchScript s2 : this.scripts) {
            toReload.addAll(s2.getClassesToReload());
        }
        for (Class<?> c : instrumentation.getAllLoadedClasses()) {
            if (toReload.contains(c.getName())) {
                try {
                    Instrumentation.class.getMethod("retransformClasses", Class[].class).invoke(instrumentation, new Class[]{c});
                } catch (InvocationTargetException e) {
                    throw new UnsupportedOperationException("The " + c.getName() + " class is already loaded and cannot be modified. You'll have to restart the application to patch it. Reason: " + e.getCause());
                } catch (Throwable unused) {
                    throw new UnsupportedOperationException("This appears to be a JVM v1.5, which cannot reload already loaded classes. You'll have to restart the application to patch it.");
                }
            }
        }
    }

    static /* synthetic */ String access$4() {
        return DEBUG_PATCHING;
    }

    private static boolean classpathContains(String property, String path) {
        String pathCanonical = new File(path).getAbsolutePath();
        try {
            pathCanonical = new File(path).getCanonicalPath();
        } catch (Exception unused) {
        }
        for (String existingPath : System.getProperty(property, "").split(File.pathSeparator)) {
            String p = new File(existingPath).getAbsolutePath();
            try {
                p = new File(existingPath).getCanonicalPath();
            } catch (Throwable unused2) {
            }
            if (p.equals(pathCanonical)) {
                return true;
            }
        }
        return false;
    }

    public void addToSystemClasspath(Instrumentation instrumentation, String pathToJar) {
        if (pathToJar == null) {
            throw new NullPointerException("pathToJar");
        }
        if (classpathContains("sun.boot.class.path", pathToJar) || classpathContains("java.class.path", pathToJar)) {
            return;
        }
        try {
            Method m = instrumentation.getClass().getMethod("appendToSystemClassLoaderSearch", JarFile.class);
            m.invoke(instrumentation, new JarFile(pathToJar));
        } catch (IOException e) {
            throw new IllegalArgumentException("not found or not a jar file: " + pathToJar, e);
        } catch (IllegalAccessException unused) {
            throw new IllegalStateException("appendToSystemClassLoaderSearch isn't public? This isn't a JVM...");
        } catch (NoSuchMethodException unused2) {
            throw new IllegalStateException("Adding to the classloader path is not possible on a v1.5 JVM");
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new IllegalArgumentException("Unknown issue: " + cause, cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    public void addToBootClasspath(Instrumentation instrumentation, String pathToJar) {
        if (pathToJar == null) {
            throw new NullPointerException("pathToJar");
        }
        if (classpathContains("sun.boot.class.path", pathToJar)) {
            return;
        }
        try {
            Method m = instrumentation.getClass().getMethod("appendToBootstrapClassLoaderSearch", JarFile.class);
            m.invoke(instrumentation, new JarFile(pathToJar));
        } catch (IOException e) {
            throw new IllegalArgumentException("not found or not a jar file: " + pathToJar, e);
        } catch (IllegalAccessException unused) {
            throw new IllegalStateException("appendToSystemClassLoaderSearch isn't public? This isn't a JVM...");
        } catch (NoSuchMethodException unused2) {
            throw new IllegalStateException("Adding to the classloader path is not possible on a v1.5 JVM");
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new IllegalArgumentException("Unknown issue: " + cause, cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    public void setTransplantMapper(TransplantMapper transplantMapper) {
        this.transplantMapper = transplantMapper == null ? TransplantMapper.IDENTITY_MAPPER : transplantMapper;
    }
}
