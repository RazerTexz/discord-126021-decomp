package b.c.a.y.l;

import android.graphics.Path;
import b.c.a.LottieDrawable;
import b.c.a.w.b.Content2;
import b.c.a.w.b.GradientFillContent;
import b.c.a.y.k.AnimatableFloatValue;
import b.c.a.y.k.AnimatableGradientColorValue;
import b.c.a.y.k.AnimatableIntegerValue;
import b.c.a.y.k.AnimatablePointValue;
import b.c.a.y.m.BaseLayer2;

/* JADX INFO: renamed from: b.c.a.y.l.d, reason: use source file name */
/* JADX INFO: compiled from: GradientFill.java */
/* JADX INFO: loaded from: classes.dex */
public class GradientFill implements ContentModel2 {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path.FillType f417b;
    public final AnimatableGradientColorValue c;
    public final AnimatableIntegerValue d;
    public final AnimatablePointValue e;
    public final AnimatablePointValue f;
    public final String g;
    public final boolean h;

    public GradientFill(String str, int i, Path.FillType fillType, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, boolean z2) {
        this.a = i;
        this.f417b = fillType;
        this.c = animatableGradientColorValue;
        this.d = animatableIntegerValue;
        this.e = animatablePointValue;
        this.f = animatablePointValue2;
        this.g = str;
        this.h = z2;
    }

    @Override // b.c.a.y.l.ContentModel2
    public Content2 a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new GradientFillContent(lottieDrawable, baseLayer2, this);
    }
}
