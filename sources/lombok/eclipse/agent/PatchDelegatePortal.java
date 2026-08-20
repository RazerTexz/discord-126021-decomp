package lombok.eclipse.agent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lombok.Lombok;

/* JADX INFO: loaded from: discord-126021.apk:lombok/eclipse/agent/PatchDelegatePortal.SCL.lombok */
public class PatchDelegatePortal {
    static final String CLASS_SCOPE = "org.eclipse.jdt.internal.compiler.lookup.ClassScope";
    static final String I_JAVA_ELEMENT_ARRAY = "[Lorg.eclipse.jdt.core.IJavaElement;";
    static final String SOURCE_TYPE_ELEMENT_INFO = "org.eclipse.jdt.internal.core.SourceTypeElementInfo";

    public static boolean handleDelegateForType(Object classScope) {
        try {
            return ((Boolean) Reflection.handleDelegateForType.invoke(null, classScope)).booleanValue();
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
            return false;
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(Reflection.problem);
                throw e2;
            }
            return false;
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }

    public static Object[] getChildren(Object returnValue, Object javaElement) {
        try {
            return (Object[]) Reflection.getChildren.invoke(null, returnValue, javaElement);
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
            return (Object[]) returnValue;
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(Reflection.problem);
                throw e2;
            }
            return (Object[]) returnValue;
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }

    /* JADX INFO: loaded from: discord-126021.apk:lombok/eclipse/agent/PatchDelegatePortal$Reflection.SCL.lombok */
    private static final class Reflection {
        public static final Method handleDelegateForType;
        public static final Method getChildren;
        public static final Throwable problem;

        private Reflection() {
        }

        static {
            Method m = null;
            Method n = null;
            Throwable problem_ = null;
            try {
                m = PatchDelegate.class.getMethod("handleDelegateForType", Class.forName(PatchDelegatePortal.CLASS_SCOPE));
                n = PatchDelegate.class.getMethod("getChildren", Class.forName(PatchDelegatePortal.I_JAVA_ELEMENT_ARRAY), Class.forName(PatchDelegatePortal.SOURCE_TYPE_ELEMENT_INFO));
            } catch (Throwable t) {
                problem_ = t;
            }
            handleDelegateForType = m;
            getChildren = n;
            problem = problem_;
        }
    }
}
