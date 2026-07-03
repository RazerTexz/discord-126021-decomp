package com.google.android.gms.analytics;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.RequiresPermission;
import p007b.p225i.p226a.p288f.p313h.p323j.C3515g;
import p007b.p225i.p226a.p288f.p313h.p323j.C3543t0;
import p007b.p225i.p226a.p288f.p313h.p323j.InterfaceC3551x0;

/* JADX INFO: loaded from: classes3.dex */
public final class AnalyticsService extends Service implements InterfaceC3551x0 {

    /* JADX INFO: renamed from: j */
    public C3543t0<AnalyticsService> f20388j;

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.InterfaceC3551x0
    /* JADX INFO: renamed from: a */
    public final void mo4503a(JobParameters jobParameters, boolean z2) {
        throw new UnsupportedOperationException();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.InterfaceC3551x0
    /* JADX INFO: renamed from: b */
    public final boolean mo4504b(int i) {
        return stopSelfResult(i);
    }

    /* JADX INFO: renamed from: c */
    public final C3543t0<AnalyticsService> m9008c() {
        if (this.f20388j == null) {
            this.f20388j = new C3543t0<>(this);
        }
        return this.f20388j;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        m9008c();
        return null;
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onCreate() {
        super.onCreate();
        C3515g.m4450b(m9008c().f9802c).m4451c().m4427C("Local AnalyticsService is starting up");
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onDestroy() {
        C3515g.m4450b(m9008c().f9802c).m4451c().m4427C("Local AnalyticsService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final int onStartCommand(Intent intent, int i, int i2) {
        m9008c().m4501a(intent, i2);
        return 2;
    }
}
