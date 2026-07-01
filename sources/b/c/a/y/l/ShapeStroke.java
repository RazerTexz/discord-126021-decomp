package b.c.a.y.l;

import androidx.annotation.Nullable;
import b.c.a.LottieDrawable;
import b.c.a.w.b.Content2;
import b.c.a.w.b.StrokeContent;
import b.c.a.y.k.AnimatableColorValue;
import b.c.a.y.k.AnimatableFloatValue;
import b.c.a.y.k.AnimatableIntegerValue;
import b.c.a.y.m.BaseLayer2;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.y.l.o, reason: use source file name */
/* JADX INFO: compiled from: ShapeStroke.java */
/* JADX INFO: loaded from: classes.dex */
public class ShapeStroke implements ContentModel2 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final AnimatableFloatValue f428b;
    public final List<AnimatableFloatValue> c;
    public final AnimatableColorValue d;
    public final AnimatableIntegerValue e;
    public final AnimatableFloatValue f;
    public final int g;
    public final int h;
    public final float i;
    public final boolean j;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;Lb/c/a/y/k/b;Ljava/util/List<Lb/c/a/y/k/b;>;Lb/c/a/y/k/a;Lb/c/a/y/k/d;Lb/c/a/y/k/b;Ljava/lang/Object;Ljava/lang/Object;FZ)V */
    public ShapeStroke(String str, @Nullable AnimatableFloatValue animatableFloatValue, List list, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue2, int i, int i2, float f, boolean z2) {
        this.a = str;
        this.f428b = animatableFloatValue;
        this.c = list;
        this.d = animatableColorValue;
        this.e = animatableIntegerValue;
        this.f = animatableFloatValue2;
        this.g = i;
        this.h = i2;
        this.i = f;
        this.j = z2;
    }

    @Override // b.c.a.y.l.ContentModel2
    public Content2 a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new StrokeContent(lottieDrawable, baseLayer2, this);
    }
}
