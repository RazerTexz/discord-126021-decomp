package p007b.p225i.p361c.p369m.p370d.p373k;

import android.util.Log;
import java.util.Date;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p379p.C4717b;
import p007b.p225i.p361c.p369m.p370d.p379p.C4718c;

/* JADX INFO: renamed from: b.i.c.m.d.k.o */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC4645o implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Date f12359j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Throwable f12360k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Thread f12361l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ C4663x f12362m;

    public RunnableC4645o(C4663x c4663x, Date date, Throwable th, Thread thread) {
        this.f12362m = c4663x;
        this.f12359j = date;
        this.f12360k = th;
        this.f12361l = thread;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    @Override // java.lang.Runnable
    public void run() throws Throwable {
        String str;
        C4717b c4717b;
        C4717b c4717b2;
        int i;
        C4718c c4718cM6646i;
        C4717b c4717b3;
        int i2;
        if (this.f12362m.m6479p()) {
            return;
        }
        long time = this.f12359j.getTime() / 1000;
        String strM6474i = this.f12362m.m6474i();
        if (strM6474i == null) {
            C4592b.f12227a.m6371b("Tried to write a non-fatal exception while no session was open.");
            return;
        }
        C4618d1 c4618d1 = this.f12362m.f12422A;
        Throwable th = this.f12360k;
        Thread thread = this.f12361l;
        String strReplaceAll = strM6474i.replaceAll("-", "");
        Objects.requireNonNull(c4618d1);
        C4592b c4592b = C4592b.f12227a;
        C1643a.m868o0("Persisting non-fatal event for session ", strReplaceAll, c4592b);
        c4618d1.m6399a(th, thread, strReplaceAll, "error", time, false);
        C4663x c4663x = this.f12362m;
        Thread thread2 = this.f12361l;
        Throwable th2 = this.f12360k;
        Objects.requireNonNull(c4663x);
        C4718c c4718c = null;
        try {
            c4592b.m6371b("Crashlytics is logging non-fatal exception \"" + th2 + "\" from thread " + thread2.getName());
            C4717b c4717b4 = new C4717b(c4663x.m6476l(), strM6474i + "SessionEvent" + C4628h.m6428v(c4663x.f12428h.getAndIncrement()));
            try {
                c4718cM6646i = C4718c.m6646i(c4717b4);
                i2 = 6;
                c4717b2 = c4717b4;
                str = "Failed to flush to non-fatal file.";
                try {
                    c4663x.m6485y(c4718cM6646i, thread2, th2, time, "error", false);
                    c4717b3 = c4717b2;
                    c4718c = c4718cM6646i;
                    i = 6;
                } catch (Exception e) {
                    e = e;
                    c4718c = c4718cM6646i;
                    i = i2;
                    try {
                        if (C4592b.f12227a.m6370a(i)) {
                            Log.e("FirebaseCrashlytics", "An error occurred in the non-fatal exception logger", e);
                        }
                        c4717b3 = c4717b2;
                    } catch (Throwable th3) {
                        th = th3;
                        c4718cM6646i = c4718c;
                        c4717b = c4717b2;
                        c4718c = c4718cM6646i;
                        C4628h.m6414h(c4718c, str);
                        C4628h.m6409c(c4717b, "Failed to close non-fatal file output stream.");
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    c4717b = c4717b2;
                    c4718c = c4718cM6646i;
                    C4628h.m6414h(c4718c, str);
                    C4628h.m6409c(c4717b, "Failed to close non-fatal file output stream.");
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                c4717b2 = c4717b4;
                str = "Failed to flush to non-fatal file.";
                i2 = 6;
            } catch (Throwable th5) {
                th = th5;
                c4717b2 = c4717b4;
                str = "Failed to flush to non-fatal file.";
                c4718cM6646i = c4718c;
                c4717b = c4717b2;
                c4718c = c4718cM6646i;
                C4628h.m6414h(c4718c, str);
                C4628h.m6409c(c4717b, "Failed to close non-fatal file output stream.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            str = "Failed to flush to non-fatal file.";
            c4717b2 = null;
            i = 6;
        } catch (Throwable th6) {
            th = th6;
            str = "Failed to flush to non-fatal file.";
            c4717b = null;
            C4628h.m6414h(c4718c, str);
            C4628h.m6409c(c4717b, "Failed to close non-fatal file output stream.");
            throw th;
        }
        C4628h.m6414h(c4718c, str);
        C4628h.m6409c(c4717b3, "Failed to close non-fatal file output stream.");
        try {
            c4663x.m6483v(strM6474i, 64);
        } catch (Exception e4) {
            if (C4592b.f12227a.m6370a(i)) {
                Log.e("FirebaseCrashlytics", "An error occurred when trimming non-fatal files.", e4);
            }
        }
    }
}
