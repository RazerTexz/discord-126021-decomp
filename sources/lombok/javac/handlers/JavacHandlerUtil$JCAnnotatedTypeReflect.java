package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.util.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacHandlerUtil$JCAnnotatedTypeReflect.SCL.lombok */
class JavacHandlerUtil$JCAnnotatedTypeReflect {
    private static Class<?> TYPE;
    private static Constructor<?> CONSTRUCTOR;
    private static Field ANNOTATIONS;
    private static Field UNDERLYING_TYPE;

    JavacHandlerUtil$JCAnnotatedTypeReflect() {
    }

    private static void initByLoader(ClassLoader classLoader) {
        if (TYPE != null) {
            return;
        }
        try {
            Class<?> c = classLoader.loadClass("com.sun.tools.javac.tree.JCTree$JCAnnotatedType");
            init(c);
        } catch (Exception unused) {
        }
    }

    private static void init(Class<?> in) {
        if (TYPE == null && in.getName().equals("com.sun.tools.javac.tree.JCTree$JCAnnotatedType")) {
            try {
                CONSTRUCTOR = Permit.getConstructor(in, List.class, JCTree$JCExpression.class);
                ANNOTATIONS = Permit.getField(in, "annotations");
                UNDERLYING_TYPE = Permit.getField(in, "underlyingType");
                TYPE = in;
            } catch (Exception unused) {
            }
        }
    }

    static boolean is(JCTree obj) {
        if (obj == null) {
            return false;
        }
        init(obj.getClass());
        return obj.getClass() == TYPE;
    }

    static List<JCTree$JCAnnotation> getAnnotations(JCTree obj) {
        init(obj.getClass());
        try {
            return (List) ANNOTATIONS.get(obj);
        } catch (Exception unused) {
            return List.nil();
        }
    }

    static void setAnnotations(JCTree obj, List<JCTree$JCAnnotation> anns) {
        init(obj.getClass());
        try {
            ANNOTATIONS.set(obj, anns);
        } catch (Exception unused) {
        }
    }

    static JCTree$JCExpression getUnderlyingType(JCTree obj) {
        init(obj.getClass());
        try {
            return (JCTree$JCExpression) UNDERLYING_TYPE.get(obj);
        } catch (Exception unused) {
            return null;
        }
    }

    static JCTree$JCExpression create(List<JCTree$JCAnnotation> annotations, JCTree$JCExpression underlyingType) {
        initByLoader(underlyingType.getClass().getClassLoader());
        try {
            return (JCTree$JCExpression) CONSTRUCTOR.newInstance(annotations, underlyingType);
        } catch (Exception unused) {
            return underlyingType;
        }
    }
}
