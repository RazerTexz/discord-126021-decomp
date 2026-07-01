package b.i.c.m.d.k;

import android.util.Log;
import b.d.b.a.outline;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.p.ClsFileOutputStream;
import b.i.c.m.d.p.CodedOutputStream2;
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
        ClsFileOutputStream clsFileOutputStream;
        ClsFileOutputStream clsFileOutputStream2;
        int i;
        CodedOutputStream2 codedOutputStream2I;
        ClsFileOutputStream clsFileOutputStream3;
        int i2;
        if (this.m.p()) {
            return;
        }
        long time = this.j.getTime() / 1000;
        String strI = this.m.i();
        if (strI == null) {
            Logger3.a.b("Tried to write a non-fatal exception while no session was open.");
            return;
        }
        SessionReportingCoordinator3 sessionReportingCoordinator3 = this.m.A;
        Throwable th = this.k;
        Thread thread = this.l;
        String strReplaceAll = strI.replaceAll("-", "");
        Objects.requireNonNull(sessionReportingCoordinator3);
        Logger3 logger3 = Logger3.a;
        outline.o0("Persisting non-fatal event for session ", strReplaceAll, logger3);
        sessionReportingCoordinator3.a(th, thread, strReplaceAll, "error", time, false);
        x xVar = this.m;
        Thread thread2 = this.l;
        Throwable th2 = this.k;
        Objects.requireNonNull(xVar);
        CodedOutputStream2 codedOutputStream2 = null;
        try {
            logger3.b("Crashlytics is logging non-fatal exception \"" + th2 + "\" from thread " + thread2.getName());
            ClsFileOutputStream clsFileOutputStream4 = new ClsFileOutputStream(xVar.l(), strI + "SessionEvent" + CommonUtils.v(xVar.h.getAndIncrement()));
            try {
                codedOutputStream2I = CodedOutputStream2.i(clsFileOutputStream4);
                i2 = 6;
                clsFileOutputStream2 = clsFileOutputStream4;
                str = "Failed to flush to non-fatal file.";
                try {
                    xVar.y(codedOutputStream2I, thread2, th2, time, "error", false);
                    clsFileOutputStream3 = clsFileOutputStream2;
                    codedOutputStream2 = codedOutputStream2I;
                    i = 6;
                } catch (Exception e) {
                    e = e;
                    codedOutputStream2 = codedOutputStream2I;
                    i = i2;
                    try {
                        if (Logger3.a.a(i)) {
                            Log.e("FirebaseCrashlytics", "An error occurred in the non-fatal exception logger", e);
                        }
                        clsFileOutputStream3 = clsFileOutputStream2;
                    } catch (Throwable th3) {
                        th = th3;
                        codedOutputStream2I = codedOutputStream2;
                        clsFileOutputStream = clsFileOutputStream2;
                        codedOutputStream2 = codedOutputStream2I;
                        CommonUtils.h(codedOutputStream2, str);
                        CommonUtils.c(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    clsFileOutputStream = clsFileOutputStream2;
                    codedOutputStream2 = codedOutputStream2I;
                    CommonUtils.h(codedOutputStream2, str);
                    CommonUtils.c(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                clsFileOutputStream2 = clsFileOutputStream4;
                str = "Failed to flush to non-fatal file.";
                i2 = 6;
            } catch (Throwable th5) {
                th = th5;
                clsFileOutputStream2 = clsFileOutputStream4;
                str = "Failed to flush to non-fatal file.";
                codedOutputStream2I = codedOutputStream2;
                clsFileOutputStream = clsFileOutputStream2;
                codedOutputStream2 = codedOutputStream2I;
                CommonUtils.h(codedOutputStream2, str);
                CommonUtils.c(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            str = "Failed to flush to non-fatal file.";
            clsFileOutputStream2 = null;
            i = 6;
        } catch (Throwable th6) {
            th = th6;
            str = "Failed to flush to non-fatal file.";
            clsFileOutputStream = null;
            CommonUtils.h(codedOutputStream2, str);
            CommonUtils.c(clsFileOutputStream, "Failed to close non-fatal file output stream.");
            throw th;
        }
        CommonUtils.h(codedOutputStream2, str);
        CommonUtils.c(clsFileOutputStream3, "Failed to close non-fatal file output stream.");
        try {
            xVar.v(strI, 64);
        } catch (Exception e4) {
            if (Logger3.a.a(i)) {
                Log.e("FirebaseCrashlytics", "An error occurred when trimming non-fatal files.", e4);
            }
        }
    }
}
