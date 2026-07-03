package p007b.p225i.p361c.p369m.p370d.p373k;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: renamed from: b.i.c.m.d.k.e */
/* JADX INFO: compiled from: BatteryState.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4619e {

    /* JADX INFO: renamed from: a */
    public final Float f12283a;

    /* JADX INFO: renamed from: b */
    public final boolean f12284b;

    public C4619e(Float f, boolean z2) {
        this.f12284b = z2;
        this.f12283a = f;
    }

    /* JADX INFO: renamed from: a */
    public static C4619e m6401a(Context context) {
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
        return new C4619e(fValueOf, z2);
    }

    /* JADX INFO: renamed from: b */
    public int m6402b() {
        Float f;
        if (!this.f12284b || (f = this.f12283a) == null) {
            return 1;
        }
        return ((double) f.floatValue()) < 0.99d ? 2 : 3;
    }
}
