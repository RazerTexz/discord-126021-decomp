package lombok.core;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import lombok.patcher.ClassRootFinder;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/core/AnnotationProcessor.SCL.lombok */
@SupportedAnnotationTypes({"*"})
public class AnnotationProcessor extends AbstractProcessor {
    private final List<ProcessorDescriptor> registered = Arrays.asList(new JavacDescriptor(), new EcjDescriptor());
    private final List<ProcessorDescriptor> active = new ArrayList();
    private final List<String> delayedWarnings = new ArrayList();

    private static String trace(Throwable t) {
        StringWriter w = new StringWriter();
        t.printStackTrace(new PrintWriter((Writer) w, true));
        return w.toString();
    }

    /* JADX INFO: loaded from: app.apk:lombok/core/AnnotationProcessor$ProcessorDescriptor.SCL.lombok */
    static abstract class ProcessorDescriptor {
        abstract boolean want(ProcessingEnvironment processingEnvironment, List<String> list);

        abstract String getName();

        abstract boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment);

        ProcessorDescriptor() {
        }
    }

    public static ProcessingEnvironment getJavacProcessingEnvironment(ProcessingEnvironment procEnv, List<String> delayedWarnings) {
        return tryRecursivelyObtainJavacProcessingEnvironment(procEnv);
    }

    private static ProcessingEnvironment tryRecursivelyObtainJavacProcessingEnvironment(ProcessingEnvironment procEnv) {
        if (procEnv.getClass().getName().equals("com.sun.tools.javac.processing.JavacProcessingEnvironment")) {
            return procEnv;
        }
        Class<?> superclass = procEnv.getClass();
        while (true) {
            Class<?> procEnvClass = superclass;
            if (procEnvClass != null) {
                try {
                    Object delegate = tryGetDelegateField(procEnvClass, procEnv);
                    if (delegate == null) {
                        delegate = tryGetProcessingEnvField(procEnvClass, procEnv);
                    }
                    if (delegate == null) {
                        delegate = tryGetProxyDelegateToField(procEnvClass, procEnv);
                    }
                    if (delegate != null) {
                        return tryRecursivelyObtainJavacProcessingEnvironment((ProcessingEnvironment) delegate);
                    }
                    continue;
                } catch (Exception unused) {
                }
                superclass = procEnvClass.getSuperclass();
            } else {
                return null;
            }
        }
    }

    private static Object tryGetDelegateField(Class<?> delegateClass, Object instance) {
        try {
            return Permit.getField(delegateClass, "delegate").get(instance);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Object tryGetProcessingEnvField(Class<?> delegateClass, Object instance) {
        try {
            return Permit.getField(delegateClass, "processingEnv").get(instance);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Object tryGetProxyDelegateToField(Class<?> delegateClass, Object instance) {
        try {
            InvocationHandler handler = Proxy.getInvocationHandler(instance);
            return Permit.getField(handler.getClass(), "val$delegateTo").get(handler);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/core/AnnotationProcessor$JavacDescriptor.SCL.lombok */
    static class JavacDescriptor extends ProcessorDescriptor {
        private Processor processor;

        JavacDescriptor() {
        }

        @Override // lombok.core.AnnotationProcessor.ProcessorDescriptor
        String getName() {
            return "OpenJDK javac";
        }

        @Override // lombok.core.AnnotationProcessor.ProcessorDescriptor
        boolean want(ProcessingEnvironment procEnv, List<String> delayedWarnings) {
            ProcessingEnvironment javacProcEnv;
            if (procEnv.getClass().getName().startsWith("org.eclipse.jdt.") || (javacProcEnv = AnnotationProcessor.getJavacProcessingEnvironment(procEnv, delayedWarnings)) == null) {
                return false;
            }
            try {
                ClassLoader classLoader = findAndPatchClassLoader(javacProcEnv);
                this.processor = (Processor) Class.forName("lombok.javac.apt.LombokProcessor", false, classLoader).getConstructor(new Class[0]).newInstance(new Object[0]);
                try {
                    this.processor.init(procEnv);
                    return true;
                } catch (Exception e) {
                    delayedWarnings.add("lombok.javac.apt.LombokProcessor could not be initialized. Lombok will not run during this compilation: " + AnnotationProcessor.trace(e));
                    return false;
                } catch (NoClassDefFoundError e2) {
                    delayedWarnings.add("Can't initialize javac processor due to (most likely) a class loader problem: " + AnnotationProcessor.trace(e2));
                    return false;
                }
            } catch (Exception e3) {
                delayedWarnings.add("You found a bug in lombok; lombok.javac.apt.LombokProcessor is not available. Lombok will not run during this compilation: " + AnnotationProcessor.trace(e3));
                return false;
            } catch (NoClassDefFoundError e4) {
                delayedWarnings.add("Can't load javac processor due to (most likely) a class loader problem: " + AnnotationProcessor.trace(e4));
                return false;
            }
        }

        private ClassLoader findAndPatchClassLoader(ProcessingEnvironment procEnv) throws Exception {
            ClassLoader environmentClassLoader = procEnv.getClass().getClassLoader();
            if (environmentClassLoader != null && environmentClassLoader.getClass().getCanonicalName().equals("org.codehaus.plexus.compiler.javac.IsolatedClassLoader") && !Augments.ClassLoader_lombokAlreadyAddedTo.getAndSet(environmentClassLoader, true).booleanValue()) {
                Method m = Permit.getMethod(environmentClassLoader.getClass(), "addURL", URL.class);
                URL selfUrl = new File(ClassRootFinder.findClassRootOfClass(AnnotationProcessor.class)).toURI().toURL();
                m.invoke(environmentClassLoader, selfUrl);
            }
            ClassLoader ourClassLoader = JavacDescriptor.class.getClassLoader();
            return ourClassLoader == null ? ClassLoader.getSystemClassLoader() : ourClassLoader;
        }

        @Override // lombok.core.AnnotationProcessor.ProcessorDescriptor
        boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
            return this.processor.process(annotations, roundEnv);
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/core/AnnotationProcessor$EcjDescriptor.SCL.lombok */
    static class EcjDescriptor extends ProcessorDescriptor {
        EcjDescriptor() {
        }

        @Override // lombok.core.AnnotationProcessor.ProcessorDescriptor
        String getName() {
            return "ECJ";
        }

        @Override // lombok.core.AnnotationProcessor.ProcessorDescriptor
        boolean want(ProcessingEnvironment procEnv, List<String> delayedWarnings) {
            return procEnv.getClass().getName().startsWith("org.eclipse.jdt.");
        }

        @Override // lombok.core.AnnotationProcessor.ProcessorDescriptor
        boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
            return false;
        }
    }

    public void init(ProcessingEnvironment procEnv) {
        super.init(procEnv);
        for (ProcessorDescriptor proc : this.registered) {
            if (proc.want(procEnv, this.delayedWarnings)) {
                this.active.add(proc);
            }
        }
        if (this.active.isEmpty() && this.delayedWarnings.isEmpty()) {
            StringBuilder supported = new StringBuilder();
            for (ProcessorDescriptor proc2 : this.registered) {
                if (supported.length() > 0) {
                    supported.append(", ");
                }
                supported.append(proc2.getName());
            }
            procEnv.getMessager().printMessage(Diagnostic.Kind.WARNING, String.format("You aren't using a compiler supported by lombok, so lombok will not work and has been disabled.\nYour processor is: %s\nLombok supports: %s", procEnv.getClass().getName(), supported));
        }
    }

    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!this.delayedWarnings.isEmpty()) {
            Set<? extends Element> rootElements = roundEnv.getRootElements();
            if (!rootElements.isEmpty()) {
                Element firstRoot = (Element) rootElements.iterator().next();
                for (String warning : this.delayedWarnings) {
                    this.processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING, warning, firstRoot);
                }
                this.delayedWarnings.clear();
            }
        }
        for (ProcessorDescriptor proc : this.active) {
            proc.process(annotations, roundEnv);
        }
        boolean onlyLombok = true;
        boolean zeroElems = true;
        for (TypeElement elem : annotations) {
            zeroElems = false;
            Name n = elem.getQualifiedName();
            if (!n.toString().startsWith("lombok.")) {
                onlyLombok = false;
            }
        }
        return onlyLombok && !zeroElems;
    }

    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.values()[SourceVersion.values().length - 1];
    }
}
