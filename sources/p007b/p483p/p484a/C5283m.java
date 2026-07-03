package p007b.p483p.p484a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.p.a.m */
/* JADX INFO: compiled from: SwipeDismissTouchListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5283m extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ViewOnTouchListenerC5282l f14382a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ViewGroup.LayoutParams f14383b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f14384c;

    public C5283m(ViewOnTouchListenerC5282l viewOnTouchListenerC5282l, ViewGroup.LayoutParams layoutParams, int i) {
        this.f14382a = viewOnTouchListenerC5282l;
        this.f14383b = layoutParams;
        this.f14384c = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        C12238m.checkNotNullParameter(animator, "animation");
        ViewOnTouchListenerC5282l viewOnTouchListenerC5282l = this.f14382a;
        viewOnTouchListenerC5282l.f14380u.onDismiss(viewOnTouchListenerC5282l.f14379t);
        this.f14382a.f14379t.setAlpha(1.0f);
        this.f14382a.f14379t.setTranslationX(0.0f);
        ViewGroup.LayoutParams layoutParams = this.f14383b;
        layoutParams.height = this.f14384c;
        this.f14382a.f14379t.setLayoutParams(layoutParams);
    }
}
