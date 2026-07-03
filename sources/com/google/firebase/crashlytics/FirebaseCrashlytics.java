package com.google.firebase.crashlytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import java.util.Date;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.C4358c0;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p373k.C4624f1;
import p007b.p225i.p361c.p369m.p370d.p373k.C4631i;
import p007b.p225i.p361c.p369m.p370d.p373k.C4638k0;
import p007b.p225i.p361c.p369m.p370d.p373k.C4663x;
import p007b.p225i.p361c.p369m.p370d.p373k.CallableC4634j;
import p007b.p225i.p361c.p369m.p370d.p373k.CallableC4643n;
import p007b.p225i.p361c.p369m.p370d.p373k.CallableC4647p;
import p007b.p225i.p361c.p369m.p370d.p373k.RunnableC4645o;

/* JADX INFO: loaded from: classes3.dex */
public class FirebaseCrashlytics {

    /* JADX INFO: renamed from: a */
    public final C4638k0 f21418a;

    public FirebaseCrashlytics(@NonNull C4638k0 c4638k0) {
        this.f21418a = c4638k0;
    }

    @NonNull
    public static FirebaseCrashlytics getInstance() {
        C4542c c4542cM6327b = C4542c.m6327b();
        c4542cM6327b.m6330a();
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) c4542cM6327b.f12121g.mo6346a(FirebaseCrashlytics.class);
        Objects.requireNonNull(firebaseCrashlytics, "FirebaseCrashlytics component is not present.");
        return firebaseCrashlytics;
    }

    @NonNull
    public Task<Boolean> checkForUnsentReports() {
        C4663x c4663x = this.f21418a.f12336h;
        if (c4663x.f12427F.compareAndSet(false, true)) {
            return c4663x.f12424C.f20845a;
        }
        C4592b.f12227a.m6371b("checkForUnsentReports should only be called once per execution.");
        return C3404f.m4264Z(Boolean.FALSE);
    }

    public void deleteUnsentReports() {
        C4663x c4663x = this.f21418a.f12336h;
        c4663x.f12425D.m9126b(Boolean.FALSE);
        C4358c0<Void> c4358c0 = c4663x.f12426E.f20845a;
    }

    public boolean didCrashOnPreviousExecution() {
        return this.f21418a.f12335g;
    }

    public void log(@NonNull String str) {
        C4638k0 c4638k0 = this.f21418a;
        Objects.requireNonNull(c4638k0);
        long jCurrentTimeMillis = System.currentTimeMillis() - c4638k0.f12332d;
        C4663x c4663x = c4638k0.f12336h;
        c4663x.f12433m.m6437b(new CallableC4643n(c4663x, jCurrentTimeMillis, str));
    }

    public void recordException(@NonNull Throwable th) {
        if (th == null) {
            C4592b.f12227a.m6376g("Crashlytics is ignoring a request to log a null exception.");
            return;
        }
        C4663x c4663x = this.f21418a.f12336h;
        Thread threadCurrentThread = Thread.currentThread();
        Objects.requireNonNull(c4663x);
        Date date = new Date();
        C4631i c4631i = c4663x.f12433m;
        c4631i.m6437b(new CallableC4634j(c4631i, new RunnableC4645o(c4663x, date, th, threadCurrentThread)));
    }

    public void sendUnsentReports() {
        C4663x c4663x = this.f21418a.f12336h;
        c4663x.f12425D.m9126b(Boolean.TRUE);
        C4358c0<Void> c4358c0 = c4663x.f12426E.f20845a;
    }

    public void setCrashlyticsCollectionEnabled(boolean z2) {
        this.f21418a.m6442d(Boolean.valueOf(z2));
    }

    public void setCustomKey(@NonNull String str, boolean z2) {
        this.f21418a.m6443e(str, Boolean.toString(z2));
    }

    public void setUserId(@NonNull String str) {
        C4663x c4663x = this.f21418a.f12336h;
        C4624f1 c4624f1 = c4663x.f12432l;
        Objects.requireNonNull(c4624f1);
        c4624f1.f12290a = C4624f1.m6403b(str);
        c4663x.f12433m.m6437b(new CallableC4647p(c4663x, c4663x.f12432l));
    }

    public void setCrashlyticsCollectionEnabled(@Nullable Boolean bool) {
        this.f21418a.m6442d(bool);
    }

    public void setCustomKey(@NonNull String str, double d) {
        this.f21418a.m6443e(str, Double.toString(d));
    }

    public void setCustomKey(@NonNull String str, float f) {
        this.f21418a.m6443e(str, Float.toString(f));
    }

    public void setCustomKey(@NonNull String str, int i) {
        this.f21418a.m6443e(str, Integer.toString(i));
    }

    public void setCustomKey(@NonNull String str, long j) {
        this.f21418a.m6443e(str, Long.toString(j));
    }

    public void setCustomKey(@NonNull String str, @NonNull String str2) {
        this.f21418a.m6443e(str, str2);
    }
}
