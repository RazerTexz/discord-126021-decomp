package b.f.j.o;

import android.graphics.Bitmap;
import b.f.b.a.SimpleCacheKey;
import b.f.j.q.BasePostprocessor;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.nativecode.NativeRoundingFilter;

/* JADX INFO: renamed from: b.f.j.o.a, reason: use source file name */
/* JADX INFO: compiled from: RoundAsCirclePostprocessor.java */
/* JADX INFO: loaded from: classes3.dex */
public class RoundAsCirclePostprocessor2 extends BasePostprocessor {
    private static final boolean ENABLE_ANTI_ALIASING = true;
    private CacheKey mCacheKey;
    private final boolean mEnableAntiAliasing;

    public RoundAsCirclePostprocessor2() {
        this(true);
    }

    @Override // b.f.j.q.BasePostprocessor, b.f.j.q.Postprocessor
    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            if (this.mEnableAntiAliasing) {
                this.mCacheKey = new SimpleCacheKey("RoundAsCirclePostprocessor#AntiAliased");
            } else {
                this.mCacheKey = new SimpleCacheKey("RoundAsCirclePostprocessor");
            }
        }
        return this.mCacheKey;
    }

    @Override // b.f.j.q.BasePostprocessor
    public void process(Bitmap bitmap) {
        NativeRoundingFilter.toCircleFast(bitmap, this.mEnableAntiAliasing);
    }

    public RoundAsCirclePostprocessor2(boolean z2) {
        this.mEnableAntiAliasing = z2;
    }
}
