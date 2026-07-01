package lombok.eclipse.agent;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchDelegatePortal$Reflection.SCL.lombok */
final class PatchDelegatePortal$Reflection {
    public static final Method handleDelegateForType;
    public static final Method getChildren;
    public static final Throwable problem;

    private PatchDelegatePortal$Reflection() {
    }

    static {
        Method m = null;
        Method n = null;
        Throwable problem_ = null;
        try {
            m = PatchDelegate.class.getMethod("handleDelegateForType", Class.forName("org.eclipse.jdt.internal.compiler.lookup.ClassScope"));
            n = PatchDelegate.class.getMethod("getChildren", Class.forName("[Lorg.eclipse.jdt.core.IJavaElement;"), Class.forName("org.eclipse.jdt.internal.core.SourceTypeElementInfo"));
        } catch (Throwable t) {
            problem_ = t;
        }
        handleDelegateForType = m;
        getChildren = n;
        problem = problem_;
    }
}
