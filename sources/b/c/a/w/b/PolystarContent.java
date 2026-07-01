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
import b.c.a.y.l.PolystarShape;
import b.c.a.y.m.BaseLayer2;
import b.d.b.a.outline;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.w.b.n, reason: use source file name */
/* JADX INFO: compiled from: PolystarContent.java */
/* JADX INFO: loaded from: classes.dex */
public class PolystarContent implements PathContent, BaseKeyframeAnimation.b, KeyPathElementContent {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f386b;
    public final LottieDrawable c;
    public final PolystarShape.a d;
    public final boolean e;
    public final BaseKeyframeAnimation<?, Float> f;
    public final BaseKeyframeAnimation<?, PointF> g;
    public final BaseKeyframeAnimation<?, Float> h;

    @Nullable
    public final BaseKeyframeAnimation<?, Float> i;
    public final BaseKeyframeAnimation<?, Float> j;

    @Nullable
    public final BaseKeyframeAnimation<?, Float> k;
    public final BaseKeyframeAnimation<?, Float> l;
    public boolean n;
    public final Path a = new Path();
    public CompoundTrimPathContent m = new CompoundTrimPathContent();

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, PolystarShape polystarShape) {
        this.c = lottieDrawable;
        this.f386b = polystarShape.a;
        PolystarShape.a aVar = polystarShape.f421b;
        this.d = aVar;
        this.e = polystarShape.j;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA = polystarShape.c.a();
        this.f = baseKeyframeAnimationA;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationA2 = polystarShape.d.a();
        this.g = baseKeyframeAnimationA2;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA3 = polystarShape.e.a();
        this.h = baseKeyframeAnimationA3;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA4 = polystarShape.g.a();
        this.j = baseKeyframeAnimationA4;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA5 = polystarShape.i.a();
        this.l = baseKeyframeAnimationA5;
        PolystarShape.a aVar2 = PolystarShape.a.STAR;
        if (aVar == aVar2) {
            this.i = polystarShape.f.a();
            this.k = polystarShape.h.a();
        } else {
            this.i = null;
            this.k = null;
        }
        baseLayer2.e(baseKeyframeAnimationA);
        baseLayer2.e(baseKeyframeAnimationA2);
        baseLayer2.e(baseKeyframeAnimationA3);
        baseLayer2.e(baseKeyframeAnimationA4);
        baseLayer2.e(baseKeyframeAnimationA5);
        if (aVar == aVar2) {
            baseLayer2.e(this.i);
            baseLayer2.e(this.k);
        }
        baseKeyframeAnimationA.a.add(this);
        baseKeyframeAnimationA2.a.add(this);
        baseKeyframeAnimationA3.a.add(this);
        baseKeyframeAnimationA4.a.add(this);
        baseKeyframeAnimationA5.a.add(this);
        if (aVar == aVar2) {
            this.i.a.add(this);
            this.k.a.add(this);
        }
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation.b
    public void a() {
        this.n = false;
        this.c.invalidateSelf();
    }

    @Override // b.c.a.w.b.Content2
    public void b(List<Content2> list, List<Content2> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content2 content2 = list.get(i);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content2;
                if (trimPathContent.c == 1) {
                    this.m.a.add(trimPathContent);
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
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.f369s) {
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.f;
            LottieValueCallback<Float> lottieValueCallback2 = baseKeyframeAnimation3.e;
            baseKeyframeAnimation3.e = lottieValueCallback;
            return;
        }
        if (t == LottieProperty.t) {
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation4 = this.h;
            LottieValueCallback<Float> lottieValueCallback3 = baseKeyframeAnimation4.e;
            baseKeyframeAnimation4.e = lottieValueCallback;
            return;
        }
        if (t == LottieProperty.j) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.g;
            LottieValueCallback<PointF> lottieValueCallback4 = baseKeyframeAnimation5.e;
            baseKeyframeAnimation5.e = lottieValueCallback;
            return;
        }
        if (t == LottieProperty.u && (baseKeyframeAnimation2 = this.i) != null) {
            LottieValueCallback<Float> lottieValueCallback5 = baseKeyframeAnimation2.e;
            baseKeyframeAnimation2.e = lottieValueCallback;
            return;
        }
        if (t == LottieProperty.v) {
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation6 = this.j;
            LottieValueCallback<Float> lottieValueCallback6 = baseKeyframeAnimation6.e;
            baseKeyframeAnimation6.e = lottieValueCallback;
        } else if (t == LottieProperty.w && (baseKeyframeAnimation = this.k) != null) {
            LottieValueCallback<Float> lottieValueCallback7 = baseKeyframeAnimation.e;
            baseKeyframeAnimation.e = lottieValueCallback;
        } else if (t == LottieProperty.f370x) {
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation7 = this.l;
            LottieValueCallback<Float> lottieValueCallback8 = baseKeyframeAnimation7.e;
            baseKeyframeAnimation7.e = lottieValueCallback;
        }
    }

    @Override // b.c.a.w.b.Content2
    public String getName() {
        return this.f386b;
    }

    @Override // b.c.a.w.b.PathContent
    public Path getPath() {
        float fSin;
        double d;
        float fCos;
        float fA;
        float f;
        float f2;
        if (this.n) {
            return this.a;
        }
        this.a.reset();
        if (this.e) {
            this.n = true;
            return this.a;
        }
        int iOrdinal = this.d.ordinal();
        if (iOrdinal == 0) {
            float fFloatValue = this.f.e().floatValue();
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.h;
            double radians = Math.toRadians((baseKeyframeAnimation != null ? baseKeyframeAnimation.e().floatValue() : 0.0d) - 90.0d);
            double d2 = fFloatValue;
            float f3 = (float) (6.283185307179586d / d2);
            float f4 = f3 / 2.0f;
            float f5 = fFloatValue - ((int) fFloatValue);
            if (f5 != 0.0f) {
                radians += (double) ((1.0f - f5) * f4);
            }
            float fFloatValue2 = this.j.e().floatValue();
            float fFloatValue3 = this.i.e().floatValue();
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.k;
            float fFloatValue4 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.e().floatValue() / 100.0f : 0.0f;
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.l;
            float fFloatValue5 = baseKeyframeAnimation3 != null ? baseKeyframeAnimation3.e().floatValue() / 100.0f : 0.0f;
            if (f5 != 0.0f) {
                fA = outline.a(fFloatValue2, fFloatValue3, f5, fFloatValue3);
                double d3 = fA;
                fCos = (float) (Math.cos(radians) * d3);
                fSin = (float) (d3 * Math.sin(radians));
                this.a.moveTo(fCos, fSin);
                d = radians + ((double) ((f3 * f5) / 2.0f));
            } else {
                double d4 = fFloatValue2;
                float fCos2 = (float) (Math.cos(radians) * d4);
                fSin = (float) (Math.sin(radians) * d4);
                this.a.moveTo(fCos2, fSin);
                d = radians + ((double) f4);
                fCos = fCos2;
                fA = 0.0f;
            }
            double dCeil = Math.ceil(d2) * 2.0d;
            int i = 0;
            boolean z2 = false;
            while (true) {
                double d5 = i;
                if (d5 >= dCeil) {
                    break;
                }
                float f6 = z2 ? fFloatValue2 : fFloatValue3;
                float f7 = (fA == 0.0f || d5 != dCeil - 2.0d) ? f4 : (f3 * f5) / 2.0f;
                if (fA == 0.0f || d5 != dCeil - 1.0d) {
                    fA = f6;
                }
                double d6 = fA;
                float fCos3 = (float) (Math.cos(d) * d6);
                float fSin2 = (float) (d6 * Math.sin(d));
                if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                    this.a.lineTo(fCos3, fSin2);
                    f = fSin2;
                    f2 = fFloatValue5;
                } else {
                    float f8 = fSin;
                    double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                    float fCos4 = (float) Math.cos(dAtan2);
                    float fSin3 = (float) Math.sin(dAtan2);
                    f = fSin2;
                    f2 = fFloatValue5;
                    double dAtan3 = (float) (Math.atan2(fSin2, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) Math.cos(dAtan3);
                    float fSin4 = (float) Math.sin(dAtan3);
                    float f9 = z2 ? fFloatValue4 : f2;
                    float f10 = z2 ? f2 : fFloatValue4;
                    float f11 = (z2 ? fFloatValue3 : fFloatValue2) * f9 * 0.47829f;
                    float f12 = fCos4 * f11;
                    float f13 = f11 * fSin3;
                    float f14 = (z2 ? fFloatValue2 : fFloatValue3) * f10 * 0.47829f;
                    float f15 = fCos5 * f14;
                    float f16 = f14 * fSin4;
                    if (f5 != 0.0f) {
                        if (i == 0) {
                            f12 *= f5;
                            f13 *= f5;
                        } else if (d5 == dCeil - 1.0d) {
                            f15 *= f5;
                            f16 *= f5;
                        }
                    }
                    this.a.cubicTo(fCos - f12, f8 - f13, fCos3 + f15, f + f16, fCos3, f);
                }
                d += (double) f7;
                z2 = !z2;
                i++;
                fCos = fCos3;
                fA = fA;
                f3 = f3;
                fSin = f;
                fFloatValue5 = f2;
            }
            PointF pointFE = this.g.e();
            this.a.offset(pointFE.x, pointFE.y);
            this.a.close();
        } else if (iOrdinal == 1) {
            int iFloor = (int) Math.floor(this.f.e().floatValue());
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation4 = this.h;
            double radians2 = Math.toRadians((baseKeyframeAnimation4 != null ? baseKeyframeAnimation4.e().floatValue() : 0.0d) - 90.0d);
            double d7 = iFloor;
            float fFloatValue6 = this.l.e().floatValue() / 100.0f;
            float fFloatValue7 = this.j.e().floatValue();
            double d8 = fFloatValue7;
            float fCos6 = (float) (Math.cos(radians2) * d8);
            float fSin5 = (float) (Math.sin(radians2) * d8);
            this.a.moveTo(fCos6, fSin5);
            double d9 = (float) (6.283185307179586d / d7);
            double d10 = radians2 + d9;
            double dCeil2 = Math.ceil(d7);
            int i2 = 0;
            while (i2 < dCeil2) {
                float fCos7 = (float) (Math.cos(d10) * d8);
                double d11 = dCeil2;
                float fSin6 = (float) (Math.sin(d10) * d8);
                if (fFloatValue6 != 0.0f) {
                    double dAtan4 = (float) (Math.atan2(fSin5, fCos6) - 1.5707963267948966d);
                    float fCos8 = (float) Math.cos(dAtan4);
                    float fSin7 = (float) Math.sin(dAtan4);
                    double dAtan5 = (float) (Math.atan2(fSin6, fCos7) - 1.5707963267948966d);
                    float f17 = fFloatValue7 * fFloatValue6 * 0.25f;
                    this.a.cubicTo(fCos6 - (fCos8 * f17), fSin5 - (fSin7 * f17), fCos7 + (((float) Math.cos(dAtan5)) * f17), fSin6 + (f17 * ((float) Math.sin(dAtan5))), fCos7, fSin6);
                } else {
                    this.a.lineTo(fCos7, fSin6);
                }
                d10 += d9;
                i2++;
                fSin5 = fSin6;
                fCos6 = fCos7;
                dCeil2 = d11;
                d8 = d8;
                d9 = d9;
            }
            PointF pointFE2 = this.g.e();
            this.a.offset(pointFE2.x, pointFE2.y);
            this.a.close();
        }
        this.a.close();
        this.m.a(this.a);
        this.n = true;
        return this.a;
    }
}
