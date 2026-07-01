package f0;

import com.discord.api.permission.Permission;
import f0.e0.k.h$a;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: OkHttpClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x$a {
    public int A;
    public long B;
    public f0.e0.g.l C;
    public q a = new q();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f3687b = new l();
    public final List<Interceptor> c = new ArrayList();
    public final List<Interceptor> d = new ArrayList();
    public t$b e;
    public boolean f;
    public c g;
    public boolean h;
    public boolean i;
    public p j;
    public s k;
    public Proxy l;
    public ProxySelector m;
    public c n;
    public SocketFactory o;
    public SSLSocketFactory p;
    public X509TrustManager q;
    public List<m> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List<? extends y> f3688s;
    public HostnameVerifier t;
    public g u;
    public f0.e0.m.c v;
    public int w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3689x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3690y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3691z;

    public x$a() {
        t tVar = t.a;
        d0.z.d.m.checkParameterIsNotNull(tVar, "$this$asFactory");
        this.e = new f0.e0.a(tVar);
        this.f = true;
        c cVar = c.a;
        this.g = cVar;
        this.h = true;
        this.i = true;
        this.j = p.a;
        this.k = s.a;
        this.n = cVar;
        SocketFactory socketFactory = SocketFactory.getDefault();
        d0.z.d.m.checkExpressionValueIsNotNull(socketFactory, "SocketFactory.getDefault()");
        this.o = socketFactory;
        x$b x_b = x.l;
        this.r = x.k;
        this.f3688s = x.j;
        this.t = f0.e0.m.d.a;
        this.u = g.a;
        this.f3689x = 10000;
        this.f3690y = 10000;
        this.f3691z = 10000;
        this.B = Permission.VIEW_CHANNEL;
    }

    public final x$a a(long j, TimeUnit timeUnit) {
        d0.z.d.m.checkParameterIsNotNull(timeUnit, "unit");
        this.f3690y = f0.e0.c.b("timeout", j, timeUnit);
        return this;
    }

    public final x$a b(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
        d0.z.d.m.checkParameterIsNotNull(sSLSocketFactory, "sslSocketFactory");
        d0.z.d.m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        if ((!d0.z.d.m.areEqual(sSLSocketFactory, this.p)) || (!d0.z.d.m.areEqual(x509TrustManager, this.q))) {
            this.C = null;
        }
        this.p = sSLSocketFactory;
        d0.z.d.m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        h$a h_a = f0.e0.k.h.c;
        this.v = f0.e0.k.h.a.b(x509TrustManager);
        this.q = x509TrustManager;
        return this;
    }
}
