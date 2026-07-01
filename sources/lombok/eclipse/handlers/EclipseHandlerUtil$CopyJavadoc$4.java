package lombok.eclipse.handlers;

import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EclipseNode;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseHandlerUtil$CopyJavadoc$4.SCL.lombok */
enum EclipseHandlerUtil$CopyJavadoc$4 extends EclipseHandlerUtil$CopyJavadoc {
    EclipseHandlerUtil$CopyJavadoc$4(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.eclipse.handlers.EclipseHandlerUtil$CopyJavadoc
    public String apply(CompilationUnitDeclaration cu, EclipseNode node) {
        return HandlerUtil.addReturnsUpdatedSelfIfNeeded(EclipseHandlerUtil$CopyJavadoc.access$3(cu, node, "WITH|WITHER"));
    }
}
