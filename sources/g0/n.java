package g0;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements x {
    public final InputStream j;
    public final y k;

    public n(InputStream inputStream, y yVar) {
        d0.z.d.m.checkParameterIsNotNull(inputStream, "input");
        d0.z.d.m.checkParameterIsNotNull(yVar, "timeout");
        this.j = inputStream;
        this.k = yVar;
    }

    @Override // g0.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.j.close();
    }

    @Override // g0.x
    public long i0(e eVar, long j) {
        d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
        if (j == 0) {
            return 0L;
        }
        if (!(j >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.t("byteCount < 0: ", j).toString());
        }
        try {
            this.k.f();
            s sVarN = eVar.N(1);
            int i = this.j.read(sVarN.a, sVarN.c, (int) Math.min(j, 8192 - sVarN.c));
            if (i != -1) {
                sVarN.c += i;
                long j2 = i;
                eVar.k += j2;
                return j2;
            }
            if (sVarN.f3693b != sVarN.c) {
                return -1L;
            }
            eVar.j = sVarN.a();
            t.a(sVarN);
            return -1L;
        } catch (AssertionError e) {
            if (b.i.a.f.e.o.f.z0(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    @Override // g0.x
    public y timeout() {
        return this.k;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("source(");
        sbU.append(this.j);
        sbU.append(')');
        return sbU.toString();
    }
}
