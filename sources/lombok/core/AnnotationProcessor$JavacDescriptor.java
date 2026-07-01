package lombok.core;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import lombok.patcher.ClassRootFinder;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/core/AnnotationProcessor$JavacDescriptor.SCL.lombok */
class AnnotationProcessor$JavacDescriptor extends AnnotationProcessor$ProcessorDescriptor {
    private Processor processor;

    AnnotationProcessor$JavacDescriptor() {
    }

    @Override // lombok.core.AnnotationProcessor$ProcessorDescriptor
    String getName() {
        return "OpenJDK javac";
    }

    @Override // lombok.core.AnnotationProcessor$ProcessorDescriptor
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
                delayedWarnings.add("lombok.javac.apt.LombokProcessor could not be initialized. Lombok will not run during this compilation: " + AnnotationProcessor.access$0(e));
                return false;
            } catch (NoClassDefFoundError e2) {
                delayedWarnings.add("Can't initialize javac processor due to (most likely) a class loader problem: " + AnnotationProcessor.access$0(e2));
                return false;
            }
        } catch (Exception e3) {
            delayedWarnings.add("You found a bug in lombok; lombok.javac.apt.LombokProcessor is not available. Lombok will not run during this compilation: " + AnnotationProcessor.access$0(e3));
            return false;
        } catch (NoClassDefFoundError e4) {
            delayedWarnings.add("Can't load javac processor due to (most likely) a class loader problem: " + AnnotationProcessor.access$0(e4));
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
        ClassLoader ourClassLoader = AnnotationProcessor$JavacDescriptor.class.getClassLoader();
        return ourClassLoader == null ? ClassLoader.getSystemClassLoader() : ourClassLoader;
    }

    @Override // lombok.core.AnnotationProcessor$ProcessorDescriptor
    boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return this.processor.process(annotations, roundEnv);
    }
}
