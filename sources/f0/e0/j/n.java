package f0.e0.j;

import g0.v;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.internal.http2.StreamResetException;

/* JADX INFO: compiled from: Http2Stream.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3644b;
    public long c;
    public long d;
    public final ArrayDeque<Headers> e;
    public boolean f;
    public final n$b g;
    public final n$a h;
    public final n$c i;
    public final n$c j;
    public a k;
    public IOException l;
    public final int m;
    public final e n;

    public n(int i, e eVar, boolean z2, boolean z3, Headers headers) {
        d0.z.d.m.checkParameterIsNotNull(eVar, "connection");
        this.m = i;
        this.n = eVar;
        this.d = eVar.E.a();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.e = arrayDeque;
        this.g = new n$b(this, eVar.D.a(), z3);
        this.h = new n$a(this, z2);
        this.i = new n$c(this);
        this.j = new n$c(this);
        if (headers == null) {
            if (!h()) {
                throw new IllegalStateException("remotely-initiated streams should have headers".toString());
            }
        } else {
            if (!(!h())) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            arrayDeque.add(headers);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0019  */
    public final void a() throws IOException {
        boolean z2;
        boolean zI;
        byte[] bArr = f0.e0.c.a;
        synchronized (this) {
            n$b n_b = this.g;
            if (n_b.n || !n_b.l) {
                z2 = false;
            } else {
                n$a n_a = this.h;
                if (n_a.l || n_a.k) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            zI = i();
        }
        if (z2) {
            c(a.CANCEL, null);
        } else {
            if (zI) {
                return;
            }
            this.n.d(this.m);
        }
    }

    public final void b() throws IOException {
        n$a n_a = this.h;
        if (n_a.k) {
            throw new IOException("stream closed");
        }
        if (n_a.l) {
            throw new IOException("stream finished");
        }
        if (this.k != null) {
            IOException iOException = this.l;
            if (iOException != null) {
                throw iOException;
            }
            a aVar = this.k;
            if (aVar == null) {
                d0.z.d.m.throwNpe();
            }
            throw new StreamResetException(aVar);
        }
    }

    public final void c(a aVar, IOException iOException) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(aVar, "rstStatusCode");
        if (d(aVar, iOException)) {
            e eVar = this.n;
            int i = this.m;
            Objects.requireNonNull(eVar);
            d0.z.d.m.checkParameterIsNotNull(aVar, "statusCode");
            eVar.K.n(i, aVar);
        }
    }

    public final boolean d(a aVar, IOException iOException) {
        byte[] bArr = f0.e0.c.a;
        synchronized (this) {
            if (this.k != null) {
                return false;
            }
            if (this.g.n && this.h.l) {
                return false;
            }
            this.k = aVar;
            this.l = iOException;
            notifyAll();
            this.n.d(this.m);
            return true;
        }
    }

    public final void e(a aVar) {
        d0.z.d.m.checkParameterIsNotNull(aVar, "errorCode");
        if (d(aVar, null)) {
            this.n.s(this.m, aVar);
        }
    }

    public final synchronized a f() {
        return this.k;
    }

    public final v g() {
        synchronized (this) {
            if (!(this.f || h())) {
                throw new IllegalStateException("reply before requesting the sink".toString());
            }
        }
        return this.h;
    }

    public final boolean h() {
        return this.n.l == ((this.m & 1) == 1);
    }

    public final synchronized boolean i() {
        if (this.k != null) {
            return false;
        }
        n$b n_b = this.g;
        if (n_b.n || n_b.l) {
            n$a n_a = this.h;
            if ((n_a.l || n_a.k) && this.f) {
                return false;
            }
        }
        return true;
    }

    public final void j(Headers headers, boolean z2) {
        boolean zI;
        d0.z.d.m.checkParameterIsNotNull(headers, "headers");
        byte[] bArr = f0.e0.c.a;
        synchronized (this) {
            if (this.f && z2) {
                Objects.requireNonNull(this.g);
            } else {
                this.f = true;
                this.e.add(headers);
            }
            if (z2) {
                this.g.n = true;
            }
            zI = i();
            notifyAll();
        }
        if (zI) {
            return;
        }
        this.n.d(this.m);
    }

    public final synchronized void k(a aVar) {
        d0.z.d.m.checkParameterIsNotNull(aVar, "errorCode");
        if (this.k == null) {
            this.k = aVar;
            notifyAll();
        }
    }

    public final void l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
}
