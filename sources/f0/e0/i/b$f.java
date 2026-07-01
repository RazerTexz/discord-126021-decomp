package f0.e0.i;

import d0.z.d.m;
import g0.e;

/* JADX INFO: compiled from: Http1ExchangeCodec.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$f extends b$a {
    public boolean m;

    public b$f(b bVar) {
        super(bVar);
    }

    @Override // g0.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.k) {
            return;
        }
        if (!this.m) {
            a();
        }
        this.k = true;
    }

    @Override // f0.e0.i.b$a, g0.x
    public long i0(e eVar, long j) {
        m.checkParameterIsNotNull(eVar, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.t("byteCount < 0: ", j).toString());
        }
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.m) {
            return -1L;
        }
        long jI0 = super.i0(eVar, j);
        if (jI0 != -1) {
            return jI0;
        }
        this.m = true;
        a();
        return -1L;
    }
}
