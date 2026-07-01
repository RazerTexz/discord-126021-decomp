package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.util.List;
import java.lang.annotation.Annotation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.ConfigurationKeys;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleConstructor$HandleAllArgsConstructor.SCL.lombok */
public class HandleConstructor$HandleAllArgsConstructor extends JavacAnnotationHandler<AllArgsConstructor> {
    private static final String NAME = AllArgsConstructor.class.getSimpleName();
    private HandleConstructor handleConstructor = new HandleConstructor();

    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<AllArgsConstructor> annotation, JCTree$JCAnnotation ast, JavacNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.ALL_ARGS_CONSTRUCTOR_FLAG_USAGE, "@AllArgsConstructor", ConfigurationKeys.ANY_CONSTRUCTOR_FLAG_USAGE, "any @xArgsConstructor");
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) AllArgsConstructor.class);
        JavacHandlerUtil.deleteImportFromCompilationUnit(annotationNode, "lombok.AccessLevel");
        JavacNode typeNode = annotationNode.up();
        if (HandleConstructor.checkLegality(typeNode, annotationNode, NAME)) {
            List<JCTree$JCAnnotation> onConstructor = JavacHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onConstructor", "@AllArgsConstructor(onConstructor", annotationNode);
            AllArgsConstructor ann = annotation.getInstance();
            AccessLevel level = ann.access();
            if (level == AccessLevel.NONE) {
                return;
            }
            String staticName = ann.staticName();
            if (annotation.isExplicit("suppressConstructorProperties")) {
                annotationNode.addError("This deprecated feature is no longer supported. Remove it; you can create a lombok.config file with 'lombok.anyConstructor.suppressConstructorProperties = true'.");
            }
            this.handleConstructor.generateConstructor(typeNode, level, onConstructor, HandleConstructor.findAllFields(typeNode), false, staticName, HandleConstructor$SkipIfConstructorExists.NO, annotationNode);
        }
    }
}
