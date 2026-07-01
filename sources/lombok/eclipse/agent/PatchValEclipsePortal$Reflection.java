package lombok.eclipse.agent;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchValEclipsePortal$Reflection.SCL.lombok */
final class PatchValEclipsePortal$Reflection {
    public static final Method copyInitializationOfForEachIterable;
    public static final Method copyInitializationOfLocalDeclaration;
    public static final Method addFinalAndValAnnotationToVariableDeclarationStatement;
    public static final Method addFinalAndValAnnotationToSingleVariableDeclaration;
    public static final Throwable problem;

    private PatchValEclipsePortal$Reflection() {
    }

    static {
        Method m = null;
        Method n = null;
        Method o = null;
        Method p = null;
        Throwable problem_ = null;
        try {
            m = PatchValEclipse.class.getMethod("copyInitializationOfForEachIterable", Class.forName("org.eclipse.jdt.internal.compiler.parser.Parser"));
            n = PatchValEclipse.class.getMethod("copyInitializationOfLocalDeclaration", Class.forName("org.eclipse.jdt.internal.compiler.parser.Parser"));
            o = PatchValEclipse.class.getMethod("addFinalAndValAnnotationToVariableDeclarationStatement", Object.class, Class.forName("org.eclipse.jdt.core.dom.VariableDeclarationStatement"), Class.forName("org.eclipse.jdt.internal.compiler.ast.LocalDeclaration"));
            p = PatchValEclipse.class.getMethod("addFinalAndValAnnotationToSingleVariableDeclaration", Object.class, Class.forName("org.eclipse.jdt.core.dom.SingleVariableDeclaration"), Class.forName("org.eclipse.jdt.internal.compiler.ast.LocalDeclaration"));
        } catch (Throwable t) {
            problem_ = t;
        }
        copyInitializationOfForEachIterable = m;
        copyInitializationOfLocalDeclaration = n;
        addFinalAndValAnnotationToVariableDeclarationStatement = o;
        addFinalAndValAnnotationToSingleVariableDeclaration = p;
        problem = problem_;
    }
}
