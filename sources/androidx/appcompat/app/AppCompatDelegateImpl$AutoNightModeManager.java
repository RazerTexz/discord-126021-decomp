package androidx.appcompat.app;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY})
@VisibleForTesting
public abstract class AppCompatDelegateImpl$AutoNightModeManager {
    private BroadcastReceiver mReceiver;
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$AutoNightModeManager(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public void cleanup() {
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            try {
                this.this$0.mContext.unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException unused) {
            }
            this.mReceiver = null;
        }
    }

    @Nullable
    public abstract IntentFilter createIntentFilterForBroadcastReceiver();

    public abstract int getApplyableNightMode();

    public boolean isListening() {
        return this.mReceiver != null;
    }

    public abstract void onChange();

    public void setup() {
        cleanup();
        IntentFilter intentFilterCreateIntentFilterForBroadcastReceiver = createIntentFilterForBroadcastReceiver();
        if (intentFilterCreateIntentFilterForBroadcastReceiver == null || intentFilterCreateIntentFilterForBroadcastReceiver.countActions() == 0) {
            return;
        }
        if (this.mReceiver == null) {
            this.mReceiver = new AppCompatDelegateImpl$AutoNightModeManager$1(this);
        }
        this.this$0.mContext.registerReceiver(this.mReceiver, intentFilterCreateIntentFilterForBroadcastReceiver);
    }
}
