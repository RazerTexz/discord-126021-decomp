package g0;

import java.io.IOException;

/* JADX INFO: compiled from: AsyncTimeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements x {
    public final /* synthetic */ b j;
    public final /* synthetic */ x k;

    public d(b bVar, x xVar) {
        this.j = bVar;
        this.k = xVar;
    }

    @Override // g0.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        b bVar = this.j;
        bVar.i();
        try {
            try {
                this.k.close();
                if (bVar.j()) {
                    throw bVar.k(null);
                }
            } catch (IOException e) {
                if (!bVar.j()) {
                    throw e;
                }
                throw bVar.k(e);
            }
        } catch (Throwable th) {
            bVar.j();
            throw th;
        }
    }

    @Override // g0.x
    public long i0(e eVar, long j) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
        b bVar = this.j;
        bVar.i();
        try {
            try {
                long jI0 = this.k.i0(eVar, j);
                if (bVar.j()) {
                    throw bVar.k(null);
                }
                return jI0;
            } catch (IOException e) {
                if (bVar.j()) {
                    throw bVar.k(e);
                }
                throw e;
            }
        } catch (Throwable th) {
            bVar.j();
            throw th;
        }
    }

    @Override // g0.x
    public y timeout() {
        return this.j;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("AsyncTimeout.source(");
        sbU.append(this.k);
        sbU.append(')');
        return sbU.toString();
    }
}
