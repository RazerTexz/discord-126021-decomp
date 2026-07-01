package lombok.eclipse.handlers;

import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EclipseNode;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseHandlerUtil$CopyJavadoc$2.SCL.lombok */
enum EclipseHandlerUtil$CopyJavadoc$2 extends EclipseHandlerUtil$CopyJavadoc {
    EclipseHandlerUtil$CopyJavadoc$2(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.eclipse.handlers.EclipseHandlerUtil$CopyJavadoc
    public String apply(CompilationUnitDeclaration cu, EclipseNode node) {
        ASTNode n = node.get();
        String javadoc = EclipseHandlerUtil.getDocComment(cu, n);
        String out = HandlerUtil.getJavadocSection(javadoc, "GETTER");
        boolean sectionBased = out != null;
        if (!sectionBased) {
            out = HandlerUtil.stripLinesWithTagFromJavadoc(HandlerUtil.stripSectionsFromJavadoc(javadoc), "@param(?:eter)?\\s+.*");
        }
        return out;
    }
}
