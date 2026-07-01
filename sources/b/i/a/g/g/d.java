package b.i.a.g.g;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;

/* JADX INFO: compiled from: CircularIndeterminateAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends g<ObjectAnimator> {
    public static final int[] d = {0, 1350, 2700, 4050};
    public static final int[] e = {667, 2017, 3367, 4717};
    public static final int[] f = {1000, 2350, 3700, 5050};
    public static final Property<d, Float> g = new d$a(Float.class, "animationFraction");
    public static final Property<d, Float> h = new d$b(Float.class, "completeEndFraction");
    public ObjectAnimator i;
    public ObjectAnimator j;
    public final FastOutSlowInInterpolator k;
    public final BaseProgressIndicatorSpec l;
    public int m;
    public float n;
    public float o;
    public Animatable2Compat$AnimationCallback p;

    public d(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.m = 0;
        this.p = null;
        this.l = circularProgressIndicatorSpec;
        this.k = new FastOutSlowInInterpolator();
    }

    @Override // b.i.a.g.g.g
    public void a() {
        ObjectAnimator objectAnimator = this.i;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // b.i.a.g.g.g
    public void c() {
        h();
    }

    @Override // b.i.a.g.g.g
    public void d(@NonNull Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        this.p = animatable2Compat$AnimationCallback;
    }

    @Override // b.i.a.g.g.g
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

    @Override // b.i.a.g.g.g
    public void f() {
        if (this.i == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, g, 0.0f, 1.0f);
            this.i = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(5400L);
            this.i.setInterpolator(null);
            this.i.setRepeatCount(-1);
            this.i.addListener(new b(this));
        }
        if (this.j == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, h, 0.0f, 1.0f);
            this.j = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(333L);
            this.j.setInterpolator(this.k);
            this.j.addListener(new c(this));
        }
        h();
        this.i.start();
    }

    @Override // b.i.a.g.g.g
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
