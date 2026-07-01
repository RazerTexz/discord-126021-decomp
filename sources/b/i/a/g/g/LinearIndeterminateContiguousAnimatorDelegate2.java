package b.i.a.g.g;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.g.g.j, reason: use source file name */
/* JADX INFO: compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class LinearIndeterminateContiguousAnimatorDelegate2 extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    public static final Property<LinearIndeterminateContiguousAnimatorDelegate2, Float> d = new a(Float.class, "animationFraction");
    public ObjectAnimator e;
    public FastOutSlowInInterpolator f;
    public final BaseProgressIndicatorSpec g;
    public int h;
    public boolean i;
    public float j;

    /* JADX INFO: renamed from: b.i.a.g.g.j$a */
    /* JADX INFO: compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
    public static class a extends Property<LinearIndeterminateContiguousAnimatorDelegate2, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(LinearIndeterminateContiguousAnimatorDelegate2 linearIndeterminateContiguousAnimatorDelegate2) {
            return Float.valueOf(linearIndeterminateContiguousAnimatorDelegate2.j);
        }

        @Override // android.util.Property
        public void set(LinearIndeterminateContiguousAnimatorDelegate2 linearIndeterminateContiguousAnimatorDelegate2, Float f) {
            LinearIndeterminateContiguousAnimatorDelegate2 linearIndeterminateContiguousAnimatorDelegate3 = linearIndeterminateContiguousAnimatorDelegate2;
            float fFloatValue = f.floatValue();
            linearIndeterminateContiguousAnimatorDelegate3.j = fFloatValue;
            linearIndeterminateContiguousAnimatorDelegate3.f1623b[0] = 0.0f;
            float fB = linearIndeterminateContiguousAnimatorDelegate3.b((int) (fFloatValue * 333.0f), 0, 667);
            float[] fArr = linearIndeterminateContiguousAnimatorDelegate3.f1623b;
            float interpolation = linearIndeterminateContiguousAnimatorDelegate3.f.getInterpolation(fB);
            fArr[2] = interpolation;
            fArr[1] = interpolation;
            float[] fArr2 = linearIndeterminateContiguousAnimatorDelegate3.f1623b;
            float interpolation2 = linearIndeterminateContiguousAnimatorDelegate3.f.getInterpolation(fB + 0.49925038f);
            fArr2[4] = interpolation2;
            fArr2[3] = interpolation2;
            float[] fArr3 = linearIndeterminateContiguousAnimatorDelegate3.f1623b;
            fArr3[5] = 1.0f;
            if (linearIndeterminateContiguousAnimatorDelegate3.i && fArr3[3] < 1.0f) {
                int[] iArr = linearIndeterminateContiguousAnimatorDelegate3.c;
                iArr[2] = iArr[1];
                iArr[1] = iArr[0];
                iArr[0] = MaterialColors.compositeARGBWithAlpha(linearIndeterminateContiguousAnimatorDelegate3.g.indicatorColors[linearIndeterminateContiguousAnimatorDelegate3.h], linearIndeterminateContiguousAnimatorDelegate3.a.getAlpha());
                linearIndeterminateContiguousAnimatorDelegate3.i = false;
            }
            linearIndeterminateContiguousAnimatorDelegate3.a.invalidateSelf();
        }
    }

    public LinearIndeterminateContiguousAnimatorDelegate2(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.h = 1;
        this.g = linearProgressIndicatorSpec;
        this.f = new FastOutSlowInInterpolator();
    }

    @Override // b.i.a.g.g.IndeterminateAnimatorDelegate
    public void a() {
        ObjectAnimator objectAnimator = this.e;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // b.i.a.g.g.IndeterminateAnimatorDelegate
    public void c() {
        h();
    }

    @Override // b.i.a.g.g.IndeterminateAnimatorDelegate
    public void d(@Nullable Animatable2Compat.AnimationCallback animationCallback) {
    }

    @Override // b.i.a.g.g.IndeterminateAnimatorDelegate
    public void e() {
    }

    @Override // b.i.a.g.g.IndeterminateAnimatorDelegate
    public void f() {
        if (this.e == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, d, 0.0f, 1.0f);
            this.e = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(333L);
            this.e.setInterpolator(null);
            this.e.setRepeatCount(-1);
            this.e.addListener(new LinearIndeterminateContiguousAnimatorDelegate(this));
        }
        h();
        this.e.start();
    }

    @Override // b.i.a.g.g.IndeterminateAnimatorDelegate
    public void g() {
    }

    @VisibleForTesting
    public void h() {
        this.i = true;
        this.h = 1;
        Arrays.fill(this.c, MaterialColors.compositeARGBWithAlpha(this.g.indicatorColors[0], this.a.getAlpha()));
    }
}
