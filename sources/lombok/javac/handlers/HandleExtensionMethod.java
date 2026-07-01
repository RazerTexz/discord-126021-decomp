package lombok.javac.handlers;

import com.sun.source.tree.MethodInvocationTree;
import com.sun.source.util.TreeScanner;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.code.Types;
import com.sun.tools.javac.tree.JCTree;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.ElementKind;
import lombok.ConfigurationKeys;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.experimental.ExtensionMethod;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacResolution;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleExtensionMethod.SCL.lombok */
@HandlerPriority(66560)
public class HandleExtensionMethod extends JavacAnnotationHandler<ExtensionMethod> {
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<ExtensionMethod> annotation, JCTree.JCAnnotation source, JavacNode annotationNode) {
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
        List<Extension> extensions = getExtensions(annotationNode, extensionProviders);
        if (extensions.isEmpty()) {
            return;
        }
        new ExtensionMethodReplaceVisitor(annotationNode, extensions, suppressBaseMethods).replace();
        annotationNode.rebuild();
    }

    public List<Extension> getExtensions(JavacNode typeNode, List<Object> extensionProviders) {
        Type providerType;
        List<Extension> extensions = new ArrayList<>();
        for (Object extensionProvider : extensionProviders) {
            if (extensionProvider instanceof JCTree.JCFieldAccess) {
                JCTree.JCFieldAccess provider = (JCTree.JCFieldAccess) extensionProvider;
                if ("class".equals(provider.name.toString()) && (providerType = JavacResolver.CLASS.resolveMember(typeNode, provider.selected)) != null && (providerType.tsym.flags() & 8704) == 0) {
                    extensions.add(getExtension(typeNode, (Type.ClassType) providerType));
                }
            }
        }
        return extensions;
    }

    public Extension getExtension(JavacNode typeNode, Type.ClassType extensionMethodProviderType) {
        List<Symbol.MethodSymbol> extensionMethods = new ArrayList<>();
        Symbol.TypeSymbol tsym = extensionMethodProviderType.asElement();
        if (tsym != null) {
            for (Symbol.MethodSymbol methodSymbol : tsym.getEnclosedElements()) {
                if (methodSymbol.getKind() == ElementKind.METHOD) {
                    Symbol.MethodSymbol method = methodSymbol;
                    if ((method.flags() & 9) != 0 && !method.params().isEmpty()) {
                        extensionMethods.add(method);
                    }
                }
            }
        }
        return new Extension(extensionMethods, tsym);
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleExtensionMethod$Extension.SCL.lombok */
    private static class Extension {
        final List<Symbol.MethodSymbol> extensionMethods;
        final Symbol.TypeSymbol extensionProvider;

        public Extension(List<Symbol.MethodSymbol> extensionMethods, Symbol.TypeSymbol extensionProvider) {
            this.extensionMethods = extensionMethods;
            this.extensionProvider = extensionProvider;
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleExtensionMethod$ExtensionMethodReplaceVisitor.SCL.lombok */
    private static class ExtensionMethodReplaceVisitor extends TreeScanner<Void, Void> {
        final JavacNode annotationNode;
        final List<Extension> extensions;
        final boolean suppressBaseMethods;

        public ExtensionMethodReplaceVisitor(JavacNode annotationNode, List<Extension> extensions, boolean suppressBaseMethods) {
            this.annotationNode = annotationNode;
            this.extensions = extensions;
            this.suppressBaseMethods = suppressBaseMethods;
        }

        public void replace() {
            this.annotationNode.up().get().accept(this, (Object) null);
        }

        public Void visitMethodInvocation(MethodInvocationTree tree, Void p) {
            handleMethodCall((JCTree.JCMethodInvocation) tree);
            return (Void) super.visitMethodInvocation(tree, p);
        }

        private void handleMethodCall(JCTree.JCMethodInvocation methodCall) {
            Map<JCTree, JCTree> resolution;
            JCTree resolvedMethodCall;
            JCTree.JCIdent jCIdent;
            JavacNode methodCallNode = this.annotationNode.getAst().get(methodCall);
            if (methodCallNode == null) {
                return;
            }
            JavacNode surroundingType = JavacHandlerUtil.upToTypeNode(methodCallNode);
            Symbol.TypeSymbol surroundingTypeSymbol = surroundingType.get().sym;
            JCTree.JCExpression receiver = receiverOf(methodCall);
            String methodName = methodNameOf(methodCall);
            if ("this".equals(receiver.toString()) || "this".equals(methodName) || "super".equals(methodName) || (resolvedMethodCall = (resolution = new JavacResolution(methodCallNode.getContext()).resolveMethodMember(methodCallNode)).get(methodCall)) == null || resolvedMethodCall.type == null) {
                return;
            }
            if ((!this.suppressBaseMethods && !(resolvedMethodCall.type instanceof Type.ErrorType)) || (jCIdent = (JCTree) resolution.get(receiver)) == null || ((JCTree) jCIdent).type == null) {
                return;
            }
            Type receiverType = ((JCTree) jCIdent).type;
            Symbol sym = null;
            if (jCIdent instanceof JCTree.JCIdent) {
                sym = jCIdent.sym;
            } else if (jCIdent instanceof JCTree.JCFieldAccess) {
                sym = ((JCTree.JCFieldAccess) jCIdent).sym;
            }
            if (sym instanceof Symbol.ClassSymbol) {
                return;
            }
            Types types = Types.instance(this.annotationNode.getContext());
            for (Extension extension : this.extensions) {
                Symbol.TypeSymbol extensionProvider = extension.extensionProvider;
                if (surroundingTypeSymbol != extensionProvider) {
                    for (Symbol.MethodSymbol extensionMethod : extension.extensionMethods) {
                        if (methodName.equals(extensionMethod.name.toString())) {
                            Type extensionMethodType = extensionMethod.type;
                            if (Type.MethodType.class.isInstance(extensionMethodType) || Type.ForAll.class.isInstance(extensionMethodType)) {
                                Type firstArgType = types.erasure((Type) extensionMethodType.asMethodType().argtypes.get(0));
                                if (types.isAssignable(receiverType, firstArgType)) {
                                    methodCall.args = methodCall.args.prepend(receiver);
                                    methodCall.meth = JavacHandlerUtil.chainDotsString(this.annotationNode, String.valueOf(extensionProvider.toString()) + "." + methodName);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

        private String methodNameOf(JCTree.JCMethodInvocation methodCall) {
            if (methodCall.meth instanceof JCTree.JCIdent) {
                return methodCall.meth.name.toString();
            }
            return methodCall.meth.name.toString();
        }

        private JCTree.JCExpression receiverOf(JCTree.JCMethodInvocation methodCall) {
            if (methodCall.meth instanceof JCTree.JCIdent) {
                return this.annotationNode.getTreeMaker().Ident(this.annotationNode.toName("this"));
            }
            return methodCall.meth.selected;
        }
    }
}
