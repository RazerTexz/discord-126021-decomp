package lombok.permit;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: app.apk:lombok/permit/Permit.SCL.lombok */
public class Permit {
    private static final long ACCESSIBLE_OVERRIDE_FIELD_OFFSET;
    private static final IllegalAccessException INIT_ERROR;
    private static final Unsafe UNSAFE = (Unsafe) reflectiveStaticFieldAccess(Unsafe.class, "theUnsafe");

    private Permit() {
    }

    static {
        long g;
        Throwable ex;
        try {
            g = getOverrideFieldOffset();
            ex = null;
        } catch (Throwable t) {
            g = -1;
            ex = t;
        }
        ACCESSIBLE_OVERRIDE_FIELD_OFFSET = g;
        if (ex != null) {
            if (!(ex instanceof IllegalAccessException)) {
                INIT_ERROR = new IllegalAccessException("Cannot initialize Unsafe-based permit");
                INIT_ERROR.initCause(ex);
                return;
            } else {
                INIT_ERROR = (IllegalAccessException) ex;
                return;
            }
        }
        INIT_ERROR = null;
    }

    public static <T extends AccessibleObject> T setAccessible(T accessor) {
        if (INIT_ERROR == null) {
            UNSAFE.putBoolean(accessor, ACCESSIBLE_OVERRIDE_FIELD_OFFSET, true);
        } else {
            accessor.setAccessible(true);
        }
        return accessor;
    }

    private static long getOverrideFieldOffset() throws Throwable {
        Field f = null;
        Throwable saved = null;
        try {
            f = AccessibleObject.class.getDeclaredField("override");
        } catch (Throwable t) {
            saved = t;
        }
        if (f != null) {
            return UNSAFE.objectFieldOffset(f);
        }
        try {
            return UNSAFE.objectFieldOffset(Permit$Fake.class.getDeclaredField("override"));
        } catch (Throwable unused) {
            throw saved;
        }
    }

    public static Method getMethod(Class<?> c, String mName, Class<?>... clsArr) throws NoSuchMethodException {
        Method m = null;
        while (c != null) {
            try {
                m = c.getDeclaredMethod(mName, clsArr);
                break;
            } catch (NoSuchMethodException unused) {
                c = c.getSuperclass();
            }
        }
        if (m == null) {
            throw new NoSuchMethodException(String.valueOf(c.getName()) + " :: " + mName + "(args)");
        }
        return (Method) setAccessible(m);
    }

    public static Field getField(Class<?> c, String fName) throws NoSuchFieldException {
        Field f = null;
        while (c != null) {
            try {
                f = c.getDeclaredField(fName);
                break;
            } catch (NoSuchFieldException unused) {
                c = c.getSuperclass();
            }
        }
        if (f == null) {
            throw new NoSuchFieldException(String.valueOf(c.getName()) + " :: " + fName);
        }
        return (Field) setAccessible(f);
    }

    public static Field permissiveGetField(Class<?> c, String fName) {
        try {
            return getField(c, fName);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T permissiveReadField(Class<T> type, Field f, Object instance) {
        try {
            return type.cast(f.get(instance));
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> Constructor<T> getConstructor(Class<T> c, Class<?>... clsArr) throws NoSuchMethodException {
        return (Constructor) setAccessible(c.getDeclaredConstructor(clsArr));
    }

    private static Object reflectiveStaticFieldAccess(Class<?> c, String fName) {
        try {
            Field f = c.getDeclaredField(fName);
            f.setAccessible(true);
            return f.get(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
