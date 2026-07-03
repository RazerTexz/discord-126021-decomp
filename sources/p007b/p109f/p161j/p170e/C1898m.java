package p007b.p109f.p161j.p170e;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.Objects;
import java.util.Set;
import p007b.p109f.p111b.p113b.InterfaceC1665h;
import p007b.p109f.p115d.p117b.InterfaceExecutorServiceC1675f;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p115d.p122g.InterfaceC1694a;
import p007b.p109f.p115d.p122g.InterfaceC1696c;
import p007b.p109f.p115d.p122g.InterfaceC1700g;
import p007b.p109f.p161j.p162a.p164b.C1841b;
import p007b.p109f.p161j.p162a.p164b.InterfaceC1840a;
import p007b.p109f.p161j.p167b.C1850a;
import p007b.p109f.p161j.p168c.C1859f;
import p007b.p109f.p161j.p168c.C1863j;
import p007b.p109f.p161j.p168c.C1864k;
import p007b.p109f.p161j.p168c.C1869p;
import p007b.p109f.p161j.p168c.C1870q;
import p007b.p109f.p161j.p168c.C1872s;
import p007b.p109f.p161j.p168c.C1873t;
import p007b.p109f.p161j.p168c.C1875v;
import p007b.p109f.p161j.p168c.C1878y;
import p007b.p109f.p161j.p168c.C1879z;
import p007b.p109f.p161j.p168c.InterfaceC1852a;
import p007b.p109f.p161j.p168c.InterfaceC1862i;
import p007b.p109f.p161j.p168c.InterfaceC1866m;
import p007b.p109f.p161j.p168c.InterfaceC1871r;
import p007b.p109f.p161j.p168c.InterfaceC1876w;
import p007b.p109f.p161j.p170e.C1897l;
import p007b.p109f.p161j.p173h.C1908a;
import p007b.p109f.p161j.p173h.InterfaceC1909b;
import p007b.p109f.p161j.p173h.InterfaceC1911d;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p176k.InterfaceC1927d;
import p007b.p109f.p161j.p176k.InterfaceC1928e;
import p007b.p109f.p161j.p177l.C1952x;
import p007b.p109f.p161j.p179n.C1957a;
import p007b.p109f.p161j.p179n.C1959c;
import p007b.p109f.p161j.p179n.InterfaceC1960d;
import p007b.p109f.p161j.p181p.C1985h1;
import p007b.p109f.p161j.p181p.InterfaceC1982g1;
import p007b.p109f.p161j.p181p.InterfaceC2002o0;
import p007b.p109f.p161j.p183r.C2030b;
import p007b.p109f.p161j.p184s.C2035e;
import p007b.p109f.p161j.p184s.InterfaceC2033c;

/* JADX INFO: renamed from: b.f.j.e.m */
/* JADX INFO: compiled from: ImagePipelineFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class C1898m {

    /* JADX INFO: renamed from: a */
    public static C1898m f3788a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1982g1 f3789b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC1896k f3790c;

    /* JADX INFO: renamed from: d */
    public final C1886a f3791d;

    /* JADX INFO: renamed from: e */
    public InterfaceC1866m<CacheKey, AbstractC1917c> f3792e;

    /* JADX INFO: renamed from: f */
    public C1872s<CacheKey, AbstractC1917c> f3793f;

    /* JADX INFO: renamed from: g */
    public InterfaceC1866m<CacheKey, PooledByteBuffer> f3794g;

    /* JADX INFO: renamed from: h */
    public C1872s<CacheKey, PooledByteBuffer> f3795h;

    /* JADX INFO: renamed from: i */
    public C1859f f3796i;

    /* JADX INFO: renamed from: j */
    public InterfaceC1665h f3797j;

    /* JADX INFO: renamed from: k */
    public InterfaceC1909b f3798k;

    /* JADX INFO: renamed from: l */
    public C1893h f3799l;

    /* JADX INFO: renamed from: m */
    public InterfaceC2033c f3800m;

    /* JADX INFO: renamed from: n */
    public C1901p f3801n;

    /* JADX INFO: renamed from: o */
    public C1902q f3802o;

    /* JADX INFO: renamed from: p */
    public C1859f f3803p;

    /* JADX INFO: renamed from: q */
    public InterfaceC1665h f3804q;

    /* JADX INFO: renamed from: r */
    public PlatformBitmapFactory f3805r;

    /* JADX INFO: renamed from: s */
    public InterfaceC1960d f3806s;

    /* JADX INFO: renamed from: t */
    public InterfaceC1840a f3807t;

    public C1898m(InterfaceC1896k interfaceC1896k) {
        C2030b.m1527b();
        Objects.requireNonNull(interfaceC1896k);
        this.f3790c = interfaceC1896k;
        Objects.requireNonNull(interfaceC1896k.getExperiments());
        this.f3789b = new C1985h1(interfaceC1896k.mo1267D().mo1255b());
        Objects.requireNonNull(interfaceC1896k.getExperiments());
        CloseableReference.f19439k = 0;
        this.f3791d = new C1886a(interfaceC1896k.mo1273f());
        C2030b.m1527b();
    }

    /* JADX INFO: renamed from: j */
    public static synchronized void m1294j(InterfaceC1896k interfaceC1896k) {
        if (f3788a != null) {
            C1691a.m983k(C1898m.class, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
        }
        f3788a = new C1898m(interfaceC1896k);
    }

    /* JADX INFO: renamed from: a */
    public final C1893h m1295a() {
        InterfaceC1909b interfaceC1909bMo1191c;
        InterfaceC1909b interfaceC1909bMo1190b;
        if (Build.VERSION.SDK_INT >= 24) {
            Objects.requireNonNull(this.f3790c.getExperiments());
        }
        if (this.f3802o == null) {
            ContentResolver contentResolver = this.f3790c.getContext().getApplicationContext().getContentResolver();
            if (this.f3801n == null) {
                C1897l.d dVar = this.f3790c.getExperiments().f3779b;
                Context context = this.f3790c.getContext();
                InterfaceC1694a interfaceC1694aM1410e = this.f3790c.mo1268a().m1410e();
                if (this.f3798k == null) {
                    if (this.f3790c.mo1265B() != null) {
                        this.f3798k = this.f3790c.mo1265B();
                    } else {
                        InterfaceC1840a interfaceC1840aM1296b = m1296b();
                        if (interfaceC1840aM1296b != null) {
                            interfaceC1909bMo1190b = interfaceC1840aM1296b.mo1190b();
                            interfaceC1909bMo1191c = interfaceC1840aM1296b.mo1191c();
                        } else {
                            interfaceC1909bMo1191c = null;
                            interfaceC1909bMo1190b = null;
                        }
                        if (this.f3790c.mo1291x() != null) {
                            m1302h();
                            Objects.requireNonNull(this.f3790c.mo1291x());
                            throw null;
                        }
                        this.f3798k = new C1908a(interfaceC1909bMo1190b, interfaceC1909bMo1191c, m1302h());
                    }
                }
                InterfaceC1909b interfaceC1909b = this.f3798k;
                InterfaceC1911d interfaceC1911dMo1282o = this.f3790c.mo1282o();
                boolean zMo1286s = this.f3790c.mo1286s();
                boolean zMo1280m = this.f3790c.mo1280m();
                Objects.requireNonNull(this.f3790c.getExperiments());
                InterfaceC1890e interfaceC1890eMo1267D = this.f3790c.mo1267D();
                InterfaceC1700g interfaceC1700gM1408c = this.f3790c.mo1268a().m1408c(this.f3790c.mo1270c());
                this.f3790c.mo1268a().m1409d();
                C1872s<CacheKey, AbstractC1917c> c1872sM1298d = m1298d();
                C1872s<CacheKey, PooledByteBuffer> c1872sM1299e = m1299e();
                C1859f c1859fM1300f = m1300f();
                C1859f c1859fM1303i = m1303i();
                InterfaceC1862i interfaceC1862iMo1279l = this.f3790c.mo1279l();
                PlatformBitmapFactory platformBitmapFactoryM1301g = m1301g();
                Objects.requireNonNull(this.f3790c.getExperiments());
                Objects.requireNonNull(this.f3790c.getExperiments());
                Objects.requireNonNull(this.f3790c.getExperiments());
                int i = this.f3790c.getExperiments().f3778a;
                C1886a c1886a = this.f3791d;
                Objects.requireNonNull(this.f3790c.getExperiments());
                int i2 = this.f3790c.getExperiments().f3784g;
                Objects.requireNonNull((C1897l.c) dVar);
                this.f3801n = new C1901p(context, interfaceC1694aM1410e, interfaceC1909b, interfaceC1911dMo1282o, zMo1286s, zMo1280m, false, interfaceC1890eMo1267D, interfaceC1700gM1408c, c1872sM1298d, c1872sM1299e, c1859fM1300f, c1859fM1303i, interfaceC1862iMo1279l, platformBitmapFactoryM1301g, 0, 0, false, i, c1886a, false, i2);
            }
            C1901p c1901p = this.f3801n;
            InterfaceC2002o0 interfaceC2002o0Mo1275h = this.f3790c.mo1275h();
            boolean zMo1280m2 = this.f3790c.mo1280m();
            Objects.requireNonNull(this.f3790c.getExperiments());
            InterfaceC1982g1 interfaceC1982g1 = this.f3789b;
            boolean zMo1286s2 = this.f3790c.mo1286s();
            Objects.requireNonNull(this.f3790c.getExperiments());
            boolean zMo1292y = this.f3790c.mo1292y();
            if (this.f3800m == null) {
                if (this.f3790c.mo1289v() == null && this.f3790c.mo1288u() == null) {
                    Objects.requireNonNull(this.f3790c.getExperiments());
                }
                int i3 = this.f3790c.getExperiments().f3778a;
                Objects.requireNonNull(this.f3790c.getExperiments());
                this.f3800m = new C2035e(i3, false, this.f3790c.mo1289v(), this.f3790c.mo1288u(), this.f3790c.getExperiments().f3783f);
            }
            InterfaceC2033c interfaceC2033c = this.f3800m;
            Objects.requireNonNull(this.f3790c.getExperiments());
            Objects.requireNonNull(this.f3790c.getExperiments());
            Objects.requireNonNull(this.f3790c.getExperiments());
            this.f3802o = new C1902q(contentResolver, c1901p, interfaceC2002o0Mo1275h, zMo1280m2, false, interfaceC1982g1, zMo1286s2, false, false, zMo1292y, interfaceC2033c, false, false, false);
        }
        C1902q c1902q = this.f3802o;
        Set<InterfaceC1928e> setMo1278k = this.f3790c.mo1278k();
        Set<InterfaceC1927d> setMo1269b = this.f3790c.mo1269b();
        Supplier<Boolean> supplierMo1271d = this.f3790c.mo1271d();
        C1872s<CacheKey, AbstractC1917c> c1872sM1298d2 = m1298d();
        C1872s<CacheKey, PooledByteBuffer> c1872sM1299e2 = m1299e();
        C1859f c1859fM1300f2 = m1300f();
        C1859f c1859fM1303i2 = m1303i();
        InterfaceC1862i interfaceC1862iMo1279l2 = this.f3790c.mo1279l();
        InterfaceC1982g1 interfaceC1982g2 = this.f3789b;
        Supplier<Boolean> supplier = this.f3790c.getExperiments().f3781d;
        Objects.requireNonNull(this.f3790c.getExperiments());
        return new C1893h(c1902q, setMo1278k, setMo1269b, supplierMo1271d, c1872sM1298d2, c1872sM1299e2, c1859fM1300f2, c1859fM1303i2, interfaceC1862iMo1279l2, interfaceC1982g2, supplier, null, this.f3790c.mo1293z(), this.f3790c);
    }

    /* JADX INFO: renamed from: b */
    public final InterfaceC1840a m1296b() {
        if (this.f3807t == null) {
            PlatformBitmapFactory platformBitmapFactoryM1301g = m1301g();
            InterfaceC1890e interfaceC1890eMo1267D = this.f3790c.mo1267D();
            InterfaceC1866m<CacheKey, AbstractC1917c> interfaceC1866mM1297c = m1297c();
            boolean z2 = this.f3790c.getExperiments().f3780c;
            InterfaceExecutorServiceC1675f interfaceExecutorServiceC1675fMo1287t = this.f3790c.mo1287t();
            if (!C1841b.f3618a) {
                try {
                    C1841b.f3619b = (InterfaceC1840a) Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(PlatformBitmapFactory.class, InterfaceC1890e.class, InterfaceC1866m.class, Boolean.TYPE, InterfaceExecutorServiceC1675f.class).newInstance(platformBitmapFactoryM1301g, interfaceC1890eMo1267D, interfaceC1866mM1297c, Boolean.valueOf(z2), interfaceExecutorServiceC1675fMo1287t);
                } catch (Throwable unused) {
                }
                if (C1841b.f3619b != null) {
                    C1841b.f3618a = true;
                }
            }
            this.f3807t = C1841b.f3619b;
        }
        return this.f3807t;
    }

    /* JADX INFO: renamed from: c */
    public InterfaceC1866m<CacheKey, AbstractC1917c> m1297c() {
        if (this.f3792e == null) {
            InterfaceC1852a interfaceC1852aMo1274g = this.f3790c.mo1274g();
            Supplier<MemoryCacheParams> supplierMo1264A = this.f3790c.mo1264A();
            InterfaceC1696c interfaceC1696cMo1290w = this.f3790c.mo1290w();
            InterfaceC1876w.a aVarMo1281n = this.f3790c.mo1281n();
            Objects.requireNonNull(this.f3790c.getExperiments());
            Objects.requireNonNull(this.f3790c.getExperiments());
            InterfaceC1866m.b<CacheKey> bVarMo1285r = this.f3790c.mo1285r();
            C1864k c1864k = (C1864k) interfaceC1852aMo1274g;
            Objects.requireNonNull(c1864k);
            C1875v c1875v = new C1875v(new C1863j(c1864k), aVarMo1281n, supplierMo1264A, bVarMo1285r, false, false);
            interfaceC1696cMo1290w.mo989a(c1875v);
            this.f3792e = c1875v;
        }
        return this.f3792e;
    }

    /* JADX INFO: renamed from: d */
    public C1872s<CacheKey, AbstractC1917c> m1298d() {
        if (this.f3793f == null) {
            InterfaceC1866m<CacheKey, AbstractC1917c> interfaceC1866mM1297c = m1297c();
            InterfaceC1871r interfaceC1871rMo1284q = this.f3790c.mo1284q();
            Objects.requireNonNull((C1879z) interfaceC1871rMo1284q);
            this.f3793f = new C1872s<>(interfaceC1866mM1297c, new C1873t(interfaceC1871rMo1284q));
        }
        return this.f3793f;
    }

    /* JADX INFO: renamed from: e */
    public C1872s<CacheKey, PooledByteBuffer> m1299e() {
        InterfaceC1876w<CacheKey, PooledByteBuffer> interfaceC1876wMo1276i;
        if (this.f3795h == null) {
            if (this.f3790c.mo1276i() != null) {
                interfaceC1876wMo1276i = this.f3790c.mo1276i();
            } else {
                if (this.f3794g == null) {
                    Supplier<MemoryCacheParams> supplierMo1266C = this.f3790c.mo1266C();
                    InterfaceC1696c interfaceC1696cMo1290w = this.f3790c.mo1290w();
                    C1875v c1875v = new C1875v(new C1869p(), new C1878y(), supplierMo1266C, null, false, false);
                    interfaceC1696cMo1290w.mo989a(c1875v);
                    this.f3794g = c1875v;
                }
                interfaceC1876wMo1276i = this.f3794g;
            }
            InterfaceC1871r interfaceC1871rMo1284q = this.f3790c.mo1284q();
            Objects.requireNonNull((C1879z) interfaceC1871rMo1284q);
            this.f3795h = new C1872s<>(interfaceC1876wMo1276i, new C1870q(interfaceC1871rMo1284q));
        }
        return this.f3795h;
    }

    /* JADX INFO: renamed from: f */
    public C1859f m1300f() {
        if (this.f3796i == null) {
            if (this.f3797j == null) {
                this.f3797j = ((C1888c) this.f3790c.mo1272e()).m1261a(this.f3790c.mo1277j());
            }
            this.f3796i = new C1859f(this.f3797j, this.f3790c.mo1268a().m1408c(this.f3790c.mo1270c()), this.f3790c.mo1268a().m1409d(), this.f3790c.mo1267D().mo1258e(), this.f3790c.mo1267D().mo1257d(), this.f3790c.mo1284q());
        }
        return this.f3796i;
    }

    /* JADX INFO: renamed from: g */
    public PlatformBitmapFactory m1301g() {
        if (this.f3805r == null) {
            C1952x c1952xMo1268a = this.f3790c.mo1268a();
            m1302h();
            this.f3805r = new C1850a(c1952xMo1268a.m1406a(), this.f3791d);
        }
        return this.f3805r;
    }

    /* JADX INFO: renamed from: h */
    public InterfaceC1960d m1302h() {
        InterfaceC1960d c1957a;
        if (this.f3806s == null) {
            C1952x c1952xMo1268a = this.f3790c.mo1268a();
            Objects.requireNonNull(this.f3790c.getExperiments());
            if (Build.VERSION.SDK_INT >= 26) {
                int iM1407b = c1952xMo1268a.m1407b();
                c1957a = new C1959c(c1952xMo1268a.m1406a(), iM1407b, new Pools.SynchronizedPool(iM1407b));
            } else {
                int iM1407b2 = c1952xMo1268a.m1407b();
                c1957a = new C1957a(c1952xMo1268a.m1406a(), iM1407b2, new Pools.SynchronizedPool(iM1407b2));
            }
            this.f3806s = c1957a;
        }
        return this.f3806s;
    }

    /* JADX INFO: renamed from: i */
    public final C1859f m1303i() {
        if (this.f3803p == null) {
            if (this.f3804q == null) {
                this.f3804q = ((C1888c) this.f3790c.mo1272e()).m1261a(this.f3790c.mo1283p());
            }
            this.f3803p = new C1859f(this.f3804q, this.f3790c.mo1268a().m1408c(this.f3790c.mo1270c()), this.f3790c.mo1268a().m1409d(), this.f3790c.mo1267D().mo1258e(), this.f3790c.mo1267D().mo1257d(), this.f3790c.mo1284q());
        }
        return this.f3803p;
    }
}
