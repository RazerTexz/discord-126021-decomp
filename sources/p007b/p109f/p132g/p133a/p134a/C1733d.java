package p007b.p109f.p132g.p133a.p134a;

import android.content.Context;
import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Set;
import p007b.p109f.p115d.p119d.C1689l;
import p007b.p109f.p132g.p133a.p134a.p136h.C1740c;
import p007b.p109f.p132g.p133a.p134a.p136h.InterfaceC1739b;
import p007b.p109f.p132g.p133a.p134a.p136h.InterfaceC1742e;
import p007b.p109f.p148h.p158b.p159a.InterfaceC1827b;
import p007b.p109f.p161j.p168c.C1867n;
import p007b.p109f.p161j.p168c.InterfaceC1862i;
import p007b.p109f.p161j.p169d.C1885f;
import p007b.p109f.p161j.p170e.C1893h;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p176k.C1926c;
import p007b.p109f.p161j.p176k.InterfaceC1928e;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: renamed from: b.f.g.a.a.d */
/* JADX INFO: compiled from: PipelineDraweeControllerBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class C1733d extends AbstractDraweeControllerBuilder<C1733d, ImageRequest, CloseableReference<AbstractC1917c>, ImageInfo> {

    /* JADX INFO: renamed from: o */
    public final C1893h f3184o;

    /* JADX INFO: renamed from: p */
    public final C1735f f3185p;

    /* JADX INFO: renamed from: q */
    public InterfaceC1742e f3186q;

    public C1733d(Context context, C1735f c1735f, C1893h c1893h, Set<ControllerListener> set, Set<InterfaceC1827b> set2) {
        super(context, set, set2);
        this.f3184o = c1893h;
        this.f3185p = c1735f;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* JADX INFO: renamed from: b */
    public DataSource<CloseableReference<AbstractC1917c>> mo1056b(DraweeController draweeController, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.EnumC10643b enumC10643b) {
        ImageRequest.EnumC10667c enumC10667c;
        InterfaceC1928e interfaceC1928e;
        ImageRequest imageRequest2 = imageRequest;
        C1893h c1893h = this.f3184o;
        int iOrdinal = enumC10643b.ordinal();
        if (iOrdinal == 0) {
            enumC10667c = ImageRequest.EnumC10667c.FULL_FETCH;
        } else if (iOrdinal == 1) {
            enumC10667c = ImageRequest.EnumC10667c.DISK_CACHE;
        } else {
            if (iOrdinal != 2) {
                throw new RuntimeException("Cache level" + enumC10643b + "is not supported. ");
            }
            enumC10667c = ImageRequest.EnumC10667c.BITMAP_MEMORY_CACHE;
        }
        ImageRequest.EnumC10667c enumC10667c2 = enumC10667c;
        C1740c c1740c = null;
        if (draweeController instanceof C1732c) {
            C1732c c1732c = (C1732c) draweeController;
            synchronized (c1732c) {
                InterfaceC1739b interfaceC1739b = c1732c.f3176G;
                c1740c = interfaceC1739b != null ? new C1740c(c1732c.f19463m, interfaceC1739b) : null;
                Set<InterfaceC1928e> set = c1732c.f3175F;
                if (set != null) {
                    C1926c c1926c = new C1926c(set);
                    if (c1740c != null) {
                        c1926c.f3913a.add(c1740c);
                    }
                    interfaceC1928e = c1926c;
                } else {
                    interfaceC1928e = c1740c;
                }
            }
        } else {
            interfaceC1928e = c1740c;
        }
        return c1893h.m1262a(imageRequest2, obj, enumC10667c2, interfaceC1928e, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* JADX INFO: renamed from: d */
    public AbstractDraweeController mo1057d() {
        C1732c c1732c;
        CacheKey cacheKey;
        CacheKey cacheKeyM1229a;
        C2030b.m1527b();
        try {
            DraweeController draweeController = this.f19490n;
            String strValueOf = String.valueOf(AbstractDraweeControllerBuilder.f19479c.getAndIncrement());
            if (draweeController instanceof C1732c) {
                c1732c = (C1732c) draweeController;
            } else {
                C1735f c1735f = this.f3185p;
                C1732c c1732c2 = new C1732c(c1735f.f3190a, c1735f.f3191b, c1735f.f3192c, c1735f.f3193d, c1735f.f3194e, c1735f.f3195f);
                Supplier<Boolean> supplier = c1735f.f3196g;
                if (supplier != null) {
                    c1732c2.f3172C = supplier.get().booleanValue();
                }
                c1732c = c1732c2;
            }
            Supplier<DataSource<CloseableReference<AbstractC1917c>>> supplierM8669e = m8669e(c1732c, strValueOf);
            ImageRequest imageRequest = (ImageRequest) this.f19484h;
            InterfaceC1862i interfaceC1862i = this.f3184o.f3739g;
            if (interfaceC1862i == null || imageRequest == null) {
                cacheKey = null;
            } else {
                if (imageRequest.f19601s != null) {
                    cacheKeyM1229a = ((C1867n) interfaceC1862i).m1231c(imageRequest, this.f19483g);
                } else {
                    cacheKeyM1229a = ((C1867n) interfaceC1862i).m1229a(imageRequest, this.f19483g);
                }
                cacheKey = cacheKeyM1229a;
            }
            c1732c.m1040H(supplierM8669e, strValueOf, cacheKey, this.f19483g, null, null);
            c1732c.m1041I(this.f3186q, this, C1689l.f3101a);
            return c1732c;
        } finally {
            C2030b.m1527b();
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    /* JADX INFO: renamed from: f */
    public C1733d m1058f(Uri uri) {
        if (uri == null) {
            this.f19484h = null;
            return this;
        }
        ImageRequestBuilder imageRequestBuilderM8723b = ImageRequestBuilder.m8723b(uri);
        imageRequestBuilderM8723b.f19616e = C1885f.f3722b;
        this.f19484h = imageRequestBuilderM8723b.m8724a();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: g */
    public C1733d m1059g(String str) {
        Uri uri;
        if (str != null && !str.isEmpty()) {
            return m1058f(Uri.parse(str));
        }
        REQUEST requestM8724a = 0;
        requestM8724a = 0;
        requestM8724a = 0;
        if (str != null && str.length() != 0 && (uri = Uri.parse(str)) != null) {
            requestM8724a = ImageRequestBuilder.m8723b(uri).m8724a();
        }
        this.f19484h = requestM8724a;
        return this;
    }
}
