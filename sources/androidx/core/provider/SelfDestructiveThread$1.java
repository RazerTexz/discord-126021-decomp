package androidx.core.provider;

import android.os.Handler$Callback;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public class SelfDestructiveThread$1 implements Handler$Callback {
    public final /* synthetic */ SelfDestructiveThread this$0;

    public SelfDestructiveThread$1(SelfDestructiveThread selfDestructiveThread) {
        this.this$0 = selfDestructiveThread;
    }

    @Override // android.os.Handler$Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            this.this$0.onDestruction();
            return true;
        }
        if (i != 1) {
            return true;
        }
        this.this$0.onInvokeRunnable((Runnable) message.obj);
        return true;
    }
}
