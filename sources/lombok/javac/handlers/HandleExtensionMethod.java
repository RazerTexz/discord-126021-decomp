package lombok.javac.handlers;

import com.sun.tools.javac.code.Symbol$MethodSymbol;
import com.sun.tools.javac.code.Symbol$TypeSymbol;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.code.Type$ClassType;
import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.tree.JCTree$JCFieldAccess;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.element.ElementKind;
import lombok.ConfigurationKeys;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.experimental.ExtensionMethod;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleExtensionMethod.SCL.lombok */
@HandlerPriority(66560)
public class HandleExtensionMethod extends JavacAnnotationHandler<ExtensionMethod> {
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<ExtensionMethod> annotation, JCTree$JCAnnotation source, JavacNode annotationNode) {
        HandlerUtil.handleExperimentalFlagUsage(annotationNode, ConfigurationKeys.EXTENSION_METHOD_FLAG_USAGE, "@ExtensionMethod");
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) ExtensionMethod.class);
        JavacNode typeNode = annotationNode.up();
        boolean isClassOrEnum = JavacHandlerUtil.isClassOrEnum(typeNode);
        if (!isClassOrEnum) {
            annotationNode.addError("@ExtensionMethod can only be used on a class or an enum");
            return;
        }
        boolean suppressBaseMethods = annotation.getInstance().suppressBaseMethods();
        List<Object> extensionProviders = annotation.getActualExpressions("value");
        if (extensionProviders.isEmpty()) {
            annotationNode.addError(String.format("@%s has no effect since no extension types were specified.", ExtensionMethod.class.getName()));
            return;
        }
        List<HandleExtensionMethod$Extension> extensions = getExtensions(annotationNode, extensionProviders);
        if (extensions.isEmpty()) {
            return;
        }
        new HandleExtensionMethod$ExtensionMethodReplaceVisitor(annotationNode, extensions, suppressBaseMethods).replace();
        annotationNode.rebuild();
    }

    public List<HandleExtensionMethod$Extension> getExtensions(JavacNode typeNode, List<Object> extensionProviders) {
        Type providerType;
        List<HandleExtensionMethod$Extension> extensions = new ArrayList<>();
        for (Object extensionProvider : extensionProviders) {
            if (extensionProvider instanceof JCTree$JCFieldAccess) {
                JCTree$JCFieldAccess provider = (JCTree$JCFieldAccess) extensionProvider;
                if ("class".equals(provider.name.toString()) && (providerType = JavacResolver.CLASS.resolveMember(typeNode, provider.selected)) != null && (providerType.tsym.flags() & 8704) == 0) {
                    extensions.add(getExtension(typeNode, (Type$ClassType) providerType));
                }
            }
        }
        return extensions;
    }

    public HandleExtensionMethod$Extension getExtension(JavacNode typeNode, Type$ClassType extensionMethodProviderType) {
        List<Symbol$MethodSymbol> extensionMethods = new ArrayList<>();
        Symbol$TypeSymbol tsym = extensionMethodProviderType.asElement();
        if (tsym != null) {
            for (Symbol$MethodSymbol symbol$MethodSymbol : tsym.getEnclosedElements()) {
                if (symbol$MethodSymbol.getKind() == ElementKind.METHOD) {
                    Symbol$MethodSymbol method = symbol$MethodSymbol;
                    if ((method.flags() & 9) != 0 && !method.params().isEmpty()) {
                        extensionMethods.add(method);
                    }
                }
            }
        }
        return new HandleExtensionMethod$Extension(extensionMethods, tsym);
    }
}
