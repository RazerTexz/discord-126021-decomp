package lombok.eclipse.agent;

import lombok.eclipse.Eclipse;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchDelegate$DelegateReceiver$1.SCL.lombok */
enum PatchDelegate$DelegateReceiver$1 extends PatchDelegate$DelegateReceiver {
    PatchDelegate$DelegateReceiver$1(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.eclipse.agent.PatchDelegate$DelegateReceiver
    public Expression get(ASTNode source, char[] name) {
        MessageSend call = new MessageSend();
        call.sourceStart = source.sourceStart;
        call.sourceEnd = source.sourceEnd;
        call.nameSourcePosition = Eclipse.pos(source);
        EclipseHandlerUtil.setGeneratedBy(call, source);
        call.selector = name;
        call.receiver = new ThisReference(source.sourceStart, source.sourceEnd);
        EclipseHandlerUtil.setGeneratedBy(call.receiver, source);
        return call;
    }
}
