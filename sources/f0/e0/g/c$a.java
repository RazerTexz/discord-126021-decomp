package f0.e0.g;

import g0.v;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: compiled from: Exchange.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a extends g0.i {
    public boolean j;
    public long k;
    public boolean l;
    public final long m;
    public final /* synthetic */ c n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c$a(c cVar, v vVar, long j) {
        super(vVar);
        d0.z.d.m.checkParameterIsNotNull(vVar, "delegate");
        this.n = cVar;
        this.m = j;
    }

    public final <E extends IOException> E a(E e) {
        if (this.j) {
            return e;
        }
        this.j = true;
        return (E) this.n.a(this.k, false, true, e);
    }

    @Override // g0.i, g0.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.l) {
            return;
        }
        this.l = true;
        long j = this.m;
        if (j != -1 && this.k != j) {
            throw new ProtocolException("unexpected end of stream");
        }
        try {
            super.close();
            a(null);
        } catch (IOException e) {
            throw a(e);
        }
    }

    @Override // g0.i, g0.v, java.io.Flushable
    public void flush() throws IOException {
        try {
            super.flush();
        } catch (IOException e) {
            throw a(e);
        }
    }

    @Override // g0.i, g0.v
    public void write(g0.e eVar, long j) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(eVar, "source");
        if (!(!this.l)) {
            throw new IllegalStateException("closed".toString());
        }
        long j2 = this.m;
        if (j2 == -1 || this.k + j <= j2) {
            try {
                super.write(eVar, j);
                this.k += j;
                return;
            } catch (IOException e) {
                throw a(e);
            }
        }
        StringBuilder sbU = b.d.b.a.a.U("expected ");
        sbU.append(this.m);
        sbU.append(" bytes but received ");
        sbU.append(this.k + j);
        throw new ProtocolException(sbU.toString());
    }
}
