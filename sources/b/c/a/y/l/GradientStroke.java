package b.c.a.y.l;

import androidx.annotation.Nullable;
import b.c.a.LottieDrawable;
import b.c.a.w.b.Content2;
import b.c.a.w.b.GradientStrokeContent;
import b.c.a.y.k.AnimatableFloatValue;
import b.c.a.y.k.AnimatableGradientColorValue;
import b.c.a.y.k.AnimatableIntegerValue;
import b.c.a.y.k.AnimatablePointValue;
import b.c.a.y.m.BaseLayer2;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.y.l.e, reason: use source file name */
/* JADX INFO: compiled from: GradientStroke.java */
/* JADX INFO: loaded from: classes.dex */
public class GradientStroke implements ContentModel2 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f418b;
    public final AnimatableGradientColorValue c;
    public final AnimatableIntegerValue d;
    public final AnimatablePointValue e;
    public final AnimatablePointValue f;
    public final AnimatableFloatValue g;
    public final int h;
    public final int i;
    public final float j;
    public final List<AnimatableFloatValue> k;

    @Nullable
    public final AnimatableFloatValue l;
    public final boolean m;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;Ljava/lang/Object;Lb/c/a/y/k/c;Lb/c/a/y/k/d;Lb/c/a/y/k/f;Lb/c/a/y/k/f;Lb/c/a/y/k/b;Ljava/lang/Object;Ljava/lang/Object;FLjava/util/List<Lb/c/a/y/k/b;>;Lb/c/a/y/k/b;Z)V */
    public GradientStroke(String str, int i, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, AnimatableFloatValue animatableFloatValue, int i2, int i3, float f, List list, @Nullable AnimatableFloatValue animatableFloatValue2, boolean z2) {
        this.a = str;
        this.f418b = i;
        this.c = animatableGradientColorValue;
        this.d = animatableIntegerValue;
        this.e = animatablePointValue;
        this.f = animatablePointValue2;
        this.g = animatableFloatValue;
        this.h = i2;
        this.i = i3;
        this.j = f;
        this.k = list;
        this.l = animatableFloatValue2;
        this.m = z2;
    }

    @Override // b.c.a.y.l.ContentModel2
    public Content2 a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new GradientStrokeContent(lottieDrawable, baseLayer2, this);
    }
}
