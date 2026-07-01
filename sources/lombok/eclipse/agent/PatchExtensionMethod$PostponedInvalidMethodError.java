package lombok.eclipse.agent;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchExtensionMethod$PostponedInvalidMethodError.SCL.lombok */
class PatchExtensionMethod$PostponedInvalidMethodError implements PatchExtensionMethod$PostponedError {
    private final ProblemReporter problemReporter;
    private final WeakReference<MessageSend> messageSendRef;
    private final MethodBinding method;
    private final Scope scope;
    private static final Method shortMethod = getMethod("invalidMethod", MessageSend.class, MethodBinding.class);
    private static final Method longMethod = getMethod("invalidMethod", MessageSend.class, MethodBinding.class, Scope.class);

    private static Method getMethod(String name, Class<?>... clsArr) {
        try {
            Method m = ProblemReporter.class.getMethod(name, clsArr);
            m.setAccessible(true);
            return m;
        } catch (Exception unused) {
            return null;
        }
    }

    PatchExtensionMethod$PostponedInvalidMethodError(ProblemReporter problemReporter, MessageSend messageSend, MethodBinding method, Scope scope) {
        this.problemReporter = problemReporter;
        this.messageSendRef = new WeakReference<>(messageSend);
        this.method = method;
        this.scope = scope;
    }

    static void invoke(ProblemReporter problemReporter, MessageSend messageSend, MethodBinding method, Scope scope) {
        if (messageSend != null) {
            try {
                if (shortMethod != null) {
                    shortMethod.invoke(problemReporter, messageSend, method);
                } else if (longMethod != null) {
                    longMethod.invoke(problemReporter, messageSend, method, scope);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                Throwable t = e2.getCause();
                if (t instanceof Error) {
                    throw ((Error) t);
                }
                if (!(t instanceof RuntimeException)) {
                    throw new RuntimeException(t);
                }
                throw ((RuntimeException) t);
            }
        }
    }

    @Override // lombok.eclipse.agent.PatchExtensionMethod$PostponedError
    public void fire() {
        MessageSend messageSend = this.messageSendRef.get();
        invoke(this.problemReporter, messageSend, this.method, this.scope);
    }
}
