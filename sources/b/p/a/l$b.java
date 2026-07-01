package b.p.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup$LayoutParams;

/* JADX INFO: compiled from: SwipeDismissTouchListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l$b extends AnimatorListenerAdapter {
    public final /* synthetic */ l a;

    public l$b(l lVar, MotionEvent motionEvent, View view) {
        this.a = lVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        d0.z.d.m.checkNotNullParameter(animator, "animation");
        l lVar = this.a;
        ViewGroup$LayoutParams layoutParams = lVar.t.getLayoutParams();
        int height = lVar.t.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(lVar.l);
        duration.addListener(new m(lVar, layoutParams, height));
        duration.addUpdateListener(new n(lVar, layoutParams));
        duration.start();
    }
}
