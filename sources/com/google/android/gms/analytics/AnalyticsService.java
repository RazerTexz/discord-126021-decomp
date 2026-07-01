package com.google.android.gms.analytics;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.RequiresPermission;
import b.i.a.f.h.j.g;
import b.i.a.f.h.j.t0;
import b.i.a.f.h.j.x0;

/* JADX INFO: loaded from: classes3.dex */
public final class AnalyticsService extends Service implements x0 {
    public t0<AnalyticsService> j;

    @Override // b.i.a.f.h.j.x0
    public final void a(JobParameters jobParameters, boolean z2) {
        throw new UnsupportedOperationException();
    }

    @Override // b.i.a.f.h.j.x0
    public final boolean b(int i) {
        return stopSelfResult(i);
    }

    public final t0<AnalyticsService> c() {
        if (this.j == null) {
            this.j = new t0<>(this);
        }
        return this.j;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        c();
        return null;
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onCreate() {
        super.onCreate();
        g.b(c().c).c().C("Local AnalyticsService is starting up");
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onDestroy() {
        g.b(c().c).c().C("Local AnalyticsService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final int onStartCommand(Intent intent, int i, int i2) {
        c().a(intent, i2);
        return 2;
    }
}
