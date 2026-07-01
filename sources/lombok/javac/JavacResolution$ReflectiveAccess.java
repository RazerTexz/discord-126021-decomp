package lombok.javac;

import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.code.Types;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lombok.Lombok;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacResolution$ReflectiveAccess.SCL.lombok */
class JavacResolution$ReflectiveAccess {
    private static Method UPPER_BOUND;

    private JavacResolution$ReflectiveAccess() {
    }

    static {
        Method upperBound = null;
        try {
            upperBound = Permit.getMethod(Types.class, "upperBound", Type.class);
        } catch (Throwable unused) {
        }
        if (upperBound == null) {
            try {
                upperBound = Permit.getMethod(Types.class, "wildUpperBound", Type.class);
            } catch (Throwable unused2) {
            }
        }
        UPPER_BOUND = upperBound;
    }

    public static Type Types_upperBound(Types types, Type type) {
        try {
            return (Type) UPPER_BOUND.invoke(types, type);
        } catch (InvocationTargetException e) {
            throw Lombok.sneakyThrow(e.getCause());
        } catch (Exception e2) {
            throw Lombok.sneakyThrow(e2);
        }
    }
}
