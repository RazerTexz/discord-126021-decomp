package lombok.eclipse.agent;

import java.lang.reflect.Method;
import java.util.Map;
import lombok.eclipse.EcjAugments;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import lombok.permit.Permit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jdt.internal.core.SourceMethod;
import org.eclipse.jdt.internal.ui.text.javadoc.JavadocContentAccess2;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchJavadoc.SCL.lombok */
public class PatchJavadoc {
    public static String getHTMLContentFromSource(String original, IJavaElement member) {
        if (original != null) {
            return original;
        }
        if (member instanceof SourceMethod) {
            SourceMethod sourceMethod = (SourceMethod) member;
            CompilationUnit compilationUnit = sourceMethod.getCompilationUnit();
            if (compilationUnit instanceof CompilationUnit) {
                CompilationUnit compilationUnit2 = compilationUnit;
                Map<String, String> docs = EcjAugments.EclipseAugments.CompilationUnit_javadoc.get(compilationUnit2);
                if (docs == null) {
                    return null;
                }
                String signature = getSignature(sourceMethod);
                String rawJavadoc = docs.get(signature);
                if (rawJavadoc == null) {
                    return null;
                }
                return Reflection.javadoc2HTML((IMember) member, member, rawJavadoc);
            }
            return null;
        }
        return null;
    }

    public static StringBuffer printMethod(AbstractMethodDeclaration methodDeclaration, Integer tab, StringBuffer output, TypeDeclaration type) {
        Map<String, String> docs;
        if ((methodDeclaration.compilationResult.compilationUnit instanceof CompilationUnit) && (docs = EcjAugments.EclipseAugments.CompilationUnit_javadoc.get((CompilationUnit) methodDeclaration.compilationResult.compilationUnit)) != null) {
            String signature = EclipseHandlerUtil.getSignature(type, methodDeclaration);
            String rawJavadoc = docs.get(signature);
            if (rawJavadoc != null) {
                for (String line : rawJavadoc.split("\r?\n")) {
                    ASTNode.printIndent(tab.intValue(), output).append(line).append("\n");
                }
            }
        }
        return methodDeclaration.print(tab.intValue(), output);
    }

    private static String getSignature(SourceMethod sourceMethod) {
        StringBuilder sb = new StringBuilder();
        sb.append(sourceMethod.getParent().getElementName());
        sb.append(".");
        sb.append(sourceMethod.getElementName());
        sb.append("(");
        for (String type : sourceMethod.getParameterTypes()) {
            sb.append(type);
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchJavadoc$Reflection.SCL.lombok */
    private static class Reflection {
        private static final Method javadoc2HTML;
        private static final Method oldJavadoc2HTML;

        private Reflection() {
        }

        static {
            Method a = null;
            Method b2 = null;
            try {
                a = Permit.getMethod(JavadocContentAccess2.class, "javadoc2HTML", IMember.class, IJavaElement.class, String.class);
            } catch (Throwable unused) {
            }
            try {
                b2 = Permit.getMethod(JavadocContentAccess2.class, "javadoc2HTML", IMember.class, String.class);
            } catch (Throwable unused2) {
            }
            javadoc2HTML = a;
            oldJavadoc2HTML = b2;
        }

        private static String javadoc2HTML(IMember member, IJavaElement element, String rawJavadoc) {
            if (javadoc2HTML != null) {
                try {
                    return (String) javadoc2HTML.invoke(null, member, element, rawJavadoc);
                } catch (Throwable unused) {
                    return null;
                }
            }
            if (oldJavadoc2HTML != null) {
                try {
                    return (String) oldJavadoc2HTML.invoke(null, member, rawJavadoc);
                } catch (Throwable unused2) {
                    return null;
                }
            }
            return null;
        }
    }
}
