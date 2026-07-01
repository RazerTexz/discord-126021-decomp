package b.f.g.a.a;

import android.content.Context;
import android.content.res.Resources;
import b.f.d.b.g;
import b.f.j.c.w;
import b.f.j.e.h;
import b.f.j.e.m;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;

/* JADX INFO: compiled from: PipelineDraweeControllerBuilderSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements Supplier<d> {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f481b;
    public final f c;

    public e(Context context) {
        b.f.g.b.a aVar;
        m mVar = m.a;
        b.c.a.a0.d.y(mVar, "ImagePipelineFactory was not initialized!");
        this.a = context;
        if (mVar.l == null) {
            mVar.l = mVar.a();
        }
        h hVar = mVar.l;
        this.f481b = hVar;
        f fVar = new f();
        this.c = fVar;
        Resources resources = context.getResources();
        synchronized (b.f.g.b.a.class) {
            if (b.f.g.b.a.a == null) {
                b.f.g.b.a.a = new b.f.g.b.b();
            }
            aVar = b.f.g.b.a.a;
        }
        b.f.j.a.b.a aVarB = mVar.b();
        b.f.j.i.a aVarA = aVarB == null ? null : aVarB.a(context);
        if (g.k == null) {
            g.k = new g();
        }
        g gVar = g.k;
        w<CacheKey, b.f.j.j.c> wVar = hVar.e;
        fVar.a = resources;
        fVar.f482b = aVar;
        fVar.c = aVarA;
        fVar.d = gVar;
        fVar.e = wVar;
        fVar.f = null;
        fVar.g = null;
    }

    public d a() {
        d dVar = new d(this.a, this.c, this.f481b, null, null);
        dVar.q = null;
        return dVar;
    }

    @Override // com.facebook.common.internal.Supplier
    public /* bridge */ /* synthetic */ d get() {
        return a();
    }
}
