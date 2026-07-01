package f0.e0.j;

import g0.x;
import g0.y;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: Http2Reader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m$a implements x {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public final g0.g o;

    public m$a(g0.g gVar) {
        d0.z.d.m.checkParameterIsNotNull(gVar, "source");
        this.o = gVar;
    }

    @Override // g0.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // g0.x
    public long i0(g0.e eVar, long j) throws IOException {
        int i;
        int i2;
        d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
        do {
            int i3 = this.m;
            if (i3 != 0) {
                long jI0 = this.o.i0(eVar, Math.min(j, i3));
                if (jI0 == -1) {
                    return -1L;
                }
                this.m -= (int) jI0;
                return jI0;
            }
            this.o.skip(this.n);
            this.n = 0;
            if ((this.k & 4) != 0) {
                return -1L;
            }
            i = this.l;
            int iT = f0.e0.c.t(this.o);
            this.m = iT;
            this.j = iT;
            int i4 = this.o.readByte() & 255;
            this.k = this.o.readByte() & 255;
            m mVar = m.k;
            Logger logger = m.j;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(d.e.b(true, this.l, this.j, i4, this.k));
            }
            i2 = this.o.readInt() & Integer.MAX_VALUE;
            this.l = i2;
            if (i4 != 9) {
                throw new IOException(i4 + " != TYPE_CONTINUATION");
            }
        } while (i2 == i);
        throw new IOException("TYPE_CONTINUATION streamId changed");
    }

    @Override // g0.x
    public y timeout() {
        return this.o.timeout();
    }
}
