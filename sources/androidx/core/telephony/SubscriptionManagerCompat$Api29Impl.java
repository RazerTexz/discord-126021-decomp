package androidx.core.telephony;

import android.telephony.SubscriptionManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
public class SubscriptionManagerCompat$Api29Impl {
    private SubscriptionManagerCompat$Api29Impl() {
    }

    @DoNotInline
    public static int getSlotIndex(int i) {
        return SubscriptionManager.getSlotIndex(i);
    }
}
