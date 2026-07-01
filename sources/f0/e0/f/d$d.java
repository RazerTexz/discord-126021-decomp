package f0.e0.f;

import b.i.a.f.e.o.f;
import d0.z.d.m;
import java.util.logging.Level;

/* JADX INFO: compiled from: TaskRunner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$d implements Runnable {
    public final /* synthetic */ d j;

    public d$d(d dVar) {
        this.j = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVarC;
        while (true) {
            synchronized (this.j) {
                aVarC = this.j.c();
            }
            if (aVarC == null) {
                return;
            }
            c cVar = aVarC.a;
            if (cVar == null) {
                m.throwNpe();
            }
            long jC = -1;
            d$b d_b = d.c;
            boolean zIsLoggable = d.f3611b.isLoggable(Level.FINE);
            if (zIsLoggable) {
                jC = cVar.e.j.c();
                f.e(aVarC, cVar, "starting");
            }
            try {
                d.a(this.j, aVarC);
                if (zIsLoggable) {
                    long jC2 = cVar.e.j.c() - jC;
                    StringBuilder sbU = b.d.b.a.a.U("finished run in ");
                    sbU.append(f.a0(jC2));
                    f.e(aVarC, cVar, sbU.toString());
                }
            } catch (Throwable th) {
                try {
                    this.j.j.execute(this);
                    throw th;
                } catch (Throwable th2) {
                    if (zIsLoggable) {
                        long jC3 = cVar.e.j.c() - jC;
                        StringBuilder sbU2 = b.d.b.a.a.U("failed a run in ");
                        sbU2.append(f.a0(jC3));
                        f.e(aVarC, cVar, sbU2.toString());
                    }
                    throw th2;
                }
            }
        }
    }
}
