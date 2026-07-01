package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.util.Name;
import lombok.javac.JavacNode;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleDelegate$DelegateReceiver.SCL.lombok */
public abstract class HandleDelegate$DelegateReceiver {
    public static final HandleDelegate$DelegateReceiver METHOD = new HandleDelegate$DelegateReceiver$1("METHOD", 0);
    public static final HandleDelegate$DelegateReceiver FIELD = new HandleDelegate$DelegateReceiver$2("FIELD", 1);
    private static final /* synthetic */ HandleDelegate$DelegateReceiver[] ENUM$VALUES = {METHOD, FIELD};

    public abstract JCTree$JCExpression get(JavacNode javacNode, Name name);

    public static HandleDelegate$DelegateReceiver[] values() {
        HandleDelegate$DelegateReceiver[] handleDelegate$DelegateReceiverArr = ENUM$VALUES;
        int length = handleDelegate$DelegateReceiverArr.length;
        HandleDelegate$DelegateReceiver[] handleDelegate$DelegateReceiverArr2 = new HandleDelegate$DelegateReceiver[length];
        System.arraycopy(handleDelegate$DelegateReceiverArr, 0, handleDelegate$DelegateReceiverArr2, 0, length);
        return handleDelegate$DelegateReceiverArr2;
    }

    public static HandleDelegate$DelegateReceiver valueOf(String str) {
        return (HandleDelegate$DelegateReceiver) Enum.valueOf(HandleDelegate$DelegateReceiver.class, str);
    }

    private HandleDelegate$DelegateReceiver(String str, int i) {
        super(str, i);
    }

    /* synthetic */ HandleDelegate$DelegateReceiver(String str, int i, HandleDelegate$DelegateReceiver handleDelegate$DelegateReceiver) {
        this(str, i);
    }
}
