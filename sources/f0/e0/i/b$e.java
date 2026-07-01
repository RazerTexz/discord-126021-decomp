package f0.e0.i;

import d0.z.d.m;
import f0.e0.c;
import g0.e;
import g0.k;
import g0.v;
import g0.y;
import java.io.IOException;

/* JADX INFO: compiled from: Http1ExchangeCodec.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$e implements v {
    public final k j;
    public boolean k;
    public final /* synthetic */ b l;

    public b$e(b bVar) {
        this.l = bVar;
        this.j = new k(bVar.g.timeout());
    }

    @Override // g0.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.k) {
            return;
        }
        this.k = true;
        b.i(this.l, this.j);
        this.l.a = 3;
    }

    @Override // g0.v, java.io.Flushable
    public void flush() throws IOException {
        if (this.k) {
            return;
        }
        this.l.g.flush();
    }

    @Override // g0.v
    public y timeout() {
        return this.j;
    }

    @Override // g0.v
    public void write(e eVar, long j) throws IOException {
        m.checkParameterIsNotNull(eVar, "source");
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        c.c(eVar.k, 0L, j);
        this.l.g.write(eVar, j);
    }
}
