package b.c.a.y.k;

import android.graphics.PointF;
import b.c.a.c0.Keyframe;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.PointKeyframeAnimation;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.y.k.f, reason: use source file name */
/* JADX INFO: compiled from: AnimatablePointValue.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatablePointValue extends BaseAnimatableValue<PointF, PointF> {
    public AnimatablePointValue(List<Keyframe<PointF>> list) {
        super((List) list);
    }

    @Override // b.c.a.y.k.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> a() {
        return new PointKeyframeAnimation(this.a);
    }
}
