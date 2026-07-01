package b.f.j.e;

import android.content.Context;
import b.f.j.c.m$b;
import b.f.j.c.r;
import b.f.j.c.w;
import b.f.j.c.w$a;
import b.f.j.l.x;
import b.f.j.p.o0;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.Set;

/* JADX INFO: compiled from: ImagePipelineConfigInterface.java */
/* JADX INFO: loaded from: classes.dex */
public interface k {
    Supplier<MemoryCacheParams> A();

    b.f.j.h.b B();

    Supplier<MemoryCacheParams> C();

    e D();

    x a();

    Set<b.f.j.k.d> b();

    int c();

    Supplier<Boolean> d();

    f e();

    b.f.j.g.a f();

    b.f.j.c.a g();

    Context getContext();

    l getExperiments();

    o0 h();

    w<CacheKey, PooledByteBuffer> i();

    DiskCacheConfig j();

    Set<b.f.j.k.e> k();

    b.f.j.c.i l();

    boolean m();

    w$a n();

    b.f.j.h.d o();

    DiskCacheConfig p();

    r q();

    m$b<CacheKey> r();

    boolean s();

    b.f.d.b.f t();

    Integer u();

    b.f.j.s.c v();

    b.f.d.g.c w();

    b.f.j.h.c x();

    boolean y();

    b.f.c.a z();
}
