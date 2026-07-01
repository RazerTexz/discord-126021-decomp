package b.f.h.a.d;

import android.graphics.Rect;
import b.f.j.a.a.AnimatedDrawableBackend;
import b.f.j.a.a.AnimatedImageResult;
import b.f.j.a.c.AnimatedDrawableBackendImpl;
import b.f.j.a.c.AnimatedDrawableBackendProvider;
import b.f.j.a.d.AnimatedDrawableUtil;
import com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl;

/* JADX INFO: renamed from: b.f.h.a.d.c, reason: use source file name */
/* JADX INFO: compiled from: AnimatedFactoryV2Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatedFactoryV2Impl4 implements AnimatedDrawableBackendProvider {
    public final /* synthetic */ AnimatedFactoryV2Impl a;

    public AnimatedFactoryV2Impl4(AnimatedFactoryV2Impl animatedFactoryV2Impl) {
        this.a = animatedFactoryV2Impl;
    }

    @Override // b.f.j.a.c.AnimatedDrawableBackendProvider
    public AnimatedDrawableBackend a(AnimatedImageResult animatedImageResult, Rect rect) {
        AnimatedFactoryV2Impl animatedFactoryV2Impl = this.a;
        if (animatedFactoryV2Impl.g == null) {
            animatedFactoryV2Impl.g = new AnimatedDrawableUtil();
        }
        return new AnimatedDrawableBackendImpl(animatedFactoryV2Impl.g, animatedImageResult, rect, animatedFactoryV2Impl.d);
    }
}
