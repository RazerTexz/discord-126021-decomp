package p007b.p225i.p361c.p369m.p370d.p373k;

import java.util.concurrent.Callable;
import p007b.p225i.p361c.p369m.p370d.C4592b;

/* JADX INFO: renamed from: b.i.c.m.d.k.l0 */
/* JADX INFO: compiled from: CrashlyticsCore.java */
/* JADX INFO: loaded from: classes3.dex */
public class CallableC4640l0 implements Callable<Boolean> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C4638k0 f12346j;

    public CallableC4640l0(C4638k0 c4638k0) {
        this.f12346j = c4638k0;
    }

    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        C4663x c4663x = this.f12346j.f12336h;
        boolean z2 = true;
        if (c4663x.f12431k.m6445b().exists()) {
            C4592b.f12227a.m6371b("Found previous crash marker.");
            c4663x.f12431k.m6445b().delete();
        } else {
            String strM6474i = c4663x.m6474i();
            if (strM6474i == null || !c4663x.f12443w.mo6366e(strM6474i)) {
                z2 = false;
            }
        }
        return Boolean.valueOf(z2);
    }
}
