package lombok.eclipse.agent;

import java.util.Arrays;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.codeassist.CompletionEngine;
import org.eclipse.jdt.internal.codeassist.InternalCompletionProposal;
import org.eclipse.jdt.internal.codeassist.complete.CompletionOnMemberAccess;
import org.eclipse.jdt.internal.codeassist.complete.CompletionOnQualifiedNameReference;
import org.eclipse.jdt.internal.codeassist.complete.CompletionOnSingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.core.NameLookup;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/ExtensionMethodCompletionProposal.SCL.lombok */
public class ExtensionMethodCompletionProposal extends InternalCompletionProposal {
    private char[] fullSignature;
    private char[][] parameterNames;

    public ExtensionMethodCompletionProposal(int replacementOffset) {
        super(6, replacementOffset - 1);
    }

    public void setMethodBinding(MethodBinding method, ASTNode node) {
        if (method.parameterNames != null && method.parameterNames.length > 0) {
            setParameterNames((char[][]) Arrays.copyOfRange(method.parameterNames, 1, method.parameterNames.length));
        } else {
            this.fullSignature = CompletionEngine.getSignature(method);
        }
        MethodBinding original = method.original();
        TypeBinding[] parameters = (TypeBinding[]) Arrays.copyOf(method.parameters, method.parameters.length);
        method.parameters = (TypeBinding[]) Arrays.copyOfRange(method.parameters, 1, method.parameters.length);
        TypeBinding[] originalParameters = null;
        if (original != method) {
            originalParameters = (TypeBinding[]) Arrays.copyOf(method.original().parameters, method.original().parameters.length);
            method.original().parameters = (TypeBinding[]) Arrays.copyOfRange(method.original().parameters, 1, method.original().parameters.length);
        }
        int length = method.parameters == null ? 0 : method.parameters.length;
        char[][] parameterPackageNames = new char[length][];
        char[][] parameterTypeNames = new char[length][];
        for (int i = 0; i < length; i++) {
            TypeBinding type = method.original().parameters[i];
            parameterPackageNames[i] = type.qualifiedPackageName();
            parameterTypeNames[i] = type.qualifiedSourceName();
        }
        char[] completion = CharOperation.concat(method.selector, new char[]{'(', ')'});
        setDeclarationSignature(CompletionEngine.getSignature(method.declaringClass));
        setSignature(CompletionEngine.getSignature(method));
        if (original != method) {
            setOriginalSignature(CompletionEngine.getSignature(original));
        }
        setDeclarationPackageName(method.declaringClass.qualifiedPackageName());
        setDeclarationTypeName(method.declaringClass.qualifiedSourceName());
        setParameterPackageNames(parameterPackageNames);
        setParameterTypeNames(parameterTypeNames);
        setPackageName(method.returnType.qualifiedPackageName());
        setTypeName(method.returnType.qualifiedSourceName());
        setName(method.selector);
        setCompletion(completion);
        setFlags(method.modifiers & (-9));
        if (method.isVarargs() && length == 0) {
            setFlags(getFlags() & (-129));
        }
        int index = node.sourceEnd + 1;
        if (node instanceof CompletionOnQualifiedNameReference) {
            index -= ((CompletionOnQualifiedNameReference) node).completionIdentifier.length;
        }
        if (node instanceof CompletionOnMemberAccess) {
            index -= ((CompletionOnMemberAccess) node).token.length;
        }
        if (node instanceof CompletionOnSingleNameReference) {
            index -= ((CompletionOnSingleNameReference) node).token.length;
        }
        setReplaceRange(index, index);
        setTokenRange(index, index);
        setRelevance(100);
        method.parameters = parameters;
        if (original != method) {
            method.original().parameters = originalParameters;
        }
    }

    public char[][] findParameterNames(IProgressMonitor monitor) {
        if (this.parameterNames != null) {
            return this.parameterNames;
        }
        NameLookup.Answer answer = this.nameLookup.findType(new String(this.declarationTypeName), new String(this.declarationPackageName), false, 0, true, false, false, (IProgressMonitor) null);
        if (answer != null && answer.type != null) {
            char[][] parameterTypes = Signature.getParameterTypes(this.fullSignature);
            String[] args = new String[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                args[i] = new String(parameterTypes[i]);
            }
            IMethod method = answer.type.getMethod(new String(getName()), args);
            IMethod[] methods = answer.type.findMethods(method);
            if (methods != null && methods.length > 0) {
                method = methods[0];
            }
            if (method != null) {
                try {
                    String[] parameterNames = method.getParameterNames();
                    char[][] parameterNamesAsChar = new char[parameterNames.length - 1][];
                    for (int i2 = 0; i2 < parameterNamesAsChar.length; i2++) {
                        parameterNamesAsChar[i2] = parameterNames[i2 + 1].toCharArray();
                    }
                    setParameterNames(parameterNamesAsChar);
                } catch (JavaModelException unused) {
                }
            }
        }
        if (this.parameterNames == null) {
            this.parameterNames = super.findParameterNames(monitor);
        }
        return this.parameterNames;
    }

    public void setParameterNames(char[][] parameterNames) {
        this.parameterNames = parameterNames;
        super.setParameterNames(parameterNames);
    }
}
