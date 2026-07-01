package com.google.firebase.crashlytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.a.f.e.o.f;
import b.i.a.f.n.c0;
import b.i.c.FirebaseApp2;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.k.CrashlyticsBackgroundWorker;
import b.i.c.m.d.k.CrashlyticsBackgroundWorker2;
import b.i.c.m.d.k.CrashlyticsCore3;
import b.i.c.m.d.k.UserMetadata;
import b.i.c.m.d.k.n;
import b.i.c.m.d.k.o;
import b.i.c.m.d.k.p;
import b.i.c.m.d.k.x;
import com.google.android.gms.tasks.Task;
import java.util.Date;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class FirebaseCrashlytics {
    public final CrashlyticsCore3 a;

    public FirebaseCrashlytics(@NonNull CrashlyticsCore3 crashlyticsCore3) {
        this.a = crashlyticsCore3;
    }

    @NonNull
    public static FirebaseCrashlytics getInstance() {
        FirebaseApp2 firebaseApp2B = FirebaseApp2.b();
        firebaseApp2B.a();
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) firebaseApp2B.g.a(FirebaseCrashlytics.class);
        Objects.requireNonNull(firebaseCrashlytics, "FirebaseCrashlytics component is not present.");
        return firebaseCrashlytics;
    }

    @NonNull
    public Task<Boolean> checkForUnsentReports() {
        x xVar = this.a.h;
        if (xVar.F.compareAndSet(false, true)) {
            return xVar.C.a;
        }
        Logger3.a.b("checkForUnsentReports should only be called once per execution.");
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
        CrashlyticsCore3 crashlyticsCore3 = this.a;
        Objects.requireNonNull(crashlyticsCore3);
        long jCurrentTimeMillis = System.currentTimeMillis() - crashlyticsCore3.d;
        x xVar = crashlyticsCore3.h;
        xVar.m.b(new n(xVar, jCurrentTimeMillis, str));
    }

    public void recordException(@NonNull Throwable th) {
        if (th == null) {
            Logger3.a.g("Crashlytics is ignoring a request to log a null exception.");
            return;
        }
        x xVar = this.a.h;
        Thread threadCurrentThread = Thread.currentThread();
        Objects.requireNonNull(xVar);
        Date date = new Date();
        CrashlyticsBackgroundWorker crashlyticsBackgroundWorker = xVar.m;
        crashlyticsBackgroundWorker.b(new CrashlyticsBackgroundWorker2(crashlyticsBackgroundWorker, new o(xVar, date, th, threadCurrentThread)));
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
        UserMetadata userMetadata = xVar.l;
        Objects.requireNonNull(userMetadata);
        userMetadata.a = UserMetadata.b(str);
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
