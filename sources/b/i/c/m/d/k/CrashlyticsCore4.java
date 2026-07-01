package b.i.c.m.d.k;

import b.i.c.m.d.Logger3;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.i.c.m.d.k.l0, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsCore.java */
/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsCore4 implements Callable<Boolean> {
    public final /* synthetic */ CrashlyticsCore3 j;

    public CrashlyticsCore4(CrashlyticsCore3 crashlyticsCore3) {
        this.j = crashlyticsCore3;
    }

    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        x xVar = this.j.h;
        boolean z2 = true;
        if (xVar.k.b().exists()) {
            Logger3.a.b("Found previous crash marker.");
            xVar.k.b().delete();
        } else {
            String strI = xVar.i();
            if (strI == null || !xVar.w.e(strI)) {
                z2 = false;
            }
        }
        return Boolean.valueOf(z2);
    }
}
