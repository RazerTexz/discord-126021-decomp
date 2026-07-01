package lombok.eclipse.agent;

import java.lang.reflect.Method;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchDelegate$Reflection.SCL.lombok */
final class PatchDelegate$Reflection {
    public static final Method classScopeBuildFieldsAndMethodsMethod;

    private PatchDelegate$Reflection() {
    }

    static {
        Method m = null;
        try {
            m = ClassScope.class.getDeclaredMethod("buildFieldsAndMethods", new Class[0]);
            m.setAccessible(true);
        } catch (Throwable unused) {
        }
        classScopeBuildFieldsAndMethodsMethod = m;
    }
}
