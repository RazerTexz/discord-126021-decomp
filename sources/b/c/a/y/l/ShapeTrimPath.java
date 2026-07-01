package b.c.a.y.l;

import b.c.a.LottieDrawable;
import b.c.a.w.b.Content2;
import b.c.a.w.b.TrimPathContent;
import b.c.a.y.k.AnimatableFloatValue;
import b.c.a.y.m.BaseLayer2;
import b.d.b.a.outline;

/* JADX INFO: renamed from: b.c.a.y.l.p, reason: use source file name */
/* JADX INFO: compiled from: ShapeTrimPath.java */
/* JADX INFO: loaded from: classes.dex */
public class ShapeTrimPath implements ContentModel2 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f429b;
    public final AnimatableFloatValue c;
    public final AnimatableFloatValue d;
    public final AnimatableFloatValue e;
    public final boolean f;

    public ShapeTrimPath(String str, int i, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, boolean z2) {
        this.a = str;
        this.f429b = i;
        this.c = animatableFloatValue;
        this.d = animatableFloatValue2;
        this.e = animatableFloatValue3;
        this.f = z2;
    }

    @Override // b.c.a.y.l.ContentModel2
    public Content2 a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new TrimPathContent(baseLayer2, this);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Trim Path: {start: ");
        sbU.append(this.c);
        sbU.append(", end: ");
        sbU.append(this.d);
        sbU.append(", offset: ");
        sbU.append(this.e);
        sbU.append("}");
        return sbU.toString();
    }
}
