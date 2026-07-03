package p007b.p109f.p161j.p170e;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p114c.InterfaceC1667a;
import p007b.p109f.p115d.p127l.C1717b;
import p007b.p109f.p161j.p168c.C1859f;
import p007b.p109f.p161j.p168c.InterfaceC1862i;
import p007b.p109f.p161j.p168c.InterfaceC1876w;
import p007b.p109f.p161j.p171f.C1906d;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p176k.C1925b;
import p007b.p109f.p161j.p176k.C1926c;
import p007b.p109f.p161j.p176k.InterfaceC1927d;
import p007b.p109f.p161j.p176k.InterfaceC1928e;
import p007b.p109f.p161j.p181p.C1966b0;
import p007b.p109f.p161j.p181p.C1973d1;
import p007b.p109f.p161j.p181p.InterfaceC1982g1;
import p007b.p109f.p161j.p181p.InterfaceC2018w0;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: renamed from: b.f.j.e.h */
/* JADX INFO: compiled from: ImagePipeline.java */
/* JADX INFO: loaded from: classes.dex */
public class C1893h {

    /* JADX INFO: renamed from: a */
    public final C1902q f3733a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1928e f3734b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC1927d f3735c;

    /* JADX INFO: renamed from: d */
    public final Supplier<Boolean> f3736d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC1876w<CacheKey, AbstractC1917c> f3737e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC1876w<CacheKey, PooledByteBuffer> f3738f;

    /* JADX INFO: renamed from: g */
    public final InterfaceC1862i f3739g;

    /* JADX INFO: renamed from: h */
    public final Supplier<Boolean> f3740h;

    /* JADX INFO: renamed from: i */
    public AtomicLong f3741i = new AtomicLong();

    /* JADX INFO: renamed from: j */
    public final Supplier<Boolean> f3742j = null;

    /* JADX INFO: renamed from: k */
    public final InterfaceC1667a f3743k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC1896k f3744l;

    static {
        new CancellationException("Prefetching is not enabled");
    }

    public C1893h(C1902q c1902q, Set<InterfaceC1928e> set, Set<InterfaceC1927d> set2, Supplier<Boolean> supplier, InterfaceC1876w<CacheKey, AbstractC1917c> interfaceC1876w, InterfaceC1876w<CacheKey, PooledByteBuffer> interfaceC1876w2, C1859f c1859f, C1859f c1859f2, InterfaceC1862i interfaceC1862i, InterfaceC1982g1 interfaceC1982g1, Supplier<Boolean> supplier2, Supplier<Boolean> supplier3, InterfaceC1667a interfaceC1667a, InterfaceC1896k interfaceC1896k) {
        this.f3733a = c1902q;
        this.f3734b = new C1926c(set);
        this.f3735c = new C1925b(set2);
        this.f3736d = supplier;
        this.f3737e = interfaceC1876w;
        this.f3738f = interfaceC1876w2;
        this.f3739g = interfaceC1862i;
        this.f3740h = supplier2;
        this.f3743k = interfaceC1667a;
        this.f3744l = interfaceC1896k;
    }

    /* JADX INFO: renamed from: a */
    public DataSource<CloseableReference<AbstractC1917c>> m1262a(ImageRequest imageRequest, Object obj, ImageRequest.EnumC10667c enumC10667c, InterfaceC1928e interfaceC1928e, String str) {
        try {
            return m1263b(this.f3733a.m1307c(imageRequest), imageRequest, enumC10667c, obj, interfaceC1928e, str);
        } catch (Exception e) {
            return C1460d.m457N0(e);
        }
    }

    /* JADX INFO: renamed from: b */
    public final <T> DataSource<CloseableReference<T>> m1263b(InterfaceC2018w0<CloseableReference<T>> interfaceC2018w0, ImageRequest imageRequest, ImageRequest.EnumC10667c enumC10667c, Object obj, InterfaceC1928e interfaceC1928e, String str) {
        C1926c c1926c;
        InterfaceC1928e c1926c2;
        C2030b.m1527b();
        if (interfaceC1928e == null) {
            InterfaceC1928e interfaceC1928e2 = imageRequest.f19602t;
            if (interfaceC1928e2 == null) {
                c1926c2 = this.f3734b;
            } else {
                c1926c = new C1926c(this.f3734b, interfaceC1928e2);
                c1926c2 = c1926c;
            }
        } else {
            InterfaceC1928e interfaceC1928e3 = imageRequest.f19602t;
            if (interfaceC1928e3 == null) {
                c1926c2 = new C1926c(this.f3734b, interfaceC1928e);
            } else {
                c1926c = new C1926c(this.f3734b, interfaceC1928e, interfaceC1928e3);
                c1926c2 = c1926c;
            }
        }
        C1966b0 c1966b0 = new C1966b0(c1926c2, this.f3735c);
        InterfaceC1667a interfaceC1667a = this.f3743k;
        if (interfaceC1667a != null) {
            interfaceC1667a.m963a(obj, false);
        }
        try {
            C1973d1 c1973d1 = new C1973d1(imageRequest, String.valueOf(this.f3741i.getAndIncrement()), str, c1966b0, obj, ImageRequest.EnumC10667c.m8721f(imageRequest.f19596n, enumC10667c), false, imageRequest.f19588f || !C1717b.m1009e(imageRequest.f19585c), imageRequest.f19595m, this.f3744l);
            C2030b.m1527b();
            C1906d c1906d = new C1906d(interfaceC2018w0, c1973d1, c1966b0);
            C2030b.m1527b();
            return c1906d;
        } catch (Exception e) {
            return C1460d.m457N0(e);
        } finally {
            C2030b.m1527b();
        }
    }
}
