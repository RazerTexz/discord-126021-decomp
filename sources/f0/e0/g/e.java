package f0.e0.g;

import androidx.core.app.NotificationCompat;
import d0.t.r;
import f0.e0.k.h$a;
import f0.q;
import f0.t;
import f0.x;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.TypeCastException;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: RealCall.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements f0.e {
    public final boolean A;
    public final k j;
    public final t k;
    public final e$c l;
    public final AtomicBoolean m;
    public Object n;
    public d o;
    public j p;
    public boolean q;
    public c r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3616s;
    public boolean t;
    public boolean u;
    public volatile boolean v;
    public volatile c w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile j f3617x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final x f3618y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Request f3619z;

    public e(x xVar, Request request, boolean z2) {
        d0.z.d.m.checkParameterIsNotNull(xVar, "client");
        d0.z.d.m.checkParameterIsNotNull(request, "originalRequest");
        this.f3618y = xVar;
        this.f3619z = request;
        this.A = z2;
        this.j = xVar.n.a;
        this.k = xVar.q.a(this);
        e$c e_c = new e$c(this);
        e_c.g(xVar.I, TimeUnit.MILLISECONDS);
        this.l = e_c;
        this.m = new AtomicBoolean();
        this.u = true;
    }

    public static final String b(e eVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(eVar.v ? "canceled " : "");
        sb.append(eVar.A ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(eVar.f3619z.url.h());
        return sb.toString();
    }

    @Override // f0.e
    public Request c() {
        return this.f3619z;
    }

    @Override // f0.e
    public void cancel() {
        Socket socket;
        if (this.v) {
            return;
        }
        this.v = true;
        c cVar = this.w;
        if (cVar != null) {
            cVar.f.cancel();
        }
        j jVar = this.f3617x;
        if (jVar != null && (socket = jVar.f3620b) != null) {
            f0.e0.c.e(socket);
        }
        Objects.requireNonNull(this.k);
        d0.z.d.m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
    }

    public Object clone() {
        return new e(this.f3618y, this.f3619z, this.A);
    }

    @Override // f0.e
    public boolean d() {
        return this.v;
    }

    @Override // f0.e
    public void e(f0.f fVar) {
        e$a next;
        d0.z.d.m.checkParameterIsNotNull(fVar, "responseCallback");
        if (!this.m.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        h();
        q qVar = this.f3618y.m;
        e$a e_a = new e$a(this, fVar);
        Objects.requireNonNull(qVar);
        d0.z.d.m.checkParameterIsNotNull(e_a, NotificationCompat.CATEGORY_CALL);
        synchronized (qVar) {
            qVar.f3677b.add(e_a);
            if (!e_a.l.A) {
                String strA = e_a.a();
                Iterator<e$a> it = qVar.c.iterator();
                do {
                    if (!it.hasNext()) {
                        Iterator<e$a> it2 = qVar.f3677b.iterator();
                        do {
                            if (!it2.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it2.next();
                        } while (!d0.z.d.m.areEqual(next.a(), strA));
                    } else {
                        next = it.next();
                    }
                } while (!d0.z.d.m.areEqual(next.a(), strA));
                if (next != null) {
                    d0.z.d.m.checkParameterIsNotNull(next, "other");
                    e_a.j = next.j;
                }
            }
        }
        qVar.d();
    }

    @Override // f0.e
    public Response execute() {
        if (!this.m.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        this.l.i();
        h();
        try {
            q qVar = this.f3618y.m;
            synchronized (qVar) {
                d0.z.d.m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
                qVar.d.add(this);
            }
            Response responseJ = j();
            q qVar2 = this.f3618y.m;
            Objects.requireNonNull(qVar2);
            d0.z.d.m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
            qVar2.b(qVar2.d, this);
            return responseJ;
        } catch (Throwable th) {
            q qVar3 = this.f3618y.m;
            Objects.requireNonNull(qVar3);
            d0.z.d.m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
            qVar3.b(qVar3.d, this);
            throw th;
        }
    }

    public final void f(j jVar) {
        d0.z.d.m.checkParameterIsNotNull(jVar, "connection");
        byte[] bArr = f0.e0.c.a;
        if (!(this.p == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.p = jVar;
        jVar.o.add(new e$b(this, this.n));
    }

    public final <E extends IOException> E g(E e) {
        E interruptedIOException;
        Socket socketM;
        byte[] bArr = f0.e0.c.a;
        j jVar = this.p;
        if (jVar != null) {
            synchronized (jVar) {
                socketM = m();
            }
            if (this.p == null) {
                if (socketM != null) {
                    f0.e0.c.e(socketM);
                }
                Objects.requireNonNull(this.k);
                d0.z.d.m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
                d0.z.d.m.checkParameterIsNotNull(jVar, "connection");
            } else {
                if (!(socketM == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        if (!this.q && this.l.j()) {
            interruptedIOException = new InterruptedIOException("timeout");
            if (e != null) {
                interruptedIOException.initCause(e);
            }
        } else {
            interruptedIOException = e;
        }
        if (e != null) {
            t tVar = this.k;
            if (interruptedIOException == null) {
                d0.z.d.m.throwNpe();
            }
            Objects.requireNonNull(tVar);
            d0.z.d.m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
            d0.z.d.m.checkParameterIsNotNull(interruptedIOException, "ioe");
        } else {
            Objects.requireNonNull(this.k);
            d0.z.d.m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
        }
        return interruptedIOException;
    }

    public final void h() {
        h$a h_a = f0.e0.k.h.c;
        this.n = f0.e0.k.h.a.g("response.body().close()");
        Objects.requireNonNull(this.k);
        d0.z.d.m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
    }

    public final void i(boolean z2) {
        c cVar;
        synchronized (this) {
            if (!this.u) {
                throw new IllegalStateException("released".toString());
            }
        }
        if (z2 && (cVar = this.w) != null) {
            cVar.f.cancel();
            cVar.c.k(cVar, true, true, null);
        }
        this.r = null;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0095  */
    public final Response j() throws Throwable {
        ArrayList arrayList = new ArrayList();
        r.addAll(arrayList, this.f3618y.o);
        arrayList.add(new f0.e0.h.i(this.f3618y));
        arrayList.add(new f0.e0.h.a(this.f3618y.v));
        Objects.requireNonNull(this.f3618y);
        arrayList.add(new f0.e0.e.a());
        arrayList.add(a.f3612b);
        if (!this.A) {
            r.addAll(arrayList, this.f3618y.p);
        }
        arrayList.add(new f0.e0.h.b(this.A));
        Request request = this.f3619z;
        x xVar = this.f3618y;
        f0.e0.h.g gVar = new f0.e0.h.g(this, arrayList, 0, null, request, xVar.J, xVar.K, xVar.L);
        boolean z2 = false;
        try {
            try {
                Response responseA = gVar.a(this.f3619z);
                if (!this.v) {
                    l(null);
                    return responseA;
                }
                d0.z.d.m.checkParameterIsNotNull(responseA, "$this$closeQuietly");
                try {
                    responseA.close();
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused) {
                }
                throw new IOException("Canceled");
            } catch (IOException e2) {
                try {
                    IOException iOExceptionL = l(e2);
                    if (iOExceptionL == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                    throw iOExceptionL;
                } catch (Throwable th) {
                    th = th;
                    z2 = true;
                    if (!z2) {
                        l(null);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (!z2) {
                l(null);
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0021 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0023 A[Catch: all -> 0x0019, TryCatch #1 {all -> 0x0019, blocks: (B:8:0x0014, B:17:0x0023, B:19:0x0027, B:20:0x0029, B:22:0x002d, B:27:0x0036, B:29:0x003a, B:14:0x001d), top: B:53:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0027 A[Catch: all -> 0x0019, TryCatch #1 {all -> 0x0019, blocks: (B:8:0x0014, B:17:0x0023, B:19:0x0027, B:20:0x0029, B:22:0x002d, B:27:0x0036, B:29:0x003a, B:14:0x001d), top: B:53:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0033  */
    public final <E extends IOException> E k(c cVar, boolean z2, boolean z3, E e) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        d0.z.d.m.checkParameterIsNotNull(cVar, "exchange");
        if (!d0.z.d.m.areEqual(cVar, this.w)) {
            return e;
        }
        synchronized (this) {
            z4 = false;
            if (z2) {
                try {
                    if (this.f3616s) {
                        if (z2) {
                            this.f3616s = false;
                        }
                        if (z3) {
                            this.t = false;
                        }
                        z6 = this.f3616s;
                        if (z6) {
                            z7 = false;
                        } else {
                            z7 = false;
                        }
                        if (!z6) {
                            z4 = true;
                        }
                        z5 = z4;
                        z4 = z7;
                    } else if (z3 || !this.t) {
                        z5 = false;
                    } else {
                        if (z2) {
                            this.f3616s = false;
                        }
                        if (z3) {
                            this.t = false;
                        }
                        z6 = this.f3616s;
                        if (z6 || this.t) {
                            z7 = false;
                        } else {
                            z7 = true;
                        }
                        if (!z6 && !this.t && !this.u) {
                            z4 = true;
                        }
                        z5 = z4;
                        z4 = z7;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                if (z3) {
                }
                z5 = false;
            }
        }
        if (z4) {
            this.w = null;
            j jVar = this.p;
            if (jVar != null) {
                synchronized (jVar) {
                    jVar.l++;
                }
            }
        }
        return z5 ? (E) g(e) : e;
    }

    public final IOException l(IOException iOException) {
        boolean z2;
        synchronized (this) {
            z2 = false;
            if (this.u) {
                this.u = false;
                if (!this.f3616s && !this.t) {
                    z2 = true;
                }
            }
        }
        return z2 ? g(iOException) : iOException;
    }

    public final Socket m() {
        j jVar = this.p;
        if (jVar == null) {
            d0.z.d.m.throwNpe();
        }
        byte[] bArr = f0.e0.c.a;
        List<Reference<e>> list = jVar.o;
        Iterator<Reference<e>> it = list.iterator();
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (d0.z.d.m.areEqual(it.next().get(), this)) {
                break;
            }
            i++;
        }
        if (!(i != -1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        list.remove(i);
        this.p = null;
        if (list.isEmpty()) {
            jVar.p = System.nanoTime();
            k kVar = this.j;
            Objects.requireNonNull(kVar);
            d0.z.d.m.checkParameterIsNotNull(jVar, "connection");
            byte[] bArr2 = f0.e0.c.a;
            if (jVar.i || kVar.e == 0) {
                jVar.i = true;
                kVar.d.remove(jVar);
                if (kVar.d.isEmpty()) {
                    kVar.f3621b.a();
                }
                z2 = true;
            } else {
                f0.e0.f.c.d(kVar.f3621b, kVar.c, 0L, 2);
            }
            if (z2) {
                return jVar.n();
            }
        }
        return null;
    }

    public final void n() {
        if (!(!this.q)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.q = true;
        this.l.j();
    }
}
