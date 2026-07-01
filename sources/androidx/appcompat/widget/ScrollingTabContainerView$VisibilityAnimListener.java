package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes.dex */
public class ScrollingTabContainerView$VisibilityAnimListener extends AnimatorListenerAdapter {
    private boolean mCanceled = false;
    private int mFinalVisibility;
    public final /* synthetic */ ScrollingTabContainerView this$0;

    public ScrollingTabContainerView$VisibilityAnimListener(ScrollingTabContainerView scrollingTabContainerView) {
        this.this$0 = scrollingTabContainerView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.mCanceled = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.mCanceled) {
            return;
        }
        ScrollingTabContainerView scrollingTabContainerView = this.this$0;
        scrollingTabContainerView.mVisibilityAnim = null;
        scrollingTabContainerView.setVisibility(this.mFinalVisibility);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.this$0.setVisibility(0);
        this.mCanceled = false;
    }

    public ScrollingTabContainerView$VisibilityAnimListener withFinalVisibility(ViewPropertyAnimator viewPropertyAnimator, int i) {
        this.mFinalVisibility = i;
        this.this$0.mVisibilityAnim = viewPropertyAnimator;
        return this;
    }
}
