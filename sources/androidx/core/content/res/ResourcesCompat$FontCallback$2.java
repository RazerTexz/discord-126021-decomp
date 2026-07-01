package androidx.core.content.res;

/* JADX INFO: loaded from: classes.dex */
public class ResourcesCompat$FontCallback$2 implements Runnable {
    public final /* synthetic */ ResourcesCompat$FontCallback this$0;
    public final /* synthetic */ int val$reason;

    public ResourcesCompat$FontCallback$2(ResourcesCompat$FontCallback resourcesCompat$FontCallback, int i) {
        this.this$0 = resourcesCompat$FontCallback;
        this.val$reason = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.onFontRetrievalFailed(this.val$reason);
    }
}
