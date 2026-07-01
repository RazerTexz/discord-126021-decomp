package b.c.a.w.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import b.c.a.LottieDrawable;
import b.c.a.LottieProperty;
import b.c.a.b0.MiscUtils;
import b.c.a.c0.LottieValueCallback;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.FloatKeyframeAnimation;
import b.c.a.y.KeyPath;
import b.c.a.y.l.RectangleShape;
import b.c.a.y.m.BaseLayer2;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.w.b.o, reason: use source file name */
/* JADX INFO: compiled from: RectangleContent.java */
/* JADX INFO: loaded from: classes.dex */
public class RectangleContent implements BaseKeyframeAnimation.b, KeyPathElementContent, PathContent {
    public final String c;
    public final boolean d;
    public final LottieDrawable e;
    public final BaseKeyframeAnimation<?, PointF> f;
    public final BaseKeyframeAnimation<?, PointF> g;
    public final BaseKeyframeAnimation<?, Float> h;
    public boolean j;
    public final Path a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f387b = new RectF();
    public CompoundTrimPathContent i = new CompoundTrimPathContent();

    public RectangleContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, RectangleShape rectangleShape) {
        this.c = rectangleShape.a;
        this.d = rectangleShape.e;
        this.e = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationA = rectangleShape.f422b.a();
        this.f = baseKeyframeAnimationA;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationA2 = rectangleShape.c.a();
        this.g = baseKeyframeAnimationA2;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA3 = rectangleShape.d.a();
        this.h = baseKeyframeAnimationA3;
        baseLayer2.e(baseKeyframeAnimationA);
        baseLayer2.e(baseKeyframeAnimationA2);
        baseLayer2.e(baseKeyframeAnimationA3);
        baseKeyframeAnimationA.a.add(this);
        baseKeyframeAnimationA2.a.add(this);
        baseKeyframeAnimationA3.a.add(this);
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation.b
    public void a() {
        this.j = false;
        this.e.invalidateSelf();
    }

    @Override // b.c.a.w.b.Content2
    public void b(List<Content2> list, List<Content2> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content2 content2 = list.get(i);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content2;
                if (trimPathContent.c == 1) {
                    this.i.a.add(trimPathContent);
                    trimPathContent.f391b.add(this);
                }
            }
        }
    }

    @Override // b.c.a.y.KeyPathElement
    public void c(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.f(keyPath, i, list, keyPath2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.y.KeyPathElement
    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.h) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.g;
            LottieValueCallback<PointF> lottieValueCallback2 = baseKeyframeAnimation.e;
            baseKeyframeAnimation.e = lottieValueCallback;
        } else if (t == LottieProperty.j) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation2 = this.f;
            LottieValueCallback<PointF> lottieValueCallback3 = baseKeyframeAnimation2.e;
            baseKeyframeAnimation2.e = lottieValueCallback;
        } else if (t == LottieProperty.i) {
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.h;
            LottieValueCallback<Float> lottieValueCallback4 = baseKeyframeAnimation3.e;
            baseKeyframeAnimation3.e = lottieValueCallback;
        }
    }

    @Override // b.c.a.w.b.Content2
    public String getName() {
        return this.c;
    }

    @Override // b.c.a.w.b.PathContent
    public Path getPath() {
        if (this.j) {
            return this.a;
        }
        this.a.reset();
        if (this.d) {
            this.j = true;
            return this.a;
        }
        PointF pointFE = this.g.e();
        float f = pointFE.x / 2.0f;
        float f2 = pointFE.y / 2.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.h;
        float fJ = baseKeyframeAnimation == null ? 0.0f : ((FloatKeyframeAnimation) baseKeyframeAnimation).j();
        float fMin = Math.min(f, f2);
        if (fJ > fMin) {
            fJ = fMin;
        }
        PointF pointFE2 = this.f.e();
        this.a.moveTo(pointFE2.x + f, (pointFE2.y - f2) + fJ);
        this.a.lineTo(pointFE2.x + f, (pointFE2.y + f2) - fJ);
        if (fJ > 0.0f) {
            RectF rectF = this.f387b;
            float f3 = pointFE2.x;
            float f4 = fJ * 2.0f;
            float f5 = pointFE2.y;
            rectF.set((f3 + f) - f4, (f5 + f2) - f4, f3 + f, f5 + f2);
            this.a.arcTo(this.f387b, 0.0f, 90.0f, false);
        }
        this.a.lineTo((pointFE2.x - f) + fJ, pointFE2.y + f2);
        if (fJ > 0.0f) {
            RectF rectF2 = this.f387b;
            float f6 = pointFE2.x;
            float f7 = pointFE2.y;
            float f8 = fJ * 2.0f;
            rectF2.set(f6 - f, (f7 + f2) - f8, (f6 - f) + f8, f7 + f2);
            this.a.arcTo(this.f387b, 90.0f, 90.0f, false);
        }
        this.a.lineTo(pointFE2.x - f, (pointFE2.y - f2) + fJ);
        if (fJ > 0.0f) {
            RectF rectF3 = this.f387b;
            float f9 = pointFE2.x;
            float f10 = pointFE2.y;
            float f11 = fJ * 2.0f;
            rectF3.set(f9 - f, f10 - f2, (f9 - f) + f11, (f10 - f2) + f11);
            this.a.arcTo(this.f387b, 180.0f, 90.0f, false);
        }
        this.a.lineTo((pointFE2.x + f) - fJ, pointFE2.y - f2);
        if (fJ > 0.0f) {
            RectF rectF4 = this.f387b;
            float f12 = pointFE2.x;
            float f13 = fJ * 2.0f;
            float f14 = pointFE2.y;
            rectF4.set((f12 + f) - f13, f14 - f2, f12 + f, (f14 - f2) + f13);
            this.a.arcTo(this.f387b, 270.0f, 90.0f, false);
        }
        this.a.close();
        this.i.a(this.a);
        this.j = true;
        return this.a;
    }
}
