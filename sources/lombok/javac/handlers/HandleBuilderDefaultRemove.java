package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import java.lang.annotation.Annotation;
import lombok.Builder;
import lombok.core.AlreadyHandledAnnotations;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/handlers/HandleBuilderDefaultRemove.SCL.lombok */
@HandlerPriority(65536)
@AlreadyHandledAnnotations
public class HandleBuilderDefaultRemove extends JavacAnnotationHandler<Builder.Default> {
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Builder.Default> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) Builder.Default.class);
    }
}
