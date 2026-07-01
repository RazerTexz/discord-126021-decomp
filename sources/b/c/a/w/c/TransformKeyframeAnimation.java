package b.c.a.w.c;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.c.a.LottieProperty;
import b.c.a.c0.Keyframe;
import b.c.a.c0.LottieValueCallback;
import b.c.a.c0.ScaleXY;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.y.k.AnimatableFloatValue;
import b.c.a.y.k.AnimatableIntegerValue;
import b.c.a.y.k.AnimatablePathValue;
import b.c.a.y.k.AnimatableScaleValue;
import b.c.a.y.k.AnimatableTransform;
import b.c.a.y.k.AnimatableValue;
import b.c.a.y.m.BaseLayer2;
import java.util.Collections;

/* JADX INFO: renamed from: b.c.a.w.c.o, reason: use source file name */
/* JADX INFO: compiled from: TransformKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class TransformKeyframeAnimation {
    public final Matrix a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f396b;
    public final Matrix c;
    public final Matrix d;
    public final float[] e;

    @NonNull
    public BaseKeyframeAnimation<PointF, PointF> f;

    @NonNull
    public BaseKeyframeAnimation<?, PointF> g;

    @NonNull
    public BaseKeyframeAnimation<ScaleXY, ScaleXY> h;

    @NonNull
    public BaseKeyframeAnimation<Float, Float> i;

    @NonNull
    public BaseKeyframeAnimation<Integer, Integer> j;

    @Nullable
    public FloatKeyframeAnimation k;

    @Nullable
    public FloatKeyframeAnimation l;

    @Nullable
    public BaseKeyframeAnimation<?, Float> m;

    @Nullable
    public BaseKeyframeAnimation<?, Float> n;

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform) {
        AnimatablePathValue animatablePathValue = animatableTransform.a;
        this.f = animatablePathValue == null ? null : animatablePathValue.a();
        AnimatableValue<PointF, PointF> animatableValue = animatableTransform.f414b;
        this.g = animatableValue == null ? null : animatableValue.a();
        AnimatableScaleValue animatableScaleValue = animatableTransform.c;
        this.h = animatableScaleValue == null ? null : animatableScaleValue.a();
        AnimatableFloatValue animatableFloatValue = animatableTransform.d;
        this.i = animatableFloatValue == null ? null : animatableFloatValue.a();
        AnimatableFloatValue animatableFloatValue2 = animatableTransform.f;
        FloatKeyframeAnimation floatKeyframeAnimation = animatableFloatValue2 == null ? null : (FloatKeyframeAnimation) animatableFloatValue2.a();
        this.k = floatKeyframeAnimation;
        if (floatKeyframeAnimation != null) {
            this.f396b = new Matrix();
            this.c = new Matrix();
            this.d = new Matrix();
            this.e = new float[9];
        } else {
            this.f396b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
        AnimatableFloatValue animatableFloatValue3 = animatableTransform.g;
        this.l = animatableFloatValue3 == null ? null : (FloatKeyframeAnimation) animatableFloatValue3.a();
        AnimatableIntegerValue animatableIntegerValue = animatableTransform.e;
        if (animatableIntegerValue != null) {
            this.j = animatableIntegerValue.a();
        }
        AnimatableFloatValue animatableFloatValue4 = animatableTransform.h;
        if (animatableFloatValue4 != null) {
            this.m = animatableFloatValue4.a();
        } else {
            this.m = null;
        }
        AnimatableFloatValue animatableFloatValue5 = animatableTransform.i;
        if (animatableFloatValue5 != null) {
            this.n = animatableFloatValue5.a();
        } else {
            this.n = null;
        }
    }

    public void a(BaseLayer2 baseLayer2) {
        baseLayer2.e(this.j);
        baseLayer2.e(this.m);
        baseLayer2.e(this.n);
        baseLayer2.e(this.f);
        baseLayer2.e(this.g);
        baseLayer2.e(this.h);
        baseLayer2.e(this.i);
        baseLayer2.e(this.k);
        baseLayer2.e(this.l);
    }

    public void b(BaseKeyframeAnimation.b bVar) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.a.add(bVar);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.a.add(bVar);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.a.add(bVar);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.a.add(bVar);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.a.add(bVar);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.a.add(bVar);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.a.add(bVar);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.a.add(bVar);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.a.add(bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> boolean c(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        FloatKeyframeAnimation floatKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.e) {
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation3 = this.f;
            if (baseKeyframeAnimation3 == null) {
                this.f = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            LottieValueCallback<PointF> lottieValueCallback2 = baseKeyframeAnimation3.e;
            baseKeyframeAnimation3.e = lottieValueCallback;
            return true;
        }
        if (t == LottieProperty.f) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation4 = this.g;
            if (baseKeyframeAnimation4 == null) {
                this.g = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            LottieValueCallback<PointF> lottieValueCallback3 = baseKeyframeAnimation4.e;
            baseKeyframeAnimation4.e = lottieValueCallback;
            return true;
        }
        if (t == LottieProperty.k) {
            BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation5 = this.h;
            if (baseKeyframeAnimation5 == null) {
                this.h = new ValueCallbackKeyframeAnimation(lottieValueCallback, new ScaleXY());
                return true;
            }
            LottieValueCallback<ScaleXY> lottieValueCallback4 = baseKeyframeAnimation5.e;
            baseKeyframeAnimation5.e = lottieValueCallback;
            return true;
        }
        if (t == LottieProperty.l) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.i;
            if (baseKeyframeAnimation6 == null) {
                this.i = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(0.0f));
                return true;
            }
            LottieValueCallback<Float> lottieValueCallback5 = baseKeyframeAnimation6.e;
            baseKeyframeAnimation6.e = lottieValueCallback;
            return true;
        }
        if (t == LottieProperty.c) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation7 = this.j;
            if (baseKeyframeAnimation7 == null) {
                this.j = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            LottieValueCallback<Integer> lottieValueCallback6 = baseKeyframeAnimation7.e;
            baseKeyframeAnimation7.e = lottieValueCallback;
            return true;
        }
        if (t == LottieProperty.f371y && (baseKeyframeAnimation2 = this.m) != null) {
            if (baseKeyframeAnimation2 == null) {
                this.m = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            LottieValueCallback<Float> lottieValueCallback7 = baseKeyframeAnimation2.e;
            baseKeyframeAnimation2.e = lottieValueCallback;
            return true;
        }
        if (t == LottieProperty.f372z && (baseKeyframeAnimation = this.n) != null) {
            if (baseKeyframeAnimation == null) {
                this.n = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            LottieValueCallback<Float> lottieValueCallback8 = baseKeyframeAnimation.e;
            baseKeyframeAnimation.e = lottieValueCallback;
            return true;
        }
        if (t == LottieProperty.m && (floatKeyframeAnimation2 = this.k) != null) {
            if (floatKeyframeAnimation2 == null) {
                this.k = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
            }
            FloatKeyframeAnimation floatKeyframeAnimation3 = this.k;
            Object obj = floatKeyframeAnimation3.e;
            floatKeyframeAnimation3.e = lottieValueCallback;
            return true;
        }
        if (t != LottieProperty.n || (floatKeyframeAnimation = this.l) == null) {
            return false;
        }
        if (floatKeyframeAnimation == null) {
            this.l = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
        }
        FloatKeyframeAnimation floatKeyframeAnimation4 = this.l;
        Object obj2 = floatKeyframeAnimation4.e;
        floatKeyframeAnimation4.e = lottieValueCallback;
        return true;
    }

    public final void d() {
        for (int i = 0; i < 9; i++) {
            this.e[i] = 0.0f;
        }
    }

    public Matrix e() {
        this.a.reset();
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.g;
        if (baseKeyframeAnimation != null) {
            PointF pointFE = baseKeyframeAnimation.e();
            float f = pointFE.x;
            if (f != 0.0f || pointFE.y != 0.0f) {
                this.a.preTranslate(f, pointFE.y);
            }
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.i;
        if (baseKeyframeAnimation2 != null) {
            float fFloatValue = baseKeyframeAnimation2 instanceof ValueCallbackKeyframeAnimation ? baseKeyframeAnimation2.e().floatValue() : ((FloatKeyframeAnimation) baseKeyframeAnimation2).j();
            if (fFloatValue != 0.0f) {
                this.a.preRotate(fFloatValue);
            }
        }
        if (this.k != null) {
            FloatKeyframeAnimation floatKeyframeAnimation = this.l;
            float fCos = floatKeyframeAnimation == null ? 0.0f : (float) Math.cos(Math.toRadians((-floatKeyframeAnimation.j()) + 90.0f));
            FloatKeyframeAnimation floatKeyframeAnimation2 = this.l;
            float fSin = floatKeyframeAnimation2 == null ? 1.0f : (float) Math.sin(Math.toRadians((-floatKeyframeAnimation2.j()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(this.k.j()));
            d();
            float[] fArr = this.e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f2 = -fSin;
            fArr[3] = f2;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.f396b.setValues(fArr);
            d();
            float[] fArr2 = this.e;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.c.setValues(fArr2);
            d();
            float[] fArr3 = this.e;
            fArr3[0] = fCos;
            fArr3[1] = f2;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.d.setValues(fArr3);
            this.c.preConcat(this.f396b);
            this.d.preConcat(this.c);
            this.a.preConcat(this.d);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation3 = this.h;
        if (baseKeyframeAnimation3 != null) {
            ScaleXY scaleXYE = baseKeyframeAnimation3.e();
            float f3 = scaleXYE.a;
            if (f3 != 1.0f || scaleXYE.f350b != 1.0f) {
                this.a.preScale(f3, scaleXYE.f350b);
            }
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f;
        if (baseKeyframeAnimation4 != null) {
            PointF pointFE2 = baseKeyframeAnimation4.e();
            float f4 = pointFE2.x;
            if (f4 != 0.0f || pointFE2.y != 0.0f) {
                this.a.preTranslate(-f4, -pointFE2.y);
            }
        }
        return this.a;
    }

    public Matrix f(float f) {
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.g;
        PointF pointFE = baseKeyframeAnimation == null ? null : baseKeyframeAnimation.e();
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation2 = this.h;
        ScaleXY scaleXYE = baseKeyframeAnimation2 == null ? null : baseKeyframeAnimation2.e();
        this.a.reset();
        if (pointFE != null) {
            this.a.preTranslate(pointFE.x * f, pointFE.y * f);
        }
        if (scaleXYE != null) {
            double d = f;
            this.a.preScale((float) Math.pow(scaleXYE.a, d), (float) Math.pow(scaleXYE.f350b, d));
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.i;
        if (baseKeyframeAnimation3 != null) {
            float fFloatValue = baseKeyframeAnimation3.e().floatValue();
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f;
            PointF pointFE2 = baseKeyframeAnimation4 != null ? baseKeyframeAnimation4.e() : null;
            this.a.preRotate(fFloatValue * f, pointFE2 == null ? 0.0f : pointFE2.x, pointFE2 != null ? pointFE2.y : 0.0f);
        }
        return this.a;
    }
}
