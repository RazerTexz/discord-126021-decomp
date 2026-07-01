package androidx.appcompat.app;

import android.content.Context;
import android.content.IntentFilter;
import android.os.PowerManager;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDelegateImpl$AutoBatteryNightModeManager extends AppCompatDelegateImpl$AutoNightModeManager {
    private final PowerManager mPowerManager;
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatDelegateImpl$AutoBatteryNightModeManager(@NonNull AppCompatDelegateImpl appCompatDelegateImpl, Context context) {
        super(appCompatDelegateImpl);
        this.this$0 = appCompatDelegateImpl;
        this.mPowerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
    public IntentFilter createIntentFilterForBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
        return intentFilter;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
    public int getApplyableNightMode() {
        return this.mPowerManager.isPowerSaveMode() ? 2 : 1;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
    public void onChange() {
        this.this$0.applyDayNight();
    }
}
