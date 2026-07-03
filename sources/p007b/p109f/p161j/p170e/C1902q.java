package p007b.p109f.p161j.p170e;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.producers.LocalExifThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.C1689l;
import p007b.p109f.p115d.p121f.C1692a;
import p007b.p109f.p115d.p128m.C1720c;
import p007b.p109f.p115d.p128m.InterfaceC1719b;
import p007b.p109f.p161j.p168c.C1859f;
import p007b.p109f.p161j.p168c.InterfaceC1862i;
import p007b.p109f.p161j.p168c.InterfaceC1876w;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p175j.C1919e;
import p007b.p109f.p161j.p181p.C1962a;
import p007b.p109f.p161j.p181p.C1967b1;
import p007b.p109f.p161j.p181p.C1972d0;
import p007b.p109f.p161j.p181p.C1975e0;
import p007b.p109f.p161j.p181p.C1977f;
import p007b.p109f.p161j.p181p.C1978f0;
import p007b.p109f.p161j.p181p.C1979f1;
import p007b.p109f.p161j.p181p.C1980g;
import p007b.p109f.p161j.p181p.C1983h;
import p007b.p109f.p161j.p181p.C1984h0;
import p007b.p109f.p161j.p181p.C1986i;
import p007b.p109f.p161j.p181p.C1987i0;
import p007b.p109f.p161j.p181p.C1988i1;
import p007b.p109f.p161j.p181p.C1989j;
import p007b.p109f.p161j.p181p.C1990j0;
import p007b.p109f.p161j.p181p.C1991j1;
import p007b.p109f.p161j.p181p.C1992k;
import p007b.p109f.p161j.p181p.C1993k0;
import p007b.p109f.p161j.p181p.C1997m;
import p007b.p109f.p161j.p181p.C1999n;
import p007b.p109f.p161j.p181p.C2000n0;
import p007b.p109f.p161j.p181p.C2001o;
import p007b.p109f.p161j.p181p.C2008r0;
import p007b.p109f.p161j.p181p.C2009s;
import p007b.p109f.p161j.p181p.C2010s0;
import p007b.p109f.p161j.p181p.C2011t;
import p007b.p109f.p161j.p181p.C2012t0;
import p007b.p109f.p161j.p181p.C2013u;
import p007b.p109f.p161j.p181p.C2015v;
import p007b.p109f.p161j.p181p.C2017w;
import p007b.p109f.p161j.p181p.InterfaceC1982g1;
import p007b.p109f.p161j.p181p.InterfaceC1994k1;
import p007b.p109f.p161j.p181p.InterfaceC2002o0;
import p007b.p109f.p161j.p181p.InterfaceC2018w0;
import p007b.p109f.p161j.p183r.C2030b;
import p007b.p109f.p161j.p184s.InterfaceC2033c;

/* JADX INFO: renamed from: b.f.j.e.q */
/* JADX INFO: compiled from: ProducerSequenceFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class C1902q {

    /* JADX INFO: renamed from: a */
    public final ContentResolver f3840a;

    /* JADX INFO: renamed from: b */
    public final C1901p f3841b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC2002o0 f3842c;

    /* JADX INFO: renamed from: d */
    public final boolean f3843d;

    /* JADX INFO: renamed from: e */
    public final boolean f3844e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC1982g1 f3845f;

    /* JADX INFO: renamed from: g */
    public final boolean f3846g;

    /* JADX INFO: renamed from: h */
    public final boolean f3847h;

    /* JADX INFO: renamed from: i */
    public final boolean f3848i;

    /* JADX INFO: renamed from: j */
    public final InterfaceC2033c f3849j;

    /* JADX INFO: renamed from: k */
    public final boolean f3850k;

    /* JADX INFO: renamed from: l */
    public final boolean f3851l;

    /* JADX INFO: renamed from: m */
    public final boolean f3852m;

    /* JADX INFO: renamed from: n */
    @Nullable
    @VisibleForTesting
    public InterfaceC2018w0<CloseableReference<AbstractC1917c>> f3853n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public InterfaceC2018w0<C1919e> f3854o;

    /* JADX INFO: renamed from: p */
    @Nullable
    @VisibleForTesting
    public InterfaceC2018w0<CloseableReference<AbstractC1917c>> f3855p;

    /* JADX INFO: renamed from: q */
    @Nullable
    @VisibleForTesting
    public InterfaceC2018w0<CloseableReference<AbstractC1917c>> f3856q;

    /* JADX INFO: renamed from: r */
    @Nullable
    @VisibleForTesting
    public InterfaceC2018w0<CloseableReference<AbstractC1917c>> f3857r;

    /* JADX INFO: renamed from: s */
    @Nullable
    @VisibleForTesting
    public InterfaceC2018w0<CloseableReference<AbstractC1917c>> f3858s;

    /* JADX INFO: renamed from: t */
    @Nullable
    @VisibleForTesting
    public InterfaceC2018w0<CloseableReference<AbstractC1917c>> f3859t;

    /* JADX INFO: renamed from: u */
    @Nullable
    @VisibleForTesting
    public InterfaceC2018w0<CloseableReference<AbstractC1917c>> f3860u;

    /* JADX INFO: renamed from: v */
    @Nullable
    @VisibleForTesting
    public InterfaceC2018w0<CloseableReference<AbstractC1917c>> f3861v;

    /* JADX INFO: renamed from: w */
    @Nullable
    @VisibleForTesting
    public InterfaceC2018w0<CloseableReference<AbstractC1917c>> f3862w;

    /* JADX INFO: renamed from: x */
    @VisibleForTesting
    public Map<InterfaceC2018w0<CloseableReference<AbstractC1917c>>, InterfaceC2018w0<CloseableReference<AbstractC1917c>>> f3863x = new HashMap();

    /* JADX INFO: renamed from: y */
    @VisibleForTesting
    public Map<InterfaceC2018w0<CloseableReference<AbstractC1917c>>, InterfaceC2018w0<CloseableReference<AbstractC1917c>>> f3864y;

    public C1902q(ContentResolver contentResolver, C1901p c1901p, InterfaceC2002o0 interfaceC2002o0, boolean z2, boolean z3, InterfaceC1982g1 interfaceC1982g1, boolean z4, boolean z5, boolean z6, boolean z7, InterfaceC2033c interfaceC2033c, boolean z8, boolean z9, boolean z10) {
        this.f3840a = contentResolver;
        this.f3841b = c1901p;
        this.f3842c = interfaceC2002o0;
        this.f3843d = z2;
        new HashMap();
        this.f3864y = new HashMap();
        this.f3845f = interfaceC1982g1;
        this.f3846g = z4;
        this.f3847h = z5;
        this.f3844e = z6;
        this.f3848i = z7;
        this.f3849j = interfaceC2033c;
        this.f3850k = z8;
        this.f3851l = z9;
        this.f3852m = z10;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized InterfaceC2018w0<C1919e> m1305a() {
        C2030b.m1527b();
        if (this.f3854o == null) {
            C2030b.m1527b();
            C1901p c1901p = this.f3841b;
            C1962a c1962a = new C1962a(m1317m(new C2000n0(c1901p.f3825k, c1901p.f3818d, this.f3842c)));
            this.f3854o = c1962a;
            this.f3854o = this.f3841b.m1304a(c1962a, this.f3843d && !this.f3846g, this.f3849j);
            C2030b.m1527b();
        }
        C2030b.m1527b();
        return this.f3854o;
    }

    /* JADX INFO: renamed from: b */
    public final synchronized InterfaceC2018w0<CloseableReference<AbstractC1917c>> m1306b() {
        if (this.f3860u == null) {
            C1997m c1997m = new C1997m(this.f3841b.f3825k);
            InterfaceC1719b interfaceC1719b = C1720c.f3139a;
            this.f3860u = m1314j(this.f3841b.m1304a(new C1962a(c1997m), true, this.f3849j));
        }
        return this.f3860u;
    }

    /* JADX INFO: renamed from: c */
    public InterfaceC2018w0<CloseableReference<AbstractC1917c>> m1307c(ImageRequest imageRequest) {
        InterfaceC2018w0<CloseableReference<AbstractC1917c>> interfaceC2018w0M1311g;
        C2001o c2001o;
        C2030b.m1527b();
        try {
            C2030b.m1527b();
            Objects.requireNonNull(imageRequest);
            Uri uri = imageRequest.f19585c;
            C1460d.m591y(uri, "Uri is null.");
            int i = imageRequest.f19586d;
            if (i != 0) {
                boolean z2 = false;
                switch (i) {
                    case 2:
                        interfaceC2018w0M1311g = m1311g();
                        break;
                    case 3:
                        synchronized (this) {
                            if (this.f3855p == null) {
                                C1901p c1901p = this.f3841b;
                                this.f3855p = m1315k(new C1984h0(c1901p.f3824j.mo1258e(), c1901p.f3825k));
                            }
                            interfaceC2018w0M1311g = this.f3855p;
                        }
                        break;
                    case 4:
                        if (imageRequest.f19590h && Build.VERSION.SDK_INT >= 29) {
                            synchronized (this) {
                                if (this.f3861v == null) {
                                    C1901p c1901p2 = this.f3841b;
                                    this.f3861v = m1313i(new C1990j0(c1901p2.f3824j.mo1256c(), c1901p2.f3815a));
                                }
                                interfaceC2018w0M1311g = this.f3861v;
                            }
                        } else {
                            String type = this.f3840a.getType(uri);
                            Map<String, String> map = C1692a.f3103a;
                            if (type != null && type.startsWith("video/")) {
                                z2 = true;
                            }
                            interfaceC2018w0M1311g = !z2 ? m1309e() : m1311g();
                        }
                        break;
                    case 5:
                        interfaceC2018w0M1311g = m1308d();
                        break;
                    case 6:
                        interfaceC2018w0M1311g = m1310f();
                        break;
                    case 7:
                        interfaceC2018w0M1311g = m1306b();
                        break;
                    case 8:
                        interfaceC2018w0M1311g = m1312h();
                        break;
                    default:
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unsupported uri scheme! Uri is: ");
                        String strValueOf = String.valueOf(uri);
                        if (strValueOf.length() > 30) {
                            strValueOf = strValueOf.substring(0, 30) + "...";
                        }
                        sb.append(strValueOf);
                        throw new IllegalArgumentException(sb.toString());
                }
            } else {
                synchronized (this) {
                    C2030b.m1527b();
                    if (this.f3853n == null) {
                        C2030b.m1527b();
                        this.f3853n = m1314j(m1305a());
                        C2030b.m1527b();
                    }
                    C2030b.m1527b();
                    interfaceC2018w0M1311g = this.f3853n;
                }
            }
            C2030b.m1527b();
            if (imageRequest.f19601s != null) {
                synchronized (this) {
                    InterfaceC2018w0<CloseableReference<AbstractC1917c>> interfaceC2018w0 = this.f3863x.get(interfaceC2018w0M1311g);
                    if (interfaceC2018w0 == null) {
                        C1901p c1901p3 = this.f3841b;
                        C2012t0 c2012t0 = new C2012t0(interfaceC2018w0M1311g, c1901p3.f3833s, c1901p3.f3824j.mo1256c());
                        C1901p c1901p4 = this.f3841b;
                        C2010s0 c2010s0 = new C2010s0(c1901p4.f3829o, c1901p4.f3830p, c2012t0);
                        this.f3863x.put(interfaceC2018w0M1311g, c2010s0);
                        interfaceC2018w0M1311g = c2010s0;
                    } else {
                        interfaceC2018w0M1311g = interfaceC2018w0;
                    }
                }
            }
            if (this.f3847h) {
                synchronized (this) {
                    InterfaceC2018w0<CloseableReference<AbstractC1917c>> interfaceC2018w1 = this.f3864y.get(interfaceC2018w0M1311g);
                    if (interfaceC2018w1 == null) {
                        C1901p c1901p5 = this.f3841b;
                        C1986i c1986i = new C1986i(interfaceC2018w0M1311g, c1901p5.f3834t, c1901p5.f3835u, c1901p5.f3836v);
                        this.f3864y.put(interfaceC2018w0M1311g, c1986i);
                        interfaceC2018w0M1311g = c1986i;
                    } else {
                        interfaceC2018w0M1311g = interfaceC2018w1;
                    }
                }
            }
            if (this.f3852m && imageRequest.f19603u > 0) {
                synchronized (this) {
                    c2001o = new C2001o(interfaceC2018w0M1311g, this.f3841b.f3824j.mo1260g());
                }
                interfaceC2018w0M1311g = c2001o;
            }
            C2030b.m1527b();
            return interfaceC2018w0M1311g;
        } catch (Throwable th) {
            C2030b.m1527b();
            throw th;
        }
    }

    /* JADX INFO: renamed from: d */
    public final synchronized InterfaceC2018w0<CloseableReference<AbstractC1917c>> m1308d() {
        if (this.f3859t == null) {
            C1901p c1901p = this.f3841b;
            this.f3859t = m1315k(new C1972d0(c1901p.f3824j.mo1258e(), c1901p.f3825k, c1901p.f3817c));
        }
        return this.f3859t;
    }

    /* JADX INFO: renamed from: e */
    public final synchronized InterfaceC2018w0<CloseableReference<AbstractC1917c>> m1309e() {
        if (this.f3857r == null) {
            C1901p c1901p = this.f3841b;
            C1975e0 c1975e0 = new C1975e0(c1901p.f3824j.mo1258e(), c1901p.f3825k, c1901p.f3815a);
            C1901p c1901p2 = this.f3841b;
            Objects.requireNonNull(c1901p2);
            C1901p c1901p3 = this.f3841b;
            this.f3857r = m1316l(c1975e0, new InterfaceC1994k1[]{new C1978f0(c1901p2.f3824j.mo1258e(), c1901p2.f3825k, c1901p2.f3815a), new LocalExifThumbnailProducer(c1901p3.f3824j.mo1259f(), c1901p3.f3825k, c1901p3.f3815a)});
        }
        return this.f3857r;
    }

    /* JADX INFO: renamed from: f */
    public final synchronized InterfaceC2018w0<CloseableReference<AbstractC1917c>> m1310f() {
        if (this.f3858s == null) {
            C1901p c1901p = this.f3841b;
            this.f3858s = m1315k(new C1987i0(c1901p.f3824j.mo1258e(), c1901p.f3825k, c1901p.f3816b));
        }
        return this.f3858s;
    }

    /* JADX INFO: renamed from: g */
    public final synchronized InterfaceC2018w0<CloseableReference<AbstractC1917c>> m1311g() {
        if (this.f3856q == null) {
            C1901p c1901p = this.f3841b;
            this.f3856q = m1313i(new C1993k0(c1901p.f3824j.mo1258e(), c1901p.f3815a));
        }
        return this.f3856q;
    }

    /* JADX INFO: renamed from: h */
    public final synchronized InterfaceC2018w0<CloseableReference<AbstractC1917c>> m1312h() {
        if (this.f3862w == null) {
            C1901p c1901p = this.f3841b;
            this.f3862w = m1315k(new C1967b1(c1901p.f3824j.mo1258e(), c1901p.f3825k, c1901p.f3815a));
        }
        return this.f3862w;
    }

    /* JADX INFO: renamed from: i */
    public final InterfaceC2018w0<CloseableReference<AbstractC1917c>> m1313i(InterfaceC2018w0<CloseableReference<AbstractC1917c>> interfaceC2018w0) {
        C1901p c1901p = this.f3841b;
        InterfaceC1876w<CacheKey, AbstractC1917c> interfaceC1876w = c1901p.f3829o;
        InterfaceC1862i interfaceC1862i = c1901p.f3830p;
        C1980g c1980g = new C1980g(interfaceC1862i, new C1983h(interfaceC1876w, interfaceC1862i, interfaceC2018w0));
        C1901p c1901p2 = this.f3841b;
        InterfaceC1982g1 interfaceC1982g1 = this.f3845f;
        Objects.requireNonNull(c1901p2);
        C1979f1 c1979f1 = new C1979f1(c1980g, interfaceC1982g1);
        if (!this.f3850k && !this.f3851l) {
            C1901p c1901p3 = this.f3841b;
            return new C1977f(c1901p3.f3829o, c1901p3.f3830p, c1979f1);
        }
        C1901p c1901p4 = this.f3841b;
        InterfaceC1876w<CacheKey, AbstractC1917c> interfaceC1876w2 = c1901p4.f3829o;
        InterfaceC1862i interfaceC1862i2 = c1901p4.f3830p;
        return new C1989j(c1901p4.f3828n, c1901p4.f3826l, c1901p4.f3827m, interfaceC1862i2, c1901p4.f3831q, c1901p4.f3832r, new C1977f(interfaceC1876w2, interfaceC1862i2, c1979f1));
    }

    /* JADX INFO: renamed from: j */
    public final InterfaceC2018w0<CloseableReference<AbstractC1917c>> m1314j(InterfaceC2018w0<C1919e> interfaceC2018w0) {
        C2030b.m1527b();
        C1901p c1901p = this.f3841b;
        InterfaceC2018w0<CloseableReference<AbstractC1917c>> interfaceC2018w0M1313i = m1313i(new C1999n(c1901p.f3818d, c1901p.f3824j.mo1254a(), c1901p.f3819e, c1901p.f3820f, c1901p.f3821g, c1901p.f3822h, c1901p.f3823i, interfaceC2018w0, c1901p.f3838x, c1901p.f3837w, null, C1689l.f3101a));
        C2030b.m1527b();
        return interfaceC2018w0M1313i;
    }

    /* JADX INFO: renamed from: k */
    public final InterfaceC2018w0<CloseableReference<AbstractC1917c>> m1315k(InterfaceC2018w0<C1919e> interfaceC2018w0) {
        C1901p c1901p = this.f3841b;
        return m1316l(interfaceC2018w0, new InterfaceC1994k1[]{new LocalExifThumbnailProducer(c1901p.f3824j.mo1259f(), c1901p.f3825k, c1901p.f3815a)});
    }

    /* JADX INFO: renamed from: l */
    public final InterfaceC2018w0<CloseableReference<AbstractC1917c>> m1316l(InterfaceC2018w0<C1919e> interfaceC2018w0, InterfaceC1994k1<C1919e>[] interfaceC1994k1Arr) {
        C1988i1 c1988i1 = new C1988i1(5, this.f3841b.f3824j.mo1255b(), this.f3841b.m1304a(new C1962a(m1317m(interfaceC2018w0)), true, this.f3849j));
        Objects.requireNonNull(this.f3841b);
        return m1314j(new C1992k(this.f3841b.m1304a(new C1991j1(interfaceC1994k1Arr), true, this.f3849j), c1988i1));
    }

    /* JADX INFO: renamed from: m */
    public final InterfaceC2018w0<C1919e> m1317m(InterfaceC2018w0<C1919e> interfaceC2018w0) {
        C2011t c2011t;
        InterfaceC1719b interfaceC1719b = C1720c.f3139a;
        if (this.f3848i) {
            C2030b.m1527b();
            if (this.f3844e) {
                C1901p c1901p = this.f3841b;
                C1859f c1859f = c1901p.f3826l;
                InterfaceC1862i interfaceC1862i = c1901p.f3830p;
                c2011t = new C2011t(c1859f, c1901p.f3827m, interfaceC1862i, new C2008r0(c1859f, interfaceC1862i, c1901p.f3825k, c1901p.f3818d, interfaceC2018w0));
            } else {
                C1901p c1901p2 = this.f3841b;
                c2011t = new C2011t(c1901p2.f3826l, c1901p2.f3827m, c1901p2.f3830p, interfaceC2018w0);
            }
            C1901p c1901p3 = this.f3841b;
            C2009s c2009s = new C2009s(c1901p3.f3826l, c1901p3.f3827m, c1901p3.f3830p, c2011t);
            C2030b.m1527b();
            interfaceC2018w0 = c2009s;
        }
        C1901p c1901p4 = this.f3841b;
        InterfaceC1876w<CacheKey, PooledByteBuffer> interfaceC1876w = c1901p4.f3828n;
        InterfaceC1862i interfaceC1862i2 = c1901p4.f3830p;
        C2015v c2015v = new C2015v(interfaceC1876w, interfaceC1862i2, interfaceC2018w0);
        if (!this.f3851l) {
            return new C2013u(interfaceC1862i2, c1901p4.f3839y, c2015v);
        }
        return new C2013u(interfaceC1862i2, c1901p4.f3839y, new C2017w(c1901p4.f3826l, c1901p4.f3827m, interfaceC1862i2, c1901p4.f3831q, c1901p4.f3832r, c2015v));
    }
}
