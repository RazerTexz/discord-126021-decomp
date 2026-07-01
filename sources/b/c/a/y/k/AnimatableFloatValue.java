package b.c.a.y.k;

import b.c.a.c0.Keyframe;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.FloatKeyframeAnimation;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.y.k.b, reason: use source file name */
/* JADX INFO: compiled from: AnimatableFloatValue.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatableFloatValue extends BaseAnimatableValue<Float, Float> {
    public AnimatableFloatValue() {
        super(Float.valueOf(0.0f));
    }

    @Override // b.c.a.y.k.AnimatableValue
    public BaseKeyframeAnimation<Float, Float> a() {
        return new FloatKeyframeAnimation(this.a);
    }

    public AnimatableFloatValue(List<Keyframe<Float>> list) {
        super((List) list);
    }
}
