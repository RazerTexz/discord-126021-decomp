package p600f0;

import java.util.concurrent.TimeUnit;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.p604f.C12280d;
import p600f0.p601e0.p605g.C12291k;

/* JADX INFO: renamed from: f0.l */
/* JADX INFO: compiled from: ConnectionPool.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12368l {

    /* JADX INFO: renamed from: a */
    public final C12291k f25929a;

    public C12368l() {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        C12238m.checkParameterIsNotNull(timeUnit, "timeUnit");
        C12291k c12291k = new C12291k(C12280d.f25420a, 5, 5L, timeUnit);
        C12238m.checkParameterIsNotNull(c12291k, "delegate");
        this.f25929a = c12291k;
    }
}
