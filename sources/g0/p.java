package g0;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p implements v {
    public final OutputStream j;
    public final y k;

    public p(OutputStream outputStream, y yVar) {
        d0.z.d.m.checkParameterIsNotNull(outputStream, "out");
        d0.z.d.m.checkParameterIsNotNull(yVar, "timeout");
        this.j = outputStream;
        this.k = yVar;
    }

    @Override // g0.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.j.close();
    }

    @Override // g0.v, java.io.Flushable
    public void flush() throws IOException {
        this.j.flush();
    }

    @Override // g0.v
    public y timeout() {
        return this.k;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("sink(");
        sbU.append(this.j);
        sbU.append(')');
        return sbU.toString();
    }

    @Override // g0.v
    public void write(e eVar, long j) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(eVar, "source");
        b.i.a.f.e.o.f.B(eVar.k, 0L, j);
        while (j > 0) {
            this.k.f();
            s sVar = eVar.j;
            if (sVar == null) {
                d0.z.d.m.throwNpe();
            }
            int iMin = (int) Math.min(j, sVar.c - sVar.f3693b);
            this.j.write(sVar.a, sVar.f3693b, iMin);
            int i = sVar.f3693b + iMin;
            sVar.f3693b = i;
            long j2 = iMin;
            j -= j2;
            eVar.k -= j2;
            if (i == sVar.c) {
                eVar.j = sVar.a();
                t.a(sVar);
            }
        }
    }
}
