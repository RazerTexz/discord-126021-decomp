package p007b.p225i.p226a.p288f.p313h.p323j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import androidx.annotation.RequiresPermission;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p313h.p323j.InterfaceC3551x0;
import p007b.p225i.p226a.p288f.p339m.C4351a;

/* JADX INFO: renamed from: b.i.a.f.h.j.t0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3543t0<T extends Context & InterfaceC3551x0> {

    /* JADX INFO: renamed from: a */
    public static Boolean f9800a;

    /* JADX INFO: renamed from: b */
    public final Handler f9801b = new HandlerC3511e1();

    /* JADX INFO: renamed from: c */
    public final T f9802c;

    public C3543t0(T t) {
        this.f9802c = t;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m4500c(Context context) {
        Objects.requireNonNull(context, "null reference");
        Boolean bool = f9800a;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z2 = false;
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"), 0);
            if (serviceInfo != null && serviceInfo.enabled) {
                z2 = true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        f9800a = Boolean.valueOf(z2);
        return z2;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    /* JADX INFO: renamed from: a */
    public final int m4501a(Intent intent, final int i) {
        try {
            synchronized (C3541s0.f9796a) {
                C4351a c4351a = C3541s0.f9797b;
                if (c4351a != null && c4351a.f11460c.isHeld()) {
                    c4351a.m6002b();
                }
            }
        } catch (SecurityException unused) {
        }
        final C3529m0 c3529m0M4451c = C3515g.m4450b(this.f9802c).m4451c();
        if (intent == null) {
            c3529m0M4451c.m4428D("AnalyticsService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        c3529m0M4451c.m4430a(2, "Local AnalyticsService called. startId, action", Integer.valueOf(i), action, null);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            m4502b(new Runnable(this, i, c3529m0M4451c) { // from class: b.i.a.f.h.j.u0

                /* JADX INFO: renamed from: j */
                public final C3543t0 f9804j;

                /* JADX INFO: renamed from: k */
                public final int f9805k;

                /* JADX INFO: renamed from: l */
                public final C3529m0 f9806l;

                {
                    this.f9804j = this;
                    this.f9805k = i;
                    this.f9806l = c3529m0M4451c;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    C3543t0 c3543t0 = this.f9804j;
                    int i2 = this.f9805k;
                    C3529m0 c3529m0 = this.f9806l;
                    if (c3543t0.f9802c.mo4504b(i2)) {
                        c3529m0.m4427C("Local AnalyticsService processed last dispatch request");
                    }
                }
            });
        }
        return 2;
    }

    /* JADX INFO: renamed from: b */
    public final void m4502b(Runnable runnable) {
        C3497a c3497aM4453e = C3515g.m4450b(this.f9802c).m4453e();
        C3549w0 c3549w0 = new C3549w0(this, runnable);
        c3497aM4453e.m4444N();
        c3497aM4453e.m4435q().m3968a(new RunnableC3503c(c3497aM4453e, c3549w0));
    }
}
