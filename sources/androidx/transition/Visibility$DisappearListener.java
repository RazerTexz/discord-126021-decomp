package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class Visibility$DisappearListener extends AnimatorListenerAdapter implements Transition$TransitionListener, AnimatorUtils$AnimatorPauseListenerCompat {
    public boolean mCanceled = false;
    private final int mFinalVisibility;
    private boolean mLayoutSuppressed;
    private final ViewGroup mParent;
    private final boolean mSuppressLayout;
    private final View mView;

    public Visibility$DisappearListener(View view, int i, boolean z2) {
        this.mView = view;
        this.mFinalVisibility = i;
        this.mParent = (ViewGroup) view.getParent();
        this.mSuppressLayout = z2;
        suppressLayout(true);
    }

    private void hideViewWhenNotCanceled() {
        if (!this.mCanceled) {
            ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            ViewGroup viewGroup = this.mParent;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        suppressLayout(false);
    }

    private void suppressLayout(boolean z2) {
        ViewGroup viewGroup;
        if (!this.mSuppressLayout || this.mLayoutSuppressed == z2 || (viewGroup = this.mParent) == null) {
            return;
        }
        this.mLayoutSuppressed = z2;
        ViewGroupUtils.suppressLayout(viewGroup, z2);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.mCanceled = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        hideViewWhenNotCanceled();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorPauseListener, androidx.transition.AnimatorUtils$AnimatorPauseListenerCompat
    public void onAnimationPause(Animator animator) {
        if (this.mCanceled) {
            return;
        }
        ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorPauseListener, androidx.transition.AnimatorUtils$AnimatorPauseListenerCompat
    public void onAnimationResume(Animator animator) {
        if (this.mCanceled) {
            return;
        }
        ViewUtils.setTransitionVisibility(this.mView, 0);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // androidx.transition.Transition$TransitionListener
    public void onTransitionCancel(@NonNull Transition transition) {
    }

    @Override // androidx.transition.Transition$TransitionListener
    public void onTransitionEnd(@NonNull Transition transition) {
        hideViewWhenNotCanceled();
        transition.removeListener(this);
    }

    @Override // androidx.transition.Transition$TransitionListener
    public void onTransitionPause(@NonNull Transition transition) {
        suppressLayout(false);
    }

    @Override // androidx.transition.Transition$TransitionListener
    public void onTransitionResume(@NonNull Transition transition) {
        suppressLayout(true);
    }

    @Override // androidx.transition.Transition$TransitionListener
    public void onTransitionStart(@NonNull Transition transition) {
    }
}
