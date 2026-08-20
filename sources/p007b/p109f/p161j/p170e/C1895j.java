package p007b.p109f.p161j.p170e;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.appcompat.widget.ActivityChooserModel;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import p007b.p109f.p114c.InterfaceC1667a;
import p007b.p109f.p115d.p117b.InterfaceExecutorServiceC1675f;
import p007b.p109f.p115d.p122g.C1697d;
import p007b.p109f.p115d.p122g.InterfaceC1696c;
import p007b.p109f.p161j.p168c.C1856c;
import p007b.p109f.p161j.p168c.C1864k;
import p007b.p109f.p161j.p168c.C1867n;
import p007b.p109f.p161j.p168c.C1868o;
import p007b.p109f.p161j.p168c.C1879z;
import p007b.p109f.p161j.p168c.InterfaceC1852a;
import p007b.p109f.p161j.p168c.InterfaceC1862i;
import p007b.p109f.p161j.p168c.InterfaceC1866m;
import p007b.p109f.p161j.p168c.InterfaceC1871r;
import p007b.p109f.p161j.p168c.InterfaceC1876w;
import p007b.p109f.p161j.p172g.C1907a;
import p007b.p109f.p161j.p173h.C1910c;
import p007b.p109f.p161j.p173h.C1913f;
import p007b.p109f.p161j.p173h.InterfaceC1909b;
import p007b.p109f.p161j.p173h.InterfaceC1911d;
import p007b.p109f.p161j.p176k.InterfaceC1927d;
import p007b.p109f.p161j.p176k.InterfaceC1928e;
import p007b.p109f.p161j.p177l.C1951w;
import p007b.p109f.p161j.p177l.C1952x;
import p007b.p109f.p161j.p181p.C1963a0;
import p007b.p109f.p161j.p181p.InterfaceC2002o0;
import p007b.p109f.p161j.p183r.C2030b;
import p007b.p109f.p161j.p184s.InterfaceC2033c;

/* JADX INFO: renamed from: b.f.j.e.j */
/* JADX INFO: compiled from: ImagePipelineConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class C1895j implements InterfaceC1896k {

    /* JADX INFO: renamed from: a */
    public static b f3745a = new b(null);

    /* JADX INFO: renamed from: b */
    public final Supplier<MemoryCacheParams> f3746b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC1876w.a f3747c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC1862i f3748d;

    /* JADX INFO: renamed from: e */
    public final Context f3749e;

    /* JADX INFO: renamed from: f */
    public final boolean f3750f;

    /* JADX INFO: renamed from: g */
    public final InterfaceC1891f f3751g;

    /* JADX INFO: renamed from: h */
    public final Supplier<MemoryCacheParams> f3752h;

    /* JADX INFO: renamed from: i */
    public final InterfaceC1890e f3753i;

    /* JADX INFO: renamed from: j */
    public final InterfaceC1871r f3754j;

    /* JADX INFO: renamed from: k */
    public final Supplier<Boolean> f3755k;

    /* JADX INFO: renamed from: l */
    public final DiskCacheConfig f3756l;

    /* JADX INFO: renamed from: m */
    public final InterfaceC1696c f3757m;

    /* JADX INFO: renamed from: n */
    public final InterfaceC2002o0 f3758n;

    /* JADX INFO: renamed from: o */
    public final int f3759o;

    /* JADX INFO: renamed from: p */
    public final C1952x f3760p;

    /* JADX INFO: renamed from: q */
    public final InterfaceC1911d f3761q;

    /* JADX INFO: renamed from: r */
    public final Set<InterfaceC1928e> f3762r;

    /* JADX INFO: renamed from: s */
    public final Set<InterfaceC1927d> f3763s;

    /* JADX INFO: renamed from: t */
    public final boolean f3764t;

    /* JADX INFO: renamed from: u */
    public final DiskCacheConfig f3765u;

    /* JADX INFO: renamed from: v */
    public final C1897l f3766v;

    /* JADX INFO: renamed from: w */
    public final boolean f3767w;

    /* JADX INFO: renamed from: x */
    public final C1907a f3768x;

    /* JADX INFO: renamed from: y */
    public final InterfaceC1852a f3769y;

    /* JADX INFO: renamed from: b.f.j.e.j$a */
    /* JADX INFO: compiled from: ImagePipelineConfig.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        public Supplier<MemoryCacheParams> f3770a;

        /* JADX INFO: renamed from: b */
        public final Context f3771b;

        /* JADX INFO: renamed from: d */
        public DiskCacheConfig f3773d;

        /* JADX INFO: renamed from: e */
        public DiskCacheConfig f3774e;

        /* JADX INFO: renamed from: c */
        public boolean f3772c = false;

        /* JADX INFO: renamed from: f */
        public final C1897l.b f3775f = new C1897l.b(this);

        /* JADX INFO: renamed from: g */
        public boolean f3776g = true;

        /* JADX INFO: renamed from: h */
        public C1907a f3777h = new C1907a();

        public a(Context context, C1894i c1894i) {
            Objects.requireNonNull(context);
            this.f3771b = context;
        }
    }

    /* JADX INFO: renamed from: b.f.j.e.j$b */
    /* JADX INFO: compiled from: ImagePipelineConfig.java */
    public static class b {
        public b(C1894i c1894i) {
        }
    }

    public C1895j(a aVar, C1894i c1894i) {
        C1867n c1867n;
        C1879z c1879z;
        C2030b.m1527b();
        this.f3766v = new C1897l(aVar.f3775f, null);
        Supplier<MemoryCacheParams> defaultBitmapMemoryCacheParamsSupplier = aVar.f3770a;
        if (defaultBitmapMemoryCacheParamsSupplier == null) {
            Object systemService = aVar.f3771b.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Objects.requireNonNull(systemService);
            defaultBitmapMemoryCacheParamsSupplier = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) systemService);
        }
        this.f3746b = defaultBitmapMemoryCacheParamsSupplier;
        this.f3747c = new C1856c();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        synchronized (C1867n.class) {
            if (C1867n.f3684a == null) {
                C1867n.f3684a = new C1867n();
            }
            c1867n = C1867n.f3684a;
        }
        this.f3748d = c1867n;
        Context context = aVar.f3771b;
        Objects.requireNonNull(context);
        this.f3749e = context;
        this.f3751g = new C1888c(new C1889d());
        this.f3750f = aVar.f3772c;
        this.f3752h = new C1868o();
        synchronized (C1879z.class) {
            if (C1879z.f3703a == null) {
                C1879z.f3703a = new C1879z();
            }
            c1879z = C1879z.f3703a;
        }
        this.f3754j = c1879z;
        this.f3755k = new C1894i(this);
        DiskCacheConfig diskCacheConfig = aVar.f3773d;
        if (diskCacheConfig == null) {
            Context context2 = aVar.f3771b;
            try {
                C2030b.m1527b();
                diskCacheConfig = new DiskCacheConfig(new DiskCacheConfig.C10634b(context2, null));
                C2030b.m1527b();
            } finally {
                C2030b.m1527b();
            }
        }
        this.f3756l = diskCacheConfig;
        this.f3757m = C1697d.m990b();
        this.f3759o = 30000;
        C2030b.m1527b();
        this.f3758n = new C1963a0(30000);
        C2030b.m1527b();
        C1952x c1952x = new C1952x(new C1951w(new C1951w.b(null), null));
        this.f3760p = c1952x;
        this.f3761q = new C1913f();
        this.f3762r = new HashSet();
        this.f3763s = new HashSet();
        this.f3764t = true;
        DiskCacheConfig diskCacheConfig2 = aVar.f3774e;
        this.f3765u = diskCacheConfig2 != null ? diskCacheConfig2 : diskCacheConfig;
        this.f3753i = new C1887b(c1952x.m1407b());
        this.f3767w = aVar.f3776g;
        this.f3768x = aVar.f3777h;
        this.f3769y = new C1864k();
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: A */
    public Supplier<MemoryCacheParams> mo1264A() {
        return this.f3746b;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: B */
    public InterfaceC1909b mo1265B() {
        return null;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: C */
    public Supplier<MemoryCacheParams> mo1266C() {
        return this.f3752h;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: D */
    public InterfaceC1890e mo1267D() {
        return this.f3753i;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: a */
    public C1952x mo1268a() {
        return this.f3760p;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: b */
    public Set<InterfaceC1927d> mo1269b() {
        return Collections.unmodifiableSet(this.f3763s);
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: c */
    public int mo1270c() {
        return 0;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: d */
    public Supplier<Boolean> mo1271d() {
        return this.f3755k;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: e */
    public InterfaceC1891f mo1272e() {
        return this.f3751g;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: f */
    public C1907a mo1273f() {
        return this.f3768x;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: g */
    public InterfaceC1852a mo1274g() {
        return this.f3769y;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    public Context getContext() {
        return this.f3749e;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    public C1897l getExperiments() {
        return this.f3766v;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: h */
    public InterfaceC2002o0 mo1275h() {
        return this.f3758n;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: i */
    public InterfaceC1876w<CacheKey, PooledByteBuffer> mo1276i() {
        return null;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: j */
    public DiskCacheConfig mo1277j() {
        return this.f3756l;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: k */
    public Set<InterfaceC1928e> mo1278k() {
        return Collections.unmodifiableSet(this.f3762r);
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: l */
    public InterfaceC1862i mo1279l() {
        return this.f3748d;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: m */
    public boolean mo1280m() {
        return this.f3764t;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: n */
    public InterfaceC1876w.a mo1281n() {
        return this.f3747c;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: o */
    public InterfaceC1911d mo1282o() {
        return this.f3761q;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: p */
    public DiskCacheConfig mo1283p() {
        return this.f3765u;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: q */
    public InterfaceC1871r mo1284q() {
        return this.f3754j;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: r */
    public InterfaceC1866m.b<CacheKey> mo1285r() {
        return null;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: s */
    public boolean mo1286s() {
        return this.f3750f;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: t */
    public InterfaceExecutorServiceC1675f mo1287t() {
        return null;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: u */
    public Integer mo1288u() {
        return null;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: v */
    public InterfaceC2033c mo1289v() {
        return null;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: w */
    public InterfaceC1696c mo1290w() {
        return this.f3757m;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: x */
    public C1910c mo1291x() {
        return null;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: y */
    public boolean mo1292y() {
        return this.f3767w;
    }

    @Override // p007b.p109f.p161j.p170e.InterfaceC1896k
    /* JADX INFO: renamed from: z */
    public InterfaceC1667a mo1293z() {
        return null;
    }
}
