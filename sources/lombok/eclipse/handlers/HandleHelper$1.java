package lombok.eclipse.handlers;

import java.util.Arrays;
import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleHelper$1.SCL.lombok */
class HandleHelper$1 extends ASTVisitor {
    final /* synthetic */ HandleHelper this$0;
    private final /* synthetic */ String[] val$knownMethodNames_;
    private final /* synthetic */ char[] val$helperName;
    private final /* synthetic */ boolean[] val$helperUsed;

    HandleHelper$1(HandleHelper handleHelper, String[] strArr, char[] cArr, boolean[] zArr) {
        this.this$0 = handleHelper;
        this.val$knownMethodNames_ = strArr;
        this.val$helperName = cArr;
        this.val$helperUsed = zArr;
    }

    public boolean visit(MessageSend messageSend, BlockScope scope) {
        if (messageSend.receiver instanceof ThisReference) {
            if ((messageSend.receiver.bits & 4) == 0) {
                return true;
            }
        } else if (messageSend.receiver != null) {
            return true;
        }
        char[] name = messageSend.selector;
        if (name == null || name.length == 0 || name[0] == '<') {
            return true;
        }
        String n = new String(name);
        if (Arrays.binarySearch(this.val$knownMethodNames_, n) < 0) {
            return true;
        }
        messageSend.receiver = new SingleNameReference(this.val$helperName, messageSend.nameSourcePosition);
        this.val$helperUsed[0] = true;
        return true;
    }
}
