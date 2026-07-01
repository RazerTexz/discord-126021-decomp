package f0.e0.i;

import d0.z.d.m;
import f0.e0.c;
import g0.e;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Http1ExchangeCodec.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$d extends b$a {
    public long m;
    public final /* synthetic */ b n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b$d(b bVar, long j) {
        super(bVar);
        this.n = bVar;
        this.m = j;
        if (j == 0) {
            a();
        }
    }

    @Override // g0.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.k) {
            return;
        }
        if (this.m != 0 && !c.i(this, 100, TimeUnit.MILLISECONDS)) {
            this.n.e.l();
            a();
        }
        this.k = true;
    }

    @Override // f0.e0.i.b$a, g0.x
    public long i0(e eVar, long j) throws ProtocolException {
        m.checkParameterIsNotNull(eVar, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.t("byteCount < 0: ", j).toString());
        }
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        long j2 = this.m;
        if (j2 == 0) {
            return -1L;
        }
        long jI0 = super.i0(eVar, Math.min(j2, j));
        if (jI0 == -1) {
            this.n.e.l();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a();
            throw protocolException;
        }
        long j3 = this.m - jI0;
        this.m = j3;
        if (j3 == 0) {
            a();
        }
        return jI0;
    }
}
