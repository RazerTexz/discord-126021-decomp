package lombok.eclipse.agent;

import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.core.JavaElement;
import org.eclipse.jdt.internal.core.SourceMethod;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchDelegate$DelegateSourceMethod.SCL.lombok */
final class PatchDelegate$DelegateSourceMethod extends SourceMethod {
    private PatchDelegate$DelegateSourceMethod$DelegateSourceMethodInfo sourceMethodInfo;

    static /* synthetic */ PatchDelegate$DelegateSourceMethod access$0(JavaElement javaElement, MethodDeclaration methodDeclaration) {
        return forMethodDeclaration(javaElement, methodDeclaration);
    }

    private static PatchDelegate$DelegateSourceMethod forMethodDeclaration(JavaElement parent, MethodDeclaration method) {
        Argument[] arguments = method.arguments != null ? method.arguments : new Argument[0];
        String[] parameterTypes = new String[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            parameterTypes[i] = Signature.createTypeSignature(CharOperation.concatWith(arguments[i].type.getParameterizedTypeName(), '.'), false);
        }
        return new PatchDelegate$DelegateSourceMethod(parent, new String(method.selector), parameterTypes, method);
    }

    private PatchDelegate$DelegateSourceMethod(JavaElement parent, String name, String[] parameterTypes, MethodDeclaration md) {
        super(parent, name, parameterTypes);
        this.sourceMethodInfo = new PatchDelegate$DelegateSourceMethod$DelegateSourceMethodInfo(this, md);
    }

    public Object getElementInfo() throws JavaModelException {
        return this.sourceMethodInfo;
    }

    public boolean isReadOnly() {
        return true;
    }

    public boolean equals(Object o) {
        return this == o;
    }
}
