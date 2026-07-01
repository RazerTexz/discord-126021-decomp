package androidx.core.provider;

import android.os.Handler;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class SelfDestructiveThread$2 implements Runnable {
    public final /* synthetic */ SelfDestructiveThread this$0;
    public final /* synthetic */ Callable val$callable;
    public final /* synthetic */ Handler val$calleeHandler;
    public final /* synthetic */ SelfDestructiveThread$ReplyCallback val$reply;

    public SelfDestructiveThread$2(SelfDestructiveThread selfDestructiveThread, Callable callable, Handler handler, SelfDestructiveThread$ReplyCallback selfDestructiveThread$ReplyCallback) {
        this.this$0 = selfDestructiveThread;
        this.val$callable = callable;
        this.val$calleeHandler = handler;
        this.val$reply = selfDestructiveThread$ReplyCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object objCall;
        try {
            objCall = this.val$callable.call();
        } catch (Exception unused) {
            objCall = null;
        }
        this.val$calleeHandler.post(new SelfDestructiveThread$2$1(this, objCall));
    }
}
