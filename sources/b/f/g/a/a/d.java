package b.f.g.a.a;

import android.content.Context;
import android.net.Uri;
import b.f.d.d.l;
import b.f.j.c.i;
import b.f.j.c.n;
import b.f.j.e.h;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder$b;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest$c;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Set;

/* JADX INFO: compiled from: PipelineDraweeControllerBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends AbstractDraweeControllerBuilder<d, ImageRequest, CloseableReference<b.f.j.j.c>, ImageInfo> {
    public final h o;
    public final f p;
    public b.f.g.a.a.h.e q;

    public d(Context context, f fVar, h hVar, Set<ControllerListener> set, Set<b.f.h.b.a.b> set2) {
        super(context, set, set2);
        this.o = hVar;
        this.p = fVar;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public DataSource<CloseableReference<b.f.j.j.c>> b(DraweeController draweeController, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder$b abstractDraweeControllerBuilder$b) {
        ImageRequest$c imageRequest$c;
        b.f.j.k.e eVar;
        ImageRequest imageRequest2 = imageRequest;
        h hVar = this.o;
        int iOrdinal = abstractDraweeControllerBuilder$b.ordinal();
        if (iOrdinal == 0) {
            imageRequest$c = ImageRequest$c.FULL_FETCH;
        } else if (iOrdinal == 1) {
            imageRequest$c = ImageRequest$c.DISK_CACHE;
        } else {
            if (iOrdinal != 2) {
                throw new RuntimeException("Cache level" + abstractDraweeControllerBuilder$b + "is not supported. ");
            }
            imageRequest$c = ImageRequest$c.BITMAP_MEMORY_CACHE;
        }
        ImageRequest$c imageRequest$c2 = imageRequest$c;
        b.f.g.a.a.h.c cVar = null;
        if (draweeController instanceof c) {
            c cVar2 = (c) draweeController;
            synchronized (cVar2) {
                b.f.g.a.a.h.b bVar = cVar2.G;
                cVar = bVar != null ? new b.f.g.a.a.h.c(cVar2.m, bVar) : null;
                Set<b.f.j.k.e> set = cVar2.F;
                if (set != null) {
                    b.f.j.k.c cVar3 = new b.f.j.k.c(set);
                    if (cVar != null) {
                        cVar3.a.add(cVar);
                    }
                    eVar = cVar3;
                } else {
                    eVar = cVar;
                }
            }
        } else {
            eVar = cVar;
        }
        return hVar.a(imageRequest2, obj, imageRequest$c2, eVar, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public AbstractDraweeController d() {
        c cVar;
        CacheKey cacheKey;
        CacheKey cacheKeyA;
        b.f.j.r.b.b();
        try {
            DraweeController draweeController = this.n;
            String strValueOf = String.valueOf(AbstractDraweeControllerBuilder.c.getAndIncrement());
            if (draweeController instanceof c) {
                cVar = (c) draweeController;
            } else {
                f fVar = this.p;
                c cVar2 = new c(fVar.a, fVar.f482b, fVar.c, fVar.d, fVar.e, fVar.f);
                Supplier<Boolean> supplier = fVar.g;
                if (supplier != null) {
                    cVar2.C = supplier.get().booleanValue();
                }
                cVar = cVar2;
            }
            Supplier<DataSource<CloseableReference<b.f.j.j.c>>> supplierE = e(cVar, strValueOf);
            ImageRequest imageRequest = (ImageRequest) this.h;
            i iVar = this.o.g;
            if (iVar == null || imageRequest == null) {
                cacheKey = null;
            } else {
                if (imageRequest.f2903s != null) {
                    cacheKeyA = ((n) iVar).c(imageRequest, this.g);
                } else {
                    cacheKeyA = ((n) iVar).a(imageRequest, this.g);
                }
                cacheKey = cacheKeyA;
            }
            cVar.H(supplierE, strValueOf, cacheKey, this.g, null, null);
            cVar.I(this.q, this, l.a);
            return cVar;
        } finally {
            b.f.j.r.b.b();
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    public d f(Uri uri) {
        if (uri == null) {
            this.h = null;
            return this;
        }
        ImageRequestBuilder imageRequestBuilderB = ImageRequestBuilder.b(uri);
        imageRequestBuilderB.e = b.f.j.d.f.f567b;
        this.h = imageRequestBuilderB.a();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d g(String str) {
        Uri uri;
        if (str != null && !str.isEmpty()) {
            return f(Uri.parse(str));
        }
        REQUEST requestA = 0;
        requestA = 0;
        requestA = 0;
        if (str != null && str.length() != 0 && (uri = Uri.parse(str)) != null) {
            requestA = ImageRequestBuilder.b(uri).a();
        }
        this.h = requestA;
        return this;
    }
}
