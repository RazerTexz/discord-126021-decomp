package lombok.launch;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: app.apk:Class50/lombok/launch/PatchFixesHider$Util.SCL.lombok */
public final class PatchFixesHider$Util {
    private static ClassLoader shadowLoader;

    public static Class<?> shadowLoadClass(String name) {
        try {
            if (shadowLoader == null) {
                try {
                    Class.forName("lombok.core.LombokNode");
                    shadowLoader = PatchFixesHider$Util.class.getClassLoader();
                } catch (ClassNotFoundException unused) {
                    shadowLoader = Main.getShadowClassLoader();
                }
            }
            return Class.forName(name, true, shadowLoader);
        } catch (ClassNotFoundException e) {
            throw sneakyThrow(e);
        }
    }

    public static Method findMethod(Class<?> type, String name, Class<?>... clsArr) {
        try {
            return type.getDeclaredMethod(name, clsArr);
        } catch (NoSuchMethodException e) {
            throw sneakyThrow(e);
        }
    }

    public static Object invokeMethod(Method method, Object... args) {
        try {
            return method.invoke(null, args);
        } catch (IllegalAccessException e) {
            throw sneakyThrow(e);
        } catch (InvocationTargetException e2) {
            throw sneakyThrow(e2.getCause());
        }
    }

    private static RuntimeException sneakyThrow(Throwable t) throws Throwable {
        if (t == null) {
            throw new NullPointerException("t");
        }
        sneakyThrow0(t);
        return null;
    }

    private static <T extends Throwable> void sneakyThrow0(Throwable t) throws Throwable {
        throw t;
    }
}
