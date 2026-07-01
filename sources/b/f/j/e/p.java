package b.f.j.e;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import b.f.j.c.w;
import b.f.j.p.c1;
import b.f.j.p.w0;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;

/* JADX INFO: compiled from: ProducerFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class p {
    public ContentResolver a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources f579b;
    public AssetManager c;
    public final b.f.d.g.a d;
    public final b.f.j.h.b e;
    public final b.f.j.h.d f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final e j;
    public final b.f.d.g.g k;
    public final b.f.j.c.f l;
    public final b.f.j.c.f m;
    public final w<CacheKey, PooledByteBuffer> n;
    public final w<CacheKey, b.f.j.j.c> o;
    public final b.f.j.c.i p;
    public final b.f.j.c.d<CacheKey> q;
    public final b.f.j.c.d<CacheKey> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final PlatformBitmapFactory f580s;
    public final int t;
    public final int u;
    public boolean v;
    public final a w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f581x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f582y;

    public p(Context context, b.f.d.g.a aVar, b.f.j.h.b bVar, b.f.j.h.d dVar, boolean z2, boolean z3, boolean z4, e eVar, b.f.d.g.g gVar, w<CacheKey, b.f.j.j.c> wVar, w<CacheKey, PooledByteBuffer> wVar2, b.f.j.c.f fVar, b.f.j.c.f fVar2, b.f.j.c.i iVar, PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z5, int i3, a aVar2, boolean z6, int i4) {
        this.a = context.getApplicationContext().getContentResolver();
        this.f579b = context.getApplicationContext().getResources();
        this.c = context.getApplicationContext().getAssets();
        this.d = aVar;
        this.e = bVar;
        this.f = dVar;
        this.g = z2;
        this.h = z3;
        this.i = z4;
        this.j = eVar;
        this.k = gVar;
        this.o = wVar;
        this.n = wVar2;
        this.l = fVar;
        this.m = fVar2;
        this.p = iVar;
        this.f580s = platformBitmapFactory;
        this.q = new b.f.j.c.d<>(i4);
        this.r = new b.f.j.c.d<>(i4);
        this.t = i;
        this.u = i2;
        this.v = z5;
        this.f581x = i3;
        this.w = aVar2;
        this.f582y = z6;
    }

    public c1 a(w0<b.f.j.j.e> w0Var, boolean z2, b.f.j.s.c cVar) {
        return new c1(this.j.c(), this.k, w0Var, z2, cVar);
    }
}
