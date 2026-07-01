package lombok.eclipse.agent;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.agent.PatchExtensionMethod;
import lombok.experimental.ExtensionMethod;
import lombok.permit.Permit;
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
import org.eclipse.jdt.internal.ui.text.java.AbstractJavaCompletionProposal;
import org.eclipse.jdt.ui.text.java.CompletionProposalCollector;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposal;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchExtensionMethodCompletionProposal.SCL.lombok */
public class PatchExtensionMethodCompletionProposal {
    public static IJavaCompletionProposal[] getJavaCompletionProposals(IJavaCompletionProposal[] javaCompletionProposals, CompletionProposalCollector completionProposalCollector) {
        List<IJavaCompletionProposal> proposals = new ArrayList<>(Arrays.asList(javaCompletionProposals));
        if (canExtendCodeAssist()) {
            for (PatchExtensionMethod.Extension extension : getExtensionMethods(completionProposalCollector)) {
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

    private static List<PatchExtensionMethod.Extension> getExtensionMethods(CompletionProposalCollector completionProposalCollector) {
        List<PatchExtensionMethod.Extension> extensions = new ArrayList<>();
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
            InternalCompletionContext context = (InternalCompletionContext) Reflection.contextField.get(completionProposalCollector);
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
            InternalCompletionContext context = (InternalCompletionContext) Reflection.contextField.get(completionProposalCollector);
            InternalExtendedCompletionContext extendedContext = (InternalExtendedCompletionContext) Reflection.extendedContextField.get(context);
            if (extendedContext == null) {
                return null;
            }
            return (ASTNode) Reflection.assistNodeField.get(extendedContext);
        } catch (Exception unused) {
            return null;
        }
    }

    private static ClassScope getClassScope(CompletionProposalCollector completionProposalCollector) {
        Scope assistScope;
        ClassScope scope = null;
        try {
            InternalCompletionContext context = (InternalCompletionContext) Reflection.contextField.get(completionProposalCollector);
            InternalExtendedCompletionContext extendedContext = (InternalExtendedCompletionContext) Reflection.extendedContextField.get(context);
            if (extendedContext != null && (assistScope = (Scope) Reflection.assistScopeField.get(extendedContext)) != null) {
                scope = assistScope.classScope();
            }
        } catch (IllegalAccessException unused) {
        }
        return scope;
    }

    private static void copyNameLookupAndCompletionEngine(CompletionProposalCollector completionProposalCollector, InternalCompletionProposal newProposal) {
        try {
            InternalCompletionContext context = (InternalCompletionContext) Reflection.contextField.get(completionProposalCollector);
            InternalExtendedCompletionContext extendedContext = (InternalExtendedCompletionContext) Reflection.extendedContextField.get(context);
            LookupEnvironment lookupEnvironment = (LookupEnvironment) Reflection.lookupEnvironmentField.get(extendedContext);
            Reflection.nameLookupField.set(newProposal, lookupEnvironment.nameEnvironment.nameLookup);
            Reflection.completionEngineField.set(newProposal, lookupEnvironment.typeRequestor);
        } catch (IllegalAccessException unused) {
        }
    }

    private static void createAndAddJavaCompletionProposal(CompletionProposalCollector completionProposalCollector, CompletionProposal newProposal, List<IJavaCompletionProposal> proposals) {
        try {
            proposals.add((IJavaCompletionProposal) Reflection.createJavaCompletionProposalMethod.invoke(completionProposalCollector, newProposal));
        } catch (Exception unused) {
        }
    }

    private static boolean canExtendCodeAssist() {
        return Reflection.isComplete();
    }

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchExtensionMethodCompletionProposal$Reflection.SCL.lombok */
    static class Reflection {
        public static final Field replacementOffsetField = accessField(AbstractJavaCompletionProposal.class, "fReplacementOffset");
        public static final Field contextField = accessField(CompletionProposalCollector.class, "fContext");
        public static final Field extendedContextField = accessField(InternalCompletionContext.class, "extendedContext");
        public static final Field assistNodeField = accessField(InternalExtendedCompletionContext.class, "assistNode");
        public static final Field assistScopeField = accessField(InternalExtendedCompletionContext.class, "assistScope");
        public static final Field lookupEnvironmentField = accessField(InternalExtendedCompletionContext.class, "lookupEnvironment");
        public static final Field completionEngineField = accessField(InternalCompletionProposal.class, "completionEngine");
        public static final Field nameLookupField = accessField(InternalCompletionProposal.class, "nameLookup");
        public static final Method createJavaCompletionProposalMethod = accessMethod(CompletionProposalCollector.class, "createJavaCompletionProposal", CompletionProposal.class);

        Reflection() {
        }

        static boolean isComplete() {
            Object[] requiredFieldsAndMethods = {replacementOffsetField, contextField, extendedContextField, assistNodeField, assistScopeField, lookupEnvironmentField, completionEngineField, nameLookupField, createJavaCompletionProposalMethod};
            for (Object o : requiredFieldsAndMethods) {
                if (o == null) {
                    return false;
                }
            }
            return true;
        }

        private static Field accessField(Class<?> clazz, String fieldName) {
            try {
                return (Field) makeAccessible(clazz.getDeclaredField(fieldName));
            } catch (Exception unused) {
                return null;
            }
        }

        private static Method accessMethod(Class<?> clazz, String methodName, Class<?> parameter) {
            try {
                return (Method) makeAccessible(clazz.getDeclaredMethod(methodName, parameter));
            } catch (Exception unused) {
                return null;
            }
        }

        private static <T extends AccessibleObject> T makeAccessible(T t) {
            return (T) Permit.setAccessible(t);
        }
    }
}
