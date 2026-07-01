package f0.e0.g;

/* JADX INFO: compiled from: RealConnectionPool.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$a extends f0.e0.f.a {
    public final /* synthetic */ k e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k$a(k kVar, String str) {
        super(str, true);
        this.e = kVar;
    }

    @Override // f0.e0.f.a
    public long a() {
        k kVar = this.e;
        long jNanoTime = System.nanoTime();
        j jVar = null;
        long j = Long.MIN_VALUE;
        int i = 0;
        int i2 = 0;
        for (j jVar2 : kVar.d) {
            d0.z.d.m.checkExpressionValueIsNotNull(jVar2, "connection");
            synchronized (jVar2) {
                if (kVar.b(jVar2, jNanoTime) > 0) {
                    i2++;
                } else {
                    i++;
                    long j2 = jNanoTime - jVar2.p;
                    if (j2 > j) {
                        jVar = jVar2;
                        j = j2;
                    }
                }
            }
        }
        long j3 = kVar.a;
        if (j < j3 && i <= kVar.e) {
            if (i > 0) {
                return j3 - j;
            }
            if (i2 > 0) {
                return j3;
            }
            return -1L;
        }
        if (jVar == null) {
            d0.z.d.m.throwNpe();
        }
        synchronized (jVar) {
            if (!jVar.o.isEmpty()) {
                return 0L;
            }
            if (jVar.p + j != jNanoTime) {
                return 0L;
            }
            jVar.i = true;
            kVar.d.remove(jVar);
            f0.e0.c.e(jVar.n());
            if (!kVar.d.isEmpty()) {
                return 0L;
            }
            kVar.f3621b.a();
            return 0L;
        }
    }
}
