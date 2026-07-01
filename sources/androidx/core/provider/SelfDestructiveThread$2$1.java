package androidx.core.provider;

/* JADX INFO: loaded from: classes.dex */
public class SelfDestructiveThread$2$1 implements Runnable {
    public final /* synthetic */ SelfDestructiveThread$2 this$1;
    public final /* synthetic */ Object val$result;

    public SelfDestructiveThread$2$1(SelfDestructiveThread$2 selfDestructiveThread$2, Object obj) {
        this.this$1 = selfDestructiveThread$2;
        this.val$result = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.val$reply.onReply(this.val$result);
    }
}
