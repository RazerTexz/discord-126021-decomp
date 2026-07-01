package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import androidx.legacy.content.WakefulBroadcastReceiver;
import b.i.a.f.i.b.k9;
import b.i.a.f.i.b.p8;
import b.i.a.f.i.b.q3;
import b.i.a.f.i.b.s8;
import b.i.a.f.i.b.t8;
import b.i.a.f.i.b.u4;
import b.i.a.f.i.b.u8;
import b.i.a.f.i.b.z4;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class AppMeasurementService extends Service implements t8 {
    public p8<AppMeasurementService> j;

    @Override // b.i.a.f.i.b.t8
    public final void a(JobParameters jobParameters, boolean z2) {
        throw new UnsupportedOperationException();
    }

    @Override // b.i.a.f.i.b.t8
    public final void b(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    public final p8<AppMeasurementService> c() {
        if (this.j == null) {
            this.j = new p8<>(this);
        }
        return this.j;
    }

    @Override // b.i.a.f.i.b.t8
    public final boolean f(int i) {
        return stopSelfResult(i);
    }

    @Override // android.app.Service
    @MainThread
    public final IBinder onBind(Intent intent) {
        p8<AppMeasurementService> p8VarC = c();
        Objects.requireNonNull(p8VarC);
        if (intent == null) {
            p8VarC.b().f.a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new z4(k9.b(p8VarC.a));
        }
        p8VarC.b().i.b("onBind received unknown action", action);
        return null;
    }

    @Override // android.app.Service
    @MainThread
    public final void onCreate() {
        super.onCreate();
        u4.b(c().a, null, null).g().n.a("Local AppMeasurementService is starting up");
    }

    @Override // android.app.Service
    @MainThread
    public final void onDestroy() {
        u4.b(c().a, null, null).g().n.a("Local AppMeasurementService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    @MainThread
    public final void onRebind(Intent intent) {
        c().c(intent);
    }

    @Override // android.app.Service
    @MainThread
    public final int onStartCommand(Intent intent, int i, int i2) {
        p8<AppMeasurementService> p8VarC = c();
        q3 q3VarG = u4.b(p8VarC.a, null, null).g();
        if (intent == null) {
            q3VarG.i.a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        q3VarG.n.c("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            return 2;
        }
        s8 s8Var = new s8(p8VarC, i2, q3VarG, intent);
        k9 k9VarB = k9.b(p8VarC.a);
        k9VarB.f().v(new u8(k9VarB, s8Var));
        return 2;
    }

    @Override // android.app.Service
    @MainThread
    public final boolean onUnbind(Intent intent) {
        c().a(intent);
        return true;
    }
}
