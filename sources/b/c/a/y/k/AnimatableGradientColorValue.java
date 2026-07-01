package b.c.a.y.k;

import b.c.a.c0.Keyframe;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.GradientColorKeyframeAnimation;
import b.c.a.y.l.GradientColor;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.y.k.c, reason: use source file name */
/* JADX INFO: compiled from: AnimatableGradientColorValue.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatableGradientColorValue extends BaseAnimatableValue<GradientColor, GradientColor> {
    public AnimatableGradientColorValue(List<Keyframe<GradientColor>> list) {
        super((List) list);
    }

    @Override // b.c.a.y.k.AnimatableValue
    public BaseKeyframeAnimation<GradientColor, GradientColor> a() {
        return new GradientColorKeyframeAnimation(this.a);
    }
}
