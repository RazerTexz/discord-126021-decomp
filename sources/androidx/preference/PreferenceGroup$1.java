package androidx.preference;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceGroup$1 implements Runnable {
    public final /* synthetic */ PreferenceGroup this$0;

    public PreferenceGroup$1(PreferenceGroup preferenceGroup) {
        this.this$0 = preferenceGroup;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.this$0.mIdRecycleCache.clear();
        }
    }
}
