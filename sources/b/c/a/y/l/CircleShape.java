package b.c.a.y.l;

import android.graphics.PointF;
import b.c.a.LottieDrawable;
import b.c.a.w.b.Content2;
import b.c.a.w.b.EllipseContent;
import b.c.a.y.k.AnimatablePointValue;
import b.c.a.y.k.AnimatableValue;
import b.c.a.y.m.BaseLayer2;

/* JADX INFO: renamed from: b.c.a.y.l.a, reason: use source file name */
/* JADX INFO: compiled from: CircleShape.java */
/* JADX INFO: loaded from: classes.dex */
public class CircleShape implements ContentModel2 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnimatableValue<PointF, PointF> f415b;
    public final AnimatablePointValue c;
    public final boolean d;
    public final boolean e;

    public CircleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, boolean z2, boolean z3) {
        this.a = str;
        this.f415b = animatableValue;
        this.c = animatablePointValue;
        this.d = z2;
        this.e = z3;
    }

    @Override // b.c.a.y.l.ContentModel2
    public Content2 a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new EllipseContent(lottieDrawable, baseLayer2, this);
    }
}
