package com.discord.utilities.system;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager$WifiLock;
import android.os.PowerManager;
import android.os.PowerManager$WakeLock;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: SystemServiceExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemServiceExtensionsKt {
    private static final String TAG = "discord:com.discord.utils";

    public static final PowerManager$WakeLock createPartialWakeLock(Context context, boolean z2, String str) {
        m.checkNotNullParameter(context, "$this$createPartialWakeLock");
        m.checkNotNullParameter(str, "tag");
        return createWakeLock$default(context, 1, null, z2, str, 2, null);
    }

    public static /* synthetic */ PowerManager$WakeLock createPartialWakeLock$default(Context context, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            str = TAG;
        }
        return createPartialWakeLock(context, z2, str);
    }

    public static final PowerManager$WakeLock createProximityScreenWakeLock(Context context, boolean z2, String str) {
        m.checkNotNullParameter(context, "$this$createProximityScreenWakeLock");
        m.checkNotNullParameter(str, "tag");
        return createWakeLock$default(context, 32, null, z2, str, 2, null);
    }

    public static /* synthetic */ PowerManager$WakeLock createProximityScreenWakeLock$default(Context context, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            str = TAG;
        }
        return createProximityScreenWakeLock(context, z2, str);
    }

    private static final PowerManager$WakeLock createWakeLock(Context context, int i, Integer num, boolean z2, String str) {
        Object systemService = context.getSystemService("power");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager powerManager = (PowerManager) systemService;
        if (!powerManager.isWakeLockLevelSupported(i)) {
            return null;
        }
        if (num != null) {
            i |= num.intValue();
        }
        PowerManager$WakeLock powerManager$WakeLockNewWakeLock = powerManager.newWakeLock(i, str);
        powerManager$WakeLockNewWakeLock.setReferenceCounted(z2);
        return powerManager$WakeLockNewWakeLock;
    }

    public static /* synthetic */ PowerManager$WakeLock createWakeLock$default(Context context, int i, Integer num, boolean z2, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 8) != 0) {
            str = TAG;
        }
        return createWakeLock(context, i, num, z2, str);
    }

    public static final WifiManager$WifiLock createWifiLock(Context context, boolean z2, int i, String str) {
        m.checkNotNullParameter(context, "$this$createWifiLock");
        m.checkNotNullParameter(str, "tag");
        Object systemService = context.getApplicationContext().getSystemService("wifi");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        WifiManager$WifiLock wifiManager$WifiLockCreateWifiLock = ((WifiManager) systemService).createWifiLock(i, str);
        wifiManager$WifiLockCreateWifiLock.setReferenceCounted(z2);
        m.checkNotNullExpressionValue(wifiManager$WifiLockCreateWifiLock, "(applicationContext.getS…unted(referenceCounted)\n}");
        return wifiManager$WifiLockCreateWifiLock;
    }

    public static /* synthetic */ WifiManager$WifiLock createWifiLock$default(Context context, boolean z2, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        if ((i2 & 2) != 0) {
            i = 3;
        }
        if ((i2 & 4) != 0) {
            str = TAG;
        }
        return createWifiLock(context, z2, i, str);
    }
}
