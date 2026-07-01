package b.i.c.m.d.k;

import android.util.Log;
import java.util.Date;
import java.util.Objects;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class o implements Runnable {
    public final /* synthetic */ Date j;
    public final /* synthetic */ Throwable k;
    public final /* synthetic */ Thread l;
    public final /* synthetic */ x m;

    public o(x xVar, Date date, Throwable th, Thread thread) {
        this.m = xVar;
        this.j = date;
        this.k = th;
        this.l = thread;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    @Override // java.lang.Runnable
    public void run() throws Throwable {
        String str;
        b.i.c.m.d.p.b bVar;
        b.i.c.m.d.p.b bVar2;
        int i;
        b.i.c.m.d.p.c cVarI;
        b.i.c.m.d.p.b bVar3;
        int i2;
        if (this.m.p()) {
            return;
        }
        long time = this.j.getTime() / 1000;
        String strI = this.m.i();
        if (strI == null) {
            b.i.c.m.d.b.a.b("Tried to write a non-fatal exception while no session was open.");
            return;
        }
        d1 d1Var = this.m.A;
        Throwable th = this.k;
        Thread thread = this.l;
        String strReplaceAll = strI.replaceAll("-", "");
        Objects.requireNonNull(d1Var);
        b.i.c.m.d.b bVar4 = b.i.c.m.d.b.a;
        b.d.b.a.a.o0("Persisting non-fatal event for session ", strReplaceAll, bVar4);
        d1Var.a(th, thread, strReplaceAll, "error", time, false);
        x xVar = this.m;
        Thread thread2 = this.l;
        Throwable th2 = this.k;
        Objects.requireNonNull(xVar);
        b.i.c.m.d.p.c cVar = null;
        try {
            bVar4.b("Crashlytics is logging non-fatal exception \"" + th2 + "\" from thread " + thread2.getName());
            b.i.c.m.d.p.b bVar5 = new b.i.c.m.d.p.b(xVar.l(), strI + "SessionEvent" + h.v(xVar.h.getAndIncrement()));
            try {
                cVarI = b.i.c.m.d.p.c.i(bVar5);
                i2 = 6;
                bVar2 = bVar5;
                str = "Failed to flush to non-fatal file.";
                try {
                    xVar.y(cVarI, thread2, th2, time, "error", false);
                    bVar3 = bVar2;
                    cVar = cVarI;
                    i = 6;
                } catch (Exception e) {
                    e = e;
                    cVar = cVarI;
                    i = i2;
                    try {
                        if (b.i.c.m.d.b.a.a(i)) {
                            Log.e("FirebaseCrashlytics", "An error occurred in the non-fatal exception logger", e);
                        }
                        bVar3 = bVar2;
                    } catch (Throwable th3) {
                        th = th3;
                        cVarI = cVar;
                        bVar = bVar2;
                        cVar = cVarI;
                        h.h(cVar, str);
                        h.c(bVar, "Failed to close non-fatal file output stream.");
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bVar = bVar2;
                    cVar = cVarI;
                    h.h(cVar, str);
                    h.c(bVar, "Failed to close non-fatal file output stream.");
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                bVar2 = bVar5;
                str = "Failed to flush to non-fatal file.";
                i2 = 6;
            } catch (Throwable th5) {
                th = th5;
                bVar2 = bVar5;
                str = "Failed to flush to non-fatal file.";
                cVarI = cVar;
                bVar = bVar2;
                cVar = cVarI;
                h.h(cVar, str);
                h.c(bVar, "Failed to close non-fatal file output stream.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            str = "Failed to flush to non-fatal file.";
            bVar2 = null;
            i = 6;
        } catch (Throwable th6) {
            th = th6;
            str = "Failed to flush to non-fatal file.";
            bVar = null;
            h.h(cVar, str);
            h.c(bVar, "Failed to close non-fatal file output stream.");
            throw th;
        }
        h.h(cVar, str);
        h.c(bVar3, "Failed to close non-fatal file output stream.");
        try {
            xVar.v(strI, 64);
        } catch (Exception e4) {
            if (b.i.c.m.d.b.a.a(i)) {
                Log.e("FirebaseCrashlytics", "An error occurred when trimming non-fatal files.", e4);
            }
        }
    }
}
