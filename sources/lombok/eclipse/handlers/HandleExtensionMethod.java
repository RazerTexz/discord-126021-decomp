package lombok.eclipse.handlers;

import java.util.List;
import lombok.ConfigurationKeys;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.experimental.ExtensionMethod;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;

/* JADX INFO: loaded from: discord-126021.apk:lombok/eclipse/handlers/HandleExtensionMethod.SCL.lombok */
@HandlerPriority(66560)
public class HandleExtensionMethod extends EclipseAnnotationHandler<ExtensionMethod> {
    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<ExtensionMethod> annotation, Annotation ast, EclipseNode annotationNode) {
        HandlerUtil.handleExperimentalFlagUsage(annotationNode, ConfigurationKeys.EXTENSION_METHOD_FLAG_USAGE, "@ExtensionMethod");
        TypeDeclaration typeDecl = null;
        EclipseNode owner = annotationNode.m10925up();
        if (owner.get() instanceof TypeDeclaration) {
            typeDecl = (TypeDeclaration) owner.get();
        }
        int modifiers = typeDecl == null ? 0 : typeDecl.modifiers;
        boolean notAClass = (modifiers & 8704) != 0;
        if (typeDecl == null || notAClass) {
            annotationNode.addError("@ExtensionMethod is legal only on classes and enums.");
            return;
        }
        List<Object> listenerInterfaces = annotation.getActualExpressions("value");
        if (listenerInterfaces.isEmpty()) {
            annotationNode.addWarning(String.format("@ExtensionMethod has no effect since no extension types were specified.", new Object[0]));
        }
    }
}
