package p600f0;

import com.discord.api.permission.Permission;
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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12160r;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;
import p600f0.AbstractC12376t;
import p600f0.InterfaceC12269e;
import p600f0.p601e0.C12270a;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p604f.C12280d;
import p600f0.p601e0.p605g.C12285e;
import p600f0.p601e0.p605g.C12292l;
import p600f0.p601e0.p609k.C12333h;
import p600f0.p601e0.p611l.C12346a;
import p600f0.p601e0.p612m.AbstractC12349c;
import p600f0.p601e0.p612m.C12350d;
import p600f0.p601e0.p613n.C12355d;
import p600f0.p601e0.p613n.C12356e;

/* JADX INFO: renamed from: f0.x */
/* JADX INFO: compiled from: OkHttpClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12380x implements Cloneable, InterfaceC12269e.a {

    /* JADX INFO: renamed from: A */
    public final SocketFactory f25997A;

    /* JADX INFO: renamed from: B */
    public final SSLSocketFactory f25998B;

    /* JADX INFO: renamed from: C */
    public final X509TrustManager f25999C;

    /* JADX INFO: renamed from: D */
    public final List<C12369m> f26000D;

    /* JADX INFO: renamed from: E */
    public final List<EnumC12381y> f26001E;

    /* JADX INFO: renamed from: F */
    public final HostnameVerifier f26002F;

    /* JADX INFO: renamed from: G */
    public final C12363g f26003G;

    /* JADX INFO: renamed from: H */
    public final AbstractC12349c f26004H;

    /* JADX INFO: renamed from: I */
    public final int f26005I;

    /* JADX INFO: renamed from: J */
    public final int f26006J;

    /* JADX INFO: renamed from: K */
    public final int f26007K;

    /* JADX INFO: renamed from: L */
    public final int f26008L;

    /* JADX INFO: renamed from: M */
    public final int f26009M;

    /* JADX INFO: renamed from: N */
    public final long f26010N;

    /* JADX INFO: renamed from: O */
    public final C12292l f26011O;

    /* JADX INFO: renamed from: m */
    public final C12373q f26012m;

    /* JADX INFO: renamed from: n */
    public final C12368l f26013n;

    /* JADX INFO: renamed from: o */
    public final List<Interceptor> f26014o;

    /* JADX INFO: renamed from: p */
    public final List<Interceptor> f26015p;

    /* JADX INFO: renamed from: q */
    public final AbstractC12376t.b f26016q;

    /* JADX INFO: renamed from: r */
    public final boolean f26017r;

    /* JADX INFO: renamed from: s */
    public final InterfaceC12265c f26018s;

    /* JADX INFO: renamed from: t */
    public final boolean f26019t;

    /* JADX INFO: renamed from: u */
    public final boolean f26020u;

    /* JADX INFO: renamed from: v */
    public final InterfaceC12372p f26021v;

    /* JADX INFO: renamed from: w */
    public final InterfaceC12375s f26022w;

    /* JADX INFO: renamed from: x */
    public final Proxy f26023x;

    /* JADX INFO: renamed from: y */
    public final ProxySelector f26024y;

    /* JADX INFO: renamed from: z */
    public final InterfaceC12265c f26025z;

    /* JADX INFO: renamed from: l */
    public static final b f25996l = new b(null);

    /* JADX INFO: renamed from: j */
    public static final List<EnumC12381y> f25994j = C12272c.m10132m(EnumC12381y.HTTP_2, EnumC12381y.HTTP_1_1);

    /* JADX INFO: renamed from: k */
    public static final List<C12369m> f25995k = C12272c.m10132m(C12369m.f25932c, C12369m.f25933d);

    /* JADX INFO: renamed from: f0.x$a */
    /* JADX INFO: compiled from: OkHttpClient.kt */
    public static final class a {

        /* JADX INFO: renamed from: A */
        public int f26026A;

        /* JADX INFO: renamed from: B */
        public long f26027B;

        /* JADX INFO: renamed from: C */
        public C12292l f26028C;

        /* JADX INFO: renamed from: a */
        public C12373q f26029a = new C12373q();

        /* JADX INFO: renamed from: b */
        public C12368l f26030b = new C12368l();

        /* JADX INFO: renamed from: c */
        public final List<Interceptor> f26031c = new ArrayList();

        /* JADX INFO: renamed from: d */
        public final List<Interceptor> f26032d = new ArrayList();

        /* JADX INFO: renamed from: e */
        public AbstractC12376t.b f26033e;

        /* JADX INFO: renamed from: f */
        public boolean f26034f;

        /* JADX INFO: renamed from: g */
        public InterfaceC12265c f26035g;

        /* JADX INFO: renamed from: h */
        public boolean f26036h;

        /* JADX INFO: renamed from: i */
        public boolean f26037i;

        /* JADX INFO: renamed from: j */
        public InterfaceC12372p f26038j;

        /* JADX INFO: renamed from: k */
        public InterfaceC12375s f26039k;

        /* JADX INFO: renamed from: l */
        public Proxy f26040l;

        /* JADX INFO: renamed from: m */
        public ProxySelector f26041m;

        /* JADX INFO: renamed from: n */
        public InterfaceC12265c f26042n;

        /* JADX INFO: renamed from: o */
        public SocketFactory f26043o;

        /* JADX INFO: renamed from: p */
        public SSLSocketFactory f26044p;

        /* JADX INFO: renamed from: q */
        public X509TrustManager f26045q;

        /* JADX INFO: renamed from: r */
        public List<C12369m> f26046r;

        /* JADX INFO: renamed from: s */
        public List<? extends EnumC12381y> f26047s;

        /* JADX INFO: renamed from: t */
        public HostnameVerifier f26048t;

        /* JADX INFO: renamed from: u */
        public C12363g f26049u;

        /* JADX INFO: renamed from: v */
        public AbstractC12349c f26050v;

        /* JADX INFO: renamed from: w */
        public int f26051w;

        /* JADX INFO: renamed from: x */
        public int f26052x;

        /* JADX INFO: renamed from: y */
        public int f26053y;

        /* JADX INFO: renamed from: z */
        public int f26054z;

        public a() {
            AbstractC12376t abstractC12376t = AbstractC12376t.f25962a;
            C12238m.checkParameterIsNotNull(abstractC12376t, "$this$asFactory");
            this.f26033e = new C12270a(abstractC12376t);
            this.f26034f = true;
            InterfaceC12265c interfaceC12265c = InterfaceC12265c.f25369a;
            this.f26035g = interfaceC12265c;
            this.f26036h = true;
            this.f26037i = true;
            this.f26038j = InterfaceC12372p.f25956a;
            this.f26039k = InterfaceC12375s.f25961a;
            this.f26042n = interfaceC12265c;
            SocketFactory socketFactory = SocketFactory.getDefault();
            C12238m.checkExpressionValueIsNotNull(socketFactory, "SocketFactory.getDefault()");
            this.f26043o = socketFactory;
            b bVar = C12380x.f25996l;
            this.f26046r = C12380x.f25995k;
            this.f26047s = C12380x.f25994j;
            this.f26048t = C12350d.f25811a;
            this.f26049u = C12363g.f25903a;
            this.f26052x = 10000;
            this.f26053y = 10000;
            this.f26054z = 10000;
            this.f26027B = Permission.VIEW_CHANNEL;
        }

        /* JADX INFO: renamed from: a */
        public final a m10420a(long j, TimeUnit timeUnit) {
            C12238m.checkParameterIsNotNull(timeUnit, "unit");
            this.f26053y = C12272c.m10121b("timeout", j, timeUnit);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public final a m10421b(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            C12238m.checkParameterIsNotNull(sSLSocketFactory, "sslSocketFactory");
            C12238m.checkParameterIsNotNull(x509TrustManager, "trustManager");
            if ((!C12238m.areEqual(sSLSocketFactory, this.f26044p)) || (!C12238m.areEqual(x509TrustManager, this.f26045q))) {
                this.f26028C = null;
            }
            this.f26044p = sSLSocketFactory;
            C12238m.checkParameterIsNotNull(x509TrustManager, "trustManager");
            C12333h.a aVar = C12333h.f25785c;
            this.f26050v = C12333h.f25783a.mo10315b(x509TrustManager);
            this.f26045q = x509TrustManager;
            return this;
        }
    }

    /* JADX INFO: renamed from: f0.x$b */
    /* JADX INFO: compiled from: OkHttpClient.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public C12380x(a aVar) throws NoSuchAlgorithmException, KeyStoreException {
        ProxySelector proxySelector;
        boolean z2;
        boolean z3;
        C12238m.checkParameterIsNotNull(aVar, "builder");
        this.f26012m = aVar.f26029a;
        this.f26013n = aVar.f26030b;
        this.f26014o = C12272c.m10145z(aVar.f26031c);
        this.f26015p = C12272c.m10145z(aVar.f26032d);
        this.f26016q = aVar.f26033e;
        this.f26017r = aVar.f26034f;
        this.f26018s = aVar.f26035g;
        this.f26019t = aVar.f26036h;
        this.f26020u = aVar.f26037i;
        this.f26021v = aVar.f26038j;
        this.f26022w = aVar.f26039k;
        Proxy proxy = aVar.f26040l;
        this.f26023x = proxy;
        if (proxy != null) {
            proxySelector = C12346a.f25808a;
        } else {
            proxySelector = aVar.f26041m;
            proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
            if (proxySelector == null) {
                proxySelector = C12346a.f25808a;
            }
        }
        this.f26024y = proxySelector;
        this.f26025z = aVar.f26042n;
        this.f25997A = aVar.f26043o;
        List<C12369m> list = aVar.f26046r;
        this.f26000D = list;
        this.f26001E = aVar.f26047s;
        this.f26002F = aVar.f26048t;
        this.f26005I = aVar.f26051w;
        this.f26006J = aVar.f26052x;
        this.f26007K = aVar.f26053y;
        this.f26008L = aVar.f26054z;
        this.f26009M = aVar.f26026A;
        this.f26010N = aVar.f26027B;
        C12292l c12292l = aVar.f26028C;
        this.f26011O = c12292l == null ? new C12292l() : c12292l;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                } else if (((C12369m) it.next()).f25934e) {
                    z2 = false;
                    break;
                }
            }
        } else {
            z2 = true;
            break;
        }
        if (z2) {
            this.f25998B = null;
            this.f26004H = null;
            this.f25999C = null;
            this.f26003G = C12363g.f25903a;
        } else {
            SSLSocketFactory sSLSocketFactory = aVar.f26044p;
            if (sSLSocketFactory != null) {
                this.f25998B = sSLSocketFactory;
                AbstractC12349c abstractC12349c = aVar.f26050v;
                if (abstractC12349c == null) {
                    C12238m.throwNpe();
                }
                this.f26004H = abstractC12349c;
                X509TrustManager x509TrustManager = aVar.f26045q;
                if (x509TrustManager == null) {
                    C12238m.throwNpe();
                }
                this.f25999C = x509TrustManager;
                C12363g c12363g = aVar.f26049u;
                if (abstractC12349c == null) {
                    C12238m.throwNpe();
                }
                this.f26003G = c12363g.m10369b(abstractC12349c);
            } else {
                C12333h.a aVar2 = C12333h.f25785c;
                X509TrustManager x509TrustManagerMo10325n = C12333h.f25783a.mo10325n();
                this.f25999C = x509TrustManagerMo10325n;
                C12333h c12333h = C12333h.f25783a;
                if (x509TrustManagerMo10325n == null) {
                    C12238m.throwNpe();
                }
                this.f25998B = c12333h.mo10326m(x509TrustManagerMo10325n);
                if (x509TrustManagerMo10325n == null) {
                    C12238m.throwNpe();
                }
                C12238m.checkParameterIsNotNull(x509TrustManagerMo10325n, "trustManager");
                AbstractC12349c abstractC12349cMo10315b = C12333h.f25783a.mo10315b(x509TrustManagerMo10325n);
                this.f26004H = abstractC12349cMo10315b;
                C12363g c12363g2 = aVar.f26049u;
                if (abstractC12349cMo10315b == null) {
                    C12238m.throwNpe();
                }
                this.f26003G = c12363g2.m10369b(abstractC12349cMo10315b);
            }
        }
        List<Interceptor> list2 = this.f26014o;
        if (list2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!list2.contains(null))) {
            StringBuilder sbM833U = C1643a.m833U("Null interceptor: ");
            sbM833U.append(this.f26014o);
            throw new IllegalStateException(sbM833U.toString().toString());
        }
        List<Interceptor> list3 = this.f26015p;
        if (list3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!list3.contains(null))) {
            StringBuilder sbM833U2 = C1643a.m833U("Null network interceptor: ");
            sbM833U2.append(this.f26015p);
            throw new IllegalStateException(sbM833U2.toString().toString());
        }
        List<C12369m> list4 = this.f26000D;
        if (!(list4 instanceof Collection) || !list4.isEmpty()) {
            Iterator<T> it2 = list4.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z3 = true;
                    break;
                } else if (((C12369m) it2.next()).f25934e) {
                    z3 = false;
                    break;
                }
            }
        } else {
            z3 = true;
            break;
        }
        if (!z3) {
            if (this.f25998B == null) {
                throw new IllegalStateException("sslSocketFactory == null".toString());
            }
            if (this.f26004H == null) {
                throw new IllegalStateException("certificateChainCleaner == null".toString());
            }
            if (this.f25999C == null) {
                throw new IllegalStateException("x509TrustManager == null".toString());
            }
            return;
        }
        if (!(this.f25998B == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.f26004H == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.f25999C == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!C12238m.areEqual(this.f26003G, C12363g.f25903a)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    @Override // p600f0.InterfaceC12269e.a
    /* JADX INFO: renamed from: b */
    public InterfaceC12269e mo10114b(Request request) {
        C12238m.checkParameterIsNotNull(request, "request");
        return new C12285e(this, request, false);
    }

    public Object clone() {
        return super.clone();
    }

    /* JADX INFO: renamed from: f */
    public a m10418f() {
        C12238m.checkParameterIsNotNull(this, "okHttpClient");
        a aVar = new a();
        aVar.f26029a = this.f26012m;
        aVar.f26030b = this.f26013n;
        C12160r.addAll(aVar.f26031c, this.f26014o);
        C12160r.addAll(aVar.f26032d, this.f26015p);
        aVar.f26033e = this.f26016q;
        aVar.f26034f = this.f26017r;
        aVar.f26035g = this.f26018s;
        aVar.f26036h = this.f26019t;
        aVar.f26037i = this.f26020u;
        aVar.f26038j = this.f26021v;
        aVar.f26039k = this.f26022w;
        aVar.f26040l = this.f26023x;
        aVar.f26041m = this.f26024y;
        aVar.f26042n = this.f26025z;
        aVar.f26043o = this.f25997A;
        aVar.f26044p = this.f25998B;
        aVar.f26045q = this.f25999C;
        aVar.f26046r = this.f26000D;
        aVar.f26047s = this.f26001E;
        aVar.f26048t = this.f26002F;
        aVar.f26049u = this.f26003G;
        aVar.f26050v = this.f26004H;
        aVar.f26051w = this.f26005I;
        aVar.f26052x = this.f26006J;
        aVar.f26053y = this.f26007K;
        aVar.f26054z = this.f26008L;
        aVar.f26026A = this.f26009M;
        aVar.f26027B = this.f26010N;
        aVar.f26028C = this.f26011O;
        return aVar;
    }

    /* JADX INFO: renamed from: g */
    public WebSocket m10419g(Request request, WebSocketListener webSocketListener) {
        C12238m.checkParameterIsNotNull(request, "request");
        C12238m.checkParameterIsNotNull(webSocketListener, "listener");
        C12355d c12355d = new C12355d(C12280d.f25420a, request, webSocketListener, new Random(), this.f26009M, null, this.f26010N);
        C12238m.checkParameterIsNotNull(this, "client");
        if (c12355d.f25841u.m10977b("Sec-WebSocket-Extensions") != null) {
            c12355d.m10353i(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
        } else {
            a aVarM10418f = m10418f();
            AbstractC12376t abstractC12376t = AbstractC12376t.f25962a;
            C12238m.checkParameterIsNotNull(abstractC12376t, "eventListener");
            byte[] bArr = C12272c.f25397a;
            C12238m.checkParameterIsNotNull(abstractC12376t, "$this$asFactory");
            aVarM10418f.f26033e = new C12270a(abstractC12376t);
            List<EnumC12381y> list = C12355d.f25821a;
            C12238m.checkParameterIsNotNull(list, "protocols");
            List mutableList = C12163u.toMutableList((Collection) list);
            EnumC12381y enumC12381y = EnumC12381y.H2_PRIOR_KNOWLEDGE;
            if (!(mutableList.contains(enumC12381y) || mutableList.contains(EnumC12381y.HTTP_1_1))) {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + mutableList).toString());
            }
            if (!(!mutableList.contains(enumC12381y) || mutableList.size() <= 1)) {
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + mutableList).toString());
            }
            if (!(!mutableList.contains(EnumC12381y.HTTP_1_0))) {
                throw new IllegalArgumentException(("protocols must not contain http/1.0: " + mutableList).toString());
            }
            if (!(!mutableList.contains(null))) {
                throw new IllegalArgumentException("protocols must not contain null".toString());
            }
            mutableList.remove(EnumC12381y.SPDY_3);
            if (!C12238m.areEqual(mutableList, aVarM10418f.f26047s)) {
                aVarM10418f.f26028C = null;
            }
            List<? extends EnumC12381y> listUnmodifiableList = Collections.unmodifiableList(mutableList);
            C12238m.checkExpressionValueIsNotNull(listUnmodifiableList, "Collections.unmodifiableList(protocolsCopy)");
            aVarM10418f.f26047s = listUnmodifiableList;
            C12380x c12380x = new C12380x(aVarM10418f);
            Request.C12935a c12935a = new Request.C12935a(c12355d.f25841u);
            c12935a.m10979b("Upgrade", "websocket");
            c12935a.m10979b("Connection", "Upgrade");
            c12935a.m10979b("Sec-WebSocket-Key", c12355d.f25822b);
            c12935a.m10979b("Sec-WebSocket-Version", "13");
            c12935a.m10979b("Sec-WebSocket-Extensions", "permessage-deflate");
            Request requestM10978a = c12935a.m10978a();
            C12285e c12285e = new C12285e(c12380x, requestM10978a, true);
            c12355d.f25823c = c12285e;
            c12285e.mo10113e(new C12356e(c12355d, requestM10978a));
        }
        return c12355d;
    }

    public C12380x() {
        this(new a());
    }
}
