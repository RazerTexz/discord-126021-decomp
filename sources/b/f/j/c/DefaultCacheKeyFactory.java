package b.f.j.c;

import b.f.b.a.SimpleCacheKey;
import b.f.j.q.Postprocessor;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: renamed from: b.f.j.c.n, reason: use source file name */
/* JADX INFO: compiled from: DefaultCacheKeyFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class DefaultCacheKeyFactory implements CacheKeyFactory {
    public static DefaultCacheKeyFactory a;

    public CacheKey a(ImageRequest imageRequest, Object obj) {
        return new BitmapMemoryCacheKey(imageRequest.c.toString(), imageRequest.j, imageRequest.k, imageRequest.i, null, null, obj);
    }

    public CacheKey b(ImageRequest imageRequest, Object obj) {
        return new SimpleCacheKey(imageRequest.c.toString());
    }

    public CacheKey c(ImageRequest imageRequest, Object obj) {
        CacheKey cacheKey;
        String name;
        Postprocessor postprocessor = imageRequest.f2903s;
        if (postprocessor != null) {
            CacheKey postprocessorCacheKey = postprocessor.getPostprocessorCacheKey();
            name = postprocessor.getClass().getName();
            cacheKey = postprocessorCacheKey;
        } else {
            cacheKey = null;
            name = null;
        }
        return new BitmapMemoryCacheKey(imageRequest.c.toString(), imageRequest.j, imageRequest.k, imageRequest.i, cacheKey, name, obj);
    }
}
