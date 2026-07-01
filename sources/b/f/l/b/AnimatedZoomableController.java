package b.f.l.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.e.FLog;
import b.f.l.a.TransformGestureDetector;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.l.b.b, reason: use source file name */
/* JADX INFO: compiled from: AnimatedZoomableController.java */
/* JADX INFO: loaded from: classes3.dex */
public class AnimatedZoomableController extends AbstractAnimatedZoomableController {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ValueAnimator f649s;

    /* JADX INFO: renamed from: b.f.l.b.b$a */
    /* JADX INFO: compiled from: AnimatedZoomableController.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimatedZoomableController animatedZoomableController = AnimatedZoomableController.this;
            Matrix matrix = animatedZoomableController.r;
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (int i = 0; i < 9; i++) {
                animatedZoomableController.p[i] = (animatedZoomableController.o[i] * fFloatValue) + ((1.0f - fFloatValue) * animatedZoomableController.n[i]);
            }
            matrix.setValues(animatedZoomableController.p);
            AnimatedZoomableController animatedZoomableController2 = AnimatedZoomableController.this;
            Matrix matrix2 = animatedZoomableController2.r;
            FLog.i(DefaultZoomableController.class, "setTransform");
            animatedZoomableController2.h.set(matrix2);
            animatedZoomableController2.i();
        }
    }

    /* JADX INFO: renamed from: b.f.l.b.b$b */
    /* JADX INFO: compiled from: AnimatedZoomableController.java */
    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ Runnable a;

        public b(Runnable runnable) {
            this.a = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Objects.requireNonNull(AnimatedZoomableController.this);
            FLog.i(AnimatedZoomableController.class, "setTransformAnimated: animation cancelled");
            Runnable runnable = this.a;
            if (runnable != null) {
                runnable.run();
            }
            AnimatedZoomableController animatedZoomableController = AnimatedZoomableController.this;
            animatedZoomableController.m = false;
            animatedZoomableController.a.d();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Objects.requireNonNull(AnimatedZoomableController.this);
            FLog.i(AnimatedZoomableController.class, "setTransformAnimated: animation finished");
            Runnable runnable = this.a;
            if (runnable != null) {
                runnable.run();
            }
            AnimatedZoomableController animatedZoomableController = AnimatedZoomableController.this;
            animatedZoomableController.m = false;
            animatedZoomableController.a.d();
        }
    }

    @SuppressLint({"NewApi"})
    public AnimatedZoomableController(TransformGestureDetector transformGestureDetector) {
        super(transformGestureDetector);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f649s = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
    }

    @Override // b.f.l.b.AbstractAnimatedZoomableController
    public Class<?> m() {
        return AnimatedZoomableController.class;
    }

    @Override // b.f.l.b.AbstractAnimatedZoomableController
    @SuppressLint({"NewApi"})
    public void n(Matrix matrix, long j, @Nullable Runnable runnable) {
        int i = FLog.a;
        o();
        AnimatableValueParser.i(Boolean.valueOf(j > 0));
        AnimatableValueParser.B(!this.m);
        this.m = true;
        this.f649s.setDuration(j);
        this.h.getValues(this.n);
        matrix.getValues(this.o);
        this.f649s.addUpdateListener(new a());
        this.f649s.addListener(new b(runnable));
        this.f649s.start();
    }

    @Override // b.f.l.b.AbstractAnimatedZoomableController
    @SuppressLint({"NewApi"})
    public void o() {
        if (this.m) {
            FLog.i(AnimatedZoomableController.class, "stopAnimation");
            this.f649s.cancel();
            this.f649s.removeAllUpdateListeners();
            this.f649s.removeAllListeners();
        }
    }
}
