package lombok.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic$Kind;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/core/AnnotationProcessor.SCL.lombok */
@SupportedAnnotationTypes({"*"})
public class AnnotationProcessor extends AbstractProcessor {
    private final List<AnnotationProcessor$ProcessorDescriptor> registered = Arrays.asList(new AnnotationProcessor$JavacDescriptor(), new AnnotationProcessor$EcjDescriptor());
    private final List<AnnotationProcessor$ProcessorDescriptor> active = new ArrayList();
    private final List<String> delayedWarnings = new ArrayList();

    static /* synthetic */ String access$0(Throwable th) {
        return trace(th);
    }

    private static String trace(Throwable t) {
        StringWriter w = new StringWriter();
        t.printStackTrace(new PrintWriter((Writer) w, true));
        return w.toString();
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

    public void init(ProcessingEnvironment procEnv) {
        super.init(procEnv);
        for (AnnotationProcessor$ProcessorDescriptor proc : this.registered) {
            if (proc.want(procEnv, this.delayedWarnings)) {
                this.active.add(proc);
            }
        }
        if (this.active.isEmpty() && this.delayedWarnings.isEmpty()) {
            StringBuilder supported = new StringBuilder();
            for (AnnotationProcessor$ProcessorDescriptor proc2 : this.registered) {
                if (supported.length() > 0) {
                    supported.append(", ");
                }
                supported.append(proc2.getName());
            }
            procEnv.getMessager().printMessage(Diagnostic$Kind.WARNING, String.format("You aren't using a compiler supported by lombok, so lombok will not work and has been disabled.\nYour processor is: %s\nLombok supports: %s", procEnv.getClass().getName(), supported));
        }
    }

    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!this.delayedWarnings.isEmpty()) {
            Set<? extends Element> rootElements = roundEnv.getRootElements();
            if (!rootElements.isEmpty()) {
                Element firstRoot = (Element) rootElements.iterator().next();
                for (String warning : this.delayedWarnings) {
                    this.processingEnv.getMessager().printMessage(Diagnostic$Kind.WARNING, warning, firstRoot);
                }
                this.delayedWarnings.clear();
            }
        }
        for (AnnotationProcessor$ProcessorDescriptor proc : this.active) {
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
