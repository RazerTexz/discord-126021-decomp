package b.c.a.y.m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import b.c.a.L;
import b.c.a.LottieDrawable;
import b.c.a.PerformanceTracker;
import b.c.a.b0.MeanCalculator;
import b.c.a.b0.Utils;
import b.c.a.c0.LottieValueCallback;
import b.c.a.c0.ScaleXY;
import b.c.a.w.LPaint;
import b.c.a.w.b.Content2;
import b.c.a.w.b.DrawingContent;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.FloatKeyframeAnimation;
import b.c.a.w.c.MaskKeyframeAnimation;
import b.c.a.w.c.TransformKeyframeAnimation;
import b.c.a.y.KeyPath;
import b.c.a.y.KeyPathElement;
import b.c.a.y.k.AnimatableTransform;
import b.c.a.y.l.Mask;
import b.c.a.y.l.ShapeData;
import b.d.b.a.outline;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.c.a.y.m.b, reason: use source file name */
/* JADX INFO: compiled from: BaseLayer.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseLayer2 implements DrawingContent, BaseKeyframeAnimation.b, KeyPathElement {
    public final Path a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f430b = new Matrix();
    public final Paint c = new LPaint(1);
    public final Paint d = new LPaint(1, PorterDuff.Mode.DST_IN);
    public final Paint e = new LPaint(1, PorterDuff.Mode.DST_OUT);
    public final Paint f;
    public final Paint g;
    public final RectF h;
    public final RectF i;
    public final RectF j;
    public final RectF k;
    public final String l;
    public final Matrix m;
    public final LottieDrawable n;
    public final Layer2 o;

    @Nullable
    public MaskKeyframeAnimation p;

    @Nullable
    public FloatKeyframeAnimation q;

    @Nullable
    public BaseLayer2 r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public BaseLayer2 f431s;
    public List<BaseLayer2> t;
    public final List<BaseKeyframeAnimation<?, ?>> u;
    public final TransformKeyframeAnimation v;
    public boolean w;

    public BaseLayer2(LottieDrawable lottieDrawable, Layer2 layer2) {
        LPaint lPaint = new LPaint(1);
        this.f = lPaint;
        this.g = new LPaint(PorterDuff.Mode.CLEAR);
        this.h = new RectF();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new RectF();
        this.m = new Matrix();
        this.u = new ArrayList();
        this.w = true;
        this.n = lottieDrawable;
        this.o = layer2;
        this.l = outline.J(new StringBuilder(), layer2.c, "#draw");
        if (layer2.u == 3) {
            lPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            lPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        AnimatableTransform animatableTransform = layer2.i;
        Objects.requireNonNull(animatableTransform);
        TransformKeyframeAnimation transformKeyframeAnimation = new TransformKeyframeAnimation(animatableTransform);
        this.v = transformKeyframeAnimation;
        transformKeyframeAnimation.b(this);
        List<Mask> list = layer2.h;
        if (list != null && !list.isEmpty()) {
            MaskKeyframeAnimation maskKeyframeAnimation = new MaskKeyframeAnimation(layer2.h);
            this.p = maskKeyframeAnimation;
            Iterator<BaseKeyframeAnimation<ShapeData, Path>> it = maskKeyframeAnimation.a.iterator();
            while (it.hasNext()) {
                it.next().a.add(this);
            }
            for (BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation : this.p.f395b) {
                e(baseKeyframeAnimation);
                baseKeyframeAnimation.a.add(this);
            }
        }
        if (this.o.t.isEmpty()) {
            p(true);
            return;
        }
        FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(this.o.t);
        this.q = floatKeyframeAnimation;
        floatKeyframeAnimation.f392b = true;
        floatKeyframeAnimation.a.add(new BaseLayer(this));
        p(this.q.e().floatValue() == 1.0f);
        e(this.q);
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation.b
    public void a() {
        this.n.invalidateSelf();
    }

    @Override // b.c.a.w.b.Content2
    public void b(List<Content2> list, List<Content2> list2) {
    }

    @Override // b.c.a.y.KeyPathElement
    public void c(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        if (keyPath.e(this.o.c, i)) {
            if (!"__container".equals(this.o.c)) {
                keyPath2 = keyPath2.a(this.o.c);
                if (keyPath.c(this.o.c, i)) {
                    list.add(keyPath2.g(this));
                }
            }
            if (keyPath.f(this.o.c, i)) {
                n(keyPath, keyPath.d(this.o.c, i) + i, list, keyPath2);
            }
        }
    }

    @Override // b.c.a.w.b.DrawingContent
    @CallSuper
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
        h();
        this.m.set(matrix);
        if (z2) {
            List<BaseLayer2> list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.m.preConcat(this.t.get(size).v.e());
                }
            } else {
                BaseLayer2 baseLayer2 = this.f431s;
                if (baseLayer2 != null) {
                    this.m.preConcat(baseLayer2.v.e());
                }
            }
        }
        this.m.preConcat(this.v.e());
    }

    public void e(@Nullable BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        if (baseKeyframeAnimation == null) {
            return;
        }
        this.u.add(baseKeyframeAnimation);
    }

    /* JADX WARN: Code duplicated, block: B:115:0x017c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x011e  */
    /* JADX WARN: Code duplicated, block: B:45:0x012c  */
    /* JADX WARN: Code duplicated, block: B:46:0x0134  */
    @Override // b.c.a.w.b.DrawingContent
    public void f(Canvas canvas, Matrix matrix, int i) {
        boolean z2;
        String str = this.l;
        if (!this.w || this.o.v) {
            L.a(str);
            return;
        }
        h();
        this.f430b.reset();
        this.f430b.set(matrix);
        int i2 = 1;
        for (int size = this.t.size() - 1; size >= 0; size--) {
            this.f430b.preConcat(this.t.get(size).v.e());
        }
        L.a("Layer#parentMatrix");
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.v.j;
        int iIntValue = (int) ((((i / 255.0f) * (baseKeyframeAnimation == null ? 100 : baseKeyframeAnimation.e().intValue())) / 100.0f) * 255.0f);
        float f = 0.0f;
        if (!l() && !k()) {
            this.f430b.preConcat(this.v.e());
            j(canvas, this.f430b, iIntValue);
            L.a("Layer#drawLayer");
            L.a(this.l);
            m(0.0f);
            return;
        }
        boolean z3 = false;
        d(this.h, this.f430b, false);
        RectF rectF = this.h;
        int i3 = 3;
        if (l() && this.o.u != 3) {
            this.j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.r.d(this.j, matrix, true);
            if (!rectF.intersect(this.j)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
        this.f430b.preConcat(this.v.e());
        RectF rectF2 = this.h;
        Matrix matrix2 = this.f430b;
        this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i4 = 2;
        if (k()) {
            int size2 = this.p.c.size();
            int i5 = 0;
            while (true) {
                if (i5 < size2) {
                    Mask mask = this.p.c.get(i5);
                    this.a.set(this.p.a.get(i5).e());
                    this.a.transform(matrix2);
                    int iH = b.c.a.y.b.h(mask.a);
                    if (iH == 0) {
                        if (mask.d) {
                        }
                        this.a.computeBounds(this.k, z3);
                        if (i5 == 0) {
                            this.i.set(this.k);
                        } else {
                            RectF rectF3 = this.i;
                            rectF3.set(Math.min(rectF3.left, this.k.left), Math.min(this.i.top, this.k.top), Math.max(this.i.right, this.k.right), Math.max(this.i.bottom, this.k.bottom));
                        }
                        i5++;
                        z3 = false;
                        i3 = 3;
                        i4 = 2;
                    } else if (iH != 1) {
                        if (iH != i4) {
                            if (iH == i3) {
                            }
                            this.a.computeBounds(this.k, z3);
                            if (i5 == 0) {
                                this.i.set(this.k);
                            } else {
                                RectF rectF4 = this.i;
                                rectF4.set(Math.min(rectF4.left, this.k.left), Math.min(this.i.top, this.k.top), Math.max(this.i.right, this.k.right), Math.max(this.i.bottom, this.k.bottom));
                            }
                            i5++;
                            z3 = false;
                            i3 = 3;
                            i4 = 2;
                        } else {
                            if (mask.d) {
                            }
                            this.a.computeBounds(this.k, z3);
                            if (i5 == 0) {
                                this.i.set(this.k);
                            } else {
                                RectF rectF5 = this.i;
                                rectF5.set(Math.min(rectF5.left, this.k.left), Math.min(this.i.top, this.k.top), Math.max(this.i.right, this.k.right), Math.max(this.i.bottom, this.k.bottom));
                            }
                            i5++;
                            z3 = false;
                            i3 = 3;
                            i4 = 2;
                        }
                    }
                } else if (!rectF2.intersect(this.i)) {
                    f = 0.0f;
                    rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
                    break;
                }
                f = 0.0f;
                break;
            }
        }
        if (!this.h.intersect(f, f, canvas.getWidth(), canvas.getHeight())) {
            this.h.set(f, f, f, f);
        }
        L.a("Layer#computeBounds");
        if (!this.h.isEmpty()) {
            this.c.setAlpha(255);
            Utils.f(canvas, this.h, this.c, 31);
            L.a("Layer#saveLayer");
            i(canvas);
            j(canvas, this.f430b, iIntValue);
            L.a("Layer#drawLayer");
            if (k()) {
                Matrix matrix3 = this.f430b;
                Utils.f(canvas, this.h, this.d, 19);
                if (Build.VERSION.SDK_INT < 28) {
                    i(canvas);
                }
                L.a("Layer#saveLayer");
                int i6 = 0;
                while (i6 < this.p.c.size()) {
                    Mask mask2 = this.p.c.get(i6);
                    BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation2 = this.p.a.get(i6);
                    BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3 = this.p.f395b.get(i6);
                    int iH2 = b.c.a.y.b.h(mask2.a);
                    if (iH2 != 0) {
                        if (iH2 == i2) {
                            if (i6 == 0) {
                                this.c.setColor(ViewCompat.MEASURED_STATE_MASK);
                                this.c.setAlpha(255);
                                canvas.drawRect(this.h, this.c);
                            }
                            if (mask2.d) {
                                Utils.f(canvas, this.h, this.e, 31);
                                canvas.drawRect(this.h, this.c);
                                this.e.setAlpha((int) (baseKeyframeAnimation3.e().intValue() * 2.55f));
                                this.a.set(baseKeyframeAnimation2.e());
                                this.a.transform(matrix3);
                                canvas.drawPath(this.a, this.e);
                                canvas.restore();
                            } else {
                                this.a.set(baseKeyframeAnimation2.e());
                                this.a.transform(matrix3);
                                canvas.drawPath(this.a, this.e);
                            }
                        } else if (iH2 != 2) {
                            if (iH2 == 3) {
                                if (this.p.a.isEmpty()) {
                                    z2 = false;
                                    break;
                                }
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= this.p.c.size()) {
                                        z2 = true;
                                        break;
                                    } else {
                                        if (this.p.c.get(i7).a != 4) {
                                            z2 = false;
                                            break;
                                        }
                                        i7++;
                                    }
                                }
                                if (z2) {
                                    this.c.setAlpha(255);
                                    canvas.drawRect(this.h, this.c);
                                }
                            }
                        } else if (mask2.d) {
                            Utils.f(canvas, this.h, this.d, 31);
                            canvas.drawRect(this.h, this.c);
                            this.e.setAlpha((int) (baseKeyframeAnimation3.e().intValue() * 2.55f));
                            this.a.set(baseKeyframeAnimation2.e());
                            this.a.transform(matrix3);
                            canvas.drawPath(this.a, this.e);
                            canvas.restore();
                        } else {
                            Utils.f(canvas, this.h, this.d, 31);
                            this.a.set(baseKeyframeAnimation2.e());
                            this.a.transform(matrix3);
                            this.c.setAlpha((int) (baseKeyframeAnimation3.e().intValue() * 2.55f));
                            canvas.drawPath(this.a, this.c);
                            canvas.restore();
                        }
                    } else if (mask2.d) {
                        Utils.f(canvas, this.h, this.c, 31);
                        canvas.drawRect(this.h, this.c);
                        this.a.set(baseKeyframeAnimation2.e());
                        this.a.transform(matrix3);
                        this.c.setAlpha((int) (baseKeyframeAnimation3.e().intValue() * 2.55f));
                        canvas.drawPath(this.a, this.e);
                        canvas.restore();
                    } else {
                        this.a.set(baseKeyframeAnimation2.e());
                        this.a.transform(matrix3);
                        this.c.setAlpha((int) (baseKeyframeAnimation3.e().intValue() * 2.55f));
                        canvas.drawPath(this.a, this.c);
                    }
                    i6++;
                    i2 = 1;
                }
                canvas.restore();
                L.a("Layer#restoreLayer");
            }
            if (l()) {
                Utils.f(canvas, this.h, this.f, 19);
                L.a("Layer#saveLayer");
                i(canvas);
                this.r.f(canvas, matrix, iIntValue);
                canvas.restore();
                L.a("Layer#restoreLayer");
                L.a("Layer#drawMatte");
            }
            canvas.restore();
            L.a("Layer#restoreLayer");
        }
        L.a(this.l);
        m(0.0f);
    }

    @Override // b.c.a.y.KeyPathElement
    @CallSuper
    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        this.v.c(t, lottieValueCallback);
    }

    @Override // b.c.a.w.b.Content2
    public String getName() {
        return this.o.c;
    }

    public final void h() {
        if (this.t != null) {
            return;
        }
        if (this.f431s == null) {
            this.t = Collections.emptyList();
            return;
        }
        this.t = new ArrayList();
        for (BaseLayer2 baseLayer2 = this.f431s; baseLayer2 != null; baseLayer2 = baseLayer2.f431s) {
            this.t.add(baseLayer2);
        }
    }

    public final void i(Canvas canvas) {
        RectF rectF = this.h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.g);
        L.a("Layer#clearLayer");
    }

    public abstract void j(Canvas canvas, Matrix matrix, int i);

    public boolean k() {
        MaskKeyframeAnimation maskKeyframeAnimation = this.p;
        return (maskKeyframeAnimation == null || maskKeyframeAnimation.a.isEmpty()) ? false : true;
    }

    public boolean l() {
        return this.r != null;
    }

    public final void m(float f) {
        PerformanceTracker performanceTracker = this.n.k.a;
        String str = this.o.c;
        if (performanceTracker.a) {
            MeanCalculator meanCalculator = performanceTracker.c.get(str);
            if (meanCalculator == null) {
                meanCalculator = new MeanCalculator();
                performanceTracker.c.put(str, meanCalculator);
            }
            float f2 = meanCalculator.a + f;
            meanCalculator.a = f2;
            int i = meanCalculator.f345b + 1;
            meanCalculator.f345b = i;
            if (i == Integer.MAX_VALUE) {
                meanCalculator.a = f2 / 2.0f;
                meanCalculator.f345b = i / 2;
            }
            if (str.equals("__container")) {
                Iterator<PerformanceTracker.a> it = performanceTracker.f375b.iterator();
                while (it.hasNext()) {
                    it.next().a(f);
                }
            }
        }
    }

    public void n(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
    }

    public void o(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.v;
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = transformKeyframeAnimation.j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.h(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = transformKeyframeAnimation.m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.h(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = transformKeyframeAnimation.n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.h(f);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = transformKeyframeAnimation.f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.h(f);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = transformKeyframeAnimation.g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.h(f);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = transformKeyframeAnimation.h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.h(f);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = transformKeyframeAnimation.i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.h(f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = transformKeyframeAnimation.k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.h(f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = transformKeyframeAnimation.l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.h(f);
        }
        if (this.p != null) {
            for (int i = 0; i < this.p.a.size(); i++) {
                this.p.a.get(i).h(f);
            }
        }
        float f2 = this.o.m;
        if (f2 != 0.0f) {
            f /= f2;
        }
        FloatKeyframeAnimation floatKeyframeAnimation3 = this.q;
        if (floatKeyframeAnimation3 != null) {
            floatKeyframeAnimation3.h(f / f2);
        }
        BaseLayer2 baseLayer2 = this.r;
        if (baseLayer2 != null) {
            baseLayer2.o(baseLayer2.o.m * f);
        }
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            this.u.get(i2).h(f);
        }
    }

    public final void p(boolean z2) {
        if (z2 != this.w) {
            this.w = z2;
            this.n.invalidateSelf();
        }
    }
}
