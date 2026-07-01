package b.c.a.y.k;

import android.graphics.PointF;
import b.c.a.c0.Keyframe;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.SplitDimensionPathKeyframeAnimation;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.y.k.i, reason: use source file name */
/* JADX INFO: compiled from: AnimatableSplitDimensionPathValue.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatableSplitDimensionPathValue implements AnimatableValue<PointF, PointF> {
    public final AnimatableFloatValue a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnimatableFloatValue f412b;

    public AnimatableSplitDimensionPathValue(AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2) {
        this.a = animatableFloatValue;
        this.f412b = animatableFloatValue2;
    }

    @Override // b.c.a.y.k.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> a() {
        return new SplitDimensionPathKeyframeAnimation(this.a.a(), this.f412b.a());
    }

    @Override // b.c.a.y.k.AnimatableValue
    public List<Keyframe<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // b.c.a.y.k.AnimatableValue
    public boolean isStatic() {
        return this.a.isStatic() && this.f412b.isStatic();
    }
}
