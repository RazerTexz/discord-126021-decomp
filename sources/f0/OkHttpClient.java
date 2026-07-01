package f0;

import b.d.b.a.outline;
import com.discord.api.permission.Permission;
import d0.t.MutableCollections;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import f0.Call2;
import f0.EventListener;
import f0.e0.Util5;
import f0.e0.Util7;
import f0.e0.f.TaskRunner;
import f0.e0.g.RealCall;
import f0.e0.g.RouteDatabase;
import f0.e0.k.Platform2;
import f0.e0.l.NullProxySelector;
import f0.e0.m.CertificateChainCleaner;
import f0.e0.m.OkHostnameVerifier;
import f0.e0.n.RealWebSocket;
import f0.e0.n.RealWebSocket2;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/* JADX INFO: renamed from: f0.x, reason: use source file name */
/* JADX INFO: compiled from: OkHttpClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public class OkHttpClient implements Cloneable, Call2.a {
    public final SocketFactory A;
    public final SSLSocketFactory B;
    public final X509TrustManager C;
    public final List<ConnectionSpec> D;
    public final List<Protocol2> E;
    public final HostnameVerifier F;
    public final CertificatePinner G;
    public final CertificateChainCleaner H;
    public final int I;
    public final int J;
    public final int K;
    public final int L;
    public final int M;
    public final long N;
    public final RouteDatabase O;
    public final Dispatcher2 m;
    public final ConnectionPool n;
    public final List<Interceptor> o;
    public final List<Interceptor> p;
    public final EventListener.b q;
    public final boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Authenticator2 f3683s;
    public final boolean t;
    public final boolean u;
    public final CookieJar2 v;
    public final Dns2 w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Proxy f3684x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ProxySelector f3685y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Authenticator2 f3686z;
    public static final b l = new b(null);
    public static final List<Protocol2> j = Util7.m(Protocol2.HTTP_2, Protocol2.HTTP_1_1);
    public static final List<ConnectionSpec> k = Util7.m(ConnectionSpec.c, ConnectionSpec.d);

    /* JADX INFO: renamed from: f0.x$a */
    /* JADX INFO: compiled from: OkHttpClient.kt */
    public static final class a {
        public int A;
        public long B;
        public RouteDatabase C;
        public Dispatcher2 a = new Dispatcher2();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ConnectionPool f3687b = new ConnectionPool();
        public final List<Interceptor> c = new ArrayList();
        public final List<Interceptor> d = new ArrayList();
        public EventListener.b e;
        public boolean f;
        public Authenticator2 g;
        public boolean h;
        public boolean i;
        public CookieJar2 j;
        public Dns2 k;
        public Proxy l;
        public ProxySelector m;
        public Authenticator2 n;
        public SocketFactory o;
        public SSLSocketFactory p;
        public X509TrustManager q;
        public List<ConnectionSpec> r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public List<? extends Protocol2> f3688s;
        public HostnameVerifier t;
        public CertificatePinner u;
        public CertificateChainCleaner v;
        public int w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f3689x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f3690y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f3691z;

        public a() {
            EventListener eventListener = EventListener.a;
            Intrinsics3.checkParameterIsNotNull(eventListener, "$this$asFactory");
            this.e = new Util5(eventListener);
            this.f = true;
            Authenticator2 authenticator2 = Authenticator2.a;
            this.g = authenticator2;
            this.h = true;
            this.i = true;
            this.j = CookieJar2.a;
            this.k = Dns2.a;
            this.n = authenticator2;
            SocketFactory socketFactory = SocketFactory.getDefault();
            Intrinsics3.checkExpressionValueIsNotNull(socketFactory, "SocketFactory.getDefault()");
            this.o = socketFactory;
            b bVar = OkHttpClient.l;
            this.r = OkHttpClient.k;
            this.f3688s = OkHttpClient.j;
            this.t = OkHostnameVerifier.a;
            this.u = CertificatePinner.a;
            this.f3689x = 10000;
            this.f3690y = 10000;
            this.f3691z = 10000;
            this.B = Permission.VIEW_CHANNEL;
        }

        public final a a(long j, TimeUnit timeUnit) {
            Intrinsics3.checkParameterIsNotNull(timeUnit, "unit");
            this.f3690y = Util7.b("timeout", j, timeUnit);
            return this;
        }

        public final a b(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            Intrinsics3.checkParameterIsNotNull(sSLSocketFactory, "sslSocketFactory");
            Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
            if ((!Intrinsics3.areEqual(sSLSocketFactory, this.p)) || (!Intrinsics3.areEqual(x509TrustManager, this.q))) {
                this.C = null;
            }
            this.p = sSLSocketFactory;
            Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
            Platform2.a aVar = Platform2.c;
            this.v = Platform2.a.b(x509TrustManager);
            this.q = x509TrustManager;
            return this;
        }
    }

    /* JADX INFO: renamed from: f0.x$b */
    /* JADX INFO: compiled from: OkHttpClient.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public OkHttpClient(a aVar) throws NoSuchAlgorithmException, KeyStoreException {
        ProxySelector proxySelector;
        boolean z2;
        boolean z3;
        Intrinsics3.checkParameterIsNotNull(aVar, "builder");
        this.m = aVar.a;
        this.n = aVar.f3687b;
        this.o = Util7.z(aVar.c);
        this.p = Util7.z(aVar.d);
        this.q = aVar.e;
        this.r = aVar.f;
        this.f3683s = aVar.g;
        this.t = aVar.h;
        this.u = aVar.i;
        this.v = aVar.j;
        this.w = aVar.k;
        Proxy proxy = aVar.l;
        this.f3684x = proxy;
        if (proxy != null) {
            proxySelector = NullProxySelector.a;
        } else {
            proxySelector = aVar.m;
            proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
            if (proxySelector == null) {
                proxySelector = NullProxySelector.a;
            }
        }
        this.f3685y = proxySelector;
        this.f3686z = aVar.n;
        this.A = aVar.o;
        List<ConnectionSpec> list = aVar.r;
        this.D = list;
        this.E = aVar.f3688s;
        this.F = aVar.t;
        this.I = aVar.w;
        this.J = aVar.f3689x;
        this.K = aVar.f3690y;
        this.L = aVar.f3691z;
        this.M = aVar.A;
        this.N = aVar.B;
        RouteDatabase routeDatabase = aVar.C;
        this.O = routeDatabase == null ? new RouteDatabase() : routeDatabase;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                } else if (((ConnectionSpec) it.next()).e) {
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
            this.G = CertificatePinner.a;
        } else {
            SSLSocketFactory sSLSocketFactory = aVar.p;
            if (sSLSocketFactory != null) {
                this.B = sSLSocketFactory;
                CertificateChainCleaner certificateChainCleaner = aVar.v;
                if (certificateChainCleaner == null) {
                    Intrinsics3.throwNpe();
                }
                this.H = certificateChainCleaner;
                X509TrustManager x509TrustManager = aVar.q;
                if (x509TrustManager == null) {
                    Intrinsics3.throwNpe();
                }
                this.C = x509TrustManager;
                CertificatePinner certificatePinner = aVar.u;
                if (certificateChainCleaner == null) {
                    Intrinsics3.throwNpe();
                }
                this.G = certificatePinner.b(certificateChainCleaner);
            } else {
                Platform2.a aVar2 = Platform2.c;
                X509TrustManager x509TrustManagerN = Platform2.a.n();
                this.C = x509TrustManagerN;
                Platform2 platform2 = Platform2.a;
                if (x509TrustManagerN == null) {
                    Intrinsics3.throwNpe();
                }
                this.B = platform2.m(x509TrustManagerN);
                if (x509TrustManagerN == null) {
                    Intrinsics3.throwNpe();
                }
                Intrinsics3.checkParameterIsNotNull(x509TrustManagerN, "trustManager");
                CertificateChainCleaner certificateChainCleanerB = Platform2.a.b(x509TrustManagerN);
                this.H = certificateChainCleanerB;
                CertificatePinner certificatePinner2 = aVar.u;
                if (certificateChainCleanerB == null) {
                    Intrinsics3.throwNpe();
                }
                this.G = certificatePinner2.b(certificateChainCleanerB);
            }
        }
        List<Interceptor> list2 = this.o;
        if (list2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!list2.contains(null))) {
            StringBuilder sbU = outline.U("Null interceptor: ");
            sbU.append(this.o);
            throw new IllegalStateException(sbU.toString().toString());
        }
        List<Interceptor> list3 = this.p;
        if (list3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!list3.contains(null))) {
            StringBuilder sbU2 = outline.U("Null network interceptor: ");
            sbU2.append(this.p);
            throw new IllegalStateException(sbU2.toString().toString());
        }
        List<ConnectionSpec> list4 = this.D;
        if (!(list4 instanceof Collection) || !list4.isEmpty()) {
            Iterator<T> it2 = list4.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z3 = true;
                    break;
                } else if (((ConnectionSpec) it2.next()).e) {
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
        if (!Intrinsics3.areEqual(this.G, CertificatePinner.a)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    @Override // f0.Call2.a
    public Call2 b(Request request) {
        Intrinsics3.checkParameterIsNotNull(request, "request");
        return new RealCall(this, request, false);
    }

    public Object clone() {
        return super.clone();
    }

    public a f() {
        Intrinsics3.checkParameterIsNotNull(this, "okHttpClient");
        a aVar = new a();
        aVar.a = this.m;
        aVar.f3687b = this.n;
        MutableCollections.addAll(aVar.c, this.o);
        MutableCollections.addAll(aVar.d, this.p);
        aVar.e = this.q;
        aVar.f = this.r;
        aVar.g = this.f3683s;
        aVar.h = this.t;
        aVar.i = this.u;
        aVar.j = this.v;
        aVar.k = this.w;
        aVar.l = this.f3684x;
        aVar.m = this.f3685y;
        aVar.n = this.f3686z;
        aVar.o = this.A;
        aVar.p = this.B;
        aVar.q = this.C;
        aVar.r = this.D;
        aVar.f3688s = this.E;
        aVar.t = this.F;
        aVar.u = this.G;
        aVar.v = this.H;
        aVar.w = this.I;
        aVar.f3689x = this.J;
        aVar.f3690y = this.K;
        aVar.f3691z = this.L;
        aVar.A = this.M;
        aVar.B = this.N;
        aVar.C = this.O;
        return aVar;
    }

    public WebSocket g(Request request, WebSocketListener webSocketListener) {
        Intrinsics3.checkParameterIsNotNull(request, "request");
        Intrinsics3.checkParameterIsNotNull(webSocketListener, "listener");
        RealWebSocket realWebSocket = new RealWebSocket(TaskRunner.a, request, webSocketListener, new Random(), this.M, null, this.N);
        Intrinsics3.checkParameterIsNotNull(this, "client");
        if (realWebSocket.u.b("Sec-WebSocket-Extensions") != null) {
            realWebSocket.i(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
        } else {
            a aVarF = f();
            EventListener eventListener = EventListener.a;
            Intrinsics3.checkParameterIsNotNull(eventListener, "eventListener");
            byte[] bArr = Util7.a;
            Intrinsics3.checkParameterIsNotNull(eventListener, "$this$asFactory");
            aVarF.e = new Util5(eventListener);
            List<Protocol2> list = RealWebSocket.a;
            Intrinsics3.checkParameterIsNotNull(list, "protocols");
            List mutableList = _Collections.toMutableList((Collection) list);
            Protocol2 protocol2 = Protocol2.H2_PRIOR_KNOWLEDGE;
            if (!(mutableList.contains(protocol2) || mutableList.contains(Protocol2.HTTP_1_1))) {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + mutableList).toString());
            }
            if (!(!mutableList.contains(protocol2) || mutableList.size() <= 1)) {
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + mutableList).toString());
            }
            if (!(!mutableList.contains(Protocol2.HTTP_1_0))) {
                throw new IllegalArgumentException(("protocols must not contain http/1.0: " + mutableList).toString());
            }
            if (!(!mutableList.contains(null))) {
                throw new IllegalArgumentException("protocols must not contain null".toString());
            }
            mutableList.remove(Protocol2.SPDY_3);
            if (!Intrinsics3.areEqual(mutableList, aVarF.f3688s)) {
                aVarF.C = null;
            }
            List<? extends Protocol2> listUnmodifiableList = Collections.unmodifiableList(mutableList);
            Intrinsics3.checkExpressionValueIsNotNull(listUnmodifiableList, "Collections.unmodifiableList(protocolsCopy)");
            aVarF.f3688s = listUnmodifiableList;
            OkHttpClient okHttpClient = new OkHttpClient(aVarF);
            Request.a aVar = new Request.a(realWebSocket.u);
            aVar.b("Upgrade", "websocket");
            aVar.b("Connection", "Upgrade");
            aVar.b("Sec-WebSocket-Key", realWebSocket.f3656b);
            aVar.b("Sec-WebSocket-Version", "13");
            aVar.b("Sec-WebSocket-Extensions", "permessage-deflate");
            Request requestA = aVar.a();
            RealCall realCall = new RealCall(okHttpClient, requestA, true);
            realWebSocket.c = realCall;
            realCall.e(new RealWebSocket2(realWebSocket, requestA));
        }
        return realWebSocket;
    }

    public OkHttpClient() {
        this(new a());
    }
}
