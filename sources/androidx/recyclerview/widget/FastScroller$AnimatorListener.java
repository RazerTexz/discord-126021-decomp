package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public class FastScroller$AnimatorListener extends AnimatorListenerAdapter {
    private boolean mCanceled = false;
    public final /* synthetic */ FastScroller this$0;

    public FastScroller$AnimatorListener(FastScroller fastScroller) {
        this.this$0 = fastScroller;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.mCanceled = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.mCanceled) {
            this.mCanceled = false;
            return;
        }
        if (((Float) this.this$0.mShowHideAnimator.getAnimatedValue()).floatValue() == 0.0f) {
            FastScroller fastScroller = this.this$0;
            fastScroller.mAnimationState = 0;
            fastScroller.setState(0);
        } else {
            FastScroller fastScroller2 = this.this$0;
            fastScroller2.mAnimationState = 2;
            fastScroller2.requestRedraw();
        }
    }
}
