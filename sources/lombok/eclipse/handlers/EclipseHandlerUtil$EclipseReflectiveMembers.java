package lombok.eclipse.handlers;

import java.lang.reflect.Field;
import lombok.permit.Permit;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.StringLiteral;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseHandlerUtil$EclipseReflectiveMembers.SCL.lombok */
class EclipseHandlerUtil$EclipseReflectiveMembers {
    public static final Field STRING_LITERAL__LINE_NUMBER = getField(StringLiteral.class, "lineNumber");
    public static final Field ANNOTATION__MEMBER_VALUE_PAIR_NAME = getField(Annotation.class, "memberValuePairName");
    public static final Field TYPE_REFERENCE__ANNOTATIONS = getField(TypeReference.class, "annotations");
    public static final Class<?> INTERSECTION_BINDING1 = getClass("org.eclipse.jdt.internal.compiler.lookup.IntersectionTypeBinding18");
    public static final Class<?> INTERSECTION_BINDING2 = getClass("org.eclipse.jdt.internal.compiler.lookup.IntersectionCastTypeBinding");
    public static final Field INTERSECTION_BINDING_TYPES1;
    public static final Field INTERSECTION_BINDING_TYPES2;

    EclipseHandlerUtil$EclipseReflectiveMembers() {
    }

    static {
        INTERSECTION_BINDING_TYPES1 = INTERSECTION_BINDING1 == null ? null : getField(INTERSECTION_BINDING1, "intersectingTypes");
        INTERSECTION_BINDING_TYPES2 = INTERSECTION_BINDING2 == null ? null : getField(INTERSECTION_BINDING2, "intersectingTypes");
    }

    public static int reflectInt(Field f, Object o) {
        try {
            return ((Number) f.get(o)).intValue();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void reflectSet(Field f, Object o, Object v) {
        try {
            f.set(o, v);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object reflect(Field f, Object o) {
        try {
            return f.get(o);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static Class<?> getClass(String fqn) {
        try {
            return Class.forName(fqn);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Field getField(Class<?> c, String fName) {
        try {
            return Permit.getField(c, fName);
        } catch (Exception unused) {
            return null;
        }
    }
}
