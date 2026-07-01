package b.c.a.y.l;

import android.graphics.Path;
import androidx.annotation.Nullable;
import b.c.a.LottieDrawable;
import b.c.a.w.b.Content2;
import b.c.a.w.b.FillContent;
import b.c.a.y.k.AnimatableColorValue;
import b.c.a.y.k.AnimatableIntegerValue;
import b.c.a.y.m.BaseLayer2;
import b.d.b.a.outline;

/* JADX INFO: renamed from: b.c.a.y.l.l, reason: use source file name */
/* JADX INFO: compiled from: ShapeFill.java */
/* JADX INFO: loaded from: classes.dex */
public class ShapeFill implements ContentModel2 {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path.FillType f425b;
    public final String c;

    @Nullable
    public final AnimatableColorValue d;

    @Nullable
    public final AnimatableIntegerValue e;
    public final boolean f;

    public ShapeFill(String str, boolean z2, Path.FillType fillType, @Nullable AnimatableColorValue animatableColorValue, @Nullable AnimatableIntegerValue animatableIntegerValue, boolean z3) {
        this.c = str;
        this.a = z2;
        this.f425b = fillType;
        this.d = animatableColorValue;
        this.e = animatableIntegerValue;
        this.f = z3;
    }

    @Override // b.c.a.y.l.ContentModel2
    public Content2 a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new FillContent(lottieDrawable, baseLayer2, this);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ShapeFill{color=, fillEnabled=");
        sbU.append(this.a);
        sbU.append('}');
        return sbU.toString();
    }
}
