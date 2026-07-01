package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver$PendingResult;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.utils.PackageManagerHelper;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintProxyUpdateReceiver$1 implements Runnable {
    public final /* synthetic */ ConstraintProxyUpdateReceiver this$0;
    public final /* synthetic */ Context val$context;
    public final /* synthetic */ Intent val$intent;
    public final /* synthetic */ BroadcastReceiver$PendingResult val$pendingResult;

    public ConstraintProxyUpdateReceiver$1(ConstraintProxyUpdateReceiver constraintProxyUpdateReceiver, Intent intent, Context context, BroadcastReceiver$PendingResult broadcastReceiver$PendingResult) {
        this.this$0 = constraintProxyUpdateReceiver;
        this.val$intent = intent;
        this.val$context = context;
        this.val$pendingResult = broadcastReceiver$PendingResult;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            boolean booleanExtra = this.val$intent.getBooleanExtra(ConstraintProxyUpdateReceiver.KEY_BATTERY_NOT_LOW_PROXY_ENABLED, false);
            boolean booleanExtra2 = this.val$intent.getBooleanExtra(ConstraintProxyUpdateReceiver.KEY_BATTERY_CHARGING_PROXY_ENABLED, false);
            boolean booleanExtra3 = this.val$intent.getBooleanExtra(ConstraintProxyUpdateReceiver.KEY_STORAGE_NOT_LOW_PROXY_ENABLED, false);
            boolean booleanExtra4 = this.val$intent.getBooleanExtra(ConstraintProxyUpdateReceiver.KEY_NETWORK_STATE_PROXY_ENABLED, false);
            Logger.get().debug(ConstraintProxyUpdateReceiver.TAG, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)), new Throwable[0]);
            PackageManagerHelper.setComponentEnabled(this.val$context, ConstraintProxy$BatteryNotLowProxy.class, booleanExtra);
            PackageManagerHelper.setComponentEnabled(this.val$context, ConstraintProxy$BatteryChargingProxy.class, booleanExtra2);
            PackageManagerHelper.setComponentEnabled(this.val$context, ConstraintProxy$StorageNotLowProxy.class, booleanExtra3);
            PackageManagerHelper.setComponentEnabled(this.val$context, ConstraintProxy$NetworkStateProxy.class, booleanExtra4);
        } finally {
            this.val$pendingResult.finish();
        }
    }
}
