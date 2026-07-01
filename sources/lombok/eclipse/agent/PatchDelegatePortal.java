package lombok.eclipse.agent;

import java.lang.reflect.InvocationTargetException;
import lombok.Lombok;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchDelegatePortal.SCL.lombok */
public class PatchDelegatePortal {
    static final String CLASS_SCOPE = "org.eclipse.jdt.internal.compiler.lookup.ClassScope";
    static final String I_JAVA_ELEMENT_ARRAY = "[Lorg.eclipse.jdt.core.IJavaElement;";
    static final String SOURCE_TYPE_ELEMENT_INFO = "org.eclipse.jdt.internal.core.SourceTypeElementInfo";

    public static boolean handleDelegateForType(Object classScope) {
        try {
            return ((Boolean) PatchDelegatePortal$Reflection.handleDelegateForType.invoke(null, classScope)).booleanValue();
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
            return false;
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(PatchDelegatePortal$Reflection.problem);
                throw e2;
            }
            return false;
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }

    public static Object[] getChildren(Object returnValue, Object javaElement) {
        try {
            return (Object[]) PatchDelegatePortal$Reflection.getChildren.invoke(null, returnValue, javaElement);
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
            return (Object[]) returnValue;
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(PatchDelegatePortal$Reflection.problem);
                throw e2;
            }
            return (Object[]) returnValue;
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }
}
