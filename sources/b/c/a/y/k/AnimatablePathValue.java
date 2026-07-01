package b.c.a.y.k;

import android.graphics.PointF;
import b.c.a.c0.Keyframe;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.PathKeyframeAnimation;
import b.c.a.w.c.PointKeyframeAnimation;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.y.k.e, reason: use source file name */
/* JADX INFO: compiled from: AnimatablePathValue.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatablePathValue implements AnimatableValue<PointF, PointF> {
    public final List<Keyframe<PointF>> a;

    public AnimatablePathValue(List<Keyframe<PointF>> list) {
        this.a = list;
    }

    @Override // b.c.a.y.k.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> a() {
        return this.a.get(0).d() ? new PointKeyframeAnimation(this.a) : new PathKeyframeAnimation(this.a);
    }

    @Override // b.c.a.y.k.AnimatableValue
    public List<Keyframe<PointF>> b() {
        return this.a;
    }

    @Override // b.c.a.y.k.AnimatableValue
    public boolean isStatic() {
        return this.a.size() == 1 && this.a.get(0).d();
    }
}
