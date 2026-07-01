package f0.e0.j;

import g0.x;
import g0.y;
import java.io.IOException;
import kotlin.TypeCastException;
import okhttp3.internal.http2.StreamResetException;

/* JADX INFO: compiled from: Http2Stream.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n$b implements x {
    public final g0.e j = new g0.e();
    public final g0.e k = new g0.e();
    public boolean l;
    public final long m;
    public boolean n;
    public final /* synthetic */ n o;

    public n$b(n nVar, long j, boolean z2) {
        this.o = nVar;
        this.m = j;
        this.n = z2;
    }

    public final void a(long j) {
        n nVar = this.o;
        byte[] bArr = f0.e0.c.a;
        nVar.n.f(j);
    }

    @Override // g0.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        long j;
        synchronized (this.o) {
            this.l = true;
            g0.e eVar = this.k;
            j = eVar.k;
            eVar.skip(j);
            n nVar = this.o;
            if (nVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
            }
            nVar.notifyAll();
        }
        if (j > 0) {
            a(j);
        }
        this.o.a();
    }

    @Override // g0.x
    public long i0(g0.e eVar, long j) throws Throwable {
        long jI0;
        boolean z2;
        long j2;
        d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
        long j3 = 0;
        if (!(j >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.t("byteCount < 0: ", j).toString());
        }
        while (true) {
            Throwable streamResetException = null;
            synchronized (this.o) {
                this.o.i.i();
                try {
                    if (this.o.f() != null && (streamResetException = this.o.l) == null) {
                        a aVarF = this.o.f();
                        if (aVarF == null) {
                            d0.z.d.m.throwNpe();
                        }
                        streamResetException = new StreamResetException(aVarF);
                    }
                    if (this.l) {
                        throw new IOException("stream closed");
                    }
                    g0.e eVar2 = this.k;
                    long j4 = eVar2.k;
                    if (j4 > j3) {
                        jI0 = eVar2.i0(eVar, Math.min(j, j4));
                        n nVar = this.o;
                        long j5 = nVar.a + jI0;
                        nVar.a = j5;
                        long j6 = j5 - nVar.f3644b;
                        if (streamResetException == null && j6 >= nVar.n.D.a() / 2) {
                            n nVar2 = this.o;
                            nVar2.n.t(nVar2.m, j6);
                            n nVar3 = this.o;
                            nVar3.f3644b = nVar3.a;
                        }
                    } else {
                        if (this.n || streamResetException != null) {
                            jI0 = -1;
                        } else {
                            this.o.l();
                            z2 = true;
                            j2 = -1;
                        }
                        this.o.i.m();
                    }
                    j2 = jI0;
                    z2 = false;
                    this.o.i.m();
                } catch (Throwable th) {
                    this.o.i.m();
                    throw th;
                }
            }
            if (!z2) {
                if (j2 != -1) {
                    a(j2);
                    return j2;
                }
                if (streamResetException == null) {
                    return -1L;
                }
                throw streamResetException;
            }
            j3 = 0;
        }
    }

    @Override // g0.x
    public y timeout() {
        return this.o.i;
    }
}
