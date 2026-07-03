package p007b.p225i.p226a.p288f.p313h.p323j;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p291b.C3175a;
import p007b.p225i.p226a.p288f.p291b.C3180f;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;

/* JADX INFO: renamed from: b.i.a.f.h.j.u */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC3544u implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C3538r f9803j;

    public RunnableC3544u(C3538r c3538r) {
        this.f9803j = c3538r;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zM4515a;
        C3538r c3538r = this.f9803j;
        c3538r.m4444N();
        C3180f.m3967b();
        Context context = c3538r.f9684j.f9722b;
        if (!C3541s0.m4499a(context)) {
            c3538r.m4428D("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!C3543t0.m4500c(context)) {
            c3538r.m4429H("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        Boolean bool = C3175a.f9192a;
        Boolean bool2 = C3175a.f9192a;
        if (bool2 != null) {
            zM4515a = bool2.booleanValue();
        } else {
            zM4515a = C3555z0.m4515a(context, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
            C3175a.f9192a = Boolean.valueOf(zM4515a);
        }
        if (!zM4515a) {
            c3538r.m4428D("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        C3535p0 c3535p0M4438u = c3538r.m4438u();
        Objects.requireNonNull(c3535p0M4438u);
        C3180f.m3967b();
        c3535p0M4438u.m4444N();
        if (c3535p0M4438u.f9778m == 0) {
            long j = c3535p0M4438u.f9777l.getLong("first_run", 0L);
            if (j != 0) {
                c3535p0M4438u.f9778m = j;
            } else {
                Objects.requireNonNull((C3401c) c3535p0M4438u.f9684j.f9724d);
                long jCurrentTimeMillis = System.currentTimeMillis();
                SharedPreferences.Editor editorEdit = c3535p0M4438u.f9777l.edit();
                editorEdit.putLong("first_run", jCurrentTimeMillis);
                if (!editorEdit.commit()) {
                    c3535p0M4438u.m4428D("Failed to commit first run time");
                }
                c3535p0M4438u.f9778m = jCurrentTimeMillis;
            }
        }
        if (!c3538r.m4495b0("android.permission.ACCESS_NETWORK_STATE")) {
            c3538r.m4429H("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            c3538r.m4444N();
            C3180f.m3967b();
            c3538r.f9792v = true;
            c3538r.f9786p.m4457O();
            c3538r.m4491U();
        }
        if (!c3538r.m4495b0("android.permission.INTERNET")) {
            c3538r.m4429H("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            c3538r.m4444N();
            C3180f.m3967b();
            c3538r.f9792v = true;
            c3538r.f9786p.m4457O();
            c3538r.m4491U();
        }
        if (C3543t0.m4500c(c3538r.f9684j.f9722b)) {
            c3538r.m4427C("AnalyticsService registered in the app manifest and enabled");
        } else {
            c3538r.m4428D("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!c3538r.f9792v && !c3538r.f9783m.m4469R()) {
            c3538r.m4489S();
        }
        c3538r.m4491U();
    }
}
