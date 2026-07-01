package lombok.eclipse.agent;

import java.lang.reflect.InvocationTargetException;
import lombok.Lombok;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchExtensionMethodPortal.SCL.lombok */
public class PatchExtensionMethodPortal {
    private static final String TYPE_BINDING = "org.eclipse.jdt.internal.compiler.lookup.TypeBinding";
    private static final String TYPE_BINDING_ARRAY = "[Lorg.eclipse.jdt.internal.compiler.lookup.TypeBinding;";
    private static final String MESSAGE_SEND = "org.eclipse.jdt.internal.compiler.ast.MessageSend";
    private static final String BLOCK_SCOPE = "org.eclipse.jdt.internal.compiler.lookup.BlockScope";
    private static final String METHOD_BINDING = "org.eclipse.jdt.internal.compiler.lookup.MethodBinding";
    private static final String PROBLEM_REPORTER = "org.eclipse.jdt.internal.compiler.problem.ProblemReporter";

    public static TypeBinding resolveType(Object resolvedType, Object methodCall, Object scope) {
        try {
            return (TypeBinding) PatchExtensionMethodPortal$Reflection.resolveType.invoke(null, resolvedType, methodCall, scope);
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
            return (TypeBinding) resolvedType;
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(PatchExtensionMethodPortal$Reflection.problem);
                throw e2;
            }
            return (TypeBinding) resolvedType;
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3);
        }
    }

    public static void errorNoMethodFor(Object problemReporter, Object messageSend, Object recType, Object params) {
        try {
            PatchExtensionMethodPortal$Reflection.errorNoMethodFor.invoke(null, problemReporter, messageSend, recType, params);
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(PatchExtensionMethodPortal$Reflection.problem);
                throw e2;
            }
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }

    public static void invalidMethod(Object problemReporter, Object messageSend, Object method) {
        try {
            PatchExtensionMethodPortal$Reflection.invalidMethod.invoke(null, problemReporter, messageSend, method);
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(PatchExtensionMethodPortal$Reflection.problem);
                throw e2;
            }
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }
}
