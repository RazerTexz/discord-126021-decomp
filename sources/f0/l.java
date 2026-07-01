package f0;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ConnectionPool.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public final f0.e0.g.k a;

    public l() {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        d0.z.d.m.checkParameterIsNotNull(timeUnit, "timeUnit");
        f0.e0.g.k kVar = new f0.e0.g.k(f0.e0.f.d.a, 5, 5L, timeUnit);
        d0.z.d.m.checkParameterIsNotNull(kVar, "delegate");
        this.a = kVar;
    }
}
