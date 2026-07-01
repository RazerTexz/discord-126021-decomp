package com.discord.utilities.anim;

import android.animation.Animator;
import android.animation.Animator$AnimatorListener;
import d0.z.d.m;

/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RingAnimator$$special$$inlined$apply$lambda$1 implements Animator$AnimatorListener {
    public final /* synthetic */ RingAnimator this$0;

    public RingAnimator$$special$$inlined$apply$lambda$1(RingAnimator ringAnimator) {
        this.this$0 = ringAnimator;
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
        RingAnimator.access$setAnimating$p(this.this$0, false);
        this.this$0.onUpdate();
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
    }
}
