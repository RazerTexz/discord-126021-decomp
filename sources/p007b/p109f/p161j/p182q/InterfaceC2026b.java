package p007b.p109f.p161j.p182q;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;

/* JADX INFO: renamed from: b.f.j.q.b */
/* JADX INFO: compiled from: Postprocessor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC2026b {
    String getName();

    CacheKey getPostprocessorCacheKey();

    CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory);
}
