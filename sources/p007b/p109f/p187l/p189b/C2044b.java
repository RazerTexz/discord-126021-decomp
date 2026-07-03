package p007b.p109f.p187l.p189b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p187l.p188a.C2042b;

/* JADX INFO: renamed from: b.f.l.b.b */
/* JADX INFO: compiled from: AnimatedZoomableController.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2044b extends AbstractC2043a {

    /* JADX INFO: renamed from: s */
    public final ValueAnimator f4295s;

    /* JADX INFO: renamed from: b.f.l.b.b$a */
    /* JADX INFO: compiled from: AnimatedZoomableController.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            C2044b c2044b = C2044b.this;
            Matrix matrix = c2044b.f4294r;
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (int i = 0; i < 9; i++) {
                c2044b.f4292p[i] = (c2044b.f4291o[i] * fFloatValue) + ((1.0f - fFloatValue) * c2044b.f4290n[i]);
            }
            matrix.setValues(c2044b.f4292p);
            C2044b c2044b2 = C2044b.this;
            Matrix matrix2 = c2044b2.f4294r;
            C1691a.m981i(C2045c.class, "setTransform");
            c2044b2.f4306h.set(matrix2);
            c2044b2.m1563i();
        }
    }

    /* JADX INFO: renamed from: b.f.l.b.b$b */
    /* JADX INFO: compiled from: AnimatedZoomableController.java */
    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Runnable f4297a;

        public b(Runnable runnable) {
            this.f4297a = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Objects.requireNonNull(C2044b.this);
            C1691a.m981i(C2044b.class, "setTransformAnimated: animation cancelled");
            Runnable runnable = this.f4297a;
            if (runnable != null) {
                runnable.run();
            }
            C2044b c2044b = C2044b.this;
            c2044b.f4289m = false;
            c2044b.f4299a.m1548d();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Objects.requireNonNull(C2044b.this);
            C1691a.m981i(C2044b.class, "setTransformAnimated: animation finished");
            Runnable runnable = this.f4297a;
            if (runnable != null) {
                runnable.run();
            }
            C2044b c2044b = C2044b.this;
            c2044b.f4289m = false;
            c2044b.f4299a.m1548d();
        }
    }

    @SuppressLint({"NewApi"})
    public C2044b(C2042b c2042b) {
        super(c2042b);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f4295s = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
    }

    @Override // p007b.p109f.p187l.p189b.AbstractC2043a
    /* JADX INFO: renamed from: m */
    public Class<?> mo1553m() {
        return C2044b.class;
    }

    @Override // p007b.p109f.p187l.p189b.AbstractC2043a
    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: n */
    public void mo1554n(Matrix matrix, long j, @Nullable Runnable runnable) {
        int i = C1691a.f3102a;
        mo1555o();
        C1460d.m527i(Boolean.valueOf(j > 0));
        C1460d.m419B(!this.f4289m);
        this.f4289m = true;
        this.f4295s.setDuration(j);
        this.f4306h.getValues(this.f4290n);
        matrix.getValues(this.f4291o);
        this.f4295s.addUpdateListener(new a());
        this.f4295s.addListener(new b(runnable));
        this.f4295s.start();
    }

    @Override // p007b.p109f.p187l.p189b.AbstractC2043a
    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: o */
    public void mo1555o() {
        if (this.f4289m) {
            C1691a.m981i(C2044b.class, "stopAnimation");
            this.f4295s.cancel();
            this.f4295s.removeAllUpdateListeners();
            this.f4295s.removeAllListeners();
        }
    }
}
