package lombok.eclipse;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import lombok.permit.Permit;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/EclipseAST$EcjReflectionCheck.SCL.lombok */
class EclipseAST$EcjReflectionCheck {
    private static final String COMPILATIONRESULT_TYPE = "org.eclipse.jdt.internal.compiler.CompilationResult";
    public static final Method addProblemToCompilationResult;
    public static final Throwable problemAddProblemToCompilationResult;
    public static final Method typeReferenceGetAnnotationsOnDimensions;
    public static final Field typeReferenceAnnotations;

    private EclipseAST$EcjReflectionCheck() {
    }

    static {
        Method m2;
        Field f;
        Throwable problem_ = null;
        Method m1 = null;
        try {
            m1 = Permit.getMethod(EclipseAstProblemView.class, "addProblemToCompilationResult", char[].class, Class.forName(COMPILATIONRESULT_TYPE), Boolean.TYPE, String.class, Integer.TYPE, Integer.TYPE);
        } catch (Throwable t) {
            problem_ = t;
        }
        try {
            m2 = Permit.getMethod(TypeReference.class, "getAnnotationsOnDimensions", new Class[0]);
        } catch (Throwable unused) {
            m2 = null;
        }
        try {
            f = Permit.getField(TypeReference.class, "annotations");
        } catch (Throwable unused2) {
            f = null;
        }
        addProblemToCompilationResult = m1;
        problemAddProblemToCompilationResult = problem_;
        typeReferenceGetAnnotationsOnDimensions = m2;
        typeReferenceAnnotations = f;
    }
}
