package androidx.preference;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceFragmentCompat$1 extends Handler {
    public final /* synthetic */ PreferenceFragmentCompat this$0;

    public PreferenceFragmentCompat$1(PreferenceFragmentCompat preferenceFragmentCompat) {
        this.this$0 = preferenceFragmentCompat;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 1) {
            return;
        }
        this.this$0.bindPreferences();
    }
}
