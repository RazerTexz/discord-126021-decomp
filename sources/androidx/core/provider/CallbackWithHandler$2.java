package androidx.core.provider;

/* JADX INFO: loaded from: classes.dex */
public class CallbackWithHandler$2 implements Runnable {
    public final /* synthetic */ CallbackWithHandler this$0;
    public final /* synthetic */ FontsContractCompat$FontRequestCallback val$callback;
    public final /* synthetic */ int val$reason;

    public CallbackWithHandler$2(CallbackWithHandler callbackWithHandler, FontsContractCompat$FontRequestCallback fontsContractCompat$FontRequestCallback, int i) {
        this.this$0 = callbackWithHandler;
        this.val$callback = fontsContractCompat$FontRequestCallback;
        this.val$reason = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$callback.onTypefaceRequestFailed(this.val$reason);
    }
}
