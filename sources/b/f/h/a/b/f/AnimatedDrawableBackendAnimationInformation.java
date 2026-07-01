package b.f.h.a.b.f;

import b.f.h.a.a.AnimationInformation;
import b.f.j.a.a.AnimatedDrawableBackend;
import b.f.j.a.c.AnimatedDrawableBackendImpl;

/* JADX INFO: renamed from: b.f.h.a.b.f.a, reason: use source file name */
/* JADX INFO: compiled from: AnimatedDrawableBackendAnimationInformation.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatedDrawableBackendAnimationInformation implements AnimationInformation {
    public final AnimatedDrawableBackend a;

    public AnimatedDrawableBackendAnimationInformation(AnimatedDrawableBackend animatedDrawableBackend) {
        this.a = animatedDrawableBackend;
    }

    @Override // b.f.h.a.a.AnimationInformation
    public int a() {
        return ((AnimatedDrawableBackendImpl) this.a).b();
    }

    @Override // b.f.h.a.a.AnimationInformation
    public int b() {
        return ((AnimatedDrawableBackendImpl) this.a).c.b();
    }

    @Override // b.f.h.a.a.AnimationInformation
    public int e(int i) {
        return ((AnimatedDrawableBackendImpl) this.a).e[i];
    }
}
