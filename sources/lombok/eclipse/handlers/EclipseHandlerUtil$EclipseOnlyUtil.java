package lombok.eclipse.handlers;

import java.util.HashMap;
import java.util.Map;
import lombok.eclipse.EcjAugments$EclipseAugments;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.core.CompilationUnit;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseHandlerUtil$EclipseOnlyUtil.SCL.lombok */
class EclipseHandlerUtil$EclipseOnlyUtil {
    private EclipseHandlerUtil$EclipseOnlyUtil() {
    }

    public static void setDocComment(CompilationUnitDeclaration cud, TypeDeclaration type, ASTNode node, String doc) {
        if (cud.compilationResult.compilationUnit instanceof CompilationUnit) {
            CompilationUnit compilationUnit = cud.compilationResult.compilationUnit;
            Map<String, String> docs = EcjAugments$EclipseAugments.CompilationUnit_javadoc.setIfAbsent(compilationUnit, new HashMap());
            if (node instanceof AbstractMethodDeclaration) {
                AbstractMethodDeclaration methodDeclaration = (AbstractMethodDeclaration) node;
                String signature = EclipseHandlerUtil.getSignature(type, methodDeclaration);
                docs.put(signature, String.format("/**%n%s%n */", doc.replaceAll("(?m)^", " * ")));
            }
        }
    }
}
