package androidx.core.telephony;

import android.annotation.SuppressLint;
import android.telephony.TelephonyManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public class TelephonyManagerCompat$Api23Impl {
    private TelephonyManagerCompat$Api23Impl() {
    }

    @SuppressLint({"MissingPermission"})
    @Nullable
    @RequiresPermission("android.permission.READ_PHONE_STATE")
    @DoNotInline
    public static String getDeviceId(TelephonyManager telephonyManager, int i) {
        return telephonyManager.getDeviceId(i);
    }
}
