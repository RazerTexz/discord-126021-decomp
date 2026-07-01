package lombok.eclipse.agent;

import lombok.eclipse.Eclipse;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchDelegate$DelegateReceiver$2.SCL.lombok */
enum PatchDelegate$DelegateReceiver$2 extends PatchDelegate$DelegateReceiver {
    PatchDelegate$DelegateReceiver$2(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.eclipse.agent.PatchDelegate$DelegateReceiver
    public Expression get(ASTNode source, char[] name) {
        FieldReference fieldRef = new FieldReference(name, Eclipse.pos(source));
        EclipseHandlerUtil.setGeneratedBy(fieldRef, source);
        fieldRef.receiver = new ThisReference(source.sourceStart, source.sourceEnd);
        EclipseHandlerUtil.setGeneratedBy(fieldRef.receiver, source);
        return fieldRef;
    }
}
