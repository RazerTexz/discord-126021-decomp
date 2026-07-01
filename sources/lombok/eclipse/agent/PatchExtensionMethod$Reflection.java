package lombok.eclipse.agent;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import lombok.permit.Permit;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchExtensionMethod$Reflection.SCL.lombok */
final class PatchExtensionMethod$Reflection {
    public static final Field argumentTypes = Permit.permissiveGetField(MessageSend.class, "argumentTypes");
    public static final Field argumentsHaveErrors = Permit.permissiveGetField(MessageSend.class, "argumentsHaveErrors");
    private static final Class<?> functionalExpression;
    private static final Constructor<?> polyTypeBindingConstructor;

    private PatchExtensionMethod$Reflection() {
    }

    static {
        Class<?> a = null;
        Constructor<?> b2 = null;
        try {
            a = Class.forName("org.eclipse.jdt.internal.compiler.ast.FunctionalExpression");
        } catch (Exception unused) {
        }
        try {
            b2 = Permit.getConstructor(Class.forName("org.eclipse.jdt.internal.compiler.lookup.PolyTypeBinding"), Expression.class);
        } catch (Exception unused2) {
        }
        functionalExpression = a;
        polyTypeBindingConstructor = b2;
    }

    public static boolean isFunctionalExpression(Expression expression) {
        if (functionalExpression == null) {
            return false;
        }
        return functionalExpression.isInstance(expression);
    }

    public static TypeBinding getPolyTypeBinding(Expression expression) {
        if (polyTypeBindingConstructor == null) {
            return null;
        }
        try {
            return (TypeBinding) polyTypeBindingConstructor.newInstance(expression);
        } catch (Exception unused) {
            return null;
        }
    }
}
