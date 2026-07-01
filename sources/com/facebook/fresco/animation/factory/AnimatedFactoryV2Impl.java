package com.facebook.fresco.animation.factory;

import android.content.Context;
import b.f.d.b.f;
import b.f.d.b.g;
import b.f.d.d.c;
import b.f.d.d.l;
import b.f.j.a.b.a;
import b.f.j.a.b.d;
import b.f.j.a.c.b;
import b.f.j.c.m;
import b.f.j.e.e;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
@c
public class AnimatedFactoryV2Impl implements a {
    public final PlatformBitmapFactory a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f2894b;
    public final m<CacheKey, b.f.j.j.c> c;
    public final boolean d;
    public d e;
    public b f;
    public b.f.j.a.d.a g;
    public b.f.j.i.a h;
    public f i;

    @c
    public AnimatedFactoryV2Impl(PlatformBitmapFactory platformBitmapFactory, e eVar, m<CacheKey, b.f.j.j.c> mVar, boolean z2, f fVar) {
        this.a = platformBitmapFactory;
        this.f2894b = eVar;
        this.c = mVar;
        this.d = z2;
        this.i = fVar;
    }

    @Override // b.f.j.a.b.a
    public b.f.j.i.a a(Context context) {
        if (this.h == null) {
            b.f.h.a.d.a aVar = new b.f.h.a.d.a(this);
            ExecutorService cVar = this.i;
            if (cVar == null) {
                cVar = new b.f.d.b.c(this.f2894b.a());
            }
            ExecutorService executorService = cVar;
            b.f.h.a.d.b bVar = new b.f.h.a.d.b(this);
            Supplier<Boolean> supplier = l.a;
            if (this.f == null) {
                this.f = new b.f.h.a.d.c(this);
            }
            b bVar2 = this.f;
            if (g.k == null) {
                g.k = new g();
            }
            this.h = new b.f.h.a.d.e(bVar2, g.k, executorService, RealtimeSinceBootClock.get(), this.a, this.c, aVar, bVar, supplier);
        }
        return this.h;
    }

    @Override // b.f.j.a.b.a
    public b.f.j.h.b b() {
        return new AnimatedFactoryV2Impl$a(this);
    }

    @Override // b.f.j.a.b.a
    public b.f.j.h.b c() {
        return new AnimatedFactoryV2Impl$b(this);
    }
}
