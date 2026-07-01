package g0;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: InflaterSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements x {
    public int j;
    public boolean k;
    public final g l;
    public final Inflater m;

    public m(x xVar, Inflater inflater) {
        d0.z.d.m.checkParameterIsNotNull(xVar, "source");
        d0.z.d.m.checkParameterIsNotNull(inflater, "inflater");
        d0.z.d.m.checkParameterIsNotNull(xVar, "$this$buffer");
        r rVar = new r(xVar);
        d0.z.d.m.checkParameterIsNotNull(rVar, "source");
        d0.z.d.m.checkParameterIsNotNull(inflater, "inflater");
        this.l = rVar;
        this.m = inflater;
    }

    public final long a(e eVar, long j) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.t("byteCount < 0: ", j).toString());
        }
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j == 0) {
            return 0L;
        }
        try {
            s sVarN = eVar.N(1);
            int iMin = (int) Math.min(j, 8192 - sVarN.c);
            if (this.m.needsInput() && !this.l.w()) {
                s sVar = this.l.g().j;
                if (sVar == null) {
                    d0.z.d.m.throwNpe();
                }
                int i = sVar.c;
                int i2 = sVar.f3693b;
                int i3 = i - i2;
                this.j = i3;
                this.m.setInput(sVar.a, i2, i3);
            }
            int iInflate = this.m.inflate(sVarN.a, sVarN.c, iMin);
            int i4 = this.j;
            if (i4 != 0) {
                int remaining = i4 - this.m.getRemaining();
                this.j -= remaining;
                this.l.skip(remaining);
            }
            if (iInflate > 0) {
                sVarN.c += iInflate;
                long j2 = iInflate;
                eVar.k += j2;
                return j2;
            }
            if (sVarN.f3693b == sVarN.c) {
                eVar.j = sVarN.a();
                t.a(sVarN);
            }
            return 0L;
        } catch (DataFormatException e) {
            throw new IOException(e);
        }
    }

    @Override // g0.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.k) {
            return;
        }
        this.m.end();
        this.k = true;
        this.l.close();
    }

    @Override // g0.x
    public long i0(e eVar, long j) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
        do {
            long jA = a(eVar, j);
            if (jA > 0) {
                return jA;
            }
            if (this.m.finished() || this.m.needsDictionary()) {
                return -1L;
            }
        } while (!this.l.w());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // g0.x
    public y timeout() {
        return this.l.timeout();
    }

    public m(g gVar, Inflater inflater) {
        d0.z.d.m.checkParameterIsNotNull(gVar, "source");
        d0.z.d.m.checkParameterIsNotNull(inflater, "inflater");
        this.l = gVar;
        this.m = inflater;
    }
}
