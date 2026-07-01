package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager$WakeLock;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.work.Logger;
import b.d.b.a.a;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
public class WakeLocks {
    private static final String TAG = Logger.tagWithPrefix("WakeLocks");
    private static final WeakHashMap<PowerManager$WakeLock, String> sWakeLocks = new WeakHashMap<>();

    private WakeLocks() {
    }

    public static void checkWakeLocks() {
        HashMap map = new HashMap();
        WeakHashMap<PowerManager$WakeLock, String> weakHashMap = sWakeLocks;
        synchronized (weakHashMap) {
            map.putAll(weakHashMap);
        }
        for (PowerManager$WakeLock powerManager$WakeLock : map.keySet()) {
            if (powerManager$WakeLock != null && powerManager$WakeLock.isHeld()) {
                Logger.get().warning(TAG, String.format("WakeLock held for %s", map.get(powerManager$WakeLock)), new Throwable[0]);
            }
        }
    }

    public static PowerManager$WakeLock newWakeLock(@NonNull Context context, @NonNull String str) {
        PowerManager powerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
        String strW = a.w("WorkManager: ", str);
        PowerManager$WakeLock powerManager$WakeLockNewWakeLock = powerManager.newWakeLock(1, strW);
        WeakHashMap<PowerManager$WakeLock, String> weakHashMap = sWakeLocks;
        synchronized (weakHashMap) {
            weakHashMap.put(powerManager$WakeLockNewWakeLock, strW);
        }
        return powerManager$WakeLockNewWakeLock;
    }
}
