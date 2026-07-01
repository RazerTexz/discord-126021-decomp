package b.i.c.m.d.k;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: renamed from: b.i.c.m.d.k.e, reason: use source file name */
/* JADX INFO: compiled from: BatteryState.java */
/* JADX INFO: loaded from: classes3.dex */
public class BatteryState {
    public final Float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1681b;

    public BatteryState(Float f, boolean z2) {
        this.f1681b = z2;
        this.a = f;
    }

    public static BatteryState a(Context context) {
        Float fValueOf = null;
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z2 = false;
        if (intentRegisterReceiver != null) {
            int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
            if (intExtra != -1 && (intExtra == 2 || intExtra == 5)) {
                z2 = true;
            }
            int intExtra2 = intentRegisterReceiver.getIntExtra("level", -1);
            int intExtra3 = intentRegisterReceiver.getIntExtra("scale", -1);
            if (intExtra2 != -1 && intExtra3 != -1) {
                fValueOf = Float.valueOf(intExtra2 / intExtra3);
            }
        }
        return new BatteryState(fValueOf, z2);
    }

    public int b() {
        Float f;
        if (!this.f1681b || (f = this.a) == null) {
            return 1;
        }
        return ((double) f.floatValue()) < 0.99d ? 2 : 3;
    }
}
