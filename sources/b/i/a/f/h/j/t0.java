package b.i.a.f.h.j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import androidx.annotation.RequiresPermission;
import b.i.a.f.h.j.x0;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class t0<T extends Context & x0> {
    public static Boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f1427b = new e1();
    public final T c;

    public t0(T t) {
        this.c = t;
    }

    public static boolean c(Context context) {
        Objects.requireNonNull(context, "null reference");
        Boolean bool = a;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z2 = false;
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"), 0);
            if (serviceInfo != null && serviceInfo.enabled) {
                z2 = true;
            }
        } catch (PackageManager$NameNotFoundException unused) {
        }
        a = Boolean.valueOf(z2);
        return z2;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final int a(Intent intent, int i) {
        try {
            synchronized (s0.a) {
                b.i.a.f.m.a aVar = s0.f1426b;
                if (aVar != null && aVar.c.isHeld()) {
                    aVar.b();
                }
            }
        } catch (SecurityException unused) {
        }
        m0 m0VarC = g.b(this.c).c();
        if (intent == null) {
            m0VarC.D("AnalyticsService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        m0VarC.a(2, "Local AnalyticsService called. startId, action", Integer.valueOf(i), action, null);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            b(new u0(this, i, m0VarC));
        }
        return 2;
    }

    public final void b(Runnable runnable) {
        a aVarE = g.b(this.c).e();
        w0 w0Var = new w0(this, runnable);
        aVarE.N();
        aVarE.q().a(new c(aVarE, w0Var));
    }
}
