package b.p.a;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import d0.z.d.Intrinsics3;
import java.util.Objects;

/* JADX INFO: renamed from: b.p.a.n, reason: use source file name */
/* JADX INFO: compiled from: SwipeDismissTouchListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SwipeDismissTouchListener3 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ SwipeDismissTouchListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f1976b;

    public SwipeDismissTouchListener3(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams) {
        this.a = swipeDismissTouchListener;
        this.f1976b = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = this.f1976b;
        Intrinsics3.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        this.a.t.setLayoutParams(this.f1976b);
    }
}
