package lombok.eclipse.agent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.eclipse.EclipseNode;
import lombok.experimental.ExtensionMethod;
import org.eclipse.jdt.core.CompletionProposal;
import org.eclipse.jdt.internal.codeassist.InternalCompletionContext;
import org.eclipse.jdt.internal.codeassist.InternalCompletionProposal;
import org.eclipse.jdt.internal.codeassist.InternalExtendedCompletionContext;
import org.eclipse.jdt.internal.codeassist.complete.CompletionOnMemberAccess;
import org.eclipse.jdt.internal.codeassist.complete.CompletionOnQualifiedNameReference;
import org.eclipse.jdt.internal.codeassist.complete.CompletionOnSingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.NameReference;
import org.eclipse.jdt.internal.compiler.ast.SuperReference;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.VariableBinding;
import org.eclipse.jdt.ui.text.java.CompletionProposalCollector;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposal;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchExtensionMethodCompletionProposal.SCL.lombok */
public class PatchExtensionMethodCompletionProposal {
    public static IJavaCompletionProposal[] getJavaCompletionProposals(IJavaCompletionProposal[] javaCompletionProposals, CompletionProposalCollector completionProposalCollector) {
        List<IJavaCompletionProposal> proposals = new ArrayList<>(Arrays.asList(javaCompletionProposals));
        if (canExtendCodeAssist()) {
            for (PatchExtensionMethod$Extension extension : getExtensionMethods(completionProposalCollector)) {
                for (MethodBinding method : extension.extensionMethods) {
                    if (isMatchingProposal(method, completionProposalCollector)) {
                        ExtensionMethodCompletionProposal newProposal = new ExtensionMethodCompletionProposal(0);
                        copyNameLookupAndCompletionEngine(completionProposalCollector, newProposal);
                        ASTNode node = getAssistNode(completionProposalCollector);
                        newProposal.setMethodBinding(method, node);
                        createAndAddJavaCompletionProposal(completionProposalCollector, newProposal, proposals);
                    }
                }
            }
        }
        return (IJavaCompletionProposal[]) proposals.toArray(new IJavaCompletionProposal[0]);
    }

    private static List<PatchExtensionMethod$Extension> getExtensionMethods(CompletionProposalCollector completionProposalCollector) {
        List<PatchExtensionMethod$Extension> extensions = new ArrayList<>();
        ClassScope classScope = getClassScope(completionProposalCollector);
        if (classScope != null) {
            TypeDeclaration decl = classScope.referenceContext;
            TypeBinding firstParameterType = getFirstParameterType(decl, completionProposalCollector);
            EclipseNode typeNode = PatchExtensionMethod.getTypeNode(decl);
            while (true) {
                EclipseNode typeNode2 = typeNode;
                if (typeNode2 == null) {
                    break;
                }
                Annotation ann = PatchExtensionMethod.getAnnotation(ExtensionMethod.class, typeNode2);
                extensions.addAll(0, PatchExtensionMethod.getApplicableExtensionMethods(typeNode2, ann, firstParameterType));
                typeNode = PatchExtensionMethod.upToType(typeNode2);
            }
        }
        return extensions;
    }

    private static boolean isMatchingProposal(MethodBinding method, CompletionProposalCollector completionProposalCollector) {
        try {
            InternalCompletionContext context = (InternalCompletionContext) PatchExtensionMethodCompletionProposal$Reflection.contextField.get(completionProposalCollector);
            String searchToken = new String(context.getToken());
            String extensionMethodName = new String(method.selector);
            return extensionMethodName.contains(searchToken);
        } catch (IllegalAccessException unused) {
            return true;
        }
    }

    static TypeBinding getFirstParameterType(TypeDeclaration decl, CompletionProposalCollector completionProposalCollector) {
        TypeBinding firstParameterType = null;
        FieldReference assistNode = getAssistNode(completionProposalCollector);
        if (assistNode == null) {
            return null;
        }
        if (!(assistNode instanceof CompletionOnQualifiedNameReference) && !(assistNode instanceof CompletionOnSingleNameReference) && !(assistNode instanceof CompletionOnMemberAccess)) {
            return null;
        }
        if ((assistNode instanceof FieldReference) && (assistNode.receiver instanceof SuperReference)) {
            return null;
        }
        if (assistNode instanceof NameReference) {
            VariableBinding variableBinding = ((NameReference) assistNode).binding;
            if (variableBinding instanceof VariableBinding) {
                firstParameterType = variableBinding.type;
            }
        } else if (assistNode instanceof FieldReference) {
            firstParameterType = assistNode.actualReceiverType;
        }
        return firstParameterType;
    }

    private static ASTNode getAssistNode(CompletionProposalCollector completionProposalCollector) {
        try {
            InternalCompletionContext context = (InternalCompletionContext) PatchExtensionMethodCompletionProposal$Reflection.contextField.get(completionProposalCollector);
            InternalExtendedCompletionContext extendedContext = (InternalExtendedCompletionContext) PatchExtensionMethodCompletionProposal$Reflection.extendedContextField.get(context);
            if (extendedContext == null) {
                return null;
            }
            return (ASTNode) PatchExtensionMethodCompletionProposal$Reflection.assistNodeField.get(extendedContext);
        } catch (Exception unused) {
            return null;
        }
    }

    private static ClassScope getClassScope(CompletionProposalCollector completionProposalCollector) {
        Scope assistScope;
        ClassScope scope = null;
        try {
            InternalCompletionContext context = (InternalCompletionContext) PatchExtensionMethodCompletionProposal$Reflection.contextField.get(completionProposalCollector);
            InternalExtendedCompletionContext extendedContext = (InternalExtendedCompletionContext) PatchExtensionMethodCompletionProposal$Reflection.extendedContextField.get(context);
            if (extendedContext != null && (assistScope = (Scope) PatchExtensionMethodCompletionProposal$Reflection.assistScopeField.get(extendedContext)) != null) {
                scope = assistScope.classScope();
            }
        } catch (IllegalAccessException unused) {
        }
        return scope;
    }

    private static void copyNameLookupAndCompletionEngine(CompletionProposalCollector completionProposalCollector, InternalCompletionProposal newProposal) {
        try {
            InternalCompletionContext context = (InternalCompletionContext) PatchExtensionMethodCompletionProposal$Reflection.contextField.get(completionProposalCollector);
            InternalExtendedCompletionContext extendedContext = (InternalExtendedCompletionContext) PatchExtensionMethodCompletionProposal$Reflection.extendedContextField.get(context);
            LookupEnvironment lookupEnvironment = (LookupEnvironment) PatchExtensionMethodCompletionProposal$Reflection.lookupEnvironmentField.get(extendedContext);
            PatchExtensionMethodCompletionProposal$Reflection.nameLookupField.set(newProposal, lookupEnvironment.nameEnvironment.nameLookup);
            PatchExtensionMethodCompletionProposal$Reflection.completionEngineField.set(newProposal, lookupEnvironment.typeRequestor);
        } catch (IllegalAccessException unused) {
        }
    }

    private static void createAndAddJavaCompletionProposal(CompletionProposalCollector completionProposalCollector, CompletionProposal newProposal, List<IJavaCompletionProposal> proposals) {
        try {
            proposals.add((IJavaCompletionProposal) PatchExtensionMethodCompletionProposal$Reflection.createJavaCompletionProposalMethod.invoke(completionProposalCollector, newProposal));
        } catch (Exception unused) {
        }
    }

    private static boolean canExtendCodeAssist() {
        return PatchExtensionMethodCompletionProposal$Reflection.isComplete();
    }
}
