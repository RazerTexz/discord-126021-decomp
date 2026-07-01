package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.RequiresPermission;
import b.i.a.f.h.j.g;
import b.i.a.f.h.j.m0;
import b.i.a.f.h.j.t0;
import b.i.a.f.h.j.v0;
import b.i.a.f.h.j.x0;

/* JADX INFO: loaded from: classes3.dex */
@TargetApi(24)
public final class AnalyticsJobService extends JobService implements x0 {
    public t0<AnalyticsJobService> j;

    @Override // b.i.a.f.h.j.x0
    @TargetApi(24)
    public final void a(JobParameters jobParameters, boolean z2) {
        jobFinished(jobParameters, false);
    }

    @Override // b.i.a.f.h.j.x0
    public final boolean b(int i) {
        return stopSelfResult(i);
    }

    public final t0<AnalyticsJobService> c() {
        if (this.j == null) {
            this.j = new t0<>(this);
        }
        return this.j;
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

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        t0<AnalyticsJobService> t0VarC = c();
        m0 m0VarC = g.b(t0VarC.c).c();
        String string = jobParameters.getExtras().getString("action");
        m0VarC.b("Local AnalyticsJobService called. action", string);
        if (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(string)) {
            return true;
        }
        t0VarC.b(new v0(t0VarC, m0VarC, jobParameters));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
