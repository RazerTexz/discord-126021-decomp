package b.c.a.y.l;

import androidx.annotation.Nullable;
import b.c.a.LottieDrawable;
import b.c.a.w.b.Content2;
import b.c.a.w.b.RepeaterContent;
import b.c.a.y.k.AnimatableFloatValue;
import b.c.a.y.k.AnimatableTransform;
import b.c.a.y.m.BaseLayer2;

/* JADX INFO: renamed from: b.c.a.y.l.j, reason: use source file name */
/* JADX INFO: compiled from: Repeater.java */
/* JADX INFO: loaded from: classes.dex */
public class Repeater implements ContentModel2 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnimatableFloatValue f423b;
    public final AnimatableFloatValue c;
    public final AnimatableTransform d;
    public final boolean e;

    public Repeater(String str, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableTransform animatableTransform, boolean z2) {
        this.a = str;
        this.f423b = animatableFloatValue;
        this.c = animatableFloatValue2;
        this.d = animatableTransform;
        this.e = z2;
    }

    @Override // b.c.a.y.l.ContentModel2
    @Nullable
    public Content2 a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new RepeaterContent(lottieDrawable, baseLayer2, this);
    }
}
