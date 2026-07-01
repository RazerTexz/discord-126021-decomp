package lombok.javac.apt;

import com.sun.source.util.TreePath;
import com.sun.source.util.Trees;
import com.sun.tools.javac.jvm.ClassWriter;
import com.sun.tools.javac.main.JavaCompiler;
import com.sun.tools.javac.processing.JavacFiler;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.Context;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileManager;
import lombok.Lombok;
import lombok.core.CleanupRegistry;
import lombok.core.DiagnosticsReceiver;
import lombok.javac.Javac;
import lombok.javac.JavacTransformer;
import lombok.javac.handlers.JavacHandlerUtil;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/javac/apt/LombokProcessor.SCL.lombok */
@SupportedAnnotationTypes({"*"})
public class LombokProcessor extends AbstractProcessor {
    private ProcessingEnvironment processingEnv;
    private JavacProcessingEnvironment javacProcessingEnv;
    private JavacFiler javacFiler;
    private JavacTransformer transformer;
    private Trees trees;
    private long[] priorityLevels;
    private Set<Long> priorityLevelsRequiringResolutionReset;
    private static final String JPE = "com.sun.tools.javac.processing.JavacProcessingEnvironment";
    private static final Field javacProcessingEnvironment_discoveredProcs = getFieldAccessor(JPE, "discoveredProcs");
    private static final Field discoveredProcessors_procStateList = getFieldAccessor("com.sun.tools.javac.processing.JavacProcessingEnvironment$DiscoveredProcessors", "procStateList");
    private static final Field processorState_processor = getFieldAccessor("com.sun.tools.javac.processing.JavacProcessingEnvironment$processor", "processor");
    private static Class<?> qualifiedNamableClass = null;
    private static Method qualifiedNamableQualifiedNameMethod = null;
    private boolean lombokDisabled = false;
    private final IdentityHashMap<JCTree.JCCompilationUnit, Long> roots = new IdentityHashMap<>();
    private CleanupRegistry cleanup = new CleanupRegistry();
    private int dummyCount = 0;

    public void init(ProcessingEnvironment procEnv) {
        super.init(procEnv);
        if (System.getProperty("lombok.disable") != null) {
            this.lombokDisabled = true;
            return;
        }
        this.processingEnv = procEnv;
        this.javacProcessingEnv = getJavacProcessingEnvironment(procEnv);
        this.javacFiler = getJavacFiler(procEnv.getFiler());
        placePostCompileAndDontMakeForceRoundDummiesHook();
        this.trees = Trees.instance(this.javacProcessingEnv);
        this.transformer = new JavacTransformer(procEnv.getMessager(), this.trees);
        SortedSet<Long> p = this.transformer.getPriorities();
        if (p.isEmpty()) {
            this.priorityLevels = new long[1];
            this.priorityLevelsRequiringResolutionReset = new HashSet();
            return;
        }
        this.priorityLevels = new long[p.size()];
        int i = 0;
        for (Long prio : p) {
            int i2 = i;
            i++;
            this.priorityLevels[i2] = prio.longValue();
        }
        this.priorityLevelsRequiringResolutionReset = this.transformer.getPrioritiesRequiringResolutionReset();
    }

    private static final Field getFieldAccessor(String typeName, String fieldName) {
        try {
            return Permit.getField(Class.forName(typeName), fieldName);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchFieldException unused2) {
            return null;
        }
    }

    private String listAnnotationProcessorsBeforeOurs() {
        try {
            Object discoveredProcessors = javacProcessingEnvironment_discoveredProcs.get(this.javacProcessingEnv);
            ArrayList<?> states = (ArrayList) discoveredProcessors_procStateList.get(discoveredProcessors);
            if (states == null || states.isEmpty()) {
                return null;
            }
            if (states.size() == 1) {
                return processorState_processor.get(states.get(0)).getClass().getName();
            }
            int idx = 0;
            StringBuilder out = new StringBuilder();
            for (Object processState : states) {
                idx++;
                String name = processorState_processor.get(processState).getClass().getName();
                if (out.length() > 0) {
                    out.append(", ");
                }
                out.append("[").append(idx).append("] ").append(name);
            }
            return out.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private void placePostCompileAndDontMakeForceRoundDummiesHook() {
        stopJavacProcessingEnvironmentFromClosingOurClassloader();
        forceMultipleRoundsInNetBeansEditor();
        Context context = this.javacProcessingEnv.getContext();
        disablePartialReparseInNetBeansEditor(context);
        try {
            Method keyMethod = Permit.getMethod(Context.class, "key", Class.class);
            Object key = keyMethod.invoke(context, JavaFileManager.class);
            Field htField = Permit.getField(Context.class, "ht");
            Map<Object, Object> ht = (Map) htField.get(context);
            JavaFileManager originalFiler = (JavaFileManager) ht.get(key);
            if (!(originalFiler instanceof InterceptingJavaFileManager)) {
                Messager messager = this.processingEnv.getMessager();
                DiagnosticsReceiver receiver = new MessagerDiagnosticsReceiver(messager);
                InterceptingJavaFileManager interceptingJavaFileManager = new InterceptingJavaFileManager(originalFiler, receiver);
                ht.put(key, interceptingJavaFileManager);
                Field filerFileManagerField = Permit.getField(JavacFiler.class, "fileManager");
                filerFileManagerField.set(this.javacFiler, interceptingJavaFileManager);
                if (Javac.getJavaCompilerVersion() > 8 && !JavacHandlerUtil.inNetbeansCompileOnSave(context)) {
                    replaceFileManagerJdk9(context, interceptingJavaFileManager);
                }
            }
        } catch (Exception e) {
            throw Lombok.sneakyThrow(e);
        }
    }

    private void replaceFileManagerJdk9(Context context, JavaFileManager newFiler) {
        try {
            JavaCompiler compiler = (JavaCompiler) Permit.getMethod(JavaCompiler.class, "instance", Context.class).invoke(null, context);
            try {
                Field fileManagerField = Permit.getField(JavaCompiler.class, "fileManager");
                fileManagerField.set(compiler, newFiler);
            } catch (Exception unused) {
            }
            try {
                Field writerField = Permit.getField(JavaCompiler.class, "writer");
                ClassWriter writer = (ClassWriter) writerField.get(compiler);
                Field fileManagerField2 = Permit.getField(ClassWriter.class, "fileManager");
                fileManagerField2.set(writer, newFiler);
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
        }
    }

    private void forceMultipleRoundsInNetBeansEditor() {
        try {
            Field f = Permit.getField(JavacProcessingEnvironment.class, "isBackgroundCompilation");
            f.set(this.javacProcessingEnv, true);
        } catch (NoSuchFieldException unused) {
        } catch (Throwable t) {
            throw Lombok.sneakyThrow(t);
        }
    }

    private void disablePartialReparseInNetBeansEditor(Context context) {
        try {
            Class<?> cancelServiceClass = Class.forName("com.sun.tools.javac.util.CancelService");
            Method cancelServiceInstace = Permit.getMethod(cancelServiceClass, "instance", Context.class);
            Object cancelService = cancelServiceInstace.invoke(null, context);
            if (cancelService == null) {
                return;
            }
            Field parserField = Permit.getField(cancelService.getClass(), "parser");
            Object parser = parserField.get(cancelService);
            Field supportsReparseField = Permit.getField(parser.getClass(), "supportsReparse");
            supportsReparseField.set(parser, false);
        } catch (ClassNotFoundException unused) {
        } catch (NoSuchFieldException unused2) {
        } catch (Throwable t) {
            throw Lombok.sneakyThrow(t);
        }
    }

    private static ClassLoader wrapClassLoader(final ClassLoader parent) {
        return new ClassLoader() { // from class: lombok.javac.apt.LombokProcessor.1
            @Override // java.lang.ClassLoader
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return parent.loadClass(name);
            }

            public String toString() {
                return parent.toString();
            }

            @Override // java.lang.ClassLoader
            public URL getResource(String name) {
                return parent.getResource(name);
            }

            @Override // java.lang.ClassLoader
            public Enumeration<URL> getResources(String name) throws IOException {
                return parent.getResources(name);
            }

            @Override // java.lang.ClassLoader
            public InputStream getResourceAsStream(String name) {
                return parent.getResourceAsStream(name);
            }

            @Override // java.lang.ClassLoader
            public void setDefaultAssertionStatus(boolean enabled) {
                parent.setDefaultAssertionStatus(enabled);
            }

            @Override // java.lang.ClassLoader
            public void setPackageAssertionStatus(String packageName, boolean enabled) {
                parent.setPackageAssertionStatus(packageName, enabled);
            }

            @Override // java.lang.ClassLoader
            public void setClassAssertionStatus(String className, boolean enabled) {
                parent.setClassAssertionStatus(className, enabled);
            }

            @Override // java.lang.ClassLoader
            public void clearAssertionStatus() {
                parent.clearAssertionStatus();
            }
        };
    }

    private void stopJavacProcessingEnvironmentFromClosingOurClassloader() {
        try {
            Field f = Permit.getField(JavacProcessingEnvironment.class, "processorClassLoader");
            ClassLoader unwrapped = (ClassLoader) f.get(this.javacProcessingEnv);
            if (unwrapped == null) {
                return;
            }
            ClassLoader wrapped = wrapClassLoader(unwrapped);
            f.set(this.javacProcessingEnv, wrapped);
        } catch (NoSuchFieldException unused) {
        } catch (Throwable t) {
            throw Lombok.sneakyThrow(t);
        }
    }

    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<Long> newLevels;
        if (this.lombokDisabled) {
            return false;
        }
        if (roundEnv.processingOver()) {
            this.cleanup.run();
            return false;
        }
        String randomModuleName = null;
        for (Element element : roundEnv.getRootElements()) {
            if (randomModuleName == null) {
                randomModuleName = getModuleNameFor(element);
            }
            JCTree.JCCompilationUnit unit = toUnit(element);
            if (unit != null && !this.roots.containsKey(unit)) {
                this.roots.put(unit, Long.valueOf(this.priorityLevels[0]));
            }
        }
        do {
            for (long prio : this.priorityLevels) {
                List<JCTree.JCCompilationUnit> cusForThisRound = new ArrayList<>();
                for (Map.Entry<JCTree.JCCompilationUnit, Long> entry : this.roots.entrySet()) {
                    Long prioOfCu = entry.getValue();
                    if (prioOfCu != null && prioOfCu.longValue() == prio) {
                        cusForThisRound.add(entry.getKey());
                    }
                }
                this.transformer.transform(prio, this.javacProcessingEnv.getContext(), cusForThisRound, this.cleanup);
            }
            newLevels = new HashSet<>();
            int i = this.priorityLevels.length - 1;
            while (i >= 0) {
                Long curLevel = Long.valueOf(this.priorityLevels[i]);
                Long nextLevel = i == this.priorityLevels.length - 1 ? null : Long.valueOf(this.priorityLevels[i + 1]);
                List<JCTree.JCCompilationUnit> cusToAdvance = new ArrayList<>();
                for (Map.Entry<JCTree.JCCompilationUnit, Long> entry2 : this.roots.entrySet()) {
                    if (curLevel.equals(entry2.getValue())) {
                        cusToAdvance.add(entry2.getKey());
                        newLevels.add(nextLevel);
                    }
                }
                Iterator<JCTree.JCCompilationUnit> it = cusToAdvance.iterator();
                while (it.hasNext()) {
                    this.roots.put(it.next(), nextLevel);
                }
                i--;
            }
            newLevels.remove(null);
            if (newLevels.isEmpty()) {
                return false;
            }
            newLevels.retainAll(this.priorityLevelsRequiringResolutionReset);
        } while (newLevels.isEmpty());
        forceNewRound(randomModuleName, this.javacFiler);
        return false;
    }

    private void forceNewRound(String randomModuleName, JavacFiler filer) {
        if (!filer.newFiles()) {
            try {
                Set generatedSourceNames = filer.getGeneratedSourceNames();
                StringBuilder sb = new StringBuilder("lombok.dummy.ForceNewRound");
                int i = this.dummyCount;
                this.dummyCount = i + 1;
                generatedSourceNames.add(sb.append(i).toString());
            } catch (Exception e) {
                e.printStackTrace();
                this.processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING, "Can't force a new processing round. Lombok won't work.");
            }
        }
    }

    private String getModuleNameFor(Element element) {
        while (element != null) {
            if (element.getKind().name().equals("MODULE")) {
                return getModuleName(element);
            }
            Element n = element.getEnclosingElement();
            if (n == element) {
                return null;
            }
            element = n;
        }
        return null;
    }

    private static String getModuleName(Element element) {
        try {
            if (qualifiedNamableClass == null) {
                qualifiedNamableClass = Class.forName("javax.lang.model.element.QualifiedNamable");
            }
            if (!qualifiedNamableClass.isInstance(element)) {
                return null;
            }
            if (qualifiedNamableQualifiedNameMethod == null) {
                qualifiedNamableQualifiedNameMethod = qualifiedNamableClass.getMethod("getQualifiedName", new Class[0]);
            }
            String name = qualifiedNamableQualifiedNameMethod.invoke(element, new Object[0]).toString().trim();
            if (name.isEmpty()) {
                return null;
            }
            return name;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (IllegalAccessException unused2) {
            return null;
        } catch (NoSuchMethodException unused3) {
            return null;
        } catch (InvocationTargetException unused4) {
            return null;
        }
    }

    private JCTree.JCCompilationUnit toUnit(Element element) {
        TreePath path = null;
        if (this.trees != null) {
            try {
                path = this.trees.getPath(element);
            } catch (NullPointerException unused) {
            }
        }
        if (path == null) {
            return null;
        }
        return path.getCompilationUnit();
    }

    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }

    public JavacProcessingEnvironment getJavacProcessingEnvironment(Object procEnv) {
        if (procEnv instanceof JavacProcessingEnvironment) {
            return (JavacProcessingEnvironment) procEnv;
        }
        Class<?> superclass = procEnv.getClass();
        while (true) {
            Class<?> procEnvClass = superclass;
            if (procEnvClass != null) {
                Object delegate = tryGetDelegateField(procEnvClass, procEnv);
                if (delegate == null) {
                    delegate = tryGetProxyDelegateToField(procEnvClass, procEnv);
                }
                if (delegate == null) {
                    delegate = tryGetProcessingEnvField(procEnvClass, procEnv);
                }
                if (delegate != null) {
                    return getJavacProcessingEnvironment(delegate);
                }
                superclass = procEnvClass.getSuperclass();
            } else {
                this.processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING, "Can't get the delegate of the gradle IncrementalProcessingEnvironment. Lombok won't work.");
                return null;
            }
        }
    }

    public JavacFiler getJavacFiler(Object filer) {
        if (filer instanceof JavacFiler) {
            return (JavacFiler) filer;
        }
        Class<?> superclass = filer.getClass();
        while (true) {
            Class<?> filerClass = superclass;
            if (filerClass != null) {
                Object delegate = tryGetDelegateField(filerClass, filer);
                if (delegate == null) {
                    delegate = tryGetProxyDelegateToField(filerClass, filer);
                }
                if (delegate == null) {
                    delegate = tryGetFilerField(filerClass, filer);
                }
                if (delegate != null) {
                    return getJavacFiler(delegate);
                }
                superclass = filerClass.getSuperclass();
            } else {
                this.processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING, "Can't get a JavacFiler from " + filer.getClass().getName() + ". Lombok won't work.");
                return null;
            }
        }
    }

    private Object tryGetDelegateField(Class<?> delegateClass, Object instance) {
        try {
            return Permit.getField(delegateClass, "delegate").get(instance);
        } catch (Exception unused) {
            return null;
        }
    }

    private Object tryGetProcessingEnvField(Class<?> delegateClass, Object instance) {
        try {
            return Permit.getField(delegateClass, "processingEnv").get(instance);
        } catch (Exception unused) {
            return null;
        }
    }

    private Object tryGetFilerField(Class<?> delegateClass, Object instance) {
        try {
            return Permit.getField(delegateClass, "filer").get(instance);
        } catch (Exception unused) {
            return null;
        }
    }

    private Object tryGetProxyDelegateToField(Class<?> delegateClass, Object instance) {
        try {
            InvocationHandler handler = Proxy.getInvocationHandler(instance);
            return Permit.getField(handler.getClass(), "val$delegateTo").get(handler);
        } catch (Exception unused) {
            return null;
        }
    }
}
