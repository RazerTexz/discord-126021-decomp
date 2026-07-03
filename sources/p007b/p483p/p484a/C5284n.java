package p007b.p483p.p484a;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.p.a.n */
/* JADX INFO: compiled from: SwipeDismissTouchListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5284n implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ViewOnTouchListenerC5282l f14385a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ViewGroup.LayoutParams f14386b;

    public C5284n(ViewOnTouchListenerC5282l viewOnTouchListenerC5282l, ViewGroup.LayoutParams layoutParams) {
        this.f14385a = viewOnTouchListenerC5282l;
        this.f14386b = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = this.f14386b;
        C12238m.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        this.f14385a.f14379t.setLayoutParams(this.f14386b);
    }
}
