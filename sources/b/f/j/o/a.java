package b.f.j.o;

import android.graphics.Bitmap;
import b.f.b.a.f;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.nativecode.NativeRoundingFilter;

/* JADX INFO: compiled from: RoundAsCirclePostprocessor.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends b.f.j.q.a {
    private static final boolean ENABLE_ANTI_ALIASING = true;
    private CacheKey mCacheKey;
    private final boolean mEnableAntiAliasing;

    public a() {
        this(true);
    }

    @Override // b.f.j.q.a, b.f.j.q.b
    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            if (this.mEnableAntiAliasing) {
                this.mCacheKey = new f("RoundAsCirclePostprocessor#AntiAliased");
            } else {
                this.mCacheKey = new f("RoundAsCirclePostprocessor");
            }
        }
        return this.mCacheKey;
    }

    @Override // b.f.j.q.a
    public void process(Bitmap bitmap) {
        NativeRoundingFilter.toCircleFast(bitmap, this.mEnableAntiAliasing);
    }

    public a(boolean z2) {
        this.mEnableAntiAliasing = z2;
    }
}
