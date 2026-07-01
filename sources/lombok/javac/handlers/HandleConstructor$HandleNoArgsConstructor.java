package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.util.List;
import java.lang.annotation.Annotation;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.NoArgsConstructor;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleConstructor$HandleNoArgsConstructor.SCL.lombok */
public class HandleConstructor$HandleNoArgsConstructor extends JavacAnnotationHandler<NoArgsConstructor> {
    private static final String NAME = NoArgsConstructor.class.getSimpleName();
    private HandleConstructor handleConstructor = new HandleConstructor();

    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<NoArgsConstructor> annotation, JCTree$JCAnnotation ast, JavacNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.NO_ARGS_CONSTRUCTOR_FLAG_USAGE, "@NoArgsConstructor", ConfigurationKeys.ANY_CONSTRUCTOR_FLAG_USAGE, "any @xArgsConstructor");
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) NoArgsConstructor.class);
        JavacHandlerUtil.deleteImportFromCompilationUnit(annotationNode, "lombok.AccessLevel");
        JavacNode typeNode = annotationNode.up();
        if (HandleConstructor.checkLegality(typeNode, annotationNode, NAME)) {
            List<JCTree$JCAnnotation> onConstructor = JavacHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onConstructor", "@NoArgsConstructor(onConstructor", annotationNode);
            NoArgsConstructor ann = annotation.getInstance();
            AccessLevel level = ann.access();
            if (level == AccessLevel.NONE) {
                return;
            }
            String staticName = ann.staticName();
            boolean force = ann.force();
            this.handleConstructor.generateConstructor(typeNode, level, onConstructor, List.nil(), force, staticName, HandleConstructor$SkipIfConstructorExists.NO, annotationNode);
        }
    }
}
