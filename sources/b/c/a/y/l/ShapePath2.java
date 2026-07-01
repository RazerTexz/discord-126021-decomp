package b.c.a.y.l;

import b.c.a.LottieDrawable;
import b.c.a.w.b.Content2;
import b.c.a.w.b.ShapeContent;
import b.c.a.y.k.AnimatableShapeValue;
import b.c.a.y.m.BaseLayer2;
import b.d.b.a.outline;

/* JADX INFO: renamed from: b.c.a.y.l.n, reason: use source file name */
/* JADX INFO: compiled from: ShapePath.java */
/* JADX INFO: loaded from: classes.dex */
public class ShapePath2 implements ContentModel2 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f427b;
    public final AnimatableShapeValue c;
    public final boolean d;

    public ShapePath2(String str, int i, AnimatableShapeValue animatableShapeValue, boolean z2) {
        this.a = str;
        this.f427b = i;
        this.c = animatableShapeValue;
        this.d = z2;
    }

    @Override // b.c.a.y.l.ContentModel2
    public Content2 a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new ShapeContent(lottieDrawable, baseLayer2, this);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ShapePath{name=");
        sbU.append(this.a);
        sbU.append(", index=");
        return outline.A(sbU, this.f427b, '}');
    }
}
