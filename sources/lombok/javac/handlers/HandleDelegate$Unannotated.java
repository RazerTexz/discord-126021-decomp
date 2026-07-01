package lombok.javac.handlers;

import com.sun.tools.javac.code.Type;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleDelegate$Unannotated.SCL.lombok */
class HandleDelegate$Unannotated {
    private static final Method unannotated;

    private HandleDelegate$Unannotated() {
    }

    static {
        Method m = null;
        try {
            m = Type.class.getDeclaredMethod("unannotatedType", new Class[0]);
        } catch (Exception unused) {
        }
        unannotated = m;
    }

    static Type unannotatedType(Type t) {
        if (unannotated == null) {
            return t;
        }
        try {
            return (Type) unannotated.invoke(t, new Object[0]);
        } catch (Exception unused) {
            return t;
        }
    }
}
