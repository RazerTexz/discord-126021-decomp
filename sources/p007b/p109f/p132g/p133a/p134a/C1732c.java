package p007b.p109f.p132g.p133a.p134a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.os.EnvironmentCompat;
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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.C1682e;
import p007b.p109f.p115d.p119d.C1686i;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p130f.p131a.InterfaceC1729a;
import p007b.p109f.p132g.p133a.p134a.p135g.C1736a;
import p007b.p109f.p132g.p133a.p134a.p135g.C1737b;
import p007b.p109f.p132g.p133a.p134a.p136h.C1738a;
import p007b.p109f.p132g.p133a.p134a.p136h.C1743f;
import p007b.p109f.p132g.p133a.p134a.p136h.C1745h;
import p007b.p109f.p132g.p133a.p134a.p136h.InterfaceC1739b;
import p007b.p109f.p132g.p133a.p134a.p136h.InterfaceC1742e;
import p007b.p109f.p132g.p138b.AbstractC1749a;
import p007b.p109f.p132g.p140d.C1757a;
import p007b.p109f.p132g.p140d.p141b.C1758a;
import p007b.p109f.p132g.p142e.C1782p;
import p007b.p109f.p132g.p145h.InterfaceC1798a;
import p007b.p109f.p161j.p168c.InterfaceC1876w;
import p007b.p109f.p161j.p174i.InterfaceC1914a;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p175j.C1922h;
import p007b.p109f.p161j.p176k.InterfaceC1928e;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: renamed from: b.f.g.a.a.c */
/* JADX INFO: compiled from: PipelineDraweeController.java */
/* JADX INFO: loaded from: classes.dex */
public class C1732c extends AbstractDraweeController<CloseableReference<AbstractC1917c>, ImageInfo> {

    /* JADX INFO: renamed from: A */
    public CacheKey f3170A;

    /* JADX INFO: renamed from: B */
    public Supplier<DataSource<CloseableReference<AbstractC1917c>>> f3171B;

    /* JADX INFO: renamed from: C */
    public boolean f3172C;

    /* JADX INFO: renamed from: D */
    public C1682e<InterfaceC1914a> f3173D;

    /* JADX INFO: renamed from: E */
    public C1743f f3174E;

    /* JADX INFO: renamed from: F */
    public Set<InterfaceC1928e> f3175F;

    /* JADX INFO: renamed from: G */
    public InterfaceC1739b f3176G;

    /* JADX INFO: renamed from: H */
    public C1737b f3177H;

    /* JADX INFO: renamed from: I */
    public ImageRequest f3178I;

    /* JADX INFO: renamed from: J */
    public ImageRequest[] f3179J;

    /* JADX INFO: renamed from: K */
    public ImageRequest f3180K;

    /* JADX INFO: renamed from: x */
    public final InterfaceC1914a f3181x;

    /* JADX INFO: renamed from: y */
    public final C1682e<InterfaceC1914a> f3182y;

    /* JADX INFO: renamed from: z */
    public final InterfaceC1876w<CacheKey, AbstractC1917c> f3183z;

    public C1732c(Resources resources, AbstractC1749a abstractC1749a, InterfaceC1914a interfaceC1914a, Executor executor, InterfaceC1876w<CacheKey, AbstractC1917c> interfaceC1876w, C1682e<InterfaceC1914a> c1682e) {
        super(abstractC1749a, executor, null, null);
        this.f3181x = new C1730a(resources, interfaceC1914a);
        this.f3182y = c1682e;
        this.f3183z = interfaceC1876w;
    }

    /* JADX INFO: renamed from: F */
    public synchronized void m1038F(InterfaceC1739b interfaceC1739b) {
        InterfaceC1739b interfaceC1739b2 = this.f3176G;
        if (interfaceC1739b2 instanceof C1738a) {
            C1738a c1738a = (C1738a) interfaceC1739b2;
            synchronized (c1738a) {
                c1738a.f3199a.add(interfaceC1739b);
            }
        } else if (interfaceC1739b2 != null) {
            this.f3176G = new C1738a(interfaceC1739b2, interfaceC1739b);
        } else {
            this.f3176G = interfaceC1739b;
        }
    }

    /* JADX INFO: renamed from: G */
    public synchronized void m1039G(InterfaceC1928e interfaceC1928e) {
        if (this.f3175F == null) {
            this.f3175F = new HashSet();
        }
        this.f3175F.add(interfaceC1928e);
    }

    /* JADX INFO: renamed from: H */
    public void m1040H(Supplier<DataSource<CloseableReference<AbstractC1917c>>> supplier, String str, CacheKey cacheKey, Object obj, C1682e<InterfaceC1914a> c1682e, InterfaceC1739b interfaceC1739b) {
        C2030b.m1527b();
        m8658n(str, obj);
        this.f19472v = false;
        this.f3171B = supplier;
        m1043K(null);
        this.f3170A = cacheKey;
        this.f3173D = null;
        synchronized (this) {
            this.f3176G = null;
        }
        m1043K(null);
        m1038F(null);
        C2030b.m1527b();
    }

    /* JADX INFO: renamed from: I */
    public synchronized void m1041I(InterfaceC1742e interfaceC1742e, AbstractDraweeControllerBuilder<C1733d, ImageRequest, CloseableReference<AbstractC1917c>, ImageInfo> abstractDraweeControllerBuilder, Supplier<Boolean> supplier) {
        C1743f c1743f = this.f3174E;
        if (c1743f != null) {
            List<InterfaceC1742e> list = c1743f.f3213j;
            if (list != null) {
                list.clear();
            }
            c1743f.m1067c(false);
            c1743f.f3206c.m1068a();
        }
        if (interfaceC1742e != null) {
            if (this.f3174E == null) {
                this.f3174E = new C1743f(AwakeTimeSinceBootClock.get(), this, supplier);
            }
            C1743f c1743f2 = this.f3174E;
            Objects.requireNonNull(c1743f2);
            if (c1743f2.f3213j == null) {
                c1743f2.f3213j = new CopyOnWriteArrayList();
            }
            c1743f2.f3213j.add(interfaceC1742e);
            this.f3174E.m1067c(true);
            C1745h c1745h = this.f3174E.f3206c;
            ImageRequest imageRequest = abstractDraweeControllerBuilder.f19484h;
            ImageRequest[] imageRequestArr = abstractDraweeControllerBuilder.f19485i;
            c1745h.f3221f = imageRequest;
            c1745h.f3222g = null;
            c1745h.f3223h = imageRequestArr;
        }
        this.f3178I = abstractDraweeControllerBuilder.f19484h;
        this.f3179J = abstractDraweeControllerBuilder.f19485i;
        this.f3180K = null;
    }

    /* JADX INFO: renamed from: J */
    public final Drawable m1042J(C1682e<InterfaceC1914a> c1682e, AbstractC1917c abstractC1917c) {
        Drawable drawableMo1036b;
        if (c1682e == null) {
            return null;
        }
        for (InterfaceC1914a interfaceC1914a : c1682e) {
            if (interfaceC1914a.mo1035a(abstractC1917c) && (drawableMo1036b = interfaceC1914a.mo1036b(abstractC1917c)) != null) {
                return drawableMo1036b;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: K */
    public final void m1043K(AbstractC1917c abstractC1917c) {
        String str;
        C1782p c1782pM556p0;
        if (this.f3172C) {
            if (this.f19462l == null) {
                C1757a c1757a = new C1757a();
                C1758a c1758a = new C1758a(c1757a);
                this.f3177H = new C1737b();
                m8656f(c1758a);
                this.f19462l = c1757a;
                InterfaceC1798a interfaceC1798a = this.f19461k;
                if (interfaceC1798a != null) {
                    interfaceC1798a.mo1131a(c1757a);
                }
            }
            if (this.f3176G == null) {
                m1038F(this.f3177H);
            }
            Drawable drawable = this.f19462l;
            if (drawable instanceof C1757a) {
                C1757a c1757a2 = (C1757a) drawable;
                String str2 = this.f19463m;
                if (str2 == null) {
                    str2 = "none";
                }
                c1757a2.f3303j = str2;
                c1757a2.invalidateSelf();
                InterfaceC1798a interfaceC1798a2 = this.f19461k;
                ScalingUtils$ScaleType scalingUtils$ScaleType = null;
                if (interfaceC1798a2 != null && (c1782pM556p0 = C1460d.m556p0(interfaceC1798a2.mo8670e())) != null) {
                    scalingUtils$ScaleType = c1782pM556p0.f3435n;
                }
                c1757a2.f3307n = scalingUtils$ScaleType;
                int i = this.f3177H.f3198a;
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
                int i2 = C1736a.f3197a.get(i, -1);
                c1757a2.f3301C = str;
                c1757a2.f3302D = i2;
                c1757a2.invalidateSelf();
                if (abstractC1917c == null) {
                    c1757a2.m1089c();
                    return;
                }
                int width = abstractC1917c.getWidth();
                int height = abstractC1917c.getHeight();
                c1757a2.f3304k = width;
                c1757a2.f3305l = height;
                c1757a2.invalidateSelf();
                c1757a2.f3306m = abstractC1917c.mo1330c();
            }
        }
    }

    /* JADX INFO: renamed from: L */
    public synchronized void m1044L(InterfaceC1928e interfaceC1928e) {
        Set<InterfaceC1928e> set = this.f3175F;
        if (set == null) {
            return;
        }
        set.remove(interfaceC1928e);
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController, com.facebook.drawee.interfaces.DraweeController
    /* JADX INFO: renamed from: e */
    public void mo1045e(DraweeHierarchy draweeHierarchy) {
        super.mo1045e(draweeHierarchy);
        m1043K(null);
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* JADX INFO: renamed from: g */
    public Drawable mo1046g(CloseableReference<AbstractC1917c> closeableReference) {
        CloseableReference<AbstractC1917c> closeableReference2 = closeableReference;
        try {
            C2030b.m1527b();
            C1460d.m419B(CloseableReference.m8640y(closeableReference2));
            AbstractC1917c abstractC1917cM8642u = closeableReference2.m8642u();
            m1043K(abstractC1917cM8642u);
            Drawable drawableM1042J = m1042J(this.f3173D, abstractC1917cM8642u);
            if (drawableM1042J == null && (drawableM1042J = m1042J(this.f3182y, abstractC1917cM8642u)) == null && (drawableM1042J = this.f3181x.mo1036b(abstractC1917cM8642u)) == null) {
                throw new UnsupportedOperationException("Unrecognized image class: " + abstractC1917cM8642u);
            }
            C2030b.m1527b();
            return drawableM1042J;
        } catch (Throwable th) {
            C2030b.m1527b();
            throw th;
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* JADX INFO: renamed from: h */
    public CloseableReference<AbstractC1917c> mo1047h() {
        CacheKey cacheKey;
        C2030b.m1527b();
        try {
            InterfaceC1876w<CacheKey, AbstractC1917c> interfaceC1876w = this.f3183z;
            if (interfaceC1876w != null && (cacheKey = this.f3170A) != null) {
                CloseableReference<AbstractC1917c> closeableReference = interfaceC1876w.get(cacheKey);
                if (closeableReference == null || ((C1922h) closeableReference.m8642u().mo1334b()).f3911d) {
                    return closeableReference;
                }
                closeableReference.close();
            }
            return null;
        } finally {
            C2030b.m1527b();
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* JADX INFO: renamed from: j */
    public DataSource<CloseableReference<AbstractC1917c>> mo1048j() {
        C2030b.m1527b();
        if (C1691a.m980h(2)) {
            System.identityHashCode(this);
        }
        DataSource<CloseableReference<AbstractC1917c>> dataSource = this.f3171B.get();
        C2030b.m1527b();
        return dataSource;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* JADX INFO: renamed from: k */
    public int mo1049k(CloseableReference<AbstractC1917c> closeableReference) {
        CloseableReference<AbstractC1917c> closeableReference2 = closeableReference;
        if (closeableReference2 == null || !closeableReference2.m8643x()) {
            return 0;
        }
        return System.identityHashCode(closeableReference2.f19443o.m8646c());
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* JADX INFO: renamed from: l */
    public ImageInfo mo1050l(CloseableReference<AbstractC1917c> closeableReference) {
        CloseableReference<AbstractC1917c> closeableReference2 = closeableReference;
        C1460d.m419B(CloseableReference.m8640y(closeableReference2));
        return closeableReference2.m8642u();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0021, code lost:
    
        if (r0 != null) goto L6;
     */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* JADX INFO: renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Uri mo1051m() {
        Uri uri;
        ImageRequest imageRequest = this.f3178I;
        ImageRequest imageRequest2 = this.f3180K;
        ImageRequest[] imageRequestArr = this.f3179J;
        if (imageRequest == null || (uri = imageRequest.f19585c) == null) {
            if (imageRequestArr != null && imageRequestArr.length > 0 && imageRequestArr[0] != null) {
                ImageRequest imageRequest3 = imageRequestArr[0];
                uri = imageRequest3 != null ? imageRequest3.f19585c : null;
            }
            if (imageRequest2 != null) {
                return imageRequest2.f19585c;
            }
            return null;
        }
        return uri;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* JADX INFO: renamed from: t */
    public Map mo1052t(ImageInfo imageInfo) {
        ImageInfo imageInfo2 = imageInfo;
        if (imageInfo2 == null) {
            return null;
        }
        return imageInfo2.mo1333a();
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public String toString() {
        C1686i c1686iM526h2 = C1460d.m526h2(this);
        c1686iM526h2.m971c("super", super.toString());
        c1686iM526h2.m971c("dataSourceSupplier", this.f3171B);
        return c1686iM526h2.toString();
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* JADX INFO: renamed from: v */
    public void mo1053v(String str, CloseableReference<AbstractC1917c> closeableReference) {
        synchronized (this) {
            InterfaceC1739b interfaceC1739b = this.f3176G;
            if (interfaceC1739b != null) {
                interfaceC1739b.mo1061a(str, 6, true, "PipelineDraweeController");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* JADX INFO: renamed from: x */
    public void mo1054x(Drawable drawable) {
        if (drawable instanceof InterfaceC1729a) {
            ((InterfaceC1729a) drawable).mo1034a();
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* JADX INFO: renamed from: z */
    public void mo1055z(CloseableReference<AbstractC1917c> closeableReference) {
        CloseableReference<AbstractC1917c> closeableReference2 = closeableReference;
        Class<CloseableReference> cls = CloseableReference.f19438j;
        if (closeableReference2 != null) {
            closeableReference2.close();
        }
    }
}
