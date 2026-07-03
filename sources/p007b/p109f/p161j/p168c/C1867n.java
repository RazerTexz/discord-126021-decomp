package p007b.p109f.p161j.p168c;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import p007b.p109f.p111b.p112a.C1656f;
import p007b.p109f.p161j.p182q.InterfaceC2026b;

/* JADX INFO: renamed from: b.f.j.c.n */
/* JADX INFO: compiled from: DefaultCacheKeyFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class C1867n implements InterfaceC1862i {

    /* JADX INFO: renamed from: a */
    public static C1867n f3684a;

    /* JADX INFO: renamed from: a */
    public CacheKey m1229a(ImageRequest imageRequest, Object obj) {
        return new C1854b(imageRequest.f19585c.toString(), imageRequest.f19592j, imageRequest.f19593k, imageRequest.f19591i, null, null, obj);
    }

    /* JADX INFO: renamed from: b */
    public CacheKey m1230b(ImageRequest imageRequest, Object obj) {
        return new C1656f(imageRequest.f19585c.toString());
    }

    /* JADX INFO: renamed from: c */
    public CacheKey m1231c(ImageRequest imageRequest, Object obj) {
        CacheKey cacheKey;
        String name;
        InterfaceC2026b interfaceC2026b = imageRequest.f19601s;
        if (interfaceC2026b != null) {
            CacheKey postprocessorCacheKey = interfaceC2026b.getPostprocessorCacheKey();
            name = interfaceC2026b.getClass().getName();
            cacheKey = postprocessorCacheKey;
        } else {
            cacheKey = null;
            name = null;
        }
        return new C1854b(imageRequest.f19585c.toString(), imageRequest.f19592j, imageRequest.f19593k, imageRequest.f19591i, cacheKey, name, obj);
    }
}
