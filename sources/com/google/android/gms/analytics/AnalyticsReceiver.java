package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RequiresPermission;
import b.i.a.f.h.j.g;
import b.i.a.f.h.j.m0;
import b.i.a.f.h.j.s0;
import b.i.a.f.h.j.t0;
import b.i.a.f.m.a;

/* JADX INFO: loaded from: classes3.dex */
public final class AnalyticsReceiver extends BroadcastReceiver {
    public s0 a;

    @Override // android.content.BroadcastReceiver
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onReceive(Context context, Intent intent) {
        if (this.a == null) {
            this.a = new s0();
        }
        Object obj = s0.a;
        m0 m0VarC = g.b(context).c();
        if (intent == null) {
            m0VarC.D("AnalyticsReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        m0VarC.b("Local AnalyticsReceiver got", action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean zC = t0.c(context);
            Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent2.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (s0.a) {
                context.startService(intent2);
                if (zC) {
                    try {
                        if (s0.f1426b == null) {
                            a aVar = new a(context, 1, "Analytics WakeLock");
                            s0.f1426b = aVar;
                            aVar.c.setReferenceCounted(false);
                            aVar.h = false;
                        }
                        s0.f1426b.a(1000L);
                    } catch (SecurityException unused) {
                        m0VarC.D("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                }
            }
        }
    }
}
