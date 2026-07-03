package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.RequiresPermission;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p313h.p323j.C3515g;
import p007b.p225i.p226a.p288f.p313h.p323j.C3529m0;
import p007b.p225i.p226a.p288f.p313h.p323j.C3543t0;
import p007b.p225i.p226a.p288f.p313h.p323j.InterfaceC3551x0;

/* JADX INFO: loaded from: classes3.dex */
@TargetApi(24)
public final class AnalyticsJobService extends JobService implements InterfaceC3551x0 {

    /* JADX INFO: renamed from: j */
    public C3543t0<AnalyticsJobService> f20386j;

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.InterfaceC3551x0
    @TargetApi(24)
    /* JADX INFO: renamed from: a */
    public final void mo4503a(JobParameters jobParameters, boolean z2) {
        jobFinished(jobParameters, false);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.InterfaceC3551x0
    /* JADX INFO: renamed from: b */
    public final boolean mo4504b(int i) {
        return stopSelfResult(i);
    }

    /* JADX INFO: renamed from: c */
    public final C3543t0<AnalyticsJobService> m9007c() {
        if (this.f20386j == null) {
            this.f20386j = new C3543t0<>(this);
        }
        return this.f20386j;
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onCreate() {
        super.onCreate();
        C3515g.m4450b(m9007c().f9802c).m4451c().m4427C("Local AnalyticsService is starting up");
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onDestroy() {
        C3515g.m4450b(m9007c().f9802c).m4451c().m4427C("Local AnalyticsService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final int onStartCommand(Intent intent, int i, int i2) {
        m9007c().m4501a(intent, i2);
        return 2;
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(final JobParameters jobParameters) {
        final C3543t0<AnalyticsJobService> c3543t0M9007c = m9007c();
        final C3529m0 c3529m0M4451c = C3515g.m4450b(c3543t0M9007c.f9802c).m4451c();
        String string = jobParameters.getExtras().getString("action");
        c3529m0M4451c.m4431b("Local AnalyticsJobService called. action", string);
        if (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(string)) {
            return true;
        }
        c3543t0M9007c.m4502b(new Runnable(c3543t0M9007c, c3529m0M4451c, jobParameters) { // from class: b.i.a.f.h.j.v0

            /* JADX INFO: renamed from: j */
            public final C3543t0 f9808j;

            /* JADX INFO: renamed from: k */
            public final C3529m0 f9809k;

            /* JADX INFO: renamed from: l */
            public final JobParameters f9810l;

            {
                this.f9808j = c3543t0M9007c;
                this.f9809k = c3529m0M4451c;
                this.f9810l = jobParameters;
            }

            @Override // java.lang.Runnable
            public final void run() {
                C3543t0 c3543t0 = this.f9808j;
                C3529m0 c3529m0 = this.f9809k;
                JobParameters jobParameters2 = this.f9810l;
                Objects.requireNonNull(c3543t0);
                c3529m0.m4427C("AnalyticsJobService processed last dispatch request");
                c3543t0.f9802c.mo4503a(jobParameters2, false);
            }
        });
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
