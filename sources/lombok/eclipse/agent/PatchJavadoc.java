package lombok.eclipse.agent;

import java.util.Map;
import lombok.eclipse.EcjAugments$EclipseAugments;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jdt.internal.core.SourceMethod;

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
                Map<String, String> docs = EcjAugments$EclipseAugments.CompilationUnit_javadoc.get(compilationUnit2);
                if (docs == null) {
                    return null;
                }
                String signature = getSignature(sourceMethod);
                String rawJavadoc = docs.get(signature);
                if (rawJavadoc == null) {
                    return null;
                }
                return PatchJavadoc$Reflection.access$0((IMember) member, member, rawJavadoc);
            }
            return null;
        }
        return null;
    }

    public static StringBuffer printMethod(AbstractMethodDeclaration methodDeclaration, Integer tab, StringBuffer output, TypeDeclaration type) {
        Map<String, String> docs;
        if ((methodDeclaration.compilationResult.compilationUnit instanceof CompilationUnit) && (docs = EcjAugments$EclipseAugments.CompilationUnit_javadoc.get((CompilationUnit) methodDeclaration.compilationResult.compilationUnit)) != null) {
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
}
