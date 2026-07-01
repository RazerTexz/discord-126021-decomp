package androidx.preference;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceGroupAdapter$1 implements Runnable {
    public final /* synthetic */ PreferenceGroupAdapter this$0;

    public PreferenceGroupAdapter$1(PreferenceGroupAdapter preferenceGroupAdapter) {
        this.this$0 = preferenceGroupAdapter;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.updatePreferences();
    }
}
