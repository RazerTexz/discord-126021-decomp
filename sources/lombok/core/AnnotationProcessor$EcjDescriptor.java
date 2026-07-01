package lombok.core;

import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

/* JADX INFO: loaded from: app.apk:lombok/core/AnnotationProcessor$EcjDescriptor.SCL.lombok */
class AnnotationProcessor$EcjDescriptor extends AnnotationProcessor$ProcessorDescriptor {
    AnnotationProcessor$EcjDescriptor() {
    }

    @Override // lombok.core.AnnotationProcessor$ProcessorDescriptor
    String getName() {
        return "ECJ";
    }

    @Override // lombok.core.AnnotationProcessor$ProcessorDescriptor
    boolean want(ProcessingEnvironment procEnv, List<String> delayedWarnings) {
        return procEnv.getClass().getName().startsWith("org.eclipse.jdt.");
    }

    @Override // lombok.core.AnnotationProcessor$ProcessorDescriptor
    boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;
    }
}
