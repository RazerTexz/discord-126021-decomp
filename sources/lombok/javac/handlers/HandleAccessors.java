package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import java.lang.annotation.Annotation;
import lombok.ConfigurationKeys;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.experimental.Accessors;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/handlers/HandleAccessors.SCL.lombok */
@HandlerPriority(65536)
public class HandleAccessors extends JavacAnnotationHandler<Accessors> {
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Accessors> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        HandlerUtil.handleExperimentalFlagUsage(annotationNode, ConfigurationKeys.ACCESSORS_FLAG_USAGE, "@Accessors");
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) Accessors.class);
    }
}
