package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import java.util.HashMap;
import java.util.WeakHashMap;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WakeLocks {
    private static final String TAG = Logger.tagWithPrefix("WakeLocks");
    private static final WeakHashMap<PowerManager.WakeLock, String> sWakeLocks = new WeakHashMap<>();

    private WakeLocks() {
    }

    public static void checkWakeLocks() {
        HashMap map = new HashMap();
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = sWakeLocks;
        synchronized (weakHashMap) {
            map.putAll(weakHashMap);
        }
        for (PowerManager.WakeLock wakeLock : map.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                Logger.get().warning(TAG, String.format("WakeLock held for %s", map.get(wakeLock)), new Throwable[0]);
            }
        }
    }

    public static PowerManager.WakeLock newWakeLock(@NonNull Context context, @NonNull String str) {
        PowerManager powerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
        String strM883w = C1643a.m883w("WorkManager: ", str);
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, strM883w);
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = sWakeLocks;
        synchronized (weakHashMap) {
            weakHashMap.put(wakeLockNewWakeLock, strM883w);
        }
        return wakeLockNewWakeLock;
    }
}
