package b.c.a.y.k;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import b.c.a.LottieDrawable;
import b.c.a.w.b.Content2;
import b.c.a.y.l.ContentModel2;
import b.c.a.y.m.BaseLayer2;

/* JADX INFO: renamed from: b.c.a.y.k.l, reason: use source file name */
/* JADX INFO: compiled from: AnimatableTransform.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatableTransform implements ContentModel2 {

    @Nullable
    public final AnimatablePathValue a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final AnimatableValue<PointF, PointF> f414b;

    @Nullable
    public final AnimatableScaleValue c;

    @Nullable
    public final AnimatableFloatValue d;

    @Nullable
    public final AnimatableIntegerValue e;

    @Nullable
    public final AnimatableFloatValue f;

    @Nullable
    public final AnimatableFloatValue g;

    @Nullable
    public final AnimatableFloatValue h;

    @Nullable
    public final AnimatableFloatValue i;

    public AnimatableTransform() {
        this(null, null, null, null, null, null, null, null, null);
    }

    @Override // b.c.a.y.l.ContentModel2
    @Nullable
    public Content2 a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return null;
    }

    public AnimatableTransform(@Nullable AnimatablePathValue animatablePathValue, @Nullable AnimatableValue<PointF, PointF> animatableValue, @Nullable AnimatableScaleValue animatableScaleValue, @Nullable AnimatableFloatValue animatableFloatValue, @Nullable AnimatableIntegerValue animatableIntegerValue, @Nullable AnimatableFloatValue animatableFloatValue2, @Nullable AnimatableFloatValue animatableFloatValue3, @Nullable AnimatableFloatValue animatableFloatValue4, @Nullable AnimatableFloatValue animatableFloatValue5) {
        this.a = animatablePathValue;
        this.f414b = animatableValue;
        this.c = animatableScaleValue;
        this.d = animatableFloatValue;
        this.e = animatableIntegerValue;
        this.h = animatableFloatValue2;
        this.i = animatableFloatValue3;
        this.f = animatableFloatValue4;
        this.g = animatableFloatValue5;
    }
}
