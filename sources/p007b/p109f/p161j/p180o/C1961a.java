package p007b.p109f.p161j.p180o;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.nativecode.NativeRoundingFilter;
import p007b.p109f.p111b.p112a.C1656f;
import p007b.p109f.p161j.p182q.AbstractC2025a;

/* JADX INFO: renamed from: b.f.j.o.a */
/* JADX INFO: compiled from: RoundAsCirclePostprocessor.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1961a extends AbstractC2025a {
    private static final boolean ENABLE_ANTI_ALIASING = true;
    private CacheKey mCacheKey;
    private final boolean mEnableAntiAliasing;

    public C1961a() {
        this(true);
    }

    @Override // p007b.p109f.p161j.p182q.AbstractC2025a, p007b.p109f.p161j.p182q.InterfaceC2026b
    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            if (this.mEnableAntiAliasing) {
                this.mCacheKey = new C1656f("RoundAsCirclePostprocessor#AntiAliased");
            } else {
                this.mCacheKey = new C1656f("RoundAsCirclePostprocessor");
            }
        }
        return this.mCacheKey;
    }

    @Override // p007b.p109f.p161j.p182q.AbstractC2025a
    public void process(Bitmap bitmap) {
        NativeRoundingFilter.toCircleFast(bitmap, this.mEnableAntiAliasing);
    }

    public C1961a(boolean z2) {
        this.mEnableAntiAliasing = z2;
    }
}
