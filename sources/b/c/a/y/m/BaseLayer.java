package b.c.a.y.m;

import b.c.a.w.c.BaseKeyframeAnimation;

/* JADX INFO: renamed from: b.c.a.y.m.a, reason: use source file name */
/* JADX INFO: compiled from: BaseLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class BaseLayer implements BaseKeyframeAnimation.b {
    public final /* synthetic */ BaseLayer2 a;

    public BaseLayer(BaseLayer2 baseLayer2) {
        this.a = baseLayer2;
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation.b
    public void a() {
        BaseLayer2 baseLayer2 = this.a;
        boolean z2 = baseLayer2.q.j() == 1.0f;
        if (z2 != baseLayer2.w) {
            baseLayer2.w = z2;
            baseLayer2.n.invalidateSelf();
        }
    }
}
