package f0;

import f0.e0.k.h$a;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Request$a;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/* JADX INFO: compiled from: OkHttpClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public class x implements Cloneable, e$a {
    public final SocketFactory A;
    public final SSLSocketFactory B;
    public final X509TrustManager C;
    public final List<m> D;
    public final List<y> E;
    public final HostnameVerifier F;
    public final g G;
    public final f0.e0.m.c H;
    public final int I;
    public final int J;
    public final int K;
    public final int L;
    public final int M;
    public final long N;
    public final f0.e0.g.l O;
    public final q m;
    public final l n;
    public final List<Interceptor> o;
    public final List<Interceptor> p;
    public final t$b q;
    public final boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c f3683s;
    public final boolean t;
    public final boolean u;
    public final p v;
    public final s w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Proxy f3684x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ProxySelector f3685y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c f3686z;
    public static final x$b l = new x$b(null);
    public static final List<y> j = f0.e0.c.m(y.HTTP_2, y.HTTP_1_1);
    public static final List<m> k = f0.e0.c.m(m.c, m.d);

    public x(x$a x_a) throws NoSuchAlgorithmException, KeyStoreException {
        ProxySelector proxySelector;
        boolean z2;
        boolean z3;
        d0.z.d.m.checkParameterIsNotNull(x_a, "builder");
        this.m = x_a.a;
        this.n = x_a.f3687b;
        this.o = f0.e0.c.z(x_a.c);
        this.p = f0.e0.c.z(x_a.d);
        this.q = x_a.e;
        this.r = x_a.f;
        this.f3683s = x_a.g;
        this.t = x_a.h;
        this.u = x_a.i;
        this.v = x_a.j;
        this.w = x_a.k;
        Proxy proxy = x_a.l;
        this.f3684x = proxy;
        if (proxy != null) {
            proxySelector = f0.e0.l.a.a;
        } else {
            proxySelector = x_a.m;
            proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
            if (proxySelector == null) {
                proxySelector = f0.e0.l.a.a;
            }
        }
        this.f3685y = proxySelector;
        this.f3686z = x_a.n;
        this.A = x_a.o;
        List<m> list = x_a.r;
        this.D = list;
        this.E = x_a.f3688s;
        this.F = x_a.t;
        this.I = x_a.w;
        this.J = x_a.f3689x;
        this.K = x_a.f3690y;
        this.L = x_a.f3691z;
        this.M = x_a.A;
        this.N = x_a.B;
        f0.e0.g.l lVar = x_a.C;
        this.O = lVar == null ? new f0.e0.g.l() : lVar;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                } else if (((m) it.next()).e) {
                    z2 = false;
                    break;
                }
            }
        } else {
            z2 = true;
            break;
        }
        if (z2) {
            this.B = null;
            this.H = null;
            this.C = null;
            this.G = g.a;
        } else {
            SSLSocketFactory sSLSocketFactory = x_a.p;
            if (sSLSocketFactory != null) {
                this.B = sSLSocketFactory;
                f0.e0.m.c cVar = x_a.v;
                if (cVar == null) {
                    d0.z.d.m.throwNpe();
                }
                this.H = cVar;
                X509TrustManager x509TrustManager = x_a.q;
                if (x509TrustManager == null) {
                    d0.z.d.m.throwNpe();
                }
                this.C = x509TrustManager;
                g gVar = x_a.u;
                if (cVar == null) {
                    d0.z.d.m.throwNpe();
                }
                this.G = gVar.b(cVar);
            } else {
                h$a h_a = f0.e0.k.h.c;
                X509TrustManager x509TrustManagerN = f0.e0.k.h.a.n();
                this.C = x509TrustManagerN;
                f0.e0.k.h hVar = f0.e0.k.h.a;
                if (x509TrustManagerN == null) {
                    d0.z.d.m.throwNpe();
                }
                this.B = hVar.m(x509TrustManagerN);
                if (x509TrustManagerN == null) {
                    d0.z.d.m.throwNpe();
                }
                d0.z.d.m.checkParameterIsNotNull(x509TrustManagerN, "trustManager");
                f0.e0.m.c cVarB = f0.e0.k.h.a.b(x509TrustManagerN);
                this.H = cVarB;
                g gVar2 = x_a.u;
                if (cVarB == null) {
                    d0.z.d.m.throwNpe();
                }
                this.G = gVar2.b(cVarB);
            }
        }
        List<Interceptor> list2 = this.o;
        if (list2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!list2.contains(null))) {
            StringBuilder sbU = b.d.b.a.a.U("Null interceptor: ");
            sbU.append(this.o);
            throw new IllegalStateException(sbU.toString().toString());
        }
        List<Interceptor> list3 = this.p;
        if (list3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!list3.contains(null))) {
            StringBuilder sbU2 = b.d.b.a.a.U("Null network interceptor: ");
            sbU2.append(this.p);
            throw new IllegalStateException(sbU2.toString().toString());
        }
        List<m> list4 = this.D;
        if (!(list4 instanceof Collection) || !list4.isEmpty()) {
            Iterator<T> it2 = list4.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z3 = true;
                    break;
                } else if (((m) it2.next()).e) {
                    z3 = false;
                    break;
                }
            }
        } else {
            z3 = true;
            break;
        }
        if (!z3) {
            if (this.B == null) {
                throw new IllegalStateException("sslSocketFactory == null".toString());
            }
            if (this.H == null) {
                throw new IllegalStateException("certificateChainCleaner == null".toString());
            }
            if (this.C == null) {
                throw new IllegalStateException("x509TrustManager == null".toString());
            }
            return;
        }
        if (!(this.B == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.H == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.C == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!d0.z.d.m.areEqual(this.G, g.a)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    @Override // f0.e$a
    public e b(Request request) {
        d0.z.d.m.checkParameterIsNotNull(request, "request");
        return new f0.e0.g.e(this, request, false);
    }

    public Object clone() {
        return super.clone();
    }

    public x$a f() {
        d0.z.d.m.checkParameterIsNotNull(this, "okHttpClient");
        x$a x_a = new x$a();
        x_a.a = this.m;
        x_a.f3687b = this.n;
        d0.t.r.addAll(x_a.c, this.o);
        d0.t.r.addAll(x_a.d, this.p);
        x_a.e = this.q;
        x_a.f = this.r;
        x_a.g = this.f3683s;
        x_a.h = this.t;
        x_a.i = this.u;
        x_a.j = this.v;
        x_a.k = this.w;
        x_a.l = this.f3684x;
        x_a.m = this.f3685y;
        x_a.n = this.f3686z;
        x_a.o = this.A;
        x_a.p = this.B;
        x_a.q = this.C;
        x_a.r = this.D;
        x_a.f3688s = this.E;
        x_a.t = this.F;
        x_a.u = this.G;
        x_a.v = this.H;
        x_a.w = this.I;
        x_a.f3689x = this.J;
        x_a.f3690y = this.K;
        x_a.f3691z = this.L;
        x_a.A = this.M;
        x_a.B = this.N;
        x_a.C = this.O;
        return x_a;
    }

    public WebSocket g(Request request, WebSocketListener webSocketListener) {
        d0.z.d.m.checkParameterIsNotNull(request, "request");
        d0.z.d.m.checkParameterIsNotNull(webSocketListener, "listener");
        f0.e0.n.d dVar = new f0.e0.n.d(f0.e0.f.d.a, request, webSocketListener, new Random(), this.M, null, this.N);
        d0.z.d.m.checkParameterIsNotNull(this, "client");
        if (dVar.u.b("Sec-WebSocket-Extensions") != null) {
            dVar.i(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
        } else {
            x$a x_aF = f();
            t tVar = t.a;
            d0.z.d.m.checkParameterIsNotNull(tVar, "eventListener");
            byte[] bArr = f0.e0.c.a;
            d0.z.d.m.checkParameterIsNotNull(tVar, "$this$asFactory");
            x_aF.e = new f0.e0.a(tVar);
            List<y> list = f0.e0.n.d.a;
            d0.z.d.m.checkParameterIsNotNull(list, "protocols");
            List mutableList = d0.t.u.toMutableList((Collection) list);
            y yVar = y.H2_PRIOR_KNOWLEDGE;
            if (!(mutableList.contains(yVar) || mutableList.contains(y.HTTP_1_1))) {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + mutableList).toString());
            }
            if (!(!mutableList.contains(yVar) || mutableList.size() <= 1)) {
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + mutableList).toString());
            }
            if (!(!mutableList.contains(y.HTTP_1_0))) {
                throw new IllegalArgumentException(("protocols must not contain http/1.0: " + mutableList).toString());
            }
            if (!(!mutableList.contains(null))) {
                throw new IllegalArgumentException("protocols must not contain null".toString());
            }
            mutableList.remove(y.SPDY_3);
            if (!d0.z.d.m.areEqual(mutableList, x_aF.f3688s)) {
                x_aF.C = null;
            }
            List<? extends y> listUnmodifiableList = Collections.unmodifiableList(mutableList);
            d0.z.d.m.checkExpressionValueIsNotNull(listUnmodifiableList, "Collections.unmodifiableList(protocolsCopy)");
            x_aF.f3688s = listUnmodifiableList;
            x xVar = new x(x_aF);
            Request$a request$a = new Request$a(dVar.u);
            request$a.b("Upgrade", "websocket");
            request$a.b("Connection", "Upgrade");
            request$a.b("Sec-WebSocket-Key", dVar.f3656b);
            request$a.b("Sec-WebSocket-Version", "13");
            request$a.b("Sec-WebSocket-Extensions", "permessage-deflate");
            Request requestA = request$a.a();
            f0.e0.g.e eVar = new f0.e0.g.e(xVar, requestA, true);
            dVar.c = eVar;
            eVar.e(new f0.e0.n.e(dVar, requestA));
        }
        return dVar;
    }

    public x() {
        this(new x$a());
    }
}
