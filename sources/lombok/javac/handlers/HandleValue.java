package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.tree.JCTree$JCModifiers;
import com.sun.tools.javac.util.List;
import java.lang.annotation.Annotation;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.Value;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.experimental.NonFinal;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleValue.SCL.lombok */
@HandlerPriority(-512)
public class HandleValue extends JavacAnnotationHandler<Value> {
    private HandleFieldDefaults handleFieldDefaults = new HandleFieldDefaults();
    private HandleConstructor handleConstructor = new HandleConstructor();
    private HandleGetter handleGetter = new HandleGetter();
    private HandleEqualsAndHashCode handleEqualsAndHashCode = new HandleEqualsAndHashCode();
    private HandleToString handleToString = new HandleToString();

    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Value> annotation, JCTree$JCAnnotation ast, JavacNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.VALUE_FLAG_USAGE, "@Value");
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) Value.class, "lombok.experimental.Value");
        JavacNode typeNode = annotationNode.up();
        boolean notAClass = !JavacHandlerUtil.isClass(typeNode);
        if (notAClass) {
            annotationNode.addError("@Value is only supported on a class.");
            return;
        }
        String staticConstructorName = annotation.getInstance().staticConstructor();
        if (!JavacHandlerUtil.hasAnnotationAndDeleteIfNeccessary(NonFinal.class, typeNode)) {
            JCTree$JCModifiers jcm = typeNode.get().mods;
            if ((jcm.flags & 16) == 0) {
                jcm.flags |= 16;
                typeNode.rebuild();
            }
        }
        this.handleFieldDefaults.generateFieldDefaultsForType(typeNode, annotationNode, AccessLevel.PRIVATE, true, true);
        this.handleConstructor.generateAllArgsConstructor(typeNode, AccessLevel.PUBLIC, staticConstructorName, HandleConstructor$SkipIfConstructorExists.YES, annotationNode);
        this.handleConstructor.generateExtraNoArgsConstructor(typeNode, annotationNode);
        this.handleGetter.generateGetterForType(typeNode, annotationNode, AccessLevel.PUBLIC, true, List.nil());
        this.handleEqualsAndHashCode.generateEqualsAndHashCodeForType(typeNode, annotationNode);
        this.handleToString.generateToStringForType(typeNode, annotationNode);
    }
}
