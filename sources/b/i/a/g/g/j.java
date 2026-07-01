package b.i.a.g.g;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import java.util.Arrays;

/* JADX INFO: compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends g<ObjectAnimator> {
    public static final Property<j, Float> d = new j$a(Float.class, "animationFraction");
    public ObjectAnimator e;
    public FastOutSlowInInterpolator f;
    public final BaseProgressIndicatorSpec g;
    public int h;
    public boolean i;
    public float j;

    public j(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.h = 1;
        this.g = linearProgressIndicatorSpec;
        this.f = new FastOutSlowInInterpolator();
    }

    @Override // b.i.a.g.g.g
    public void a() {
        ObjectAnimator objectAnimator = this.e;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // b.i.a.g.g.g
    public void c() {
        h();
    }

    @Override // b.i.a.g.g.g
    public void d(@Nullable Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
    }

    @Override // b.i.a.g.g.g
    public void e() {
    }

    @Override // b.i.a.g.g.g
    public void f() {
        if (this.e == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, d, 0.0f, 1.0f);
            this.e = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(333L);
            this.e.setInterpolator(null);
            this.e.setRepeatCount(-1);
            this.e.addListener(new i(this));
        }
        h();
        this.e.start();
    }

    @Override // b.i.a.g.g.g
    public void g() {
    }

    @VisibleForTesting
    public void h() {
        this.i = true;
        this.h = 1;
        Arrays.fill(this.c, MaterialColors.compositeARGBWithAlpha(this.g.indicatorColors[0], this.a.getAlpha()));
    }
}
