package lombok.eclipse.agent;

import org.eclipse.jdt.core.ILocalVariable;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.core.LocalVariable;
import org.eclipse.jdt.internal.core.SourceMethodInfo;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchDelegate$DelegateSourceMethod$DelegateSourceMethodInfo.SCL.lombok */
public final class PatchDelegate$DelegateSourceMethod$DelegateSourceMethodInfo extends SourceMethodInfo {
    public /* bridge */ /* synthetic */ int getDeclarationSourceEnd() {
        return super.getDeclarationSourceEnd();
    }

    public /* bridge */ /* synthetic */ int getDeclarationSourceStart() {
        return super.getDeclarationSourceStart();
    }

    public /* bridge */ /* synthetic */ int getModifiers() {
        return super.getModifiers();
    }

    PatchDelegate$DelegateSourceMethod$DelegateSourceMethodInfo(PatchDelegate$DelegateSourceMethod delegateSourceMethod, MethodDeclaration md) {
        int pS = md.sourceStart;
        int pE = md.sourceEnd;
        Argument[] methodArguments = md.arguments != null ? md.arguments : new Argument[0];
        char[][] argumentNames = new char[methodArguments.length][];
        this.arguments = new ILocalVariable[methodArguments.length];
        for (int i = 0; i < methodArguments.length; i++) {
            Argument argument = methodArguments[i];
            argumentNames[i] = argument.name;
            this.arguments[i] = new LocalVariable(delegateSourceMethod, new String(argument.name), pS, pE, pS, pS, delegateSourceMethod.getParameterTypes()[i], argument.annotations, argument.modifiers, true);
        }
        setArgumentNames(argumentNames);
        setSourceRangeStart(pS);
        setSourceRangeEnd(pE);
        setNameSourceStart(pS);
        setNameSourceEnd(pE);
        setExceptionTypeNames(CharOperation.NO_CHAR_CHAR);
        setReturnType(md.returnType == null ? new char[]{'v', 'o', 'i', 'd'} : CharOperation.concatWith(md.returnType.getParameterizedTypeName(), '.'));
        setFlags(md.modifiers);
    }
}
