package lombok.eclipse.agent;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchExtensionMethodPortal$Reflection.SCL.lombok */
final class PatchExtensionMethodPortal$Reflection {
    public static final Method resolveType;
    public static final Method errorNoMethodFor;
    public static final Method invalidMethod;
    public static final Throwable problem;

    private PatchExtensionMethodPortal$Reflection() {
    }

    static {
        Method m = null;
        Method n = null;
        Method o = null;
        Throwable problem_ = null;
        try {
            m = PatchExtensionMethod.class.getMethod("resolveType", Class.forName("org.eclipse.jdt.internal.compiler.lookup.TypeBinding"), Class.forName("org.eclipse.jdt.internal.compiler.ast.MessageSend"), Class.forName("org.eclipse.jdt.internal.compiler.lookup.BlockScope"));
            n = PatchExtensionMethod.class.getMethod("errorNoMethodFor", Class.forName("org.eclipse.jdt.internal.compiler.problem.ProblemReporter"), Class.forName("org.eclipse.jdt.internal.compiler.ast.MessageSend"), Class.forName("org.eclipse.jdt.internal.compiler.lookup.TypeBinding"), Class.forName("[Lorg.eclipse.jdt.internal.compiler.lookup.TypeBinding;"));
            o = PatchExtensionMethod.class.getMethod("invalidMethod", Class.forName("org.eclipse.jdt.internal.compiler.problem.ProblemReporter"), Class.forName("org.eclipse.jdt.internal.compiler.ast.MessageSend"), Class.forName("org.eclipse.jdt.internal.compiler.lookup.MethodBinding"));
        } catch (Throwable t) {
            problem_ = t;
        }
        resolveType = m;
        errorNoMethodFor = n;
        invalidMethod = o;
        problem = problem_;
    }
}
