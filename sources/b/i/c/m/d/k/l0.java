package b.i.c.m.d.k;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CrashlyticsCore.java */
/* JADX INFO: loaded from: classes3.dex */
public class l0 implements Callable<Boolean> {
    public final /* synthetic */ k0 j;

    public l0(k0 k0Var) {
        this.j = k0Var;
    }

    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        x xVar = this.j.h;
        boolean z2 = true;
        if (xVar.k.b().exists()) {
            b.i.c.m.d.b.a.b("Found previous crash marker.");
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
