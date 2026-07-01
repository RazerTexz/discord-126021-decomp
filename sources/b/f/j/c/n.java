package b.f.j.c;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: compiled from: DefaultCacheKeyFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class n implements i {
    public static n a;

    public CacheKey a(ImageRequest imageRequest, Object obj) {
        return new b(imageRequest.c.toString(), imageRequest.j, imageRequest.k, imageRequest.i, null, null, obj);
    }

    public CacheKey b(ImageRequest imageRequest, Object obj) {
        return new b.f.b.a.f(imageRequest.c.toString());
    }

    public CacheKey c(ImageRequest imageRequest, Object obj) {
        CacheKey cacheKey;
        String name;
        b.f.j.q.b bVar = imageRequest.f2903s;
        if (bVar != null) {
            CacheKey postprocessorCacheKey = bVar.getPostprocessorCacheKey();
            name = bVar.getClass().getName();
            cacheKey = postprocessorCacheKey;
        } else {
            cacheKey = null;
            name = null;
        }
        return new b(imageRequest.c.toString(), imageRequest.j, imageRequest.k, imageRequest.i, cacheKey, name, obj);
    }
}
