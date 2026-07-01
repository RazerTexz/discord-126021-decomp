package lombok.eclipse.handlers;

import lombok.eclipse.EclipseNode;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseHandlerUtil$CopyJavadoc$3.SCL.lombok */
enum EclipseHandlerUtil$CopyJavadoc$3 extends EclipseHandlerUtil$CopyJavadoc {
    EclipseHandlerUtil$CopyJavadoc$3(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.eclipse.handlers.EclipseHandlerUtil$CopyJavadoc
    public String apply(CompilationUnitDeclaration cu, EclipseNode node) {
        return EclipseHandlerUtil$CopyJavadoc.access$3(cu, node, "SETTER");
    }
}
