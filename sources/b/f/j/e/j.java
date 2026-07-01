package b.f.j.e;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap$Config;
import androidx.appcompat.widget.ActivityChooserModel;
import b.f.j.c.m$b;
import b.f.j.c.r;
import b.f.j.c.w$a;
import b.f.j.c.z;
import b.f.j.l.w;
import b.f.j.l.w$b;
import b.f.j.l.x;
import b.f.j.p.a0;
import b.f.j.p.o0;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskCacheConfig$b;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: ImagePipelineConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements k {
    public static j$b a = new j$b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Supplier<MemoryCacheParams> f570b;
    public final w$a c;
    public final b.f.j.c.i d;
    public final Context e;
    public final boolean f;
    public final f g;
    public final Supplier<MemoryCacheParams> h;
    public final e i;
    public final r j;
    public final Supplier<Boolean> k;
    public final DiskCacheConfig l;
    public final b.f.d.g.c m;
    public final o0 n;
    public final int o;
    public final x p;
    public final b.f.j.h.d q;
    public final Set<b.f.j.k.e> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Set<b.f.j.k.d> f571s;
    public final boolean t;
    public final DiskCacheConfig u;
    public final l v;
    public final boolean w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b.f.j.g.a f572x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b.f.j.c.a f573y;

    public j(j$a j_a, i iVar) {
        b.f.j.c.n nVar;
        z zVar;
        b.f.j.r.b.b();
        this.v = new l(j_a.f, null);
        Supplier<MemoryCacheParams> defaultBitmapMemoryCacheParamsSupplier = j_a.a;
        if (defaultBitmapMemoryCacheParamsSupplier == null) {
            Object systemService = j_a.f574b.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Objects.requireNonNull(systemService);
            defaultBitmapMemoryCacheParamsSupplier = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) systemService);
        }
        this.f570b = defaultBitmapMemoryCacheParamsSupplier;
        this.c = new b.f.j.c.c();
        Bitmap$Config bitmap$Config = Bitmap$Config.ARGB_8888;
        synchronized (b.f.j.c.n.class) {
            if (b.f.j.c.n.a == null) {
                b.f.j.c.n.a = new b.f.j.c.n();
            }
            nVar = b.f.j.c.n.a;
        }
        this.d = nVar;
        Context context = j_a.f574b;
        Objects.requireNonNull(context);
        this.e = context;
        this.g = new c(new d());
        this.f = j_a.c;
        this.h = new b.f.j.c.o();
        synchronized (z.class) {
            if (z.a == null) {
                z.a = new z();
            }
            zVar = z.a;
        }
        this.j = zVar;
        this.k = new i(this);
        DiskCacheConfig diskCacheConfig = j_a.d;
        if (diskCacheConfig == null) {
            Context context2 = j_a.f574b;
            try {
                b.f.j.r.b.b();
                diskCacheConfig = new DiskCacheConfig(new DiskCacheConfig$b(context2, null));
                b.f.j.r.b.b();
            } finally {
                b.f.j.r.b.b();
            }
        }
        this.l = diskCacheConfig;
        this.m = b.f.d.g.d.b();
        this.o = 30000;
        b.f.j.r.b.b();
        this.n = new a0(30000);
        b.f.j.r.b.b();
        x xVar = new x(new w(new w$b(null), null));
        this.p = xVar;
        this.q = new b.f.j.h.f();
        this.r = new HashSet();
        this.f571s = new HashSet();
        this.t = true;
        DiskCacheConfig diskCacheConfig2 = j_a.e;
        this.u = diskCacheConfig2 != null ? diskCacheConfig2 : diskCacheConfig;
        this.i = new b(xVar.b());
        this.w = j_a.g;
        this.f572x = j_a.h;
        this.f573y = new b.f.j.c.k();
    }

    @Override // b.f.j.e.k
    public Supplier<MemoryCacheParams> A() {
        return this.f570b;
    }

    @Override // b.f.j.e.k
    public b.f.j.h.b B() {
        return null;
    }

    @Override // b.f.j.e.k
    public Supplier<MemoryCacheParams> C() {
        return this.h;
    }

    @Override // b.f.j.e.k
    public e D() {
        return this.i;
    }

    @Override // b.f.j.e.k
    public x a() {
        return this.p;
    }

    @Override // b.f.j.e.k
    public Set<b.f.j.k.d> b() {
        return Collections.unmodifiableSet(this.f571s);
    }

    @Override // b.f.j.e.k
    public int c() {
        return 0;
    }

    @Override // b.f.j.e.k
    public Supplier<Boolean> d() {
        return this.k;
    }

    @Override // b.f.j.e.k
    public f e() {
        return this.g;
    }

    @Override // b.f.j.e.k
    public b.f.j.g.a f() {
        return this.f572x;
    }

    @Override // b.f.j.e.k
    public b.f.j.c.a g() {
        return this.f573y;
    }

    @Override // b.f.j.e.k
    public Context getContext() {
        return this.e;
    }

    @Override // b.f.j.e.k
    public l getExperiments() {
        return this.v;
    }

    @Override // b.f.j.e.k
    public o0 h() {
        return this.n;
    }

    @Override // b.f.j.e.k
    public b.f.j.c.w<CacheKey, PooledByteBuffer> i() {
        return null;
    }

    @Override // b.f.j.e.k
    public DiskCacheConfig j() {
        return this.l;
    }

    @Override // b.f.j.e.k
    public Set<b.f.j.k.e> k() {
        return Collections.unmodifiableSet(this.r);
    }

    @Override // b.f.j.e.k
    public b.f.j.c.i l() {
        return this.d;
    }

    @Override // b.f.j.e.k
    public boolean m() {
        return this.t;
    }

    @Override // b.f.j.e.k
    public w$a n() {
        return this.c;
    }

    @Override // b.f.j.e.k
    public b.f.j.h.d o() {
        return this.q;
    }

    @Override // b.f.j.e.k
    public DiskCacheConfig p() {
        return this.u;
    }

    @Override // b.f.j.e.k
    public r q() {
        return this.j;
    }

    @Override // b.f.j.e.k
    public m$b<CacheKey> r() {
        return null;
    }

    @Override // b.f.j.e.k
    public boolean s() {
        return this.f;
    }

    @Override // b.f.j.e.k
    public b.f.d.b.f t() {
        return null;
    }

    @Override // b.f.j.e.k
    public Integer u() {
        return null;
    }

    @Override // b.f.j.e.k
    public b.f.j.s.c v() {
        return null;
    }

    @Override // b.f.j.e.k
    public b.f.d.g.c w() {
        return this.m;
    }

    @Override // b.f.j.e.k
    public b.f.j.h.c x() {
        return null;
    }

    @Override // b.f.j.e.k
    public boolean y() {
        return this.w;
    }

    @Override // b.f.j.e.k
    public b.f.c.a z() {
        return null;
    }
}
