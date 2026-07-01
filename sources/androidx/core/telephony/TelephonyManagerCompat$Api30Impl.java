package androidx.core.telephony;

import android.telephony.TelephonyManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(30)
public class TelephonyManagerCompat$Api30Impl {
    private TelephonyManagerCompat$Api30Impl() {
    }

    @DoNotInline
    public static int getSubscriptionId(TelephonyManager telephonyManager) {
        return telephonyManager.getSubscriptionId();
    }
}
