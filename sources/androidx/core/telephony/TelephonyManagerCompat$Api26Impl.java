package androidx.core.telephony;

import android.annotation.SuppressLint;
import android.telephony.TelephonyManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public class TelephonyManagerCompat$Api26Impl {
    private TelephonyManagerCompat$Api26Impl() {
    }

    @SuppressLint({"MissingPermission"})
    @Nullable
    @RequiresPermission("android.permission.READ_PHONE_STATE")
    @DoNotInline
    public static String getImei(TelephonyManager telephonyManager) {
        return telephonyManager.getImei();
    }
}
