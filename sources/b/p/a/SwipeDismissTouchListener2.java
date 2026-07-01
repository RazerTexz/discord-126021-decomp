package b.p.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.p.a.m, reason: use source file name */
/* JADX INFO: compiled from: SwipeDismissTouchListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SwipeDismissTouchListener2 extends AnimatorListenerAdapter {
    public final /* synthetic */ SwipeDismissTouchListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f1975b;
    public final /* synthetic */ int c;

    public SwipeDismissTouchListener2(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams, int i) {
        this.a = swipeDismissTouchListener;
        this.f1975b = layoutParams;
        this.c = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animation");
        SwipeDismissTouchListener swipeDismissTouchListener = this.a;
        swipeDismissTouchListener.u.onDismiss(swipeDismissTouchListener.t);
        this.a.t.setAlpha(1.0f);
        this.a.t.setTranslationX(0.0f);
        ViewGroup.LayoutParams layoutParams = this.f1975b;
        layoutParams.height = this.c;
        this.a.t.setLayoutParams(layoutParams);
    }
}
