package b.c.a.w.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import b.c.a.LottieDrawable;
import b.c.a.LottieProperty;
import b.c.a.b0.MiscUtils;
import b.c.a.c0.LottieValueCallback;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.y.KeyPath;
import b.c.a.y.l.CircleShape;
import b.c.a.y.m.BaseLayer2;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.w.b.f, reason: use source file name */
/* JADX INFO: compiled from: EllipseContent.java */
/* JADX INFO: loaded from: classes.dex */
public class EllipseContent implements PathContent, BaseKeyframeAnimation.b, KeyPathElementContent {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f379b;
    public final LottieDrawable c;
    public final BaseKeyframeAnimation<?, PointF> d;
    public final BaseKeyframeAnimation<?, PointF> e;
    public final CircleShape f;
    public boolean h;
    public final Path a = new Path();
    public CompoundTrimPathContent g = new CompoundTrimPathContent();

    public EllipseContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, CircleShape circleShape) {
        this.f379b = circleShape.a;
        this.c = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationA = circleShape.c.a();
        this.d = baseKeyframeAnimationA;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationA2 = circleShape.f415b.a();
        this.e = baseKeyframeAnimationA2;
        this.f = circleShape;
        baseLayer2.e(baseKeyframeAnimationA);
        baseLayer2.e(baseKeyframeAnimationA2);
        baseKeyframeAnimationA.a.add(this);
        baseKeyframeAnimationA2.a.add(this);
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation.b
    public void a() {
        this.h = false;
        this.c.invalidateSelf();
    }

    @Override // b.c.a.w.b.Content2
    public void b(List<Content2> list, List<Content2> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content2 content2 = list.get(i);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content2;
                if (trimPathContent.c == 1) {
                    this.g.a.add(trimPathContent);
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
        if (t == LottieProperty.g) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.d;
            LottieValueCallback<PointF> lottieValueCallback2 = baseKeyframeAnimation.e;
            baseKeyframeAnimation.e = lottieValueCallback;
        } else if (t == LottieProperty.j) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation2 = this.e;
            LottieValueCallback<PointF> lottieValueCallback3 = baseKeyframeAnimation2.e;
            baseKeyframeAnimation2.e = lottieValueCallback;
        }
    }

    @Override // b.c.a.w.b.Content2
    public String getName() {
        return this.f379b;
    }

    @Override // b.c.a.w.b.PathContent
    public Path getPath() {
        if (this.h) {
            return this.a;
        }
        this.a.reset();
        if (this.f.e) {
            this.h = true;
            return this.a;
        }
        PointF pointFE = this.d.e();
        float f = pointFE.x / 2.0f;
        float f2 = pointFE.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.a.reset();
        if (this.f.d) {
            float f5 = -f2;
            this.a.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.a.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.a.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.a.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.a.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.a.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.a.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.a.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.a.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.a.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointFE2 = this.e.e();
        this.a.offset(pointFE2.x, pointFE2.y);
        this.a.close();
        this.g.a(this.a);
        this.h = true;
        return this.a;
    }
}
