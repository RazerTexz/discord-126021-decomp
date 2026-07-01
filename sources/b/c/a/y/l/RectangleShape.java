package b.c.a.y.l;

import android.graphics.PointF;
import b.c.a.LottieDrawable;
import b.c.a.w.b.Content2;
import b.c.a.w.b.RectangleContent;
import b.c.a.y.k.AnimatableFloatValue;
import b.c.a.y.k.AnimatablePointValue;
import b.c.a.y.k.AnimatableValue;
import b.c.a.y.m.BaseLayer2;
import b.d.b.a.outline;

/* JADX INFO: renamed from: b.c.a.y.l.i, reason: use source file name */
/* JADX INFO: compiled from: RectangleShape.java */
/* JADX INFO: loaded from: classes.dex */
public class RectangleShape implements ContentModel2 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnimatableValue<PointF, PointF> f422b;
    public final AnimatablePointValue c;
    public final AnimatableFloatValue d;
    public final boolean e;

    public RectangleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, AnimatableFloatValue animatableFloatValue, boolean z2) {
        this.a = str;
        this.f422b = animatableValue;
        this.c = animatablePointValue;
        this.d = animatableFloatValue;
        this.e = z2;
    }

    @Override // b.c.a.y.l.ContentModel2
    public Content2 a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new RectangleContent(lottieDrawable, baseLayer2, this);
    }

    public String toString() {
        StringBuilder sbU = outline.U("RectangleShape{position=");
        sbU.append(this.f422b);
        sbU.append(", size=");
        sbU.append(this.c);
        sbU.append('}');
        return sbU.toString();
    }
}
