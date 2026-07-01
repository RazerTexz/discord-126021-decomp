package androidx.appcompat.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDelegateImpl$AutoNightModeManager$1 extends BroadcastReceiver {
    public final /* synthetic */ AppCompatDelegateImpl$AutoNightModeManager this$1;

    public AppCompatDelegateImpl$AutoNightModeManager$1(AppCompatDelegateImpl$AutoNightModeManager appCompatDelegateImpl$AutoNightModeManager) {
        this.this$1 = appCompatDelegateImpl$AutoNightModeManager;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.this$1.onChange();
    }
}
