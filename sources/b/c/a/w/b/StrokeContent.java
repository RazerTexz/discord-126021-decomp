package b.c.a.w.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import b.c.a.LottieDrawable;
import b.c.a.LottieProperty;
import b.c.a.c0.LottieValueCallback;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.ColorKeyframeAnimation;
import b.c.a.w.c.ValueCallbackKeyframeAnimation;
import b.c.a.y.l.ShapeStroke;
import b.c.a.y.m.BaseLayer2;

/* JADX INFO: renamed from: b.c.a.w.b.r, reason: use source file name */
/* JADX INFO: compiled from: StrokeContent.java */
/* JADX INFO: loaded from: classes.dex */
public class StrokeContent extends BaseStrokeContent {
    public final BaseLayer2 o;
    public final String p;
    public final boolean q;
    public final BaseKeyframeAnimation<Integer, Integer> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> f390s;

    public StrokeContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, ShapeStroke shapeStroke) {
        super(lottieDrawable, baseLayer2, b.c.a.y.b.k(shapeStroke.g), b.c.a.y.b.l(shapeStroke.h), shapeStroke.i, shapeStroke.e, shapeStroke.f, shapeStroke.c, shapeStroke.f428b);
        this.o = baseLayer2;
        this.p = shapeStroke.a;
        this.q = shapeStroke.j;
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationA = shapeStroke.d.a();
        this.r = baseKeyframeAnimationA;
        baseKeyframeAnimationA.a.add(this);
        baseLayer2.e(baseKeyframeAnimationA);
    }

    @Override // b.c.a.w.b.BaseStrokeContent, b.c.a.w.b.DrawingContent
    public void f(Canvas canvas, Matrix matrix, int i) {
        if (this.q) {
            return;
        }
        Paint paint = this.i;
        ColorKeyframeAnimation colorKeyframeAnimation = (ColorKeyframeAnimation) this.r;
        paint.setColor(colorKeyframeAnimation.j(colorKeyframeAnimation.a(), colorKeyframeAnimation.c()));
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f390s;
        if (baseKeyframeAnimation != null) {
            this.i.setColorFilter(baseKeyframeAnimation.e());
        }
        super.f(canvas, matrix, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.w.b.BaseStrokeContent, b.c.a.y.KeyPathElement
    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        super.g(t, lottieValueCallback);
        if (t == LottieProperty.f368b) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.r;
            LottieValueCallback<Integer> lottieValueCallback2 = baseKeyframeAnimation.e;
            baseKeyframeAnimation.e = lottieValueCallback;
        } else if (t == LottieProperty.C) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation2 = this.f390s;
            if (baseKeyframeAnimation2 != null) {
                this.o.u.remove(baseKeyframeAnimation2);
            }
            if (lottieValueCallback == 0) {
                this.f390s = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.f390s = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a.add(this);
            this.o.e(this.r);
        }
    }

    @Override // b.c.a.w.b.Content2
    public String getName() {
        return this.p;
    }
}
