package b.p.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.view.ViewGroup$LayoutParams;
import java.util.Objects;

/* JADX INFO: compiled from: SwipeDismissTouchListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ l a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup$LayoutParams f1976b;

    public n(l lVar, ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.a = lVar;
        this.f1976b = viewGroup$LayoutParams;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ViewGroup$LayoutParams viewGroup$LayoutParams = this.f1976b;
        d0.z.d.m.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        viewGroup$LayoutParams.height = ((Integer) animatedValue).intValue();
        this.a.t.setLayoutParams(this.f1976b);
    }
}
