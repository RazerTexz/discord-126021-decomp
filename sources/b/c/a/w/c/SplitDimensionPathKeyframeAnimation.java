package b.c.a.w.c;

import android.graphics.PointF;
import b.c.a.c0.Keyframe;
import java.util.Collections;

/* JADX INFO: renamed from: b.c.a.w.c.m, reason: use source file name */
/* JADX INFO: compiled from: SplitDimensionPathKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {
    public final PointF i;
    public final BaseKeyframeAnimation<Float, Float> j;
    public final BaseKeyframeAnimation<Float, Float> k;

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation, BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2) {
        super(Collections.emptyList());
        this.i = new PointF();
        this.j = baseKeyframeAnimation;
        this.k = baseKeyframeAnimation2;
        h(this.d);
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation
    public PointF e() {
        return this.i;
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation
    public PointF f(Keyframe<PointF> keyframe, float f) {
        return this.i;
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation
    public void h(float f) {
        this.j.h(f);
        this.k.h(f);
        this.i.set(this.j.e().floatValue(), this.k.e().floatValue());
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).a();
        }
    }
}
