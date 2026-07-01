package f0.e0.j;

import com.discord.api.permission.Permission;
import g0.v;
import g0.y;
import java.io.IOException;

/* JADX INFO: compiled from: Http2Stream.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n$a implements v {
    public final g0.e j = new g0.e();
    public boolean k;
    public boolean l;
    public final /* synthetic */ n m;

    public n$a(n nVar, boolean z2) {
        this.m = nVar;
        this.l = z2;
    }

    public final void a(boolean z2) throws IOException {
        long jMin;
        boolean z3;
        synchronized (this.m) {
            this.m.j.i();
            while (true) {
                try {
                    n nVar = this.m;
                    if (nVar.c < nVar.d || this.l || this.k || nVar.f() != null) {
                        break;
                    } else {
                        this.m.l();
                    }
                } catch (Throwable th) {
                    this.m.j.m();
                    throw th;
                }
            }
            this.m.j.m();
            this.m.b();
            n nVar2 = this.m;
            jMin = Math.min(nVar2.d - nVar2.c, this.j.k);
            n nVar3 = this.m;
            nVar3.c += jMin;
            z3 = z2 && jMin == this.j.k && nVar3.f() == null;
        }
        this.m.j.i();
        try {
            n nVar4 = this.m;
            nVar4.n.n(nVar4.m, z3, this.j, jMin);
        } finally {
            this.m.j.m();
        }
    }

    @Override // g0.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        n nVar = this.m;
        byte[] bArr = f0.e0.c.a;
        synchronized (nVar) {
            if (this.k) {
                return;
            }
            boolean z2 = this.m.f() == null;
            n nVar2 = this.m;
            if (!nVar2.h.l) {
                if (this.j.k > 0) {
                    while (this.j.k > 0) {
                        a(true);
                    }
                } else if (z2) {
                    nVar2.n.n(nVar2.m, true, null, 0L);
                }
            }
            synchronized (this.m) {
                this.k = true;
            }
            this.m.n.K.flush();
            this.m.a();
        }
    }

    @Override // g0.v, java.io.Flushable
    public void flush() throws IOException {
        n nVar = this.m;
        byte[] bArr = f0.e0.c.a;
        synchronized (nVar) {
            this.m.b();
        }
        while (this.j.k > 0) {
            a(false);
            this.m.n.K.flush();
        }
    }

    @Override // g0.v
    public y timeout() {
        return this.m.j;
    }

    @Override // g0.v
    public void write(g0.e eVar, long j) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(eVar, "source");
        byte[] bArr = f0.e0.c.a;
        this.j.write(eVar, j);
        while (this.j.k >= Permission.EMBED_LINKS) {
            a(false);
        }
    }
}
