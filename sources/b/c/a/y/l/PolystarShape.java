package b.c.a.y.l;

import android.graphics.PointF;
import b.c.a.LottieDrawable;
import b.c.a.w.b.Content2;
import b.c.a.w.b.PolystarContent;
import b.c.a.y.k.AnimatableFloatValue;
import b.c.a.y.k.AnimatableValue;
import b.c.a.y.m.BaseLayer2;

/* JADX INFO: renamed from: b.c.a.y.l.h, reason: use source file name */
/* JADX INFO: compiled from: PolystarShape.java */
/* JADX INFO: loaded from: classes.dex */
public class PolystarShape implements ContentModel2 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f421b;
    public final AnimatableFloatValue c;
    public final AnimatableValue<PointF, PointF> d;
    public final AnimatableFloatValue e;
    public final AnimatableFloatValue f;
    public final AnimatableFloatValue g;
    public final AnimatableFloatValue h;
    public final AnimatableFloatValue i;
    public final boolean j;

    /* JADX INFO: renamed from: b.c.a.y.l.h$a */
    /* JADX INFO: compiled from: PolystarShape.java */
    public enum a {
        STAR(1),
        POLYGON(2);

        private final int value;

        a(int i) {
            this.value = i;
        }

        public static a f(int i) {
            a[] aVarArrValues = values();
            for (int i2 = 0; i2 < 2; i2++) {
                a aVar = aVarArrValues[i2];
                if (aVar.value == i) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, a aVar, AnimatableFloatValue animatableFloatValue, AnimatableValue<PointF, PointF> animatableValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, AnimatableFloatValue animatableFloatValue4, AnimatableFloatValue animatableFloatValue5, AnimatableFloatValue animatableFloatValue6, boolean z2) {
        this.a = str;
        this.f421b = aVar;
        this.c = animatableFloatValue;
        this.d = animatableValue;
        this.e = animatableFloatValue2;
        this.f = animatableFloatValue3;
        this.g = animatableFloatValue4;
        this.h = animatableFloatValue5;
        this.i = animatableFloatValue6;
        this.j = z2;
    }

    @Override // b.c.a.y.l.ContentModel2
    public Content2 a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new PolystarContent(lottieDrawable, baseLayer2, this);
    }
}
