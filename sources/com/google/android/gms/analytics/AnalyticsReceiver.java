package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RequiresPermission;
import p007b.p225i.p226a.p288f.p313h.p323j.C3515g;
import p007b.p225i.p226a.p288f.p313h.p323j.C3529m0;
import p007b.p225i.p226a.p288f.p313h.p323j.C3541s0;
import p007b.p225i.p226a.p288f.p313h.p323j.C3543t0;
import p007b.p225i.p226a.p288f.p339m.C4351a;

/* JADX INFO: loaded from: classes3.dex */
public final class AnalyticsReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    public C3541s0 f20387a;

    @Override // android.content.BroadcastReceiver
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onReceive(Context context, Intent intent) {
        if (this.f20387a == null) {
            this.f20387a = new C3541s0();
        }
        Object obj = C3541s0.f9796a;
        C3529m0 c3529m0M4451c = C3515g.m4450b(context).m4451c();
        if (intent == null) {
            c3529m0M4451c.m4428D("AnalyticsReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        c3529m0M4451c.m4431b("Local AnalyticsReceiver got", action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean zM4500c = C3543t0.m4500c(context);
            Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent2.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (C3541s0.f9796a) {
                context.startService(intent2);
                if (zM4500c) {
                    try {
                        if (C3541s0.f9797b == null) {
                            C4351a c4351a = new C4351a(context, 1, "Analytics WakeLock");
                            C3541s0.f9797b = c4351a;
                            c4351a.f11460c.setReferenceCounted(false);
                            c4351a.f11465h = false;
                        }
                        C3541s0.f9797b.m6001a(1000L);
                    } catch (SecurityException unused) {
                        c3529m0M4451c.m4428D("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                }
            }
        }
    }
}
