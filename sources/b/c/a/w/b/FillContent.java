package b.c.a.w.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import b.c.a.L;
import b.c.a.LottieDrawable;
import b.c.a.LottieProperty;
import b.c.a.b0.MiscUtils;
import b.c.a.c0.LottieValueCallback;
import b.c.a.w.LPaint;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.ColorKeyframeAnimation;
import b.c.a.w.c.ValueCallbackKeyframeAnimation;
import b.c.a.y.KeyPath;
import b.c.a.y.l.ShapeFill;
import b.c.a.y.m.BaseLayer2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.w.b.g, reason: use source file name */
/* JADX INFO: compiled from: FillContent.java */
/* JADX INFO: loaded from: classes.dex */
public class FillContent implements DrawingContent, BaseKeyframeAnimation.b, KeyPathElementContent {
    public final Path a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f380b;
    public final BaseLayer2 c;
    public final String d;
    public final boolean e;
    public final List<PathContent> f;
    public final BaseKeyframeAnimation<Integer, Integer> g;
    public final BaseKeyframeAnimation<Integer, Integer> h;

    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> i;
    public final LottieDrawable j;

    public FillContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, ShapeFill shapeFill) {
        Path path = new Path();
        this.a = path;
        this.f380b = new LPaint(1);
        this.f = new ArrayList();
        this.c = baseLayer2;
        this.d = shapeFill.c;
        this.e = shapeFill.f;
        this.j = lottieDrawable;
        if (shapeFill.d == null || shapeFill.e == null) {
            this.g = null;
            this.h = null;
            return;
        }
        path.setFillType(shapeFill.f425b);
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationA = shapeFill.d.a();
        this.g = baseKeyframeAnimationA;
        baseKeyframeAnimationA.a.add(this);
        baseLayer2.e(baseKeyframeAnimationA);
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationA2 = shapeFill.e.a();
        this.h = baseKeyframeAnimationA2;
        baseKeyframeAnimationA2.a.add(this);
        baseLayer2.e(baseKeyframeAnimationA2);
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation.b
    public void a() {
        this.j.invalidateSelf();
    }

    @Override // b.c.a.w.b.Content2
    public void b(List<Content2> list, List<Content2> list2) {
        for (int i = 0; i < list2.size(); i++) {
            Content2 content2 = list2.get(i);
            if (content2 instanceof PathContent) {
                this.f.add((PathContent) content2);
            }
        }
    }

    @Override // b.c.a.y.KeyPathElement
    public void c(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.f(keyPath, i, list, keyPath2, this);
    }

    @Override // b.c.a.w.b.DrawingContent
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        this.a.reset();
        for (int i = 0; i < this.f.size(); i++) {
            this.a.addPath(this.f.get(i).getPath(), matrix);
        }
        this.a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // b.c.a.w.b.DrawingContent
    public void f(Canvas canvas, Matrix matrix, int i) {
        if (this.e) {
            return;
        }
        Paint paint = this.f380b;
        ColorKeyframeAnimation colorKeyframeAnimation = (ColorKeyframeAnimation) this.g;
        paint.setColor(colorKeyframeAnimation.j(colorKeyframeAnimation.a(), colorKeyframeAnimation.c()));
        this.f380b.setAlpha(MiscUtils.c((int) ((((i / 255.0f) * this.h.e().intValue()) / 100.0f) * 255.0f), 0, 255));
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.i;
        if (baseKeyframeAnimation != null) {
            this.f380b.setColorFilter(baseKeyframeAnimation.e());
        }
        this.a.reset();
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            this.a.addPath(this.f.get(i2).getPath(), matrix);
        }
        canvas.drawPath(this.a, this.f380b);
        L.a("FillContent#draw");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.y.KeyPathElement
    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.a) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.g;
            LottieValueCallback<Integer> lottieValueCallback2 = baseKeyframeAnimation.e;
            baseKeyframeAnimation.e = lottieValueCallback;
            return;
        }
        if (t == LottieProperty.d) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.h;
            LottieValueCallback<Integer> lottieValueCallback3 = baseKeyframeAnimation2.e;
            baseKeyframeAnimation2.e = lottieValueCallback;
        } else if (t == LottieProperty.C) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation3 = this.i;
            if (baseKeyframeAnimation3 != null) {
                this.c.u.remove(baseKeyframeAnimation3);
            }
            if (lottieValueCallback == 0) {
                this.i = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.i = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a.add(this);
            this.c.e(this.i);
        }
    }

    @Override // b.c.a.w.b.Content2
    public String getName() {
        return this.d;
    }
}
