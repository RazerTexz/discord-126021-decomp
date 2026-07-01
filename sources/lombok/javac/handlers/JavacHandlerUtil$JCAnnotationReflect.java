package lombok.javac.handlers;

import com.sun.tools.javac.code.Attribute$Compound;
import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import java.lang.reflect.Field;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacHandlerUtil$JCAnnotationReflect.SCL.lombok */
class JavacHandlerUtil$JCAnnotationReflect {
    private static Field ATTRIBUTE;

    JavacHandlerUtil$JCAnnotationReflect() {
    }

    static {
        try {
            ATTRIBUTE = Permit.getField(JCTree$JCAnnotation.class, "attribute");
        } catch (Exception unused) {
        }
    }

    static Attribute$Compound getAttribute(JCTree$JCAnnotation jcAnnotation) {
        try {
            return (Attribute$Compound) ATTRIBUTE.get(jcAnnotation);
        } catch (Exception unused) {
            return null;
        }
    }
}
