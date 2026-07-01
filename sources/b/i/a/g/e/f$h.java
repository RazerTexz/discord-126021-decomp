package b.i.a.g.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import androidx.annotation.NonNull;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f$h extends AnimatorListenerAdapter implements ValueAnimator$AnimatorUpdateListener {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f1620b;
    public float c;
    public final /* synthetic */ f d;

    public f$h(f fVar, d dVar) {
        this.d = fVar;
    }

    public abstract float a();

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.d.w((int) this.c);
        this.a = false;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        if (!this.a) {
            MaterialShapeDrawable materialShapeDrawable = this.d.i;
            this.f1620b = materialShapeDrawable == null ? 0.0f : materialShapeDrawable.getElevation();
            this.c = a();
            this.a = true;
        }
        f fVar = this.d;
        float f = this.f1620b;
        fVar.w((int) ((valueAnimator.getAnimatedFraction() * (this.c - f)) + f));
    }
}
