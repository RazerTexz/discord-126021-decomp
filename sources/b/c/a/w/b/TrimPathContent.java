package b.c.a.w.b;

import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.y.l.ShapeTrimPath;
import b.c.a.y.m.BaseLayer2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.w.b.s, reason: use source file name */
/* JADX INFO: compiled from: TrimPathContent.java */
/* JADX INFO: loaded from: classes.dex */
public class TrimPathContent implements Content2, BaseKeyframeAnimation.b {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<BaseKeyframeAnimation.b> f391b = new ArrayList();
    public final int c;
    public final BaseKeyframeAnimation<?, Float> d;
    public final BaseKeyframeAnimation<?, Float> e;
    public final BaseKeyframeAnimation<?, Float> f;

    public TrimPathContent(BaseLayer2 baseLayer2, ShapeTrimPath shapeTrimPath) {
        this.a = shapeTrimPath.f;
        this.c = shapeTrimPath.f429b;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA = shapeTrimPath.c.a();
        this.d = baseKeyframeAnimationA;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA2 = shapeTrimPath.d.a();
        this.e = baseKeyframeAnimationA2;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA3 = shapeTrimPath.e.a();
        this.f = baseKeyframeAnimationA3;
        baseLayer2.e(baseKeyframeAnimationA);
        baseLayer2.e(baseKeyframeAnimationA2);
        baseLayer2.e(baseKeyframeAnimationA3);
        baseKeyframeAnimationA.a.add(this);
        baseKeyframeAnimationA2.a.add(this);
        baseKeyframeAnimationA3.a.add(this);
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation.b
    public void a() {
        for (int i = 0; i < this.f391b.size(); i++) {
            this.f391b.get(i).a();
        }
    }

    @Override // b.c.a.w.b.Content2
    public void b(List<Content2> list, List<Content2> list2) {
    }
}
