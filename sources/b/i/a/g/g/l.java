package b.i.a.g.g;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.google.android.material.R$animator;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;

/* JADX INFO: compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends g<ObjectAnimator> {
    public static final int[] d = {533, 567, 850, 750};
    public static final int[] e = {1267, 1000, 333, 0};
    public static final Property<l, Float> f = new l$a(Float.class, "animationFraction");
    public ObjectAnimator g;
    public final Interpolator[] h;
    public final BaseProgressIndicatorSpec i;
    public int j;
    public boolean k;
    public float l;
    public boolean m;
    public Animatable2Compat$AnimationCallback n;

    public l(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.j = 0;
        this.n = null;
        this.i = linearProgressIndicatorSpec;
        this.h = new Interpolator[]{AnimationUtilsCompat.loadInterpolator(context, R$animator.linear_indeterminate_line1_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, R$animator.linear_indeterminate_line1_tail_interpolator), AnimationUtilsCompat.loadInterpolator(context, R$animator.linear_indeterminate_line2_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, R$animator.linear_indeterminate_line2_tail_interpolator)};
    }

    @Override // b.i.a.g.g.g
    public void a() {
        ObjectAnimator objectAnimator = this.g;
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
        this.n = animatable2Compat$AnimationCallback;
    }

    @Override // b.i.a.g.g.g
    public void e() {
        if (this.a.isVisible()) {
            this.m = true;
            this.g.setRepeatCount(0);
        } else {
            ObjectAnimator objectAnimator = this.g;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
        }
    }

    @Override // b.i.a.g.g.g
    public void f() {
        if (this.g == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f, 0.0f, 1.0f);
            this.g = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(1800L);
            this.g.setInterpolator(null);
            this.g.setRepeatCount(-1);
            this.g.addListener(new k(this));
        }
        h();
        this.g.start();
    }

    @Override // b.i.a.g.g.g
    public void g() {
        this.n = null;
    }

    @VisibleForTesting
    public void h() {
        this.j = 0;
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(this.i.indicatorColors[0], this.a.getAlpha());
        int[] iArr = this.c;
        iArr[0] = iCompositeARGBWithAlpha;
        iArr[1] = iCompositeARGBWithAlpha;
    }
}
