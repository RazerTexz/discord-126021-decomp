package androidx.core.provider;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes.dex */
public class CallbackWithHandler$1 implements Runnable {
    public final /* synthetic */ CallbackWithHandler this$0;
    public final /* synthetic */ FontsContractCompat$FontRequestCallback val$callback;
    public final /* synthetic */ Typeface val$typeface;

    public CallbackWithHandler$1(CallbackWithHandler callbackWithHandler, FontsContractCompat$FontRequestCallback fontsContractCompat$FontRequestCallback, Typeface typeface) {
        this.this$0 = callbackWithHandler;
        this.val$callback = fontsContractCompat$FontRequestCallback;
        this.val$typeface = typeface;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$callback.onTypefaceRetrieved(this.val$typeface);
    }
}
