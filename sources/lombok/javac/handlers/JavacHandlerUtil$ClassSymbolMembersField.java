package lombok.javac.handlers;

import com.sun.tools.javac.code.Scope;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Symbol$ClassSymbol;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacHandlerUtil$ClassSymbolMembersField.SCL.lombok */
class JavacHandlerUtil$ClassSymbolMembersField {
    private static final Field membersField;
    private static final Method removeMethod;
    private static final Method enterMethod;

    JavacHandlerUtil$ClassSymbolMembersField() {
    }

    static {
        Field f = null;
        Method r = null;
        Method e = null;
        try {
            f = Permit.getField(Symbol$ClassSymbol.class, "members_field");
            r = Permit.getMethod(f.getType(), "remove", Symbol.class);
            e = Permit.getMethod(f.getType(), "enter", Symbol.class);
        } catch (Exception unused) {
        }
        membersField = f;
        removeMethod = r;
        enterMethod = e;
    }

    static void remove(Symbol$ClassSymbol from, Symbol toRemove) {
        if (from == null) {
            return;
        }
        try {
            Scope scope = (Scope) membersField.get(from);
            if (scope == null) {
                return;
            }
            removeMethod.invoke(scope, toRemove);
        } catch (Exception unused) {
        }
    }

    static void enter(Symbol$ClassSymbol from, Symbol toEnter) {
        if (from == null) {
            return;
        }
        try {
            Scope scope = (Scope) membersField.get(from);
            if (scope == null) {
                return;
            }
            enterMethod.invoke(scope, toEnter);
        } catch (Exception unused) {
        }
    }
}
