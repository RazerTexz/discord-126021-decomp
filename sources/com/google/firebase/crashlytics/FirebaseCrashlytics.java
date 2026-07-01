package com.google.firebase.crashlytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.a.f.e.o.f;
import b.i.a.f.n.c0;
import b.i.c.c;
import b.i.c.m.d.b;
import b.i.c.m.d.k.f1;
import b.i.c.m.d.k.i;
import b.i.c.m.d.k.j;
import b.i.c.m.d.k.k0;
import b.i.c.m.d.k.n;
import b.i.c.m.d.k.o;
import b.i.c.m.d.k.p;
import b.i.c.m.d.k.x;
import com.google.android.gms.tasks.Task;
import java.util.Date;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class FirebaseCrashlytics {
    public final k0 a;

    public FirebaseCrashlytics(@NonNull k0 k0Var) {
        this.a = k0Var;
    }

    @NonNull
    public static FirebaseCrashlytics getInstance() {
        c cVarB = c.b();
        cVarB.a();
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) cVarB.g.a(FirebaseCrashlytics.class);
        Objects.requireNonNull(firebaseCrashlytics, "FirebaseCrashlytics component is not present.");
        return firebaseCrashlytics;
    }

    @NonNull
    public Task<Boolean> checkForUnsentReports() {
        x xVar = this.a.h;
        if (xVar.F.compareAndSet(false, true)) {
            return xVar.C.a;
        }
        b.a.b("checkForUnsentReports should only be called once per execution.");
        return f.Z(Boolean.FALSE);
    }

    public void deleteUnsentReports() {
        x xVar = this.a.h;
        xVar.D.b(Boolean.FALSE);
        c0<Void> c0Var = xVar.E.a;
    }

    public boolean didCrashOnPreviousExecution() {
        return this.a.g;
    }

    public void log(@NonNull String str) {
        k0 k0Var = this.a;
        Objects.requireNonNull(k0Var);
        long jCurrentTimeMillis = System.currentTimeMillis() - k0Var.d;
        x xVar = k0Var.h;
        xVar.m.b(new n(xVar, jCurrentTimeMillis, str));
    }

    public void recordException(@NonNull Throwable th) {
        if (th == null) {
            b.a.g("Crashlytics is ignoring a request to log a null exception.");
            return;
        }
        x xVar = this.a.h;
        Thread threadCurrentThread = Thread.currentThread();
        Objects.requireNonNull(xVar);
        Date date = new Date();
        i iVar = xVar.m;
        iVar.b(new j(iVar, new o(xVar, date, th, threadCurrentThread)));
    }

    public void sendUnsentReports() {
        x xVar = this.a.h;
        xVar.D.b(Boolean.TRUE);
        c0<Void> c0Var = xVar.E.a;
    }

    public void setCrashlyticsCollectionEnabled(boolean z2) {
        this.a.d(Boolean.valueOf(z2));
    }

    public void setCustomKey(@NonNull String str, boolean z2) {
        this.a.e(str, Boolean.toString(z2));
    }

    public void setUserId(@NonNull String str) {
        x xVar = this.a.h;
        f1 f1Var = xVar.l;
        Objects.requireNonNull(f1Var);
        f1Var.a = f1.b(str);
        xVar.m.b(new p(xVar, xVar.l));
    }

    public void setCrashlyticsCollectionEnabled(@Nullable Boolean bool) {
        this.a.d(bool);
    }

    public void setCustomKey(@NonNull String str, double d) {
        this.a.e(str, Double.toString(d));
    }

    public void setCustomKey(@NonNull String str, float f) {
        this.a.e(str, Float.toString(f));
    }

    public void setCustomKey(@NonNull String str, int i) {
        this.a.e(str, Integer.toString(i));
    }

    public void setCustomKey(@NonNull String str, long j) {
        this.a.e(str, Long.toString(j));
    }

    public void setCustomKey(@NonNull String str, @NonNull String str2) {
        this.a.e(str, str2);
    }
}
