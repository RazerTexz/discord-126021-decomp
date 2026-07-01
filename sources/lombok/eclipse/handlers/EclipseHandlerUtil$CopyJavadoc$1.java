package lombok.eclipse.handlers;

import lombok.eclipse.EclipseNode;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseHandlerUtil$CopyJavadoc$1.SCL.lombok */
enum EclipseHandlerUtil$CopyJavadoc$1 extends EclipseHandlerUtil$CopyJavadoc {
    EclipseHandlerUtil$CopyJavadoc$1(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.eclipse.handlers.EclipseHandlerUtil$CopyJavadoc
    public String apply(CompilationUnitDeclaration cu, EclipseNode node) {
        return EclipseHandlerUtil.getDocComment(cu, node.get());
    }
}
