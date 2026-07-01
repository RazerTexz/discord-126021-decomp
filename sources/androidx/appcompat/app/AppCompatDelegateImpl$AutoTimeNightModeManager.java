package androidx.appcompat.app;

import android.content.IntentFilter;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDelegateImpl$AutoTimeNightModeManager extends AppCompatDelegateImpl$AutoNightModeManager {
    private final TwilightManager mTwilightManager;
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatDelegateImpl$AutoTimeNightModeManager(@NonNull AppCompatDelegateImpl appCompatDelegateImpl, TwilightManager twilightManager) {
        super(appCompatDelegateImpl);
        this.this$0 = appCompatDelegateImpl;
        this.mTwilightManager = twilightManager;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
    public IntentFilter createIntentFilterForBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_TICK");
        return intentFilter;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
    public int getApplyableNightMode() {
        return this.mTwilightManager.isNight() ? 2 : 1;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
    public void onChange() {
        this.this$0.applyDayNight();
    }
}
