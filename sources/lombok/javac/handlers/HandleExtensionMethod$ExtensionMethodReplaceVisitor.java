package lombok.javac.handlers;

import com.sun.source.tree.MethodInvocationTree;
import com.sun.source.util.TreeScanner;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Symbol$ClassSymbol;
import com.sun.tools.javac.code.Symbol$MethodSymbol;
import com.sun.tools.javac.code.Symbol$TypeSymbol;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.code.Type$ErrorType;
import com.sun.tools.javac.code.Type$ForAll;
import com.sun.tools.javac.code.Type$MethodType;
import com.sun.tools.javac.code.Types;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.tree.JCTree$JCFieldAccess;
import com.sun.tools.javac.tree.JCTree$JCIdent;
import com.sun.tools.javac.tree.JCTree$JCMethodInvocation;
import java.util.List;
import java.util.Map;
import lombok.javac.JavacNode;
import lombok.javac.JavacResolution;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleExtensionMethod$ExtensionMethodReplaceVisitor.SCL.lombok */
class HandleExtensionMethod$ExtensionMethodReplaceVisitor extends TreeScanner<Void, Void> {
    final JavacNode annotationNode;
    final List<HandleExtensionMethod$Extension> extensions;
    final boolean suppressBaseMethods;

    public /* bridge */ /* synthetic */ Object visitMethodInvocation(MethodInvocationTree methodInvocationTree, Object obj) {
        return visitMethodInvocation(methodInvocationTree, (Void) obj);
    }

    public HandleExtensionMethod$ExtensionMethodReplaceVisitor(JavacNode annotationNode, List<HandleExtensionMethod$Extension> extensions, boolean suppressBaseMethods) {
        this.annotationNode = annotationNode;
        this.extensions = extensions;
        this.suppressBaseMethods = suppressBaseMethods;
    }

    public void replace() {
        this.annotationNode.up().get().accept(this, (Object) null);
    }

    public Void visitMethodInvocation(MethodInvocationTree tree, Void p) {
        handleMethodCall((JCTree$JCMethodInvocation) tree);
        return (Void) super.visitMethodInvocation(tree, p);
    }

    private void handleMethodCall(JCTree$JCMethodInvocation methodCall) {
        Map<JCTree, JCTree> resolution;
        JCTree resolvedMethodCall;
        JCTree$JCIdent jCTree$JCIdent;
        JavacNode methodCallNode = this.annotationNode.getAst().get(methodCall);
        if (methodCallNode == null) {
            return;
        }
        JavacNode surroundingType = JavacHandlerUtil.upToTypeNode(methodCallNode);
        Symbol$TypeSymbol surroundingTypeSymbol = surroundingType.get().sym;
        JCTree$JCExpression receiver = receiverOf(methodCall);
        String methodName = methodNameOf(methodCall);
        if ("this".equals(receiver.toString()) || "this".equals(methodName) || "super".equals(methodName) || (resolvedMethodCall = (resolution = new JavacResolution(methodCallNode.getContext()).resolveMethodMember(methodCallNode)).get(methodCall)) == null || resolvedMethodCall.type == null) {
            return;
        }
        if ((!this.suppressBaseMethods && !(resolvedMethodCall.type instanceof Type$ErrorType)) || (jCTree$JCIdent = (JCTree) resolution.get(receiver)) == null || ((JCTree) jCTree$JCIdent).type == null) {
            return;
        }
        Type receiverType = ((JCTree) jCTree$JCIdent).type;
        Symbol sym = null;
        if (jCTree$JCIdent instanceof JCTree$JCIdent) {
            sym = jCTree$JCIdent.sym;
        } else if (jCTree$JCIdent instanceof JCTree$JCFieldAccess) {
            sym = ((JCTree$JCFieldAccess) jCTree$JCIdent).sym;
        }
        if (sym instanceof Symbol$ClassSymbol) {
            return;
        }
        Types types = Types.instance(this.annotationNode.getContext());
        for (HandleExtensionMethod$Extension extension : this.extensions) {
            Symbol$TypeSymbol extensionProvider = extension.extensionProvider;
            if (surroundingTypeSymbol != extensionProvider) {
                for (Symbol$MethodSymbol extensionMethod : extension.extensionMethods) {
                    if (methodName.equals(extensionMethod.name.toString())) {
                        Type extensionMethodType = extensionMethod.type;
                        if (Type$MethodType.class.isInstance(extensionMethodType) || Type$ForAll.class.isInstance(extensionMethodType)) {
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

    private String methodNameOf(JCTree$JCMethodInvocation methodCall) {
        if (methodCall.meth instanceof JCTree$JCIdent) {
            return methodCall.meth.name.toString();
        }
        return methodCall.meth.name.toString();
    }

    private JCTree$JCExpression receiverOf(JCTree$JCMethodInvocation methodCall) {
        if (methodCall.meth instanceof JCTree$JCIdent) {
            return this.annotationNode.getTreeMaker().Ident(this.annotationNode.toName("this"));
        }
        return methodCall.meth.selected;
    }
}
