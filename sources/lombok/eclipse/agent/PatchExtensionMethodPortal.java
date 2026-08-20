package lombok.eclipse.agent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lombok.Lombok;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;

/* JADX INFO: loaded from: discord-126021.apk:lombok/eclipse/agent/PatchExtensionMethodPortal.SCL.lombok */
public class PatchExtensionMethodPortal {
    private static final String TYPE_BINDING = "org.eclipse.jdt.internal.compiler.lookup.TypeBinding";
    private static final String TYPE_BINDING_ARRAY = "[Lorg.eclipse.jdt.internal.compiler.lookup.TypeBinding;";
    private static final String MESSAGE_SEND = "org.eclipse.jdt.internal.compiler.ast.MessageSend";
    private static final String BLOCK_SCOPE = "org.eclipse.jdt.internal.compiler.lookup.BlockScope";
    private static final String METHOD_BINDING = "org.eclipse.jdt.internal.compiler.lookup.MethodBinding";
    private static final String PROBLEM_REPORTER = "org.eclipse.jdt.internal.compiler.problem.ProblemReporter";

    public static TypeBinding resolveType(Object resolvedType, Object methodCall, Object scope) {
        try {
            return (TypeBinding) Reflection.resolveType.invoke(null, resolvedType, methodCall, scope);
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
            return (TypeBinding) resolvedType;
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(Reflection.problem);
                throw e2;
            }
            return (TypeBinding) resolvedType;
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3);
        }
    }

    public static void errorNoMethodFor(Object problemReporter, Object messageSend, Object recType, Object params) {
        try {
            Reflection.errorNoMethodFor.invoke(null, problemReporter, messageSend, recType, params);
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(Reflection.problem);
                throw e2;
            }
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }

    public static void invalidMethod(Object problemReporter, Object messageSend, Object method) {
        try {
            Reflection.invalidMethod.invoke(null, problemReporter, messageSend, method);
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(Reflection.problem);
                throw e2;
            }
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }

    /* JADX INFO: loaded from: discord-126021.apk:lombok/eclipse/agent/PatchExtensionMethodPortal$Reflection.SCL.lombok */
    private static final class Reflection {
        public static final Method resolveType;
        public static final Method errorNoMethodFor;
        public static final Method invalidMethod;
        public static final Throwable problem;

        private Reflection() {
        }

        static {
            Method m = null;
            Method n = null;
            Method o = null;
            Throwable problem_ = null;
            try {
                m = PatchExtensionMethod.class.getMethod("resolveType", Class.forName(PatchExtensionMethodPortal.TYPE_BINDING), Class.forName(PatchExtensionMethodPortal.MESSAGE_SEND), Class.forName(PatchExtensionMethodPortal.BLOCK_SCOPE));
                n = PatchExtensionMethod.class.getMethod("errorNoMethodFor", Class.forName(PatchExtensionMethodPortal.PROBLEM_REPORTER), Class.forName(PatchExtensionMethodPortal.MESSAGE_SEND), Class.forName(PatchExtensionMethodPortal.TYPE_BINDING), Class.forName(PatchExtensionMethodPortal.TYPE_BINDING_ARRAY));
                o = PatchExtensionMethod.class.getMethod("invalidMethod", Class.forName(PatchExtensionMethodPortal.PROBLEM_REPORTER), Class.forName(PatchExtensionMethodPortal.MESSAGE_SEND), Class.forName(PatchExtensionMethodPortal.METHOD_BINDING));
            } catch (Throwable t) {
                problem_ = t;
            }
            resolveType = m;
            errorNoMethodFor = n;
            invalidMethod = o;
            problem = problem_;
        }
    }
}
