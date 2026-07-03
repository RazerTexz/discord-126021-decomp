package p600f0.p601e0.p605g;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.TypeCastException;
import okhttp3.Request;
import okhttp3.Response;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12160r;
import p507d0.p592z.p594d.C12238m;
import p600f0.AbstractC12376t;
import p600f0.C12373q;
import p600f0.C12380x;
import p600f0.InterfaceC12269e;
import p600f0.InterfaceC12361f;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p603e.C12275a;
import p600f0.p601e0.p604f.C12279c;
import p600f0.p601e0.p606h.C12295a;
import p600f0.p601e0.p606h.C12296b;
import p600f0.p601e0.p606h.C12301g;
import p600f0.p601e0.p606h.C12303i;
import p600f0.p601e0.p609k.C12333h;
import p615g0.C12385b;

/* JADX INFO: renamed from: f0.e0.g.e */
/* JADX INFO: compiled from: RealCall.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12285e implements InterfaceC12269e {

    /* JADX INFO: renamed from: A */
    public final boolean f25464A;

    /* JADX INFO: renamed from: j */
    public final C12291k f25465j;

    /* JADX INFO: renamed from: k */
    public final AbstractC12376t f25466k;

    /* JADX INFO: renamed from: l */
    public final c f25467l;

    /* JADX INFO: renamed from: m */
    public final AtomicBoolean f25468m;

    /* JADX INFO: renamed from: n */
    public Object f25469n;

    /* JADX INFO: renamed from: o */
    public C12284d f25470o;

    /* JADX INFO: renamed from: p */
    public C12290j f25471p;

    /* JADX INFO: renamed from: q */
    public boolean f25472q;

    /* JADX INFO: renamed from: r */
    public C12283c f25473r;

    /* JADX INFO: renamed from: s */
    public boolean f25474s;

    /* JADX INFO: renamed from: t */
    public boolean f25475t;

    /* JADX INFO: renamed from: u */
    public boolean f25476u;

    /* JADX INFO: renamed from: v */
    public volatile boolean f25477v;

    /* JADX INFO: renamed from: w */
    public volatile C12283c f25478w;

    /* JADX INFO: renamed from: x */
    public volatile C12290j f25479x;

    /* JADX INFO: renamed from: y */
    public final C12380x f25480y;

    /* JADX INFO: renamed from: z */
    public final Request f25481z;

    /* JADX INFO: renamed from: f0.e0.g.e$a */
    /* JADX INFO: compiled from: RealCall.kt */
    public final class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public volatile AtomicInteger f25482j;

        /* JADX INFO: renamed from: k */
        public final InterfaceC12361f f25483k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ C12285e f25484l;

        public a(C12285e c12285e, InterfaceC12361f interfaceC12361f) {
            C12238m.checkParameterIsNotNull(interfaceC12361f, "responseCallback");
            this.f25484l = c12285e;
            this.f25483k = interfaceC12361f;
            this.f25482j = new AtomicInteger(0);
        }

        /* JADX INFO: renamed from: a */
        public final String m10190a() {
            return this.f25484l.f25481z.url.f25979g;
        }

        @Override // java.lang.Runnable
        public void run() {
            C12285e c12285e;
            StringBuilder sbM833U = C1643a.m833U("OkHttp ");
            sbM833U.append(this.f25484l.f25481z.url.m10406h());
            String string = sbM833U.toString();
            Thread threadCurrentThread = Thread.currentThread();
            C12238m.checkExpressionValueIsNotNull(threadCurrentThread, "currentThread");
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(string);
            try {
                this.f25484l.f25467l.m10424i();
                boolean z2 = false;
                try {
                    try {
                        try {
                            this.f25483k.mo10358a(this.f25484l, this.f25484l.m10185j());
                            c12285e = this.f25484l;
                        } catch (IOException e) {
                            e = e;
                            z2 = true;
                            if (z2) {
                                C12333h.a aVar = C12333h.f25785c;
                                C12333h.f25783a.m10330i("Callback failure for " + C12285e.m10180b(this.f25484l), 4, e);
                            } else {
                                this.f25483k.mo10359b(this.f25484l, e);
                            }
                            c12285e = this.f25484l;
                        } catch (Throwable th) {
                            th = th;
                            z2 = true;
                            this.f25484l.cancel();
                            if (!z2) {
                                IOException iOException = new IOException("canceled due to " + th);
                                iOException.addSuppressed(th);
                                this.f25483k.mo10359b(this.f25484l, iOException);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        this.f25484l.f25480y.f26012m.m10390c(this);
                        throw th2;
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th3) {
                    th = th3;
                }
                c12285e.f25480y.f26012m.m10390c(this);
                threadCurrentThread.setName(name);
            } catch (Throwable th4) {
                threadCurrentThread.setName(name);
                throw th4;
            }
        }
    }

    /* JADX INFO: renamed from: f0.e0.g.e$b */
    /* JADX INFO: compiled from: RealCall.kt */
    public static final class b extends WeakReference<C12285e> {

        /* JADX INFO: renamed from: a */
        public final Object f25485a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C12285e c12285e, Object obj) {
            super(c12285e);
            C12238m.checkParameterIsNotNull(c12285e, "referent");
            this.f25485a = obj;
        }
    }

    /* JADX INFO: renamed from: f0.e0.g.e$c */
    /* JADX INFO: compiled from: RealCall.kt */
    public static final class c extends C12385b {
        public c() {
        }

        @Override // p615g0.C12385b
        /* JADX INFO: renamed from: l */
        public void mo10191l() {
            C12285e.this.cancel();
        }
    }

    public C12285e(C12380x c12380x, Request request, boolean z2) {
        C12238m.checkParameterIsNotNull(c12380x, "client");
        C12238m.checkParameterIsNotNull(request, "originalRequest");
        this.f25480y = c12380x;
        this.f25481z = request;
        this.f25464A = z2;
        this.f25465j = c12380x.f26013n.f25929a;
        this.f25466k = c12380x.f26016q.mo10115a(this);
        c cVar = new c();
        cVar.mo10484g(c12380x.f26005I, TimeUnit.MILLISECONDS);
        this.f25467l = cVar;
        this.f25468m = new AtomicBoolean();
        this.f25476u = true;
    }

    /* JADX INFO: renamed from: b */
    public static final String m10180b(C12285e c12285e) {
        StringBuilder sb = new StringBuilder();
        sb.append(c12285e.f25477v ? "canceled " : "");
        sb.append(c12285e.f25464A ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(c12285e.f25481z.url.m10406h());
        return sb.toString();
    }

    @Override // p600f0.InterfaceC12269e
    /* JADX INFO: renamed from: c */
    public Request mo10111c() {
        return this.f25481z;
    }

    @Override // p600f0.InterfaceC12269e
    public void cancel() {
        Socket socket;
        if (this.f25477v) {
            return;
        }
        this.f25477v = true;
        C12283c c12283c = this.f25478w;
        if (c12283c != null) {
            c12283c.f25442f.cancel();
        }
        C12290j c12290j = this.f25479x;
        if (c12290j != null && (socket = c12290j.f25491b) != null) {
            C12272c.m10124e(socket);
        }
        Objects.requireNonNull(this.f25466k);
        C12238m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
    }

    public Object clone() {
        return new C12285e(this.f25480y, this.f25481z, this.f25464A);
    }

    @Override // p600f0.InterfaceC12269e
    /* JADX INFO: renamed from: d */
    public boolean mo10112d() {
        return this.f25477v;
    }

    @Override // p600f0.InterfaceC12269e
    /* JADX INFO: renamed from: e */
    public void mo10113e(InterfaceC12361f interfaceC12361f) {
        a next;
        C12238m.checkParameterIsNotNull(interfaceC12361f, "responseCallback");
        if (!this.f25468m.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        m10183h();
        C12373q c12373q = this.f25480y.f26012m;
        a aVar = new a(this, interfaceC12361f);
        Objects.requireNonNull(c12373q);
        C12238m.checkParameterIsNotNull(aVar, NotificationCompat.CATEGORY_CALL);
        synchronized (c12373q) {
            c12373q.f25958b.add(aVar);
            if (!aVar.f25484l.f25464A) {
                String strM10190a = aVar.m10190a();
                Iterator<a> it = c12373q.f25959c.iterator();
                do {
                    if (!it.hasNext()) {
                        Iterator<a> it2 = c12373q.f25958b.iterator();
                        do {
                            if (!it2.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it2.next();
                        } while (!C12238m.areEqual(next.m10190a(), strM10190a));
                    } else {
                        next = it.next();
                    }
                } while (!C12238m.areEqual(next.m10190a(), strM10190a));
                if (next != null) {
                    C12238m.checkParameterIsNotNull(next, "other");
                    aVar.f25482j = next.f25482j;
                }
            }
        }
        c12373q.m10391d();
    }

    @Override // p600f0.InterfaceC12269e
    public Response execute() {
        if (!this.f25468m.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        this.f25467l.m10424i();
        m10183h();
        try {
            C12373q c12373q = this.f25480y.f26012m;
            synchronized (c12373q) {
                C12238m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
                c12373q.f25960d.add(this);
            }
            Response responseM10185j = m10185j();
            C12373q c12373q2 = this.f25480y.f26012m;
            Objects.requireNonNull(c12373q2);
            C12238m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
            c12373q2.m10389b(c12373q2.f25960d, this);
            return responseM10185j;
        } catch (Throwable th) {
            C12373q c12373q3 = this.f25480y.f26012m;
            Objects.requireNonNull(c12373q3);
            C12238m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
            c12373q3.m10389b(c12373q3.f25960d, this);
            throw th;
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m10181f(C12290j c12290j) {
        C12238m.checkParameterIsNotNull(c12290j, "connection");
        byte[] bArr = C12272c.f25397a;
        if (!(this.f25471p == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f25471p = c12290j;
        c12290j.f25504o.add(new b(this, this.f25469n));
    }

    /* JADX INFO: renamed from: g */
    public final <E extends IOException> E m10182g(E e) {
        E interruptedIOException;
        Socket socketM10188m;
        byte[] bArr = C12272c.f25397a;
        C12290j c12290j = this.f25471p;
        if (c12290j != null) {
            synchronized (c12290j) {
                socketM10188m = m10188m();
            }
            if (this.f25471p == null) {
                if (socketM10188m != null) {
                    C12272c.m10124e(socketM10188m);
                }
                Objects.requireNonNull(this.f25466k);
                C12238m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
                C12238m.checkParameterIsNotNull(c12290j, "connection");
            } else {
                if (!(socketM10188m == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        if (!this.f25472q && this.f25467l.m10425j()) {
            interruptedIOException = new InterruptedIOException("timeout");
            if (e != null) {
                interruptedIOException.initCause(e);
            }
        } else {
            interruptedIOException = e;
        }
        if (e != null) {
            AbstractC12376t abstractC12376t = this.f25466k;
            if (interruptedIOException == null) {
                C12238m.throwNpe();
            }
            Objects.requireNonNull(abstractC12376t);
            C12238m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
            C12238m.checkParameterIsNotNull(interruptedIOException, "ioe");
        } else {
            Objects.requireNonNull(this.f25466k);
            C12238m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
        }
        return interruptedIOException;
    }

    /* JADX INFO: renamed from: h */
    public final void m10183h() {
        C12333h.a aVar = C12333h.f25785c;
        this.f25469n = C12333h.f25783a.mo10321g("response.body().close()");
        Objects.requireNonNull(this.f25466k);
        C12238m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
    }

    /* JADX INFO: renamed from: i */
    public final void m10184i(boolean z2) {
        C12283c c12283c;
        synchronized (this) {
            if (!this.f25476u) {
                throw new IllegalStateException("released".toString());
            }
        }
        if (z2 && (c12283c = this.f25478w) != null) {
            c12283c.f25442f.cancel();
            c12283c.f25439c.m10186k(c12283c, true, true, null);
        }
        this.f25473r = null;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0095  */
    /* JADX INFO: renamed from: j */
    public final Response m10185j() throws Throwable {
        ArrayList arrayList = new ArrayList();
        C12160r.addAll(arrayList, this.f25480y.f26014o);
        arrayList.add(new C12303i(this.f25480y));
        arrayList.add(new C12295a(this.f25480y.f26021v));
        Objects.requireNonNull(this.f25480y);
        arrayList.add(new C12275a());
        arrayList.add(C12281a.f25432b);
        if (!this.f25464A) {
            C12160r.addAll(arrayList, this.f25480y.f26015p);
        }
        arrayList.add(new C12296b(this.f25464A));
        Request request = this.f25481z;
        C12380x c12380x = this.f25480y;
        C12301g c12301g = new C12301g(this, arrayList, 0, null, request, c12380x.f26006J, c12380x.f26007K, c12380x.f26008L);
        boolean z2 = false;
        try {
            try {
                Response responseMo10228a = c12301g.mo10228a(this.f25481z);
                if (!this.f25477v) {
                    m10187l(null);
                    return responseMo10228a;
                }
                C12238m.checkParameterIsNotNull(responseMo10228a, "$this$closeQuietly");
                try {
                    responseMo10228a.close();
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused) {
                }
                throw new IOException("Canceled");
            } catch (IOException e2) {
                try {
                    IOException iOExceptionM10187l = m10187l(e2);
                    if (iOExceptionM10187l == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                    throw iOExceptionM10187l;
                } catch (Throwable th) {
                    th = th;
                    z2 = true;
                    if (!z2) {
                        m10187l(null);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (!z2) {
                m10187l(null);
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0021 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0023 A[Catch: all -> 0x0019, TryCatch #1 {all -> 0x0019, blocks: (B:8:0x0014, B:17:0x0023, B:19:0x0027, B:20:0x0029, B:22:0x002d, B:27:0x0036, B:29:0x003a, B:14:0x001d), top: B:53:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0027 A[Catch: all -> 0x0019, TryCatch #1 {all -> 0x0019, blocks: (B:8:0x0014, B:17:0x0023, B:19:0x0027, B:20:0x0029, B:22:0x002d, B:27:0x0036, B:29:0x003a, B:14:0x001d), top: B:53:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0033  */
    /* JADX INFO: renamed from: k */
    public final <E extends IOException> E m10186k(C12283c c12283c, boolean z2, boolean z3, E e) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        C12238m.checkParameterIsNotNull(c12283c, "exchange");
        if (!C12238m.areEqual(c12283c, this.f25478w)) {
            return e;
        }
        synchronized (this) {
            z4 = false;
            if (z2) {
                try {
                    if (this.f25474s) {
                        if (z2) {
                            this.f25474s = false;
                        }
                        if (z3) {
                            this.f25475t = false;
                        }
                        z6 = this.f25474s;
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
                    } else if (z3 || !this.f25475t) {
                        z5 = false;
                    } else {
                        if (z2) {
                            this.f25474s = false;
                        }
                        if (z3) {
                            this.f25475t = false;
                        }
                        z6 = this.f25474s;
                        if (z6 || this.f25475t) {
                            z7 = false;
                        } else {
                            z7 = true;
                        }
                        if (!z6 && !this.f25475t && !this.f25476u) {
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
            this.f25478w = null;
            C12290j c12290j = this.f25471p;
            if (c12290j != null) {
                synchronized (c12290j) {
                    c12290j.f25501l++;
                }
            }
        }
        return z5 ? (E) m10182g(e) : e;
    }

    /* JADX INFO: renamed from: l */
    public final IOException m10187l(IOException iOException) {
        boolean z2;
        synchronized (this) {
            z2 = false;
            if (this.f25476u) {
                this.f25476u = false;
                if (!this.f25474s && !this.f25475t) {
                    z2 = true;
                }
            }
        }
        return z2 ? m10182g(iOException) : iOException;
    }

    /* JADX INFO: renamed from: m */
    public final Socket m10188m() {
        C12290j c12290j = this.f25471p;
        if (c12290j == null) {
            C12238m.throwNpe();
        }
        byte[] bArr = C12272c.f25397a;
        List<Reference<C12285e>> list = c12290j.f25504o;
        Iterator<Reference<C12285e>> it = list.iterator();
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (C12238m.areEqual(it.next().get(), this)) {
                break;
            }
            i++;
        }
        if (!(i != -1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        list.remove(i);
        this.f25471p = null;
        if (list.isEmpty()) {
            c12290j.f25505p = System.nanoTime();
            C12291k c12291k = this.f25465j;
            Objects.requireNonNull(c12291k);
            C12238m.checkParameterIsNotNull(c12290j, "connection");
            byte[] bArr2 = C12272c.f25397a;
            if (c12290j.f25498i || c12291k.f25511e == 0) {
                c12290j.f25498i = true;
                c12291k.f25510d.remove(c12290j);
                if (c12291k.f25510d.isEmpty()) {
                    c12291k.f25508b.m10152a();
                }
                z2 = true;
            } else {
                C12279c.m10151d(c12291k.f25508b, c12291k.f25509c, 0L, 2);
            }
            if (z2) {
                return c12290j.m10205n();
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: n */
    public final void m10189n() {
        if (!(!this.f25472q)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f25472q = true;
        this.f25467l.m10425j();
    }
}
