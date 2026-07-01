package f0.e0.g;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.t.MutableCollections;
import d0.z.d.Intrinsics3;
import f0.Call2;
import f0.Callback2;
import f0.Dispatcher2;
import f0.EventListener;
import f0.OkHttpClient;
import f0.e0.Util7;
import f0.e0.e.CacheInterceptor;
import f0.e0.f.TaskQueue2;
import f0.e0.h.BridgeInterceptor;
import f0.e0.h.CallServerInterceptor;
import f0.e0.h.RealInterceptorChain;
import f0.e0.h.RetryAndFollowUpInterceptor;
import f0.e0.k.Platform2;
import g0.AsyncTimeout;
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

/* JADX INFO: renamed from: f0.e0.g.e, reason: use source file name */
/* JADX INFO: compiled from: RealCall.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RealCall implements Call2 {
    public final boolean A;
    public final RealConnectionPool j;
    public final EventListener k;
    public final c l;
    public final AtomicBoolean m;
    public Object n;
    public ExchangeFinder o;
    public RealConnection4 p;
    public boolean q;
    public Exchange r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3616s;
    public boolean t;
    public boolean u;
    public volatile boolean v;
    public volatile Exchange w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile RealConnection4 f3617x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final OkHttpClient f3618y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Request f3619z;

    /* JADX INFO: renamed from: f0.e0.g.e$a */
    /* JADX INFO: compiled from: RealCall.kt */
    public final class a implements Runnable {
        public volatile AtomicInteger j;
        public final Callback2 k;
        public final /* synthetic */ RealCall l;

        public a(RealCall realCall, Callback2 callback2) {
            Intrinsics3.checkParameterIsNotNull(callback2, "responseCallback");
            this.l = realCall;
            this.k = callback2;
            this.j = new AtomicInteger(0);
        }

        public final String a() {
            return this.l.f3619z.url.g;
        }

        @Override // java.lang.Runnable
        public void run() {
            RealCall realCall;
            StringBuilder sbU = outline.U("OkHttp ");
            sbU.append(this.l.f3619z.url.h());
            String string = sbU.toString();
            Thread threadCurrentThread = Thread.currentThread();
            Intrinsics3.checkExpressionValueIsNotNull(threadCurrentThread, "currentThread");
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(string);
            try {
                this.l.l.i();
                boolean z2 = false;
                try {
                    try {
                        try {
                            this.k.a(this.l, this.l.j());
                            realCall = this.l;
                        } catch (IOException e) {
                            e = e;
                            z2 = true;
                            if (z2) {
                                Platform2.a aVar = Platform2.c;
                                Platform2.a.i("Callback failure for " + RealCall.b(this.l), 4, e);
                            } else {
                                this.k.b(this.l, e);
                            }
                            realCall = this.l;
                        } catch (Throwable th) {
                            th = th;
                            z2 = true;
                            this.l.cancel();
                            if (!z2) {
                                IOException iOException = new IOException("canceled due to " + th);
                                iOException.addSuppressed(th);
                                this.k.b(this.l, iOException);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        this.l.f3618y.m.c(this);
                        throw th2;
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th3) {
                    th = th3;
                }
                realCall.f3618y.m.c(this);
                threadCurrentThread.setName(name);
            } catch (Throwable th4) {
                threadCurrentThread.setName(name);
                throw th4;
            }
        }
    }

    /* JADX INFO: renamed from: f0.e0.g.e$b */
    /* JADX INFO: compiled from: RealCall.kt */
    public static final class b extends WeakReference<RealCall> {
        public final Object a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RealCall realCall, Object obj) {
            super(realCall);
            Intrinsics3.checkParameterIsNotNull(realCall, "referent");
            this.a = obj;
        }
    }

    /* JADX INFO: renamed from: f0.e0.g.e$c */
    /* JADX INFO: compiled from: RealCall.kt */
    public static final class c extends AsyncTimeout {
        public c() {
        }

        @Override // g0.AsyncTimeout
        public void l() {
            RealCall.this.cancel();
        }
    }

    public RealCall(OkHttpClient okHttpClient, Request request, boolean z2) {
        Intrinsics3.checkParameterIsNotNull(okHttpClient, "client");
        Intrinsics3.checkParameterIsNotNull(request, "originalRequest");
        this.f3618y = okHttpClient;
        this.f3619z = request;
        this.A = z2;
        this.j = okHttpClient.n.a;
        this.k = okHttpClient.q.a(this);
        c cVar = new c();
        cVar.g(okHttpClient.I, TimeUnit.MILLISECONDS);
        this.l = cVar;
        this.m = new AtomicBoolean();
        this.u = true;
    }

    public static final String b(RealCall realCall) {
        StringBuilder sb = new StringBuilder();
        sb.append(realCall.v ? "canceled " : "");
        sb.append(realCall.A ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(realCall.f3619z.url.h());
        return sb.toString();
    }

    @Override // f0.Call2
    public Request c() {
        return this.f3619z;
    }

    @Override // f0.Call2
    public void cancel() {
        Socket socket;
        if (this.v) {
            return;
        }
        this.v = true;
        Exchange exchange = this.w;
        if (exchange != null) {
            exchange.f.cancel();
        }
        RealConnection4 realConnection4 = this.f3617x;
        if (realConnection4 != null && (socket = realConnection4.f3620b) != null) {
            Util7.e(socket);
        }
        Objects.requireNonNull(this.k);
        Intrinsics3.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
    }

    public Object clone() {
        return new RealCall(this.f3618y, this.f3619z, this.A);
    }

    @Override // f0.Call2
    public boolean d() {
        return this.v;
    }

    @Override // f0.Call2
    public void e(Callback2 callback2) {
        a next;
        Intrinsics3.checkParameterIsNotNull(callback2, "responseCallback");
        if (!this.m.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        h();
        Dispatcher2 dispatcher2 = this.f3618y.m;
        a aVar = new a(this, callback2);
        Objects.requireNonNull(dispatcher2);
        Intrinsics3.checkParameterIsNotNull(aVar, NotificationCompat.CATEGORY_CALL);
        synchronized (dispatcher2) {
            dispatcher2.f3677b.add(aVar);
            if (!aVar.l.A) {
                String strA = aVar.a();
                Iterator<a> it = dispatcher2.c.iterator();
                do {
                    if (!it.hasNext()) {
                        Iterator<a> it2 = dispatcher2.f3677b.iterator();
                        do {
                            if (!it2.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it2.next();
                        } while (!Intrinsics3.areEqual(next.a(), strA));
                    } else {
                        next = it.next();
                    }
                } while (!Intrinsics3.areEqual(next.a(), strA));
                if (next != null) {
                    Intrinsics3.checkParameterIsNotNull(next, "other");
                    aVar.j = next.j;
                }
            }
        }
        dispatcher2.d();
    }

    @Override // f0.Call2
    public Response execute() {
        if (!this.m.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        this.l.i();
        h();
        try {
            Dispatcher2 dispatcher2 = this.f3618y.m;
            synchronized (dispatcher2) {
                Intrinsics3.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
                dispatcher2.d.add(this);
            }
            Response responseJ = j();
            Dispatcher2 dispatcher3 = this.f3618y.m;
            Objects.requireNonNull(dispatcher3);
            Intrinsics3.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
            dispatcher3.b(dispatcher3.d, this);
            return responseJ;
        } catch (Throwable th) {
            Dispatcher2 dispatcher4 = this.f3618y.m;
            Objects.requireNonNull(dispatcher4);
            Intrinsics3.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
            dispatcher4.b(dispatcher4.d, this);
            throw th;
        }
    }

    public final void f(RealConnection4 realConnection4) {
        Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
        byte[] bArr = Util7.a;
        if (!(this.p == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.p = realConnection4;
        realConnection4.o.add(new b(this, this.n));
    }

    public final <E extends IOException> E g(E e) {
        E interruptedIOException;
        Socket socketM;
        byte[] bArr = Util7.a;
        RealConnection4 realConnection4 = this.p;
        if (realConnection4 != null) {
            synchronized (realConnection4) {
                socketM = m();
            }
            if (this.p == null) {
                if (socketM != null) {
                    Util7.e(socketM);
                }
                Objects.requireNonNull(this.k);
                Intrinsics3.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
                Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
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
            EventListener eventListener = this.k;
            if (interruptedIOException == null) {
                Intrinsics3.throwNpe();
            }
            Objects.requireNonNull(eventListener);
            Intrinsics3.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(interruptedIOException, "ioe");
        } else {
            Objects.requireNonNull(this.k);
            Intrinsics3.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
        }
        return interruptedIOException;
    }

    public final void h() {
        Platform2.a aVar = Platform2.c;
        this.n = Platform2.a.g("response.body().close()");
        Objects.requireNonNull(this.k);
        Intrinsics3.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
    }

    public final void i(boolean z2) {
        Exchange exchange;
        synchronized (this) {
            if (!this.u) {
                throw new IllegalStateException("released".toString());
            }
        }
        if (z2 && (exchange = this.w) != null) {
            exchange.f.cancel();
            exchange.c.k(exchange, true, true, null);
        }
        this.r = null;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0095  */
    public final Response j() throws Throwable {
        ArrayList arrayList = new ArrayList();
        MutableCollections.addAll(arrayList, this.f3618y.o);
        arrayList.add(new RetryAndFollowUpInterceptor(this.f3618y));
        arrayList.add(new BridgeInterceptor(this.f3618y.v));
        Objects.requireNonNull(this.f3618y);
        arrayList.add(new CacheInterceptor());
        arrayList.add(ConnectInterceptor.f3612b);
        if (!this.A) {
            MutableCollections.addAll(arrayList, this.f3618y.p);
        }
        arrayList.add(new CallServerInterceptor(this.A));
        Request request = this.f3619z;
        OkHttpClient okHttpClient = this.f3618y;
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this, arrayList, 0, null, request, okHttpClient.J, okHttpClient.K, okHttpClient.L);
        boolean z2 = false;
        try {
            try {
                Response responseA = realInterceptorChain.a(this.f3619z);
                if (!this.v) {
                    l(null);
                    return responseA;
                }
                Intrinsics3.checkParameterIsNotNull(responseA, "$this$closeQuietly");
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
    public final <E extends IOException> E k(Exchange exchange, boolean z2, boolean z3, E e) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Intrinsics3.checkParameterIsNotNull(exchange, "exchange");
        if (!Intrinsics3.areEqual(exchange, this.w)) {
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
            RealConnection4 realConnection4 = this.p;
            if (realConnection4 != null) {
                synchronized (realConnection4) {
                    realConnection4.l++;
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
        RealConnection4 realConnection4 = this.p;
        if (realConnection4 == null) {
            Intrinsics3.throwNpe();
        }
        byte[] bArr = Util7.a;
        List<Reference<RealCall>> list = realConnection4.o;
        Iterator<Reference<RealCall>> it = list.iterator();
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (Intrinsics3.areEqual(it.next().get(), this)) {
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
            realConnection4.p = System.nanoTime();
            RealConnectionPool realConnectionPool = this.j;
            Objects.requireNonNull(realConnectionPool);
            Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
            byte[] bArr2 = Util7.a;
            if (realConnection4.i || realConnectionPool.e == 0) {
                realConnection4.i = true;
                realConnectionPool.d.remove(realConnection4);
                if (realConnectionPool.d.isEmpty()) {
                    realConnectionPool.f3621b.a();
                }
                z2 = true;
            } else {
                TaskQueue2.d(realConnectionPool.f3621b, realConnectionPool.c, 0L, 2);
            }
            if (z2) {
                return realConnection4.n();
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
