package b.f.j.p;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: PartialDiskCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class p0 implements z.c<b.f.j.j.e, Void> {
    public final /* synthetic */ z0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x0 f633b;
    public final /* synthetic */ l c;
    public final /* synthetic */ CacheKey d;
    public final /* synthetic */ r0 e;

    public p0(r0 r0Var, z0 z0Var, x0 x0Var, l lVar, CacheKey cacheKey) {
        this.e = r0Var;
        this.a = z0Var;
        this.f633b = x0Var;
        this.c = lVar;
        this.d = cacheKey;
    }

    @Override // z.c
    public Void a(z.g<b.f.j.j.e> gVar) throws Exception {
        boolean z2;
        b.f.j.j.e eVar;
        synchronized (gVar.g) {
            z2 = gVar.i;
        }
        if (z2 || (gVar.e() && (gVar.d() instanceof CancellationException))) {
            this.a.d(this.f633b, "PartialDiskCacheProducer", null);
            this.c.d();
        } else if (gVar.e()) {
            this.a.k(this.f633b, "PartialDiskCacheProducer", gVar.d(), null);
            this.e.d(this.c, this.f633b, this.d, null);
        } else {
            synchronized (gVar.g) {
                eVar = gVar.j;
            }
            b.f.j.j.e eVar2 = eVar;
            if (eVar2 != null) {
                z0 z0Var = this.a;
                x0 x0Var = this.f633b;
                z0Var.j(x0Var, "PartialDiskCacheProducer", r0.c(z0Var, x0Var, true, eVar2.n()));
                int iN = eVar2.n() - 1;
                b.c.a.a0.d.i(Boolean.valueOf(iN > 0));
                eVar2.f590s = new b.f.j.d.a(0, iN);
                int iN2 = eVar2.n();
                ImageRequest imageRequestE = this.f633b.e();
                b.f.j.d.a aVar = imageRequestE.l;
                if (aVar != null && aVar.a >= 0 && iN >= aVar.f563b) {
                    this.f633b.i("disk", "partial");
                    this.a.c(this.f633b, "PartialDiskCacheProducer", true);
                    this.c.b(eVar2, 9);
                } else {
                    this.c.b(eVar2, 8);
                    ImageRequestBuilder imageRequestBuilderB = ImageRequestBuilder.b(imageRequestE.c);
                    imageRequestBuilderB.f = imageRequestE.i;
                    imageRequestBuilderB.o = imageRequestE.l;
                    imageRequestBuilderB.g = imageRequestE.f2902b;
                    imageRequestBuilderB.i = imageRequestE.g;
                    imageRequestBuilderB.j = imageRequestE.h;
                    imageRequestBuilderB.f2904b = imageRequestE.n;
                    imageRequestBuilderB.c = imageRequestE.o;
                    imageRequestBuilderB.l = imageRequestE.f2903s;
                    imageRequestBuilderB.h = imageRequestE.f;
                    imageRequestBuilderB.k = imageRequestE.m;
                    imageRequestBuilderB.d = imageRequestE.j;
                    imageRequestBuilderB.n = imageRequestE.t;
                    imageRequestBuilderB.e = imageRequestE.k;
                    imageRequestBuilderB.m = imageRequestE.r;
                    imageRequestBuilderB.p = imageRequestE.u;
                    int i = iN2 - 1;
                    b.c.a.a0.d.i(Boolean.valueOf(i >= 0));
                    imageRequestBuilderB.o = new b.f.j.d.a(i, Integer.MAX_VALUE);
                    this.e.d(this.c, new d1(imageRequestBuilderB.a(), this.f633b), this.d, eVar2);
                }
            } else {
                z0 z0Var2 = this.a;
                x0 x0Var2 = this.f633b;
                z0Var2.j(x0Var2, "PartialDiskCacheProducer", r0.c(z0Var2, x0Var2, false, 0));
                this.e.d(this.c, this.f633b, this.d, eVar2);
            }
        }
        return null;
    }
}
