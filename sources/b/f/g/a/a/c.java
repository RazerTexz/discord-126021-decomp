package b.f.g.a.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.os.EnvironmentCompat;
import b.f.d.d.i;
import b.f.g.a.a.h.h;
import b.f.g.e.p;
import b.f.j.c.w;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PipelineDraweeController.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends AbstractDraweeController<CloseableReference<b.f.j.j.c>, ImageInfo> {
    public CacheKey A;
    public Supplier<DataSource<CloseableReference<b.f.j.j.c>>> B;
    public boolean C;
    public b.f.d.d.e<b.f.j.i.a> D;
    public b.f.g.a.a.h.f E;
    public Set<b.f.j.k.e> F;
    public b.f.g.a.a.h.b G;
    public b.f.g.a.a.g.b H;
    public ImageRequest I;
    public ImageRequest[] J;
    public ImageRequest K;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b.f.j.i.a f478x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b.f.d.d.e<b.f.j.i.a> f479y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final w<CacheKey, b.f.j.j.c> f480z;

    public c(Resources resources, b.f.g.b.a aVar, b.f.j.i.a aVar2, Executor executor, w<CacheKey, b.f.j.j.c> wVar, b.f.d.d.e<b.f.j.i.a> eVar) {
        super(aVar, executor, null, null);
        this.f478x = new a(resources, aVar2);
        this.f479y = eVar;
        this.f480z = wVar;
    }

    public synchronized void F(b.f.g.a.a.h.b bVar) {
        b.f.g.a.a.h.b bVar2 = this.G;
        if (bVar2 instanceof b.f.g.a.a.h.a) {
            b.f.g.a.a.h.a aVar = (b.f.g.a.a.h.a) bVar2;
            synchronized (aVar) {
                aVar.a.add(bVar);
            }
        } else if (bVar2 != null) {
            this.G = new b.f.g.a.a.h.a(bVar2, bVar);
        } else {
            this.G = bVar;
        }
    }

    public synchronized void G(b.f.j.k.e eVar) {
        if (this.F == null) {
            this.F = new HashSet();
        }
        this.F.add(eVar);
    }

    public void H(Supplier<DataSource<CloseableReference<b.f.j.j.c>>> supplier, String str, CacheKey cacheKey, Object obj, b.f.d.d.e<b.f.j.i.a> eVar, b.f.g.a.a.h.b bVar) {
        b.f.j.r.b.b();
        n(str, obj);
        this.v = false;
        this.B = supplier;
        K(null);
        this.A = cacheKey;
        this.D = null;
        synchronized (this) {
            this.G = null;
        }
        K(null);
        F(null);
        b.f.j.r.b.b();
    }

    public synchronized void I(b.f.g.a.a.h.e eVar, AbstractDraweeControllerBuilder<d, ImageRequest, CloseableReference<b.f.j.j.c>, ImageInfo> abstractDraweeControllerBuilder, Supplier<Boolean> supplier) {
        b.f.g.a.a.h.f fVar = this.E;
        if (fVar != null) {
            List<b.f.g.a.a.h.e> list = fVar.j;
            if (list != null) {
                list.clear();
            }
            fVar.c(false);
            fVar.c.a();
        }
        if (eVar != null) {
            if (this.E == null) {
                this.E = new b.f.g.a.a.h.f(AwakeTimeSinceBootClock.get(), this, supplier);
            }
            b.f.g.a.a.h.f fVar2 = this.E;
            Objects.requireNonNull(fVar2);
            if (fVar2.j == null) {
                fVar2.j = new CopyOnWriteArrayList();
            }
            fVar2.j.add(eVar);
            this.E.c(true);
            h hVar = this.E.c;
            ImageRequest imageRequest = abstractDraweeControllerBuilder.h;
            ImageRequest[] imageRequestArr = abstractDraweeControllerBuilder.i;
            hVar.f = imageRequest;
            hVar.g = null;
            hVar.h = imageRequestArr;
        }
        this.I = abstractDraweeControllerBuilder.h;
        this.J = abstractDraweeControllerBuilder.i;
        this.K = null;
    }

    public final Drawable J(b.f.d.d.e<b.f.j.i.a> eVar, b.f.j.j.c cVar) {
        Drawable drawableB;
        if (eVar == null) {
            return null;
        }
        for (b.f.j.i.a aVar : eVar) {
            if (aVar.a(cVar) && (drawableB = aVar.b(cVar)) != null) {
                return drawableB;
            }
        }
        return null;
    }

    public final void K(b.f.j.j.c cVar) {
        String str;
        p pVarP0;
        if (this.C) {
            if (this.l == null) {
                b.f.g.d.a aVar = new b.f.g.d.a();
                b.f.g.d.b.a aVar2 = new b.f.g.d.b.a(aVar);
                this.H = new b.f.g.a.a.g.b();
                f(aVar2);
                this.l = aVar;
                b.f.g.h.a aVar3 = this.k;
                if (aVar3 != null) {
                    aVar3.a(aVar);
                }
            }
            if (this.G == null) {
                F(this.H);
            }
            Drawable drawable = this.l;
            if (drawable instanceof b.f.g.d.a) {
                b.f.g.d.a aVar4 = (b.f.g.d.a) drawable;
                String str2 = this.m;
                if (str2 == null) {
                    str2 = "none";
                }
                aVar4.j = str2;
                aVar4.invalidateSelf();
                b.f.g.h.a aVar5 = this.k;
                ScalingUtils$ScaleType scalingUtils$ScaleType = null;
                if (aVar5 != null && (pVarP0 = b.c.a.a0.d.p0(aVar5.e())) != null) {
                    scalingUtils$ScaleType = pVarP0.n;
                }
                aVar4.n = scalingUtils$ScaleType;
                int i = this.H.a;
                switch (i) {
                    case 2:
                        str = "network";
                        break;
                    case 3:
                        str = "disk";
                        break;
                    case 4:
                        str = "memory_encoded";
                        break;
                    case 5:
                        str = "memory_bitmap";
                        break;
                    case 6:
                        str = "memory_bitmap_shortcut";
                        break;
                    case 7:
                        str = "local";
                        break;
                    default:
                        str = EnvironmentCompat.MEDIA_UNKNOWN;
                        break;
                }
                int i2 = b.f.g.a.a.g.a.a.get(i, -1);
                aVar4.C = str;
                aVar4.D = i2;
                aVar4.invalidateSelf();
                if (cVar == null) {
                    aVar4.c();
                    return;
                }
                int width = cVar.getWidth();
                int height = cVar.getHeight();
                aVar4.k = width;
                aVar4.l = height;
                aVar4.invalidateSelf();
                aVar4.m = cVar.c();
            }
        }
    }

    public synchronized void L(b.f.j.k.e eVar) {
        Set<b.f.j.k.e> set = this.F;
        if (set == null) {
            return;
        }
        set.remove(eVar);
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController, com.facebook.drawee.interfaces.DraweeController
    public void e(DraweeHierarchy draweeHierarchy) {
        super.e(draweeHierarchy);
        K(null);
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public Drawable g(CloseableReference<b.f.j.j.c> closeableReference) {
        CloseableReference<b.f.j.j.c> closeableReference2 = closeableReference;
        try {
            b.f.j.r.b.b();
            b.c.a.a0.d.B(CloseableReference.y(closeableReference2));
            b.f.j.j.c cVarU = closeableReference2.u();
            K(cVarU);
            Drawable drawableJ = J(this.D, cVarU);
            if (drawableJ == null && (drawableJ = J(this.f479y, cVarU)) == null && (drawableJ = this.f478x.b(cVarU)) == null) {
                throw new UnsupportedOperationException("Unrecognized image class: " + cVarU);
            }
            b.f.j.r.b.b();
            return drawableJ;
        } catch (Throwable th) {
            b.f.j.r.b.b();
            throw th;
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public CloseableReference<b.f.j.j.c> h() {
        CacheKey cacheKey;
        b.f.j.r.b.b();
        try {
            w<CacheKey, b.f.j.j.c> wVar = this.f480z;
            if (wVar != null && (cacheKey = this.A) != null) {
                CloseableReference<b.f.j.j.c> closeableReference = wVar.get(cacheKey);
                if (closeableReference == null || ((b.f.j.j.h) closeableReference.u().b()).d) {
                    return closeableReference;
                }
                closeableReference.close();
            }
            return null;
        } finally {
            b.f.j.r.b.b();
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public DataSource<CloseableReference<b.f.j.j.c>> j() {
        b.f.j.r.b.b();
        if (b.f.d.e.a.h(2)) {
            System.identityHashCode(this);
        }
        DataSource<CloseableReference<b.f.j.j.c>> dataSource = this.B.get();
        b.f.j.r.b.b();
        return dataSource;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public int k(CloseableReference<b.f.j.j.c> closeableReference) {
        CloseableReference<b.f.j.j.c> closeableReference2 = closeableReference;
        if (closeableReference2 == null || !closeableReference2.x()) {
            return 0;
        }
        return System.identityHashCode(closeableReference2.o.c());
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public ImageInfo l(CloseableReference<b.f.j.j.c> closeableReference) {
        CloseableReference<b.f.j.j.c> closeableReference2 = closeableReference;
        b.c.a.a0.d.B(CloseableReference.y(closeableReference2));
        return closeableReference2.u();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0021, code lost:
    
        if (r0 != null) goto L6;
     */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Uri m() {
        Uri uri;
        ImageRequest imageRequest = this.I;
        ImageRequest imageRequest2 = this.K;
        ImageRequest[] imageRequestArr = this.J;
        if (imageRequest == null || (uri = imageRequest.c) == null) {
            if (imageRequestArr != null && imageRequestArr.length > 0 && imageRequestArr[0] != null) {
                ImageRequest imageRequest3 = imageRequestArr[0];
                uri = imageRequest3 != null ? imageRequest3.c : null;
            }
            if (imageRequest2 != null) {
                return imageRequest2.c;
            }
            return null;
        }
        return uri;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public Map t(ImageInfo imageInfo) {
        ImageInfo imageInfo2 = imageInfo;
        if (imageInfo2 == null) {
            return null;
        }
        return imageInfo2.a();
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public String toString() {
        i iVarH2 = b.c.a.a0.d.h2(this);
        iVarH2.c("super", super.toString());
        iVarH2.c("dataSourceSupplier", this.B);
        return iVarH2.toString();
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public void v(String str, CloseableReference<b.f.j.j.c> closeableReference) {
        synchronized (this) {
            b.f.g.a.a.h.b bVar = this.G;
            if (bVar != null) {
                bVar.a(str, 6, true, "PipelineDraweeController");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public void x(Drawable drawable) {
        if (drawable instanceof b.f.f.a.a) {
            ((b.f.f.a.a) drawable).a();
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public void z(CloseableReference<b.f.j.j.c> closeableReference) {
        CloseableReference<b.f.j.j.c> closeableReference2 = closeableReference;
        Class<CloseableReference> cls = CloseableReference.j;
        if (closeableReference2 != null) {
            closeableReference2.close();
        }
    }
}
