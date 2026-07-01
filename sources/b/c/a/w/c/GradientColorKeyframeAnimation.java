package b.c.a.w.c;

import b.c.a.a0.AnimatableValueParser;
import b.c.a.b0.MiscUtils;
import b.c.a.c0.Keyframe;
import b.c.a.y.l.GradientColor;
import b.d.b.a.outline;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.c.a.w.c.d, reason: use source file name */
/* JADX INFO: compiled from: GradientColorKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {
    public final GradientColor i;

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        GradientColor gradientColor = list.get(0).f347b;
        int length = gradientColor != null ? gradientColor.f416b.length : 0;
        this.i = new GradientColor(new float[length], new int[length]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.w.c.BaseKeyframeAnimation
    public Object f(Keyframe keyframe, float f) {
        GradientColor gradientColor = this.i;
        GradientColor gradientColor2 = (GradientColor) keyframe.f347b;
        GradientColor gradientColor3 = (GradientColor) keyframe.c;
        Objects.requireNonNull(gradientColor);
        if (gradientColor2.f416b.length != gradientColor3.f416b.length) {
            StringBuilder sbU = outline.U("Cannot interpolate between gradients. Lengths vary (");
            sbU.append(gradientColor2.f416b.length);
            sbU.append(" vs ");
            throw new IllegalArgumentException(outline.B(sbU, gradientColor3.f416b.length, ")"));
        }
        for (int i = 0; i < gradientColor2.f416b.length; i++) {
            gradientColor.a[i] = MiscUtils.e(gradientColor2.a[i], gradientColor3.a[i], f);
            gradientColor.f416b[i] = AnimatableValueParser.i0(f, gradientColor2.f416b[i], gradientColor3.f416b[i]);
        }
        return this.i;
    }
}
