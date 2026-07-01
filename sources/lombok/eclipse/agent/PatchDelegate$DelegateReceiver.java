package lombok.eclipse.agent;

import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.Expression;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchDelegate$DelegateReceiver.SCL.lombok */
abstract class PatchDelegate$DelegateReceiver {
    public static final PatchDelegate$DelegateReceiver METHOD = new PatchDelegate$DelegateReceiver$1("METHOD", 0);
    public static final PatchDelegate$DelegateReceiver FIELD = new PatchDelegate$DelegateReceiver$2("FIELD", 1);
    private static final /* synthetic */ PatchDelegate$DelegateReceiver[] ENUM$VALUES = {METHOD, FIELD};

    public abstract Expression get(ASTNode aSTNode, char[] cArr);

    public static PatchDelegate$DelegateReceiver[] values() {
        PatchDelegate$DelegateReceiver[] patchDelegate$DelegateReceiverArr = ENUM$VALUES;
        int length = patchDelegate$DelegateReceiverArr.length;
        PatchDelegate$DelegateReceiver[] patchDelegate$DelegateReceiverArr2 = new PatchDelegate$DelegateReceiver[length];
        System.arraycopy(patchDelegate$DelegateReceiverArr, 0, patchDelegate$DelegateReceiverArr2, 0, length);
        return patchDelegate$DelegateReceiverArr2;
    }

    public static PatchDelegate$DelegateReceiver valueOf(String str) {
        return (PatchDelegate$DelegateReceiver) Enum.valueOf(PatchDelegate$DelegateReceiver.class, str);
    }

    private PatchDelegate$DelegateReceiver(String str, int i) {
        super(str, i);
    }

    /* synthetic */ PatchDelegate$DelegateReceiver(String str, int i, PatchDelegate$DelegateReceiver patchDelegate$DelegateReceiver) {
        this(str, i);
    }
}
