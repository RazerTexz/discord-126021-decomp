package f0.e0.g;

import androidx.core.app.NotificationCompat;
import f0.t;
import g0.x;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;

/* JADX INFO: compiled from: Exchange.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$b extends g0.j {
    public long k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final long o;
    public final /* synthetic */ c p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c$b(c cVar, x xVar, long j) {
        super(xVar);
        d0.z.d.m.checkParameterIsNotNull(xVar, "delegate");
        this.p = cVar;
        this.o = j;
        this.l = true;
        if (j == 0) {
            a(null);
        }
    }

    public final <E extends IOException> E a(E e) {
        if (this.m) {
            return e;
        }
        this.m = true;
        if (e == null && this.l) {
            this.l = false;
            c cVar = this.p;
            t tVar = cVar.d;
            e eVar = cVar.c;
            Objects.requireNonNull(tVar);
            d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        }
        return (E) this.p.a(this.k, true, false, e);
    }

    @Override // g0.j, g0.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.n) {
            return;
        }
        this.n = true;
        try {
            this.j.close();
            a(null);
        } catch (IOException e) {
            throw a(e);
        }
    }

    @Override // g0.x
    public long i0(g0.e eVar, long j) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
        if (!(!this.n)) {
            throw new IllegalStateException("closed".toString());
        }
        try {
            long jI0 = this.j.i0(eVar, j);
            if (this.l) {
                this.l = false;
                c cVar = this.p;
                t tVar = cVar.d;
                e eVar2 = cVar.c;
                Objects.requireNonNull(tVar);
                d0.z.d.m.checkParameterIsNotNull(eVar2, NotificationCompat.CATEGORY_CALL);
            }
            if (jI0 == -1) {
                a(null);
                return -1L;
            }
            long j2 = this.k + jI0;
            long j3 = this.o;
            if (j3 != -1 && j2 > j3) {
                throw new ProtocolException("expected " + this.o + " bytes but received " + j2);
            }
            this.k = j2;
            if (j2 == j3) {
                a(null);
            }
            return jI0;
        } catch (IOException e) {
            throw a(e);
        }
    }
}
