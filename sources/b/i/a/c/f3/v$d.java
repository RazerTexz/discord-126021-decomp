package b.i.a.c.f3;

import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyDisplayInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: NetworkTypeObserver.java */
/* JADX INFO: loaded from: classes3.dex */
public class v$d extends PhoneStateListener {
    public final /* synthetic */ v a;

    public v$d(v vVar, v$a v_a) {
        this.a = vVar;
    }

    @Override // android.telephony.PhoneStateListener
    @RequiresApi(31)
    public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
        v.a(this.a, overrideNetworkType == 3 || overrideNetworkType == 4 ? 10 : 5);
    }

    @Override // android.telephony.PhoneStateListener
    public void onServiceStateChanged(@Nullable ServiceState serviceState) {
        String string = serviceState == null ? "" : serviceState.toString();
        v.a(this.a, string.contains("nrState=CONNECTED") || string.contains("nrState=NOT_RESTRICTED") ? 10 : 5);
    }
}
