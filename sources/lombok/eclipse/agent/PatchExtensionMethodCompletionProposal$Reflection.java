package lombok.eclipse.agent;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import lombok.permit.Permit;
import org.eclipse.jdt.core.CompletionProposal;
import org.eclipse.jdt.internal.codeassist.InternalCompletionContext;
import org.eclipse.jdt.internal.codeassist.InternalCompletionProposal;
import org.eclipse.jdt.internal.codeassist.InternalExtendedCompletionContext;
import org.eclipse.jdt.internal.ui.text.java.AbstractJavaCompletionProposal;
import org.eclipse.jdt.ui.text.java.CompletionProposalCollector;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchExtensionMethodCompletionProposal$Reflection.SCL.lombok */
class PatchExtensionMethodCompletionProposal$Reflection {
    public static final Field replacementOffsetField = accessField(AbstractJavaCompletionProposal.class, "fReplacementOffset");
    public static final Field contextField = accessField(CompletionProposalCollector.class, "fContext");
    public static final Field extendedContextField = accessField(InternalCompletionContext.class, "extendedContext");
    public static final Field assistNodeField = accessField(InternalExtendedCompletionContext.class, "assistNode");
    public static final Field assistScopeField = accessField(InternalExtendedCompletionContext.class, "assistScope");
    public static final Field lookupEnvironmentField = accessField(InternalExtendedCompletionContext.class, "lookupEnvironment");
    public static final Field completionEngineField = accessField(InternalCompletionProposal.class, "completionEngine");
    public static final Field nameLookupField = accessField(InternalCompletionProposal.class, "nameLookup");
    public static final Method createJavaCompletionProposalMethod = accessMethod(CompletionProposalCollector.class, "createJavaCompletionProposal", CompletionProposal.class);

    PatchExtensionMethodCompletionProposal$Reflection() {
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
