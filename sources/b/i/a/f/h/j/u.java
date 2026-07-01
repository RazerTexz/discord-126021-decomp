package b.i.a.f.h.j;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements Runnable {
    public final /* synthetic */ r j;

    public u(r rVar) {
        this.j = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zA;
        r rVar = this.j;
        rVar.N();
        b.i.a.f.b.f.b();
        Context context = rVar.j.f1417b;
        if (!s0.a(context)) {
            rVar.D("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!t0.c(context)) {
            rVar.H("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        Boolean bool = b.i.a.f.b.a.a;
        Boolean bool2 = b.i.a.f.b.a.a;
        if (bool2 != null) {
            zA = bool2.booleanValue();
        } else {
            zA = z0.a(context, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
            b.i.a.f.b.a.a = Boolean.valueOf(zA);
        }
        if (!zA) {
            rVar.D("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        p0 p0VarU = rVar.u();
        Objects.requireNonNull(p0VarU);
        b.i.a.f.b.f.b();
        p0VarU.N();
        if (p0VarU.m == 0) {
            long j = p0VarU.l.getLong("first_run", 0L);
            if (j != 0) {
                p0VarU.m = j;
            } else {
                Objects.requireNonNull((b.i.a.f.e.o.c) p0VarU.j.d);
                long jCurrentTimeMillis = System.currentTimeMillis();
                SharedPreferences.Editor editorEdit = p0VarU.l.edit();
                editorEdit.putLong("first_run", jCurrentTimeMillis);
                if (!editorEdit.commit()) {
                    p0VarU.D("Failed to commit first run time");
                }
                p0VarU.m = jCurrentTimeMillis;
            }
        }
        if (!rVar.b0("android.permission.ACCESS_NETWORK_STATE")) {
            rVar.H("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            rVar.N();
            b.i.a.f.b.f.b();
            rVar.v = true;
            rVar.p.O();
            rVar.U();
        }
        if (!rVar.b0("android.permission.INTERNET")) {
            rVar.H("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            rVar.N();
            b.i.a.f.b.f.b();
            rVar.v = true;
            rVar.p.O();
            rVar.U();
        }
        if (t0.c(rVar.j.f1417b)) {
            rVar.C("AnalyticsService registered in the app manifest and enabled");
        } else {
            rVar.D("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!rVar.v && !rVar.m.R()) {
            rVar.S();
        }
        rVar.U();
    }
}
