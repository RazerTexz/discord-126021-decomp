package b.c.a.w.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import b.c.a.L;
import b.c.a.LottieDrawable;
import b.c.a.LottieProperty;
import b.c.a.b0.MiscUtils;
import b.c.a.b0.Utils;
import b.c.a.c0.LottieValueCallback;
import b.c.a.w.LPaint;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.FloatKeyframeAnimation;
import b.c.a.w.c.IntegerKeyframeAnimation;
import b.c.a.w.c.ValueCallbackKeyframeAnimation;
import b.c.a.y.KeyPath;
import b.c.a.y.k.AnimatableFloatValue;
import b.c.a.y.k.AnimatableIntegerValue;
import b.c.a.y.m.BaseLayer2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.w.b.a, reason: use source file name */
/* JADX INFO: compiled from: BaseStrokeContent.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseStrokeContent implements BaseKeyframeAnimation.b, KeyPathElementContent, DrawingContent {
    public final LottieDrawable e;
    public final BaseLayer2 f;
    public final float[] h;
    public final Paint i;
    public final BaseKeyframeAnimation<?, Float> j;
    public final BaseKeyframeAnimation<?, Integer> k;
    public final List<BaseKeyframeAnimation<?, Float>> l;

    @Nullable
    public final BaseKeyframeAnimation<?, Float> m;

    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> n;
    public final PathMeasure a = new PathMeasure();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f376b = new Path();
    public final Path c = new Path();
    public final RectF d = new RectF();
    public final List<b> g = new ArrayList();

    /* JADX INFO: renamed from: b.c.a.w.b.a$b */
    /* JADX INFO: compiled from: BaseStrokeContent.java */
    public static final class b {
        public final List<PathContent> a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final TrimPathContent f377b;

        public b(TrimPathContent trimPathContent, a aVar) {
            this.f377b = trimPathContent;
        }
    }

    public BaseStrokeContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, Paint.Cap cap, Paint.Join join, float f, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2) {
        LPaint lPaint = new LPaint(1);
        this.i = lPaint;
        this.e = lottieDrawable;
        this.f = baseLayer2;
        lPaint.setStyle(Paint.Style.STROKE);
        lPaint.setStrokeCap(cap);
        lPaint.setStrokeJoin(join);
        lPaint.setStrokeMiter(f);
        this.k = animatableIntegerValue.a();
        this.j = animatableFloatValue.a();
        if (animatableFloatValue2 == null) {
            this.m = null;
        } else {
            this.m = animatableFloatValue2.a();
        }
        this.l = new ArrayList(list.size());
        this.h = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.l.add(list.get(i).a());
        }
        baseLayer2.e(this.k);
        baseLayer2.e(this.j);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            baseLayer2.e(this.l.get(i2));
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.m;
        if (baseKeyframeAnimation != null) {
            baseLayer2.e(baseKeyframeAnimation);
        }
        this.k.a.add(this);
        this.j.a.add(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.l.get(i3).a.add(this);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.a.add(this);
        }
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation.b
    public void a() {
        this.e.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0052  */
    /* JADX WARN: Code duplicated, block: B:24:0x0056 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0058  */
    /* JADX WARN: Code duplicated, block: B:38:0x0064 A[SYNTHETIC] */
    @Override // b.c.a.w.b.Content2
    public void b(List<Content2> list, List<Content2> list2) {
        TrimPathContent trimPathContent = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content2 content2 = list.get(size);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent2 = (TrimPathContent) content2;
                if (trimPathContent2.c == 2) {
                    trimPathContent = trimPathContent2;
                }
            }
        }
        if (trimPathContent != null) {
            trimPathContent.f391b.add(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Content2 content3 = list2.get(size2);
            if (content3 instanceof TrimPathContent) {
                TrimPathContent trimPathContent3 = (TrimPathContent) content3;
                if (trimPathContent3.c == 2) {
                    if (bVar != null) {
                        this.g.add(bVar);
                    }
                    bVar = new b(trimPathContent3, null);
                    trimPathContent3.f391b.add(this);
                } else if (!(content3 instanceof PathContent)) {
                    if (bVar == null) {
                        bVar = new b(trimPathContent, null);
                    }
                    bVar.a.add((PathContent) content3);
                }
            } else if (!(content3 instanceof PathContent)) {
                if (bVar == null) {
                    bVar = new b(trimPathContent, null);
                }
                bVar.a.add((PathContent) content3);
            }
        }
        if (bVar != null) {
            this.g.add(bVar);
        }
    }

    @Override // b.c.a.y.KeyPathElement
    public void c(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.f(keyPath, i, list, keyPath2, this);
    }

    @Override // b.c.a.w.b.DrawingContent
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        this.f376b.reset();
        for (int i = 0; i < this.g.size(); i++) {
            b bVar = this.g.get(i);
            for (int i2 = 0; i2 < bVar.a.size(); i2++) {
                this.f376b.addPath(bVar.a.get(i2).getPath(), matrix);
            }
        }
        this.f376b.computeBounds(this.d, false);
        float fJ = ((FloatKeyframeAnimation) this.j).j();
        RectF rectF2 = this.d;
        float f = fJ / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        L.a("StrokeContent#getBounds");
    }

    /* JADX WARN: Code duplicated, block: B:69:0x01ff  */
    @Override // b.c.a.w.b.DrawingContent
    public void f(Canvas canvas, Matrix matrix, int i) {
        float f;
        float[] fArr = Utils.d;
        boolean z2 = false;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        if (fArr[0] == fArr[2] || fArr[1] == fArr[3]) {
            L.a("StrokeContent#draw");
            return;
        }
        IntegerKeyframeAnimation integerKeyframeAnimation = (IntegerKeyframeAnimation) this.k;
        float fJ = (i / 255.0f) * integerKeyframeAnimation.j(integerKeyframeAnimation.a(), integerKeyframeAnimation.c());
        float f2 = 100.0f;
        this.i.setAlpha(MiscUtils.c((int) ((fJ / 100.0f) * 255.0f), 0, 255));
        this.i.setStrokeWidth(Utils.d(matrix) * ((FloatKeyframeAnimation) this.j).j());
        if (this.i.getStrokeWidth() <= 0.0f) {
            L.a("StrokeContent#draw");
            return;
        }
        float f3 = 1.0f;
        if (this.l.isEmpty()) {
            L.a("StrokeContent#applyDashPattern");
        } else {
            float fD = Utils.d(matrix);
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                this.h[i2] = this.l.get(i2).e().floatValue();
                if (i2 % 2 == 0) {
                    float[] fArr2 = this.h;
                    if (fArr2[i2] < 1.0f) {
                        fArr2[i2] = 1.0f;
                    }
                } else {
                    float[] fArr3 = this.h;
                    if (fArr3[i2] < 0.1f) {
                        fArr3[i2] = 0.1f;
                    }
                }
                float[] fArr4 = this.h;
                fArr4[i2] = fArr4[i2] * fD;
            }
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.m;
            this.i.setPathEffect(new DashPathEffect(this.h, baseKeyframeAnimation == null ? 0.0f : baseKeyframeAnimation.e().floatValue() * fD));
            L.a("StrokeContent#applyDashPattern");
        }
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation2 = this.n;
        if (baseKeyframeAnimation2 != null) {
            this.i.setColorFilter(baseKeyframeAnimation2.e());
        }
        int i3 = 0;
        while (i3 < this.g.size()) {
            b bVar = this.g.get(i3);
            TrimPathContent trimPathContent = bVar.f377b;
            if (trimPathContent == null) {
                this.f376b.reset();
                for (int size = bVar.a.size() - 1; size >= 0; size--) {
                    this.f376b.addPath(bVar.a.get(size).getPath(), matrix);
                }
                L.a("StrokeContent#buildPath");
                canvas.drawPath(this.f376b, this.i);
                L.a("StrokeContent#drawPath");
            } else if (trimPathContent == null) {
                L.a("StrokeContent#applyTrimPath");
            } else {
                this.f376b.reset();
                int size2 = bVar.a.size();
                while (true) {
                    size2--;
                    if (size2 < 0) {
                        break;
                    } else {
                        this.f376b.addPath(bVar.a.get(size2).getPath(), matrix);
                    }
                }
                this.a.setPath(this.f376b, z2);
                float length = this.a.getLength();
                while (this.a.nextContour()) {
                    length += this.a.getLength();
                }
                float fFloatValue = (bVar.f377b.f.e().floatValue() * length) / 360.0f;
                float fFloatValue2 = ((bVar.f377b.d.e().floatValue() * length) / f2) + fFloatValue;
                float fFloatValue3 = ((bVar.f377b.e.e().floatValue() * length) / f2) + fFloatValue;
                int size3 = bVar.a.size() - 1;
                float f4 = 0.0f;
                while (size3 >= 0) {
                    this.c.set(bVar.a.get(size3).getPath());
                    this.c.transform(matrix);
                    this.a.setPath(this.c, z2);
                    float length2 = this.a.getLength();
                    if (fFloatValue3 > length) {
                        float f5 = fFloatValue3 - length;
                        if (f5 >= f4 + length2 || f4 >= f5) {
                            f = f4 + length2;
                            if (f < fFloatValue2 && f4 <= fFloatValue3) {
                                if (f > fFloatValue3 || fFloatValue2 >= f4) {
                                    Utils.a(this.c, fFloatValue2 < f4 ? 0.0f : (fFloatValue2 - f4) / length2, fFloatValue3 > f ? 1.0f : (fFloatValue3 - f4) / length2, 0.0f);
                                    canvas.drawPath(this.c, this.i);
                                } else {
                                    canvas.drawPath(this.c, this.i);
                                }
                            }
                        } else {
                            Utils.a(this.c, fFloatValue2 > length ? (fFloatValue2 - length) / length2 : 0.0f, Math.min(f5 / length2, f3), 0.0f);
                            canvas.drawPath(this.c, this.i);
                        }
                    } else {
                        f = f4 + length2;
                        if (f < fFloatValue2) {
                        }
                    }
                    f4 += length2;
                    size3--;
                    z2 = false;
                    f3 = 1.0f;
                }
                L.a("StrokeContent#applyTrimPath");
            }
            i3++;
            z2 = false;
            f2 = 100.0f;
            f3 = 1.0f;
        }
        L.a("StrokeContent#draw");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.y.KeyPathElement
    @CallSuper
    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.d) {
            BaseKeyframeAnimation<?, Integer> baseKeyframeAnimation = this.k;
            LottieValueCallback<Integer> lottieValueCallback2 = baseKeyframeAnimation.e;
            baseKeyframeAnimation.e = lottieValueCallback;
            return;
        }
        if (t == LottieProperty.o) {
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.j;
            LottieValueCallback<Float> lottieValueCallback3 = baseKeyframeAnimation2.e;
            baseKeyframeAnimation2.e = lottieValueCallback;
        } else if (t == LottieProperty.C) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation3 = this.n;
            if (baseKeyframeAnimation3 != null) {
                this.f.u.remove(baseKeyframeAnimation3);
            }
            if (lottieValueCallback == 0) {
                this.n = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.n = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a.add(this);
            this.f.e(this.n);
        }
    }
}
