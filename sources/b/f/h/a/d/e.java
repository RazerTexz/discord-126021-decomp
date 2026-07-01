package b.f.h.a.d;

import android.graphics.Bitmap$Config;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import b.f.j.c.m;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: ExperimentalBitmapAnimationDrawableFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements b.f.j.i.a {
    public final b.f.j.a.c.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f536b;
    public final ExecutorService c;
    public final b.f.d.k.b d;
    public final PlatformBitmapFactory e;
    public final m<CacheKey, b.f.j.j.c> f;
    public final Supplier<Integer> g;
    public final Supplier<Integer> h;
    public final Supplier<Boolean> i;

    public e(b.f.j.a.c.b bVar, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, b.f.d.k.b bVar2, PlatformBitmapFactory platformBitmapFactory, m<CacheKey, b.f.j.j.c> mVar, Supplier<Integer> supplier, Supplier<Integer> supplier2, Supplier<Boolean> supplier3) {
        this.a = bVar;
        this.f536b = scheduledExecutorService;
        this.c = executorService;
        this.d = bVar2;
        this.e = platformBitmapFactory;
        this.f = mVar;
        this.g = supplier;
        this.h = supplier2;
        this.i = supplier3;
    }

    @Override // b.f.j.i.a
    public boolean a(b.f.j.j.c cVar) {
        return cVar instanceof b.f.j.j.a;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0089  */
    /* JADX WARN: Code duplicated, block: B:35:0x0093  */
    @Override // b.f.j.i.a
    public Drawable b(b.f.j.j.c cVar) {
        b.f.j.a.a.c cVar2;
        b.f.j.a.a.e eVar;
        b.f.h.a.b.d.b bVar;
        b.f.h.a.b.b dVar;
        b.f.h.a.b.f.b bVar2;
        int iIntValue;
        b.f.h.a.b.e.d dVar2;
        b.f.h.a.b.e.c cVar3;
        b.f.j.j.a aVar = (b.f.j.j.a) cVar;
        synchronized (aVar) {
            b.f.j.a.a.e eVar2 = aVar.l;
            cVar2 = eVar2 == null ? null : eVar2.a;
        }
        synchronized (aVar) {
            eVar = aVar.l;
        }
        Objects.requireNonNull(eVar);
        Bitmap$Config bitmap$ConfigD = cVar2 != null ? cVar2.d() : null;
        b.f.j.a.a.c cVar4 = eVar.a;
        b.f.j.a.a.a aVarA = this.a.a(eVar, new Rect(0, 0, cVar4.getWidth(), cVar4.getHeight()));
        int iIntValue2 = this.g.get().intValue();
        if (iIntValue2 != 1) {
            if (iIntValue2 != 2) {
                dVar = iIntValue2 != 3 ? new b.f.h.a.b.d.d() : new b.f.h.a.b.d.c();
            } else {
                bVar = new b.f.h.a.b.d.b(c(eVar), false);
            }
            b.f.h.a.b.b bVar3 = dVar;
            bVar2 = new b.f.h.a.b.f.b(bVar3, aVarA);
            iIntValue = this.h.get().intValue();
            if (iIntValue > 0) {
                b.f.h.a.b.e.d dVar3 = new b.f.h.a.b.e.d(iIntValue);
                PlatformBitmapFactory platformBitmapFactory = this.e;
                if (bitmap$ConfigD == null) {
                    bitmap$ConfigD = Bitmap$Config.ARGB_8888;
                }
                dVar2 = dVar3;
                cVar3 = new b.f.h.a.b.e.c(platformBitmapFactory, bVar2, bitmap$ConfigD, this.c);
            } else {
                dVar2 = null;
                cVar3 = null;
            }
            b.f.h.a.b.a aVar2 = new b.f.h.a.b.a(this.e, bVar3, new b.f.h.a.b.f.a(aVarA), bVar2, dVar2, cVar3);
            return new b.f.h.a.c.a(new b.f.h.a.a.c(aVar2, aVar2, this.d, this.f536b));
        }
        bVar = new b.f.h.a.b.d.b(c(eVar), true);
        dVar = bVar;
        b.f.h.a.b.b bVar4 = dVar;
        bVar2 = new b.f.h.a.b.f.b(bVar4, aVarA);
        iIntValue = this.h.get().intValue();
        if (iIntValue > 0) {
            b.f.h.a.b.e.d dVar4 = new b.f.h.a.b.e.d(iIntValue);
            PlatformBitmapFactory platformBitmapFactory2 = this.e;
            if (bitmap$ConfigD == null) {
                bitmap$ConfigD = Bitmap$Config.ARGB_8888;
            }
            dVar2 = dVar4;
            cVar3 = new b.f.h.a.b.e.c(platformBitmapFactory2, bVar2, bitmap$ConfigD, this.c);
        } else {
            dVar2 = null;
            cVar3 = null;
        }
        b.f.h.a.b.a aVar3 = new b.f.h.a.b.a(this.e, bVar4, new b.f.h.a.b.f.a(aVarA), bVar2, dVar2, cVar3);
        return new b.f.h.a.c.a(new b.f.h.a.a.c(aVar3, aVar3, this.d, this.f536b));
    }

    public final b.f.j.a.c.c c(b.f.j.a.a.e eVar) {
        return new b.f.j.a.c.c(new b.f.h.a.b.d.a(eVar.hashCode(), Boolean.FALSE.booleanValue()), this.f);
    }
}
