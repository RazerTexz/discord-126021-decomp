package b.i.a.g.g;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;

/* JADX INFO: renamed from: b.i.a.g.g.d, reason: use source file name */
/* JADX INFO: compiled from: CircularIndeterminateAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CircularIndeterminateAnimatorDelegate3 extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    public static final int[] d = {0, 1350, 2700, 4050};
    public static final int[] e = {667, 2017, 3367, 4717};
    public static final int[] f = {1000, 2350, 3700, 5050};
    public static final Property<CircularIndeterminateAnimatorDelegate3, Float> g = new a(Float.class, "animationFraction");
    public static final Property<CircularIndeterminateAnimatorDelegate3, Float> h = new b(Float.class, "completeEndFraction");
    public ObjectAnimator i;
    public ObjectAnimator j;
    public final FastOutSlowInInterpolator k;
    public final BaseProgressIndicatorSpec l;
    public int m;
    public float n;
    public float o;
    public Animatable2Compat.AnimationCallback p;

    /* JADX INFO: renamed from: b.i.a.g.g.d$a */
    /* JADX INFO: compiled from: CircularIndeterminateAnimatorDelegate.java */
    public static class a extends Property<CircularIndeterminateAnimatorDelegate3, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(CircularIndeterminateAnimatorDelegate3 circularIndeterminateAnimatorDelegate3) {
            return Float.valueOf(circularIndeterminateAnimatorDelegate3.n);
        }

        @Override // android.util.Property
        public void set(CircularIndeterminateAnimatorDelegate3 circularIndeterminateAnimatorDelegate3, Float f) {
            CircularIndeterminateAnimatorDelegate3 circularIndeterminateAnimatorDelegate4 = circularIndeterminateAnimatorDelegate3;
            float fFloatValue = f.floatValue();
            circularIndeterminateAnimatorDelegate4.n = fFloatValue;
            int i = (int) (5400.0f * fFloatValue);
            float[] fArr = circularIndeterminateAnimatorDelegate4.f1623b;
            float f2 = fFloatValue * 1520.0f;
            fArr[0] = (-20.0f) + f2;
            fArr[1] = f2;
            for (int i2 = 0; i2 < 4; i2++) {
                float fB = circularIndeterminateAnimatorDelegate4.b(i, CircularIndeterminateAnimatorDelegate3.d[i2], 667);
                float[] fArr2 = circularIndeterminateAnimatorDelegate4.f1623b;
                fArr2[1] = (circularIndeterminateAnimatorDelegate4.k.getInterpolation(fB) * 250.0f) + fArr2[1];
                float fB2 = circularIndeterminateAnimatorDelegate4.b(i, CircularIndeterminateAnimatorDelegate3.e[i2], 667);
                float[] fArr3 = circularIndeterminateAnimatorDelegate4.f1623b;
                fArr3[0] = (circularIndeterminateAnimatorDelegate4.k.getInterpolation(fB2) * 250.0f) + fArr3[0];
            }
            float[] fArr4 = circularIndeterminateAnimatorDelegate4.f1623b;
            fArr4[0] = ((fArr4[1] - fArr4[0]) * circularIndeterminateAnimatorDelegate4.o) + fArr4[0];
            fArr4[0] = fArr4[0] / 360.0f;
            fArr4[1] = fArr4[1] / 360.0f;
            for (int i3 = 0; i3 < 4; i3++) {
                float fB3 = circularIndeterminateAnimatorDelegate4.b(i, CircularIndeterminateAnimatorDelegate3.f[i3], 333);
                if (fB3 >= 0.0f && fB3 <= 1.0f) {
                    int i4 = i3 + circularIndeterminateAnimatorDelegate4.m;
                    int[] iArr = circularIndeterminateAnimatorDelegate4.l.indicatorColors;
                    int length = i4 % iArr.length;
                    int length2 = (length + 1) % iArr.length;
                    int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(iArr[length], circularIndeterminateAnimatorDelegate4.a.getAlpha());
                    int iCompositeARGBWithAlpha2 = MaterialColors.compositeARGBWithAlpha(circularIndeterminateAnimatorDelegate4.l.indicatorColors[length2], circularIndeterminateAnimatorDelegate4.a.getAlpha());
                    circularIndeterminateAnimatorDelegate4.c[0] = ArgbEvaluatorCompat.getInstance().evaluate(circularIndeterminateAnimatorDelegate4.k.getInterpolation(fB3), Integer.valueOf(iCompositeARGBWithAlpha), Integer.valueOf(iCompositeARGBWithAlpha2)).intValue();
                    break;
                }
            }
            circularIndeterminateAnimatorDelegate4.a.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.g.d$b */
    /* JADX INFO: compiled from: CircularIndeterminateAnimatorDelegate.java */
    public static class b extends Property<CircularIndeterminateAnimatorDelegate3, Float> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(CircularIndeterminateAnimatorDelegate3 circularIndeterminateAnimatorDelegate3) {
            return Float.valueOf(circularIndeterminateAnimatorDelegate3.o);
        }

        @Override // android.util.Property
        public void set(CircularIndeterminateAnimatorDelegate3 circularIndeterminateAnimatorDelegate3, Float f) {
            circularIndeterminateAnimatorDelegate3.o = f.floatValue();
        }
    }

    public CircularIndeterminateAnimatorDelegate3(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.m = 0;
        this.p = null;
        this.l = circularProgressIndicatorSpec;
        this.k = new FastOutSlowInInterpolator();
    }

    @Override // b.i.a.g.g.IndeterminateAnimatorDelegate
    public void a() {
        ObjectAnimator objectAnimator = this.i;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // b.i.a.g.g.IndeterminateAnimatorDelegate
    public void c() {
        h();
    }

    @Override // b.i.a.g.g.IndeterminateAnimatorDelegate
    public void d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.p = animationCallback;
    }

    @Override // b.i.a.g.g.IndeterminateAnimatorDelegate
    public void e() {
        if (this.j.isRunning()) {
            return;
        }
        if (this.a.isVisible()) {
            this.j.start();
        } else {
            a();
        }
    }

    @Override // b.i.a.g.g.IndeterminateAnimatorDelegate
    public void f() {
        if (this.i == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, g, 0.0f, 1.0f);
            this.i = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(5400L);
            this.i.setInterpolator(null);
            this.i.setRepeatCount(-1);
            this.i.addListener(new CircularIndeterminateAnimatorDelegate(this));
        }
        if (this.j == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, h, 0.0f, 1.0f);
            this.j = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(333L);
            this.j.setInterpolator(this.k);
            this.j.addListener(new CircularIndeterminateAnimatorDelegate2(this));
        }
        h();
        this.i.start();
    }

    @Override // b.i.a.g.g.IndeterminateAnimatorDelegate
    public void g() {
        this.p = null;
    }

    @VisibleForTesting
    public void h() {
        this.m = 0;
        this.c[0] = MaterialColors.compositeARGBWithAlpha(this.l.indicatorColors[0], this.a.getAlpha());
        this.o = 0.0f;
    }
}
