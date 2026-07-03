package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import androidx.legacy.content.WakefulBroadcastReceiver;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p330i.p332b.BinderC4257z4;
import p007b.p225i.p226a.p288f.p330i.p332b.C4097k9;
import p007b.p225i.p226a.p288f.p330i.p332b.C4151p8;
import p007b.p225i.p226a.p288f.p330i.p332b.C4157q3;
import p007b.p225i.p226a.p288f.p330i.p332b.C4202u4;
import p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4195t8;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4206u8;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class AppMeasurementService extends Service implements InterfaceC4195t8 {

    /* JADX INFO: renamed from: j */
    public C4151p8<AppMeasurementService> f20658j;

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4195t8
    /* JADX INFO: renamed from: a */
    public final void mo5868a(JobParameters jobParameters, boolean z2) {
        throw new UnsupportedOperationException();
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4195t8
    /* JADX INFO: renamed from: b */
    public final void mo5869b(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    /* JADX INFO: renamed from: c */
    public final C4151p8<AppMeasurementService> m9110c() {
        if (this.f20658j == null) {
            this.f20658j = new C4151p8<>(this);
        }
        return this.f20658j;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4195t8
    /* JADX INFO: renamed from: f */
    public final boolean mo5870f(int i) {
        return stopSelfResult(i);
    }

    @Override // android.app.Service
    @MainThread
    public final IBinder onBind(Intent intent) {
        C4151p8<AppMeasurementService> c4151p8M9110c = m9110c();
        Objects.requireNonNull(c4151p8M9110c);
        if (intent == null) {
            c4151p8M9110c.m5786b().f11141f.m5860a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new BinderC4257z4(C4097k9.m5698b(c4151p8M9110c.f11131a));
        }
        c4151p8M9110c.m5786b().f11144i.m5861b("onBind received unknown action", action);
        return null;
    }

    @Override // android.app.Service
    @MainThread
    public final void onCreate() {
        super.onCreate();
        C4202u4.m5933b(m9110c().f11131a, null, null).mo5726g().f11149n.m5860a("Local AppMeasurementService is starting up");
    }

    @Override // android.app.Service
    @MainThread
    public final void onDestroy() {
        C4202u4.m5933b(m9110c().f11131a, null, null).mo5726g().f11149n.m5860a("Local AppMeasurementService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    @MainThread
    public final void onRebind(Intent intent) {
        m9110c().m5787c(intent);
    }

    @Override // android.app.Service
    @MainThread
    public final int onStartCommand(final Intent intent, int i, final int i2) {
        final C4151p8<AppMeasurementService> c4151p8M9110c = m9110c();
        final C4157q3 c4157q3Mo5726g = C4202u4.m5933b(c4151p8M9110c.f11131a, null, null).mo5726g();
        if (intent == null) {
            c4157q3Mo5726g.f11144i.m5860a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        c4157q3Mo5726g.f11149n.m5862c("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            return 2;
        }
        Runnable runnable = new Runnable(c4151p8M9110c, i2, c4157q3Mo5726g, intent) { // from class: b.i.a.f.i.b.s8

            /* JADX INFO: renamed from: j */
            public final C4151p8 f11211j;

            /* JADX INFO: renamed from: k */
            public final int f11212k;

            /* JADX INFO: renamed from: l */
            public final C4157q3 f11213l;

            /* JADX INFO: renamed from: m */
            public final Intent f11214m;

            {
                this.f11211j = c4151p8M9110c;
                this.f11212k = i2;
                this.f11213l = c4157q3Mo5726g;
                this.f11214m = intent;
            }

            @Override // java.lang.Runnable
            public final void run() {
                C4151p8 c4151p8 = this.f11211j;
                int i3 = this.f11212k;
                C4157q3 c4157q3 = this.f11213l;
                Intent intent2 = this.f11214m;
                if (c4151p8.f11131a.mo5870f(i3)) {
                    c4157q3.f11149n.m5861b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i3));
                    c4151p8.m5786b().f11149n.m5860a("Completed wakeful intent.");
                    c4151p8.f11131a.mo5869b(intent2);
                }
            }
        };
        C4097k9 c4097k9M5698b = C4097k9.m5698b(c4151p8M9110c.f11131a);
        c4097k9M5698b.mo5725f().m5852v(new RunnableC4206u8(c4097k9M5698b, runnable));
        return 2;
    }

    @Override // android.app.Service
    @MainThread
    public final boolean onUnbind(Intent intent) {
        m9110c().m5785a(intent);
        return true;
    }
}
