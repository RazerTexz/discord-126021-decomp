package androidx.preference;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceFragment$1 extends Handler {
    public final /* synthetic */ PreferenceFragment this$0;

    public PreferenceFragment$1(PreferenceFragment preferenceFragment) {
        this.this$0 = preferenceFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 1) {
            return;
        }
        this.this$0.bindPreferences();
    }
}
